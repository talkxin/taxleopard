package com.paychex.entity;

/**
 * PcFrontier entity. @author MyEclipse Persistence Tools
 */

public class PcFrontier implements java.io.Serializable {

	// Fields

	private Integer pfid;
	private Integer uid;
	private String entryDate;
	private String situationDate;
	private Integer inChinaDays;
	private Integer inTaxDays;

	// Constructors

	/** default constructor */
	public PcFrontier() {
	}

	/** minimal constructor */
	public PcFrontier(Integer pfid) {
		this.pfid = pfid;
	}

	/** full constructor */
	public PcFrontier(Integer pfid, Integer uid, String entryDate,
			String situationDate, Integer inChinaDays, Integer inTaxDays) {
		this.pfid = pfid;
		this.uid = uid;
		this.entryDate = entryDate;
		this.situationDate = situationDate;
		this.inChinaDays = inChinaDays;
		this.inTaxDays = inTaxDays;
	}

	// Property accessors

	public Integer getPfid() {
		return this.pfid;
	}

	public void setPfid(Integer pfid) {
		this.pfid = pfid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getSituationDate() {
		return this.situationDate;
	}

	public void setSituationDate(String situationDate) {
		this.situationDate = situationDate;
	}

	public Integer getInChinaDays() {
		return this.inChinaDays;
	}

	public void setInChinaDays(Integer inChinaDays) {
		this.inChinaDays = inChinaDays;
	}

	public Integer getInTaxDays() {
		return this.inTaxDays;
	}

	public void setInTaxDays(Integer inTaxDays) {
		this.inTaxDays = inTaxDays;
	}

}