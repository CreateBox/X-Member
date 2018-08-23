package com.manager.pojo;


import java.util.Date;

public class ServiceFaq {

    private Integer sf_Id;
    private String sf_Title;
    private DataDictionary sf_Type;
    private DataDictionary sf_Create;
    private Date sf_LastTime;

    public Integer getSf_Id() {
        return sf_Id;
    }

    public void setSf_Id(Integer sf_Id) {
        this.sf_Id = sf_Id;
    }

    public String getSf_Title() {
        return sf_Title;
    }

    public void setSf_Title(String sf_Title) {
        this.sf_Title = sf_Title;
    }

    public DataDictionary getSf_Type() {
        return sf_Type;
    }

    public void setSf_Type(DataDictionary sf_Type) {
        this.sf_Type = sf_Type;
    }

    public DataDictionary getSf_Create() {
        return sf_Create;
    }

    public void setSf_Create(DataDictionary sf_Create) {
        this.sf_Create = sf_Create;
    }

    public Date getSf_LastTime() {
        return sf_LastTime;
    }

    public void setSf_LastTime(Date sf_LastTime) {
        this.sf_LastTime = sf_LastTime;
    }
}
