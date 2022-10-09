package com.prprv.shop.util;

import com.prprv.shop.pojo.AdminInfo;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
class DBUtilTest {

    //select * from admin_info
//    @Test
//    void queryUser() {
//        List<Map<String, Object>> list = DBUtil.query("select * from admin_info");
//        for (Map<String,Object> map : list){
//            System.out.println(map);
//        }
//    }

//    @Test
//    void query() {
//        try (ResultSet rs = DBUtil.query("select * from admin_info")) {
//            try {
//                ResultSetMetaData metaData = rs.getMetaData();
//                int col = metaData.getColumnCount();
//                while (rs.next()) {
//                    for (int i = 1; i <= col; i++) {
//                        System.out.print(metaData.getColumnName(i) + ":" + rs.getObject(i) + "\t");
//                    }
//                    System.out.println();
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            DBUtil.close();
//        }
//    }

    @Test
    void update() {
        String sql = "update user_info set name = ? where uid = ?";
        int result = DBUtil.update(sql, "test", 10009);
        if (result == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        DBUtil.close();
    }

    @Test
    void close(){
        DBUtil.close();
    }


//    @Test
//    void resultList() {
//        List<Map<String, Object>> list = DBUtil.resultList("select * from admin_info");
//        for (Map<String, Object> map : list) {
//            AdminInfo adminInfo = new AdminInfo();
//            adminInfo.setAid((Integer) map.get("aid"));
//            adminInfo.setName((String) map.get("name"));
//            adminInfo.setPassword((String) map.get("password"));
//            adminInfo.setLevel((String) map.get("level"));
//            System.out.println(adminInfo);
//        }
//    }


}