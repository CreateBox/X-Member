package com.manager.service.servicees;

import com.manager.mapper.ServiceesMapper;
import com.manager.pojo.Servicees;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceesServiceImpl implements ServiceesService {
    @Resource
    private ServiceesMapper serviceesMapper;

    @Override
    public Integer delSer(Integer id) {
        return serviceesMapper.delSer(id);
    }

    @Override
    public Integer addSer(Servicees servicees) {
        return serviceesMapper.addSer(servicees);
    }

    @Override
    public List<Servicees> getSerNotCus() {
        return serviceesMapper.getSerNotCus();
    }

    @Override
    public Servicees getSerById(Integer id) {
        return serviceesMapper.getSerById(id);
    }

    @Override
    public Integer updateSerCrl(Servicees servicees) {
        return serviceesMapper.updateSerCrl(servicees);
    }

    @Override
    public List<Servicees> getServiceesList(Servicees servicees, int start, int length) {
        Map<String, Object> map = new HashMap<>();
        map.put("ser", servicees);
        map.put("start", start);
        map.put("length", length);
        return serviceesMapper.getServiceesList(map);
    }

    @Override
    public Integer getServiceesCount(Servicees servicees) {
        return serviceesMapper.getServiceesCount(servicees);
    }

    @Override
    public Integer updateSer(Servicees servicees) {
        return serviceesMapper.updateSer(servicees);
    }
}
