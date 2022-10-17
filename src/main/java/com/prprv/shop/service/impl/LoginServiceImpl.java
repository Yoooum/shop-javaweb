package com.prprv.shop.service.impl;

import com.prprv.shop.mapper.UserMapper;
import com.prprv.shop.pojo.User;
import com.prprv.shop.service.LoginService;
import com.prprv.shop.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 未確認の庭師
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public Boolean isLogin(String email, String password) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin(email, password);
        sqlSession.close();
        return user != null;
    }

    @Override
    public User getUserById(Integer uid) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(uid);
        sqlSession.close();
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserByEmail(email);
        sqlSession.close();
        return user;
    }

    @Override
    public User registerUser(User user) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insertUser(user);
        sqlSession.close();
        return user;
    }
}
