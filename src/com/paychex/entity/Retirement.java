package com.paychex.entity;
/**
 * 退养费表
 * */
public class Retirement {

	private Integer reid;
	private Integer uid;
	private String retirementCompanyName;
	private String retirementDay1;
	private String retirementDay2;
	private String retirementOnPay;
	private Integer retirementType;
	private String retirementNumber;
	private String retirementTax;
	public Integer getReid() {
		return reid;
	}
	public void setReid(Integer reid) {
		this.reid = reid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getRetirementCompanyName() {
		return retirementCompanyName;
	}
	public void setRetirementCompanyName(String retirementCompanyName) {
		this.retirementCompanyName = retirementCompanyName;
	}
	public String getRetirementDay1() {
		return retirementDay1;
	}
	public void setRetirementDay1(String retirementDay1) {
		this.retirementDay1 = retirementDay1;
	}
	public String getRetirementDay2() {
		return retirementDay2;
	}
	public void setRetirementDay2(String retirementDay2) {
		this.retirementDay2 = retirementDay2;
	}
	public String getRetirementOnPay() {
		return retirementOnPay;
	}
	public void setRetirementOnPay(String retirementOnPay) {
		this.retirementOnPay = retirementOnPay;
	}
	public Integer getRetirementType() {
		return retirementType;
	}
	public void setRetirementType(Integer retirementType) {
		this.retirementType = retirementType;
	}
	public String getRetirementNumber() {
		return retirementNumber;
	}
	public void setRetirementNumber(String retirementNumber) {
		this.retirementNumber = retirementNumber;
	}
	public String getRetirementTax() {
		return retirementTax;
	}
	public void setRetirementTax(String retirementTax) {
		this.retirementTax = retirementTax;
	}
	
	
}
