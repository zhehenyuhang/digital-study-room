package xyz.yuhang.web.student;

import xyz.yuhang.StudentStudyJdbc;
import xyz.yuhang.pojo.Student;
import xyz.yuhang.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    StudentService studentService = new StudentService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //乱码 post
        request.setCharacterEncoding("utf-8");

        //获取id
        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");

        Student student = new Student();
        student.setStudentId(studentId);
        student.setStudentName(studentName);

        studentService.add(student);
        studentService.addAccount(studentId);

        new StudentStudyJdbc().play();
        request.getRequestDispatcher("/selectAllStudentServlet").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}


