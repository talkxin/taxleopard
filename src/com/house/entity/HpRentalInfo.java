package com.house.entity;

/**
 * HpRentalInfo entity. @author MyEclipse Persistence Tools
 */

public class HpRentalInfo implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Integer uid;
	private String rentalName;
	private Integer rentalIdType;
	private String rentalIdNumber;
	private String rentalImage;

	// Constructors

	/** default constructor */
	public HpRentalInfo() {
	}

	/** minimal constructor */
	public HpRentalInfo(Integer rid) {
		this.rid = rid;
	}

	/** full constructor */
	public HpRentalInfo(Integer rid, Integer uid, String rentalName,
			Integer rentalIdType, String rentalIdNumber, String rentalImage) {
		this.rid = rid;
		this.uid = uid;
		this.rentalName = rentalName;
		this.rentalIdType = rentalIdType;
		this.rentalIdNumber = rentalIdNumber;
		this.rentalImage = rentalImage;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getRentalName() {
		return this.rentalName;
	}

	public void setRentalName(String rentalName) {
		this.rentalName = rentalName;
	}

	public Integer getRentalIdType() {
		return this.rentalIdType;
	}

	public void setRentalIdType(Integer rentalIdType) {
		this.rentalIdType = rentalIdType;
	}

	public String getRentalIdNumber() {
		return this.rentalIdNumber;
	}

	public void setRentalIdNumber(String rentalIdNumber) {
		this.rentalIdNumber = rentalIdNumber;
	}

	public String getRentalImage() {
		return this.rentalImage;
	}

	public void setRentalImage(String rentalImage) {
		this.rentalImage = rentalImage;
	}

}