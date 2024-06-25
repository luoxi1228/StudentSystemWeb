package com.web.admin;

import com.pojo.classroom;
import com.service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/classManageServlet")
public class classManageServlet extends HttpServlet {
    private ClassroomService classroomService=new ClassroomService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<classroom>classrooms=classroomService.selectAll();
        HttpSession session = req.getSession();
        session.setAttribute("manageClass",classrooms);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/admin/classManageHome.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
