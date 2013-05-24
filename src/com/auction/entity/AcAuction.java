package com.auction.entity;

/**
 * AcAuction entity. @author MyEclipse Persistence Tools
 */

public class AcAuction implements java.io.Serializable {

	// Fields

	private Integer aid;
	private Integer uid;
	private Integer taxed;
	private String auctionName;
	private String auctionOldNumber;
	private String auctionNumber;
	private String auctionTime;
	private String outCastNumber;
	private String taxNumber;
	private String taxableNumber;
	private String payOutNumber;
	private String taxEdNumber;

	// Constructors

	/** default constructor */
	public AcAuction() {
	}

	/** minimal constructor */
	public AcAuction(Integer aid) {
		this.aid = aid;
	}

	/** full constructor */
	public AcAuction(Integer aid, Integer uid, Integer taxed,
			String auctionName, String auctionOldNumber, String auctionNumber,
			String auctionTime, String outCastNumber, String taxNumber,
			String taxableNumber, String payOutNumber, String taxEdNumber) {
		this.aid = aid;
		this.uid = uid;
		this.taxed = taxed;
		this.auctionName = auctionName;
		this.auctionOldNumber = auctionOldNumber;
		this.auctionNumber = auctionNumber;
		this.auctionTime = auctionTime;
		this.outCastNumber = outCastNumber;
		this.taxNumber = taxNumber;
		this.taxableNumber = taxableNumber;
		this.payOutNumber = payOutNumber;
		this.taxEdNumber = taxEdNumber;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getTaxed() {
		return this.taxed;
	}

	public void setTaxed(Integer taxed) {
		this.taxed = taxed;
	}

	public String getAuctionName() {
		return this.auctionName;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

	public String getAuctionOldNumber() {
		return this.auctionOldNumber;
	}

	public void setAuctionOldNumber(String auctionOldNumber) {
		this.auctionOldNumber = auctionOldNumber;
	}

	public String getAuctionNumber() {
		return this.auctionNumber;
	}

	public void setAuctionNumber(String auctionNumber) {
		this.auctionNumber = auctionNumber;
	}

	public String getAuctionTime() {
		return this.auctionTime;
	}

	public void setAuctionTime(String auctionTime) {
		this.auctionTime = auctionTime;
	}

	public String getOutCastNumber() {
		return this.outCastNumber;
	}

	public void setOutCastNumber(String outCastNumber) {
		this.outCastNumber = outCastNumber;
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

}