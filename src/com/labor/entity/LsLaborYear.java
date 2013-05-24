package com.labor.entity;

public class LsLaborYear {

	private Integer uid;
	private Integer lid;
	private String payOutNumSum;
	private String taxNumSum;
	private String companyName;
	private String laborYear;
	
	public LsLaborYear() {
	}

    public LsLaborYear(Integer uid,String payOutNumSum,
			String taxNumSum, String companyName, String laborYear) {
		super();
		this.uid = uid;
		this.payOutNumSum = payOutNumSum;
		this.taxNumSum = taxNumSum;
		this.companyName = companyName;
		this.laborYear = laborYear;
	}



	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
    
    public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getPayOutNumSum() {
		return payOutNumSum;
	}

	public void setPayOutNumSum(String payOutNumSum) {
		this.payOutNumSum = payOutNumSum;
	}

	public String getTaxNumSum() {
		return taxNumSum;
	}
	public void setTaxNumSum(String taxNumSum) {
		this.taxNumSum = taxNumSum;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLaborYear() {
		return laborYear;
	}
	public void setLaborYear(String laborYear) {
		this.laborYear = laborYear;
	}
	
}
