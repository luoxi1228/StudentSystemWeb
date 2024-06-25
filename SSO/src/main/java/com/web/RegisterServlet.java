package com.web;

import com.pojo.student;
import com.pojo.teacher;
import com.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private StuService stuService = new StuService();
    private TeaService teaService = new TeaService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String role = request.getParameter("role");
        String id = request.getParameter("account");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String faculty = request.getParameter("faculty");
        String password = request.getParameter("password");

        student student = stuService.selectById(id);
        teacher teacher = teaService.selectById(id);

        if (id == null || name == null || gender == null || age == null || faculty == null || password == null) {
            request.setAttribute("register_msg", "注册信息不完整！");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        // 验证账号格式
        if (!id.matches("^S_2021\\d{4}$") && !id.matches("^T_2021\\d{4}$")) {
            request.setAttribute("register_msg", "账号格式必须为 S_2021xxxx 或 T_2021xxxx");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        if (role.equals("student") && student == null) {
            student stu = new student(id, name, gender, age, faculty, password, 0);
            stuService.addStu(stu);
            request.setAttribute("register_msg", "注册成功！！");
        } else if (role.equals("teacher") && teacher == null) {
            teacher tea = new teacher(id, name, gender, age, faculty, password);
            teaService.addTea(tea);
            request.setAttribute("register_msg", "注册成功！！");
        } else {
            request.setAttribute("register_msg", "该用户已存在，注册失败");
        }

        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
