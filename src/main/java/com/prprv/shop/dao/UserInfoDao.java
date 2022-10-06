package com.prprv.shop.dao;

import com.prprv.shop.pojo.UserInfo;

import java.util.List;


/**
 * @author 未確認の庭師
 */
public interface UserInfoDao {
    List<UserInfo> getUserList();
    UserInfo login(UserInfo userInfo);
    int addUserInfo(UserInfo userInfo);
    int updateUserInfo(UserInfo userInfo);
    int deleteUserInfo(int id);
}
