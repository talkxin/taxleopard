package com.org.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.Duty;
import com.org.service.DutyService;

@SuppressWarnings("serial")
public class DutyAction extends ActionSupport {
	private Duty duty;
	private DutyService dutyService;
	private int dutyID;

	public int getDutyID() {
		return dutyID;
	}

	public void setDutyID(int dutyID) {
		this.dutyID = dutyID;
	}

	public Duty getDuty() {
		return duty;
	}

	public void setDuty(Duty duty) {
		this.duty = duty;
	}

	public DutyService getDutyService() {
		return dutyService;
	}

	public void setDutyService(DutyService dutyService) {
		this.dutyService = dutyService;
	}

	/**
	 * 添加税法
	 * */
	public String addDuty() throws Exception {
		dutyService.addDuty(duty);
		return "addDutySuccess";
	}

	/**
	 * 删除税法
	 * */
	public String delDuty() throws Exception {
		dutyService.delDuty(dutyID);
		return "delDutySuccess";
	}

	/**
	 * 更改税法
	 * */
	public String updDuty() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	/**
	 * 查询税法
	 * */
	public String findDuty() throws Exception {
		List<Duty> list = dutyService.findDutys();
		if (list.size() > 0) {
			ActionContext.getContext().put("list", list);
			return "findDutySuccess";
		} else {
			return "findDutyError";
		}
	}
}
