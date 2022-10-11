package com.prprv.shop.controller;// 导入必需的 java 库

import com.prprv.shop.dao.impl.UserInfoDaoImpl;
import com.prprv.shop.pojo.UserInfo;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// 扩展 HttpServlet 类
@WebServlet(name = "HelloForm", urlPatterns = "/hello")
public class Test extends HttpServlet {
    private String message;
    public void init() {
        message = "Hello World";
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html,charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
        List<UserInfo> userList = new UserInfoDaoImpl().queryUserInfo();
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("test.jsp").forward(req,resp);
    }
}