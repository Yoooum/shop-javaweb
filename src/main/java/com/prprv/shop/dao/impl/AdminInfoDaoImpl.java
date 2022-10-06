package com.prprv.shop.dao.impl;

import com.prprv.shop.dao.AdminInfoDao;
import com.prprv.shop.pojo.AdminInfo;
import com.prprv.shop.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminInfoDaoImpl implements AdminInfoDao {
    /**
     * 通过SQL语句查询管理员信息，自动关闭数据库连接
     * @param sql SQL语句
     * @return 管理员信息列表
     */
    @Override
    public List<AdminInfo> getAdminInfoList(String sql) {
        List<AdminInfo> adminInfoList = new ArrayList<>();
        List<Map<String, Object>> list = DBUtil.query(sql);
        for(Map<String,Object> map : list){
            AdminInfo adminInfo = new AdminInfo();
            adminInfo.setAid((Integer) map.get("aid"));
            adminInfo.setName((String) map.get("name"));
            adminInfo.setPassword((String) map.get("password"));
            adminInfo.setLevel((String) map.get("level"));
            adminInfoList.add(adminInfo);
        }
        return adminInfoList;
    }

    /**
     * 通过SQL语句查询管理员信息，需要手动关闭数据库连接
     * @param sql SQL语句
     * @return 管理员信息列表
     */
    public List<AdminInfo> getAdminInfoList_(String sql){
        List<AdminInfo> adminInfoList = new ArrayList<>();
        try (ResultSet resultSet = DBUtil.query_(sql)) {
            while (resultSet.next()){
                AdminInfo adminInfo = new AdminInfo();
                adminInfo.setAid(resultSet.getInt("aid"));
                adminInfo.setName(resultSet.getString("name"));
                adminInfo.setPassword(resultSet.getString("password"));
                adminInfo.setLevel(resultSet.getString("level"));
                adminInfoList.add(adminInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adminInfoList;
    }

    /**
     * 添加管理员信息
     * @param adminInfo 管理员信息，不需要设置id，id由数据库自动增长
     * @return 影响的行数
     */
    @Override
    public int addAdminInfo(AdminInfo adminInfo) {
        return DBUtil.update(
                "insert into admin_info(name,password,level) values(?,?,?)",
                adminInfo.getName(),
                adminInfo.getPassword(),
                adminInfo.getLevel()
        );
    }

    @Override
    public int updateAdminInfo(AdminInfo adminInfo) {
        return  DBUtil.update(
                "update admin_info set name = ?,password = ?,level = ? where aid = ?",
                adminInfo.getName(),
                adminInfo.getLevel(),
                adminInfo.getAid(),
                adminInfo.getAid()
        );
    }

    @Override
    public int deleteAdminInfo(int id) {
        return DBUtil.update("delete from admin_info where aid = ?", id);
    }
}
