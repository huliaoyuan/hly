package com.hly.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	@SuppressWarnings("unused")
	private static InputStream in = null;
	private static Properties prop = null;


	public static String getConfig(String name) throws IOException {
		 String sep = System.getProperty("file.separator"); 
		  if(sep.equals("\\"))
		    sep="/";
		  prop =  new  Properties();  
		 String url=sep+"config.properties";
		 InputStream in=ConfigUtil.class.getResourceAsStream(url);
		 prop.load(in);    
		return prop.getProperty(name).trim();

	}
	
	
    public static void main(String[] args) throws IOException {
    	System.out.println( ConfigUtil.getConfig("uploadUrl"));;
    	//new ConfigUtil();
	}
}
