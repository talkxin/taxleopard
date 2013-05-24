package com.org.entity;

import com.org.util.Pager;

/**
 * 新闻管理
 * */
public class Press extends Pager {
	private int pressID;// 新闻编号
	private String pressTitle;// 新闻标题
	private String pressDate;// 新闻发布时间
	private String pressContent;// 新闻内容
	private String pressIntercept;// 新闻内容截取之后的内容

	public String getPressIntercept() {
		return pressIntercept;
	}

	public void setPressIntercept(String pressIntercept) {
		this.pressIntercept = pressIntercept;
	}

	public int getPressID() {
		return pressID;
	}

	public void setPressID(int pressID) {
		this.pressID = pressID;
	}

	public String getPressTitle() {
		return pressTitle;
	}

	public void setPressTitle(String pressTitle) {
		this.pressTitle = pressTitle;
	}

	public String getPressDate() {
		return pressDate;
	}

	public void setPressDate(String pressDate) {
		this.pressDate = pressDate;
	}

	public String getPressContent() {
		return pressContent;
	}

	public void setPressContent(String pressContent) {
		this.pressContent = pressContent;
	}

}
