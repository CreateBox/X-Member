package com.manager.mapper;

import com.manager.pojo.Servicees;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ServiceesMapper {
    List<Servicees> getServiceesList(Map<String, Object> map);

    Integer getServiceesCount(@Param("ser") Servicees servicees);

    Integer delSer(@Param("id") Integer id);

    Servicees getSerById(@Param("id") Integer id);

    Integer updateSer(@Param("ser") Servicees servicees);

    Integer updateSerCrl(@Param("ser") Servicees servicees);

    Integer addSer(@Param("ser") Servicees servicees);

    List<Servicees> getSerNotCus();
}
