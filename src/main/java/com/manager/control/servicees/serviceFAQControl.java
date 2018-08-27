package com.manager.control.servicees;

import com.manager.pojo.DataDictionary;
import com.manager.pojo.ServiceFaq;
import com.manager.service.datadictionary.DataDictionaryService;
import com.manager.service.servicees.ServiceFaqService;
import com.manager.util.PageUtil;
import com.manager.util.SessionUtil;
import org.springframework.stereotype.Controller;
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
public class serviceFAQControl {
    @Resource
    private DataDictionaryService dataDictionaryService;
    @Resource
    private ServiceFaqService serviceFaqService;

    @RequestMapping("serviceFAQ.html")
    public String serviceFAQView(Model model) {
        List<DataDictionary> service_type = dataDictionaryService.getservice_type("service_type");
        model.addAttribute("s_type", service_type);
        return "serviceFAQ";
    }

    @RequestMapping("serviceFAQ.json")
    @ResponseBody
    public Object serviceFAQList(@RequestParam(name = "draw", required = false, defaultValue = "0") int draw,
                                 @RequestParam(name = "start", required = false, defaultValue = "0") int start,
                                 @RequestParam(name = "length", required = false, defaultValue = "0") int length,
                                 ServiceFaq serviceFaq, HttpSession session) {
        PageUtil<ServiceFaq> pageUtil = new PageUtil<>();
//        Employees employees = SessionUtil.get(session);
        int count = serviceFaqService.getServiceFaqCount(serviceFaq);
        List<ServiceFaq> serviceFaqList = serviceFaqService.getServiceFaqList(serviceFaq, start, length);
        pageUtil.setData(serviceFaqList);
        pageUtil.setDraw(draw);
        pageUtil.setRecordsFiltered(count);
        pageUtil.setRecordsTotal(count);
        return pageUtil;
    }

    @RequestMapping("/delFaq")
    @ResponseBody
    public Object delFaq(Integer s_Id) {
        Integer integer = serviceFaqService.delFaq(s_Id);
        if (1 == integer)
            return true;
        else
            return false;
    }

    @RequestMapping("/getFaq/{id}/{str}")
    public ModelAndView getFaq(@PathVariable("id") Integer id, @PathVariable("str") String str) {
        System.out.println(id);
        ModelAndView mv = new ModelAndView();
        ServiceFaq serviceFaq = serviceFaqService.getServiceFaq(id);
        mv.addObject("info", serviceFaq);
        mv.setViewName("faqInfo");
        if (str.equals("modify")) {
            List<DataDictionary> service_type = dataDictionaryService.getservice_type("service_type");
            mv.addObject("service_type", service_type);
            mv.setViewName("faqmodify");
        }
        return mv;
    }


    @RequestMapping("/modifyFaq")
    @ResponseBody
    public Object modifyFaq(ServiceFaq serviceFaq) {
        Integer integer = serviceFaqService.updateFaq(serviceFaq);
        if (1 == integer)
            return true;
        return false;
    }


    @RequestMapping("/toAddFaq")
    public ModelAndView toAddFaq() {
        ModelAndView mv = new ModelAndView();
        List<DataDictionary> service_type = dataDictionaryService.getservice_type("service_type");
        mv.addObject("service_type", service_type);
        mv.setViewName("faqadd");
        return mv;
    }

    @RequestMapping("/addFaq")
    @ResponseBody
    public Object addFaq(ServiceFaq serviceFaq, HttpSession session) {
        serviceFaq.setSf_Create(SessionUtil.get(session));
        Integer integer = serviceFaqService.addFaq(serviceFaq);
        if (integer == 1)
            return true;
        return false;
    }
}
