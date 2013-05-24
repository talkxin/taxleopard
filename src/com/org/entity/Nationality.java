package com.org.entity;

/**
 * 国籍表
 * */
public class Nationality {
	private int nationalityID;// 国籍表编号
	private String nationalityName;// 国籍地区名称
	private String nationalityPoint;// 起征点2

	public int getNationalityID() {
		return nationalityID;
	}

	public void setNationalityID(int nationalityID) {
		this.nationalityID = nationalityID;
	}

	public String getNationalityName() {
		return nationalityName;
	}

	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}

	public String getNationalityPoint() {
		return nationalityPoint;
	}

	public void setNationalityPoint(String nationalityPoint) {
		this.nationalityPoint = nationalityPoint;
	}

}
