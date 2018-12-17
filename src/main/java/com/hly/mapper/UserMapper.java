package com.hly.mapper;

import java.util.List;
import java.util.Map;

import com.hly.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> select(User user);
	List<Map<String,Object>> selectPage1(Map map);
    
}