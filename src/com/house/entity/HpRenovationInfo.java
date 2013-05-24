package com.house.entity;

/**
 * HpRenovationInfo entity. @author MyEclipse Persistence Tools
 */

public class HpRenovationInfo implements java.io.Serializable {

	// Fields

	private Integer rvid;
	private Integer hid;
	private Integer uid;
	private String renovationName;
	private String renovationNumber;

	// Constructors

	/** default constructor */
	public HpRenovationInfo() {
	}

	/** minimal constructor */
	public HpRenovationInfo(Integer rvid) {
		this.rvid = rvid;
	}

	/** full constructor */
	public HpRenovationInfo(Integer rvid, Integer hid, Integer uid,
			String renovationName, String renovationNumber) {
		this.rvid = rvid;
		this.hid = hid;
		this.uid = uid;
		this.renovationName = renovationName;
		this.renovationNumber = renovationNumber;
	}

	// Property accessors

	public Integer getRvid() {
		return this.rvid;
	}

	public void setRvid(Integer rvid) {
		this.rvid = rvid;
	}

	public Integer getHid() {
		return this.hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getRenovationName() {
		return this.renovationName;
	}

	public void setRenovationName(String renovationName) {
		this.renovationName = renovationName;
	}

	public String getRenovationNumber() {
		return this.renovationNumber;
	}

	public void setRenovationNumber(String renovationNumber) {
		this.renovationNumber = renovationNumber;
	}

}