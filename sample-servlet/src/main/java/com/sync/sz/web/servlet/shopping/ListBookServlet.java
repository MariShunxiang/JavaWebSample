package com.sync.sz.web.servlet.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
public class ListBookServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    req.getSession();

    out.print("本网站有如下商品:<br/>");
    Map<String, Book> map = Db.getAll();
    for (Map.Entry<String, Book> entry : map.entrySet()) {
      Book book = entry.getValue();
      String url = resp.encodeURL("/BuyServlet?id=" + book.getId());
      out.print(book.getName() + " <a href='" + url + "' target='_blank'>购买</a><br/>");
    }
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}

class Db {
  private static Map<String, Book> map = new LinkedHashMap<String, Book>();

  static {
    map.put("1", new Book("1", "Java Web", "sync", "gook book!"));
    map.put("2", new Book("2", "Jdbc", "mari", "gook book!"));
    map.put("3", new Book("3", "Spring", "sync", "gook book!"));
    map.put("4", new Book("4", "Status", "sync", "gook book!"));
    map.put("5", new Book("5", "Android", "sync", "gook book!"));
  }

  public static Map<String, Book> getAll() {
    return map;
  }
}

class Book implements Serializable {

  private String id;
  private String name;
  private String author;
  private String description;

  public Book() {
  }

  public Book(String id, String name, String author, String description) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}


