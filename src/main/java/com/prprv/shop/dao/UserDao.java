package com.prprv.shop.dao;


/**
 * @author 未確認の庭師
 */
public class UserDao {
    /**
     * 用户注册，将用户信息存入数据库，
     * 需要传入一个UserInfo对象，包含用户的用户名，邮箱，密码
     * @param userInfo 用户信息：用户名，密码，邮箱
     * @return 影响行数或SQL错误码
     */
//    public int register(UserInfo userInfo) {
//        String sql = "insert into user_info(name,email,password) values(?,?,?)";
//        return new DBUtil().update(sql, userInfo.getName(), userInfo.getEmail(), userInfo.getPassword());
//    }

    /**
     * 用户登录，根据邮箱和密码查询数据库，返回查询结果
     * @param userInfo 用户信息：邮箱，密码
     * @return 查询结果
     */
//    public UserInfo login(UserInfo userInfo) {
//        String sql = "select uid,name,email,password from user_info where email = ? and password = ?";
//        ResultSet rs = new DBUtil().query(sql, userInfo.getEmail(), userInfo.getPassword());
//        try  {
//            if (rs.next()) {
//                UserInfo user = new UserInfo();
//                user.setUid(rs.getInt("uid"));
//                user.setName(rs.getString("name"));
//                user.setEmail(rs.getString("email"));
//                user.setPassword(rs.getString("password"));
//                return user;
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }

    /**
     * 根据用户邮箱查询是否以存在该用户
     * @param email 待查询的用户邮箱
     */
//    public void findEmail(String email) {
//        String sql = "select email from user_info where email = ?";
//        try  {
//            ResultSet rs = new DBUtil().query(sql, email);
//            if (rs.next()) {
//                System.out.println("邮箱已被注册");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    /**
     * 根据用户id删除用户
     * @param uid 用户id
     * @return 影响行数或SQL错误码
     */
//    public int delete(int uid) {
//        String sql = "delete from user_info where uid = ?";
//        return DBUtil.update(sql, uid);
//    }

    /**
     * 查询所有用户信息
     * @return 用户信息列表
     */
//    public List<UserInfo> selectAll() {
//        ResultSet rs = DBUtil.query("select * from user_info");
//        List<UserInfo> userList = new ArrayList<>();
//        try {
//            while (rs.next()) {
//                UserInfo userInfo = new UserInfo();
//                userInfo.setUid(rs.getInt("uid"));
//                userInfo.setName(rs.getString("name"));
//                userInfo.setEmail(rs.getString("email"));
//                userInfo.setPassword(rs.getString("password"));
//                userList.add(userInfo);
//                System.out.println(userInfo);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return userList;
//    }
}
