package com.prprv.shop.pojo;


import java.time.LocalDateTime;

public class Goods {

  private Integer gid;
  private String name;
  private double price;
  private String classify;
  private Integer amount;
  private LocalDateTime date;
  private String img;
  private Integer look;
  private String intro;
  private String brief;

  public Goods() {
  }

  public Goods(Integer gid, String name, double price, String classify, Integer amount, LocalDateTime date, String img, Integer look, String intro, String brief) {
    this.gid = gid;
    this.name = name;
    this.price = price;
    this.classify = classify;
    this.amount = amount;
    this.date = date;
    this.img = img;
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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
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

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
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
    return "Goods{" +
            "gid=" + gid +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", classify='" + classify + '\'' +
            ", amount=" + amount +
            ", date=" + date +
            ", img='" + img + '\'' +
            ", look=" + look +
            ", intro='" + intro + '\'' +
            ", brief='" + brief + '\'' +
            '}';
  }
}
