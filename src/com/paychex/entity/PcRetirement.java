package com.paychex.entity;

/**
 * PcRetirement entity. @author MyEclipse Persistence Tools
 */

public class PcRetirement implements java.io.Serializable {

	// Fields

	private Integer reid;
	private Integer uid;
	private String retirementCompanyName;
	private String retirementDay1;
	private String retirementDay2;
	private String retirementOnPay;
	private Integer retirementType;
	private String retirementNumber;
	private String retirementTax;

	// Constructors

	/** default constructor */
	public PcRetirement() {
	}

	/** minimal constructor */
	public PcRetirement(Integer reid) {
		this.reid = reid;
	}

	/** full constructor */
	public PcRetirement(Integer reid, Integer uid,
			String retirementCompanyName, String retirementDay1,
			String retirementDay2, String retirementOnPay,
			Integer retirementType, String retirementNumber,
			String retirementTax) {
		this.reid = reid;
		this.uid = uid;
		this.retirementCompanyName = retirementCompanyName;
		this.retirementDay1 = retirementDay1;
		this.retirementDay2 = retirementDay2;
		this.retirementOnPay = retirementOnPay;
		this.retirementType = retirementType;
		this.retirementNumber = retirementNumber;
		this.retirementTax = retirementTax;
	}

	// Property accessors

	public Integer getReid() {
		return this.reid;
	}

	public void setReid(Integer reid) {
		this.reid = reid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getRetirementCompanyName() {
		return this.retirementCompanyName;
	}

	public void setRetirementCompanyName(String retirementCompanyName) {
		this.retirementCompanyName = retirementCompanyName;
	}

	public String getRetirementDay1() {
		return this.retirementDay1;
	}

	public void setRetirementDay1(String retirementDay1) {
		this.retirementDay1 = retirementDay1;
	}

	public String getRetirementDay2() {
		return this.retirementDay2;
	}

	public void setRetirementDay2(String retirementDay2) {
		this.retirementDay2 = retirementDay2;
	}

	public String getRetirementOnPay() {
		return this.retirementOnPay;
	}

	public void setRetirementOnPay(String retirementOnPay) {
		this.retirementOnPay = retirementOnPay;
	}

	public Integer getRetirementType() {
		return this.retirementType;
	}

	public void setRetirementType(Integer retirementType) {
		this.retirementType = retirementType;
	}

	public String getRetirementNumber() {
		return this.retirementNumber;
	}

	public void setRetirementNumber(String retirementNumber) {
		this.retirementNumber = retirementNumber;
	}

	public String getRetirementTax() {
		return this.retirementTax;
	}

	public void setRetirementTax(String retirementTax) {
		this.retirementTax = retirementTax;
	}

}