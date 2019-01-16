package com.hly.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hly.common.DateUtil;
import com.hly.model.Attachment;
import com.hly.model.CommonProperties;
import com.hly.service.AttachmentService;
import com.hly.utils.Constants;
import com.hly.utils.StringUtils;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {
     @Autowired
	 CommonProperties commonProperties;
	 @Autowired
     public AttachmentService attachmentService;

	
	    @RequestMapping("/getType")
	    @ResponseBody
	    public JSONArray getType()    
	    {
	    	Map<String, String> stateMap= Constants.enclosureTypeMap;
	           JSONArray jsonArray=new JSONArray();
	    	   for (Entry<String, String> entry :stateMap.entrySet()) {
				    JSONObject jsonObject=new JSONObject();
				    jsonObject.put("id", entry.getKey());
				    jsonObject.put("text", entry.getValue());
	    		    jsonArray.add(jsonObject);
			}
	    	
	    	 
	    	return jsonArray;
	    			
	    }
	  //上传附件
	    @RequestMapping(value="/uploadFile")  
	    @ResponseBody
	    public Map<String,Object> uploadFile(HttpServletResponse response,HttpServletRequest request, @RequestParam("myfile") MultipartFile file) throws IOException{  
	    	String filename = file.getOriginalFilename().substring(file.getName().lastIndexOf("\\")+1);
		    String fileType = filename.substring(filename.lastIndexOf(".") + 1);
		    //文件夹是否创建。
		    String path = null;
		    String uploadPath="",fileName="";
		    long nowTime =System.currentTimeMillis();
		    String year = DateUtil.toString(nowTime,"yyyyMMdd").substring(0, 4);
		    String month = DateUtil.toString(nowTime,"yyyyMMdd").substring(4, 6);
		    String day = DateUtil.toString(nowTime,"yyyyMMdd").substring(6, 8);
		    path=year+"/"+month+"/"+day+"/";
		    String uploadUrl=commonProperties.upload;
			File dir = new File(uploadUrl+path);
			if(!dir.exists()){
				dir.mkdirs();
			}       
	        fileName=System.currentTimeMillis()+"."+fileType;
			uploadPath=commonProperties.upload+path+fileName;

	    	 byte[] bytes = file.getBytes();  
	       
	  
	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	       // String id=multipartRequest.getParameter("id");
	        String name=multipartRequest.getParameter("name");
	        File uploadedFile = new File(uploadPath);
	        String url=commonProperties.download+path+fileName;
	        FileCopyUtils.copy(bytes, uploadedFile);  
	        Map<String,Object> map=new HashMap<String, Object>();
	         
	        Attachment attachment=new Attachment();
	        attachment.setId(StringUtils.UUID());
	        attachment.setPath(path+fileName);
	        attachment.setCreatetime(System.currentTimeMillis());
	        attachmentService.insert(attachment);
	        map.put("id",attachment.getId());     
			return map;  
	    }  
	    
	  
	    //删除附件
	    @RequestMapping(value="/deleteFile")
	    @ResponseBody
	    public Map<String,Object> deleteFile(HttpServletRequest request,Model model) throws Exception
	    {
	    	String key=request.getParameter("key");    	
	    	Attachment enclosure=attachmentService.selectByPrimaryKey(key);
	    	String  path=enclosure.getPath();
	        String uploadPath=commonProperties.upload;
	    	File file=new File(uploadPath+path);
	        if(file.exists()&&file.isFile())
	            file.delete();
	        attachmentService.deleteByPrimaryKey(key);    	
	    	
	    	Map<String,Object> map=new HashMap<String, Object>();
	        map.put("state", "true");
	    	return map;
	    } 
	    
	    
	 
	 
	
}
