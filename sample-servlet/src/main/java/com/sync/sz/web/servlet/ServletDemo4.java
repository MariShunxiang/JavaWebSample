package com.sync.sz.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class ServletDemo4 extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String value = (String) this.getServletContext().getAttribute("aa");
    System.out.println(value);

  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
