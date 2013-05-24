package com.shares.entity;

/**
 * ShSharesPrice entity. @author MyEclipse Persistence Tools
 */

public class ShSharesPrice implements java.io.Serializable {

	// Fields

	private Integer spid;
	private Integer sid;
	private String priceTime;
	private String price;

	// Constructors

	/** default constructor */
	public ShSharesPrice() {
	}

	/** minimal constructor */
	public ShSharesPrice(Integer spid) {
		this.spid = spid;
	}

	/** full constructor */
	public ShSharesPrice(Integer spid, Integer sid, String priceTime,
			String price) {
		this.spid = spid;
		this.sid = sid;
		this.priceTime = priceTime;
		this.price = price;
	}

	// Property accessors

	public Integer getSpid() {
		return this.spid;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getPriceTime() {
		return this.priceTime;
	}

	public void setPriceTime(String priceTime) {
		this.priceTime = priceTime;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}