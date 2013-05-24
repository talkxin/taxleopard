package com.org.entity;

import java.util.Date;

/**
 * 登录记录表
 * */
public class AdminRegister {
	private int LoginID;// 登录记录编号
	private String loginUserName;// 登录用户
	private Date loginDate;// 登录时间
	private String loginIP;// 登录IP
	private Date loginQuitTime;// 退出时间

	public int getLoginID() {
		return LoginID;
	}

	public void setLoginID(int loginID) {
		LoginID = loginID;
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	public Date getLoginQuitTime() {
		return loginQuitTime;
	}

	public void setLoginQuitTime(Date loginQuitTime) {
		this.loginQuitTime = loginQuitTime;
	}

}
