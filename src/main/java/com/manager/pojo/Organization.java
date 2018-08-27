package com.manager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Organization {

  private Integer o_Id;
  private String o_Code;
  private String o_Name;
  private String o_FullName;
  private Dept o_DeptNo;
  private Employees o_ModifyId;
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Date o_ModifyTime;
  private String o_Description;

  public Organization(){}

  public Organization(Integer id){
    this.o_Id = id;
  }

  public String getO_Code() {
    return o_Code;
  }

  public void setO_Code(String o_Code) {
    this.o_Code = o_Code;
  }

  public Integer getO_Id() {
    return o_Id;
  }

  public void setO_Id(Integer o_Id) {
    this.o_Id = o_Id;
  }

  public String getO_Name() {
    return o_Name;
  }

  public void setO_Name(String o_Name) {
    this.o_Name = o_Name;
  }

  public String getO_FullName() {
    return o_FullName;
  }

  public void setO_FullName(String o_FullName) {
    this.o_FullName = o_FullName;
  }

  public Dept getO_DeptNo() {
    return o_DeptNo;
  }

  public void setO_DeptNo(Dept o_DeptNo) {
    this.o_DeptNo = o_DeptNo;
  }

  public Employees getO_ModifyId() {
    return o_ModifyId;
  }

  public void setO_ModifyId(Employees o_ModifyId) {
    this.o_ModifyId = o_ModifyId;
  }

  public Date getO_ModifyTime() {
    return o_ModifyTime;
  }

  public void setO_ModifyTime(Date o_ModifyTime) {
    this.o_ModifyTime = o_ModifyTime;
  }

  public String getO_Description() {
    return o_Description;
  }

  public void setO_Description(String o_Description) {
    this.o_Description = o_Description;
  }
}
