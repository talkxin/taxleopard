package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.Dutys;
import com.org.service.DutysService;

@SuppressWarnings("serial")
public class DutysAction extends ActionSupport {
	private DutysService dutysService;
	private Dutys dutys;

	public Dutys getDutys() {
		return dutys;
	}

	public void setDutys(Dutys dutys) {
		this.dutys = dutys;
	}

	public DutysService getDutysService() {
		return dutysService;
	}

	public void setDutysService(DutysService dutysService) {
		this.dutysService = dutysService;
	}

	/**
	 * 添加税模块
	 * */
	public String addDutys() throws Exception {
		dutysService.addDutys(dutys);
		return "addDutysSuccess";
	}

}
