package com.hly.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class Constants {

	public static Map<String, String> stateMap=new LinkedHashMap<>();
	public static Map<String, String> enclosureTypeMap=new LinkedHashMap<>();
	public static  String STATE_ZC="1";
	public static String StATE_DJ="2";
	public static String STATE_SC="3";
	public static String ENCLOSURE_TYPE_TP="1";
	public static String ENCLOSURE_TYPE_YP="2";
	public static String ENCLOSURE_TYPE_SP="3";
	static{
		stateMap.put(STATE_ZC, "正常");
		stateMap.put(StATE_DJ, "冻结");
		stateMap.put(STATE_SC, "删除");
		enclosureTypeMap.put(ENCLOSURE_TYPE_TP, "图片");
		enclosureTypeMap.put(ENCLOSURE_TYPE_YP, "音频");
		enclosureTypeMap.put(ENCLOSURE_TYPE_SP, "视频");
  
		
	}
	
	
}
