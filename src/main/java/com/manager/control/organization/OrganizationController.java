package com.manager.control.organization;

import com.manager.pojo.Dept;
import com.manager.pojo.Employees;
import com.manager.pojo.Organization;
import com.manager.service.dept.DeptService;
import com.manager.service.organization.OrganizationService;
import com.manager.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class OrganizationController {

    @Resource
    private OrganizationService organizationService;
    @Resource
    private DeptService deptService;

    @RequestMapping("/organizationList")
    @ResponseBody
    public Object organizationList(@RequestParam(name = "draw",required = false,defaultValue = "0")int draw,
                                   @RequestParam(name = "start",required = false,defaultValue = "0")int start,
                                   @RequestParam(name = "length",required = false,defaultValue = "0")int length,
                                   Organization organization)
    {
        PageUtil<Organization> pageUtil = new PageUtil<>();
        List<Organization> organizations = organizationService.organizationList(start,length,organization);
        int count = organizationService.count(organization);
        pageUtil.setData(organizations);
        pageUtil.setDraw(draw);
        pageUtil.setRecordsTotal(count);
        pageUtil.setRecordsFiltered(count);
        return pageUtil;
    }

    @RequestMapping(value = "/getOrganization/{id}")
    public ModelAndView getOrganization(@PathVariable("id")Integer id){
        ModelAndView mv = new ModelAndView();
        Organization organization = new Organization(id);
        Organization newOrganization = organizationService.getOrganization(organization);
        List<Dept> depts = deptService.deptAll();
        mv.addObject("newOrganization",newOrganization);
        mv.addObject("depts",depts);
        mv.setViewName("sysorganizationmodify");
        return mv;
    }

    @RequestMapping(value = "/modifyOrganization",method = RequestMethod.POST)
    @ResponseBody
    public Object modifyOrganization(HttpSession session,Organization organization){
        Employees employees = (Employees) session.getAttribute("loginEmployee");
        organization.setO_ModifyId(employees);
        organization.setO_ModifyTime(new Date());
        int i = organizationService.modifyOrganization(organization);
        if(i==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "/validationOrganization",method = RequestMethod.POST)
    @ResponseBody
    public Object validationOrganization(Organization organization){
        int i = organizationService.validationOrganization(organization);
        if(i==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "/delOrganization",method = RequestMethod.POST)
    @ResponseBody
    public Object delOrganization(Organization organization){
        int i = organizationService.delOrganization(organization);
        if(i==1){
            return "true";
        }
        return "false";
    }
}
