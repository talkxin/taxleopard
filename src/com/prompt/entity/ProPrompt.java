package com.prompt.entity;

/**
 * ProPrompt entity. @author MyEclipse Persistence Tools
 */

public class ProPrompt implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String proptName;
	private String proptText;

	// Constructors

	/** default constructor */
	public ProPrompt() {
	}

	/** minimal constructor */
	public ProPrompt(Integer pid) {
		this.pid = pid;
	}

	/** full constructor */
	public ProPrompt(Integer pid, String proptName, String proptText) {
		this.pid = pid;
		this.proptName = proptName;
		this.proptText = proptText;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getProptName() {
		return this.proptName;
	}

	public void setProptName(String proptName) {
		this.proptName = proptName;
	}

	public String getProptText() {
		return this.proptText;
	}

	public void setProptText(String proptText) {
		this.proptText = proptText;
	}

}