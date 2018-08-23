package com.manager.service.datadictionary;

import com.manager.mapper.DataDictionaryMapper;
import com.manager.pojo.DataDictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> getservice_type(String dd_typeCode) {
        return dataDictionaryMapper.getservice_type(dd_typeCode);
    }
}
