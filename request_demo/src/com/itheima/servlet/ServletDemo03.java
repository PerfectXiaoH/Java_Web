package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/servletDemo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.根据名称获取数据 getParameter()
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);
        System.out.println("---------------------------------");

        //2.根据名称获取所有数据 getParameterValues()
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("---------------------------------");

        //3.获取所有名称 getParameterNames()
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name);
        }
        System.out.println("---------------------------------");

        //4.获取所有参数的键值对 getParameterMap()
        Map<String, String[]> map = req.getParameterMap();
        map.forEach((k, v) ->{
            System.out.print(k + "：");
            for (String s : v) {
                System.out.print(s + "，");
            }
            System.out.println();
        });
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
