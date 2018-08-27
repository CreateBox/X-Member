package com.manager.service.datadictionary;

import com.manager.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryService {
    List<DataDictionary> getservice_type(String dd_typeCode);

    List<DataDictionary> getDataDicList(DataDictionary dataDictionary, int start, int length);

    Integer getDataDicCount(DataDictionary dataDictionary);

    DataDictionary getDicById(Integer id);

    Integer updateDic(DataDictionary dataDictionary);

    Integer getCodeValCount(DataDictionary dataDictionary);

    Integer addDic(DataDictionary dataDictionary);

}
