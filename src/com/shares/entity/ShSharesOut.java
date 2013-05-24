package com.shares.entity;

/**
 * ShSharesOut entity. @author MyEclipse Persistence Tools
 */

public class ShSharesOut implements java.io.Serializable {

	// Fields

	private Integer eoid;
	private Integer sid;
	private Integer uid;
	private String outChina;
	private String sharesOutNumber;
	private String sharesOutPrice;
	private String sharesAllNumber;
	private String taxNumber;
	private String taxableNumber;
	private String payOutNumber;
	private String taxEdNumber;
	private Integer taxEdType;
    private String outOtherCost;
    private String sharesOutTime;
	// Constructors

	/** default constructor */
	public ShSharesOut() {
	}

	/** minimal constructor */
	public ShSharesOut(Integer eoid) {
		this.eoid = eoid;
	}

	/** full constructor */
	public ShSharesOut(Integer eoid, Integer sid, Integer uid, String outChina,
			String sharesOutNumber, String sharesOutPrice,
			String sharesAllNumber, String taxNumber, String taxableNumber,
			String payOutNumber, String taxEdNumber, Integer taxEdType,String outOtherCost,String sharesOutTime) {
		this.eoid = eoid;
		this.sid = sid;
		this.uid = uid;
		this.outChina = outChina;
		this.sharesOutNumber = sharesOutNumber;
		this.sharesOutPrice = sharesOutPrice;
		this.sharesAllNumber = sharesAllNumber;
		this.taxNumber = taxNumber;
		this.taxableNumber = taxableNumber;
		this.payOutNumber = payOutNumber;
		this.taxEdNumber = taxEdNumber;
		this.taxEdType = taxEdType;
		this.outOtherCost=outOtherCost;
		this.sharesOutTime=sharesOutTime;
	}

	// Property accessors

	public Integer getEoid() {
		return this.eoid;
	}

	public void setEoid(Integer eoid) {
		this.eoid = eoid;
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

	public String getOutChina() {
		return this.outChina;
	}

	public void setOutChina(String outChina) {
		this.outChina = outChina;
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

	public String getTaxableNumber() {
		return this.taxableNumber;
	}

	public void setTaxableNumber(String taxableNumber) {
		this.taxableNumber = taxableNumber;
	}

	public String getPayOutNumber() {
		return this.payOutNumber;
	}

	public void setPayOutNumber(String payOutNumber) {
		this.payOutNumber = payOutNumber;
	}

	public String getTaxEdNumber() {
		return this.taxEdNumber;
	}

	public void setTaxEdNumber(String taxEdNumber) {
		this.taxEdNumber = taxEdNumber;
	}

	public Integer getTaxEdType() {
		return this.taxEdType;
	}

	public void setTaxEdType(Integer taxEdType) {
		this.taxEdType = taxEdType;
	}

	public String getOutOtherCost() {
		return outOtherCost;
	}

	public void setOutOtherCost(String outOtherCost) {
		this.outOtherCost = outOtherCost;
	}

	public String getSharesOutTime() {
		return sharesOutTime;
	}

	public void setSharesOutTime(String sharesOutTime) {
		this.sharesOutTime = sharesOutTime;
	}
    
}