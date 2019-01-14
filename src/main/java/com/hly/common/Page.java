package com.hly.common;

/**
 * Copyright (c) 2005-2011 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: Page.java 1528 2011-04-25 14:58:33Z calvinxiu $
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 与具体ORM实现无关的分页查询结果封装.
 * 
 * @param <T>
 *            Page中记录的类型.
 * 
 * @author calvin
 * @author badqiu
 */
public class Page<T> extends PageRequest implements Iterable<T> {

	protected List<T> result = null;

	public Page() {
	}

	public Page(PageRequest request) {
		super.setTotalRecords(request.getTotalRecords());
		super.setPageSize(request.getPageSize());
		super.setCountTotal(request.countTotal);
		super.setOrderBy(request.getOrderBy());
		super.setOrderDir(request.getOrderDir());
		super.setPageNo(request.getPageNo());
	}

	public Page(List<T> result, long total, int pageNo, int pageSize) {
		super.setTotalRecords(total);
		super.setPageSize(pageSize);
		super.setPageNo(pageNo);
		setResult(result);
		getHtml();
	}

	/**
	 * 获得页内的记录列表.
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * 设置页内的记录列表.
	 */
	public void setResult(final List<T> result) {
		this.result = result;
	}

	/**
	 * 实现Iterable接口, 可以for(Object item : page)遍历使用
	 */
	public Iterator<T> iterator() {
		return result.iterator();
	}

	/**
	 * 是否还有下一页.
	 */
	public boolean hasNextPage() {
		return (getPageNo() + 1 <= getTotalPages());
	}

	/**
	 * 是否最后一页.
	 */
	public boolean isLastPage() {
		return !hasNextPage();
	}

	/**
	 * 取得下页的页号, 序号从1开始. 当前页为尾页时仍返回尾页序号.
	 */
	public int getNextPage() {
		if (hasNextPage()) {
			return getPageNo() + 1;
		} else {
			return getPageNo();
		}
	}

	/**
	 * 是否还有上一页.
	 */
	public boolean hasPrePage() {
		return (getPageNo() > 1);
	}

	/**
	 * 是否第一页.
	 */
	public boolean isFirstPage() {
		return !hasPrePage();
	}

	/**
	 * 取得上页的页号, 序号从1开始. 当前页为首页时返回首页序号.
	 */
	public int getPrePage() {
		if (hasPrePage()) {
			return getPageNo() - 1;
		} else {
			return getPageNo();
		}
	}

	/**
	 * 计算以当前页为中心的页面列表,如"首页,23,24,25,26,27,末页"
	 * 
	 * @param count
	 *            需要计算的列表大小
	 * @return pageNo列表
	 */
	public List<Integer> getSlider(int count) {
		int halfSize = count / 2;
		int totalPage = getTotalPages();

		int startPageNo = Math.max(getPageNo() - halfSize, 1);
		int endPageNo = Math.min(startPageNo + count - 1, totalPage);

		if (endPageNo - startPageNo < count) {
			startPageNo = Math.max(endPageNo - count, 1);
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int i = startPageNo; i <= endPageNo; i++) {
			result.add(i);
		}
		return result;

	}

	public String getHtml() {
		List<Integer> slider = getSlider(5);

		String html = "<ul class=\"pagination\">";
		if (pageNo == 1) {

			html += "<li class=\"paginate_button first  disabled \"><a href=\"#\"  >首页</a></li>";
			html += "<li class=\"paginate_button previous  disabled \"><a href=\"#\"  >上一页</a></li>";

		} else {
			html += "<li class=\"paginate_button first \"><a href=\"#\" onclick=\"pageSkip(this)\" value=\"1\">首页</a></li>";
			html += "<li class=\"paginate_button previous \"><a href=\"#\" onclick=\"pageSkip(this)\" value=\""
					+ (pageNo - 1) + "\">上一页</a></li>";
		}
		;
		for (Integer integer : slider) {

			if (pageNo == integer)
				html += "<li class=\"paginate_button active \"><a href=\"#\" onclick=\"pageSkip(this)\" value=\""
						+ integer + "\">" + integer + "</a></li>";
			else
				html += "<li class=\"paginate_button\"><a href=\"#\" onclick=\"pageSkip(this)\" value=\""
						+ integer + "\">" + integer + "</a></li>";

		}
		if (pageNo == getTotalPages()) {
			html += "<li class=\"paginate_button next disabled \"><a href=\"#\" >下一页</a></li> ";
			html += "<li class=\"paginate_button last disabled \"><a href=\"#\" >尾页</a></li> ";

		} else {
			html += "<li class=\"paginate_button next \"><a href=\"#\" onclick=\"pageSkip(this)\" value=\""
					+ (pageNo + 1) + "\">下一页</a></li>";
			html += "<li class=\"paginate_button last \"><a href=\"#\" onclick=\"pageSkip(this)\" value=\""
					+ getTotalPages() + "\">尾页</a></li>";
		}

		html += "</ul>";


		return html;

	}

}
