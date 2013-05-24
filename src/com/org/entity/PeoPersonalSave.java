package com.org.entity;

/**
 * PeoPersonalSave entity. @author MyEclipse Persistence Tools
 */

public class PeoPersonalSave implements java.io.Serializable {

	// Fields

	private Integer ppid;
	private Integer uid;
	private Integer pid;

	// Constructors

	/** default constructor */
	public PeoPersonalSave() {
	}

	/** minimal constructor */
	public PeoPersonalSave(Integer ppid) {
		this.ppid = ppid;
	}

	/** full constructor */
	public PeoPersonalSave(Integer ppid, Integer uid, Integer pid) {
		this.ppid = ppid;
		this.uid = uid;
		this.pid = pid;
	}

	// Property accessors

	public Integer getPpid() {
		return this.ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

}