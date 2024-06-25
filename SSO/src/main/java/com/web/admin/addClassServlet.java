package com.web.admin;

import com.pojo.classroom;
import com.pojo.course;
import com.pojo.teacher;
import com.service.ClassroomService;
import com.service.CourseService;
import com.service.TeaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/addClassServlet")
public class addClassServlet extends HttpServlet {
    private CourseService courseService = new CourseService();
    private ClassroomService classroomService = new ClassroomService();
    private TeaService teaService = new TeaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        List<teacher> allTeacher = teaService.selectAll();
        List<course> allCourse = courseService.selectAll();
        List<classroom> allClass = classroomService.selectAll();

        req.setAttribute("allClass", allClass);
        req.setAttribute("allTeacher", allTeacher);
        req.setAttribute("allCourse", allCourse);
        req.getRequestDispatcher("/admin/addClass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String classId = request.getParameter("classId");
        String teacherId = request.getParameter("teacherId");
        String courseId = request.getParameter("courseId");
        String classRoom = request.getParameter("classRoom");
        String term = request.getParameter("term");
        int s_num=0;

        if (classroomService.findClass(classId)!=null) {
            List<teacher> allTeacher = teaService.selectAll();
            List<course> allCourse = courseService.selectAll();
            List<classroom> allClass = classroomService.selectAll();

            request.setAttribute("errorMessage", "班级编号已存在，请选择其他编号。");
            request.setAttribute("allClass", allClass);
            request.setAttribute("allTeacher", allTeacher);
            request.setAttribute("allCourse", allCourse);

            // Preserve form data
            request.setAttribute("classId", classId);
            request.setAttribute("teacherId", teacherId);
            request.setAttribute("courseId", courseId);
            request.setAttribute("classRoom", classRoom);
            request.setAttribute("term", term);

            request.getRequestDispatcher("/admin/addClass.jsp").forward(request, response);
        } else {
            classroom newClassroom = new classroom();
            newClassroom.setC_id(classId);
            newClassroom.setT_id(teacherId);
            newClassroom.setCo_id(courseId);
            newClassroom.setC_room(classRoom);
            newClassroom.setS_num(0);
            newClassroom.setC_time(term);

            classroomService.addClassroom(newClassroom);

            response.sendRedirect("/SSO/admin/classManageServlet");
        }
    }
}
