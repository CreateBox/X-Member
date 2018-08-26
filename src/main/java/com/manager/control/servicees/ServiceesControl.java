package com.manager.control.servicees;

import com.manager.pojo.DataDictionary;
import com.manager.pojo.Servicees;
import com.manager.service.datadictionary.DataDictionaryService;
import com.manager.service.servicees.ServiceesService;
import com.manager.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ServiceesControl {
    @Resource
    private ServiceesService serviceesService;
    @Resource
    private DataDictionaryService dataDictionaryService;

    @RequestMapping("serviceview.html")
    public String serviceesVist(Model model) {
        List<DataDictionary> service_type = dataDictionaryService.getservice_type("service_type");
        List<DataDictionary> service_status = dataDictionaryService.getservice_type("service_status");
        model.addAttribute("s_type", service_type);
        model.addAttribute("s_status", service_status);
        return "serviceview";
    }

    @RequestMapping("serviceesList.json")
    @ResponseBody
    public Object serviceesList(@RequestParam(name = "draw", required = false, defaultValue = "0") int draw,
                                @RequestParam(name = "start", required = false, defaultValue = "0") int start,
                                @RequestParam(name = "length", required = false, defaultValue = "0") int length,
                                Servicees servicees) {
        PageUtil<Servicees> pageUtil = new PageUtil<>();
        int count = serviceesService.getServiceesCount(servicees);
        List<Servicees> serviceesList = serviceesService.getServiceesList(servicees, start, length);
        pageUtil.setData(serviceesList);
        pageUtil.setDraw(draw);
        pageUtil.setRecordsFiltered(count);
        pageUtil.setRecordsTotal(count);
        return pageUtil;
    }

    @RequestMapping("/delSer")
    @ResponseBody
    public Object delSer(Integer s_Id) {
        Integer integer = serviceesService.delSer(s_Id);
        if (1 == integer)
            return true;
        else
            return false;
    }

    @RequestMapping("/subSer")
    @ResponseBody
    public Object subSer(Integer s_Id) {
        Integer integer = serviceesService.updateSerSub(s_Id);
        if (1 == integer)
            return true;
        else
            return false;
    }

    @RequestMapping("/getSer/{id}/{str}")
    public ModelAndView getSer(@PathVariable("id") Integer id, @PathVariable("str") String str) {
        System.out.println(id);
        ModelAndView mv = new ModelAndView();
        Servicees serById = serviceesService.getSerById(id);
        mv.addObject("info", serById);
        mv.setViewName("serInfo");
        if (str.equals("modify")) {
            List<DataDictionary> service_type = dataDictionaryService.getservice_type("service_type");
            mv.addObject("service_type", service_type);
            mv.setViewName("sermodify");
        }
        return mv;
    }

    @RequestMapping("/modifySer")
    @ResponseBody
    public Object modifySer(Servicees servicees) {
        Integer integer = serviceesService.updateSer(servicees);
        if (1 == integer)
            return true;
        return false;
    }
}
