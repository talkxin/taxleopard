package com.paychex.entity;

/**
 * PcPrizeType entity. @author MyEclipse Persistence Tools
 */

public class PcPrizeType implements java.io.Serializable {

	// Fields

	private Integer ptid;
	private String prizeName;
	private Integer prizeType;
	private Integer prizeTypeDate;

	// Constructors

	/** default constructor */
	public PcPrizeType() {
	}

	/** minimal constructor */
	public PcPrizeType(Integer ptid) {
		this.ptid = ptid;
	}

	/** full constructor */
	public PcPrizeType(Integer ptid, String prizeName, Integer prizeType,
			Integer prizeTypeDate) {
		this.ptid = ptid;
		this.prizeName = prizeName;
		this.prizeType = prizeType;
		this.prizeTypeDate = prizeTypeDate;
	}

	// Property accessors

	public Integer getPtid() {
		return this.ptid;
	}

	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public String getPrizeName() {
		return this.prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public Integer getPrizeType() {
		return this.prizeType;
	}

	public void setPrizeType(Integer prizeType) {
		this.prizeType = prizeType;
	}

	public Integer getPrizeTypeDate() {
		return this.prizeTypeDate;
	}

	public void setPrizeTypeDate(Integer prizeTypeDate) {
		this.prizeTypeDate = prizeTypeDate;
	}

}