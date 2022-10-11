package com.prprv.shop.service;

/**
 * @author 未確認の庭師
 */
public interface IsLogin {
    boolean admin(String name,String password);
    boolean user(String email,String password);
}
