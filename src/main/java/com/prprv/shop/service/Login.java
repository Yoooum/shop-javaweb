package com.prprv.shop.service;

import com.prprv.shop.pojo_old.UserInfo;

/**
 * @author 未確認の庭師
 */
public interface Login {
    boolean admin(String name,String password);
    boolean hasUser(String email,String password);
    UserInfo getUserInfo(String email);
}
