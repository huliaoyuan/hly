package com.hly.common;

import java.util.ArrayList;
import java.util.List;

public class Pagination {

	public static final int DEFAULT_PAGE_SIZE = 10;

	protected int pageNo = 1;
	protected int pageSize = DEFAULT_PAGE_SIZE;
	protected long totalRecords = 0;// 记录总数
	
	public Pagination(int pageNo,int pageSize, long totalRecords ){
		this.pageNo=pageNo;
		this.pageSize=pageSize;
		this.totalRecords=totalRecords;
	}
	
	public Pagination(int pageNo, long totalRecords ){
		this.pageNo=pageNo;
		this.totalRecords=totalRecords;
	}
	
	
	
	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public long getTotalRecords() {
		return totalRecords;
	}


	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}


	public static int getDefaultPageSize() {
		return DEFAULT_PAGE_SIZE;
	}

	/**
	 * 根据pageSize与totalItems计算总页数.
	 */
	public int getTotalPages() {
		return (int) Math.ceil((double) totalRecords / (double) getPageSize());

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
	

	public  static String getHtml(int pageNo,int pageSize,long totalRecords ) {
		       
		int count=5;
		int halfSize = count/2;
		
		int totalPage = (int) Math.ceil((double) totalRecords / (double) pageSize);

		int startPageNo = Math.max(pageNo - halfSize, 1);
		int endPageNo = Math.min(startPageNo + count - 1, totalPage);

		if (endPageNo - startPageNo < count) {
			startPageNo = Math.max(endPageNo - count, 1);
		}

		List<Integer> slider = new ArrayList<Integer>();
		for (int i = startPageNo; i <= endPageNo; i++) {
			slider.add(i);
		}
		
		
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
		if (pageNo == totalPage) {
			html += "<li class=\"paginate_button next disabled \"><a href=\"#\" >下一页</a></li> ";
			html += "<li class=\"paginate_button last disabled \"><a href=\"#\" >尾页</a></li> ";

		} else {
			html += "<li class=\"paginate_button next \"><a href=\"#\" onclick=\"pageSkip(this)\" value=\""
					+ (pageNo + 1) + "\">下一页</a></li>";
			html += "<li class=\"paginate_button last \"><a href=\"#\" onclick=\"pageSkip(this)\" value=\""
					+ totalPage + "\">尾页</a></li>";
		}

		html += "</ul>";


		return html;

	}

	
}
