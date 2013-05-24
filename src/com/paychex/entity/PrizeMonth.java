package com.paychex.entity;

/**
 * 12个月各个月的奖金和 视图
 * */
public class PrizeMonth {

	private Integer uid;
	private String prMonth;
	private String monthPrize;
	private String prizeYear;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
    

	public String getPrMonth() {
		return prMonth;
	}
	public void setPrMonth(String prMonth) {
		this.prMonth = prMonth;
	}
	public String getMonthPrize() {
		return monthPrize;
	}
	public void setMonthPrize(String monthPrize) {
		this.monthPrize = monthPrize;
	}
	public String getPrizeYear() {
		return prizeYear;
	}
	public void setPrizeYear(String prizeYear) {
		this.prizeYear = prizeYear;
	}
	
}
