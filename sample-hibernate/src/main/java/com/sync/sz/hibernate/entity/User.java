package com.sync.sz.hibernate.entity;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class User {

  private Integer uid;
  private String username;
  private String password;
  private String address;

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override public String toString() {
    return "User{" +
        "uid=" + uid +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
