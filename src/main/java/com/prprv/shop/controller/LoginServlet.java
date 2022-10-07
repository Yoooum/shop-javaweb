package com.prprv.shop.controller;


import com.prprv.shop.dao.impl.UserInfoDaoImpl;
import com.prprv.shop.pojo.UserInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 未確認の庭師
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //调用请求对象
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        //验证登录
        UserInfo userInfo = new UserInfoDaoImpl().login(new UserInfo(null, null, email, password));
        //调用响应对象
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (userInfo.getEmail() != null && userInfo.getPassword() != null) {
            //登录成功
            HttpSession session = req.getSession();
            session.setAttribute("username", userInfo.getName());
            resp.sendRedirect("/shop/");
        } else {
            //登录失败
            out.print("<script>");
            out.print("alert('登录失败');");
            out.print("location.href='/shop/login.jsp';");
            out.print("</script>");
        }
    }
}

