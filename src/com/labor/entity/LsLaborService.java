package com.labor.entity;

/**
 * LsLaborService entity. @author MyEclipse Persistence Tools
 */

public class LsLaborService implements java.io.Serializable {

	// Fields

	private Integer lsid;
	private Integer lid;
	private Integer ltid;
	private String laborInDay;
	private Integer laborAdd;
	private Integer laborTaxEd;
	private String laborTaxEdNumber;
	private String laborNumber;
	private String taxNumber;
	private String taxableNumber;
	private String payOutNumber;
	private String laborTaxNumber;

	// Constructors

	public String getLaborTaxNumber() {
		return laborTaxNumber;
	}

	public void setLaborTaxNumber(String laborTaxNumber) {
		this.laborTaxNumber = laborTaxNumber;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getLaborTaxEdNumber() {
		return laborTaxEdNumber;
	}

	public void setLaborTaxEdNumber(String laborTaxEdNumber) {
		this.laborTaxEdNumber = laborTaxEdNumber;
	}

	/** default constructor */
	public LsLaborService() {
	}

	/** minimal constructor */
	public LsLaborService(Integer lsid) {
		this.lsid = lsid;
	}

	/** full constructor */
	public LsLaborService(Integer lsid, Integer ltid, String laborInDay,
			Integer laborAdd, Integer laborTaxEd, String laborNumber,
			String taxNumber, String taxableNumber, String payOutNumber) {
		this.lsid = lsid;
		this.ltid = ltid;
		this.laborInDay = laborInDay;
		this.laborAdd = laborAdd;
		this.laborTaxEd = laborTaxEd;
		this.laborNumber = laborNumber;
		this.taxNumber = taxNumber;
		this.taxableNumber = taxableNumber;
		this.payOutNumber = payOutNumber;
	}

	// Property accessors

	public Integer getLsid() {
		return this.lsid;
	}

	public void setLsid(Integer lsid) {
		this.lsid = lsid;
	}

	public Integer getLtid() {
		return this.ltid;
	}

	public void setLtid(Integer ltid) {
		this.ltid = ltid;
	}

	public String getLaborInDay() {
		return this.laborInDay;
	}

	public void setLaborInDay(String laborInDay) {
		this.laborInDay = laborInDay;
	}

	public Integer getLaborAdd() {
		return this.laborAdd;
	}

	public void setLaborAdd(Integer laborAdd) {
		this.laborAdd = laborAdd;
	}

	public Integer getLaborTaxEd() {
		return this.laborTaxEd;
	}

	public void setLaborTaxEd(Integer laborTaxEd) {
		this.laborTaxEd = laborTaxEd;
	}

	public String getLaborNumber() {
		return this.laborNumber;
	}

	public void setLaborNumber(String laborNumber) {
		this.laborNumber = laborNumber;
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

}