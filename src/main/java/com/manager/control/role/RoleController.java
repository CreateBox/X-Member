package com.manager.control.role;

import com.manager.pojo.Dept;
import com.manager.pojo.Employees;
import com.manager.pojo.Role;
import com.manager.service.dept.DeptService;
import com.manager.service.role.RoleService;
import com.manager.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private DeptService deptService;

    @RequestMapping(value = "/roleList")
    @ResponseBody
    public Object roleList(@RequestParam(name = "draw",required = false,defaultValue = "0")int draw,
                           @RequestParam(name = "start",required = false,defaultValue = "0")int start,
                           @RequestParam(name = "length",required = false,defaultValue = "0")int length,
                           Role role){
        PageUtil<Role> pageUtil = new PageUtil<Role>();
        int count = roleService.count(role);
        List<Role> roles = roleService.roleList(role,start,length);
        pageUtil.setData(roles);
        pageUtil.setDraw(draw);
        pageUtil.setRecordsFiltered(count);
        pageUtil.setRecordsTotal(count);
        return pageUtil;
    }

    @RequestMapping("/getRole/{id}/{str}")
    public ModelAndView getRole(@PathVariable("id")Integer id, @PathVariable("str")String str){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sysroleInfo");
        List<Dept> depts = null;
        Role role = new Role(id);
        Role newRole = roleService.getRole(role);
        if(str.equals("modify")){
            depts = deptService.deptAll();
            mv.setViewName("sysrolemodify");
        }
        mv.addObject("newRole",newRole);
        mv.addObject("depts",depts);
        return mv;
    }

    @RequestMapping(value = "/modifyRole",method = RequestMethod.POST)
    @ResponseBody
    public Object modifyRole(HttpSession session,Role role){
        role.setR_ModifyTime(new Date());
        Employees employees = (Employees) session.getAttribute("loginEmployee");
        role.setR_ModifyId(employees);
        int modify = roleService.modify(role);
        if(modify==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "/delRole",method = RequestMethod.POST)
    @ResponseBody
    public Object delRole(Role role){
        int i = roleService.delRole(role);
        if(i==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    @ResponseBody
    public Object addRole(HttpSession session,Role role){
        role.setR_ModifyTime(new Date());
        role.setR_ModifyId((Employees) session.getAttribute("loginEmployee"));
        int i = roleService.addRole(role);
        if(i==1){
            return "true";
        }
        return "false";
    }


    @RequestMapping(value = "/validationRole",method = RequestMethod.POST)
    @ResponseBody
    public Object validationRole(Role role){
        int i = roleService.validationRole(role);
        if(i==1){
            return "true";
        }
        return "false";
    }
}
