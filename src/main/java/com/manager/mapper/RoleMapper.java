package com.manager.mapper;

import com.manager.pojo.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> roleList(Role role);

    int count(Role role);
}
