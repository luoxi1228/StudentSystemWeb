package com.web.student;

import com.service.ClassroomService;
import com.service.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/selectSuccessfulServlet")
public class selectSuccessfulServlet extends HttpServlet {
    private GradeService serviceGrade=new GradeService();
    private ClassroomService serviceclass=new ClassroomService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String classId = req.getParameter("classId");
        String studentId = req.getParameter("studentId");

       /* System.out.println("classId: " + classId);
        System.out.println("studentId: " + studentId);
*/
        // Here, you can add your logic to handle the selection process
         //在grade表添加一条信息
        serviceGrade.addGrade(studentId,classId);
        //相应班级的人数加1
        int num=serviceclass.findClass(classId).getS_num();
        serviceclass.updateNum(num+1,classId);

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/student/courseSelectServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
