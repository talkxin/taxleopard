package com.org.entity;

/**
 * 密码提示问题表
 * */
public class Matter {
	private int matterID;// 问题编号
	private String matter;// 问题
	private String result;// 问题答案
	private int taxID;// 用户ID

	public int getMatterID() {
		return matterID;
	}

	public void setMatterID(int matterID) {
		this.matterID = matterID;
	}

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getTaxID() {
		return taxID;
	}

	public void setTaxID(int taxID) {
		this.taxID = taxID;
	}

}
