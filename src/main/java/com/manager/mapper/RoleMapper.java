package com.manager.mapper;

import com.manager.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    List<Role> roleList(Map map);

    int count(Role role);

    Role getRole(Role role);

    List<Role> roleAll();

    int modify(Role role);

    int delRole(Role role);
}
