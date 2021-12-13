package xyz.yuhang.web.student;

import xyz.yuhang.pojo.Student;
import xyz.yuhang.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdStudentServlet")
public class SelectByIdStudentServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        Student student = studentService.selectById(Integer.parseInt(id));

        request.setAttribute("student",student);

        request.getRequestDispatcher("/web/jsp/UserManagement/updataStudent.jsp").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
