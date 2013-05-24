package com.paychex.entity;
/**
 * 奖金类型表
 * */
public class PrizeType {

	private Integer ptid;
	private String prizeName;
	private Integer prizeType;
	private Integer prizeTypeDate;
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
	
	
	
}
