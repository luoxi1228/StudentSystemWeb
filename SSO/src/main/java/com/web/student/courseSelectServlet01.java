package com.web.student;

import com.pojo.classroom;
import com.pojo.selectCourse.classTeacher;
import com.pojo.teacher;
import com.service.ClassroomService;
import com.service.TeaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/student/courseSelectServlet01")
public class courseSelectServlet01 extends HttpServlet {
    private ClassroomService serviceClass=new ClassroomService();
    private TeaService serviceTea=new TeaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String co_id=req.getParameter("courseId");
        String courseName=req.getParameter("courseName");
        //System.out.println(courseName);
        List<classroom> classroomList=serviceClass.selectByCourse(co_id);
        ArrayList<classTeacher> classInfo=new ArrayList<>();

        for (int i = 0; i < classroomList.size(); i++) {
            classroom c1=classroomList.get(i);
            teacher t1=serviceTea.selectById(c1.getT_id());
            classTeacher c2=new classTeacher(
                    c1.getC_id(), c1.getT_id(),c1.getCo_id() ,c1.getC_room(),c1.getS_num(),c1.getC_time(),
                    t1.getT_name(),t1.getT_gender(),t1.getT_age(),t1.getT_faculty()
            );
            classInfo.add(c2);
            //System.out.println(c2);
        }

        HttpSession session = req.getSession();
        session.setAttribute("classInfo",classInfo);
        session.setAttribute("courseName",courseName);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/student/courseSelect01.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
