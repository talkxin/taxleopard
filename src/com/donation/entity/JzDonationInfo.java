package com.donation.entity;

/**
 * JzDonationInfo entity. @author MyEclipse Persistence Tools
 */

public class JzDonationInfo implements java.io.Serializable {

	// Fields

	private Integer diid;
	private Integer uid;
	private Integer dtid;
	private String donationNumber;
	private String donationTime;
	private Integer donationModule;
	private String taxableNumber;
	private String taxOutNumber;
	private String taxOldNumber;

	// Constructors

	/** default constructor */
	public JzDonationInfo() {
	}

	/** minimal constructor */
	public JzDonationInfo(Integer diid) {
		this.diid = diid;
	}

	/** full constructor */
	public JzDonationInfo(Integer diid, Integer uid, Integer dtid,
			String donationNumber, String donationTime, Integer donationModule,
			String taxableNumber, String taxOutNumber, String taxOldNumber) {
		this.diid = diid;
		this.uid = uid;
		this.dtid = dtid;
		this.donationNumber = donationNumber;
		this.donationTime = donationTime;
		this.donationModule = donationModule;
		this.taxableNumber = taxableNumber;
		this.taxOutNumber = taxOutNumber;
		this.taxOldNumber = taxOldNumber;
	}

	// Property accessors

	public Integer getDiid() {
		return this.diid;
	}

	public void setDiid(Integer diid) {
		this.diid = diid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getDtid() {
		return this.dtid;
	}

	public void setDtid(Integer dtid) {
		this.dtid = dtid;
	}

	public String getDonationNumber() {
		return this.donationNumber;
	}

	public void setDonationNumber(String donationNumber) {
		this.donationNumber = donationNumber;
	}

	public String getDonationTime() {
		return this.donationTime;
	}

	public void setDonationTime(String donationTime) {
		this.donationTime = donationTime;
	}

	public Integer getDonationModule() {
		return this.donationModule;
	}

	public void setDonationModule(Integer donationModule) {
		this.donationModule = donationModule;
	}

	public String getTaxableNumber() {
		return this.taxableNumber;
	}

	public void setTaxableNumber(String taxableNumber) {
		this.taxableNumber = taxableNumber;
	}

	public String getTaxOutNumber() {
		return this.taxOutNumber;
	}

	public void setTaxOutNumber(String taxOutNumber) {
		this.taxOutNumber = taxOutNumber;
	}

	public String getTaxOldNumber() {
		return this.taxOldNumber;
	}

	public void setTaxOldNumber(String taxOldNumber) {
		this.taxOldNumber = taxOldNumber;
	}

}