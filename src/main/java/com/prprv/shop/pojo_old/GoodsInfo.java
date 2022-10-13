package com.prprv.shop.pojo_old;

import java.time.LocalDateTime;

/**
 * 商品信息
 */
public class GoodsInfo {
    private Integer gid;//商品id
    private String name;//商品名
    private Double price;//商品价格
    private String classify;//商品分类
    private Integer amount;//商品数量
    private LocalDateTime date;//商品上架时间
    private String imgUrl;//商品图片地址
    private Integer look;//商品浏览量
    private String intro;//商品说明
    private String brief;//商品简介

    public GoodsInfo() {
    }

    public GoodsInfo(String name, Double price, String classify, Integer amount, LocalDateTime date, String imgUrl, Integer look, String intro, String brief) {
        this.name = name;
        this.price = price;
        this.classify = classify;
        this.amount = amount;
        this.date = date;
        this.imgUrl = imgUrl;
        this.look = look;
        this.intro = intro;
        this.brief = brief;
    }

    public GoodsInfo(Integer gid, String name, Double price, String classify, Integer amount, LocalDateTime date, String imgUrl, Integer look, String intro, String brief) {
        this.gid = gid;
        this.name = name;
        this.price = price;
        this.classify = classify;
        this.amount = amount;
        this.date = date;
        this.imgUrl = imgUrl;
        this.look = look;
        this.intro = intro;
        this.brief = brief;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getLook() {
        return look;
    }

    public void setLook(Integer look) {
        this.look = look;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", classify='" + classify + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", imgUrl='" + imgUrl + '\'' +
                ", look=" + look +
                ", intro='" + intro + '\'' +
                ", brief='" + brief + '\'' +
                '}';
    }
}
