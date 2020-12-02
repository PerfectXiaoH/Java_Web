package com.itheima.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取ServletContext对象
        ServletContext context = getServletContext();

        //2.常用方法的演示
        //获取全局配置参数：getInitParameter(String Key) 根据Key获取Value
        String value = context.getInitParameter("globalDesc");
        System.out.println(value);

        //3.根据虚拟目录获取绝对路径：getRealPath(String path)
        String realPath = context.getRealPath("/");
        System.out.println(realPath);

        String a = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);

        String b = context.getRealPath("/b.txt");
        System.out.println(b);

        String c = context.getRealPath("WEB-INF/c.txt");
        System.out.println(c);

        //设置共享数据
        context.setAttribute("username", "zhangsan");

        //删除共享数据
//        context.removeAttribute("username");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
