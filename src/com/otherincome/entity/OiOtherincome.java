package com.otherincome.entity;

/**
 * OiOtherincome entity. @author MyEclipse Persistence Tools
 */

public class OiOtherincome implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Integer uid;
	private String otherName;
	private String otherTime;
	private String otherNumber;
	private String otherTax;

	// Constructors

	/** default constructor */
	public OiOtherincome() {
	}

	/** minimal constructor */
	public OiOtherincome(Integer oid) {
		this.oid = oid;
	}

	/** full constructor */
	public OiOtherincome(Integer oid, Integer uid, String otherName,
			String otherTime, String otherNumber, String otherTax) {
		this.oid = oid;
		this.uid = uid;
		this.otherName = otherName;
		this.otherTime = otherTime;
		this.otherNumber = otherNumber;
		this.otherTax = otherTax;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getOtherName() {
		return this.otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getOtherTime() {
		return this.otherTime;
	}

	public void setOtherTime(String otherTime) {
		this.otherTime = otherTime;
	}

	public String getOtherNumber() {
		return this.otherNumber;
	}

	public void setOtherNumber(String otherNumber) {
		this.otherNumber = otherNumber;
	}

	public String getOtherTax() {
		return this.otherTax;
	}

	public void setOtherTax(String otherTax) {
		this.otherTax = otherTax;
	}

}