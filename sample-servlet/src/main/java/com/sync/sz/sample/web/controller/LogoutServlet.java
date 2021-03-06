package com.sync.sz.sample.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class LogoutServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if (session != null) {
      session.removeAttribute("user");
    }
    req.setAttribute("message", "注销成功!!5秒后将自动跳转首页!! <meta http-equiv='refresh' content='5;url=/sample/index.jsp'>");
    req.getRequestDispatcher("/sample/message.jsp").forward(req, resp);
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
