package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.UserPart;
import com.org.service.UserPartService;

@SuppressWarnings("serial")
public class UserPartAction extends ActionSupport {
	private UserPartService userPartService;
	UserPart userPart;

	public UserPart getUserPart() {
		return userPart;
	}

	public void setUserPart(UserPart userPart) {
		this.userPart = userPart;
	}

	public UserPartService getUserPartService() {
		return userPartService;
	}

	public void setUserPartService(UserPartService userPartService) {
		this.userPartService = userPartService;
	}

	/**
	 * 添加角色
	 * */
	public String addUserPart() throws Exception {
		userPartService.addUserPart(userPart);
		return "addUserPartSuccess";
	}
}
