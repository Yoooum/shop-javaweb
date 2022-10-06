package com.prprv.shop.pojo;

/**
 * 管理员信息
 */
public class AdminInfo {
    private Integer aid;//管理员id
    private String name;//管理员名
    private String password;//管理员密码
    private String level;//管理员等级

    public AdminInfo() {
    }

    public AdminInfo(Integer aid, String name, String password, String level) {
        this.aid = aid;
        this.name = name;
        this.password = password;
        this.level = level;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
