package com.qaqrz.onlinexam.util;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class PageTag extends SimpleTagSupport {
	private int curPage;
	private int totalPage;
	private int rows;
	private String url;

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		sb.append("<p>共");
		sb.append(rows);
		sb.append("条记录&nbsp;共");
		sb.append(totalPage);
		sb.append("页&nbsp;当前页: ");
		sb.append(curPage);
		sb.append("<a href=");
		sb.append(url);
		sb.append("=1>首页</a>&nbsp;<a href=");
		int prePage = curPage < 2 ? curPage : curPage - 1;
		int nextPage = curPage >= totalPage ? totalPage : curPage + 1;
		sb.append(url + "=" + prePage);
		sb.append(">上一页</a>&nbsp;<a href=");
		sb.append(url + "=" + nextPage);
		sb.append(">下一页</a>&nbsp;<a href=");
		sb.append(url + "=" + totalPage);
		sb.append(">末页</a></p>");
		out.write(sb.toString());
	}
}