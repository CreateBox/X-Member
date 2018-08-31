package com.manager.pojo;

import java.util.Date;

public class Serviceback {

    private Integer sb_Id;
    private Integer sb_Ser;
    private Date sb_LastTime;
    private Integer sb_Operator;
    private String sb_Info;

    public Integer getSb_Id() {
        return sb_Id;
    }

    public void setSb_Id(Integer sb_Id) {
        this.sb_Id = sb_Id;
    }

    public Integer getSb_Ser() {
        return sb_Ser;
    }

    public void setSb_Ser(Integer sb_Ser) {
        this.sb_Ser = sb_Ser;
    }

    public Date getSb_LastTime() {
        return sb_LastTime;
    }

    public void setSb_LastTime(Date sb_LastTime) {
        this.sb_LastTime = sb_LastTime;
    }

    public Integer getSb_Operator() {
        return sb_Operator;
    }

    public void setSb_Operator(Integer sb_Operator) {
        this.sb_Operator = sb_Operator;
    }

    public String getSb_Info() {
        return sb_Info;
    }

    public void setSb_Info(String sb_Info) {
        this.sb_Info = sb_Info;
    }
}
