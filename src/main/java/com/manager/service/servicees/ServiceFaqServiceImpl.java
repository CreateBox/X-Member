package com.manager.service.servicees;

import com.manager.mapper.ServiceFaqMapper;
import com.manager.pojo.ServiceFaq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceFaqServiceImpl implements ServiceFaqService {
    @Resource
    private ServiceFaqMapper serviceFaqMapper;

    @Override
    public Integer addFaq(ServiceFaq serviceFaq) {
        return serviceFaqMapper.addFaq(serviceFaq);
    }

    @Override
    public Integer updateFaq(ServiceFaq serviceFaq) {
        return serviceFaqMapper.updateFaq(serviceFaq);
    }

    @Override
    public Integer delFaq(Integer sf_id) {
        return serviceFaqMapper.delFaq(sf_id);
    }

    @Override
    public List<ServiceFaq> getServiceFaqList(ServiceFaq serviceFaq, int start, int length) {
        Map<String, Object> map = new HashMap<>();
        map.put("faq", serviceFaq);
        map.put("start", start);
        map.put("length", length);
        return serviceFaqMapper.getServiceFaqList(map);
    }

    @Override
    public Integer getServiceFaqCount(ServiceFaq serviceFaq) {
        return serviceFaqMapper.getServiceFaqCount(serviceFaq);
    }

    @Override
    public ServiceFaq getServiceFaq(Integer sf_id) {
        return serviceFaqMapper.getServiceFaq(sf_id);
    }
}
