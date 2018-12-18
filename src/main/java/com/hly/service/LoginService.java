package com.hly.service;

import java.util.List;

import com.hly.model.Permission;
import com.hly.model.Role;
import com.hly.model.User;

public interface LoginService {

	User findByName(String name);

	List<Role> selectByUserId(String id);

	List<Permission> selectByRoleId(String id);
     
}
