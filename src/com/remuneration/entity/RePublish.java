package com.remuneration.entity;

/**
 * RePublish entity. @author MyEclipse Persistence Tools
 */

public class RePublish implements java.io.Serializable {

	// Fields

	private Integer pid;
	private Integer rid;
	private Integer ptid;
	private Integer uid;
	private Integer publishType1;
	private Integer publishType2;
	private Integer taxed;
	private String publishTime;
	private String publishNumber;
	private String taxNumber;
	private String taxableNumber;
	private String payOutNumber;
	private String taxEdNumber;

	// Constructors

	/** default constructor */
	public RePublish() {
	}

	/** minimal constructor */
	public RePublish(Integer pid) {
		this.pid = pid;
	}

	/** full constructor */
	public RePublish(Integer pid, Integer rid, Integer ptid, Integer uid,
			Integer publishType1, Integer publishType2, Integer taxed,
			String publishTime, String publishNumber, String taxNumber,
			String taxableNumber, String payOutNumber, String taxEdNumber) {
		this.pid = pid;
		this.rid = rid;
		this.ptid = ptid;
		this.uid = uid;
		this.publishType1 = publishType1;
		this.publishType2 = publishType2;
		this.taxed = taxed;
		this.publishTime = publishTime;
		this.publishNumber = publishNumber;
		this.taxNumber = taxNumber;
		this.taxableNumber = taxableNumber;
		this.payOutNumber = payOutNumber;
		this.taxEdNumber = taxEdNumber;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getPtid() {
		return this.ptid;
	}

	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getPublishType1() {
		return this.publishType1;
	}

	public void setPublishType1(Integer publishType1) {
		this.publishType1 = publishType1;
	}

	public Integer getPublishType2() {
		return this.publishType2;
	}

	public void setPublishType2(Integer publishType2) {
		this.publishType2 = publishType2;
	}

	public Integer getTaxed() {
		return this.taxed;
	}

	public void setTaxed(Integer taxed) {
		this.taxed = taxed;
	}

	public String getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getPublishNumber() {
		return this.publishNumber;
	}

	public void setPublishNumber(String publishNumber) {
		this.publishNumber = publishNumber;
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