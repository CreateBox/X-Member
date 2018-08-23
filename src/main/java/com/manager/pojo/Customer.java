package com.manager.pojo;


import java.util.Date;

public class Customer {

    private Integer c_Id;
    private String c_Name;
    private DataDictionary c_Sex;
    private DataDictionary c_Type;
    private DataDictionary c_Status;
    private DataDictionary c_Allot;
    private Date c_Entertime;
    private Double c_Enteremp;
    private Servicees c_Service;

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

    public DataDictionary getC_Sex() {
        return c_Sex;
    }

    public void setC_Sex(DataDictionary c_Sex) {
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

    public DataDictionary getC_Allot() {
        return c_Allot;
    }

    public void setC_Allot(DataDictionary c_Allot) {
        this.c_Allot = c_Allot;
    }

    public Date getC_Entertime() {
        return c_Entertime;
    }

    public void setC_Entertime(Date c_Entertime) {
        this.c_Entertime = c_Entertime;
    }

    public Double getC_Enteremp() {
        return c_Enteremp;
    }

    public void setC_Enteremp(Double c_Enteremp) {
        this.c_Enteremp = c_Enteremp;
    }

    public Servicees getC_Service() {
        return c_Service;
    }

    public void setC_Service(Servicees c_Service) {
        this.c_Service = c_Service;
    }
}
