package xyz.yuhang.web.teacher;

import xyz.yuhang.pojo.AccountTeacher;
import xyz.yuhang.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updataAccountTeacherServlet")
public class UpdataAccountTeacherServlet extends HttpServlet {
    TeacherService teacherService = new TeacherService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //乱码
        request.setCharacterEncoding("utf-8");

        String teacherId = request.getParameter("teacherId");
        String teacherNumber = request.getParameter("teacherNumber");
        String teacherPassword = request.getParameter("teacherPassword");

        AccountTeacher accountTeacher = new AccountTeacher();

        accountTeacher.setTeacherId(teacherId);
        accountTeacher.setTeacherNumber(teacherNumber);
        accountTeacher.setTeacherPassword(teacherPassword);

        teacherService.updataAccount(accountTeacher);

        request.getRequestDispatcher("/selectAllTeacherServlet").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
