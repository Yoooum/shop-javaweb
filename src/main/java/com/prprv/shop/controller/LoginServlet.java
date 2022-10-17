package com.prprv.shop.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.prprv.shop.pojo.User;
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
import java.util.Map;


/**
 * @author 未確認の庭師
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/data/login")
public class LoginServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // req.setCharacterEncoding("UTF-8")的作用是设置对客户端请求进行重新编码的编码
        // resp.setCharacterEncoding("UTF-8")的作用是指定对服务器响应进行重新编码的编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(email + " " + password);

        Login login = new LoginImpl();
        PrintWriter out = resp.getWriter();
        if (login.isLogin(email, password)) {
            User user = login.getUserByEmail(email);
            out.print(JSON.toJSONString(Map.of("status", 1, "data", user)));
        } else {
            out.print("{status:0}");
        }

    }
}




