package xyz.yuhang.web.student;

import xyz.yuhang.pojo.AccountStudent;
import xyz.yuhang.pojo.Student;
import xyz.yuhang.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updataAccountStudentServlet")
public class UpdataAccountStudentServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //luanma
        request.setCharacterEncoding("utf-8");

        //获取id
        String studentId = request.getParameter("studentId");
        String studentNumber = request.getParameter("studentNumber");
        String studentPassword = request.getParameter("studentPassword");

        AccountStudent accountStudent = new AccountStudent();

        accountStudent.setStudentId(studentId);
        accountStudent.setStudentNumber(studentNumber);
        accountStudent.setStudentPassword(studentPassword);

        studentService.updataAccount(accountStudent);

        request.getRequestDispatcher("/selectAllStudentServlet").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
