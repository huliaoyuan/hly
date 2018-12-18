package com.hly.mapper;

import java.util.List;
import java.util.Map;

import com.hly.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> select(User user);

	List<Map<String, Object>> selectPage1(Map<String, Object> map);

	User selectByName(String name);
}