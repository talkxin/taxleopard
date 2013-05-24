package com.house.entity;

/**
 * HpTransfer entity. @author MyEclipse Persistence Tools
 */

public class HpTransfer implements java.io.Serializable {

	// Fields

	private Integer htid;
	private Integer hid;
	private Integer uid;
	private Integer taxType;
	private String transferNumber;
	private String transferTime;
	private String cityConstructionTax;
	private String taxEdNumber;
	private String transferTaxNumber;
	private String tranceferTax;
	private String transferEndNumber;
	private String intermediary;
	private String tax1;
	private String tax2;
	private String tax3;
	private String tax4;
	private String tax5;
	private String tax6;

	// Constructors

	/** default constructor */
	public HpTransfer() {
	}

	public String getIntermediary() {
		return intermediary;
	}

	public void setIntermediary(String intermediary) {
		this.intermediary = intermediary;
	}

	/** minimal constructor */
	public HpTransfer(Integer htid) {
		this.htid = htid;
	}

	/** full constructor */
	public HpTransfer(Integer htid, Integer hid, Integer uid, Integer taxType,
			String transferNumber, String transferTime,
			String cityConstructionTax, String taxEdNumber,
			String transferTaxNumber, String tranceferTax,String transferEndNumber, String tax1,
			String tax2, String tax3, String tax4, String tax5, String tax6) {
		this.htid = htid;
		this.hid = hid;
		this.uid = uid;
		this.taxType = taxType;
		this.transferNumber = transferNumber;
		this.transferTime = transferTime;
		this.cityConstructionTax = cityConstructionTax;
		this.taxEdNumber = taxEdNumber;
		this.transferTaxNumber = transferTaxNumber;
		this.tranceferTax = tranceferTax;
		this.transferEndNumber=transferEndNumber;
		this.tax1 = tax1;
		this.tax2 = tax2;
		this.tax3 = tax3;
		this.tax4 = tax4;
		this.tax5 = tax5;
		this.tax6 = tax6;
	}

	// Property accessors

	public Integer getHtid() {
		return this.htid;
	}

	public void setHtid(Integer htid) {
		this.htid = htid;
	}

	public Integer getHid() {
		return this.hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getTaxType() {
		return this.taxType;
	}

	public void setTaxType(Integer taxType) {
		this.taxType = taxType;
	}



	public String getTransferNumber() {
		return transferNumber;
	}

	public void setTransferNumber(String transferNumber) {
		this.transferNumber = transferNumber;
	}

	public String getTransferTime() {
		return this.transferTime;
	}

	public void setTransferTime(String transferTime) {
		this.transferTime = transferTime;
	}

	public String getCityConstructionTax() {
		return this.cityConstructionTax;
	}

	public void setCityConstructionTax(String cityConstructionTax) {
		this.cityConstructionTax = cityConstructionTax;
	}

	public String getTaxEdNumber() {
		return this.taxEdNumber;
	}

	public void setTaxEdNumber(String taxEdNumber) {
		this.taxEdNumber = taxEdNumber;
	}

	public String getTransferTaxNumber() {
		return this.transferTaxNumber;
	}

	public void setTransferTaxNumber(String transferTaxNumber) {
		this.transferTaxNumber = transferTaxNumber;
	}

	public String getTranceferTax() {
		return this.tranceferTax;
	}

	public void setTranceferTax(String tranceferTax) {
		this.tranceferTax = tranceferTax;
	}

	public String getTax1() {
		return this.tax1;
	}

	public void setTax1(String tax1) {
		this.tax1 = tax1;
	}

	public String getTax2() {
		return this.tax2;
	}

	public void setTax2(String tax2) {
		this.tax2 = tax2;
	}

	public String getTax3() {
		return this.tax3;
	}

	public void setTax3(String tax3) {
		this.tax3 = tax3;
	}

	public String getTax4() {
		return this.tax4;
	}

	public void setTax4(String tax4) {
		this.tax4 = tax4;
	}

	public String getTax5() {
		return this.tax5;
	}

	public void setTax5(String tax5) {
		this.tax5 = tax5;
	}

	public String getTax6() {
		return this.tax6;
	}

	public void setTax6(String tax6) {
		this.tax6 = tax6;
	}

	public String getTransferEndNumber() {
		return transferEndNumber;
	}

	public void setTransferEndNumber(String transferEndNumber) {
		this.transferEndNumber = transferEndNumber;
	}


    
}