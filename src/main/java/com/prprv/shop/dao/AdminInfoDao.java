package com.prprv.shop.dao;

import com.prprv.shop.pojo.AdminInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 未確認の庭師
 */
public interface AdminInfoDao {
    //查
    List<AdminInfo> getAdminInfoList(String sql) throws SQLException;
    List<AdminInfo> queryAdminInfo(String sql, Object... params);
    //增
    int addAdminInfo(AdminInfo adminInfo);
    //改
    int updateAdminInfo(AdminInfo adminInfo);
    //删
    int deleteAdminInfo(int id);
}
