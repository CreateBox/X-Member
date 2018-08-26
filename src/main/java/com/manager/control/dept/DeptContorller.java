package com.manager.control.dept;

import com.manager.pojo.Dept;
import com.manager.service.dept.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DeptContorller {
    @Resource
    private DeptService deptService;

    @RequestMapping(value = "/deptList",method = RequestMethod.POST)
    @ResponseBody
    public Object deptList(){
        List<Dept> depts = deptService.deptAll();
        return depts;
    }
}
