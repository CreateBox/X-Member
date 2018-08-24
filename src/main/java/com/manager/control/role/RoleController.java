package com.manager.control.role;

import com.manager.pojo.Role;
import com.manager.service.role.RoleService;
import com.manager.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RoleController {
    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/roleList",method = RequestMethod.POST)
    @ResponseBody
    public Object roleList(@RequestParam(name = "draw",required = false,defaultValue = "0")int draw,
                           @RequestParam(name = "start",required = false,defaultValue = "0")int start,
                           @RequestParam(name = "length",required = false,defaultValue = "0")int length){
        PageUtil<Role> pageUtil = new PageUtil<Role>();
        int count = roleService.count(new Role());
        List<Role> roles = roleService.roleList(new Role());
        pageUtil.setData(roles);
        pageUtil.setDraw(draw);
        pageUtil.setRecordsFiltered(count);
        pageUtil.setRecordsTotal(count);
        return pageUtil;
    }
}
