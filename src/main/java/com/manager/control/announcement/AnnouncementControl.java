package com.manager.control.announcement;

import com.manager.pojo.Announcement;
import com.manager.service.Announcement.AnnouncementService;
import com.manager.util.PageUtil;
import com.manager.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AnnouncementControl {
    @Resource
    private AnnouncementService service;

    @RequestMapping("annview.html")
    public String annview() {
        return "annview";
    }

    @RequestMapping("/annview.json")
    @ResponseBody
    public Object dicList(@RequestParam(name = "draw", required = false, defaultValue = "0") int draw,
                          @RequestParam(name = "start", required = false, defaultValue = "0") int start,
                          @RequestParam(name = "length", required = false, defaultValue = "0") int length,
                          String t_title) {
        PageUtil<Announcement> pageUtil = new PageUtil<>();
        int count = service.getAnnCount(t_title);
        List<Announcement> annlist = service.announcementlist(t_title, start, length);
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
            for (Announcement a : announcementselect) {
                m.addAttribute("ann", a);
                return "announcementlist";
            }
        }
        return "error";
    }

    @RequestMapping("/announcementAdd")
    @ResponseBody
    public Object anadd(Announcement announcement, HttpSession session) {
        announcement.setT_Name(SessionUtil.get(session));
        Integer integer = service.addAnnouncement(announcement);
        if (integer == 1)
            return true;
        return false;
    }

    @RequestMapping("/getAnnNo/{t_no}")
    public String getAnnNo(@PathVariable("t_no") String t_no, Model model) {
        Announcement no = service.getNo(t_no);
        model.addAttribute("ann", no);
        return "anninfo";
    }
}
