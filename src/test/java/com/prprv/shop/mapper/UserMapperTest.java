package com.prprv.shop.mapper;

import com.prprv.shop.pojo.User;
import com.prprv.shop.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @author 未確認の庭師
 */
class UserMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    @Test
    void insertUser() {
        User user = new User(null,"test@p.p","test","123456",true);
        userMapper.insertUser(user);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    void deleteUser() {
        User user = userMapper.selectUserByEmail("test@p.p");
        if (user != null) {
            System.out.println(userMapper.deleteUser(user.getUid()));
        } else {
            System.out.println("用户不存在");
        }
        sqlSession.close();
    }

    @Test
    void updateUser() {
        User user = userMapper.selectUserByEmail("test@p.p");
        if (user != null) {
            user.setUsername("test");
            user.setPassword("123456");
            System.out.println(userMapper.updateUser(user));
        } else {
            System.out.println("用户不存在");
        }
    }

    @Test
    void selectUserById() {
    }

    @Test
    void selectUserByEmail() {
        User user = userMapper.selectUserByEmail("test@p.p");
        System.out.println(user);
    }

    @Test
    void selectUserByName() {
        System.out.println(userMapper.selectUserByName("test"));
    }

    @Test
    void checkLogin() {
        User user = userMapper.checkLogin("test@p.p", "123456");
        System.out.println(user);
    }

    @Test
    void selectAllUser() {
        System.out.println(userMapper.selectAllUser());
    }

    @Test
    void selectAllUserToMap() {
        System.out.println(userMapper.selectAllUserToMap());
    }
}