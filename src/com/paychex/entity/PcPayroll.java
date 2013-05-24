package com.paychex.entity;

/**
 * PcPayroll entity. @author MyEclipse Persistence Tools
 */

public class PcPayroll implements java.io.Serializable {

	// Fields

	private Integer pid;
	private Integer uid;
	private String inPayDay;
	private String payInNumber;
	private String taxableNumber;
	private String taxNumber;
	private String payOutNumber;
	private Integer payType;
	private String basicWage;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getInPayDay() {
		return inPayDay;
	}
	public void setInPayDay(String inPayDay) {
		this.inPayDay = inPayDay;
	}
	public String getPayInNumber() {
		return payInNumber;
	}
	public void setPayInNumber(String payInNumber) {
		this.payInNumber = payInNumber;
	}
	public String getTaxableNumber() {
		return taxableNumber;
	}
	public void setTaxableNumber(String taxableNumber) {
		this.taxableNumber = taxableNumber;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	public String getPayOutNumber() {
		return payOutNumber;
	}
	public void setPayOutNumber(String payOutNumber) {
		this.payOutNumber = payOutNumber;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public String getBasicWage() {
		return basicWage;
	}
	public void setBasicWage(String basicWage) {
		this.basicWage = basicWage;
	}


}