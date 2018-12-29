package com.hly.controller;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hly.framwork.Pagination;
import com.hly.model.User;
import com.hly.service.UserService;
import com.hly.utils.StringUtils;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    
    
    @ResponseBody
    @RequestMapping(value = "/add")
    public int addUser(){
    	User user=new User();
    	user.setId(StringUtils.UUID());
    	user.setPassword("123");   	
    	userService.addUser1(user);
    	System.out.println();
        return 1;
    }
    
    
    @GetMapping(value = "/add")
    public String add(){
    
        return "/user/add";
    }
    
    
    
    /**
     * 
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/redis")
    public int redis(){
    	User user=new User();
    	user.setId(StringUtils.UUID());
    	user.setPassword("123");   	
    	userService.redis();
    	System.out.println();
        return 1;
    }
    
    
    
    
    
    
    @ResponseBody
    @RequestMapping("/delete")
    public String delete(String id){
    	userService.delete(id);
        return "123";
    }
    @ResponseBody
    @RequestMapping("/update")
    public String update(String id){
    	User user=new User();
    	user.setId(id);
    	user.setUsername("盖伦啊啊啊1");
    	user.setPassword("80082088201");   	
    	userService.updateByPrimaryKeySelective(user);
        return "123";
    }
    
    @ResponseBody
    @RequestMapping("/selectByPrimaryKey")
    public String selectByPrimaryKey(String id){    	
    	userService.selectByPrimaryKey(id);
        return "123";
    }
    
    @RequestMapping(value="/getList")
	public  String getList(HttpServletRequest request,HttpServletResponse response,Model model)throws Exception
	{    	
    	    	    	
    	  String pageNo=request.getParameter("pageNo")==null?"1":request.getParameter("pageNo");
    	  Map<String,String> filterMap=new HashMap<String, String>(); 
          String username=request.getParameter("username");
          if(!org.springframework.util.StringUtils.isEmpty(username))
          filterMap.put("username",username);
       /*   Page<User> page=userService.getPage(filterMap,Integer.valueOf(pageNo),10);
          List<UserDTO> list=new ArrayList<UserDTO>();
          for (User user :page.getResult() ) {
		   UserDTO UserDTO=new UserDTO().transfer(user);
		   list.add(UserDTO);
           }    */
          
          PageInfo<User> pageInfo=userService.findAllUser(Integer.valueOf(pageNo),10,new User());
          
          
    	  model.addAttribute("userList", pageInfo.getList());
    	  model.addAttribute("html", Pagination.getHtml(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal()));
    	  model.addAttribute("total", pageInfo.getTotal());
    	  model.addAttribute("username",username);

    	  System.out.println(); 
    	  return "user/list";    
		
	}
    
    
    
    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum, pageSize);
    }
    
    @ResponseBody
    @RequestMapping(value = "/all1/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findPage(pageNum, pageSize);
    }
    
    @RequestMapping("/list/{pageNum}/{pageSize}")
    public String list(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,Model model){
    	model.addAttribute("users",userService.findAllUser(pageNum, pageSize)) ;          
         return "/user/list";
    }
    @RequestMapping("/page1/{pageNum}/{pageSize}")
    @ResponseBody
    public PageInfo<Map<String, Object>> list1(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,Model model){    	  
         return userService.selectPage1(pageNum, pageSize);
    }
    
    
    
    
}


