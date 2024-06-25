package com.web.admin;

import com.pojo.course;
import com.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/addCourseServlet")
public class addCourseServlet extends HttpServlet {
    private CourseService courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/admin/addCourse.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String co_id = req.getParameter("co_id");
        String co_name = req.getParameter("co_name");

        course IDcourse=courseService.selectById(co_id);
        course Namecourse=courseService.selectByName(co_name);

         course course1=new course(co_id,co_name);

        if (IDcourse!=null || Namecourse!=null) {
            StringBuilder errorMessage = new StringBuilder("错误：");
            if (IDcourse!=null) {
                errorMessage.append("课程编号已存在。");
            }
            if (Namecourse!=null) {
                errorMessage.append("课程名称已存在。");
            }
            req.setAttribute("errorMessage", errorMessage.toString());
            req.setAttribute("co_id", co_id);
            req.setAttribute("co_name", co_name);
            req.getRequestDispatcher("/admin/addCourse.jsp").forward(req, resp);
        } else {
            courseService.addCourse(course1);
            resp.sendRedirect("/SSO/admin/courseManageServlet");
        }
    }
}
