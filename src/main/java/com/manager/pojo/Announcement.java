package com.manager.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Announcement {

    private Integer t_Id;     //公告编码
    private String t_Title;    //公告标题
    private Integer t_Type;   //公告类型
    private Integer t_Name;   //发布人
    private String t_Content;  //公告内容
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date t_Date;     //发布时间

    public Integer getT_Id() {
        return t_Id;
    }

    public void setT_Id(Integer t_Id) {
        this.t_Id = t_Id;
    }

    public String getT_Title() {
        return t_Title;
    }

    public void setT_Title(String t_Title) {
        this.t_Title = t_Title;
    }

    public Integer getT_Type() {
        return t_Type;
    }

    public void setT_Type(Integer t_Type) {
        this.t_Type = t_Type;
    }

    public Integer getT_Name() {
        return t_Name;
    }

    public void setT_Name(Integer t_Name) {
        this.t_Name = t_Name;
    }

    public String getT_Content() {
        return t_Content;
    }

    public void setT_Content(String t_Content) {
        this.t_Content = t_Content;
    }

    public Date getT_Date() {
        return t_Date;
    }

    public void setT_Date(Date t_Date) {
        this.t_Date = t_Date;
    }

}
