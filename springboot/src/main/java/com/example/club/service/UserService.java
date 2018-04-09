package com.example.club.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.club.dao.gen.UserEntityMapper;
import com.example.club.model.gen.UserEntity;
import com.example.club.model.gen.UserEntityExample;

@Service
public class UserService {
	@Autowired
	UserEntityMapper userEntityMapper;
	public List<UserEntity> getUsers(){
		UserEntityExample userEntityExample = new UserEntityExample();
		List<UserEntity> users = userEntityMapper.selectByExample(userEntityExample);
		return users;
	}
	public UserEntity getUser(int id){
		UserEntity user = userEntityMapper.selectByPrimaryKey(id);
		return user;
	}
	public List<UserEntity> getUsersByName(String name){
		UserEntityExample userEntityExample = new UserEntityExample();
		userEntityExample.createCriteria().andNameEqualTo(name);
		List<UserEntity> users = userEntityMapper.selectByExample(userEntityExample);
		return users;
	}
	public void insertUser(UserEntity user){
		userEntityMapper.insertSelective(user);
	}
	public void updateUser(UserEntity userEntity){
		userEntityMapper.updateByPrimaryKeySelective(userEntity);
	}
}
