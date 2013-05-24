package com.paychex.entity;

public class DeductionMonth {

	private Integer uid;
	private String deductionDay;
	private String monthDeduction;
	private String dedMonth;
	private String deductionYear;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getDeductionDay() {
		return deductionDay;
	}
	public void setDeductionDay(String deductionDay) {
		this.deductionDay = deductionDay;
	}
	public String getMonthDeduction() {
		return monthDeduction;
	}
	public void setMonthDeduction(String monthDeduction) {
		this.monthDeduction = monthDeduction;
	}
	
	public String getDedMonth() {
		return dedMonth;
	}
	public void setDedMonth(String dedMonth) {
		this.dedMonth = dedMonth;
	}
	public String getDeductionYear() {
		return deductionYear;
	}
	public void setDeductionYear(String deductionYear) {
		this.deductionYear = deductionYear;
	}
	
}
