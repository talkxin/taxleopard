package com.house.entity;

/**
 * HpRentalHouseInfo entity. @author MyEclipse Persistence Tools
 */

public class HpRentalHouseInfo implements java.io.Serializable {

	// Fields

	private Integer rhid;
	private Integer hid;
	private Integer uid;
	private Integer rid;
	private String rentalRenovation;
	private String rentalStartTime;
	private String rentalEndTime;
	private Integer rentalMM;
	private String rentalRepairs;
	private String rentalNumber;
	private String rentalTaxed;
	private Integer rentalTaxType;
	private String rentalTaxNumber;
	private String rentalTax;
	private String rentalTaxEndNumber;

	// Constructors

	public String getRentalRepairs() {
		return rentalRepairs;
	}

	public void setRentalRepairs(String rentalRepairs) {
		this.rentalRepairs = rentalRepairs;
	}

	/** default constructor */
	public HpRentalHouseInfo() {
	}

	public String getRentalRenovation() {
		return rentalRenovation;
	}

	public void setRentalRenovation(String rentalRenovation) {
		this.rentalRenovation = rentalRenovation;
	}

	public Integer getRentalMM() {
		return rentalMM;
	}

	public void setRentalMM(Integer rentalMM) {
		this.rentalMM = rentalMM;
	}

	/** minimal constructor */
	public HpRentalHouseInfo(Integer rhid) {
		this.rhid = rhid;
	}

	/** full constructor */
	public HpRentalHouseInfo(Integer rhid, Integer hid, Integer uid,
			Integer rid, String rentalStartTime, String rentalEndTime,
			Integer rentalMn, String rentalNumber, String rentalTaxed,
			Integer rentalTaxType, String rentalTaxNumber, String rentalTax,
			String rentalTaxEndNumber) {
		this.rhid = rhid;
		this.hid = hid;
		this.uid = uid;
		this.rid = rid;
		this.rentalStartTime = rentalStartTime;
		this.rentalEndTime = rentalEndTime;
		this.rentalMM = rentalMn;
		this.rentalNumber = rentalNumber;
		this.rentalTaxed = rentalTaxed;
		this.rentalTaxType = rentalTaxType;
		this.rentalTaxNumber = rentalTaxNumber;
		this.rentalTax = rentalTax;
		this.rentalTaxEndNumber = rentalTaxEndNumber;
	}

	// Property accessors

	public Integer getRhid() {
		return this.rhid;
	}

	public void setRhid(Integer rhid) {
		this.rhid = rhid;
	}

	public Integer getHid() {
		return this.hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRentalStartTime() {
		return this.rentalStartTime;
	}

	public void setRentalStartTime(String rentalStartTime) {
		this.rentalStartTime = rentalStartTime;
	}

	public String getRentalEndTime() {
		return this.rentalEndTime;
	}

	public void setRentalEndTime(String rentalEndTime) {
		this.rentalEndTime = rentalEndTime;
	}

	public Integer getRentalMn() {
		return this.rentalMM;
	}

	public void setRentalMn(Integer rentalMn) {
		this.rentalMM = rentalMn;
	}

	public String getRentalNumber() {
		return this.rentalNumber;
	}

	public void setRentalNumber(String rentalNumber) {
		this.rentalNumber = rentalNumber;
	}

	public String getRentalTaxed() {
		return this.rentalTaxed;
	}

	public void setRentalTaxed(String rentalTaxed) {
		this.rentalTaxed = rentalTaxed;
	}

	public Integer getRentalTaxType() {
		return this.rentalTaxType;
	}

	public void setRentalTaxType(Integer rentalTaxType) {
		this.rentalTaxType = rentalTaxType;
	}

	public String getRentalTaxNumber() {
		return this.rentalTaxNumber;
	}

	public void setRentalTaxNumber(String rentalTaxNumber) {
		this.rentalTaxNumber = rentalTaxNumber;
	}

	public String getRentalTax() {
		return this.rentalTax;
	}

	public void setRentalTax(String rentalTax) {
		this.rentalTax = rentalTax;
	}

	public String getRentalTaxEndNumber() {
		return this.rentalTaxEndNumber;
	}

	public void setRentalTaxEndNumber(String rentalTaxEndNumber) {
		this.rentalTaxEndNumber = rentalTaxEndNumber;
	}

}