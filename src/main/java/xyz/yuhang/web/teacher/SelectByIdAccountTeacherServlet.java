package xyz.yuhang.web.teacher;

import xyz.yuhang.pojo.AccountTeacher;
import xyz.yuhang.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdAccountTeacherServlet")
public class SelectByIdAccountTeacherServlet extends HttpServlet {
    TeacherService teacherService = new TeacherService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String teacherId = request.getParameter("teacherId");
        teacherId = new String(teacherId.getBytes("ISO-8859-1"),"UTF-8");

        AccountTeacher accountTeacher = teacherService.selectByIdAccount(teacherId);


        request.setAttribute("accountTeacher",accountTeacher);

        request.getRequestDispatcher("/web/jsp/UserManagement/updataAccountTeacher.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
