package com.manager.mapper;

import com.manager.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DataDictionaryMapper {
    List<DataDictionary> getservice_type(@Param("dd_typeCode") String dd_typeCode);

    List<DataDictionary> getDataDicList(Map<String, Object> map);

    Integer getDataDicCount(@Param("dic") DataDictionary dataDictionary);

    DataDictionary getDicById(@Param("id") Integer id);

    Integer updateDic(@Param("dic") DataDictionary dataDictionary);

    Integer getCodeValCount(@Param("dic") DataDictionary dataDictionary);

    Integer addDic(@Param("dic") DataDictionary dataDictionary);
}
