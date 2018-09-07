package com.manager.control.customer;

import com.manager.pojo.Customer;
import com.manager.pojo.DataDictionary;
import com.manager.pojo.Servicees;
import com.manager.service.customer.CustomerService;
import com.manager.service.datadictionary.DataDictionaryService;
import com.manager.service.servicees.ServiceesService;
import com.manager.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CustomerControl {
    @Resource
    private CustomerService customerService;
    @Resource
    private DataDictionaryService dataDictionaryService;
    @Resource
    private ServiceesService serviceesService;

    @RequestMapping("/cusview.html")
    public String cusview() {
        return "cusview";
    }

    @RequestMapping("/cusview.json")
    @ResponseBody
    public Object cusjson(@RequestParam(name = "draw", required = false, defaultValue = "0") int draw,
                          @RequestParam(name = "start", required = false, defaultValue = "0") int start,
                          @RequestParam(name = "length", required = false, defaultValue = "0") int length,
                          Customer customer, Integer status) {
        PageUtil<Customer> pageUtil = new PageUtil<>();
        int count = customerService.getCusCount(customer, status);
        List<Customer> cus = customerService.getCus(customer, status, start, length);
        pageUtil.setData(cus);
        pageUtil.setDraw(draw);
        pageUtil.setRecordsFiltered(count);
        pageUtil.setRecordsTotal(count);
        return pageUtil;
    }

    @RequestMapping("/getCus/{id}/{str}")
    public ModelAndView getCus(@PathVariable("id") Integer id, @PathVariable("str") String str) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cusInfo");
        Customer cusById = customerService.getCusById(id);
        mv.addObject("cusById", cusById);
        if (str.equals("modify")) {
            List<DataDictionary> status = dataDictionaryService.getservice_type("customer_status");
            mv.addObject("status", status);
            List<DataDictionary> customer_type = dataDictionaryService.getservice_type("customer_type");
            mv.addObject("customer_type", customer_type);
            List<Servicees> serNotCus = serviceesService.getSerNotCus();
            mv.addObject("serNotCus", serNotCus);
            mv.setViewName("cusmodify");
        }
        return mv;
    }

    @RequestMapping("/modifyCus")
    @ResponseBody
    public Object modifyCus(Customer customer) {
        Integer integer = customerService.updateCus(customer);
        if (1 == integer)
            return true;
        return false;
    }
}
