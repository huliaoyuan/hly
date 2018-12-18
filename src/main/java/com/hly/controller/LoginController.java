package com.hly.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
     
    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    //post登录
    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, Map<String, Object> map,Model model) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        model.addAttribute(map);
        model.addAttribute("message","This is your asdf ");
        map.put("msg", msg);
        
        System.out.print(map.toString());
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }
    
    //退出的时候是get请求，主要是用于退出
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    //登出
    @RequestMapping(value = "/logout")
    public String logout(){
        return "logout";
    }
   
	
}
