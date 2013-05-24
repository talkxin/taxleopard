package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.AdminRegister;
import com.org.service.AdminRegisterService;

@SuppressWarnings("serial")
public class AdminRegisterAction extends ActionSupport {
	private AdminRegisterService adminRegisterService;
	private AdminRegister adminRegister;

	public AdminRegister getAdminRegister() {
		return adminRegister;
	}

	public void setAdminRegister(AdminRegister adminRegister) {
		this.adminRegister = adminRegister;
	}

	public AdminRegisterService getAdminRegisterService() {
		return adminRegisterService;
	}

	public void setAdminRegisterService(
			AdminRegisterService adminRegisterService) {
		this.adminRegisterService = adminRegisterService;
	}

}
