package com.manager.pojo;


import java.util.Date;

public class Employees {

    private Integer e_Id;
    private String e_LoginName;
    private String e_Pwd;
    private String e_RealName;
    private Integer e_Sex;
    private String e_Phone;
    private Role e_Role;
    private Dept e_DeptId;
    private Integer e_Status;
    private Date e_CreateTime;
    private Employees e_ModifyId;
    private Date e_ModifyTime;
    private String e_Description;
    private Date e_LastLoginTime;

    public Date getE_LastLoginTime() {
        return e_LastLoginTime;
    }

    public void setE_LastLoginTime(Date e_LastLoginTime) {
        this.e_LastLoginTime = e_LastLoginTime;
    }

    public Integer getE_Id() {
        return e_Id;
    }

    public void setE_Id(Integer e_Id) {
        this.e_Id = e_Id;
    }

    public String getE_LoginName() {
        return e_LoginName;
    }

    public void setE_LoginName(String e_LoginName) {
        this.e_LoginName = e_LoginName;
    }

    public String getE_Pwd() {
        return e_Pwd;
    }

    public void setE_Pwd(String e_Pwd) {
        this.e_Pwd = e_Pwd;
    }

    public String getE_RealName() {
        return e_RealName;
    }

    public void setE_RealName(String e_RealName) {
        this.e_RealName = e_RealName;
    }

    public Integer getE_Sex() {
        return e_Sex;
    }

    public void setE_Sex(Integer e_Sex) {
        this.e_Sex = e_Sex;
    }

    public String getE_Phone() {
        return e_Phone;
    }

    public void setE_Phone(String e_Phone) {
        this.e_Phone = e_Phone;
    }

    public Role getE_Role() {
        return e_Role;
    }

    public void setE_Role(Role e_Role) {
        this.e_Role = e_Role;
    }

    public Dept getE_DeptId() {
        return e_DeptId;
    }

    public void setE_DeptId(Dept e_DeptId) {
        this.e_DeptId = e_DeptId;
    }

    public Integer getE_Status() {
        return e_Status;
    }

    public void setE_Status(Integer e_Status) {
        this.e_Status = e_Status;
    }

    public Date getE_CreateTime() {
        return e_CreateTime;
    }

    public void setE_CreateTime(Date e_CreateTime) {
        this.e_CreateTime = e_CreateTime;
    }

    public Employees getE_ModifyId() {
        return e_ModifyId;
    }

    public void setE_ModifyId(Employees e_ModifyId) {
        this.e_ModifyId = e_ModifyId;
    }

    public Date getE_ModifyTime() {
        return e_ModifyTime;
    }

    public void setE_ModifyTime(Date e_ModifyTime) {
        this.e_ModifyTime = e_ModifyTime;
    }

    public String getE_Description() {
        return e_Description;
    }

    public void setE_Description(String e_Description) {
        this.e_Description = e_Description;
    }
}
