package com.manager.service.servicees;

import com.manager.pojo.Servicees;

import java.util.List;

public interface ServiceesService {
    List<Servicees> getServiceesList(Servicees servicees, int start, int length);

    Integer getServiceesCount(Servicees servicees);

    Integer delSer(Integer id);

    Integer updateSerSub(Integer id);

    Servicees getSerById(Integer id);

    Integer updateSer(Servicees servicees);
}
