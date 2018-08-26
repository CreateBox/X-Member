package com.manager.service.dept;

import com.manager.mapper.DeptMapper;
import com.manager.pojo.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl  implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> deptAll() {
        return deptMapper.deptAll();
    }
}
