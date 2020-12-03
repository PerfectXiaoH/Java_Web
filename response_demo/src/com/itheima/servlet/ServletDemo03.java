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
import java.io.PrintWriter;

/*
    响应图片
 */
@WebServlet("/servletDemo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建字节输入流对象，关联图片路径
        BufferedInputStream bis = new BufferedInputStream(new
                FileInputStream(this.getServletContext().getRealPath("/img/hm.png")));

        //2.通过响应对象获取字节输出流对象
        ServletOutputStream os = resp.getOutputStream();

        //3.循环读写
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            os.write(bys, 0, len);
        }
        bis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
