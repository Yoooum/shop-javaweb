package com.prprv.shop.mapper;

import com.prprv.shop.pojo.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author 未確認の庭師
 */
public interface OrderMapper {
    void insertOrder(Order order);
    int deleteOrder(@Param("oid") Integer oid);
    int updateOrder(Order order);
    int selectOrderById(@Param("oid") Integer oid);

}
