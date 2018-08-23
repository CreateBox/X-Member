package com.manager.control.users;

import com.manager.pojo.Employees;
import com.manager.service.users.EmployeesService;
import com.manager.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeesContorller {
    @Resource
    private EmployeesService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object loginajax(HttpSession session, Employees employees) {
        Map<String, String> map = new HashMap<>();
        Employees Employee = usersService.getEmployees(employees);
        if (Employee != null) {
            String pwd = MD5Util.EncoderByMd5(employees.getE_Pwd());
            if (pwd.equals(Employee.getE_Pwd())) {
                session.setAttribute("loginEmployee", Employee);
                Employee.setE_LastLoginTime(new Date());
                usersService.alterEmployees(Employee);
            } else {
                map.put("msg", "false");
            }
        } else {
            map.put("msg", "null");
        }
        return map;
    }

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/userOut")
    public String userOut(HttpSession session) {
        session.invalidate();
        return "login";
    }

}
