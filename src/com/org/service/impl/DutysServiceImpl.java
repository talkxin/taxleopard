package com.org.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.dao.DutysDao;
import com.org.entity.Dutys;
import com.org.service.DutysService;

public class DutysServiceImpl implements DutysService {
	private DutysDao dutysDao;

	public DutysDao getDutysDao() {
		return dutysDao;
	}

	public void setDutysDao(DutysDao dutysDao) {
		this.dutysDao = dutysDao;
	}

	public void addDutys(Dutys dutys) throws SQLException {
		dutysDao.addDutys(dutys);

	}

	public void delDutys(int DutysID) throws SQLException {
		dutysDao.delDutys(DutysID);

	}

	public List<Dutys> findDutys() throws SQLException {
		return dutysDao.findDutys();
	}

	public void updDutys(Dutys dutys) throws SQLException {
		dutysDao.updDutys(dutys);
	}

}
