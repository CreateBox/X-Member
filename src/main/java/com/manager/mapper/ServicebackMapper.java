package com.manager.mapper;

import com.manager.pojo.Serviceback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServicebackMapper {
    List<Serviceback> getSerBack(@Param("sb_ser") Integer sb_ser);

    Integer addSerBack(@Param("sback") Serviceback serviceback);

}
