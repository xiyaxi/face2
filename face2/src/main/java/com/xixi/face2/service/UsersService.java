package com.xixi.face2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xixi.face2.entity.Users;
import com.xixi.face2.mapper.UsersMapper;

@Service
public class UsersService {

	@Autowired
	private UsersMapper usersMapper;
	
	public int addUsers(Users usersName) {
		return usersMapper.addUser(usersName);
	}
}
