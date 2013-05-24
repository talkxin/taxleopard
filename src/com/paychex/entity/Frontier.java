package com.paychex.entity;
/**
 * 出入境管理表
 * */
public class Frontier {

	private Integer pfid;
	private Integer uid;
	private String entryDate;
	private String situationDate;
	private Integer inChinaDays;
	private Integer inTaxDays;
	public Integer getPfid() {
		return pfid;
	}
	public void setPfid(Integer pfid) {
		this.pfid = pfid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getSituationDate() {
		return situationDate;
	}
	public void setSituationDate(String situationDate) {
		this.situationDate = situationDate;
	}
	public Integer getInChinaDays() {
		return inChinaDays;
	}
	public void setInChinaDays(Integer inChinaDays) {
		this.inChinaDays = inChinaDays;
	}
	public Integer getInTaxDays() {
		return inTaxDays;
	}
	public void setInTaxDays(Integer inTaxDays) {
		this.inTaxDays = inTaxDays;
	}
	
}
