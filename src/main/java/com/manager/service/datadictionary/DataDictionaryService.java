package com.manager.service.datadictionary;

import com.manager.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryService {
    List<DataDictionary> getservice_type(String dd_typeCode);
}
