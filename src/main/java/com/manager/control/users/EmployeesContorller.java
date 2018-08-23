package com.manager.control.users;

import com.manager.pojo.Employees;
import com.manager.service.users.EmployeesService;
import com.manager.util.MD5Util;
import com.manager.util.PwdUtil;
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
    private EmployeesService employeesService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object loginajax(HttpSession session, Employees employees) {
        Map<String, String> map = new HashMap<>();
        Employees employee = employeesService.getEmployees(employees);
        if (employee != null) {
            String pwd = MD5Util.EncoderByMd5(employees.getE_Pwd());
            if (pwd.equals(employee.getE_Pwd())) {
                session.setAttribute("loginEmployee", employee);
                employee.setE_LastLoginTime(new Date());
                employeesService.alterEmployees(employee);
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

    @RequestMapping(value = "/modifyEmployees", method = RequestMethod.POST )
    @ResponseBody
    public Object modifyEmployees(Employees employees){
        int i = employeesService.alterEmployees(employees);
        if(i==1){
            return "true";
        }else{
            return "false";
        }
    }

    @RequestMapping(value = "modifyPwd",method = RequestMethod.POST)
    @ResponseBody
    public Object modifyPwd(HttpSession session,PwdUtil pwd){
        int result = 0;
        Employees employees = employeesService.getEmployees(new Employees(pwd.getLoginName()));
        if(employees.getE_Pwd().equals(MD5Util.EncoderByMd5(pwd.getOldPwd()))){
            if(pwd.getNewPwd().equals(pwd.getConfirmNewPwd())){
                employees.setE_Pwd(MD5Util.EncoderByMd5(pwd.getConfirmNewPwd()));
                result = employeesService.alterEmployees(employees);
                if(result==1){
                    session.invalidate();
                    return "true";
                }else{
                    return "false";
                }
            }else{
                return "Don't match";
            }
        }else{
            return "error";
        }

    }
}
