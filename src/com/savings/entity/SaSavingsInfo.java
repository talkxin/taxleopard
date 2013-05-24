package com.savings.entity;

/**
 * SaSavingsInfo entity. @author MyEclipse Persistence Tools
 */

public class SaSavingsInfo implements java.io.Serializable {

	// Fields

	private Integer siid;
	private Integer uid;
	private Integer savingsType;
	private String savingsName;
	private String savingsTime;
	private String savingsAccount;

	// Constructors

	/** default constructor */
	public SaSavingsInfo() {
	}

	/** minimal constructor */
	public SaSavingsInfo(Integer siid) {
		this.siid = siid;
	}

	/** full constructor */
	public SaSavingsInfo(Integer siid, Integer uid, Integer savingsType,
			String savingsName, String savingsTime, String savingsAccount) {
		this.siid = siid;
		this.uid = uid;
		this.savingsType = savingsType;
		this.savingsName = savingsName;
		this.savingsTime = savingsTime;
		this.savingsAccount = savingsAccount;
	}

	// Property accessors

	public Integer getSiid() {
		return this.siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getSavingsType() {
		return this.savingsType;
	}

	public void setSavingsType(Integer savingsType) {
		this.savingsType = savingsType;
	}

	public String getSavingsName() {
		return this.savingsName;
	}

	public void setSavingsName(String savingsName) {
		this.savingsName = savingsName;
	}

	public String getSavingsTime() {
		return this.savingsTime;
	}

	public void setSavingsTime(String savingsTime) {
		this.savingsTime = savingsTime;
	}

	public String getSavingsAccount() {
		return this.savingsAccount;
	}

	public void setSavingsAccount(String savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

}