package com.prprv.shop.mapper;

import com.prprv.shop.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
public interface UserMapper {
    //新增用户，同时返回自增的主键 uid 到 user 对象
    void insertUser(User user);
    //通过 uid 删除用户
    int deleteUser(@Param("uid") Integer uid);
    //修改
    Boolean updateUser(User user);
    //通过id查
    User selectUserById(@Param("uid") Integer uid);
    //通过邮箱查，数据库为唯一值
    User selectUserByEmail(@Param("email") String email);
    //通过name查，可能同名，使用List
    List<User> selectUserByName(@Param("username") String username);
    //查单个用户
    User checkLogin(@Param("email") String email, @Param("password") String password);
    //查所有用户
    List<User> selectAllUser();
    //查所有用户，放进Map
    @MapKey("uid")
    Map<String, Object> selectAllUserToMap();
}
