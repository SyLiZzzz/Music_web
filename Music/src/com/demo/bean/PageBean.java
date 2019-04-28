package com.demo.bean;

import java.util.List;

public class PageBean {
	private int currentPage;//当前页码
	private int totalCount;//总条数
	private int totalPage;//总页数
	private int currentCount;//每条页数
	private List<Album> ps;//每页显示歌曲的数量
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public List<Album> getPs() {
		return ps;
	}
	public void setPs(List<Album> ps2) {
		this.ps = ps2;
	}


}
