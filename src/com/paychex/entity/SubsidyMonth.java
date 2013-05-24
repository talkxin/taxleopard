package com.paychex.entity;
/**
 * 12个月各个月的补贴和 视图
 * */
public class SubsidyMonth {

	private Integer uid;
	private String suMonth;
	private String monthSubsidy;
	private String subsidyYear;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getSuMonth() {
		return suMonth;
	}
	public void setSuMonth(String suMonth) {
		this.suMonth = suMonth;
	}
	public String getMonthSubsidy() {
		return monthSubsidy;
	}
	public void setMonthSubsidy(String monthSubsidy) {
		this.monthSubsidy = monthSubsidy;
	}
	public String getSubsidyYear() {
		return subsidyYear;
	}
	public void setSubsidyYear(String subsidyYear) {
		this.subsidyYear = subsidyYear;
	}
	
	
}
