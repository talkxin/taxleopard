package com.org.entity;

/**
 * 用户角色表
 * */
public class UserPart {
	private int userPartID;// 用户角色表编号
	private String userPartName;// 用户角色表名称

	public int getUserPartID() {
		return userPartID;
	}

	public void setUserPartID(int userPartID) {
		this.userPartID = userPartID;
	}

	public String getUserPartName() {
		return userPartName;
	}

	public void setUserPartName(String userPartName) {
		this.userPartName = userPartName;
	}

}
