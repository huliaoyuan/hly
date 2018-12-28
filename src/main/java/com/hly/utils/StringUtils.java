package com.hly.utils;
import java.util.UUID;

/**
 *
 */
public class StringUtils {

    public static String UUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static boolean isEmpty(String str){
        return org.springframework.util.StringUtils.isEmpty(str);
    }
}

