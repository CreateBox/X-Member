package com.manager.service.role;

import com.manager.mapper.RoleMapper;
import com.manager.pojo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> roleList(Role role) {
        return roleMapper.roleList(role);
    }

    @Override
    public int count(Role role) {
        return roleMapper.count(role);
    }
}
