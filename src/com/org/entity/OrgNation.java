package com.org.entity;

/**
 * OrgNation entity. @author MyEclipse Persistence Tools
 */

public class OrgNation implements java.io.Serializable {

	// Fields

	private Integer nid;
	private Integer ntype;
	private String sortName;
	private String langName;

	// Constructors

	/** default constructor */
	public OrgNation() {
	}

	/** minimal constructor */
	public OrgNation(Integer nid) {
		this.nid = nid;
	}

	/** full constructor */
	public OrgNation(Integer nid, Integer ntype, String sortName,
			String langName) {
		this.nid = nid;
		this.ntype = ntype;
		this.sortName = sortName;
		this.langName = langName;
	}

	// Property accessors

	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public Integer getNtype() {
		return this.ntype;
	}

	public void setNtype(Integer ntype) {
		this.ntype = ntype;
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