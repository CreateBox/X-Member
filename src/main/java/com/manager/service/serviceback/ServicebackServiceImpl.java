package com.manager.service.serviceback;

import com.manager.mapper.ServicebackMapper;
import com.manager.pojo.Serviceback;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServicebackServiceImpl implements ServicebackService {
    @Resource
    private ServicebackMapper servicebackMapper;

    @Override
    public List<Serviceback> getSerBack(Integer sb_ser) {
        return servicebackMapper.getSerBack(sb_ser);
    }

    @Override
    public Integer addSerBack(Serviceback serviceback) {
        return servicebackMapper.addSerBack(serviceback);
    }
}
