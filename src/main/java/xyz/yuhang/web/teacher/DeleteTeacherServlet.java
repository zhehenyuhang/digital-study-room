package xyz.yuhang.web.teacher;

import xyz.yuhang.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {
    TeacherService teacherService = new TeacherService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取id
        String id = request.getParameter("id");
        String teacherId = request.getParameter("teacherId");
        teacherId = new String(teacherId.getBytes("ISO-8859-1"),"utf-8");

        teacherService.deleteAccount(teacherId);
        teacherService.delete(Integer.parseInt(id));

        request.getRequestDispatcher("/selectAllTeacherServlet").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
