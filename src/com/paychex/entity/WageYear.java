package com.paychex.entity;
/**
 * 年视图
 * */
public class WageYear {
    private Integer taxID;//用户编号
	private String basicWageSum;//各个月基础工资和
	private String prizeSum;//各个月奖金和
	private String subsidySum;//各个月补贴和
	private String insuranceSum;//月社保（养老+医疗+失业+公积金）
	private String bonusSum;//各个月分红和
    private String payOutNumberSum;//各个月税后收入和
	private String taxNumberSum;//各个月应纳税额和
	private String inPayYear;
	private String prizeYear;
	private String subsidyYear;
	private String bonusYear;
	private String deductionSum;
	private String cooInsSum;
	private String retSum;
	private String retmSum;
	public Integer getTaxID() {
		return taxID;
	}
	public void setTaxID(Integer taxID) {
		this.taxID = taxID;
	}
    
	
	public String getBasicWageSum() {
		return basicWageSum;
	}
	public void setBasicWageSum(String basicWageSum) {
		this.basicWageSum = basicWageSum;
	}
	public String getPrizeSum() {
		return prizeSum;
	}
	public void setPrizeSum(String prizeSum) {
		this.prizeSum = prizeSum;
	}
	public String getSubsidySum() {
		return subsidySum;
	}
	public void setSubsidySum(String subsidySum) {
		this.subsidySum = subsidySum;
	}
	public String getInsuranceSum() {
		return insuranceSum;
	}
	public void setInsuranceSum(String insuranceSum) {
		this.insuranceSum = insuranceSum;
	}
	public String getBonusSum() {
		return bonusSum;
	}
	public void setBonusSum(String bonusSum) {
		this.bonusSum = bonusSum;
	}
	public String getPayOutNumberSum() {
		return payOutNumberSum;
	}
	public void setPayOutNumberSum(String payOutNumberSum) {
		this.payOutNumberSum = payOutNumberSum;
	}
	public String getTaxNumberSum() {
		return taxNumberSum;
	}
	public void setTaxNumberSum(String taxNumberSum) {
		this.taxNumberSum = taxNumberSum;
	}
	public String getInPayYear() {
		return inPayYear;
	}
	public void setInPayYear(String inPayYear) {
		this.inPayYear = inPayYear;
	}
	public String getPrizeYear() {
		return prizeYear;
	}
	public void setPrizeYear(String prizeYear) {
		this.prizeYear = prizeYear;
	}
	public String getSubsidyYear() {
		return subsidyYear;
	}
	public void setSubsidyYear(String subsidyYear) {
		this.subsidyYear = subsidyYear;
	}
	public String getBonusYear() {
		return bonusYear;
	}
	public void setBonusYear(String bonusYear) {
		this.bonusYear = bonusYear;
	}
	public String getDeductionSum() {
		return deductionSum;
	}
	public void setDeductionSum(String deductionSum) {
		this.deductionSum = deductionSum;
	}
	public String getCooInsSum() {
		return cooInsSum;
	}
	public void setCooInsSum(String cooInsSum) {
		this.cooInsSum = cooInsSum;
	}
	public String getRetSum() {
		return retSum;
	}
	public void setRetSum(String retSum) {
		this.retSum = retSum;
	}
	public String getRetmSum() {
		return retmSum;
	}
	public void setRetmSum(String retmSum) {
		this.retmSum = retmSum;
	}
	
	
	
	
}
