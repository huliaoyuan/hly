package com.hly.mapper;

import java.util.List;

import com.hly.model.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

	List<Permission> selectPermissionByRoleId(String id);
    
}