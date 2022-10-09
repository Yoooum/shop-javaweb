package com.prprv.shop.dao.impl;

import com.prprv.shop.dao.GoodsInfoDao;
import com.prprv.shop.pojo.GoodsInfo;
import com.prprv.shop.util.DBUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
public class GoodsInfoDaoImpl implements GoodsInfoDao {
    /**
     * 全查
     * @return 商品信息列表
     */
    @Override
    public List<GoodsInfo> getGoodsInfoList() {
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        List<Map<String,Object>> list = DBUtil.query("select * from goods_info");
        return getGoodsList(goodsInfoList, list);
    }

    /**
     * 根据条件查询商品
     * @param sql SQL语句
     * @param params SQL参数
     * @return 商品信息列表
     */
    @Override
    public List<GoodsInfo> queryGoodsInfo(String sql, Object... params) {
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        List<Map<String,Object>> list = DBUtil.query(sql,params);
        return getGoodsList(goodsInfoList, list);
    }

    /**
     * 从数据库中查询出来的数据转换成GoodsInfo对象
     * @param goodsInfoList 用于存放GoodsInfo对象的集合
     * @param list 从数据库中查询出来的数据
     * @return GoodsInfo对象的集合
     */
    private List<GoodsInfo> getGoodsList(List<GoodsInfo> goodsInfoList, List<Map<String, Object>> list) {
        for(Map<String,Object> map : list){
            GoodsInfo goodsInfo = new GoodsInfo();
            goodsInfo.setGid((Integer) map.get("gid"));
            goodsInfo.setName((String) map.get("name"));
            goodsInfo.setPrice((Double) map.get("price"));
            goodsInfo.setClassify((String) map.get("classify"));
            goodsInfo.setAmount((Integer) map.get("amount"));
            goodsInfo.setDate((LocalDateTime) map.get("date"));
            goodsInfo.setImgUrl((String) map.get("img_url"));
            goodsInfo.setLook((Integer) map.get("look"));
            goodsInfo.setIntro((String) map.get("intro"));
            goodsInfo.setBrief((String) map.get("brief"));
            goodsInfoList.add(goodsInfo);
        }
        return goodsInfoList;
    }

    /**
     * 添加商品
     * @param goodsInfo 商品信息对象
     * @return 影响的行数
     */
    @Override
    public int addGoodsInfo(GoodsInfo goodsInfo) {
        String sql = "insert into goods_info(name,price,classify,amount,date,img_url,look,intro,brief) values(?,?,?,?,?,?,?,?,?)";
        return DBUtil.update(sql,
                goodsInfo.getName(),goodsInfo.getPrice(),
                goodsInfo.getClassify(),goodsInfo.getAmount(),
                goodsInfo.getDate(),goodsInfo.getImgUrl(),
                goodsInfo.getLook(),goodsInfo.getIntro(),
                goodsInfo.getBrief());
    }

    /**
     * 修改商品信息
     * @param goodsInfo 商品信息对象
     * @return 影响的行数
     */
    @Override
    public int updateGoodsInfo(GoodsInfo goodsInfo) {
        String sql = "update goods_info set name=?,price=?,classify=?,amount=?,date=?,img_url=?,look=?,intro=?,brief=? where gid=?";
        return DBUtil.update(sql,
                goodsInfo.getName(),goodsInfo.getPrice(),
                goodsInfo.getClassify(),goodsInfo.getAmount(),
                goodsInfo.getDate(),goodsInfo.getImgUrl(),
                goodsInfo.getLook(),goodsInfo.getIntro(),
                goodsInfo.getBrief(),goodsInfo.getGid());
    }

    /**
     * 删除商品
     * @param id 商品id
     * @return 影响的行数
     */
    @Override
    public int deleteGoodsInfo(int id) {
        String sql = "delete from goods_info where gid=?";
        return DBUtil.update(sql,id);
    }
}
