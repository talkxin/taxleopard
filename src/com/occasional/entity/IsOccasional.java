package com.occasional.entity;
/**
 偶然所得两表连接时候的视图
 * */
public class IsOccasional {

	private Integer oid;
	private Integer uid;
	private Integer oiid;
	private String occasionalName;
	private Integer occasionalType;
	private String occasionalNumber;
	private String occasionalTime;
	private Integer taxed;
	private String taxableNumber;
	private String taxNumber;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public Integer getOiid() {
		return oiid;
	}
	public void setOiid(Integer oiid) {
		this.oiid = oiid;
	}
	public String getOccasionalName() {
		return occasionalName;
	}
	public void setOccasionalName(String occasionalName) {
		this.occasionalName = occasionalName;
	}
	public Integer getOccasionalType() {
		return occasionalType;
	}
	public void setOccasionalType(Integer occasionalType) {
		this.occasionalType = occasionalType;
	}
	public String getOccasionalNumber() {
		return occasionalNumber;
	}
	public void setOccasionalNumber(String occasionalNumber) {
		this.occasionalNumber = occasionalNumber;
	}
	public String getOccasionalTime() {
		return occasionalTime;
	}
	public void setOccasionalTime(String occasionalTime) {
		this.occasionalTime = occasionalTime;
	}
	public Integer getTaxed() {
		return taxed;
	}
	public void setTaxed(Integer taxed) {
		this.taxed = taxed;
	}
	public String getTaxableNumber() {
		return taxableNumber;
	}
	public void setTaxableNumber(String taxableNumber) {
		this.taxableNumber = taxableNumber;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	
}
