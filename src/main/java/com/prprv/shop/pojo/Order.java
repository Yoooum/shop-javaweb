package com.prprv.shop.pojo;


import java.time.LocalDateTime;

public class Order {

  private Integer oid;
  private Integer uid;
  private String status;
  private LocalDateTime date;
  private String phone;
  private double price;
  private String address;

  public Order() {
  }

  public Order(Integer oid, Integer uid, String status, LocalDateTime date, String phone, double price, String address) {
    this.oid = oid;
    this.uid = uid;
    this.status = status;
    this.date = date;
    this.phone = phone;
    this.price = price;
    this.address = address;
  }

  public Integer getOid() {
    return oid;
  }

  public void setOid(Integer oid) {
    this.oid = oid;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Order{" +
            "oid=" + oid +
            ", uid=" + uid +
            ", status='" + status + '\'' +
            ", date=" + date +
            ", phone='" + phone + '\'' +
            ", price=" + price +
            ", address='" + address + '\'' +
            '}';
  }
}
