package com.org.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.Functions;
import com.org.service.FunctionService;

@SuppressWarnings("serial")
public class FunctionAction extends ActionSupport {
	private FunctionService functionsService;
	private Functions function;
	private int functionID;

	public int getFunctionID() {
		return functionID;
	}

	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}

	public FunctionService getFunctionsService() {
		return functionsService;
	}

	public void setFunctionsService(FunctionService functionsService) {
		this.functionsService = functionsService;
	}

	public Functions getFunction() {
		return function;
	}

	public void setFunction(Functions function) {
		this.function = function;
	}

	/**
	 * 添加功能
	 * */
	public String addFunction() throws Exception {
		functionsService.addFunctions(function);
		return "addFunctionSuccess";
	}

	/**
	 * 删除功能
	 * */
	public String delFunctions() throws Exception {
		functionsService.delFunctions(functionID);
		return "delFunctionSuccess";
	}

	/**
	 * 查询功能
	 * */
	public String findFunction() throws Exception {
		List<Functions> list = functionsService.findFunction(1);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				List<Functions> list1 = functionsService.findReside(list.get(i)
						.getFunctionID());
				list.get(i).setList(list1);
			}
			ActionContext.getContext().put("list", list);
			System.out.println(list.size());
			return "findFunctionSuccess";
		} else {
			return "findFunctionError";
		}
	}

	/**
	 * 修改功能
	 * */
	public String execute() throws Exception {
		return super.execute();
	}
}
