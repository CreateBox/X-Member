package com.manager.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Role {

    private Integer r_Id;
    private String r_Code;
    private String r_Name;
    private Dept r_DeptNo;
    private Employees r_ModifyId;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date r_ModifyTime;
    private String r_Description;

    public Role(){

    }

    public Role(Integer id){
        this.r_Id = id;
    }

    public Integer getR_Id() {
        return r_Id;
    }

    public void setR_Id(Integer r_Id) {
        this.r_Id = r_Id;
    }

    public String getR_Code() {
        return r_Code;
    }

    public void setR_Code(String r_Code) {
        this.r_Code = r_Code;
    }

    public String getR_Name() {
        return r_Name;
    }

    public void setR_Name(String r_Name) {
        this.r_Name = r_Name;
    }

    public Dept getR_DeptNo() {
        return r_DeptNo;
    }

    public void setR_DeptNo(Dept r_DeptNo) {
        this.r_DeptNo = r_DeptNo;
    }

    public Employees getR_ModifyId() {
        return r_ModifyId;
    }

    public void setR_ModifyId(Employees r_ModifyId) {
        this.r_ModifyId = r_ModifyId;
    }

    public Date getR_ModifyTime() {
        return r_ModifyTime;
    }

    public void setR_ModifyTime(Date r_ModifyTime) {
        this.r_ModifyTime = r_ModifyTime;
    }

    public String getR_Description() {
        return r_Description;
    }

    public void setR_Description(String r_Description) {
        this.r_Description = r_Description;
    }
}
