package com.manager.service.servicees;

import com.manager.pojo.ServiceFaq;

import java.util.List;

public interface ServiceFaqService {
    List<ServiceFaq> getServiceFaqList(ServiceFaq serviceFaq, int start, int length);

    Integer getServiceFaqCount(ServiceFaq serviceFaq);

    ServiceFaq getServiceFaq(Integer sf_id);

    Integer delFaq(Integer sf_id);

    Integer updateFaq(ServiceFaq serviceFaq);

    Integer addFaq(ServiceFaq serviceFaq);

}
