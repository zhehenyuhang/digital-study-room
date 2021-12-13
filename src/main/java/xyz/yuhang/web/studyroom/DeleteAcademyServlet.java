package xyz.yuhang.web.studyroom;

import xyz.yuhang.pojo.Studyroom;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAcademyServlet")
public class DeleteAcademyServlet extends HttpServlet {
    StudyroomService studyroomService = new StudyroomService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        //查询教室表中是否存在此学院的教室存在则不允许删除


        Studyroom studyroom = studyroomService.selectAcademy(Integer.parseInt(id));

        if(studyroom == null){
            //不存在  可以删除
            //删除操作
            studyroomService.deleteAcademy(Integer.parseInt(id));

            request.getRequestDispatcher("/selectAcademyServlet").forward(request,response);
        }else {
            //存在
            //已存在该学院
            int i = 1;
            request.setAttribute("i",i);
            request.getRequestDispatcher("/selectAcademyServlet").forward(request,response);
        }



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
