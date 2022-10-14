package com.prprv.shop.pojo;

public class User {
  private Integer uid;
  private String email;
  private String username;
  private String password;
  private Boolean is_admin;

  public User() {
  }

  public User(Integer uid, String email, String username, String password, Boolean is_admin) {
    this.uid = uid;
    this.email = email;
    this.username = username;
    this.password = password;
    this.is_admin = is_admin;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getAdmin() {
    return is_admin;
  }

  public void setAdmin(Boolean is_admin) {
    this.is_admin = is_admin;
  }

  @Override
  public String toString() {
    return "User{" +
            "uid=" + uid +
            ", email='" + email + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", is_admin=" + is_admin +
            '}';
  }
}
