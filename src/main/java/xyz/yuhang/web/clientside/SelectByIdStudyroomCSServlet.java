package xyz.yuhang.web.clientside;

import xyz.yuhang.pojo.StudyroomLog;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByIdStudyroomCSServlet")
public class SelectByIdStudyroomCSServlet extends HttpServlet {

    StudyroomService studyroomService = new StudyroomService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String academyName = request.getParameter("academyName");
        String date = request.getParameter("date");
        String timeId = request.getParameter("timeId");
        String srid = request.getParameter("srid");

        List<StudyroomLog> studyroomLogs = studyroomService.SelectById(srid, timeId, date,academyName);

        HttpSession session = request.getSession();
        session.setAttribute("studyroomLogs",studyroomLogs);
        session.setAttribute("where","1");

        session.setAttribute("chaacademyName",academyName);
        session.setAttribute("chadate)",date);
        session.setAttribute("chatimeId",timeId);
        session.setAttribute("chasrid",srid);

        request.getRequestDispatcher("/selectStudyroomCSServlet").forward(request,response);


        // System.out.println("date:"+date);
        // System.out.println("timeId:"+timeId);
        // System.out.println("srid:"+srid);
        // System.out.println("submit:"+submit);

        // if ("1".equals(submit)){
        //     // System.out.println(1);
        //     // 查询位置
        // }else if ("2".equals(submit)){
        //     // System.out.println(2);
        //
        // }else if ("3".equals(submit)){
        //     // System.out.println(3);
        // }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
