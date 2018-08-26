package com.manager.util;

import com.manager.pojo.Employees;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static Employees get(HttpSession session) {
        Object loginEmployee = session.getAttribute("loginEmployee");
        if (null != loginEmployee)
            return (Employees) loginEmployee;
        return null;
    }
}
