package com.geti.service;

import java.sql.SQLException;

import com.geti.dao.GetiDao;
import com.geti.entity.GtGetigongshang;

public class GetiServiceImpl implements GetiService{
	private GetiDao getiDao;

	public GetiDao getGetiDao() {
		return getiDao;
	}

	public void setGetiDao(GetiDao getiDao) {
		this.getiDao = getiDao;
	}

	public void addGetti(GtGetigongshang gt) throws SQLException {
		// TODO Auto-generated method stub
		getiDao.addGetti(gt);
	}

	public void upGetti(GtGetigongshang gt) throws SQLException {
		// TODO Auto-generated method stub
		getiDao.upGetti(gt);
	}

	public void delGetti(int gt) throws SQLException {
		// TODO Auto-generated method stub
		getiDao.delGetti(gt);
	}
}
