package org.motorframework.core.pojo;

public class Page {
	private int pageSize = 10;
	private int pageNumber = 1;
	private int beginNumber;
	private int endNumber;
	
	public Page(){
		super();
	}
	
	public Page(int pageSize,int pageNumber){
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getBeginNumber() {
		return getEndNumber()-pageSize+1;
	}

	public int getEndNumber() {
		return pageSize*pageNumber;
	}
}
