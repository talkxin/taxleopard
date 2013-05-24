package com.paychex.entity;

/**
 * PcSubsidy entity. @author MyEclipse Persistence Tools
 */

public class PcSubsidy implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Integer uid;
	private String subsidyInDay;
	private Integer stid;
	private String subsidyNumber;
	private String subsidyTax;

	// Constructors

	/** default constructor */
	public PcSubsidy() {
	}

	/** minimal constructor */
	public PcSubsidy(Integer sid) {
		this.sid = sid;
	}

	/** full constructor */
	public PcSubsidy(Integer sid, Integer uid, String subsidyInDay,
			Integer stid, String subsidyNumber, String subsidyTax) {
		this.sid = sid;
		this.uid = uid;
		this.subsidyInDay = subsidyInDay;
		this.stid = stid;
		this.subsidyNumber = subsidyNumber;
		this.subsidyTax = subsidyTax;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getSubsidyInDay() {
		return this.subsidyInDay;
	}

	public void setSubsidyInDay(String subsidyInDay) {
		this.subsidyInDay = subsidyInDay;
	}

	public Integer getStid() {
		return this.stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	public String getSubsidyNumber() {
		return this.subsidyNumber;
	}

	public void setSubsidyNumber(String subsidyNumber) {
		this.subsidyNumber = subsidyNumber;
	}

	public String getSubsidyTax() {
		return this.subsidyTax;
	}

	public void setSubsidyTax(String subsidyTax) {
		this.subsidyTax = subsidyTax;
	}

}