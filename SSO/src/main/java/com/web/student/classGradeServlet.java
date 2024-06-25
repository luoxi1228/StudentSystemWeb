package com.web.student;


import com.pojo.viewGrade.classGrade;
import com.service.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/classGradeServlet")
public class classGradeServlet extends HttpServlet {
    private GradeService service=new GradeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String c_id = req.getParameter("c_id");
       List<classGrade> classGrades=service.classGrades(c_id);

       //获得该班级的统一信息
       String classId=classGrades.get(1).getC_id();
       String classRoom=classGrades.get(1).getC_room();
       String classCourse=classGrades.get(1).getCo_name();
       String classTeacher=classGrades.get(1).getT_name();
       String classTime=classGrades.get(1).getC_time();


//        for (int i = 0; i < classGrades.size(); i++) {
//            System.out.println(classGrades);
//        }
        //存放到session
        HttpSession session = req.getSession();
        session.setAttribute("classGrades",classGrades);
        session.setAttribute("classId",classId);
        session.setAttribute("classRoom",classRoom);
        session.setAttribute("classCourse",classCourse);
        session.setAttribute("classTeacher",classTeacher);
        session.setAttribute("classTime",classTime);

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/student/classGrade.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
