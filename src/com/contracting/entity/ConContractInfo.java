package com.contracting.entity;

/**
 * ConContractInfo entity. @author MyEclipse Persistence Tools
 */

public class ConContractInfo implements java.io.Serializable {

	// Fields

	private Integer ciid;
	private Integer uid;
	private String contractName;
	private Integer contractCoType;
	private String allPay;

	// Constructors

	/** default constructor */
	public ConContractInfo() {
	}

	/** minimal constructor */
	public ConContractInfo(Integer ciid) {
		this.ciid = ciid;
	}

	/** full constructor */
	public ConContractInfo(Integer ciid, Integer uid, String contractName,
			Integer contractCoType, String allPay) {
		this.ciid = ciid;
		this.uid = uid;
		this.contractName = contractName;
		this.contractCoType = contractCoType;
		this.allPay = allPay;
	}

	// Property accessors

	public Integer getCiid() {
		return this.ciid;
	}

	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getContractName() {
		return this.contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public Integer getContractCoType() {
		return this.contractCoType;
	}

	public void setContractCoType(Integer contractCoType) {
		this.contractCoType = contractCoType;
	}

	public String getAllPay() {
		return this.allPay;
	}

	public void setAllPay(String allPay) {
		this.allPay = allPay;
	}

}