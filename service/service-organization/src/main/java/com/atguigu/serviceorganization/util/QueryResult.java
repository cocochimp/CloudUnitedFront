
package com.atguigu.serviceorganization.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 分页工具类
 *
 *
 */
public class QueryResult implements Serializable {
	private static final long serialVersionUID = 1L;

	private PageUtils pageUtils;

	public QueryResult(PageUtils pageUtils) {
		this.pageUtils=pageUtils;
	}

	public Map<String,Object> getPageInfo() {
		Map<String,Object> result = new HashMap<>();


		//当前页码
		result.put("current",pageUtils.getCurrPage());

		//总页数
		result.put("pages",pageUtils.getTotalPage());

		//每页的数据
		result.put("info",pageUtils.getList());

		//每页的数据量
		result.put("size",pageUtils.getPageSize());

		//总的数据量
		result.put("total",pageUtils.getTotalCount());

		return result;

	}

	public void setPageUtils(PageUtils pageUtils) {
		this.pageUtils = pageUtils;
	}
}
