package com.prprv.shop.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 未確認の庭師
 */
@WebServlet(urlPatterns = "/api/")
public class RouterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/javascript;charset=UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String param = req.getParameter("data");
        PrintWriter out = resp.getWriter();
        switch (param){
            //http://127.0.0.1:8080/api/?data=classify
            case "classify" : out.write("classify");break;
            case "goods" : out.write("goods");break;
            case "users" : out.write("users");break;
            default: out.write("error");
        }


    }
}
