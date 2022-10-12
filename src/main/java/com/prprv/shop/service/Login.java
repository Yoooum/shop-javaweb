package com.prprv.shop.service;

import com.prprv.shop.pojo.UserInfo;

import java.util.Map;
import java.util.Objects;

/**
 * @author 未確認の庭師
 */
public interface Login {
    boolean admin(String name,String password);
    boolean hasUser(String email,String password);
    UserInfo getUserInfo(String email);
}
