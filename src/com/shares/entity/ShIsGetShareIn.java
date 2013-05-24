package com.shares.entity;

/**
 * ShIsGetShareInId entity. @author MyEclipse Persistence Tools
 */

public class ShIsGetShareIn implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Integer sid;
	private String sharesName;
	private String sharesInTime;
	private String sharesInNumber;
	private String sharesInPrice;
	private String inOtherCost;

	// Constructors

	/** default constructor */
	public ShIsGetShareIn() {
	}

	/** full constructor */
	public ShIsGetShareIn(Integer uid,Integer sid, String sharesName,
			String sharesInTime, String sharesInNumber, String sharesInPrice,
			String inOtherCost) {
		this.uid = uid;
		this.sid = sid;
		this.sharesName = sharesName;
		this.sharesInTime = sharesInTime;
		this.sharesInNumber = sharesInNumber;
		this.sharesInPrice = sharesInPrice;
		this.inOtherCost = inOtherCost;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
    
	
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSharesName() {
		return this.sharesName;
	}

	public void setSharesName(String sharesName) {
		this.sharesName = sharesName;
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
		return this.inOtherCost;
	}

	public void setInOtherCost(String inOtherCost) {
		this.inOtherCost = inOtherCost;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ShIsGetShareIn))
			return false;
		ShIsGetShareIn castOther = (ShIsGetShareIn) other;

		return ((this.getUid() == castOther.getUid()) || (this.getUid() != null
				&& castOther.getUid() != null && this.getUid().equals(
				castOther.getUid())))
				&& ((this.getSharesName() == castOther.getSharesName()) || (this
						.getSharesName() != null
						&& castOther.getSharesName() != null && this
						.getSharesName().equals(castOther.getSharesName())))
				&& ((this.getSharesInTime() == castOther.getSharesInTime()) || (this
						.getSharesInTime() != null
						&& castOther.getSharesInTime() != null && this
						.getSharesInTime().equals(castOther.getSharesInTime())))
				&& ((this.getSharesInNumber() == castOther.getSharesInNumber()) || (this
						.getSharesInNumber() != null
						&& castOther.getSharesInNumber() != null && this
						.getSharesInNumber().equals(
								castOther.getSharesInNumber())))
				&& ((this.getSharesInPrice() == castOther.getSharesInPrice()) || (this
						.getSharesInPrice() != null
						&& castOther.getSharesInPrice() != null && this
						.getSharesInPrice()
						.equals(castOther.getSharesInPrice())))
				&& ((this.getInOtherCost() == castOther.getInOtherCost()) || (this
						.getInOtherCost() != null
						&& castOther.getInOtherCost() != null && this
						.getInOtherCost().equals(castOther.getInOtherCost())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUid() == null ? 0 : this.getUid().hashCode());
		result = 37
				* result
				+ (getSharesName() == null ? 0 : this.getSharesName()
						.hashCode());
		result = 37
				* result
				+ (getSharesInTime() == null ? 0 : this.getSharesInTime()
						.hashCode());
		result = 37
				* result
				+ (getSharesInNumber() == null ? 0 : this.getSharesInNumber()
						.hashCode());
		result = 37
				* result
				+ (getSharesInPrice() == null ? 0 : this.getSharesInPrice()
						.hashCode());
		result = 37
				* result
				+ (getInOtherCost() == null ? 0 : this.getInOtherCost()
						.hashCode());
		return result;
	}

}