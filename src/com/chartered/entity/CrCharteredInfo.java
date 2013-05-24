package com.chartered.entity;

/**
 * CrCharteredInfo entity. @author MyEclipse Persistence Tools
 */

public class CrCharteredInfo implements java.io.Serializable {

	// Fields

	private Integer ciid;
	private Integer uid;
	private String charteredInfoName;
	private Integer charteredInfoType;

	// Constructors

	/** default constructor */
	public CrCharteredInfo() {
	}

	/** minimal constructor */
	public CrCharteredInfo(Integer ciid) {
		this.ciid = ciid;
	}

	/** full constructor */
	public CrCharteredInfo(Integer ciid, Integer uid, String charteredInfoName,
			Integer charteredInfoType) {
		this.ciid = ciid;
		this.uid = uid;
		this.charteredInfoName = charteredInfoName;
		this.charteredInfoType = charteredInfoType;
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

	public String getCharteredInfoName() {
		return this.charteredInfoName;
	}

	public void setCharteredInfoName(String charteredInfoName) {
		this.charteredInfoName = charteredInfoName;
	}

	public Integer getCharteredInfoType() {
		return this.charteredInfoType;
	}

	public void setCharteredInfoType(Integer charteredInfoType) {
		this.charteredInfoType = charteredInfoType;
	}

}