package com.manager.control.datadictionary;

import com.manager.pojo.DataDictionary;
import com.manager.service.datadictionary.DataDictionaryService;
import com.manager.util.PageUtil;
import com.manager.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DataDictionaryControl {
    @Resource
    private DataDictionaryService dataDictionaryService;

    @RequestMapping("/dicview.json")
    @ResponseBody
    public Object dicList(@RequestParam(name = "draw", required = false, defaultValue = "0") int draw,
                          @RequestParam(name = "start", required = false, defaultValue = "0") int start,
                          @RequestParam(name = "length", required = false, defaultValue = "0") int length,
                          DataDictionary dataDictionary) {
        PageUtil<DataDictionary> pageUtil = new PageUtil<>();
        int count = dataDictionaryService.getDataDicCount(dataDictionary);
        List<DataDictionary> dataDicList = dataDictionaryService.getDataDicList(dataDictionary, start, length);
        pageUtil.setData(dataDicList);
        pageUtil.setDraw(draw);
        pageUtil.setRecordsFiltered(count);
        pageUtil.setRecordsTotal(count);
        return pageUtil;
    }

    @RequestMapping("/getDic/{id}/{str}")
    public ModelAndView getDic(@PathVariable("id") Integer id, @PathVariable("str") String str) {
        System.out.println(id);
        ModelAndView mv = new ModelAndView();
        DataDictionary dicById = dataDictionaryService.getDicById(id);
        mv.addObject("info", dicById);
        mv.setViewName("dicInfo");
        if (str.equals("modify")) {
            mv.setViewName("dicmodify");
        }
        return mv;
    }

    @RequestMapping("/modifydic")
    @ResponseBody
    public Object modifydic(DataDictionary dataDictionary) {
        Integer integer = dataDictionaryService.updateDic(dataDictionary);
        if (1 == integer)
            return true;
        return false;
    }

    @RequestMapping("dicview.html")
    public String dicview() {
        return "dicview";
    }

    @RequestMapping("/toDicAdd")
    public String toDicAdd() {
        return "dicAdd";
    }

    @RequestMapping("/dicAdd")
    @ResponseBody
    public Object dicAdd(DataDictionary dataDictionary, HttpSession session) {
        dataDictionary.setDd_OperationId(SessionUtil.get(session));
        Integer codeValCount = dataDictionaryService.getCodeValCount(dataDictionary);
        if (0 == codeValCount) {
            Integer integer = dataDictionaryService.addDic(dataDictionary);
            if (1 == integer)
                return true;
        }
        return false;
    }
}
