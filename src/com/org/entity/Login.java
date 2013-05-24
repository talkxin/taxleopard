package com.org.entity;

import java.util.Date;

/***
 * 登陆记录类
 * */
public class Login {
	private int loginID;// 登录ID编号
	private int loginUserName;// 登录用户
	private Date logintime;// 登陆时间
	private String loginIP;// 登录IP
	private Date loginQuitTime;//登录时间
	public int getLoginID() {
		return loginID;
	}
	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}
	public int getLoginUserName() {
		return loginUserName;
	}
	public void setLoginUserName(int loginUserName) {
		this.loginUserName = loginUserName;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
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
