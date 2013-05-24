package com.org.entity;

/**
 * 税表
 * */
public class Duty {
	private int dutyID;// 税表编号
	private String dutyName;// 税项名称
	private String dutyCess;// 税率
	private String dutyQuick;// 速算扣除数
	private String dutyPrice;// 含税
	private String dutySales;// 不含税
	private int fuormulaID;// 公式编号
	private int dutysID;// 税模块编号

	public int getDutyID() {
		return dutyID;
	}

	public void setDutyID(int dutyID) {
		this.dutyID = dutyID;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public String getDutyCess() {
		return dutyCess;
	}

	public void setDutyCess(String dutyCess) {
		this.dutyCess = dutyCess;
	}

	public String getDutyQuick() {
		return dutyQuick;
	}

	public void setDutyQuick(String dutyQuick) {
		this.dutyQuick = dutyQuick;
	}

	public String getDutyPrice() {
		return dutyPrice;
	}

	public void setDutyPrice(String dutyPrice) {
		this.dutyPrice = dutyPrice;
	}

	public String getDutySales() {
		return dutySales;
	}

	public void setDutySales(String dutySales) {
		this.dutySales = dutySales;
	}

	public int getFuormulaID() {
		return fuormulaID;
	}

	public void setFuormulaID(int fuormulaID) {
		this.fuormulaID = fuormulaID;
	}

	public int getDutysID() {
		return dutysID;
	}

	public void setDutysID(int dutysID) {
		this.dutysID = dutysID;
	}

}
