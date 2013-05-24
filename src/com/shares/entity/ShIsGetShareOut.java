package com.shares.entity;

/**
 * ShIsGetShareOutId entity. @author MyEclipse Persistence Tools
 */

public class ShIsGetShareOut implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Integer sid;
	private String sharesName;
	private String sharesOutNumber;
	private String sharesOutPrice;
	private String sharesAllNumber;
	private String taxNumber;
	private String payOutNumber;
	private String outOtherCost;
	private String sharesOutTime;
	// Constructors

	/** default constructor */
	public ShIsGetShareOut() {
	}

	/** full constructor */
	public ShIsGetShareOut(Integer uid, Integer sid,String sharesName,
			String sharesOutNumber, String sharesOutPrice,
			String sharesAllNumber, String taxNumber, String payOutNumber,
			String outOtherCost,String sharesOutTime) {
		this.uid = uid;
		this.sid = sid;
		this.sharesName = sharesName;
		this.sharesOutNumber = sharesOutNumber;
		this.sharesOutPrice = sharesOutPrice;
		this.sharesAllNumber = sharesAllNumber;
		this.taxNumber = taxNumber;
		this.payOutNumber = payOutNumber;
		this.outOtherCost = outOtherCost;
		this.sharesOutTime=sharesOutTime;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}
    
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getSharesName() {
		return this.sharesName;
	}

	public void setSharesName(String sharesName) {
		this.sharesName = sharesName;
	}

	public String getSharesOutNumber() {
		return this.sharesOutNumber;
	}

	public void setSharesOutNumber(String sharesOutNumber) {
		this.sharesOutNumber = sharesOutNumber;
	}

	public String getSharesOutPrice() {
		return this.sharesOutPrice;
	}

	public void setSharesOutPrice(String sharesOutPrice) {
		this.sharesOutPrice = sharesOutPrice;
	}

	public String getSharesAllNumber() {
		return this.sharesAllNumber;
	}

	public void setSharesAllNumber(String sharesAllNumber) {
		this.sharesAllNumber = sharesAllNumber;
	}

	public String getTaxNumber() {
		return this.taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getPayOutNumber() {
		return this.payOutNumber;
	}

	public void setPayOutNumber(String payOutNumber) {
		this.payOutNumber = payOutNumber;
	}
    
	public String getSharesOutTime() {
		return sharesOutTime;
	}

	public void setSharesOutTime(String sharesOutTime) {
		this.sharesOutTime = sharesOutTime;
	}

	public String getOutOtherCost() {
		return this.outOtherCost;
	}

	public void setOutOtherCost(String outOtherCost) {
		this.outOtherCost = outOtherCost;
	}
    
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ShIsGetShareOut))
			return false;
		ShIsGetShareOut castOther = (ShIsGetShareOut) other;

		return ((this.getUid() == castOther.getUid()) || (this.getUid() != null
				&& castOther.getUid() != null && this.getUid().equals(
				castOther.getUid())))
				&& ((this.getSharesName() == castOther.getSharesName()) || (this
						.getSharesName() != null
						&& castOther.getSharesName() != null && this
						.getSharesName().equals(castOther.getSharesName())))
				&& ((this.getSharesOutNumber() == castOther
						.getSharesOutNumber()) || (this.getSharesOutNumber() != null
						&& castOther.getSharesOutNumber() != null && this
						.getSharesOutNumber().equals(
								castOther.getSharesOutNumber())))
				&& ((this.getSharesOutPrice() == castOther.getSharesOutPrice()) || (this
						.getSharesOutPrice() != null
						&& castOther.getSharesOutPrice() != null && this
						.getSharesOutPrice().equals(
								castOther.getSharesOutPrice())))
				&& ((this.getSharesAllNumber() == castOther
						.getSharesAllNumber()) || (this.getSharesAllNumber() != null
						&& castOther.getSharesAllNumber() != null && this
						.getSharesAllNumber().equals(
								castOther.getSharesAllNumber())))
				&& ((this.getTaxNumber() == castOther.getTaxNumber()) || (this
						.getTaxNumber() != null
						&& castOther.getTaxNumber() != null && this
						.getTaxNumber().equals(castOther.getTaxNumber())))
				&& ((this.getPayOutNumber() == castOther.getPayOutNumber()) || (this
						.getPayOutNumber() != null
						&& castOther.getPayOutNumber() != null && this
						.getPayOutNumber().equals(castOther.getPayOutNumber())))
				&& ((this.getOutOtherCost() == castOther.getOutOtherCost()) || (this
						.getOutOtherCost() != null
						&& castOther.getOutOtherCost() != null && this
						.getOutOtherCost().equals(castOther.getOutOtherCost())));
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
				+ (getSharesOutNumber() == null ? 0 : this.getSharesOutNumber()
						.hashCode());
		result = 37
				* result
				+ (getSharesOutPrice() == null ? 0 : this.getSharesOutPrice()
						.hashCode());
		result = 37
				* result
				+ (getSharesAllNumber() == null ? 0 : this.getSharesAllNumber()
						.hashCode());
		result = 37 * result
				+ (getTaxNumber() == null ? 0 : this.getTaxNumber().hashCode());
		result = 37
				* result
				+ (getPayOutNumber() == null ? 0 : this.getPayOutNumber()
						.hashCode());
		result = 37
				* result
				+ (getOutOtherCost() == null ? 0 : this.getOutOtherCost()
						.hashCode());
		return result;
	}

}