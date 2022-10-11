package com.prprv.shop.controller;


import com.prprv.shop.service.IsLoginImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

/**
 * @author 未確認の庭師
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //调用请求对象
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        if (new IsLoginImpl().user(email,password)) {
            //登录成功
            HttpSession session = req.getSession();
            session.setAttribute("username", email);
            resp.sendRedirect("/");
        } else {
            //登录失败
            req.setAttribute("message", "邮箱或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}

