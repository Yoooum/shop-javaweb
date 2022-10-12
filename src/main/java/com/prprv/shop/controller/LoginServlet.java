package com.prprv.shop.controller;


import com.prprv.shop.pojo.UserInfo;
import com.prprv.shop.service.Login;
import com.prprv.shop.service.impl.LoginImpl;

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
        // req.setCharacterEncoding("UTF-8")的作用是设置对客户端请求进行重新编码的编码
        // resp.setCharacterEncoding("UTF-8")的作用是指定对服务器响应进行重新编码的编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //调用请求对象
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if(email != null || password != null){
            Login login = new LoginImpl();
            if(login.hasUser(email,password)){
                HttpSession session = req.getSession();
                UserInfo userInfo = login.getUserInfo(email);
                session.setAttribute("username",userInfo.getName());
                session.setAttribute("email",userInfo.getEmail());
                //req.getRequestDispatcher("index.jsp").forward(req,resp);
                resp.sendRedirect("/");
            }
        } else {
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            //resp.sendRedirect("/login.jsp");
        }

    }
}




