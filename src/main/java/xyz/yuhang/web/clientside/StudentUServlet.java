package xyz.yuhang.web.clientside;

import xyz.yuhang.StudentStudyJdbc;
import xyz.yuhang.StudyroomLogJdbc;
import xyz.yuhang.pojo.AccountStudent;
import xyz.yuhang.pojo.StudyroomLog;
import xyz.yuhang.service.StudentService;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/studentUServlet")
public class StudentUServlet extends HttpServlet {

    StudyroomService studyroomService = new StudyroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //获取字符输出流，并设置content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date(System.currentTimeMillis());
        String strTime = new SimpleDateFormat("yyyy-MM-dd").format(date);
        // String[] format = simpleDateFormat.format(date).split(" ");
        int time = Integer.parseInt(strTime.replace("-",""));


        //座位
        StudyroomLog studyroomLog = studyroomService.selectByu(String.valueOf(time));
        int seatNumber = studyroomLog.getSeatNumber();
        int usIng = studyroomLog.getUsIng();
        int nusIng = studyroomLog.getNusIng();

        session.setAttribute("seatNumber",seatNumber);
        session.setAttribute("usIng",usIng);
        session.setAttribute("nusIng",nusIng);

        request.getRequestDispatcher("/web/jsp/StudentPage/Studentindex.jsp").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
