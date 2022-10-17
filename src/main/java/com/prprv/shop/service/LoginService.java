package com.prprv.shop.service;

import com.prprv.shop.pojo.User;

/**
 * @author 未確認の庭師
 */
public interface LoginService {
    Boolean isLogin(String email, String password);
    User getUserById(Integer uid);
    User getUserByEmail(String email);
    User registerUser(User user);
}
