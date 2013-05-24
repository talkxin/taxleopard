package com.paychex.entity;

public class PayrollMonth {//纳税视图

	private Integer uid;
	private String basicWage;
	private String inPayDay;
	private String taxNumber;
	private String payMonth;
	private String payrollYear;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public String getBasicWage() {
		return basicWage;
	}
	public void setBasicWage(String basicWage) {
		this.basicWage = basicWage;
	}
	public String getInPayDay() {
		return inPayDay;
	}
	public void setInPayDay(String inPayDay) {
		this.inPayDay = inPayDay;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	
	public String getPayMonth() {
		return payMonth;
	}
	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}
	public String getPayrollYear() {
		return payrollYear;
	}
	public void setPayrollYear(String payrollYear) {
		this.payrollYear = payrollYear;
	}
	
}
