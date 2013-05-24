package com.paychex.entity;

/**
 * PcSubsidyType entity. @author MyEclipse Persistence Tools
 */

public class PcSubsidyType implements java.io.Serializable {

	// Fields

	private Integer stid;
	private String subsidyName;
	private Integer subsidyType;

	// Constructors

	/** default constructor */
	public PcSubsidyType() {
	}

	/** minimal constructor */
	public PcSubsidyType(Integer stid) {
		this.stid = stid;
	}

	/** full constructor */
	public PcSubsidyType(Integer stid, String subsidyName, Integer subsidyType) {
		this.stid = stid;
		this.subsidyName = subsidyName;
		this.subsidyType = subsidyType;
	}

	// Property accessors

	public Integer getStid() {
		return this.stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	public String getSubsidyName() {
		return this.subsidyName;
	}

	public void setSubsidyName(String subsidyName) {
		this.subsidyName = subsidyName;
	}

	public Integer getSubsidyType() {
		return this.subsidyType;
	}

	public void setSubsidyType(Integer subsidyType) {
		this.subsidyType = subsidyType;
	}

}