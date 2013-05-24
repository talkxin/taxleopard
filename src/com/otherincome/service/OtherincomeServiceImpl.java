package com.otherincome.service;

import com.otherincome.dao.OtherincomeDao;
import com.otherincome.entity.OiOtherincome;

public class OtherincomeServiceImpl implements OtherincomeService{
	private OtherincomeDao otherincomeDao;

	public OtherincomeDao getOtherincomeDao() {
		return otherincomeDao;
	}

	public void setOtherincomeDao(OtherincomeDao otherincomeDao) {
		this.otherincomeDao = otherincomeDao;
	}

	public void addOtherincome(OiOtherincome oo) {
		// TODO Auto-generated method stub
		otherincomeDao.addOtherincome(oo);
	}

	public void upOtherincome(OiOtherincome oo) {
		// TODO Auto-generated method stub
		otherincomeDao.upOtherincome(oo);
	}

	public void delOtherincome(int oo) {
		// TODO Auto-generated method stub
		otherincomeDao.delOtherincome(oo);
	}
}
