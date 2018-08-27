package com.manager.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DataDictionary {

    private Integer dd_Id;
    private String dd_TypeCode;
    private String dd_TypeName;
    private Integer dd_ValueId;
    private String dd_ValueName;
    private Employees dd_OperationId;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dd_LastTime;
    private String dd_Comment;

    public Integer getDd_Id() {
        return dd_Id;
    }

    public void setDd_Id(Integer dd_Id) {
        this.dd_Id = dd_Id;
    }

    public String getDd_TypeCode() {
        return dd_TypeCode;
    }

    public void setDd_TypeCode(String dd_TypeCode) {
        this.dd_TypeCode = dd_TypeCode;
    }

    public String getDd_TypeName() {
        return dd_TypeName;
    }

    public void setDd_TypeName(String dd_TypeName) {
        this.dd_TypeName = dd_TypeName;
    }

    public Integer getDd_ValueId() {
        return dd_ValueId;
    }

    public void setDd_ValueId(Integer dd_ValueId) {
        this.dd_ValueId = dd_ValueId;
    }

    public String getDd_ValueName() {
        return dd_ValueName;
    }

    public void setDd_ValueName(String dd_ValueName) {
        this.dd_ValueName = dd_ValueName;
    }

    public Employees getDd_OperationId() {
        return dd_OperationId;
    }

    public void setDd_OperationId(Employees dd_OperationId) {
        this.dd_OperationId = dd_OperationId;
    }

    public Date getDd_LastTime() {
        return dd_LastTime;
    }

    public void setDd_LastTime(Date dd_LastTime) {
        this.dd_LastTime = dd_LastTime;
    }

    public String getDd_Comment() {
        return dd_Comment;
    }

    public void setDd_Comment(String dd_Comment) {
        this.dd_Comment = dd_Comment;
    }
}
