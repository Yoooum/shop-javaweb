package com.prprv.shop.dao.impl;

import com.prprv.shop.pojo.AdminInfo;
import com.prprv.shop.util.DBUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 未確認の庭師
 */
class AdminInfoDaoImplTest {

    @Test
    void getAdminInfoList_() {
        List<AdminInfo> userList = new AdminInfoDaoImpl().getAdminInfoList_("select * from admin_info");
        for(AdminInfo adminInfo : userList){
            System.out.println(adminInfo);
        }
        DBUtil.close();
    }

    @Test
    void getAdminInfoList() {
        List<AdminInfo> userList = new AdminInfoDaoImpl().getAdminInfoList("select * from admin_info");
        for(AdminInfo adminInfo : userList){
            System.out.println(adminInfo);
        }
    }

    @Test
    void addAdminInfo() {
        System.out.println(new AdminInfoDaoImpl().addAdminInfo(
                new AdminInfo(null,"test","pwd","普通")
        ));
    }

    @Test
    void updateAdminInfo() {
    }

    @Test
    void deleteAdminInfo() {
        System.out.println(new AdminInfoDaoImpl().deleteAdminInfo(4));
    }
}