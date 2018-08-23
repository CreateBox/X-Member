package com.manager.pojo;


import java.util.Date;

public class Orders {

    private Integer o_Id;
    private DataDictionary o_Type;
    private String o_Commodity;
    private Customer o_Customer;
    private Double o_Price;
    private Date o_Time;
    private DataDictionary o_Status;

    public Integer getO_Id() {
        return o_Id;
    }

    public void setO_Id(Integer o_Id) {
        this.o_Id = o_Id;
    }

    public DataDictionary getO_Type() {
        return o_Type;
    }

    public void setO_Type(DataDictionary o_Type) {
        this.o_Type = o_Type;
    }

    public String getO_Commodity() {
        return o_Commodity;
    }

    public void setO_Commodity(String o_Commodity) {
        this.o_Commodity = o_Commodity;
    }

    public Customer getO_Customer() {
        return o_Customer;
    }

    public void setO_Customer(Customer o_Customer) {
        this.o_Customer = o_Customer;
    }

    public Double getO_Price() {
        return o_Price;
    }

    public void setO_Price(Double o_Price) {
        this.o_Price = o_Price;
    }

    public Date getO_Time() {
        return o_Time;
    }

    public void setO_Time(Date o_Time) {
        this.o_Time = o_Time;
    }

    public DataDictionary getO_Status() {
        return o_Status;
    }

    public void setO_Status(DataDictionary o_Status) {
        this.o_Status = o_Status;
    }
}
