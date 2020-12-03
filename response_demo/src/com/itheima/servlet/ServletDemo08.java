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
    文件下载
 */
@WebServlet("/servletDemo08")
public class ServletDemo08 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建字节输入流对象，关联读取的文件
        String realPath = getServletContext().getRealPath("img/naizi.jpg");
        BufferedInputStream bis = new BufferedInputStream(new
                FileInputStream(realPath));

        //2.设置响应头支持的类型
        /*
            Content-Type 消息头名称 支持的类型
            application/octet-stream 消息头参数 应用的类型为字节流
         */
        resp.setHeader("Content-Type", "application/octet-stream");

        //3.设置响应头以下载方式打开附件
        /*
            Content-Disposition 消息头名称 处理的形式
            attachment;filename=hm.png 消息头参数 附件形式进行处理 指定下载文件的名称
         */
        resp.setHeader("Content-Disposition", "attachment;filename=haoziweizhi.jpg");

        //4.获取字节输出流对象
        ServletOutputStream os = resp.getOutputStream();

        //5.循环读写
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            os.write(bys, 0, len);
        }
        //6.释放资源
        bis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
