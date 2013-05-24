package com.org.dao;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.RecordOfWork;

public interface RecordOfWorkDao {
	/**
	 * 根据编号删除
	 * @param id
	 * @throws SQLException
	 */
	public void delete(Integer id) throws SQLException;
	/**
	 * 添加
	 * @param recordOfWork
	 * @throws SQLException
	 */
	public void insert(RecordOfWork recordOfWork) throws SQLException;
	/**
	 * 按照时间查询
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public List<RecordOfWork> selectByTime(RecordOfWork recordOfWork) throws SQLException;
	/**
	 * 按照编号查询
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public RecordOfWork selectByID(Integer id) throws SQLException;
	/**
	 * 查询所有
	 * @return
	 * @throws SQLException
	 */
	public List<RecordOfWork> selectAll(Integer userID) throws SQLException;
	/**
	 * 根据编号修改
	 * @param recordOfWork
	 * @throws SQLException
	 */
	public void update(RecordOfWork recordOfWork) throws SQLException;

}
