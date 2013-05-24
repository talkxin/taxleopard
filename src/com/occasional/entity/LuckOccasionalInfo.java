package com.occasional.entity;

/**
 * LuckOccasionalInfo entity. @author MyEclipse Persistence Tools
 */

public class LuckOccasionalInfo implements java.io.Serializable {

	// Fields

	private Integer oiid;
	private Integer oid;
	private String occasionalNumber;
	private String occasionalTime;
	private Integer taxed;
	private String taxableNumber;
	private String taxNumber;
	private Integer occasionalType;
	// Constructors

	/** default constructor */
	public LuckOccasionalInfo() {
	}

	/** minimal constructor */
	public LuckOccasionalInfo(Integer oiid) {
		this.oiid = oiid;
	}

	/** full constructor */
	public LuckOccasionalInfo(Integer oiid,Integer oid,Integer uid, String occasionalName,
			Integer occasionalType, String occasionalNumber, String occasionalTime,
			Integer taxed, String taxableNumber, String taxNumber) {
		this.oiid = oiid;
		this.oid=oid;
        this.occasionalNumber = occasionalNumber;
		this.occasionalTime = occasionalTime;
		this.taxed = taxed;
		this.taxableNumber = taxableNumber;
		this.taxNumber = taxNumber;
	}

	public Integer getOiid() {
		return oiid;
	}

	public void setOiid(Integer oiid) {
		this.oiid = oiid;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOccasionalNumber() {
		return occasionalNumber;
	}

	public void setOccasionalNumber(String occasionalNumber) {
		this.occasionalNumber = occasionalNumber;
	}

	public String getOccasionalTime() {
		return occasionalTime;
	}

	public void setOccasionalTime(String occasionalTime) {
		this.occasionalTime = occasionalTime;
	}

	public Integer getTaxed() {
		return taxed;
	}

	public void setTaxed(Integer taxed) {
		this.taxed = taxed;
	}

	public String getTaxableNumber() {
		return taxableNumber;
	}

	public void setTaxableNumber(String taxableNumber) {
		this.taxableNumber = taxableNumber;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public Integer getOccasionalType() {
		return occasionalType;
	}

	public void setOccasionalType(Integer occasionalType) {
		this.occasionalType = occasionalType;
	}
    
	// Property accessors
   
}