package com.savings.service;

import java.sql.SQLException;
import java.util.List;

import com.savings.dao.SavingsDao;
import com.savings.entity.SaInterest;
import com.savings.entity.SaSavings;
import com.savings.entity.SaSavingsInfo;

public class SavingsServiceImpl implements SavingsService{
	private SavingsDao savingsDao;

	public SavingsDao getSavingsDao() {
		return savingsDao;
	}

	public void setSavingsDao(SavingsDao savingsDao) {
		this.savingsDao = savingsDao;
	}

	public SaSavingsInfo addSaSavingsInfo(SaSavingsInfo sa) throws SQLException {
		// TODO Auto-generated method stub
		return savingsDao.addSaSavingsInfo(sa);
	}

	public void upSaSavingsInfo(SaSavingsInfo sa) throws SQLException {
		// TODO Auto-generated method stub
		savingsDao.upSaSavingsInfo(sa);
	}

	public void delSaSavingsInfo(int sa) throws SQLException {
		// TODO Auto-generated method stub
		savingsDao.delSaSavingsInfo(sa);
	}

	public void addSaSavings(SaSavings sa) throws SQLException {
		// TODO Auto-generated method stub
		savingsDao.addSaSavings(sa);
	}

	public void upSaSavings(SaSavings sa) throws SQLException {
		// TODO Auto-generated method stub
		savingsDao.upSaSavings(sa);
	}

	public void delSaSavings(int sa) throws SQLException {
		// TODO Auto-generated method stub
		savingsDao.delSaSavings(sa);
	}

	public List<SaSavingsInfo> isGetSavingsInfo(int sa) throws SQLException {
		// TODO Auto-generated method stub
		return savingsDao.isGetSavingsInfo(sa);
	}

	public void addInterest(SaInterest sa) throws SQLException {
		// TODO Auto-generated method stub
		savingsDao.addInterest(sa);
	}

	public void upInterest(SaInterest sa) throws SQLException {
		// TODO Auto-generated method stub
		savingsDao.upInterest(sa);
	}

	public void delInterest(int sa) throws SQLException {
		// TODO Auto-generated method stub
		savingsDao.delInterest(sa);
	}

	public List<SaInterest> isGetInterest(int sa) throws SQLException {
		// TODO Auto-generated method stub
		return savingsDao.isGetInterest(sa);
	}

	public SaInterest isGetNewInterest(int sa) throws SQLException {
		// TODO Auto-generated method stub
		return savingsDao.isGetNewInterest(sa);
	}
}
