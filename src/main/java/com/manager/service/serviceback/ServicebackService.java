package com.manager.service.serviceback;

import com.manager.pojo.Serviceback;

import java.util.List;

public interface ServicebackService {
    List<Serviceback> getSerBack(Integer sb_ser);

    Integer addSerBack(Serviceback serviceback);

}
