package xyz.yuhang.web.student;

import xyz.yuhang.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取ID
        String id = request.getParameter("id");
        String studentId = request.getParameter("studentId");
        studentId = new String(studentId.getBytes("ISO-8859-1"),"utf-8");

        studentService.deleteAccount(studentId);
        studentService.delete(Integer.parseInt(id));

        request.getRequestDispatcher("/selectAllStudentServlet").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
