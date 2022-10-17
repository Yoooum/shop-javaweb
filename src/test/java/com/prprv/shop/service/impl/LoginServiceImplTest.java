package com.prprv.shop.service.impl;

import com.prprv.shop.pojo.User;
import com.prprv.shop.service.LoginService;
import org.junit.jupiter.api.Test;

/**
 * @author 未確認の庭師
 */
class LoginServiceImplTest {

    @Test
    void isLogin() {
        LoginService loginService = new LoginServiceImpl();
        Boolean isLogin = loginService.isLogin("test@p.p","123456");
        if (isLogin){
            User user = loginService.getUserByEmail("test@p.p");
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