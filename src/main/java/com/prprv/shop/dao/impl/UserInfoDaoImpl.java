package com.prprv.shop.dao.impl;

import com.prprv.shop.dao.UserInfoDao;
import com.prprv.shop.pojo_old.UserInfo;
import com.prprv.shop.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
public class UserInfoDaoImpl implements UserInfoDao {
    public List<UserInfo> login(String name, String password){
        String sql = "select * from user_info where name = ? and password = ?";
        List<Map<String,Object>> list = DBUtil.query(sql,name,password);
        return getUserList(list);
    }
    @Override
    public List<UserInfo> getUserList() {

        List<Map<String, Object>> mapList = DBUtil.query("select * from user_info");
        return getUserList(mapList);
    }

    public List<UserInfo> queryUserInfo() {
        List<Map<String, Object>> mapList = DBUtil.query("select * from user_info");
        return getUserList(mapList);
    }

    @Override
    public List<UserInfo> queryUserInfo(String sql, Object... params) {
        List<Map<String, Object>> mapList = DBUtil.query(sql, params);
        return getUserList(mapList);
    }

    private List<UserInfo> getUserList(List<Map<String, Object>> mapList) {
        List<UserInfo> users = new ArrayList<>();
        for(Map<String, Object> userMap : mapList){
            UserInfo userInfo = new UserInfo();
            userInfo.setUid((Integer) userMap.get("uid"));
            userInfo.setName((String) userMap.get("name"));
            userInfo.setEmail((String) userMap.get("email"));
            userInfo.setPassword((String) userMap.get("password"));
            users.add(userInfo);
        }
        return users;
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        UserInfo user = new UserInfo();
        List<Map<String, Object>> mapList = DBUtil.query("select uid,name,email,password from user_info where email = ? and password = ?",
                userInfo.getEmail(),userInfo.getPassword());
        for(Map<String,Object> userMap : mapList){
            user.setUid((Integer) userMap.get("uid"));
            user.setName((String) userMap.get("name"));
            user.setEmail((String) userMap.get("email"));
            user.setPassword((String) userMap.get("password"));
        }
        return user;
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return DBUtil.update("insert into user_info(name,email,password) values(?,?,?)",
                userInfo.getName(),userInfo.getEmail(),userInfo.getPassword()
        );
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return  DBUtil.update(
                "update user_info set name = ?,email = ?,password = ? where uid = ?",
                userInfo.getName(),userInfo.getEmail(),userInfo.getPassword(),userInfo.getUid()
        );
    }

    @Override
    public int deleteUserInfo(int id) {
        return DBUtil.update("delete from user_info where uid = ?", id);
    }
}
