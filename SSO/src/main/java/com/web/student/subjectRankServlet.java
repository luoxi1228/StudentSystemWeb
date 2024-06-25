package com.web.student;

import com.mapper.StuMapper;
import com.pojo.Rank.subjectClassRank;
import com.pojo.grade;
import com.pojo.student;
import com.service.ClassroomService;
import com.service.CourseService;
import com.service.GradeService;
import com.service.StuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student/subjectRankServlet")
public class subjectRankServlet extends HttpServlet {
    private StuService serviceStu = new StuService();
    private CourseService serviceCourse = new CourseService();
    private GradeService serviceGrade=new GradeService();
    private ClassroomService serviceClass=new ClassroomService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        //得到需要查看排名的学科id
        String co_id = req.getParameter("co_id");
        String co_name = serviceCourse.findName(co_id);
        List<String> classId = serviceClass.findClassId(co_id);
        ArrayList<subjectClassRank> subRanks = new ArrayList<>();
        //System.out.println("=================================================");
        for (int i = 0; i < classId.size(); i++) {
            //System.out.println(classId.get(i));
            List<grade> grades = serviceGrade.findStu(classId.get(i));
            for (int j = 0; j < grades.size(); j++) {
               // System.out.println(grades.get(j));
                String s_id = grades.get(j).getS_id();
                String s_name = serviceStu.selectById(s_id).getS_name();
                int finalGrade = grades.get(j).getFinalGrade();
                subjectClassRank subRank = new subjectClassRank(s_id, s_name, finalGrade, 0);
                subRanks.add(subRank);
                //System.out.println(subRank);
            }
        }
        // 对subRanks集合按照finalGrade属性进行降序排序
        subRanks.sort((r1, r2) -> Integer.compare(r2.getFinalGrade(), r1.getFinalGrade()));

        // 赋值排名给subject_rank属性
        student stu = (student) session.getAttribute("stu");
        String name=stu.getS_name();
        int mySubRank=0;
        for (int i = 0; i < subRanks.size(); i++) {
            subRanks.get(i).setRank(i + 1);
            if(subRanks.get(i).getS_name().equals(name))
                mySubRank=i+1;
        }


        session.setAttribute("subRanks", subRanks);
        session.setAttribute("mySubRank",mySubRank);
        session.setAttribute("courseName",co_name);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/student/subjectRank.jsp");

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
