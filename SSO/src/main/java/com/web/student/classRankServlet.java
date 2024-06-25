package com.web.student;

import com.pojo.Rank.subjectClassRank;
import com.pojo.classroom;
import com.pojo.grade;
import com.pojo.student;
import com.pojo.teacher;
import com.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student/classRankServlet")
public class classRankServlet extends HttpServlet {
    private StuService serviceStu = new StuService();
    private CourseService serviceCourse = new CourseService();
    private GradeService serviceGrade = new GradeService();
    private ClassroomService serviceClass = new ClassroomService();
    private TeaService serviceTea=new TeaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传递过来的班级id
        String c_id = req.getParameter("c_id");
        classroom myClass=serviceClass.findClass(c_id);
        //得到老师id和课程id,
        String t_id=myClass.getT_id();
        String co_id=myClass.getCo_id();
        //获取课程名和老师
        String co_name1 = serviceCourse.findName(co_id);
        teacher myTeacher=serviceTea.selectById(t_id);

        System.out.println(co_name1);

        HttpSession session = req.getSession();
        ArrayList<subjectClassRank> classRanks = new ArrayList<>();
        List<grade> grades = serviceGrade.findStu(c_id);

        for (int j = 0; j < grades.size(); j++) {
            // System.out.println(grades.get(j));
            String s_id = grades.get(j).getS_id();
            String s_name = serviceStu.selectById(s_id).getS_name();
            int finalGrade = grades.get(j).getFinalGrade();
            subjectClassRank subRank = new subjectClassRank(s_id, s_name, finalGrade, 0);
            classRanks.add(subRank);
            //System.out.println(subRank);

        }
        // 对subRanks集合按照finalGrade属性进行降序排序
        classRanks.sort((r1, r2) -> Integer.compare(r2.getFinalGrade(), r1.getFinalGrade()));

        // 赋值排名给subject_rank属性
        student stu = (student) session.getAttribute("stu");
        String name = stu.getS_name();
        int myClassRank = 0;
        for (int i = 0; i < classRanks.size(); i++) {
            classRanks.get(i).setRank(i + 1);
            if (classRanks.get(i).getS_name().equals(name))
                myClassRank = i + 1;
        }


        session.setAttribute("classRanks", classRanks);
        session.setAttribute("myClassRank", myClassRank);
        session.setAttribute("courseName1", co_name1);
        session.setAttribute("myClass", myClass);
        session.setAttribute("myTeacher",myTeacher);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/student/classRank.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
