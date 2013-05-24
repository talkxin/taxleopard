package com.paychex.entity;

/**
 * PcPrize entity. @author MyEclipse Persistence Tools
 */

public class PcPrize implements java.io.Serializable {

	// Fields

	private Integer pid;
	private Integer uid;
	private String prizeInDay;
	private Integer ptid;
	private String prizeNumber;
	private String prizeTax;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getPrizeInDay() {
		return prizeInDay;
	}
	public void setPrizeInDay(String prizeInDay) {
		this.prizeInDay = prizeInDay;
	}
	public Integer getPtid() {
		return ptid;
	}
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}
	public String getPrizeNumber() {
		return prizeNumber;
	}
	public void setPrizeNumber(String prizeNumber) {
		this.prizeNumber = prizeNumber;
	}
	public String getPrizeTax() {
		return prizeTax;
	}
	public void setPrizeTax(String prizeTax) {
		this.prizeTax = prizeTax;
	}

}