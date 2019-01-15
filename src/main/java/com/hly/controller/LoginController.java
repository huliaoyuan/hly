package com.hly.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hly.model.Permission;
import com.hly.model.Role;
import com.hly.model.User;
import com.hly.service.LoginService;

@Controller
public class LoginController {
	//用于用户查询
	  @Autowired
	  private LoginService loginService;
    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    //post登录
    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, Map<String, Object> map,Model model) throws Exception{
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	System.out.println(username + "---" + password);

		// 获得当前Subject
		Subject currentUser = SecurityUtils.getSubject();
		// 验证用户是否验证，即是否登录
		if (!currentUser.isAuthenticated()) {
			String msg = "";
			// 把用户名和密码封装为 UsernamePasswordToken 对象
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				// 执行登录.
				currentUser.login(token); 
				// 登录成功...
				return "index";
			} catch (IncorrectCredentialsException e) {
				msg = "登录密码错误";
				System.out.println("登录密码错误!!!" + e);
			} catch (ExcessiveAttemptsException e) {
				msg = "登录失败次数过多";
				System.out.println("登录失败次数过多!!!" + e);
			} catch (LockedAccountException e) {
				msg = "帐号已被锁定";
				System.out.println("帐号已被锁定!!!" + e);
			} catch (DisabledAccountException e) {
				msg = "帐号已被禁用";
				System.out.println("帐号已被禁用!!!" + e);
			} catch (ExpiredCredentialsException e) {
				msg = "帐号已过期";
				System.out.println("帐号已过期!!!" + e);
			} catch (UnknownAccountException e) {
				msg = "帐号不存在";
				System.out.println("帐号不存在!!!" + e);
			} catch (UnauthorizedException e) {
				msg = "您没有得到相应的授权！";
				System.out.println("您没有得到相应的授权！" + e);
			} catch (Exception e) {
				System.out.println("出错！！！" + e);
			}
			map.put("msg", msg);
			model.addAttribute(map);
			return "login";
		} 
		// 登录成功，重定向到LoginSuccess.action
		return "index";
    }
    
    //退出的时候是get请求，主要是用于退出
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    //登出
    @RequestMapping(value = "/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
  //登出
    @RequestMapping(value = "/test")
    public String test(){
    	//获取登录用户名
	     String name= "18668437101";
	     //查询用户名称
	    User user = loginService.findByName(name);
	    List<Role>  roles=loginService.selectRoleByUserId(user.getId());
	     for (Role role:roles) {
	    	 System.out.println("-----------"+role.getRolename());
       
        List<Permission>  permissions=loginService.selectPermissionByRoleId(role.getId());
        for (Permission permission:permissions) {
        	System.out.println("-----------"+permission.getPermission());
           
        }
    }
		return name;
	    
	    
    }
    

   
	
}
