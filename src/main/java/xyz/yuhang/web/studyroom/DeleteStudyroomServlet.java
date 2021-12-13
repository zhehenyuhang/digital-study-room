package xyz.yuhang.web.studyroom;

import xyz.yuhang.pojo.Studyroom;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudyroomServlet")
public class DeleteStudyroomServlet extends HttpServlet {
    StudyroomService studyroomService = new StudyroomService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String srid = request.getParameter("srid");

        studyroomService.deleteBySridStudyroomlog(srid);
        studyroomService.deleteStudyroom(Integer.parseInt(id));


        request.getRequestDispatcher("/selectAllServlet").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
