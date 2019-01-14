package com.hly.common;

import java.util.List;

public class DatatablesView<T> {

	
	private List<T> data; //data 与datatales 加载的“dataSrc"对应  

    private long recordsTotal;   

    private long recordsFiltered;  

    private long draw;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public long getDraw() {
		return draw;
	}

	public void setDraw(long draw) {
		this.draw = draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}
    
}
