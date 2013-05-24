package com.org.service;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.Press;

public interface PressService {
	/**
	 * 添加新闻
	 * 
	 * @throws SQLException
	 * */
	public void addPress(Press press) throws SQLException;

	/**
	 * 查询新闻
	 * 
	 * @throws SQLException
	 * */
	public List<Press> findPress() throws SQLException;

	/**
	 * 更改新闻
	 * 
	 * @throws SQLException
	 * */
	public void updPress(Press press) throws SQLException;

	/**
	 * 删除新闻
	 * 
	 * @throws SQLException
	 * */
	public void delPress(int pressID) throws SQLException;

	/**
	 *根据ID查询新闻
	 * 
	 * @throws SQLException
	 * */
	public Press findPressByID(int pressID) throws SQLException;

	/***
	 * 查询下一篇
	 * 
	 * @throws SQLException
	 * */
	public Press findNextPress(int pressID) throws SQLException;

	/**
	 * 查询上一篇
	 * 
	 * @throws SQLException
	 * */
	public Press findUpPress(int pressID) throws SQLException;

	/**
	 * 查询分页
	 * 
	 * @throws SQLException
	 * */
	public List<Press> findPage(Press press) throws SQLException;

	/**
	 * 查询总记录数
	 * 
	 * @throws SQLException
	 * **/
	public Integer recordCount(String where) throws SQLException;
	/**
	 * 查询新闻首页
	 * @return
	 * @throws SQLException
	 */
	public List<Press> selectNewIndex() throws SQLException;
}
