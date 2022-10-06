package com.prprv.shop.dao.impl;

import com.prprv.shop.dao.UserInfoDao;
import com.prprv.shop.pojo.UserInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 未確認の庭師
 */
class UserInfoDaoImplTest {

    @Test
    void getUserList() {
        UserInfoDao infoDao = new UserInfoDaoImpl();
        List<UserInfo> userList = infoDao.getUserList();
        for (UserInfo list : userList){
            System.out.println(list);
        }
    }

    @Test
    void addUserInfo() {
    }

    @Test
    void updateUserInfo() {
    }

    @Test
    void deleteUserInfo() {
    }

    @Test
    void login() {
        System.out.println(new UserInfoDaoImpl().login(new UserInfo(null,null,"test@p.p","test")));
    }

    @Test
    void login_() {
        System.out.println(new UserInfoDaoImpl().login(new UserInfo(null,null,"test@p.pp  ","test")));
    }
}