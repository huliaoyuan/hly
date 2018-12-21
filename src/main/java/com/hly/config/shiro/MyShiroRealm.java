package com.hly.config.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hly.model.Permission;
import com.hly.model.Role;
import com.hly.model.User;
import com.hly.service.LoginService;

//实现AuthorizingRealm接口用户用户认证
public class MyShiroRealm extends AuthorizingRealm{

  //用于用户查询
  @Autowired
  private LoginService loginService;


  //用户认证
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
      //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
      if (authenticationToken.getPrincipal() == null) {
          return null;
      }
      //获取用户信息
      String name = authenticationToken.getPrincipal().toString();
      User user = loginService.findByName(name);
      if (user == null) {
          //这里返回后会报出对应异常
          return null;
      } else {
          //这里验证authenticationToken和simpleAuthenticationInfo的信息
          SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword().toString(), getName());
          return simpleAuthenticationInfo;
      }
  }
  
  
  //角色权限和对应权限添加
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
      SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
      principalCollection.getPrimaryPrincipal();
      //获取登录用户名
      User user= (User)principalCollection.getPrimaryPrincipal();
	    List<Role>  roles=loginService.selectRoleByUserId(user.getId());
	     for (Role role:roles) {
	    	 System.out.println("-----------"+role.getRolename());
	    	 simpleAuthorizationInfo.addRole(role.getRole());
     
      List<Permission>  permissions=loginService.selectPermissionByRoleId(role.getId());
      for (Permission permission:permissions) {
      	System.out.println("-----------"+permission.getPermission());
      	simpleAuthorizationInfo.addStringPermission(permission.getPermission());
         
      }
  }
	     
      
      //获取登录用户名
     // String name= (String) principalCollection.getPrimaryPrincipal();
    //  //查询用户名称
    //  User user = loginService.findByName(name);
    //  List<Role>  roles=loginService.selectByUserId(user.getId());
    //  //添加角色和权限
     /* simpleAuthorizationInfo.addRole("view");
      simpleAuthorizationInfo.addStringPermission("view");*/

     /* for (Role role:roles) {
          //添加角色
          simpleAuthorizationInfo.addRole(role.getRolename());
          List<Permission>  permissions=loginService.selectByRoleId(role.getId());
          for (Permission permission:permissions) {
              //添加权限
              simpleAuthorizationInfo.addStringPermission(permission.getPermission());
          }
      }*/
      return simpleAuthorizationInfo;
  }
  
  
  
  

  
   
  
  
}


