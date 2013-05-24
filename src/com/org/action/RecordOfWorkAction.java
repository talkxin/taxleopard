package com.org.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.RecordOfWork;
import com.org.service.RecordOfWorkService;

@SuppressWarnings("serial")
public class RecordOfWorkAction  extends ActionSupport{
	//Spring 注入Service
	private RecordOfWorkService recordOfWorkService;
	public RecordOfWorkService getRecordOfWorkService() {
		return recordOfWorkService;
	}
	public void setRecordOfWorkService(RecordOfWorkService recordOfWorkService) {
		this.recordOfWorkService = recordOfWorkService;
	}
	//日志对象用于增加和修改
	private RecordOfWork recordOfWork;
	public RecordOfWork getRecordOfWork() {
		return recordOfWork;
	}
	public void setRecordOfWork(RecordOfWork recordOfWork) {
		this.recordOfWork = recordOfWork;
	}
	//List查询
	private List<RecordOfWork> recordOfWorkList = new ArrayList<RecordOfWork>();
	public List<RecordOfWork> getRecordOfWorkList() {
		return recordOfWorkList;
	}
	public void setRecordOfWorkList(List<RecordOfWork> recordOfWorkList) {
		this.recordOfWorkList = recordOfWorkList;
	}
	//Integer 值仅仅存储对象编号用于删除操作
	private Integer deleteInteger;
	public Integer getDeleteInteger() {
		return deleteInteger;
	}
	public void setDeleteInteger(Integer deleteInteger) {
		this.deleteInteger = deleteInteger;
	}
	//对数据的操作
	/**
	 * 用于删除操作
	 * @return 用户界面连接地址 Success and delete Error
	 */
	public String recordOfWorkDelete(){
		return null;
	}
	/**
	 * 用于增加操作
	 * @return 用户界面连接地址 Insert Success and Insert Error
	 */
	public String recordOfWorkInsert(){
		return null;
	}
	/**
	 * 用于日志查询初始化操作
	 * @return 用户界面连接地址 List Success and List Error
	 */
	public String recordOfWorkList(){
		return null;
	}
	/**
	 * 用于查询单条对象
	 * @return 用户界面连接地址 Object Success and Object Error
	 */
	public String recordOfWorkObject(){
		return null;
	}
	
	
	
	

}
