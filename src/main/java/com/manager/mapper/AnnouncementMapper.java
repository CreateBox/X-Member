package com.manager.mapper;

import com.manager.pojo.Announcement;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AnnouncementMapper {
    List<Announcement> announcementlist(Map<String, Object> map);

    List<Announcement> announcementselect(Announcement announcement);

    Integer getAnnCount(String t_title);

    Integer delAnnouncement(@Param("tId") Integer tId);

    Integer updateAnnouncement(Announcement announcement);

    Integer addAnnouncement(Announcement announcement);

    Integer getNoCount(@Param("t_no") String t_no);

    Announcement getNo(@Param("t_no") String t_no);
}
