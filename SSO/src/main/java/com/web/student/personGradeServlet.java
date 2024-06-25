package com.web.student;

import com.pojo.User;
import com.pojo.student;
import com.pojo.viewGrade.courseGrade;
import com.service.GradeService;
import com.service.StuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/personGradeServlet")
public class personGradeServlet extends HttpServlet {
    private GradeService service=new GradeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        student stu = (student) session.getAttribute("stu");
        String s_id=stu.getS_id();
        List<courseGrade> personGrade=service.personGrade(s_id);
        //System.out.println(s_id);
        //查看成绩
/*        for (int i = 0; i < personGrade.size(); i++) {
            System.out.println(personGrade.get(i));
        }*/


        session.setAttribute("personGrade",personGrade);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/student/personGrade.jsp");


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         this.doGet(req,resp);
    }
}
