package com.hly.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hly.mapper.UserMapper;
import com.hly.model.User;
import com.hly.utils.RedisUtil;
/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public class UserServiceImpl implements com.hly.service.UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Resource
	private RedisTemplate<String, Object> redisTemplate;

   
    /**
     * 新增
     * 
     */
   //@CachePut(value = "usercache", key = "#user.id")
   public User addUser1(User user) {
   	   System.out.println(userMapper.insert(user));
       return user;
       
   }
    
    
 /**
  * 删除
  * 
  */
    //@CacheEvict(value = "usercache", key = "#userId")
    public void delete(String userId) {
         userMapper.deleteByPrimaryKey(userId);
    }
    
    /**
     * 更新
     * 
     */
   // @CachePut(value = "usercache", key = "#user.id")
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
    public List<User> findAllUser(int pageNum, int pageSize) {
    	 PageHelper.startPage(pageNum, pageSize);
    	 User user=new User();
    	 user.setPassword("123");
    	 List<User> appsList = userMapper.select(user);
    	 PageInfo<User> appsPageInfo = new PageInfo<>(appsList);
         return appsPageInfo.getList();
    }
    
    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
     @Override
     public PageInfo<User> findAllUser(int pageNum, int pageSize,User user) {
     	 PageHelper.startPage(pageNum, pageSize);
     	 List<User> appsList = userMapper.select(user);     	 
     	 PageInfo<User> pageInfo = new PageInfo<>(appsList);
          return pageInfo;
     }
    

	@Override
	public PageInfo<User> findPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 查询
	 */
	// redis缓存配置
	//@Cacheable(value = "usercache", key = "#id")
	@Override
	public User selectByPrimaryKey(String id) {
		return userMapper.selectByPrimaryKey(id);
	}


	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}


	@Override
	public int redis() {
		List<User> list=userMapper.select(new User());
		/**
		 * 单个操作
		 */
		/*for (User user : list) {
			redisUtil.set(user.getUserid(), user);
		}		
		User user=(User) redisUtil.get("2");
		System.out.println(user.toString());
		System.out.println("缓存过期时间："+redisUtil.getExpire("2"));*/
				
	    /**
	     * list操作 整个list作为一条记录
	     */
		//redisUtil.lSet("userlist", list);
		
	/**
	 * 存储map
	 */
	//	Map<String,Object> map=new HashMap<>();
		//map.put("11", "压缩");
	//	map.put("22", "凯");
	//	map.put("33", "后裔");
	//	redisUtil.sSet("hashmaptest", map);
	//	redisUtil.
	//	
	//set操作	
	//redisTemplate.opsForSet().add("settest",1);
    redisTemplate.opsForZSet().add("ZSettest","德玛西亚",21321);
		
		
		return 0;
	}


	@Override
	public PageInfo<Map<String, Object>> selectPage1(int pageNum, int pageSize) {
		 PageHelper.startPage(pageNum, pageSize);
    	 User user=new User();
    	 user.setPassword("123");
    	 Map<String ,Object> map=new HashMap<>();
    	 map.put("classid","11");
    	 List<Map<String,Object>> appsList = userMapper.selectPage1(map);
    	 PageInfo<Map<String, Object>> appsPageInfo = new PageInfo<>(appsList);   
    	 for(int i=0;i<appsList.size();i++){
    		 Map<String,Object> pserson=appsList.get(i);
    		 System.out.println(pserson.get("username")+"--"+pserson.get("name"));
    	 }
		 return  appsPageInfo;
		
	}

	
	
}
