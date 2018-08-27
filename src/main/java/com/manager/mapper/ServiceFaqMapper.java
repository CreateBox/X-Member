package com.manager.mapper;

import com.manager.pojo.ServiceFaq;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ServiceFaqMapper {
    List<ServiceFaq> getServiceFaqList(Map<String, Object> map);

    Integer getServiceFaqCount(@Param("faq") ServiceFaq serviceFaq);

    ServiceFaq getServiceFaq(@Param("sf_id") Integer sf_id);

    Integer delFaq(@Param("sf_id") Integer sf_id);

    Integer updateFaq(@Param("faq") ServiceFaq serviceFaq);

    Integer addFaq(@Param("faq") ServiceFaq serviceFaq);
}
