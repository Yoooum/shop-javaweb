package com.prprv.shop.service.impl;

import com.prprv.shop.dao.impl.AdminInfoDaoImpl;
import com.prprv.shop.dao.impl.UserInfoDaoImpl;
import com.prprv.shop.pojo_old.AdminInfo;
import com.prprv.shop.pojo_old.UserInfo;
import com.prprv.shop.service.Login;

import java.util.List;

/**
 * @author 未確認の庭師
 */
public class LoginImpl implements Login {

    @Override
    public boolean admin(String name, String password) {
        List<AdminInfo> list = new AdminInfoDaoImpl().queryAdminInfo();
        for (AdminInfo adminInfo : list){
            if(adminInfo.getName().equals(name) && adminInfo.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasUser(String email, String password) {
        List<UserInfo> list = new UserInfoDaoImpl().queryUserInfo();
        for (UserInfo userInfo : list) {
            if (userInfo.getEmail().equals(email) && userInfo.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserInfo getUserInfo(String email) {
        List<UserInfo> list = new UserInfoDaoImpl().queryUserInfo();
        for (UserInfo info : list) {
            if (info.getEmail().equals(email)) {
                return info;
            }
        }
        return null;
    }
}
