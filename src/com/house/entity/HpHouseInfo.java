package com.house.entity;

/**
 * HpHouseInfo entity. @author MyEclipse Persistence Tools
 */

public class HpHouseInfo implements java.io.Serializable {

	// Fields

	private Integer hid;
	private Integer uid;
	private String houseName;
	private Integer houseAdd;
	private String houseTime;
	private Integer houseType;
	private String houseCompensation;
	private String houseArea;
	private String houseNumber;
	private String houseSingleNumber;
	private String houseTaxedNumber;
	private Integer houseTaxType;
	private String houseRenovation;
	private String houseAllNumber;
	private Integer houseState;

	// Constructors

	public Integer getHouseState() {
		return houseState;
	}

	public void setHouseState(Integer houseState) {
		this.houseState = houseState;
	}

	/** default constructor */
	public HpHouseInfo() {
	}

	/** minimal constructor */
	public HpHouseInfo(Integer hid) {
		this.hid = hid;
	}

	/** full constructor */
	public HpHouseInfo(Integer hid, Integer uid, String houseName,
			Integer houseAdd, String houseTime, Integer houseType,
			String houseCompensation, String houseArea, String houseNumber,
			String houseSingleNumber, String houseTaxedNumber,
			Integer houseTaxType, String houseRenovation, String houseAllNumber) {
		this.hid = hid;
		this.uid = uid;
		this.houseName = houseName;
		this.houseAdd = houseAdd;
		this.houseTime = houseTime;
		this.houseType = houseType;
		this.houseCompensation = houseCompensation;
		this.houseArea = houseArea;
		this.houseNumber = houseNumber;
		this.houseSingleNumber = houseSingleNumber;
		this.houseTaxedNumber = houseTaxedNumber;
		this.houseTaxType = houseTaxType;
		this.houseRenovation = houseRenovation;
		this.houseAllNumber = houseAllNumber;
	}

	// Property accessors

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

	public String getHouseName() {
		return this.houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public Integer getHouseAdd() {
		return this.houseAdd;
	}

	public void setHouseAdd(Integer houseAdd) {
		this.houseAdd = houseAdd;
	}

	public String getHouseTime() {
		return this.houseTime;
	}

	public void setHouseTime(String houseTime) {
		this.houseTime = houseTime;
	}

	public Integer getHouseType() {
		return this.houseType;
	}

	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}

	public String getHouseCompensation() {
		return this.houseCompensation;
	}

	public void setHouseCompensation(String houseCompensation) {
		this.houseCompensation = houseCompensation;
	}

	public String getHouseArea() {
		return this.houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getHouseSingleNumber() {
		return this.houseSingleNumber;
	}

	public void setHouseSingleNumber(String houseSingleNumber) {
		this.houseSingleNumber = houseSingleNumber;
	}

	public String getHouseTaxedNumber() {
		return this.houseTaxedNumber;
	}

	public void setHouseTaxedNumber(String houseTaxedNumber) {
		this.houseTaxedNumber = houseTaxedNumber;
	}

	public Integer getHouseTaxType() {
		return this.houseTaxType;
	}

	public void setHouseTaxType(Integer houseTaxType) {
		this.houseTaxType = houseTaxType;
	}

	public String getHouseRenovation() {
		return this.houseRenovation;
	}

	public void setHouseRenovation(String houseRenovation) {
		this.houseRenovation = houseRenovation;
	}

	public String getHouseAllNumber() {
		return this.houseAllNumber;
	}

	public void setHouseAllNumber(String houseAllNumber) {
		this.houseAllNumber = houseAllNumber;
	}

}