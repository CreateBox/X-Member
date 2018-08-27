package com.manager.control.dept;

import com.manager.pojo.Dept;
import com.manager.service.dept.DeptService;
import com.manager.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DeptContorller {
    @Resource
    private DeptService deptService;

    @RequestMapping(value = "/deptAll",method = RequestMethod.POST)
    @ResponseBody
    public Object deptAll(){
        List<Dept> depts = deptService.deptAll();
        return depts;
    }
}
