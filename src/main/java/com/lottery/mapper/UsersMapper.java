package com.lottery.mapper;

import com.lottery.pojo.Users;

public interface UsersMapper {
    Users getUser(Users users);

    int alterUser(Users users);
}
