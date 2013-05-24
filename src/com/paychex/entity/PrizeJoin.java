package com.paychex.entity;

/**
 * 奖金类型与奖金信息连接
 * */
public class PrizeJoin {

	private Integer pid;
	private Integer uid;
	private String prizeInDay;
	private Integer ptid;
	private String prizeNumber;
	private String prizeTax;
	private String prizeName;
	private Integer prizeType;
	private Integer prizeTypeDate;
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
	@Override
	public String toString() {
		return "PrizeJoin [pid=" + pid + ", prizeInDay=" + prizeInDay
				+ ", prizeName=" + prizeName + ", prizeNumber=" + prizeNumber
				+ ", prizeTax=" + prizeTax + ", prizeType=" + prizeType
				+ ", prizeTypeDate=" + prizeTypeDate + ", ptid=" + ptid
				+ ", uid=" + uid + "]";
	}
	
	
	
}
