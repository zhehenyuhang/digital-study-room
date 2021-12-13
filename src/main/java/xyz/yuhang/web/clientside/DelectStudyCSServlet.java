package xyz.yuhang.web.clientside;

import xyz.yuhang.service.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delectStudyCSServlet")
public class DelectStudyCSServlet extends HttpServlet {

    DataService dataService = new DataService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String srid = request.getParameter("srid");
        String timeId = request.getParameter("timeId");
        String date = request.getParameter("date");
        HttpSession session = request.getSession();
        Object studentId = session.getAttribute("studentId");

        //判断该学生当前时间段是否已经有选择的课程了

        String i = dataService.dselectByIdandTime(studentId, timeId, date,srid);

        // session.setAttribute("xuanze",0);

        if("1".equals(i)){
            //可以删除
            dataService.delectUsing(srid,timeId,date,studentId);
            dataService.delectStudyroomlog(srid,timeId,date);
            // session.setAttribute("xuanze",1);
        }else {
            //不可以选择
            // session.setAttribute("xuanze",-1);
        }


        Object where = session.getAttribute("where");

        if ("1".equals(where)){
            request.getRequestDispatcher("/selectchaServlet").forward(request,response);
        }else {
            request.getRequestDispatcher("/selectStudyroomCSServlet").forward(request,response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
