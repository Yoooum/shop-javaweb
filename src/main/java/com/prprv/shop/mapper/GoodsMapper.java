package com.prprv.shop.mapper;

import com.prprv.shop.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 未確認の庭師
 */
public interface GoodsMapper {
    //新增商品，同时返回自增的主键 gid 到 goods 对象
    void insertGoods(Goods goods);
    //通过 gid 删除商品
    int deleteGoods(@Param("gid") Integer gid);
    //修改
    int updateGoods(Goods goods);
    //通过主键id查
    Goods selectGoodsById(@Param("gid") Integer gid);
    //通过商品名查，可能同名，使用List
    List<Goods> selectGoodsByName(@Param("name") String name);
    //查所有商品
    List<Goods> selectAllGoods();
}
