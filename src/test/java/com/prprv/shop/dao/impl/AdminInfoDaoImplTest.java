package com.prprv.shop.dao.impl;

import com.prprv.shop.pojo.AdminInfo;
import com.prprv.shop.util.DBUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 未確認の庭師
 */
class AdminInfoDaoImplTest {

    //全查1，需要手动关闭数据库连接
    @Test
    void getAdminInfoList_() {
        List<AdminInfo> userList = new AdminInfoDaoImpl().getAdminInfoList_("select * from admin_info");
        for(AdminInfo adminInfo : userList){
            System.out.println(adminInfo);
        }
        DBUtil.close();
    }
    //全查2
    @Test
    void getAdminInfoList() {
        List<AdminInfo> userList = new AdminInfoDaoImpl().getAdminInfoList("select * from admin_info");
        for(AdminInfo adminInfo : userList){
            System.out.println(adminInfo);
        }
    }

    //条件查询
    @Test
    void queryAdminInfo() {
        List<AdminInfo> list = new AdminInfoDaoImpl().queryAdminInfo("select * from admin_info where aid = ?", 10001);
        list.forEach(System.out::println);
    }
    @Test
    void addAdminInfo() {
        System.out.println(new AdminInfoDaoImpl().addAdminInfo(
                new AdminInfo("test","pwd","普通")
        ));
    }

    @Test
    void updateAdminInfo() {
        System.out.println(new AdminInfoDaoImpl().updateAdminInfo(
                new AdminInfo(5,"test","pwd","超级")
        ));

    }

    @Test
    void deleteAdminInfo() {
        System.out.println(new AdminInfoDaoImpl().deleteAdminInfo(5));
    }
}