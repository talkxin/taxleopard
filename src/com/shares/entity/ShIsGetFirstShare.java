package com.shares.entity;

/**
 * ShIsGetFistShareId entity. @author MyEclipse Persistence Tools
 */

public class ShIsGetFirstShare implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Integer sid;
	private String sharesName;
	private String sharesInTime;
	private String sharesNumber;
	private String sharesInDayNumber;
	private String taxedNumber;

	// Constructors

	/** default constructor */
	public ShIsGetFirstShare() {
	}

	/** full constructor */
	public ShIsGetFirstShare(Integer uid, Integer sid,String sharesName,
			String sharesInTime, String sharesNumber, String sharesInDayNumber,
			String taxedNumber) {
		this.uid = uid;
		this.sid = sid;
		this.sharesName = sharesName;
		this.sharesInTime = sharesInTime;
		this.sharesNumber = sharesNumber;
		this.sharesInDayNumber = sharesInDayNumber;
		this.taxedNumber = taxedNumber;
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

	public String getSharesNumber() {
		return this.sharesNumber;
	}

	public void setSharesNumber(String sharesNumber) {
		this.sharesNumber = sharesNumber;
	}

	public String getSharesInDayNumber() {
		return this.sharesInDayNumber;
	}

	public void setSharesInDayNumber(String sharesInDayNumber) {
		this.sharesInDayNumber = sharesInDayNumber;
	}

	public String getTaxedNumber() {
		return this.taxedNumber;
	}

	public void setTaxedNumber(String taxedNumber) {
		this.taxedNumber = taxedNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ShIsGetFirstShare))
			return false;
		ShIsGetFirstShare castOther = (ShIsGetFirstShare) other;

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
				&& ((this.getSharesNumber() == castOther.getSharesNumber()) || (this
						.getSharesNumber() != null
						&& castOther.getSharesNumber() != null && this
						.getSharesNumber().equals(castOther.getSharesNumber())))
				&& ((this.getSharesInDayNumber() == castOther
						.getSharesInDayNumber()) || (this
						.getSharesInDayNumber() != null
						&& castOther.getSharesInDayNumber() != null && this
						.getSharesInDayNumber().equals(
								castOther.getSharesInDayNumber())))
				&& ((this.getTaxedNumber() == castOther.getTaxedNumber()) || (this
						.getTaxedNumber() != null
						&& castOther.getTaxedNumber() != null && this
						.getTaxedNumber().equals(castOther.getTaxedNumber())));
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
				+ (getSharesNumber() == null ? 0 : this.getSharesNumber()
						.hashCode());
		result = 37
				* result
				+ (getSharesInDayNumber() == null ? 0 : this
						.getSharesInDayNumber().hashCode());
		result = 37
				* result
				+ (getTaxedNumber() == null ? 0 : this.getTaxedNumber()
						.hashCode());
		return result;
	}

}