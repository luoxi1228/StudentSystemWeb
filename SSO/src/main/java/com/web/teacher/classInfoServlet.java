package com.web.teacher;

import com.pojo.*;
import com.service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/classInfoServlet")
public class classInfoServlet extends HttpServlet {
    private ClassroomService serviceClass=new ClassroomService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取登录信息
        HttpSession session = req.getSession();
        teacher tea=(teacher) session.getAttribute("tea");
        List<classroom> Teaclassrooms=serviceClass.selectByTea(tea.getT_id());

        session.setAttribute("Teaclassrooms", Teaclassrooms);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/teacher/classInfo.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
