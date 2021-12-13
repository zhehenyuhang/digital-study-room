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

@WebServlet("/selectByIdAccountStudentServlet")
public class SelectByIdAccountStudentServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String studentId = request.getParameter("studentId");
        studentId = new String(studentId.getBytes("ISO-8859-1"),"UTF-8");


        AccountStudent accountStudent = studentService.selectByIdAccount(studentId);

        request.setAttribute("accountStudent",accountStudent);

        request.getRequestDispatcher("/web/jsp/UserManagement/updataAccountStudent.jsp").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
