package com.prprv.shop.dao;

import com.prprv.shop.pojo_old.UserInfo;

import java.util.List;


/**
 * @author 未確認の庭師
 */
public interface UserInfoDao {
    List<UserInfo> getUserList();
    List<UserInfo> queryUserInfo(String sql, Object... params);
    UserInfo login(UserInfo userInfo);
    int addUserInfo(UserInfo userInfo);
    int updateUserInfo(UserInfo userInfo);
    int deleteUserInfo(int id);
}
