package xyz.yuhang.web.studyroom;

import xyz.yuhang.pojo.Academy;
import xyz.yuhang.pojo.Studyroom;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    StudyroomService studyroomService = new StudyroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object studyroomwhere = session.getAttribute("studyroomwhere");
        Object studyrooms;
        if ("1".equals(studyroomwhere)){
            //已经查询过，显示查询的studyroomLogs
            studyrooms = session.getAttribute("studyrooms");
        }else {
            //未查询，获取新的查询
            studyrooms = studyroomService.selectStudyroom();
        }


        session.setAttribute("studyrooms",studyrooms);

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
