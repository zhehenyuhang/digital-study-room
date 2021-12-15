package xyz.yuhang.web.clientside;

import xyz.yuhang.pojo.StudentStudy;
import xyz.yuhang.service.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/selectCountServlet")
public class SelectCountServlet extends HttpServlet {

    DataService dataService = new DataService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Object studentId = session.getAttribute("studentId");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date(System.currentTimeMillis());
        String strTime = new SimpleDateFormat("yyyy-MM-dd").format(date);
        // String[] format = simpleDateFormat.format(date).split(" ");
        int time = Integer.parseInt(strTime.replace("-",""));

        List<StudentStudy> studentStudies = dataService.selectByCount((String) studentId, String.valueOf(time));

        request.setAttribute("studentStudies",studentStudies);

        request.getRequestDispatcher("/web/jsp/StudentPage/StudentStudy.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
