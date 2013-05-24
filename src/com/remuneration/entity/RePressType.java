package com.remuneration.entity;

/**
 * RePressType entity. @author MyEclipse Persistence Tools
 */

public class RePressType implements java.io.Serializable {

	// Fields

	private Integer ptid;
	private Integer uid;
	private String pressName;

	// Constructors

	/** default constructor */
	public RePressType() {
	}

	/** minimal constructor */
	public RePressType(Integer ptid) {
		this.ptid = ptid;
	}

	/** full constructor */
	public RePressType(Integer ptid, Integer uid, String pressName) {
		this.ptid = ptid;
		this.uid = uid;
		this.pressName = pressName;
	}

	// Property accessors

	public Integer getPtid() {
		return this.ptid;
	}

	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getPressName() {
		return this.pressName;
	}

	public void setPressName(String pressName) {
		this.pressName = pressName;
	}

}