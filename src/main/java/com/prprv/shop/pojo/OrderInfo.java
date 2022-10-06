package com.prprv.shop.pojo;

import java.util.Date;

/**
 * 订单信息
 */
public class OrderInfo {
    private Integer oid;//订单id
    private Date date;//订单时间
    private Integer aid;//管理员id
    private String state;//订单状态
    private String name;//收货人姓名
    private String address;//收货人地址
    private String telephone;//收货人电话
    private Integer uid;//用户id
    private Double totalPrice;//订单总价

    public OrderInfo() {
    }

    public OrderInfo(Integer oid, Date date, Integer aid, String state, String name, String address, String telephone, Integer uid, Double totalPrice) {
        this.oid = oid;
        this.date = date;
        this.aid = aid;
        this.state = state;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.uid = uid;
        this.totalPrice = totalPrice;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "oid=" + oid +
                ", date=" + date +
                ", aid=" + aid +
                ", state='" + state + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", uid=" + uid +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
