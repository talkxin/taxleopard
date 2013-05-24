package com.shares.entity;

/**
 * ShSharesInfo entity. @author MyEclipse Persistence Tools
 */

public class ShSharesInfo implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Integer uid;
	private Integer sharesType;
	private String sharesName;
	private Integer equityType;
	private Integer sharesType2;
	private Integer sharesAdd;
	private String sharesInTime;
	private String sharesNumber;
	private String sharesAllNumber;
	private String sharesInDayNumber;
	private String equityOutDay;
	private String taxedNumber;
	private String earlyWarning;
    
	
	// Constructors

	public Integer getSharesType2() {
		return sharesType2;
	}

	public void setSharesType2(Integer sharesType2) {
		this.sharesType2 = sharesType2;
	}

	/** default constructor */
	public ShSharesInfo() {
	}

	/** minimal constructor */
	public ShSharesInfo(Integer sid) {
		this.sid = sid;
	}

	/** full constructor */
	public ShSharesInfo(Integer sid, Integer uid, Integer sharesType,
			String sharesName, Integer equityType, Integer sharesAdd,
			String sharesInTime, String sharesNumber, String sharesAllNumber,
			String sharesInDayNumber, String equityOutDay, String taxedNumber,
			String earlyWarning) {
		this.sid = sid;
		this.uid = uid;
		this.sharesType = sharesType;
		this.sharesName = sharesName;
		this.equityType = equityType;
		this.sharesAdd = sharesAdd;
		this.sharesInTime = sharesInTime;
		this.sharesNumber = sharesNumber;
		this.sharesAllNumber = sharesAllNumber;
		this.sharesInDayNumber = sharesInDayNumber;
		this.equityOutDay = equityOutDay;
		this.taxedNumber = taxedNumber;
		this.earlyWarning = earlyWarning;
		
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getSharesType() {
		return this.sharesType;
	}

	public void setSharesType(Integer sharesType) {
		this.sharesType = sharesType;
	}

	public String getSharesName() {
		return this.sharesName;
	}

	public void setSharesName(String sharesName) {
		this.sharesName = sharesName;
	}

	public Integer getEquityType() {
		return this.equityType;
	}

	public void setEquityType(Integer equityType) {
		this.equityType = equityType;
	}

	public Integer getSharesAdd() {
		return this.sharesAdd;
	}

	public void setSharesAdd(Integer sharesAdd) {
		this.sharesAdd = sharesAdd;
	}

	public String getSharesInTime() {
		return this.sharesInTime;
	}

	public void setSharesInTime(String sharesInTime) {
		this.sharesInTime = sharesInTime;
	}

	public String getSharesNumber() {
		return this.sharesNumber;
	}

	public void setSharesNumber(String sharesNumber) {
		this.sharesNumber = sharesNumber;
	}

	public String getSharesAllNumber() {
		return this.sharesAllNumber;
	}

	public void setSharesAllNumber(String sharesAllNumber) {
		this.sharesAllNumber = sharesAllNumber;
	}

	public String getSharesInDayNumber() {
		return this.sharesInDayNumber;
	}

	public void setSharesInDayNumber(String sharesInDayNumber) {
		this.sharesInDayNumber = sharesInDayNumber;
	}

	public String getEquityOutDay() {
		return this.equityOutDay;
	}

	public void setEquityOutDay(String equityOutDay) {
		this.equityOutDay = equityOutDay;
	}

	public String getTaxedNumber() {
		return this.taxedNumber;
	}

	public void setTaxedNumber(String taxedNumber) {
		this.taxedNumber = taxedNumber;
	}

	public String getEarlyWarning() {
		return this.earlyWarning;
	}

	public void setEarlyWarning(String earlyWarning) {
		this.earlyWarning = earlyWarning;
	}

	
}