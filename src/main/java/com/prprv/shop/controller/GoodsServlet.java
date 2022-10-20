package com.prprv.shop.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONType;
import com.prprv.shop.mapper.GoodsMapper;
import com.prprv.shop.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 未確認の庭師
 */
@WebServlet(name = "GoodsServlet", urlPatterns = "/data/goods")
public class GoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/javascript;charset=UTF-8");
        req.getParameter("goods_list");
        PrintWriter out = resp.getWriter();
        if(req.getParameter("goods_list").equals("all")){
            //查所有商品
            SqlSession sqlSession = SqlSessionUtil.getSession();
            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
            out.write(JSON.toJSONString(goodsMapper.selectAllGoods()));
        } else {
            out.write("error");
        }
    }
}
