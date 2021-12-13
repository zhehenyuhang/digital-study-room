package xyz.yuhang.web.studyroom;

import xyz.yuhang.pojo.Academy;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectSridServlet")
public class SelectSridServlet extends HttpServlet {

    StudyroomService studyroomService = new StudyroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Academy> academies = studyroomService.selectAllAcademy();
        request.setAttribute("academies",academies);
        request.getRequestDispatcher("/web/jsp/StudyRoomManagement/addClassRoom.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
