package com.org.dao;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.AdminRegister;

public interface AdminRegisterDao {
	/***
	 * 添加登录记录
	 * 
	 * @throws SQLException
	 * */
	public void addAdminRegister(AdminRegister adminRegister)
			throws SQLException;

	/***
	 * 查询登录记录
	 * 
	 * @throws SQLException
	 * */
	public List<AdminRegister> findAdminRegister() throws SQLException;
	/**
	 * 查询通过用户名
	 * @return
	 * @throws SQLException
	 */
	public AdminRegister selectUserByUserID(String userName)throws SQLException;
}
