package xyz.yuhang.web.studyroom;

import org.omg.PortableInterceptor.INACTIVE;
import xyz.yuhang.pojo.Academy;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdAcademyServlet")
public class SelectByIdAcademyServlet extends HttpServlet {
    StudyroomService studyroomService = new StudyroomService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Academy academy = studyroomService.selectByIdnAcademy(Integer.parseInt(id));

        request.setAttribute("academy",academy);

        request.getRequestDispatcher("web/jsp/StudyRoomManagement/updataCollege.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
