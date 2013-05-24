package com.remuneration.entity;

/**
 * ReRemunerationInfo entity. @author MyEclipse Persistence Tools
 */

public class ReRemunerationInfo implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Integer uid;
	private String remunerationName;
	private Integer remunerationType;

	// Constructors

	/** default constructor */
	public ReRemunerationInfo() {
	}

	/** minimal constructor */
	public ReRemunerationInfo(Integer rid) {
		this.rid = rid;
	}

	/** full constructor */
	public ReRemunerationInfo(Integer rid, Integer uid,
			String remunerationName, Integer remunerationType) {
		this.rid = rid;
		this.uid = uid;
		this.remunerationName = remunerationName;
		this.remunerationType = remunerationType;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getRemunerationName() {
		return this.remunerationName;
	}

	public void setRemunerationName(String remunerationName) {
		this.remunerationName = remunerationName;
	}

	public Integer getRemunerationType() {
		return this.remunerationType;
	}

	public void setRemunerationType(Integer remunerationType) {
		this.remunerationType = remunerationType;
	}

}