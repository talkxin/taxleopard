package com.paychex.entity;

/**
 * IsGetPrizeId entity. @author MyEclipse Persistence Tools
 */

public class IsGetPrize implements java.io.Serializable {

	// Fields

	private Integer pid;
	private Integer uid;
	private String prizeInDay;
	private Integer ptid;
	private String prizeName;
	private Integer prizeType;
	private Integer prizeTypeDate;
	private Double prizeNumber;
	private Double prizeTax;
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
	public String getPrizeName() {
		return prizeName;
	}
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	public Integer getPrizeType() {
		return prizeType;
	}
	public void setPrizeType(Integer prizeType) {
		this.prizeType = prizeType;
	}
	public Integer getPrizeTypeDate() {
		return prizeTypeDate;
	}
	public void setPrizeTypeDate(Integer prizeTypeDate) {
		this.prizeTypeDate = prizeTypeDate;
	}
	public Double getPrizeNumber() {
		return prizeNumber;
	}
	public void setPrizeNumber(Double prizeNumber) {
		this.prizeNumber = prizeNumber;
	}
	public Double getPrizeTax() {
		return prizeTax;
	}
	public void setPrizeTax(Double prizeTax) {
		this.prizeTax = prizeTax;
	}


}