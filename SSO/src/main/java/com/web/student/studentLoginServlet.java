package com.web.student;

import com.pojo.student;
import com.service.StuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/student/studentLoginServlet")
public class studentLoginServlet  extends HttpServlet {
    private StuService service = new StuService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收用户名和密码
        String s_id = request.getParameter("username");
        String s_password = request.getParameter("password");
        //2. 调用service查询
        student stu= service.login(s_id,s_password);
        //System.out.println(stu);

        //3. 判断user释放为null
        if(stu != null){
            // 登陆成功
            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("stu",stu);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/student/studentHome.jsp");
        }else {
            // 登陆失败
            // 存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误！");

            // 跳转到login.jsp
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/login.jsp");
           // request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}