package com.manager.service.serviceprocess;

import com.manager.pojo.Serviceprocess;

import java.util.List;

public interface ServiceprocessService {

    List<Serviceprocess> getSerPro(Integer sp_ser);

    Integer addSerPro(Serviceprocess serviceprocess);

}
