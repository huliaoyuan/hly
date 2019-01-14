package com.hly.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hly.common.HttpClientUtil;
import com.hly.common.IMoocJSONResult;

/**
 * 
 * @author Administrator
 * 微信小程序登录
 */
@RestController
@RequestMapping("/miniProgram")
public class MiniProgramController {
      @PostMapping("/login")
	  public IMoocJSONResult login(HttpServletRequest request){
		   String code=request.getParameter("code");
    	   String url="https://api.weixin.qq.com/sns/jscode2session";
		   HashMap<String ,String > map=new HashMap<>();
		   map.put("APPID","wxadc98712005fec96");
		   map.put("secret","5671f30b5cf2d822010d5316baeda9fc");
		   map.put("js_code",code);
		   map.put("grant_type","authorization_code");

		  System.out.println(HttpClientUtil.doGet(url, map));  ;
		   
    	  return   IMoocJSONResult.ok();
		  
		    
		  
	  }
	
	
	
}
