package com.lottery.pojo;

import java.util.Date;

public class Users {

  private Integer id;
  private String name;
  private String password;
  private String realityName;
  private String sex;
  private Date birthDay;
  private String idCardNumber;
  private String address;
  private String email;
  private String qq;
  private String telephone;
  private String mobile;
  private Date registerTime;
  private Date lastLoginTime;
  private Integer loginCount;
  private Integer userType;
  private String payName;
  private String payCardNumber;
  private double balance;
  private double freeze;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getRealityName() {
    return realityName;
  }

  public void setRealityName(String realityName) {
    this.realityName = realityName;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }

  public String getIdCardNumber() {
    return idCardNumber;
  }

  public void setIdCardNumber(String idCardNumber) {
    this.idCardNumber = idCardNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public Date getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(Date registerTime) {
    this.registerTime = registerTime;
  }

  public Integer getLoginCount() {
    return loginCount;
  }

  public void setLoginCount(Integer loginCount) {
    this.loginCount = loginCount;
  }

  public Integer getUserType() {
    return userType;
  }

  public void setUserType(Integer userType) {
    this.userType = userType;
  }

  public String getPayName() {
    return payName;
  }

  public void setPayName(String payName) {
    this.payName = payName;
  }

  public String getPayCardNumber() {
    return payCardNumber;
  }

  public void setPayCardNumber(String payCardNumber) {
    this.payCardNumber = payCardNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getFreeze() {
    return freeze;
  }

  public void setFreeze(double freeze) {
    this.freeze = freeze;
  }
}
