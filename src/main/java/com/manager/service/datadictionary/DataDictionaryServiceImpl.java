package com.manager.service.datadictionary;

import com.manager.mapper.DataDictionaryMapper;
import com.manager.pojo.DataDictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> getservice_type(String dd_typeCode) {
        return dataDictionaryMapper.getservice_type(dd_typeCode);
    }

    @Override
    public Integer getCodeValCount(DataDictionary dataDictionary) {
        return dataDictionaryMapper.getCodeValCount(dataDictionary);
    }

    @Override
    public Integer addDic(DataDictionary dataDictionary) {
        return dataDictionaryMapper.addDic(dataDictionary);
    }

    @Override
    public Integer updateDic(DataDictionary dataDictionary) {
        return dataDictionaryMapper.updateDic(dataDictionary);
    }

    @Override
    public DataDictionary getDicById(Integer id) {
        return dataDictionaryMapper.getDicById(id);
    }

    @Override
    public Integer getDataDicCount(DataDictionary dataDictionary) {
        return dataDictionaryMapper.getDataDicCount(dataDictionary);
    }

    @Override
    public List<DataDictionary> getDataDicList(DataDictionary dataDictionary, int start, int length) {
        Map<String, Object> map = new HashMap<>();
        map.put("dic", dataDictionary);
        map.put("start", start);
        map.put("length", length);
        return dataDictionaryMapper.getDataDicList(map);
    }
}
