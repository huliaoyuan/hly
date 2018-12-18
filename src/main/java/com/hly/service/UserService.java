package com.hly.service;



import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.hly.model.User;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface UserService {

    User addUser1(User user);

    int addUser(User user);

    
    List<User> findAllUser(int pageNum, int pageSize);

	PageInfo<User> findPage(int pageNum, int pageSize);

	User updateByPrimaryKeySelective(User user);

	void delete(String string);
	
	User selectByPrimaryKey(String id);
    
	int redis();
	
	PageInfo<Map<String,Object>> selectPage1(int pageNum, int pageSize);

	
	
}
