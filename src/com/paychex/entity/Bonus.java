package com.paychex.entity;
/**
 * 分红获取信息表
 * */
public class Bonus {

	private Integer bid;
	private Integer uid;
	private String bonusInDay;
	private String bonusNumber;
	private String bonusTax;
	
	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getBonusInDay() {
		return bonusInDay;
	}

	public void setBonusInDay(String bonusInDay) {
		this.bonusInDay = bonusInDay;
	}

	public String getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(String bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	public String getBonusTax() {
		return bonusTax;
	}

	public void setBonusTax(String bonusTax) {
		this.bonusTax = bonusTax;
	}

	@Override
	public String toString() {
		return "Bonus [bid=" + bid + ", bonusInDay=" + bonusInDay
				+ ", bonusNumber=" + bonusNumber + ", bonusTax=" + bonusTax
				+ ", uid=" + uid + "]";
	}
	
	
	
}
