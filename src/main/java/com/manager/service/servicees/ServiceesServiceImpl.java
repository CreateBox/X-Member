package com.manager.service.servicees;

import com.manager.mapper.ServiceesMapper;
import com.manager.pojo.Servicees;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceesServiceImpl implements ServiceesService {
    @Resource
    private ServiceesMapper serviceesMapper;

    @Override
    public List<Servicees> getServiceesList() {
        return serviceesMapper.getServiceesList();
    }
}
