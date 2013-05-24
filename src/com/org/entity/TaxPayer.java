package com.org.entity;

/**
 * 纳税人表
 * */
public class TaxPayer {
	private Integer taxID;// 编号
	private String taxUserName;// 用户名
	private String taxPassWord;// 密码
	private String taxName;// 姓名
	private Integer taxSex;// 性别
	private Integer taxAge;// 年龄
	private String taxAddress;// 家庭住址
	private String taxDomicle;// 现在居住地
	private String taxNationality;// 国籍 国籍表外键
	private String taxIndustry;// 所属行业 行业表外键
	private Integer taxMarried;// 婚否
	private String taxEmail;// 用户邮箱
	private Integer taxSenior;// 是否高管0|1
	private String taxPart;// 用户角色
	private Integer taxInteqral;// 用户积分
	private Integer counts;// 次数
	private Integer state;// 状态
	private String pid;//已经添加的模块

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Integer getTaxID() {
		return taxID;
	}

	public void setTaxID(Integer taxID) {
		this.taxID = taxID;
	}

	public String getTaxUserName() {
		return taxUserName;
	}

	public void setTaxUserName(String taxUserName) {
		this.taxUserName = taxUserName;
	}

	public String getTaxPassWord() {
		return taxPassWord;
	}

	public void setTaxPassWord(String taxPassWord) {
		this.taxPassWord = taxPassWord;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public Integer getTaxSex() {
		return taxSex;
	}

	public void setTaxSex(Integer taxSex) {
		this.taxSex = taxSex;
	}

	public Integer getTaxAge() {
		return taxAge;
	}

	public void setTaxAge(Integer taxAge) {
		this.taxAge = taxAge;
	}

	public String getTaxAddress() {
		return taxAddress;
	}

	public void setTaxAddress(String taxAddress) {
		this.taxAddress = taxAddress;
	}

	public String getTaxDomicle() {
		return taxDomicle;
	}

	public void setTaxDomicle(String taxDomicle) {
		this.taxDomicle = taxDomicle;
	}

	public String getTaxNationality() {
		return taxNationality;
	}

	public void setTaxNationality(String taxNationality) {
		this.taxNationality = taxNationality;
	}

	public String getTaxIndustry() {
		return taxIndustry;
	}

	public void setTaxIndustry(String taxIndustry) {
		this.taxIndustry = taxIndustry;
	}

	public Integer getTaxMarried() {
		return taxMarried;
	}

	public void setTaxMarried(Integer taxMarried) {
		this.taxMarried = taxMarried;
	}

	public String getTaxEmail() {
		return taxEmail;
	}

	public void setTaxEmail(String taxEmail) {
		this.taxEmail = taxEmail;
	}

	public Integer getTaxSenior() {
		return taxSenior;
	}

	public void setTaxSenior(Integer taxSenior) {
		this.taxSenior = taxSenior;
	}

	public String getTaxPart() {
		return taxPart;
	}

	public void setTaxPart(String taxPart) {
		this.taxPart = taxPart;
	}

	public Integer getTaxInteqral() {
		return taxInteqral;
	}

	public void setTaxIntegereqral(Integer taxInteqral) {
		this.taxInteqral = taxInteqral;
	}

}
