package com.web;

import com.pojo.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受用户数据并修改
        HttpSession session = req.getSession();
        if(session.getAttribute("stu")!=null){
            session.removeAttribute("stu");
        }else if (session.getAttribute("tea")!=null) {
            session.removeAttribute("tea");
        }else if(session.getAttribute("admin")!=null){
            session.removeAttribute("admin");
        }
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
