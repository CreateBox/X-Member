package com.manager.mapper;

import com.manager.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataDictionaryMapper {
    List<DataDictionary> getservice_type(@Param("dd_typeCode") String dd_typeCode);
}
