package xyz.yuhang.web.studyroom;

import xyz.yuhang.StudyroomLogJdbc;
import xyz.yuhang.pojo.Academy;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudyroomServlet")
public class AddStudyroomServlet extends HttpServlet {
    StudyroomService studyroomService = new StudyroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String srid = request.getParameter("srid");
        String seatNumber = request.getParameter("seatNumber");
        String id = request.getParameter("id");


        studyroomService.addStudyroom(srid,seatNumber,id);

        Academy academy = studyroomService.selectByIdAcademy(id);
        StudyroomLogJdbc studyroomLogJdbc = new StudyroomLogJdbc();
        studyroomLogJdbc.insert(srid,seatNumber,academy.getAcademyName());

        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
