package xyz.yuhang.web.clientside;

import xyz.yuhang.service.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addStudyCSServlet")
public class AddStudyCSServlet extends HttpServlet {

    DataService dataService = new DataService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String srid = request.getParameter("srid");
        String timeId = request.getParameter("timeId");
        String date = request.getParameter("date");
        HttpSession session = request.getSession();
        Object studentId = session.getAttribute("studentId");

        //判断该学生当前时间段是否已经有选择的课程了

        String i = dataService.selectByIdandTime(studentId, timeId, date);

        // session.setAttribute("xuanze",0);
        //判断选择的课是否还有空余座位
        int s = dataService.selectByNusing(srid, timeId, date);

        if("0".equals(i) && s>0){
            //可以选择
            dataService.updateUsing(srid,timeId,date,studentId);
            dataService.updateStudyroomlog(srid,timeId,date);
            // session.setAttribute("xuanze",1);
        }else {
            //不可以选择
            // session.setAttribute("xuanze",-1);
        }

        // request.setAttribute("yanse",srid+timeId+date);

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
