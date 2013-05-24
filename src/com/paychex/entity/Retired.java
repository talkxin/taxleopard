package com.paychex.entity;
/**
 * 退职费表
 * */
public class Retired {

	private Integer rid;
	private Integer uid;
	private String retiredCompanyName;
	private String retiredDay;
	private Integer workYears;
	private String retiredNumber;
	private String retiredTax;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getRetiredCompanyName() {
		return retiredCompanyName;
	}
	public void setRetiredCompanyName(String retiredCompanyName) {
		this.retiredCompanyName = retiredCompanyName;
	}
	public String getRetiredDay() {
		return retiredDay;
	}
	public void setRetiredDay(String retiredDay) {
		this.retiredDay = retiredDay;
	}
	public Integer getWorkYears() {
		return workYears;
	}
	public void setWorkYears(Integer workYears) {
		this.workYears = workYears;
	}
	public String getRetiredNumber() {
		return retiredNumber;
	}
	public void setRetiredNumber(String retiredNumber) {
		this.retiredNumber = retiredNumber;
	}
	public String getRetiredTax() {
		return retiredTax;
	}
	public void setRetiredTax(String retiredTax) {
		this.retiredTax = retiredTax;
	}
	
	
}
