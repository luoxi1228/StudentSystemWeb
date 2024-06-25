package com.web.teacher;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.grade;
import com.pojo.student;
import com.service.GradeService;
import com.service.StuService;
import com.util.DataGenerate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/updateGradesServlet")
public class updateGradesServlet extends HttpServlet {
    private GradeService gradeService = new GradeService();
    private StuService stuService=new StuService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // 获取请求体中的JSON数据
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            jsonBuffer.append(line);
        }
        String gradesData = jsonBuffer.toString();

        // 使用Jackson库将JSON数据解析为List<Grade>
        ObjectMapper mapper = new ObjectMapper();
        List<grade> grades = mapper.readValue(gradesData, new TypeReference<List<grade>>() {});

        String c_id= (String) session.getAttribute("class_id");
        // 更新数据库中的成绩
        for (grade gd : grades) {
            gd.setC_id(c_id);
            gradeService.updateGrade(gd);
            //System.out.println(gd);
        }
        //更新每个人的总成绩
        List<grade>allGrades= gradeService.selectAll();
        List<student>allStudent=stuService.selectAll();
        for (student stu:allStudent) {
            int s_grade = 0;
            for (grade gd : allGrades) {
                if (gd.getS_id().equals(stu.getS_id())) {
                    s_grade += gd.getFinalGrade();
                }
            }
            stuService.updateAllGrade(stu.getS_id(),s_grade);
        }


        // 重定向回到原来的页面或其他适当的页面
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/teacher/changeGradeServlet?c_id="+c_id);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
