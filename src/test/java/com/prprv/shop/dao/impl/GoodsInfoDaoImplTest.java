package com.prprv.shop.dao.impl;

import com.prprv.shop.pojo.GoodsInfo;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 未確認の庭師
 */
class GoodsInfoDaoImplTest {

    @Test
    void getGoodsInfoList() {
        new GoodsInfoDaoImpl().getGoodsInfoList().forEach(System.out::println);
    }

    @Test
    void queryGoodsInfoAll() {
        List<GoodsInfo> list = new GoodsInfoDaoImpl().queryGoodsInfo(
                "select * from goods_info");
        list.forEach(System.out::println);
    }

    @Test
    void queryGoodsInfo() {
        List<GoodsInfo> list = new GoodsInfoDaoImpl().queryGoodsInfo(
                "select * from goods_info where name like ?", "%test%");
        list.forEach(System.out::println);
    }

    @Test
    void addGoodsInfo() {
        System.out.println(new GoodsInfoDaoImpl().addGoodsInfo(new GoodsInfo(){
            {
                setName("test");
                setPrice(100.0);
                setClassify("test");
                setAmount(100);
                setDate(LocalDateTime.now());
                setImgUrl("http://test.jpg");
                setLook(100);
                setIntro("test");
                setBrief("test");
            }
        }));
    }

    @Test
    void updateGoodsInfo() {
        System.out.println(new GoodsInfoDaoImpl().updateGoodsInfo(new GoodsInfo(){
            {
                setGid(807200010);
                setName("test");
                setPrice(100.0);
                setClassify("test");
                setAmount(100);
                setDate(LocalDateTime.now());
                setImgUrl("http://test.jpg");
                setLook(100);
                setIntro("test");
                setBrief("test");
            }
        }));
    }

    @Test
    void deleteGoodsInfo() {
        System.out.println(new GoodsInfoDaoImpl().deleteGoodsInfo(807200012));
    }
}