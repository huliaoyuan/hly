package com.hly.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作的基本类
 * 
 */
public class StringUtil {

	private static String utf8 = "UTF-8";

	private StringUtil() {
		// default
	}

	/**
	 * The empty String <code>""</code>.
	 * 
	 * @since 1.0
	 */
	public static final String EMPTY = "";

	/**
	 * 判断字符串是否为null
	 * 
	 * @param input
	 *            给定的字符串
	 * @return 如果字符串为null，返回true，否则返回false
	 */
	public static boolean isNull(String input) {
		return input == null || "null".equals(input);
	}

	/**
	 * 判断字符串是否为空或null
	 * 
	 * @param input
	 *            给定的字符串
	 * @return 如果字符串为空或null，返回true，否则返回false
	 */
	public static boolean isNullOrEmpty(String input) {
		return StringUtil.isNull(input) || input.trim().equals("");
	}

	/**
	 * 用UTF-8进行解码
	 * 
	 * @param str
	 * @return
	 * @throws UtilityException
	 */
	public static String decodeStringByUTF8(String str) throws Exception {
		if (isNullOrEmpty(str)) {
			return "";
		} else {
			str = clean(str);
			try {
				return URLDecoder.decode(str, utf8);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new Exception("解码为UTF-8出现错误");
			}
		}

	}

	/**
	 * 用UTF-8进行编码
	 * 
	 * @param str
	 * @return
	 * @throws UtilityException
	 */
	public static String encodeStringByUTF8(String str) throws Exception {
		if (isNullOrEmpty(str)) {
			return "";
		} else {
			str = clean(str);
			try {
				return URLEncoder.encode(str, utf8);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new Exception("编码为UTF-8出现错误");
			}
		}

	}

	/**
	 * 判断字符串是否符合给定的正则表达式
	 * 
	 * @param input
	 *            给定的字符串
	 * @param regex
	 *            给定的正则表达式
	 * @return 如果input符合给定的正则表达式，则返回true，否则返回false
	 */
	public static boolean isAccord(String input, String regex) {
		return Pattern.matches(regex, input);
	}

	/**
	 * 去掉字符串中的空字节，如果字符串为空则返回空串
	 * 
	 * @param input
	 *            the String to clean, may be null
	 * @return the trimmed text, never <code>null</code>
	 * @see String#trim()
	 */
	public static String clean(String input) {
		return input == null || "null".equals(input) ? EMPTY : input.trim();
	}

	/**
	 * 去掉字符串中的空
	 * 
	 * @param input
	 * @return the String to be trimmed, may be null
	 */
	public static String trim(String input) {
		return input == null ? null : input.trim();
	}

	/**
	 * 比较给定的字符串
	 * 
	 * @param input1
	 *            the first String, may be null
	 * @param input2
	 *            the second String, may be null
	 * @return <code>true</code> if the Strings are equal, case sensitive, or
	 *         both <code>null</code>
	 */
	public static boolean equals(String input1, String input2) {
		return input1 == null ? input2 == null : input1.equals(input2);
	}

	/**
	 * 比较给定的字符串(忽略字母大小写)
	 * 
	 * @param input1
	 *            the first String, may be null
	 * @param input2
	 *            the second String, may be null
	 * @return <code>true</code> if the Strings are equal, case sensitive, or
	 *         both <code>null</code>
	 */
	public static boolean equalsIgnoreCase(String input1, String input2) {
		return input1 == null ? input2 == null : input1
				.equalsIgnoreCase(input2);
	}

	/**
	 * 已给定的字符分割数组
	 * 
	 * @param value
	 * @param symbol
	 * @return
	 */
	public static String fillSymbol(String[] value, String symbol) {
		if (value == null || value.length < 1)
			return null;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < value.length; i++) {
			result.append(value[i]);
			if (i != value.length - 1) {
				result.append(symbol);
			}
		}
		return result.toString();
	}

	public static String fillSymbol(Collection<String> value, String symbol) {
		if (value == null || value.size() < 1) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		for (String string : value) {
			result.append(string);
			result.append(symbol);
		}
		if (result.length() > 0) {
			if (result.charAt(result.length() - 1) == symbol.toCharArray()[0]) {
				result.deleteCharAt(result.length() - 1);
			}
		}
		return result.toString();
	}

	/**
	 * 以逗号分割数组
	 * 
	 * @param value
	 * @return
	 */
	public static String fillComma(Collection<String> value) {
		return fillSymbol(value, ",");
	}

	/**
	 * 以逗号分割数组
	 * 
	 * @param value
	 * @return
	 */
	public static String fillComma(String[] value) {
		return fillSymbol(value, ",");
	}

	/**
	 * 已给定的字符分割字符串
	 * 
	 * @param str
	 * @param symbol
	 * @return
	 */
	public static String[] splitSymbol(String str, String symbol) {
		if (str == null || "".equals(str))
			return null;
		String[] strs = str.split(symbol);
		return strs;
	}

	/**
	 * 以逗号分割字符串，返回数组
	 * 
	 * @param str
	 * @return
	 */
	public static String[] splitComma(String str) {
		return splitSymbol(str, ",");
	}

	public static String replace(String str, String token, String s) {
		return null;
	}

	/**
	 * 将yyyy-mm-dd字符串转换成yyyymmdd
	 * 
	 * @param dateFormat
	 * @return
	 */
	public static String changeDateFormat(String dateFormat) {
		if (isNullOrEmpty(dateFormat))
			return null;
		String[] strs = dateFormat.split("-");
		StringBuffer result = new StringBuffer(strs[0]).append(strs[1]).append(
				strs[2]);
		return result.toString();
	}

	public static String toChinese(String strvalue) {
		try {
			if (isNullOrEmpty(strvalue)) {
				return "";
			} else {
				strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK")
						.trim();
				return strvalue;
			}
		} catch (Exception e) {
			return "";
		}
	}

	public static String chineseToISO8859_1(String strvalue) {
		try {
			if (isNullOrEmpty(strvalue)) {
				return "";
			} else {
				strvalue = new String(strvalue.getBytes("GBK"), "ISO8859-1")
						.trim();
				return strvalue;
			}
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
	 * 去除字符串中的空格、回车、换行符、制表符
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("-|\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");

		}
		return dest;
	}
	
	/**
	  * 功能：去掉所有的<*>标记,去除html标签
	  * 
	  * @param content
	  * @return
	  */
	public String removeTagFromText(String content) {
		Pattern p = null;
		Matcher m = null;
		String value = null;
		// 去掉<>标签
		p = Pattern.compile("(<[^>]*>)");
		m = p.matcher(content);
		String temp = content;
		while (m.find()) {
			value = m.group(0);
			temp = temp.replace(value, "");
		}
		// 去掉换行或回车符号
		p = Pattern.compile("(/r+|/n+)");
		m = p.matcher(temp);
		while (m.find()) {
			value = m.group(0);
			temp = temp.replace(value, " ");
			// System.out.println("....." + value);
		}
		return temp;
	}
}
