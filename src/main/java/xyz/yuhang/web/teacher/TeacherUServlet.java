package xyz.yuhang.web.teacher;

import xyz.yuhang.pojo.StudyroomLog;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/teacherUServlet")
public class TeacherUServlet extends HttpServlet {

    StudyroomService studyroomService = new StudyroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //获取字符输出流，并设置content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();


        //座位
        StudyroomLog studyroomLog = studyroomService.selectByu();
        int seatNumber = studyroomLog.getSeatNumber();
        int usIng = studyroomLog.getUsIng();
        int nusIng = studyroomLog.getNusIng();

        session.setAttribute("seatNumber",seatNumber);
        session.setAttribute("usIng",usIng);
        session.setAttribute("nusIng",nusIng);

        request.getRequestDispatcher("/web/jsp/HomePage/zhuye.jsp").forward(request,response);



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
