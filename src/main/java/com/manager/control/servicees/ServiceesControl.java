package com.manager.control.servicees;

import com.manager.pojo.*;
import com.manager.service.customer.CustomerService;
import com.manager.service.datadictionary.DataDictionaryService;
import com.manager.service.serviceback.ServicebackService;
import com.manager.service.servicees.ServiceesService;
import com.manager.service.serviceprocess.ServiceprocessService;
import com.manager.service.users.EmployeesService;
import com.manager.util.PageUtil;
import com.manager.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ServiceesControl {
    @Resource
    private ServiceesService serviceesService;
    @Resource
    private DataDictionaryService dataDictionaryService;
    @Resource
    private ServiceprocessService serviceprocessService;
    @Resource
    private ServicebackService servicebackService;
    @Resource
    private EmployeesService employeesService;
    @Resource
    private CustomerService customerService;

    @RequestMapping("ser{name}view.html")
    public String serviceesVist(@PathVariable("name") String name, Model model) {
        List<DataDictionary> service_type = dataDictionaryService.getservice_type("service_type");
        List<DataDictionary> service_status = dataDictionaryService.getservice_type("service_status");
        model.addAttribute("s_type", service_type);
        model.addAttribute("s_status", service_status);
        return "ser" + name + "view";
    }

    @RequestMapping("serviceesList.json")
    @ResponseBody
    public Object serviceesList(@RequestParam(name = "draw", required = false, defaultValue = "0") int draw,
                                @RequestParam(name = "start", required = false, defaultValue = "0") int start,
                                @RequestParam(name = "length", required = false, defaultValue = "0") int length,
                                Servicees servicees, HttpSession session) {
        PageUtil<Servicees> pageUtil = new PageUtil<>();
        Employees employees = SessionUtil.get(session);
        servicees.setS_Operator(employees);
        servicees.setS_Processor(employees);
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

    @RequestMapping("/ser{name}/{id}")
    public ModelAndView sername(@PathVariable("name") String name, @PathVariable("id") Integer id, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Servicees serById = serviceesService.getSerById(id);
        List<Employees> employees = employeesService.lowerList(SessionUtil.get(session));
        mv.addObject("info", serById);
        mv.addObject("employees", employees);
        mv.setViewName("ser" + name);
        return mv;
    }

    @RequestMapping("/crlSer/{value}")
    @ResponseBody
    @Transactional
    public Object crlSer(@PathVariable("value") Integer value, Integer s_Id, Integer emp, HttpSession session, String info) {
        DataDictionary dataDictionary = new DataDictionary();
        Employees employees = new Employees();
        Servicees servicees = new Servicees();
        servicees.setS_Id(s_Id);
        servicees.setS_Operator(SessionUtil.get(session));
        if (0 == value) {//提交  打回
            Integer integer = customerService.getcountSer(servicees.getS_Id());
            if (0 == integer)
                return false;
            dataDictionary.setDd_ValueId(2);
            servicees.setS_Status(dataDictionary);
            servicees.setS_Processor(SessionUtil.get(session).getE_Superior());
        } else if (1 == value) {//分配
            dataDictionary.setDd_ValueId(3);
            servicees.setS_Status(dataDictionary);
            employees.setE_Id(emp);
            servicees.setS_Processor(employees);
        } else if (2 == value) {//处理
            dataDictionary.setDd_ValueId(4);
            servicees.setS_Status(dataDictionary);
            servicees.setS_Processor(SessionUtil.get(session));
            Serviceprocess serviceprocess = new Serviceprocess();
            serviceprocess.setSp_Ser(servicees.getS_Id());
            serviceprocess.setSp_Operator(SessionUtil.get(session).getE_Id());
            serviceprocess.setSp_Info(info);
            if (0 == serviceprocessService.addSerPro(serviceprocess))
                return false;
        } else if (3 == value) {//反馈
            dataDictionary.setDd_ValueId(5);
            servicees.setS_Status(dataDictionary);
            servicees.setS_Processor(SessionUtil.get(session));
            Serviceback serviceback = new Serviceback();
            serviceback.setSb_Ser(servicees.getS_Id());
            serviceback.setSb_Operator(SessionUtil.get(session).getE_Id());
            serviceback.setSb_Info(info);
            if (0 == servicebackService.addSerBack(serviceback))
                return false;
        } else if (4 == value) {
            dataDictionary.setDd_ValueId(5);
            servicees.setS_Status(dataDictionary);
        }
        Integer integer = serviceesService.updateSerCrl(servicees);
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

    @RequestMapping("/getSerPro/{id}/{str}")
    public ModelAndView getSerPro(@PathVariable("id") Integer id, @PathVariable("str") String str) {
        ModelAndView mv = getSer(id, str);

        List<Serviceprocess> serPro = serviceprocessService.getSerPro(id);
        mv.addObject("serPro", serPro);

        List<Serviceback> serBack = servicebackService.getSerBack(id);
        mv.addObject("serBack", serBack);

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

    @RequestMapping("/toAddser")
    public ModelAndView toAddser() {
        ModelAndView mv = new ModelAndView();
        List<DataDictionary> service_type = dataDictionaryService.getservice_type("service_type");
        mv.addObject("service_type", service_type);
        mv.setViewName("addser");
        return mv;
    }

    @RequestMapping("/addSer")
    @ResponseBody
    public Object addSer(Servicees servicees, HttpSession session) {
        servicees.setS_Operator(SessionUtil.get(session));
        servicees.setS_Processor(SessionUtil.get(session));
        Integer integer = serviceesService.addSer(servicees);
        if (1 == integer)
            return true;
        return false;
    }
}
