package com.manager.service.Announcement;

import com.alipay.api.AlipayApiException;
import com.manager.control.AlipayControl;
import com.manager.mapper.AnnouncementMapper;
import com.manager.pojo.Announcement;
import com.manager.pojo.DataDictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Resource
    private AnnouncementMapper announcementMapper;


    @Override
    public List<Announcement> announcementlist(String t_title, int start, int length) {
        Map<String, Object> map = new HashMap<>();
        map.put("t_title", t_title);
        map.put("start", start);
        map.put("length", length);
        return announcementMapper.announcementlist(map);
    }

    @Override
    public List<Announcement> announcementselect(Announcement announcement) {
        return announcementMapper.announcementselect(announcement);
    }


    @Override
    public Integer delAnnouncement(Integer tId) {
        return announcementMapper.delAnnouncement(tId);
    }

    @Override
    public Integer updateAnnouncement(Announcement announcement) {
        return announcementMapper.updateAnnouncement(announcement);
    }

    @Override
    public Announcement getNo(String t_no) {
        return announcementMapper.getNo(t_no);
    }

    @Override
    public Integer addAnnouncement(Announcement announcement) {
        int add = 0;
        try {
            String query = AlipayControl.query(announcement.getT_no());
            if ("Success".equals(query)) {//订单成功
                //查找数据库订单是否存在  避免卡bug
                Integer noCount = announcementMapper.getNoCount(announcement.getT_no());
                if (0 == noCount)//一个订单号付款一个公告
                    add = announcementMapper.addAnnouncement(announcement);
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return add;
    }

    @Override
    public Integer getAnnCount(String t_title) {
        return announcementMapper.getAnnCount(t_title);
    }

    @Override
    public Integer getNoCount(String t_no) {
        return announcementMapper.getNoCount(t_no);
    }

}
