package com.hly.service.user.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hly.mapper.UserMapper;
import com.hly.model.User;
import com.hly.service.user.UserService;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
   
    /**
     * 新增
     * 
     */
   @CachePut(value = "usercache", key = "#user.userid")
   public User addUser1(User user) {
   	   System.out.println(userMapper.insert(user));
       return user;
       
   }
    
    
 /**
  * 删除
  * 
  */
    @CacheEvict(value = "usercache", key = "#userId")
    public void delete(String userId) {
         userMapper.deleteByPrimaryKey(userId);
    }
    
    /**
     * 更新
     * 
     */
    @CachePut(value = "usercache", key = "#user.userid")
    @Override
	public User updateByPrimaryKeySelective(User user) {
    	userMapper.updateByPrimaryKeySelective(user);
    	return user;
	}
    
    
    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Cacheable
    public List<User> findAllUser(int pageNum, int pageSize) {
    	 PageHelper.startPage(pageNum, pageSize);
    	 User user=new User();
    	 user.setPassword("123");
    	 List<User> appsList = userMapper.select(user);
    	 PageInfo<User> appsPageInfo = new PageInfo<>(appsList);
         return appsPageInfo.getList();
    }

	@Override
	public PageInfo<User> findPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 查询
	 */
	@Cacheable(value = "usercache", key = "#id")
	@Override
	public User selectByPrimaryKey(String id) {
		return userMapper.selectByPrimaryKey(id);
	}


	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
