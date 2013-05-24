package com.paychex.entity;
/**
 * 社保信息表
 * */
public class Insurance {

	private Integer uid;
	private Integer piid;
	private String userArea;
	private Integer insuranceType;
	private Integer housingType;
	private String insuranceInNumber;
	private String insuranceCardinal;
	private String housingCardinal;
	private String pensionB;
	private String pensionP;
	private String medicalB;
	private String medicalP;
	private String unemploymentB;
	private String unemploymentP;
	private String housingB;
	private String housingP;
	private String pensionCB;
	private String pensionC;
	private String medicalCB;
	private String medicalC;
	private String unemploymentCB;
	private String unemploymentC;
	private String industrialCB;
	private String industrialC;
	private String birthCB;
	private String birthC;
	private String housingCB;
	private String housingC;
	private String insSum;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPiid() {
		return piid;
	}
	public void setPiid(Integer piid) {
		this.piid = piid;
	}
	
	public Integer getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(Integer insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getUserArea() {
		return userArea;
	}
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}
	public Integer getHousingType() {
		return housingType;
	}
	public void setHousingType(Integer housingType) {
		this.housingType = housingType;
	}
	public String getInsuranceInNumber() {
		return insuranceInNumber;
	}
	public void setInsuranceInNumber(String insuranceInNumber) {
		this.insuranceInNumber = insuranceInNumber;
	}
	public String getInsuranceCardinal() {
		return insuranceCardinal;
	}
	public void setInsuranceCardinal(String insuranceCardinal) {
		this.insuranceCardinal = insuranceCardinal;
	}
	public String getHousingCardinal() {
		return housingCardinal;
	}
	public void setHousingCardinal(String housingCardinal) {
		this.housingCardinal = housingCardinal;
	}
	public String getPensionB() {
		return pensionB;
	}
	public void setPensionB(String pensionB) {
		this.pensionB = pensionB;
	}
	public String getPensionP() {
		return pensionP;
	}
	public void setPensionP(String pensionP) {
		this.pensionP = pensionP;
	}
	public String getMedicalB() {
		return medicalB;
	}
	public void setMedicalB(String medicalB) {
		this.medicalB = medicalB;
	}
	public String getMedicalP() {
		return medicalP;
	}
	public void setMedicalP(String medicalP) {
		this.medicalP = medicalP;
	}
	public String getUnemploymentB() {
		return unemploymentB;
	}
	public void setUnemploymentB(String unemploymentB) {
		this.unemploymentB = unemploymentB;
	}
	public String getUnemploymentP() {
		return unemploymentP;
	}
	public void setUnemploymentP(String unemploymentP) {
		this.unemploymentP = unemploymentP;
	}
	public String getHousingB() {
		return housingB;
	}
	public void setHousingB(String housingB) {
		this.housingB = housingB;
	}
	public String getHousingP() {
		return housingP;
	}
	public void setHousingP(String housingP) {
		this.housingP = housingP;
	}
	public String getPensionCB() {
		return pensionCB;
	}
	public void setPensionCB(String pensionCB) {
		this.pensionCB = pensionCB;
	}
	public String getPensionC() {
		return pensionC;
	}
	public void setPensionC(String pensionC) {
		this.pensionC = pensionC;
	}
	public String getMedicalCB() {
		return medicalCB;
	}
	public void setMedicalCB(String medicalCB) {
		this.medicalCB = medicalCB;
	}
	public String getMedicalC() {
		return medicalC;
	}
	public void setMedicalC(String medicalC) {
		this.medicalC = medicalC;
	}
	public String getUnemploymentCB() {
		return unemploymentCB;
	}
	public void setUnemploymentCB(String unemploymentCB) {
		this.unemploymentCB = unemploymentCB;
	}
	public String getUnemploymentC() {
		return unemploymentC;
	}
	public void setUnemploymentC(String unemploymentC) {
		this.unemploymentC = unemploymentC;
	}
	public String getIndustrialCB() {
		return industrialCB;
	}
	public void setIndustrialCB(String industrialCB) {
		this.industrialCB = industrialCB;
	}
	public String getIndustrialC() {
		return industrialC;
	}
	public void setIndustrialC(String industrialC) {
		this.industrialC = industrialC;
	}
	public String getBirthCB() {
		return birthCB;
	}
	public void setBirthCB(String birthCB) {
		this.birthCB = birthCB;
	}
	public String getBirthC() {
		return birthC;
	}
	public void setBirthC(String birthC) {
		this.birthC = birthC;
	}
	public String getHousingCB() {
		return housingCB;
	}
	public void setHousingCB(String housingCB) {
		this.housingCB = housingCB;
	}
	public String getHousingC() {
		return housingC;
	}
	public void setHousingC(String housingC) {
		this.housingC = housingC;
	}
	
	public String getInsSum() {
		return insSum;
	}
	public void setInsSum(String insSum) {
		this.insSum = insSum;
	}
	@Override
	public String toString() {
		return "Insurance [birthC=" + birthC + ", birthCB=" + birthCB
				+ ", housingB=" + housingB + ", housingC=" + housingC
				+ ", housingCB=" + housingCB + ", housingCardinal="
				+ housingCardinal + ", housingP=" + housingP + ", housingType="
				+ housingType + ", industrialC=" + industrialC
				+ ", industrialCB=" + industrialCB + ", insSum=" + insSum
				+ ", insuranceCardinal=" + insuranceCardinal
				+ ", insuranceInNumber=" + insuranceInNumber
				+ ", insuranceType=" + insuranceType + ", medicalB=" + medicalB
				+ ", medicalC=" + medicalC + ", medicalCB=" + medicalCB
				+ ", medicalP=" + medicalP + ", pensionB=" + pensionB
				+ ", pensionC=" + pensionC + ", pensionCB=" + pensionCB
				+ ", pensionP=" + pensionP + ", piid=" + piid + ", uid=" + uid
				+ ", unemploymentB=" + unemploymentB + ", unemploymentC="
				+ unemploymentC + ", unemploymentCB=" + unemploymentCB
				+ ", unemploymentP=" + unemploymentP + ", userArea=" + userArea
				+ "]";
	}
	
	
	
	
}
