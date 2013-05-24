package com.org.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.dao.PressDao;
import com.org.entity.Press;
import com.org.service.PressService;

public class PressServiceImpl implements PressService {
	private PressDao pressDao;

	public PressDao getPressDao() {
		return pressDao;
	}

	public void setPressDao(PressDao pressDao) {
		this.pressDao = pressDao;
	}

	/**
	 *添加新闻
	 * */
	public void addPress(Press press) throws SQLException {
		pressDao.addPress(press);

	}

	/**
	 * 删除新闻
	 * */
	public void delPress(int pressID) throws SQLException {
		pressDao.delPress(pressID);

	}

	/**
	 * 查询新闻
	 * */
	public List<Press> findPress() throws SQLException {
		return pressDao.findPress();
	}

	/**
	 * 更改新闻
	 * */
	public void updPress(Press press) throws SQLException {
		pressDao.updPress(press);

	}

	/**
	 * 根据ID查询新闻
	 * 
	 * @throws SQLException
	 * */
	public Press findPressByID(int pressID) throws SQLException {
		return pressDao.findPressByID(pressID);
	}

	/***
	 * 查询下一篇
	 * */
	public Press findNextPress(int pressID) throws SQLException {
		return pressDao.findNextPress(pressID);
	}

	/**
	 * 查询上一篇
	 * */
	public Press findUpPress(int pressID) throws SQLException {
		return pressDao.findUpPress(pressID);
	}

	/**
	 * 查询分页
	 * @throws SQLException 
	 * */
	public List<Press> findPage(Press press) throws SQLException {
		return pressDao.findPage(press);
	}

	/***
	 * 查询总记录数
	 * @throws SQLException 
	 * */
	public Integer recordCount(String where) throws SQLException {
		return pressDao.recordCount(where);
	}

	public List<Press> selectNewIndex() throws SQLException {
		return pressDao.selectNewIndex();
	}
}
