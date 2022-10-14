package com.prprv.shop.mapper;

import com.prprv.shop.pojo.OrderGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 未確認の庭師
 */
public interface OrderGoodsMapper {
    void insertOrderGoods(OrderGoods orderGoods);
    int deleteOrderGoods(@Param("id") Integer id);
    int updateOrderGoods(OrderGoods orderGoods);
    //通过主键id查
    OrderGoods selectOrderGoodsById(@Param("id") Integer id);
    //通过用户id查该用户所有订单
    List<OrderGoods> selectOrderGoodsByUid(@Param("uid") Integer uid);
}
