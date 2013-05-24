package com.org.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.SysRecordOfWork;
import com.org.service.SysRecordOfWorkService;

@SuppressWarnings("serial")
public class SysRecordOfWorkAction extends ActionSupport{
	//注入查询语句
	private SysRecordOfWorkService sysRecordOfWorkService;
	public SysRecordOfWorkService getSysRecordOfWorkService() {
		return sysRecordOfWorkService;
	}
	public void setSysRecordOfWorkService(
			SysRecordOfWorkService sysRecordOfWorkService) {
		this.sysRecordOfWorkService = sysRecordOfWorkService;
	}
	//编号
	private Integer id;
	//实体
	private SysRecordOfWork sysRecordOfWork;
	//对象List
	private List<SysRecordOfWork> list;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SysRecordOfWork getSysRecordOfWork() {
		return sysRecordOfWork;
	}
	public void setSysRecordOfWork(SysRecordOfWork sysRecordOfWork) {
		this.sysRecordOfWork = sysRecordOfWork;
	}
	public List<SysRecordOfWork> getList() {
		return list;
	}
	public void setList(List<SysRecordOfWork> list) {
		this.list = list;
	}
	/*方法主题*/
	/**
	 * 初始化查询方法返回对象数组
	 * @return 返回页面
	 */
	public String sysRecordOfWorkActionSelectAll(){
		return null;
	}
	public String sysRecordOfWorkActionSelectByTime(){
		return null;
	}
	public String sysRecordOfWorkActionSelectByID(){
		return null;
	}
	
	/**
	 * 删除方法根据编号删除
	 * @return 返回页面
	 */
	public String sysRecordOfWorkActiondelete(){
		return null;
	}
	/**
	 * 插入方法
	 * @return 返回页面
	 */
	public String sysRecordOfWorkActioninsert(){
		return null;
	}
	/**
	 * 修改页面
	 * @return返回页面
	 */
	public String sysRecordOfWorkActionupdate(){
		return null;
	}
	
	
}
