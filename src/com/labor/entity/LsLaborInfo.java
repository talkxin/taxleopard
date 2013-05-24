package com.labor.entity;

/**
 * LsLaborInfo entity. @author MyEclipse Persistence Tools
 */

public class LsLaborInfo implements java.io.Serializable {

	// Fields

	private Integer lid;
	private Integer uid;
	private String companyName;
	private Integer laborType;
	private Integer industry;

	// Constructors

	/** default constructor */
	public LsLaborInfo() {
	}

	/** minimal constructor */
	public LsLaborInfo(Integer lid) {
		this.lid = lid;
	}

	/** full constructor */
	public LsLaborInfo(Integer lid, Integer uid, String companyName,
			Integer laborType, Integer industry) {
		this.lid = lid;
		this.uid = uid;
		this.companyName = companyName;
		this.laborType = laborType;
		this.industry = industry;
	}

	// Property accessors

	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getLaborType() {
		return this.laborType;
	}

	public void setLaborType(Integer laborType) {
		this.laborType = laborType;
	}

	public Integer getIndustry() {
		return this.industry;
	}

	public void setIndustry(Integer industry) {
		this.industry = industry;
	}

}