package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
    设置缓存
 */
@WebServlet("/servletDemo04")
public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String news = "这是一条很火爆的新闻！";

        //设置缓存 1小时的缓存时间
        resp.setDateHeader("Expires", System.currentTimeMillis() + 60 * 60 * 1000);

        //设置编码格式
        resp.setContentType("text/html;charset=UTF-8");
        //写出数据
        resp.getWriter().write(news);

        System.out.println("aaa");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
