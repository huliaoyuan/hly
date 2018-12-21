package com.hly.mapper;

import java.util.List;

import com.hly.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role>  selectRoleByUserId(String userid);
    
    
    
}