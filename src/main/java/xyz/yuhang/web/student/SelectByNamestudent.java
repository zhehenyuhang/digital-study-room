package xyz.yuhang.web.student;

import xyz.yuhang.pojo.Student;
import xyz.yuhang.pojo.Teacher;
import xyz.yuhang.service.StudentService;
import xyz.yuhang.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByNamestudent")
public class SelectByNamestudent extends HttpServlet {

    StudentService studentService = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String studentName = request.getParameter("studentName");

        List<Student> students = studentService.selectByname(studentName);

        HttpSession session = request.getSession();
        session.setAttribute("studentwhere","1");
        session.setAttribute("students",students);

        request.getRequestDispatcher("/selectAllStudentServlet").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
