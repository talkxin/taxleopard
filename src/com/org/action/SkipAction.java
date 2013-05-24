package com.org.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SkipAction extends ActionSupport {

	/***
	 * 跳转添加税级
	 * */
	public String skipAddDuty() throws Exception {
//		DutysDaoImpl d = new DutysDaoImpl();
//		List<Dutys> list = d.findDutys();
//		ActionContext.getContext().put("list", list);
		return "skipAddDuty";
	}

	/**
	 * 跳转添加税模块
	 * */
	public String skipAddDutys() throws Exception {

		return "skipAddDutys";
	}

	/**
	 * 跳转添加新闻
	 * */
	public String skipAddPress() throws Exception {
		return "skipAddPress";
	}
}
