package com.paychex.entity;

/**
 * PcDeduction entity. @author MyEclipse Persistence Tools
 */

public class PcDeduction implements java.io.Serializable {

	// Fields

	private Integer did;
	private Integer uid;
	private String deductionDay;
	private String deductionName;
	private String deductionNumber;

	// Constructors

	/** default constructor */
	public PcDeduction() {
	}

	/** minimal constructor */
	public PcDeduction(Integer did) {
		this.did = did;
	}

	/** full constructor */
	public PcDeduction(Integer did, Integer uid, String deductionDay,
			String deductionName, String deductionNumber) {
		this.did = did;
		this.uid = uid;
		this.deductionDay = deductionDay;
		this.deductionName = deductionName;
		this.deductionNumber = deductionNumber;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getDeductionDay() {
		return this.deductionDay;
	}

	public void setDeductionDay(String deductionDay) {
		this.deductionDay = deductionDay;
	}

	public String getDeductionName() {
		return this.deductionName;
	}

	public void setDeductionName(String deductionName) {
		this.deductionName = deductionName;
	}

	public String getDeductionNumber() {
		return this.deductionNumber;
	}

	public void setDeductionNumber(String deductionNumber) {
		this.deductionNumber = deductionNumber;
	}

}