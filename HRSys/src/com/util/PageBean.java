package com.util;

import java.util.ArrayList;
import java.util.Map;

public class PageBean {
	// 总页�?
	private int totalPageCount = 1;
	// 页面大小，即每页显示记录�?
	private int pageSize = 5;
	// 记录总数
	private int totalCount = 0;
	// 当前页码
	private int currPageNo = 1;
	// 每页结果集合
	private ArrayList resultList;
	
	private Map<String,Object> paraMap;
	
	
	/**
	 * 获取总页�?
	 * 
	 * @return
	 */
	public int getTotalPageCount() {
		// 总记录数total对pageSize取余，如果结果为0，不用加1,否则�?1
		if (totalCount % pageSize == 0) {
			totalPageCount = totalCount / pageSize;
		} else {
			totalPageCount = totalCount / pageSize + 1;
		}

		return totalPageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public ArrayList getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList resultList) {
		this.resultList = resultList;
	}


	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public Map<String, Object> getParaMap() {
		return paraMap;
	}

	public void setParaMap(Map<String, Object> paraMap) {
		this.paraMap = paraMap;
	}

	

}
