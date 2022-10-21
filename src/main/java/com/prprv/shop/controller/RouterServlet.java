package com.prprv.shop.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.prprv.shop.mapper.GoodsMapper;
import com.prprv.shop.mapper.UserMapper;
import com.prprv.shop.pojo.Goods;
import com.prprv.shop.pojo.User;
import com.prprv.shop.service.LoginService;
import com.prprv.shop.service.impl.LoginServiceImpl;
import com.prprv.shop.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
@WebServlet(name = "RouterServlet", urlPatterns = "/api/")
public class RouterServlet extends HttpServlet {
    static JSONObject httpJsonRequest(HttpServletRequest req) throws IOException {
        StringBuilder reqJson = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            reqJson.append(line);
        }
        return (JSONObject) JSON.parse(reqJson.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        switch (req.getParameter("param")) {
            //当前用户
            case "login": login(req, resp);break;
            case "register": register(req, resp);break;
            //共用
            case "user_update":
            case "users_update":
                userUpdate(req,resp);break;
            //商品管理
            case "goods_all": goodsAllList(req, resp);break;
            case "goods_add": goodsAdd(req, resp);break;
            case "goods_delete": goodsDelete(req, resp);break;
            case "goods_update": goodsUpdate(req, resp);break;
            case "classify_all": classifyAllList(req, resp);break;
            //用户管理
            case "users_add": usersAdd(req, resp);break;
            case "users_delete": usersDelete(req, resp);break;
            case "users_all": userAllList(req,resp); break;

            default: resp.sendError(404);
        }
    }

