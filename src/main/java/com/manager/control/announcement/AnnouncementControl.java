package com.manager.control.announcement;

import com.manager.pojo.Announcement;
import com.manager.pojo.DataDictionary;
import com.manager.service.Announcement.AnnouncementService;
import com.manager.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AnnouncementControl {
    @Resource
    private AnnouncementService service;
    @RequestMapping("dicview2.html")
    public String dicview() {
        return "dicview2";
    }

    @RequestMapping("/dicview2.json")
    @ResponseBody
    public Object dicList(@RequestParam(name = "draw", required = false, defaultValue = "0") int draw,
                          @RequestParam(name = "start", required = false, defaultValue = "0") int start,
                          @RequestParam(name = "length", required = false, defaultValue = "0") int length,
                          String t_title) {
        PageUtil<Announcement> pageUtil = new PageUtil<>();
        int count = service.getAnnCount(t_title);
        List<Announcement> annlist = service.announcementlist(t_title,start,length);
        pageUtil.setData(annlist);
        pageUtil.setDraw(draw);
        pageUtil.setRecordsFiltered(count);
        pageUtil.setRecordsTotal(count);
        return pageUtil;
    }

    @RequestMapping("/announcementlist")
    public String showIndex(Announcement announcement, Model m) {
        List<Announcement> announcementselect = service.announcementselect(announcement);
        if (announcementselect != null) {
            for (Announcement a:announcementselect) {
                m.addAttribute("ann", a);
                return "announcementlist";
            }
        }
        return "error";
    }


    @RequestMapping("/announcementAdd.html")
    public String annadd(){
        return "announcementAdd";
    }

    @RequestMapping("/announcementAdd")
    public Object anadd(Announcement announcement,HttpSession session){
        int i = service.addAnnouncement(announcement);
        if(i>0){
            return true;
        }
        return false;
    };
}
