package com.paychex.entity;

/**
 * IsGetSubsidyId entity. @author MyEclipse Persistence Tools
 */

public class IsGetSubsidy implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Integer uid;
	private String subsidyInDay;
	private Integer stid;
	private String subsidyName;
	private Integer subsidyType;
	private String subsidyNumber;
	private String subsidyTax;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getSubsidyInDay() {
		return subsidyInDay;
	}
	public void setSubsidyInDay(String subsidyInDay) {
		this.subsidyInDay = subsidyInDay;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getSubsidyName() {
		return subsidyName;
	}
	public void setSubsidyName(String subsidyName) {
		this.subsidyName = subsidyName;
	}
	public Integer getSubsidyType() {
		return subsidyType;
	}
	public void setSubsidyType(Integer subsidyType) {
		this.subsidyType = subsidyType;
	}
	public String getSubsidyNumber() {
		return subsidyNumber;
	}
	public void setSubsidyNumber(String subsidyNumber) {
		this.subsidyNumber = subsidyNumber;
	}
	public String getSubsidyTax() {
		return subsidyTax;
	}
	public void setSubsidyTax(String subsidyTax) {
		this.subsidyTax = subsidyTax;
	}


}