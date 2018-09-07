package com.manager.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Customer {

    private Integer c_Id;
    private String c_Name;
    private Sex c_Sex;
    private DataDictionary c_Type;
    private DataDictionary c_Status;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date c_Entertime;
    private Employees c_Enteremp;
    private Integer c_Service;

    public Integer getC_Id() {
        return c_Id;
    }

    public void setC_Id(Integer c_Id) {
        this.c_Id = c_Id;
    }

    public String getC_Name() {
        return c_Name;
    }

    public void setC_Name(String c_Name) {
        this.c_Name = c_Name;
    }

    public Sex getC_Sex() {
        return c_Sex;
    }

    public void setC_Sex(Sex c_Sex) {
        this.c_Sex = c_Sex;
    }

    public DataDictionary getC_Type() {
        return c_Type;
    }

    public void setC_Type(DataDictionary c_Type) {
        this.c_Type = c_Type;
    }

    public DataDictionary getC_Status() {
        return c_Status;
    }

    public void setC_Status(DataDictionary c_Status) {
        this.c_Status = c_Status;
    }

    public Date getC_Entertime() {
        return c_Entertime;
    }

    public void setC_Entertime(Date c_Entertime) {
        this.c_Entertime = c_Entertime;
    }

    public Employees getC_Enteremp() {
        return c_Enteremp;
    }

    public void setC_Enteremp(Employees c_Enteremp) {
        this.c_Enteremp = c_Enteremp;
    }

    public Integer getC_Service() {
        return c_Service;
    }

    public void setC_Service(Integer c_Service) {
        this.c_Service = c_Service;
    }
}
