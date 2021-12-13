package xyz.yuhang.web.studyroom;

import xyz.yuhang.pojo.Academy;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addAcademyServlet")
public class AddAcademyServlet extends HttpServlet {

    StudyroomService studyroomService = new StudyroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String academyName = request.getParameter("academyName");

        Academy academy = studyroomService.selectByAcademy(academyName);

        if(academy == null){
            //不存在该学院 可以添加
            studyroomService.addAcademy(academyName);
            request.getRequestDispatcher("/selectAcademyServlet").forward(request,response);
        }else {
            //已存在该学院
            int i = 1;
            request.setAttribute("i",i);
            request.getRequestDispatcher("/web/jsp/StudyRoomManagement/addCollege.jsp").forward(request,response);
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
