package com.manager.service.Announcement;

import com.manager.pojo.Announcement;
import com.manager.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AnnouncementService {
    List<Announcement> announcementlist(String t_title, int start, int length);

    List<Announcement> announcementselect(Announcement announcement);

    Integer delAnnouncement(@Param("tId") Integer tId);

    Integer updateAnnouncement(Announcement announcement);

    Integer addAnnouncement(Announcement announcement);

    Integer getAnnCount(String t_title);
}
