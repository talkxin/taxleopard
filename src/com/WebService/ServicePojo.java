package com.WebService;

import java.util.HashMap;

/***
 * 此类是处理所有传入请求的基本对象类，ArrayList中封装了一次或者数次同样请求的操作HashMap
 * 此HashMap的请求合法性是此类会出现及容易出现的错误之一
 * @author 刘鑫
 *
 */
public class ServicePojo {

	//验证码存储
	private String verification;
	//返回服务器错误
	private String ServerError;
	//业务存储的List
	@SuppressWarnings("unchecked")
	private HashMap<String,HashMap> businessList=new HashMap<String, HashMap>();
	public String getVerification() {
		return verification;
	}
	public void setVerification(String verification) {
		this.verification = verification;
	}
	public String getServerError() {
		return ServerError;
	}
	public void setServerError(String serverError) {
		ServerError = serverError;
	}
	@SuppressWarnings("unchecked")
	public HashMap<String, HashMap> getBusinessList() {
		return businessList;
	}
	@SuppressWarnings("unchecked")
	public void setBusinessList(HashMap<String, HashMap> businessList) {
		this.businessList = businessList;
	}
}