    private void usersDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int ret = userMapper.deleteUser(Integer.valueOf(req.getParameter("uid")));
        Map<String, Object> map = new HashMap<>();
        if(ret == 1){
            map.put("status", "success");
            map.put("msg", "删除成功");
        } else {
            map.put("status", "error");
            map.put("msg", "删除失败");
        }
        PrintWriter out = resp.getWriter();
        out.print(JSON.toJSONString(map));
    }

    private void usersAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json = httpJsonRequest(req);
        System.out.println(json);
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername(json.getString("name"));
        user.setEmail(json.getString("email"));
        user.setPassword(json.getString("password"));
        user.setAdmin(json.getBoolean("admin"));
        userMapper.insertUser(user);
        Map<String, Object> map = new HashMap<>();
        if(user.getUid() != null){
            map.put("status", "success");
            map.put("msg", "添加成功");
        } else {
            map.put("status", "error");
            map.put("msg", "添加失败");
        }
        PrintWriter out = resp.getWriter();
        out.print(JSON.toJSONString(map));
    }

    private void userAllList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        Map<String, Object> map = new HashMap<>();
        //查所有用户
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        map.put("status", "success");
        map.put("data", userMapper.selectAllUser());
        out.write(JSON.toJSONString(map));
        sqlSession.close();
    }

    private void userUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json = httpJsonRequest(req);
        System.out.println(json);
        User user = new User();
        user.setUid(json.getInteger("uid"));
        user.setEmail(json.getString("email"));
        user.setUsername(json.getString("username"));
        user.setPassword(json.getString("password"));
        user.setAdmin(json.getBoolean("is_admin"));
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        PrintWriter out = resp.getWriter();
        Map<String,Object>  map = new HashMap<>();
        if(userMapper.updateUser(user)==1){
            map.put("status", "success");
            map.put("msg", "修改成功");
        }else {
            map.put("status", "fail");
            map.put("msg", "修改失败");
        }
        out.write(JSON.toJSONString(map));
    }

    private void goodsUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json = httpJsonRequest(req);
        System.out.println(json);
        SqlSession sqlSession = SqlSessionUtil.getSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        Goods goods = new Goods();
        goods.setGid(json.getInteger("gid"));
        goods.setName(json.getString("name"));
        goods.setPrice(json.getDouble("price"));
        goods.setAmount(json.getInteger("amount"));
        goods.setClassify(json.getString("classify"));
        goods.setImg(json.getString("img"));
        goods.setBrief(json.getString("brief"));
        goods.setIntro(json.getString("intro"));
        goods.setDate(json.getDate("date"));
        int ret  = goodsMapper.updateGoods(goods);
        System.out.println(ret);
        Map<String, Object> map = new HashMap<>();
        if(ret == 1){
            map.put("status", "success");
            map.put("msg", "修改成功");
        } else {
            map.put("status", "error");
            map.put("msg", "修改失败");
        }
        PrintWriter out = resp.getWriter();
        out.print(JSON.toJSONString(map));
        sqlSession.close();
    }

    private void goodsDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getParameter("gid");
        SqlSession sqlSession = SqlSessionUtil.getSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        int ret = goodsMapper.deleteGoods(Integer.parseInt(req.getParameter("gid")));
        Map<String, Object> map = new HashMap<>();
        if(ret == 1){
            map.put("status", "success");
            map.put("msg", "删除成功");
        } else {
            map.put("status", "error");
            map.put("msg", "删除失败");
        }
        PrintWriter out = resp.getWriter();
        out.print(JSON.toJSONString(map));
    }

    private void goodsAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json = httpJsonRequest(req);
        System.out.println(json);
        SqlSession sqlSession = SqlSessionUtil.getSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        Goods goods = new Goods();
        goods.setName(json.getString("name"));
        goods.setPrice(json.getDouble("price"));
        goods.setAmount(json.getInteger("amount"));
        goods.setClassify(json.getString("classify"));
        goods.setImg(json.getString("img"));
        goods.setBrief(json.getString("brief"));
        goods.setIntro(json.getString("intro"));
        goods.setDate(json.getDate("date"));
        goodsMapper.insertGoods(goods);

        Map<String, Object> map = new HashMap<>();
        if(goods.getGid() != null){
            map.put("status", "success");
            map.put("msg", "添加成功");
        } else {
            map.put("status", "error");
            map.put("msg", "添加失败");
        }
        PrintWriter out = resp.getWriter();
        out.print(JSON.toJSONString(map));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json = httpJsonRequest(req);
        LoginService loginService = new LoginServiceImpl();
        PrintWriter out = resp.getWriter();
        Map<String, Object> map = new HashMap<>();
        System.out.println(json.getString("email"));
        System.out.println(json.getString("password"));
        if (loginService.isLogin(json.getString("email"), json.getString("password"))) {

            User user = loginService.getUserByEmail(json.getString("email"));
            map.put("status", "success");
            map.put("data", user);
            map.put("msg", "登录成功");
            out.write(JSON.toJSONString(map));
        } else {
            map.put("status", "fail");
            map.put("msg", "用户名或密码错误");
            out.write(JSON.toJSONString(map));
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json = httpJsonRequest(req);
        LoginService loginService = new LoginServiceImpl();
        PrintWriter out = resp.getWriter();
        Map<String, Object> map = new HashMap<>();
        if (loginService.getUserByEmail(json.getString("email")) == null) {
            User user = new User();
            user.setUsername(json.getString("username"));
            user.setEmail(json.getString("email"));
            user.setPassword(json.getString("password"));
            User userReg = loginService.registerUser(user);
            if(userReg.getUid()!=null){
                map.put("status", "success");
                map.put("msg", "注册成功");
                map.put("data", userReg);
                out.write(JSON.toJSONString(map));
            } else {
                map.put("status", "fail");
                map.put("msg", "注册失败");
                out.write(JSON.toJSONString(map));
            }
        } else {
            map.put("status", "fail");
            map.put("msg", "邮箱已被注册");
            out.write(JSON.toJSONString(map));
        }
    }

    private void goodsAllList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        Map<String, Object> map = new HashMap<>();
        //查所有商品
        SqlSession sqlSession = SqlSessionUtil.getSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        map.put("status", "success");
        map.put("data", goodsMapper.selectAllGoods());
        out.write(JSON.toJSONString(map));
        sqlSession.close();
    }

    private void classifyAllList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        Map<String, Object> map = new HashMap<>();
        SqlSession sqlSession = SqlSessionUtil.getSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        map.put("status", "success");
        map.put("data", goodsMapper.selectAllClassify());
        out.write(JSON.toJSONString(map));
        sqlSession.close();
    }
}
