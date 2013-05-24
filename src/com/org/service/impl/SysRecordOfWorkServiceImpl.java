package com.org.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.dao.SysRecordOfWorkDao;
import com.org.entity.SysRecordOfWork;
import com.org.service.SysRecordOfWorkService;

public class SysRecordOfWorkServiceImpl implements SysRecordOfWorkService {
	private SysRecordOfWorkDao sysRecordOfWorkDao;
	public SysRecordOfWorkDao getSysRecordOfWorkDao() {
		return sysRecordOfWorkDao;
	}
	public void setSysRecordOfWorkDao(SysRecordOfWorkDao sysRecordOfWorkDao) {
		this.sysRecordOfWorkDao = sysRecordOfWorkDao;
	}

	public void delete(Integer integer) throws SQLException {
		sysRecordOfWorkDao.delete(integer);
	}

	public void insert(SysRecordOfWork sysRecordOfWork) throws SQLException {
		sysRecordOfWorkDao.insert(sysRecordOfWork);
	}

	public List<SysRecordOfWork> select() throws SQLException {
		return sysRecordOfWorkDao.select();
	}

	public SysRecordOfWork select(Integer integer) throws SQLException {
		return sysRecordOfWorkDao.select(integer);
	}

	public List<SysRecordOfWork> select(SysRecordOfWork sysRecordOfWork)
			throws SQLException {
		return sysRecordOfWorkDao.select(sysRecordOfWork);
	}

	public void update(SysRecordOfWork sysRecordOfWork) throws SQLException {
		sysRecordOfWorkDao.update(sysRecordOfWork);
	}

}
