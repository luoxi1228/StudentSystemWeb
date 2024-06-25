package com.web.teacher;

import com.mapper.TeaMapper;
import com.pojo.student;
import com.pojo.teacher;
import com.service.StuService;
import com.service.TeaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/teacher/teacherLoginServlet")
public class teacherLoginServlet extends HttpServlet {
    private TeaService service = new TeaService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收用户名和密码
        String t_id = request.getParameter("username");
        String t_password = request.getParameter("password");
        //2. 调用service查询
        teacher tea = service.login(t_id,t_password);
        //System.out.println(tea);

        //3. 判断user释放为null
        if(tea != null){
            // 登陆成功
            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("tea",tea);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/teacher/teacherHome.jsp");
        }else {
            // 登陆失败
            // 存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误！");

            // 跳转到login.jsp
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
