package com.manager.pojo;


import java.util.Date;

public class Serviceprocess {

    private Integer sp_Id;
    private Integer sp_Ser;
    private Date sp_LastTime;
    private Integer sp_Operator;
    private String sp_Info;

    public Integer getSp_Id() {
        return sp_Id;
    }

    public void setSp_Id(Integer sp_Id) {
        this.sp_Id = sp_Id;
    }

    public Integer getSp_Ser() {
        return sp_Ser;
    }

    public void setSp_Ser(Integer sp_Ser) {
        this.sp_Ser = sp_Ser;
    }

    public Date getSp_LastTime() {
        return sp_LastTime;
    }

    public void setSp_LastTime(Date sp_LastTime) {
        this.sp_LastTime = sp_LastTime;
    }

    public Integer getSp_Operator() {
        return sp_Operator;
    }

    public void setSp_Operator(Integer sp_Operator) {
        this.sp_Operator = sp_Operator;
    }

    public String getSp_Info() {
        return sp_Info;
    }

    public void setSp_Info(String sp_Info) {
        this.sp_Info = sp_Info;
    }
}
