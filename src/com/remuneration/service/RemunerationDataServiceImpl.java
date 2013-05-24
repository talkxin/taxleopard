package com.remuneration.service;

import java.util.List;

import com.remuneration.dao.RemunerationDataDao;
import com.remuneration.entity.RePressType;
import com.remuneration.entity.RePublish;
import com.remuneration.entity.ReRemunerationInfo;

public class RemunerationDataServiceImpl implements RemunerationDataService {
	private RemunerationDataDao remunerationDataDao;

	public RemunerationDataDao getRemunerationDataDao() {
		return remunerationDataDao;
	}

	public void setRemunerationDataDao(RemunerationDataDao remunerationDataDao) {
		this.remunerationDataDao = remunerationDataDao;
	}

	public ReRemunerationInfo addRemunerationInfo(ReRemunerationInfo re) {
		// TODO Auto-generated method stub
		return remunerationDataDao.addRemunerationInfo(re);
	}

	public void upRemunerationInfo(ReRemunerationInfo re) {
		// TODO Auto-generated method stub
		remunerationDataDao.upRemunerationInfo(re);
	}

	public void delRemunerationInfo(int re) {
		// TODO Auto-generated method stub
		remunerationDataDao.delRemunerationInfo(re);
	}

	public RePressType addRePressType(RePressType re) {
		// TODO Auto-generated method stub
		return remunerationDataDao.addRePressType(re);
	}

	public void upRePressType(RePressType re) {
		// TODO Auto-generated method stub
		remunerationDataDao.upRePressType(re);
	}

	public void delRePressType(int re) {
		// TODO Auto-generated method stub
		remunerationDataDao.delRePressType(re);
	}

	public void addRePublish(RePublish re) {
		// TODO Auto-generated method stub
		remunerationDataDao.addRePublish(re);
	}

	public void upRePublish(RePublish re) {
		// TODO Auto-generated method stub
		remunerationDataDao.upRePublish(re);
	}

	public void delRePublish(int re) {
		// TODO Auto-generated method stub
		remunerationDataDao.delRePublish(re);
	}

	public List<ReRemunerationInfo> isGetReRemunerationInfo(int re) {
		// TODO Auto-generated method stub
		return remunerationDataDao.isGetReRemunerationInfo(re);
	}

	public List<RePressType> isGetRePressType(int re) {
		// TODO Auto-generated method stub
		return remunerationDataDao.isGetRePressType(re);
	}

	public List<RePressType> isGetAllRePressType(int re) {
		// TODO Auto-generated method stub
		return remunerationDataDao.isGetAllRePressType(re);
	}
}
