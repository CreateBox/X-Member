package com.manager.control.servicees;

import com.manager.pojo.DataDictionary;
import com.manager.pojo.Servicees;
import com.manager.service.datadictionary.DataDictionaryService;
import com.manager.service.servicees.ServiceesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                                @RequestParam(name = "length", required = false, defaultValue = "0") int length) {
        Map<String, Object> data = new HashMap<>();
        List<Servicees> serviceesList = serviceesService.getServiceesList();
        data.put("data", serviceesList);
        return data;
    }
}
