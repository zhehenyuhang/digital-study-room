package xyz.yuhang.web.student;

import xyz.yuhang.pojo.Student;
import xyz.yuhang.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllStudentServlet")
public class SelectAllStudentServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        Object studentwhere = session.getAttribute("studentwhere");
        Object students;
        if ("1".equals(studentwhere)){
            //已经查询过，显示查询的studyroomLogs
            students = session.getAttribute("students");
        }else {
            //未查询，获取新的查询
            students = studentService.selectAll();
        }
        //sql

        // for (Student student : students) {
        //     System.out.println(student);
        // }

        request.setAttribute("students",students);

        request.getRequestDispatcher("/web/jsp/UserManagement/StudentManagement.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
