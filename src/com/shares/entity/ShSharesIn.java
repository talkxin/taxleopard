package com.shares.entity;

/**
 * ShSharesIn entity. @author MyEclipse Persistence Tools
 */

public class ShSharesIn implements java.io.Serializable {

	// Fields

	private Integer eiid;
	private Integer sid;
	private Integer uid;
	private String sharesInTime;
	private String sharesInNumber;
	private String sharesInPrice;
	private String inOtherCost;
	// Constructors

	/** default constructor */
	public ShSharesIn() {
	}

	/** minimal constructor */
	public ShSharesIn(Integer eiid) {
		this.eiid = eiid;
	}

	/** full constructor */
	public ShSharesIn(Integer eiid, Integer sid, Integer uid,
			String sharesInTime, String sharesInNumber, String sharesInPrice,String inOtherCost) {
		this.eiid = eiid;
		this.sid = sid;
		this.uid = uid;
		this.sharesInTime = sharesInTime;
		this.sharesInNumber = sharesInNumber;
		this.sharesInPrice = sharesInPrice;
		this.inOtherCost=inOtherCost;
	}

	// Property accessors

	public Integer getEiid() {
		return this.eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

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

	public String getSharesInTime() {
		return this.sharesInTime;
	}

	public void setSharesInTime(String sharesInTime) {
		this.sharesInTime = sharesInTime;
	}

	public String getSharesInNumber() {
		return this.sharesInNumber;
	}

	public void setSharesInNumber(String sharesInNumber) {
		this.sharesInNumber = sharesInNumber;
	}

	public String getSharesInPrice() {
		return this.sharesInPrice;
	}

	public void setSharesInPrice(String sharesInPrice) {
		this.sharesInPrice = sharesInPrice;
	}
	public String getInOtherCost() {
		return inOtherCost;
	}

	public void setInOtherCost(String inOtherCost) {
		this.inOtherCost = inOtherCost;
	}
    
}