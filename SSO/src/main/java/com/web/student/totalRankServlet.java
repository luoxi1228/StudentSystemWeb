package com.web.student;

import com.pojo.Rank.totalRank;
import com.pojo.User;
import com.pojo.student;
import com.service.StuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/student/totalRankServlet")
public class totalRankServlet extends HttpServlet {
    private StuService service = new StuService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //当前登录用户的id
        student stu = (student) session.getAttribute("stu");
        String your_id=stu.getS_id();
        int yourRank=service.findRank(your_id).getTotal_rank();

        List<student>students=service.selectAll();
        ArrayList<totalRank>totalRanks=new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            String id=students.get(i).getS_id();
            totalRank rank=service.findRank(id);
            totalRanks.add(rank);
            //System.out.println(rank);
        }
        // 创建自定义比较器
        Comparator<totalRank> comparator = (o1, o2) -> {
            return Integer.compare(o1.getTotal_rank(), o2.getTotal_rank());
        };
       // 对 totalRanks 集合进行排序
        Collections.sort(totalRanks, comparator);

        session.setAttribute("totalRanks",totalRanks);
        session.setAttribute("yourRank",yourRank);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/student/totalRank.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
