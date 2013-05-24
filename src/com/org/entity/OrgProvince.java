package com.org.entity;

/**
 * OrgProvince entity. @author MyEclipse Persistence Tools
 */

public class OrgProvince implements java.io.Serializable {

	// Fields

	private Integer pid;
	private Integer nid;
	private String provinceName;

	// Constructors

	/** default constructor */
	public OrgProvince() {
	}

	/** minimal constructor */
	public OrgProvince(Integer pid) {
		this.pid = pid;
	}

	/** full constructor */
	public OrgProvince(Integer pid, Integer nid, String provinceName) {
		this.pid = pid;
		this.nid = nid;
		this.provinceName = provinceName;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}