package com.prprv.shop.dao;

import com.prprv.shop.pojo_old.GoodsInfo;

import java.util.List;

/**
 * @author 未確認の庭師
 */
public interface GoodsInfoDao {
    //查
    List<GoodsInfo> getGoodsInfoList();
    List<GoodsInfo> queryGoodsInfo(String sql, Object... params);
    //增
    int addGoodsInfo(GoodsInfo goodsInfo);
    //改
    int updateGoodsInfo(GoodsInfo goodsInfo);
    //删
    int deleteGoodsInfo(int id);
}
