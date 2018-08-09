package com.xixi.face2.mapper;

import org.apache.ibatis.annotations.Param;

import com.xixi.face2.entity.Users;

public interface UsersMapper {
	int addUser(Users users);
}
