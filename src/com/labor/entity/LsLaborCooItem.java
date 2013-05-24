package com.labor.entity;

/**
 * LsLaborCooItem entity. @author MyEclipse Persistence Tools
 */

public class LsLaborCooItem implements java.io.Serializable {

	// Fields

	private Integer ltid;
	private Integer lid;
	private Integer uid;
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	private String itemName;

	// Constructors

	/** default constructor */
	public LsLaborCooItem() {
	}

	/** minimal constructor */
	public LsLaborCooItem(Integer ltid) {
		this.ltid = ltid;
	}

	/** full constructor */
	public LsLaborCooItem(Integer ltid, Integer lid, String itemName) {
		this.ltid = ltid;
		this.lid = lid;
		this.itemName = itemName;
	}

	// Property accessors

	public Integer getLtid() {
		return this.ltid;
	}

	public void setLtid(Integer ltid) {
		this.ltid = ltid;
	}

	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}