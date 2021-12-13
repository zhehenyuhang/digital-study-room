package xyz.yuhang.web.studyroom;

import xyz.yuhang.StudentStudyJdbc;
import xyz.yuhang.StudyroomLogJdbc;
import xyz.yuhang.pojo.Academy;
import xyz.yuhang.pojo.Studyroom;
import xyz.yuhang.pojo.StudyroomLog;
import xyz.yuhang.service.StudentService;
import xyz.yuhang.service.StudyroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/selectStudyroomServlet")
public class SelectStudyroomServlet extends HttpServlet {

    StudyroomService studyroomService = new StudyroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        new StudyroomLogJdbc().play();
        new StudentStudyJdbc().play();
        //创建session，对显示表进行判断
        HttpSession session = request.getSession();
        Object where = session.getAttribute("where");


        List<Academy> academies = studyroomService.selectAcademyName();
        List<StudyroomLog> dates =  studyroomService.selectDate();
        List<StudyroomLog> srids =  studyroomService.selectSrid();

        Object studyroomLogs;
        //判断是否查询过
        if ("1".equals(where)){
            //已经查询过，显示查询的studyroomLogs
            studyroomLogs = session.getAttribute("studyroomLogs");
        }else {
            //未查询，获取新的查询
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            Date date = new Date(System.currentTimeMillis());
            String strTime = new SimpleDateFormat("yyyy-MM-dd").format(date);
            int time = Integer.parseInt(strTime.replace("-",""));
            studyroomLogs = studyroomService.studyroomLog(String.valueOf(time));
        }


        request.setAttribute("academies",academies);
        request.setAttribute("dates",dates);
        request.setAttribute("srids",srids);
        session.setAttribute("studyroomLogs",studyroomLogs);

        request.getRequestDispatcher("/web/jsp/StudyRoomManagement/SeatManagement.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
