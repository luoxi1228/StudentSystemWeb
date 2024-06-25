package com.web;

import com.pojo.admin;
import com.service.AdminService;
import com.service.StuService;
import com.service.TeaService;
import com.pojo.student;
import com.pojo.teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private StuService stuService = new StuService();
    private TeaService teaService = new TeaService();
    private AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String accountType = request.getParameter("accountType");

        HttpSession session = request.getSession();

        System.out.println(username+password);
        if (username == null || password == null || accountType == null) {
            request.setAttribute("login_msg", "登录信息不完整！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }


        if (accountType.equals("student")) {
            student stu= stuService.login(username,password);
            if(stu!=null) {
                session.setAttribute("stu", stu);
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath + "/student/studentHome.jsp");
            }else{
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } else if (accountType.equals("teacher")) {
            teacher tea = teaService.login(username,password);
            if(tea!=null) {
                session.setAttribute("tea", tea);
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath + "/teacher/teacherHome.jsp");
            }else{
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } else if (accountType.equals("admin")) {
             admin adm=adminService.login(username,password);
            if(adm!=null) {
                session.setAttribute("admin", adm);
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath + "/admin/adminHome.jsp");
            }else{
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        }else {
            request.setAttribute("login_msg", "不存在该类型用户！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
