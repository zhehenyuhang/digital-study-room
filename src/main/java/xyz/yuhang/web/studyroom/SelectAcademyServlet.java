package xyz.yuhang.web.studyroom;

import xyz.yuhang.pojo.Academy;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAcademyServlet")
public class SelectAcademyServlet extends HttpServlet {

    StudyroomService  studyroomService = new StudyroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object acadwhere = session.getAttribute("acadwhere");
        Object academies;
        if ("1".equals(acadwhere)){
            //已经查询过，显示查询的studyroomLogs
            academies = session.getAttribute("academies");
        }else {
            //未查询，获取新的查询
            academies = studyroomService.selectAllAcademy();
        }


        session.setAttribute("academies",academies);

        request.getRequestDispatcher("/web/jsp/StudyRoomManagement/CollegeManagement.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
