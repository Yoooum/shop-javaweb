package com.prprv.shop.service;

import com.prprv.shop.pojo.User;
import com.prprv.shop.pojo_old.UserInfo;

/**
 * @author 未確認の庭師
 */
public interface Login {
    Boolean isLogin(String email, String password);
    User getUserById(Integer uid);
    User getUserByEmail(String email);
    User registerUser(User user);
}
