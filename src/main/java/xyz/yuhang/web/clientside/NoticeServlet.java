package xyz.yuhang.web.clientside;

import xyz.yuhang.pojo.Notice;
import xyz.yuhang.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/noticeServlet")
public class NoticeServlet extends HttpServlet {

    NoticeService noticeService = new NoticeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Notice> notices = noticeService.selectAll();

        request.setAttribute("notices",notices);

        request.getRequestDispatcher("/web/jsp/StudentPage/NotificationInformation.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
