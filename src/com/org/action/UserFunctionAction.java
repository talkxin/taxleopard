package com.org.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.UserFunction;
import com.org.service.UserFunctionService;

@SuppressWarnings("serial")
public class UserFunctionAction extends ActionSupport {
	private UserFunctionService userFunctionService;
	private UserFunction userFunction;
	private int[] functionID;
	private Date date;

	public Date getDate() {
		return date;
	}

	public int[] getFunctionID() {
		return functionID;
	}

	public void setFunctionID(int[] functionID) {
		this.functionID = functionID;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserFunction getUserFunction() {
		return userFunction;
	}

	public void setUserFunction(UserFunction userFunction) {
		this.userFunction = userFunction;
	}

	public UserFunctionService getUserFunctionService() {
		return userFunctionService;
	}

	public void setUserFunctionService(UserFunctionService userFunctionService) {
		this.userFunctionService = userFunctionService;
	}

	/**
	 * 给用户添加功能
	 * */
	public String addUserFunction() throws Exception {
		for (int i = 0; i < functionID.length; i++) {
			System.out.println(functionID[i]);
			userFunction.setFunctionID(functionID[i]);
			userFunction.setExpirationDate(date);
			userFunctionService.addUserFunction(userFunction);
		}
		return "addUserFunctionSuccess";
	}
}
