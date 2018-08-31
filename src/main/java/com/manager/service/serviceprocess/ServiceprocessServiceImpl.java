package com.manager.service.serviceprocess;

import com.manager.mapper.ServiceprocessMapper;
import com.manager.pojo.Serviceprocess;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceprocessServiceImpl implements ServiceprocessService {
    @Resource
    private ServiceprocessMapper serviceprocessMapper;

    @Override
    public Integer addSerPro(Serviceprocess serviceprocess) {
        return serviceprocessMapper.addSerPro(serviceprocess);
    }

    @Override
    public List<Serviceprocess> getSerPro(Integer sp_ser) {
        return serviceprocessMapper.getSerPro(sp_ser);
    }
}
