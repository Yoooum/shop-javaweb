package com.prprv.shop.pojo;


public class OrderGoods {

  private Integer id;
  private Integer uid;
  private Integer oid;
  private Integer amount;
  private double price;

  public OrderGoods() {
  }

  public OrderGoods(Integer id, Integer uid, Integer oid, Integer amount, double price) {
    this.id = id;
    this.uid = uid;
    this.oid = oid;
    this.amount = amount;
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Integer getOid() {
    return oid;
  }

  public void setOid(Integer oid) {
    this.oid = oid;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "OrderGoods{" +
            "id=" + id +
            ", uid=" + uid +
            ", oid=" + oid +
            ", amount=" + amount +
            ", price=" + price +
            '}';
  }
}
