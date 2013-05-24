package com.paychex.entity;

/**
 * PcCooinsurance entity. @author MyEclipse Persistence Tools
 */

public class PcCooinsurance implements java.io.Serializable {

	// Fields

	private Integer ciid;
	private Integer uid;
	private String cooinsuranceName;
	private String cooinsuranceType;
	private String insuranceDate;
	private String insuranceNumber;
	private Integer insuranceType;

	// Constructors

	/** default constructor */
	public PcCooinsurance() {
	}

	/** minimal constructor */
	public PcCooinsurance(Integer ciid) {
		this.ciid = ciid;
	}

	/** full constructor */
	public PcCooinsurance(Integer ciid, Integer uid, String cooinsuranceName,
			String cooinsuranceType, String insuranceDate,
			String insuranceNumber, Integer insuranceType) {
		this.ciid = ciid;
		this.uid = uid;
		this.cooinsuranceName = cooinsuranceName;
		this.cooinsuranceType = cooinsuranceType;
		this.insuranceDate = insuranceDate;
		this.insuranceNumber = insuranceNumber;
		this.insuranceType = insuranceType;
	}

	// Property accessors

	public Integer getCiid() {
		return this.ciid;
	}

	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getCooinsuranceName() {
		return this.cooinsuranceName;
	}

	public void setCooinsuranceName(String cooinsuranceName) {
		this.cooinsuranceName = cooinsuranceName;
	}

	public String getCooinsuranceType() {
		return this.cooinsuranceType;
	}

	public void setCooinsuranceType(String cooinsuranceType) {
		this.cooinsuranceType = cooinsuranceType;
	}

	public String getInsuranceDate() {
		return this.insuranceDate;
	}

	public void setInsuranceDate(String insuranceDate) {
		this.insuranceDate = insuranceDate;
	}

	public String getInsuranceNumber() {
		return this.insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public Integer getInsuranceType() {
		return this.insuranceType;
	}

	public void setInsuranceType(Integer insuranceType) {
		this.insuranceType = insuranceType;
	}

}