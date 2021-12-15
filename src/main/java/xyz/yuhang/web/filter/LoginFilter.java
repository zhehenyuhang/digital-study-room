package xyz.yuhang.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


// @WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String[] urls = {"web/css","web/image","web/js"
                ,"web/layui","/loginTeacherServlet"
                ,"web/jsp/HomePage/login_student.jsp"
                ,"web/jsp/HomePage/index.jsp"};

        String s = req.getRequestURL().toString();

        for (String url : urls) {
            if(s.contains(url)){
                chain.doFilter(request,response);
                return;
            }
        }

        //判断session中是否有tuser
        HttpSession session = req.getSession();
        Object teacherName = session.getAttribute("teacherName");

        if (teacherName != null && teacherName != ""){
            //已经登录了
            chain.doFilter(request,response);
        }else {
            //未登录
            req.setAttribute("login_msg","你尚未登录");
            req.getRequestDispatcher("/web/jsp/HomePage/index.jsp").forward(req,response);
        }


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }



    @Override
    public void destroy() {

    }
}
