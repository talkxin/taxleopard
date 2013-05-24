package com.paychex.entity;
/**
 * 工资信息表
 * */
public class PayrollInfo {
    private Integer piid;//编号
    private Integer uid;//用户编号
    private Integer industry;//行业
    private Integer industryXZ;//职位性质
    private Integer userNation;//国籍
    private Integer companyType;//公司类型
    private String companyName;//单位名称
    private Integer companyAdd;//工作地区
    private Integer payDay;//发薪时间
    private String payDay2;//年发薪时间
    private String incomeDay;//入职时间
    private Integer payType;//薪金类型
    private String payNumber;//合同工资数额（基础工资）
	public Integer getPiid() {
		return piid;
	}
	public void setPiid(Integer piid) {
		this.piid = piid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getIndustry() {
		return industry;
	}
	public void setIndustry(Integer industry) {
		this.industry = industry;
	}
	public Integer getIndustryXZ() {
		return industryXZ;
	}
	public void setIndustryXZ(Integer industryXZ) {
		this.industryXZ = industryXZ;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getCompanyAdd() {
		return companyAdd;
	}
	public void setCompanyAdd(Integer companyAdd) {
		this.companyAdd = companyAdd;
	}
	public Integer getPayDay() {
		return payDay;
	}
	public void setPayDay(Integer payDay) {
		this.payDay = payDay;
	}
	public String getIncomeDay() {
		return incomeDay;
	}
	public void setIncomeDay(String incomeDay) {
		this.incomeDay = incomeDay;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public String getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}
	
	public Integer getUserNation() {
		return userNation;
	}
	public void setUserNation(Integer userNation) {
		this.userNation = userNation;
	}
	public String getPayDay2() {
			return payDay2;
	}
    public void setPayDay2(String payDay2) {
			this.payDay2 = payDay2;
	}
	public Integer getCompanyType() {
			return companyType;
	}
	public void setCompanyType(Integer companyType) {
			this.companyType = companyType;
	}
	
      
}
