package com.org.service;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.SysRecordOfWork;

public interface SysRecordOfWorkService {
	public void update(SysRecordOfWork sysRecordOfWork)throws SQLException;
	public void insert(SysRecordOfWork sysRecordOfWork) throws SQLException;
	public void delete(Integer integer)throws SQLException;
	public List<SysRecordOfWork> select()throws SQLException;
	public SysRecordOfWork select(Integer integer)throws SQLException;
	public List<SysRecordOfWork> select(SysRecordOfWork sysRecordOfWork)throws SQLException;
}
