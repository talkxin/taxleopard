package com.labor.entity;

public class LsLaborItem {

	private Integer uid;
	private Integer lid;
	private Integer ltid;
	private String itemName;
	private String companyName;
	private String itemNumSum;
	private String itemTaxSum;
	private String laborYear;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public Integer getLtid() {
		return ltid;
	}
	public void setLtid(Integer ltid) {
		this.ltid = ltid;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getItemNumSum() {
		return itemNumSum;
	}
	public void setItemNumSum(String itemNumSum) {
		this.itemNumSum = itemNumSum;
	}
	public String getItemTaxSum() {
		return itemTaxSum;
	}
	public void setItemTaxSum(String itemTaxSum) {
		this.itemTaxSum = itemTaxSum;
	}
	public String getLaborYear() {
		return laborYear;
	}
	public void setLaborYear(String laborYear) {
		this.laborYear = laborYear;
	}
	
}
