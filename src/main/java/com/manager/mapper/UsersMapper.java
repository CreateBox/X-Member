package com.manager.mapper;

import com.manager.pojo.Users;

public interface UsersMapper {
    Users getUser(Users users);

    int alterUser(Users users);
}
