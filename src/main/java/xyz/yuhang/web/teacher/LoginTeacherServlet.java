package xyz.yuhang.web.teacher;

import org.apache.ibatis.session.SqlSession;
import xyz.yuhang.StudentStudyJdbc;
import xyz.yuhang.StudyroomLogJdbc;
import xyz.yuhang.mapper.TeacherMapper;
import xyz.yuhang.pojo.AccountStudent;
import xyz.yuhang.pojo.AccountTeacher;
import xyz.yuhang.pojo.Teacher;
import xyz.yuhang.service.StudentService;
import xyz.yuhang.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginTeacherServlet")
public class LoginTeacherServlet extends HttpServlet {

    TeacherService teacherService = new TeacherService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        
        String teacherNumber = request.getParameter("teacherNumber");
        String teacherPassword = request.getParameter("teacherPassword");


        AccountTeacher accountTeacher = teacherService.login(teacherNumber, teacherPassword);


        //获取字符输出流，并设置content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if (accountTeacher != null){
            new StudyroomLogJdbc().play();
            new StudentStudyJdbc().play();
            String teacherName = teacherService.teacherName(accountTeacher.getTeacherId());
            HttpSession session = request.getSession();
            session.setAttribute("teacherName",teacherName);
            //动态获取虚拟目录
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/web/jsp/HomePage/zhuye.jsp");
        }else {
            request.setAttribute("login_msg","账号或密码错误");
            // writer.write("登陆失败");
            request.getRequestDispatcher("/web/jsp/HomePage/index.jsp").forward(request,response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
