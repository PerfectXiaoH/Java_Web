package com.itheima.servlet;

import com.itheima.bean.Student;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/*
    流对象获取数据
 */
@WebServlet("/servletDemo07")
public class ServletDemo07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //字符流（必须是post方式）
//        BufferedReader br = req.getReader();
//        String line;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
//        //br.close();
        //字节流
        ServletInputStream is = req.getInputStream();
        byte[] bys = new byte[1024];
        int len;
        while ((len = is.read(bys)) != -1) {
            System.out.println(new String(bys, 0, len));
        }
//        is.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
