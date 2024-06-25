package com.web.student;

import com.pojo.classroom;
import com.pojo.course;
import com.pojo.student;
import com.pojo.viewGrade.courseGrade;
import com.service.ClassroomService;
import com.service.CourseService;
import com.service.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student/courseSelectServlet")
public class courseSelectServlet extends HttpServlet {
    private GradeService serviceGrade=new GradeService();
    private ClassroomService serviceClass=new ClassroomService();
    private CourseService serviceCourse=new CourseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        student stu = (student) session.getAttribute("stu");
        String s_id=stu.getS_id();

        //拿到以选的课程
        List<courseGrade> hasSelectCourse=serviceGrade.personGrade(s_id);

        //拿到未选的课程信息
        List<course>allCourse=serviceCourse.selectAll();

        ArrayList<course> notSelectCourse=new ArrayList<>();
        for (int i = 0; i < allCourse.size(); i++) {
            course c1=allCourse.get(i);
            boolean flag=false;
            for (int j = 0; j < hasSelectCourse.size(); j++) {
                courseGrade c2=hasSelectCourse.get(j);
                if(c1.getCo_id().equals(c2.getCo_id())){
                    break;
                }else if(j==hasSelectCourse.size()-1) {
                    flag = true;
                }
            }
            if(flag){
                notSelectCourse.add(c1);
                System.out.println(c1);
            }
        }

        session.setAttribute("hasSelectCourse",hasSelectCourse);
        session.setAttribute("notSelectCourse",notSelectCourse);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/student/courseSelect.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
