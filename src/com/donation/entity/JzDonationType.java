package com.donation.entity;

/**
 * JzDonationType entity. @author MyEclipse Persistence Tools
 */

public class JzDonationType implements java.io.Serializable {

	// Fields

	private Integer dtid;
	private String donationName;
	private String donationType;

	// Constructors

	/** default constructor */
	public JzDonationType() {
	}

	/** minimal constructor */
	public JzDonationType(Integer dtid) {
		this.dtid = dtid;
	}

	/** full constructor */
	public JzDonationType(Integer dtid, String donationName, String donationType) {
		this.dtid = dtid;
		this.donationName = donationName;
		this.donationType = donationType;
	}

	// Property accessors

	public Integer getDtid() {
		return this.dtid;
	}

	public void setDtid(Integer dtid) {
		this.dtid = dtid;
	}

	public String getDonationName() {
		return this.donationName;
	}

	public void setDonationName(String donationName) {
		this.donationName = donationName;
	}

	public String getDonationType() {
		return this.donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

}