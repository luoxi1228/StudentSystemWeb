package com.fliter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //1. 判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("stu");
        //2. 判断user是否为null
        if (user != null) {
            // 登录过了
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 没有登陆，存储提示信息，跳转到登录页面
            req.setAttribute("login_msg", "您尚未登陆！");
            req.getRequestDispatcher("/login.jsp").forward(req, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
