package com.manager.service.Announcement;

import com.manager.pojo.Announcement;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> announcementlist(String t_title, int start, int length);

    List<Announcement> announcementselect(Announcement announcement);

    Integer delAnnouncement(Integer tId);

    Integer updateAnnouncement(Announcement announcement);

    Integer addAnnouncement(Announcement announcement);

    Integer getAnnCount(String t_title);

    Integer getNoCount(String t_no);

    Announcement getNo(String t_no);


}
