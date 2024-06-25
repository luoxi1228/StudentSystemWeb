package com.web.admin;

import com.pojo.classroom;
import com.pojo.course;
import com.service.ClassroomService;
import com.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/courseManageServlet")
public class courseManageServlet extends HttpServlet{
        private CourseService courseService=new CourseService();
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            List<course>courses=courseService.selectAll();
            HttpSession session = req.getSession();
            session.setAttribute("manageCourse",courses);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/admin/courseManageHome.jsp");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req,resp);
        }
}
