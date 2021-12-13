package xyz.yuhang.web.studyroom;

import xyz.yuhang.pojo.Academy;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updataAcademyServlet")
public class UpdataAcademyServlet extends HttpServlet {
    StudyroomService studyroomService = new StudyroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String academyName = request.getParameter("academyName");
        String id = request.getParameter("id");

        Academy academy = new Academy();

        academy.setId(Integer.parseInt(id));
        academy.setAcademyName(academyName);

        // Academy ac = studyroomService.selectByIdAcademy(Integer.parseInt(id));
        studyroomService.updataAcademy(academy);
        // studyroomService.updata

        request.getRequestDispatcher("/selectAcademyServlet").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
