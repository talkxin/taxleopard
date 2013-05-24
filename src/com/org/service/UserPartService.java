package com.org.service;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.UserPart;

public interface UserPartService {

	/**
	 * 添加角色
	 * 
	 * @throws SQLException
	 * */
	public void addUserPart(UserPart userPart) throws SQLException;

	/**
	 * 查询角色
	 * 
	 * @throws SQLException
	 * */
	public List<UserPart> findUserPart() throws SQLException;

	/**
	 * 删除角色
	 * 
	 * @throws SQLException
	 * */
	public void delUserPart(int userPartID) throws SQLException;

	/**
	 * 更改角色
	 * 
	 * @throws SQLException
	 * */
	public void updUserPart(UserPart userPart) throws SQLException;

}
