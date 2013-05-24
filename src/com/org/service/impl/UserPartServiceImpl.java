package com.org.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.dao.UserPartDao;
import com.org.entity.UserPart;
import com.org.service.UserPartService;

public class UserPartServiceImpl implements UserPartService {
	private UserPartDao userPartDao;

	public UserPartDao getUserPartDao() {
		return userPartDao;
	}

	public void setUserPartDao(UserPartDao userPartDao) {
		this.userPartDao = userPartDao;
	}

	/**
	 * 添加角色
	 * */
	public void addUserPart(UserPart userPart) throws SQLException {
		userPartDao.addUserPart(userPart);
	}

	public List<UserPart> findUserPart() throws SQLException {
		return userPartDao.findUserPart();
	}

	/**
	 * 删除角色
	 * 
	 * @throws SQLException
	 * */
	public void delUserPart(int userPartID) throws SQLException {
		userPartDao.delUserPart(userPartID);

	}

	/**
	 * 更改角色
	 * 
	 * */
	public void updUserPart(UserPart userPart) throws SQLException {
		userPartDao.updUserPart(userPart);
	}
}
