package com.manager.pojo;


import java.util.Date;

public class Servicees {

    private Integer s_Id;
    private String s_Name;
    private DataDictionary s_Type;
    private DataDictionary s_Status;
    private Date s_LastTime;
    private Employees s_Operator;
    private Employees s_Processor;

    public Integer getS_Id() {
        return s_Id;
    }

    public void setS_Id(Integer s_Id) {
        this.s_Id = s_Id;
    }

    public String getS_Name() {
        return s_Name;
    }

    public void setS_Name(String s_Name) {
        this.s_Name = s_Name;
    }

    public DataDictionary getS_Type() {
        return s_Type;
    }

    public void setS_Type(DataDictionary s_Type) {
        this.s_Type = s_Type;
    }

    public DataDictionary getS_Status() {
        return s_Status;
    }

    public void setS_Status(DataDictionary s_Status) {
        this.s_Status = s_Status;
    }

    public Date getS_LastTime() {
        return s_LastTime;
    }

    public void setS_LastTime(Date s_LastTime) {
        this.s_LastTime = s_LastTime;
    }

    public Employees getS_Operator() {
        return s_Operator;
    }

    public void setS_Operator(Employees s_Operator) {
        this.s_Operator = s_Operator;
    }

    public Employees getS_Processor() {
        return s_Processor;
    }

    public void setS_Processor(Employees s_Processor) {
        this.s_Processor = s_Processor;
    }
}
