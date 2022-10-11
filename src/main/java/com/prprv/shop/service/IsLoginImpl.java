package com.prprv.shop.service;

import com.prprv.shop.dao.impl.AdminInfoDaoImpl;
import com.prprv.shop.dao.impl.UserInfoDaoImpl;
import com.prprv.shop.pojo.AdminInfo;
import com.prprv.shop.pojo.UserInfo;

import java.util.List;

/**
 * @author 未確認の庭師
 */
public class IsLoginImpl implements IsLogin {

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
    public boolean user(String email, String password) {
        List<UserInfo> list = new UserInfoDaoImpl().queryUserInfo();
        for (UserInfo userInfo : list) {
            if (userInfo.getEmail().equals(email) && userInfo.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
