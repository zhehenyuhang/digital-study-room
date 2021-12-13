package xyz.yuhang.web.student;

import xyz.yuhang.StudentStudyJdbc;
import xyz.yuhang.StudyroomLogJdbc;
import xyz.yuhang.pojo.AccountStudent;
import xyz.yuhang.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginStudentServlet")
public class LoginStudentServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String studentNumber = request.getParameter("studentNumber");
        String studentPassword = request.getParameter("studentPassword");

        AccountStudent login = studentService.login(studentNumber, studentPassword);

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //获取字符输出流，并设置content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();

        if (login != null){
            new StudyroomLogJdbc().play();
            new StudentStudyJdbc().play();
            session.setAttribute("studentId",login.getStudentId());
            response.sendRedirect(contextPath+"/web/jsp/StudentPage/Studentindex.jsp");
        }else {
            writer.write("登陆失败");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
