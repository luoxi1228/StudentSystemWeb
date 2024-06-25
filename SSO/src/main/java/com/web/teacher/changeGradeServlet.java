package com.web.teacher;

import com.pojo.changeGrade.studentGrade;
import com.pojo.grade;
import com.pojo.student;
import com.service.GradeService;
import com.service.StuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/teacher/changeGradeServlet")
public class changeGradeServlet extends HttpServlet {
    private GradeService serviceGrade=new GradeService();
    private StuService serviceStu=new StuService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String c_id = req.getParameter("c_id");
        List<grade>grades=serviceGrade.findStu(c_id);
        /*for (int i = 0; i<grades.size(); i++) {
            System.out.println(grades.get(i));
        }*/
        ArrayList<studentGrade> TeaGrades=new ArrayList<>();
        for (int i = 0; i < grades.size(); i++) {
            grade gd=grades.get(i);
            student st=serviceStu.selectById(gd.getS_id());
            studentGrade sg=new studentGrade(
                    st.getS_id(),st.getS_name(),st.getS_gender(),st.getS_age(),st.getS_faculty(),st.getS_grade(),
                    gd.getC_id(),gd.getMidGrade(),gd.getLabGrade(),gd.getExamGrade(),gd.getUsualGrade(),gd.getFinalGrade()
            );

            TeaGrades.add(sg);
        }

        HttpSession session = req.getSession();
        session.setAttribute("TeaGrades", TeaGrades);
        session.setAttribute("class_id",c_id);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/teacher/changeGrade.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
