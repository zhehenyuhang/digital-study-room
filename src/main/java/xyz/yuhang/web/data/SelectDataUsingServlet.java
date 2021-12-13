package xyz.yuhang.web.data;

import xyz.yuhang.service.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/selectDataUsingServlet")
public class SelectDataUsingServlet extends HttpServlet {

    DataService dataService = new DataService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date(System.currentTimeMillis());
        String strTime = new SimpleDateFormat("yyyy-MM-dd").format(date);
        // String[] format = simpleDateFormat.format(date).split(" ");
        int time = Integer.parseInt(strTime.replace("-",""));

        String i = dataService.selectDataUsing(time);
        String i2 = dataService.selectDataUsingZhou(time);
        String i3 = dataService.selectDataUsingYue(time);

        request.setAttribute("using",i);
        request.setAttribute("usingZhou",i2);
        request.setAttribute("usingYue",i3);

        request.getRequestDispatcher("/web/jsp/DataStatistics/LearningSituation.jsp").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
