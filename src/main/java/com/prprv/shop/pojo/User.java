package com.prprv.shop.pojo;

public class User {
  private Integer uid;
  private String email;
  private String username;
  private String password;
  private Boolean isAdmin;

  public User() {
  }

  public User(Integer uid, String email, String username, String password, Boolean isAdmin) {
    this.uid = uid;
    this.email = email;
    this.username = username;
    this.password = password;
    this.isAdmin = isAdmin;
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
    return isAdmin;
  }

  public void setAdmin(Boolean admin) {
    isAdmin = admin;
  }

  @Override
  public String toString() {
    return "User{" +
            "uid=" + uid +
            ", email='" + email + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", isAdmin=" + isAdmin +
            '}';
  }
}
