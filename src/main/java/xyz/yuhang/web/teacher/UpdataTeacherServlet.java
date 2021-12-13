package xyz.yuhang.web.teacher;

import xyz.yuhang.pojo.Teacher;
import xyz.yuhang.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updataTeacherServlet")
public class UpdataTeacherServlet extends HttpServlet {

    TeacherService teacherService = new TeacherService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //中文乱码
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String teacherId = request.getParameter("teacherId");
        String teacherName = request.getParameter("teacherName");

        Teacher teacher = new Teacher();

        teacher.setId(Integer.parseInt(id));
        teacher.setTeacherId(teacherId);
        teacher.setTeacherName(teacherName);


        teacherService.updata(teacher);

        request.getRequestDispatcher("/selectAllTeacherServlet").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
