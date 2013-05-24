package com.geti.entity;

/**
 * GtGetigongshang entity. @author MyEclipse Persistence Tools
 */

public class GtGetigongshang implements java.io.Serializable {

	// Fields

	private Integer gid;
	private Integer uid;
	private String gtiTime;
	private Integer taxed;
	private String gtiNumber;
	private String taxNumber;
	private String taxableNumber;
	private String payOutNumber;
	private String taxEdNumber;

	// Constructors

	/** default constructor */
	public GtGetigongshang() {
	}

	/** minimal constructor */
	public GtGetigongshang(Integer gid) {
		this.gid = gid;
	}

	/** full constructor */
	public GtGetigongshang(Integer gid, Integer uid, String gtiTime,
			Integer taxed, String gtiNumber, String taxNumber,
			String taxableNumber, String payOutNumber, String taxEdNumber) {
		this.gid = gid;
		this.uid = uid;
		this.gtiTime = gtiTime;
		this.taxed = taxed;
		this.gtiNumber = gtiNumber;
		this.taxNumber = taxNumber;
		this.taxableNumber = taxableNumber;
		this.payOutNumber = payOutNumber;
		this.taxEdNumber = taxEdNumber;
	}

	// Property accessors

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}



	public String getGtiTime() {
		return gtiTime;
	}

	public void setGtiTime(String gtiTime) {
		this.gtiTime = gtiTime;
	}

	public Integer getTaxed() {
		return this.taxed;
	}

	public void setTaxed(Integer taxed) {
		this.taxed = taxed;
	}

	public String getGtiNumber() {
		return this.gtiNumber;
	}

	public void setGtiNumber(String gtiNumber) {
		this.gtiNumber = gtiNumber;
	}

	public String getTaxNumber() {
		return this.taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getTaxableNumber() {
		return this.taxableNumber;
	}

	public void setTaxableNumber(String taxableNumber) {
		this.taxableNumber = taxableNumber;
	}

	public String getPayOutNumber() {
		return this.payOutNumber;
	}

	public void setPayOutNumber(String payOutNumber) {
		this.payOutNumber = payOutNumber;
	}

	public String getTaxEdNumber() {
		return this.taxEdNumber;
	}

	public void setTaxEdNumber(String taxEdNumber) {
		this.taxEdNumber = taxEdNumber;
	}

}