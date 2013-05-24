package com.paychex.entity;
/**
 * 扣除项表
 * */
public class Deduction {

	private Integer did;
	private Integer uid;
	private String deductionDay;
	private String deductionName;
	private String deductionNumber;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
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
	public String getDeductionName() {
		return deductionName;
	}
	public void setDeductionName(String deductionName) {
		this.deductionName = deductionName;
	}
	public String getDeductionNumber() {
		return deductionNumber;
	}
	public void setDeductionNumber(String deductionNumber) {
		this.deductionNumber = deductionNumber;
	}
	
	
	
}
