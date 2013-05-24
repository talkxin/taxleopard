package com.paychex.entity;
/**
 * 12个月各个月的分红和 视图
 * */
public class BonusMonth {

	private Integer uid;
	private String bonusInDay;
	private String monthBonus;
	private String boMonth;
	private String bonusYear;
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
	public String getMonthBonus() {
		return monthBonus;
	}
	public void setMonthBonus(String monthBonus) {
		this.monthBonus = monthBonus;
	}
	
	public String getBoMonth() {
		return boMonth;
	}
	public void setBoMonth(String boMonth) {
		this.boMonth = boMonth;
	}
	public String getBonusYear() {
		return bonusYear;
	}
	public void setBonusYear(String bonusYear) {
		this.bonusYear = bonusYear;
	}
	
}
