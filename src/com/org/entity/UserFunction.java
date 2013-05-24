package com.org.entity;

import java.util.Date;

/**
 * 用户功能表
 * */
public class UserFunction {
	private int userFunctionID;// 用户功能表编号
	private int taxID;// 纳税人的编号
	private int functionID;// 功能表的编号
	private Date expirationDate;// 到期时间

	public int getUserFunctionID() {
		return userFunctionID;
	}

	public void setUserFunctionID(int userFunctionID) {
		this.userFunctionID = userFunctionID;
	}

	public int getTaxID() {
		return taxID;
	}

	public void setTaxID(int taxID) {
		this.taxID = taxID;
	}

	public int getFunctionID() {
		return functionID;
	}

	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
