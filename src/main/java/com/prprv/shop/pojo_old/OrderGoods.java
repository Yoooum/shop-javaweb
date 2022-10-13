package com.prprv.shop.pojo_old;

/**
 * 订单商品信息
 */
public class OrderGoods {
    private Integer id;//订单商品id
    private Integer oid;//订单id
    private Integer gid;//商品id
    private Integer uid;//用户id
    private Integer amount;//商品数量
    private Double totalPrice;//商品总价

    public OrderGoods() {
    }

    public OrderGoods(Integer id, Integer oid, Integer gid, Integer uid, Integer amount, Double totalPrice) {
        this.id = id;
        this.oid = oid;
        this.gid = gid;
        this.uid = uid;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", oid=" + oid +
                ", gid=" + gid +
                ", uid=" + uid +
                ", amount=" + amount +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
