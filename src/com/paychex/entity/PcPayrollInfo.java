package com.paychex.entity;

/**
 * PcPayrollInfo entity. @author MyEclipse Persistence Tools
 */

public class PcPayrollInfo implements java.io.Serializable {

	// Fields

	private Integer piid;
	private Integer uid;
	private Integer industry;
	private Integer industryXz;
	private String companyName;
	private Integer companyAdd;
	private Integer payDay;
	private String payDay2;
	private String incomeDay;
	private Integer payType;
	private String payNumber;
	private Integer userNation;
	private Integer companType;

	// Constructors

	public String getPayDay2() {
		return payDay2;
	}

	public void setPayDay2(String payDay2) {
		this.payDay2 = payDay2;
	}

	public Integer getCompanType() {
		return companType;
	}

	public void setCompanType(Integer companType) {
		this.companType = companType;
	}

	public Integer getUserNation() {
		return userNation;
	}

	public void setUserNation(Integer userNation) {
		this.userNation = userNation;
	}

	/** default constructor */
	public PcPayrollInfo() {
	}

	/** minimal constructor */
	public PcPayrollInfo(Integer piid) {
		this.piid = piid;
	}

	/** full constructor */
	public PcPayrollInfo(Integer piid, Integer uid, Integer industry,
			Integer industryXz, String companyName, Integer companyAdd,
			Integer payDay, String incomeDay, Integer payType, String payNumber) {
		this.piid = piid;
		this.uid = uid;
		this.industry = industry;
		this.industryXz = industryXz;
		this.companyName = companyName;
		this.companyAdd = companyAdd;
		this.payDay = payDay;
		this.incomeDay = incomeDay;
		this.payType = payType;
		this.payNumber = payNumber;
	}

	// Property accessors

	public Integer getPiid() {
		return this.piid;
	}

	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getIndustry() {
		return this.industry;
	}

	public void setIndustry(Integer industry) {
		this.industry = industry;
	}

	public Integer getIndustryXz() {
		return this.industryXz;
	}

	public void setIndustryXz(Integer industryXz) {
		this.industryXz = industryXz;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCompanyAdd() {
		return this.companyAdd;
	}

	public void setCompanyAdd(Integer companyAdd) {
		this.companyAdd = companyAdd;
	}

	public Integer getPayDay() {
		return this.payDay;
	}

	public void setPayDay(Integer payDay) {
		this.payDay = payDay;
	}

	public String getIncomeDay() {
		return this.incomeDay;
	}

	public void setIncomeDay(String incomeDay) {
		this.incomeDay = incomeDay;
	}

	public Integer getPayType() {
		return this.payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getPayNumber() {
		return this.payNumber;
	}

	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}

}