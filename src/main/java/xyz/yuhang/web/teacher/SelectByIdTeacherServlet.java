package xyz.yuhang.web.teacher;

import xyz.yuhang.pojo.Teacher;
import xyz.yuhang.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdTeacherServlet")
public class SelectByIdTeacherServlet extends HttpServlet {
    TeacherService teacherService = new TeacherService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取id
        String id = request.getParameter("id");


        Teacher teacher = teacherService.selectById(Integer.parseInt(id));

        request.setAttribute("teacher",teacher);

        request.getRequestDispatcher("/web/jsp/UserManagement/updataTeacher.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
