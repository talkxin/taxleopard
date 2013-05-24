package com.paychex.entity;

/**
 * PcBonus entity. @author MyEclipse Persistence Tools
 */

public class PcBonus implements java.io.Serializable {

	// Fields

	private Integer bid;
	private Integer uid;
	private String bonusInDay;
	private String bonusNumber;
	private String bonusTax;
	private Integer bonusType;

	// Constructors

	public Integer getBonusType() {
		return bonusType;
	}

	public void setBonusType(Integer bonusType) {
		this.bonusType = bonusType;
	}

	/** default constructor */
	public PcBonus() {
	}

	/** minimal constructor */
	public PcBonus(Integer bid) {
		this.bid = bid;
	}

	/** full constructor */
	public PcBonus(Integer bid, Integer uid, String bonusInDay,
			String bonusNumber, String bonusTax) {
		this.bid = bid;
		this.uid = uid;
		this.bonusInDay = bonusInDay;
		this.bonusNumber = bonusNumber;
		this.bonusTax = bonusTax;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getBonusInDay() {
		return this.bonusInDay;
	}

	public void setBonusInDay(String bonusInDay) {
		this.bonusInDay = bonusInDay;
	}

	public String getBonusNumber() {
		return this.bonusNumber;
	}

	public void setBonusNumber(String bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	public String getBonusTax() {
		return this.bonusTax;
	}

	public void setBonusTax(String bonusTax) {
		this.bonusTax = bonusTax;
	}

}