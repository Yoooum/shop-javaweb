package com.prprv.shop.dao.impl;

import com.prprv.shop.dao.UserInfoDao;
import com.prprv.shop.pojo_old.UserInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 未確認の庭師
 */
class UserInfoDaoImplTest {

    //全查1
    @Test
    void getUserList() {
        UserInfoDao infoDao = new UserInfoDaoImpl();
        List<UserInfo> userList = infoDao.getUserList();
        for (UserInfo list : userList){
            System.out.println(list);
        }
    }

    //全查2
    @Test
    void queryUserInfo() {
        List<UserInfo> list = new UserInfoDaoImpl().queryUserInfo(
                "select * from user_info");
        for (UserInfo userInfo : list) {
            System.out.println(userInfo);
        }
    }

    //条件查询
    @Test
    void queryUserInfo_() {
        List<UserInfo> list = new UserInfoDaoImpl().queryUserInfo(
                "select * from user_info where uid = ?", 10001);
        for (UserInfo userInfo : list) {
            System.out.println(userInfo);
        }
    }

    @Test
    void addUserInfo() {
        int result = new UserInfoDaoImpl().addUserInfo(
                new UserInfo("test","test@you","123")
        );
        if(result == 1){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    @Test
    void updateUserInfo() {
        int result = new UserInfoDaoImpl().updateUserInfo(
                new UserInfo(10023,"test1","test@you","123")
        );
        if(result == 1){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    @Test
    void deleteUserInfo() {
        int result = new UserInfoDaoImpl().deleteUserInfo(10023);
        if(result == 1){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    void login() {
        System.out.println(new UserInfoDaoImpl().login(new UserInfo(null,null,"test@p.p","test")));
    }

}