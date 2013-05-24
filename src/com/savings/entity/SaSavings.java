package com.savings.entity;

/**
 * SaSavings entity. @author MyEclipse Persistence Tools
 */

public class SaSavings implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Integer siid;
	private Integer uid;
	private Integer savingsType1;
	private Integer savingsType2;
	private String savingsNumber;
	private String savingsStart;
	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	private String interest;
	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}
	private String savingsEnd;
	private String savingsAllTime;
	private String interestRate;
	private String taxNumber;
	private String taxableNumber;
	private String payOutNumber;
	private String taxEdNumber;

	// Constructors

	/** default constructor */
	public SaSavings() {
	}

	public String getSavingsAllTime() {
		return savingsAllTime;
	}

	public void setSavingsAllTime(String savingsAllTime) {
		this.savingsAllTime = savingsAllTime;
	}

	/** minimal constructor */
	public SaSavings(Integer sid) {
		this.sid = sid;
	}

	/** full constructor */
	public SaSavings(Integer sid, Integer siid, Integer uid,
			Integer savingsType1, Integer savingsType2, String savingsNumber,
			String savingsStart, String savingsEnd, String taxNumber,
			String taxableNumber, String payOutNumber, String taxEdNumber) {
		this.sid = sid;
		this.siid = siid;
		this.uid = uid;
		this.savingsType1 = savingsType1;
		this.savingsType2 = savingsType2;
		this.savingsNumber = savingsNumber;
		this.savingsStart = savingsStart;
		this.savingsEnd = savingsEnd;
		this.taxNumber = taxNumber;
		this.taxableNumber = taxableNumber;
		this.payOutNumber = payOutNumber;
		this.taxEdNumber = taxEdNumber;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getSiid() {
		return this.siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getSavingsType1() {
		return this.savingsType1;
	}

	public void setSavingsType1(Integer savingsType1) {
		this.savingsType1 = savingsType1;
	}

	public Integer getSavingsType2() {
		return this.savingsType2;
	}

	public void setSavingsType2(Integer savingsType2) {
		this.savingsType2 = savingsType2;
	}

	public String getSavingsNumber() {
		return this.savingsNumber;
	}

	public void setSavingsNumber(String savingsNumber) {
		this.savingsNumber = savingsNumber;
	}

	public String getSavingsStart() {
		return this.savingsStart;
	}

	public void setSavingsStart(String savingsStart) {
		this.savingsStart = savingsStart;
	}

	public String getSavingsEnd() {
		return this.savingsEnd;
	}

	public void setSavingsEnd(String savingsEnd) {
		this.savingsEnd = savingsEnd;
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