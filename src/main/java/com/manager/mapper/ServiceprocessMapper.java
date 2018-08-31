package com.manager.mapper;

import com.manager.pojo.Serviceprocess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceprocessMapper {

    List<Serviceprocess> getSerPro(@Param("sp_ser") Integer sp_ser);

    Integer addSerPro(@Param("spro") Serviceprocess serviceprocess);
}
