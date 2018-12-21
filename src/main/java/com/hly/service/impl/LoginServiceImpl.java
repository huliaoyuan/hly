package com.hly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hly.mapper.PermissionMapper;
import com.hly.mapper.RoleMapper;
import com.hly.mapper.UserMapper;
import com.hly.model.Permission;
import com.hly.model.Role;
import com.hly.model.User;
import com.hly.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{
    
	 @Autowired
	 private UserMapper userMapper;
	
	 @Autowired
	 private RoleMapper roleMapper;
	 @Autowired
	 private PermissionMapper permissionMapper;
	 
	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.selectByName(name); 
	}


	@Override
	public List<Permission> selectPermissionByRoleId(String id) {
		// TODO Auto-generated method stub
		return permissionMapper.selectPermissionByRoleId(id);

	}

	@Override
	public List<Role> selectRoleByUserId(String id) {
		
		return roleMapper.selectRoleByUserId(id);
		// TODO Auto-generated method stub
	}

	  
	
}
