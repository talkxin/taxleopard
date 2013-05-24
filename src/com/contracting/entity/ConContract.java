package com.contracting.entity;

/**
 * ConContract entity. @author MyEclipse Persistence Tools
 */

public class ConContract implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer uid;
	private Integer ciid;
	private Integer contractType;
	private Integer contractType2;
	private Integer taxed;
	private String contractStart;
	private String contractEnd;
	private String contractAllTime;
	private String contractNumber1;
	private String contractNumber2;
	private String taxNumber;
	private String taxableNumber;
	private String payOutNumber;
	private String taxEdNumber;

	// Constructors

	/** default constructor */
	public ConContract() {
	}

	/** minimal constructor */
	public ConContract(Integer cid) {
		this.cid = cid;
	}

	/** full constructor */
	public ConContract(Integer cid, Integer uid, Integer ciid,
			Integer contractType, Integer contractType2, Integer taxed,
			String contractStart, String contractEnd, String contractAllTime,
			String contractNumber1, String contractNumber2, String taxNumber,
			String taxableNumber, String payOutNumber, String taxEdNumber) {
		this.cid = cid;
		this.uid = uid;
		this.ciid = ciid;
		this.contractType = contractType;
		this.contractType2 = contractType2;
		this.taxed = taxed;
		this.contractStart = contractStart;
		this.contractEnd = contractEnd;
		this.contractAllTime = contractAllTime;
		this.contractNumber1 = contractNumber1;
		this.contractNumber2 = contractNumber2;
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

	public Integer getContractType() {
		return this.contractType;
	}

	public void setContractType(Integer contractType) {
		this.contractType = contractType;
	}

	public Integer getContractType2() {
		return this.contractType2;
	}

	public void setContractType2(Integer contractType2) {
		this.contractType2 = contractType2;
	}

	public Integer getTaxed() {
		return this.taxed;
	}

	public void setTaxed(Integer taxed) {
		this.taxed = taxed;
	}

	public String getContractStart() {
		return this.contractStart;
	}

	public void setContractStart(String contractStart) {
		this.contractStart = contractStart;
	}

	public String getContractEnd() {
		return this.contractEnd;
	}

	public void setContractEnd(String contractEnd) {
		this.contractEnd = contractEnd;
	}

	public String getContractAllTime() {
		return this.contractAllTime;
	}

	public void setContractAllTime(String contractAllTime) {
		this.contractAllTime = contractAllTime;
	}

	public String getContractNumber1() {
		return this.contractNumber1;
	}

	public void setContractNumber1(String contractNumber1) {
		this.contractNumber1 = contractNumber1;
	}

	public String getContractNumber2() {
		return this.contractNumber2;
	}

	public void setContractNumber2(String contractNumber2) {
		this.contractNumber2 = contractNumber2;
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