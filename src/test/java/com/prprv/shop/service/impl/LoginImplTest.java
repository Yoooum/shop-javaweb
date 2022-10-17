package com.prprv.shop.service.impl;

import com.prprv.shop.pojo.User;
import com.prprv.shop.service.Login;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 未確認の庭師
 */
class LoginImplTest {

    @Test
    void isLogin() {
        Login login = new LoginImpl();
        Boolean isLogin = login.isLogin("test@p.p","123456");
        if (isLogin){
            User user = login.getUserByEmail("test@p.p");
            System.out.println(user);
        }
    }

    @Test
    void getUserById() {

    }

    @Test
    void getUserByEmail() {
    }

    @Test
    void registerUser() {
    }
}