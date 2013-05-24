package com.paychex.entity;
/**
 * 补贴获取信息表
 * */
public class Subsidy {

	private Integer sid;
	private Integer uid;
	private String subsidyInDay;
	private Integer stid;
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
	@Override
	public String toString() {
		return "Subsidy [sid=" + sid + ", stid=" + stid + ", subsidyInDay="
				+ subsidyInDay + ", subsidyNumber=" + subsidyNumber
				+ ", subsidyTax=" + subsidyTax + ", uid=" + uid + "]";
	}
	
	
}
