package com.hly.common;

import java.util.List;

public class ListView<T> {

	
	private List<T> data; //data 与datatales 加载的“dataSrc"对应  

    private long currentPage;   

    private long totalPages;  

    
    
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	

}
