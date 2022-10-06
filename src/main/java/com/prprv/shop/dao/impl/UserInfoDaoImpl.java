package com.prprv.shop.dao.impl;

import com.prprv.shop.dao.UserInfoDao;
import com.prprv.shop.pojo.UserInfo;
import com.prprv.shop.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
public class UserInfoDaoImpl implements UserInfoDao {
    @Override
    public List<UserInfo> getUserList() {
        List<UserInfo> users = new ArrayList<>();
        List<Map<String, Object>> mapList = DBUtil.query("select * from admin_info");
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

    public UserInfo login_(UserInfo userInfo){
        UserInfo user = new UserInfo();
        try (ResultSet resultSet = DBUtil.query_("select uid,name,email,password from user_info where email = ? and password = ?",
                userInfo.getEmail(),userInfo.getPassword())) {
            while (resultSet.next()){
                user.setUid(resultSet.getInt("uid"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    @Override
    public int addUserInfo(UserInfo userInfo) {
        return DBUtil.update("insert into admin_info(name,email,password) values(?,?,?)",
                userInfo.getName(),userInfo.getEmail(),userInfo.getPassword()
        );
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return  DBUtil.update(
                "update user_info set name = ?,email = ?,password = ? where uid = ?",
                userInfo.getName(),userInfo.getEmail(),userInfo.getPassword()
        );
    }

    @Override
    public int deleteUserInfo(int id) {
        return DBUtil.update("delete from user_info where uid = ?", id);
    }
}
