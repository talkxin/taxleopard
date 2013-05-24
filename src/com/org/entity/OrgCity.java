package com.org.entity;

/**
 * OrgCity entity. @author MyEclipse Persistence Tools
 */

public class OrgCity implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer pid;
	private String sortName;
	private String langName;

	// Constructors

	/** default constructor */
	public OrgCity() {
	}

	/** minimal constructor */
	public OrgCity(Integer cid) {
		this.cid = cid;
	}

	/** full constructor */
	public OrgCity(Integer cid, Integer pid, String sortName, String langName) {
		this.cid = cid;
		this.pid = pid;
		this.sortName = sortName;
		this.langName = langName;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getSortName() {
		return this.sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getLangName() {
		return this.langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

}