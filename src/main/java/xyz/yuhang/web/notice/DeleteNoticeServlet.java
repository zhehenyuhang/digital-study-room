package xyz.yuhang.web.notice;

import xyz.yuhang.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteNoticeServlet")
public class DeleteNoticeServlet extends HttpServlet {

    NoticeService noticeService = new NoticeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        noticeService.delect(Integer.parseInt(id));

        request.getRequestDispatcher("/selectNoticeServlet").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
