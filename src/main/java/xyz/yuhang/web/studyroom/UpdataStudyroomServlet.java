package xyz.yuhang.web.studyroom;

import xyz.yuhang.StudyroomLogJdbc;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updataStudyroomServlet")
public class UpdataStudyroomServlet extends HttpServlet {

    StudyroomService studyroomService = new StudyroomService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String srid = request.getParameter("srid");
        String seatNumber = request.getParameter("seatNumber");
        String acid = request.getParameter("acid");

        studyroomService.updataStudyroom(id,srid,seatNumber,acid);
        studyroomService.updateStudyroomfLog(srid,Integer.parseInt(seatNumber),acid);


        request.getRequestDispatcher("/selectAllServlet").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
