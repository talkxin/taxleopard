package com.org.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.dao.AdminRegisterDao;
import com.org.entity.AdminRegister;
import com.org.service.AdminRegisterService;

public class AdminRegisterServiceImpl implements AdminRegisterService {
	private AdminRegisterDao adminRegisterDao;

	public AdminRegisterDao getAdminRegisterDao() {
		return adminRegisterDao;
	}

	public void setAdminRegisterDao(AdminRegisterDao adminRegisterDao) {
		this.adminRegisterDao = adminRegisterDao;
	}

	/**
	 * 添加登录信息
	 * @throws SQLException 
	 * */
	public void addAdminRegister(AdminRegister adminRegister) throws SQLException {
		adminRegisterDao.addAdminRegister(adminRegister);
	}
	/***
	 * 查询登录信息
	 * @throws SQLException 
	 * */
	public List<AdminRegister> findAdminRegister() throws SQLException {
		return adminRegisterDao.findAdminRegister();
	}

	public AdminRegister selectUserByUserID(String userName)
			throws SQLException {
		return adminRegisterDao.selectUserByUserID(userName);
	}
}
