package com.org.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能项表
 * */
public class Functions {
	private int functionID;// 功能项表ID
	private String functionName;// 功能项表姓名
	private int functionReside;// 所属功能
	private int functionLink;// 功能连接
	private int functionWhether;// 停用与否
	private String functionBewrite;// 功能描述
	private String functionImages;// 功能图片
	private int functionCharge;// 收费情况
	private List<Functions> list = new ArrayList<Functions>();

	public List<Functions> getList() {
		return list;
	}

	public void setList(List<Functions> list) {
		this.list = list;
	}

	public int getFunctionID() {
		return functionID;
	}

	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public int getFunctionLink() {
		return functionLink;
	}

	public void setFunctionLink(int functionLink) {
		this.functionLink = functionLink;
	}

	public int getFunctionWhether() {
		return functionWhether;
	}

	public void setFunctionWhether(int functionWhether) {
		this.functionWhether = functionWhether;
	}

	public String getFunctionBewrite() {
		return functionBewrite;
	}

	public void setFunctionBewrite(String functionBewrite) {
		this.functionBewrite = functionBewrite;
	}

	public String getFunctionImages() {
		return functionImages;
	}

	public void setFunctionImages(String functionImages) {
		this.functionImages = functionImages;
	}

	public int getFunctionReside() {
		return functionReside;
	}

	public void setFunctionReside(int functionReside) {
		this.functionReside = functionReside;
	}

	public int getFunctionCharge() {
		return functionCharge;
	}

	public void setFunctionCharge(int functionCharge) {
		this.functionCharge = functionCharge;
	}

	public String getFunctionBasic() {
		return functionBasic;
	}

	public void setFunctionBasic(String functionBasic) {
		this.functionBasic = functionBasic;
	}

	private String functionBasic;// 基本情况
}
