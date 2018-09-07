package com.manager.service.Announcement;

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
    private  AnnouncementMapper announcementMapper;


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
    public Integer delAnnouncement(Integer tId){
        return announcementMapper.delAnnouncement(tId);
    }

    @Override
    public Integer updateAnnouncement(Announcement announcement){
        return announcementMapper.updateAnnouncement(announcement);
    }

    @Override
    public Integer addAnnouncement(Announcement announcement){
        return announcementMapper.addAnnouncement(announcement);
    }

    @Override
    public Integer getAnnCount(String t_title) {
        return announcementMapper.getAnnCount(t_title);
    }

}
