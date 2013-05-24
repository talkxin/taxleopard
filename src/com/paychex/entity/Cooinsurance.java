package com.paychex.entity;
/**
 * 商业保险信息表
 * */
public class Cooinsurance {

	private Integer ciid;
	private Integer uid;
	private String cooinsuranceName;
	private String cooinsuranceType;
	private String insuranceDate;
	private String insuranceNumber;
	private Integer insuranceType;
	private String cooMonth;
	public Integer getCiid() {
		return ciid;
	}
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getCooinsuranceName() {
		return cooinsuranceName;
	}
	public void setCooinsuranceName(String cooinsuranceName) {
		this.cooinsuranceName = cooinsuranceName;
	}
	public String getCooinsuranceType() {
		return cooinsuranceType;
	}
	public void setCooinsuranceType(String cooinsuranceType) {
		this.cooinsuranceType = cooinsuranceType;
	}
	public String getInsuranceDate() {
		return insuranceDate;
	}
	public void setInsuranceDate(String insuranceDate) {
		this.insuranceDate = insuranceDate;
	}
    
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public Integer getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(Integer insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getCooMonth() {
		return cooMonth;
	}
	public void setCooMonth(String cooMonth) {
		this.cooMonth = cooMonth;
	}
    
}
