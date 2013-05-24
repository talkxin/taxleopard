package com.chartered.entity;

/**
 * CrChartered entity. @author MyEclipse Persistence Tools
 */

public class CrChartered implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer uid;
	private Integer ciid;
	private Integer charteredType;
	private Integer taxed;
	private String charteredStart;
	private String charteredEnd;
	private Integer charteredTime;
	private String charteredNumber;
	private String taxNumber;
	private String taxableNumber;
	private String payOutNumber;
	private String taxEdNumber;

	// Constructors

	/** default constructor */
	public CrChartered() {
	}

	/** minimal constructor */
	public CrChartered(Integer cid) {
		this.cid = cid;
	}

	/** full constructor */
	public CrChartered(Integer cid, Integer uid, Integer ciid,
			Integer charteredType, Integer taxed, String charteredStart,
			String charteredEnd, Integer charteredTime, String charteredNumber,
			String taxNumber, String taxableNumber, String payOutNumber,
			String taxEdNumber) {
		this.cid = cid;
		this.uid = uid;
		this.ciid = ciid;
		this.charteredType = charteredType;
		this.taxed = taxed;
		this.charteredStart = charteredStart;
		this.charteredEnd = charteredEnd;
		this.charteredTime = charteredTime;
		this.charteredNumber = charteredNumber;
		this.taxNumber = taxNumber;
		this.taxableNumber = taxableNumber;
		this.payOutNumber = payOutNumber;
		this.taxEdNumber = taxEdNumber;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getCiid() {
		return this.ciid;
	}

	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	public Integer getCharteredType() {
		return this.charteredType;
	}

	public void setCharteredType(Integer charteredType) {
		this.charteredType = charteredType;
	}

	public Integer getTaxed() {
		return this.taxed;
	}

	public void setTaxed(Integer taxed) {
		this.taxed = taxed;
	}

	public String getCharteredStart() {
		return this.charteredStart;
	}

	public void setCharteredStart(String charteredStart) {
		this.charteredStart = charteredStart;
	}

	public String getCharteredEnd() {
		return this.charteredEnd;
	}

	public void setCharteredEnd(String charteredEnd) {
		this.charteredEnd = charteredEnd;
	}

	public Integer getCharteredTime() {
		return this.charteredTime;
	}

	public void setCharteredTime(Integer charteredTime) {
		this.charteredTime = charteredTime;
	}

	public String getCharteredNumber() {
		return this.charteredNumber;
	}

	public void setCharteredNumber(String charteredNumber) {
		this.charteredNumber = charteredNumber;
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