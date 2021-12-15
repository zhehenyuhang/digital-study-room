package xyz.yuhang.web.teacher;

import xyz.yuhang.pojo.Teacher;
import xyz.yuhang.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByNameteacher")
public class SelectByNameteacher extends HttpServlet {

    TeacherService teacherService = new TeacherService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String teacherName = request.getParameter("teacherName");

        List<Teacher> teachers = teacherService.selectByname(teacherName);

        HttpSession session = request.getSession();
        session.setAttribute("teacherwhere","1");
        session.setAttribute("teachers",teachers);

        request.getRequestDispatcher("/selectAllTeacherServlet").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
