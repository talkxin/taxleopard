package com.paychex.entity;

/**
 * PcIndustry entity. @author MyEclipse Persistence Tools
 */

public class PcIndustry implements java.io.Serializable {

	// Fields

	private Integer piid;
	private String industryName;
	private Integer industryType;

	// Constructors

	/** default constructor */
	public PcIndustry() {
	}

	/** minimal constructor */
	public PcIndustry(Integer piid) {
		this.piid = piid;
	}

	/** full constructor */
	public PcIndustry(Integer piid, String industryName, Integer industryType) {
		this.piid = piid;
		this.industryName = industryName;
		this.industryType = industryType;
	}

	// Property accessors

	public Integer getPiid() {
		return this.piid;
	}

	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	public String getIndustryName() {
		return this.industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public Integer getIndustryType() {
		return this.industryType;
	}

	public void setIndustryType(Integer industryType) {
		this.industryType = industryType;
	}

}