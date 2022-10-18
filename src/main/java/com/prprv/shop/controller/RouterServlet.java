package com.prprv.shop.controller;

import com.alibaba.fastjson2.JSON;
import com.prprv.shop.mapper.GoodsMapper;
import org.apache.ibatis.session.SqlSession;

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
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        switch (param){
            //http://127.0.0.1:8080/api/?data=classify
            case "classify" : out.write(JSON.toJSONString(goodsMapper.selectAllClassify()));break;
            case "goods" : out.write("goods");break;
            case "users" : out.write("users");break;
            default: out.write("error");
        }


    }
}
