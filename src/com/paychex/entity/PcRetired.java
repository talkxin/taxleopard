package com.paychex.entity;

/**
 * PcRetired entity. @author MyEclipse Persistence Tools
 */

public class PcRetired implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Integer uid;
	private String retiredCompanyName;
	private String retiredDay;
	private Integer workYears;
	private String retiredNumber;
	private String retiredTax;

	// Constructors

	/** default constructor */
	public PcRetired() {
	}

	/** minimal constructor */
	public PcRetired(Integer rid) {
		this.rid = rid;
	}

	/** full constructor */
	public PcRetired(Integer rid, Integer uid, String retiredCompanyName,
			String retiredDay, Integer workYears, String retiredNumber,
			String retiredTax) {
		this.rid = rid;
		this.uid = uid;
		this.retiredCompanyName = retiredCompanyName;
		this.retiredDay = retiredDay;
		this.workYears = workYears;
		this.retiredNumber = retiredNumber;
		this.retiredTax = retiredTax;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getRetiredCompanyName() {
		return this.retiredCompanyName;
	}

	public void setRetiredCompanyName(String retiredCompanyName) {
		this.retiredCompanyName = retiredCompanyName;
	}

	public String getRetiredDay() {
		return this.retiredDay;
	}

	public void setRetiredDay(String retiredDay) {
		this.retiredDay = retiredDay;
	}

	public Integer getWorkYears() {
		return this.workYears;
	}

	public void setWorkYears(Integer workYears) {
		this.workYears = workYears;
	}

	public String getRetiredNumber() {
		return this.retiredNumber;
	}

	public void setRetiredNumber(String retiredNumber) {
		this.retiredNumber = retiredNumber;
	}

	public String getRetiredTax() {
		return this.retiredTax;
	}

	public void setRetiredTax(String retiredTax) {
		this.retiredTax = retiredTax;
	}

}