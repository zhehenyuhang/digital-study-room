package xyz.yuhang.web.studyroom;

import xyz.yuhang.pojo.Academy;
import xyz.yuhang.pojo.Studyroom;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    StudyroomService studyroomService = new StudyroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Studyroom> studyrooms = studyroomService.selectStudyroom();

        request.setAttribute("studyrooms",studyrooms);

        // List academys = null;
        //
        // for (Studyroom studyroom : studyrooms) {
        //     int academy = studyroom.getAcademy();
        //
        //     Academy academy1 = studyroomService.selectByIdAcademy(academy);
        //
        //     academys.add(academy1.getAcademyName());
        //
        // }
        // request.setAttribute("academys",academys);

        request.getRequestDispatcher("/web/jsp/StudyRoomManagement/ClassRoomManagement.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
