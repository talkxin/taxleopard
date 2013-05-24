package com.org.entity;

/**
 * 税模块表
 * */
public class Dutys {
	private int dutysID;// 税模块编号
	private String dutysName;// 税模块名称
	private String dutysMax;// 封征数
	private String dutysMin;// 起征点

	public int getDutysID() {
		return dutysID;
	}

	public void setDutysID(int dutysID) {
		this.dutysID = dutysID;
	}

	public String getDutysName() {
		return dutysName;
	}

	public void setDutysName(String dutysName) {
		this.dutysName = dutysName;
	}

	public String getDutysMax() {
		return dutysMax;
	}

	public void setDutysMax(String dutysMax) {
		this.dutysMax = dutysMax;
	}

	public String getDutysMin() {
		return dutysMin;
	}

	public void setDutysMin(String dutysMin) {
		this.dutysMin = dutysMin;
	}
}
