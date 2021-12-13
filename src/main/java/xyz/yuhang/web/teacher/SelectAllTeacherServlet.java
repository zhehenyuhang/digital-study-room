package xyz.yuhang.web.teacher;


import xyz.yuhang.pojo.Teacher;
import xyz.yuhang.service.StudentService;
import xyz.yuhang.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/selectAllTeacherServlet")
public class SelectAllTeacherServlet extends HttpServlet {

    TeacherService teacherService = new TeacherService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //sql

        List<Teacher> teachers = teacherService.selectAll();

        // for (Student student : students) {
        //     System.out.println(student);
        // }

        request.setAttribute("teachers",teachers);


        request.getRequestDispatcher("/web/jsp/UserManagement/TeacherManagement.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
