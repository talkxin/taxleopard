package com.savings.entity;

/**
 * SaInterest entity. @author MyEclipse Persistence Tools
 */

public class SaInterest implements java.io.Serializable {

	// Fields

	private Integer iid;
	private Integer siid;
	private String interestTime;
	private String interest;
	private String interestRate;

	// Constructors

	/** default constructor */
	public SaInterest() {
	}

	/** minimal constructor */
	public SaInterest(Integer iid) {
		this.iid = iid;
	}

	/** full constructor */
	public SaInterest(Integer iid, Integer sid, String interestTime,
			String interest, String interestRate) {
		this.iid = iid;
		this.siid = sid;
		this.interestTime = interestTime;
		this.interest = interest;
		this.interestRate = interestRate;
	}

	// Property accessors

	public Integer getIid() {
		return this.iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public Integer getSiid() {
		return this.siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	public String getInterestTime() {
		return this.interestTime;
	}

	public void setInterestTime(String interestTime) {
		this.interestTime = interestTime;
	}

	public String getInterest() {
		return this.interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

}