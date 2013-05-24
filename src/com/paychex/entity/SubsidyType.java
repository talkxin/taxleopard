package com.paychex.entity;
/**
 * 补贴类型表
 * */
public class SubsidyType {

	private Integer stid;
	private String subsidyName;
	private Integer subsidyType;
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
	
	
}
