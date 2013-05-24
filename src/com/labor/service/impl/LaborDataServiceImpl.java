package com.labor.service.impl;

import java.util.List;

import com.labor.dao.LaborDataDao;
import com.labor.entity.LsLaborCooItem;
import com.labor.entity.LsLaborInfo;
import com.labor.entity.LsLaborMonth;
import com.labor.entity.LsLaborService;
import com.labor.service.LaborDataService;

public class LaborDataServiceImpl implements LaborDataService {
	private LaborDataDao laborDataDao;

	public LaborDataDao getLaborDataDao() {
		return laborDataDao;
	}

	public void setLaborDataDao(LaborDataDao laborDataDao) {
		this.laborDataDao = laborDataDao;
	}

	public LsLaborInfo addLaborInfo(LsLaborInfo li) {
		// TODO Auto-generated method stub
		return laborDataDao.addLaborInfo(li);
	}

	public void addLaborService(List<LsLaborService> li) {
		// TODO Auto-generated method stub
		laborDataDao.addLaborService(li);
	}

	public void addLaborTax(LsLaborService li) {
		// TODO Auto-generated method stub
		laborDataDao.addLaborTax(li);
	}

	public void delLaboService(int li) {
		// TODO Auto-generated method stub
		laborDataDao.delLaboService(li);
	}

	public void delLaborInfo(int li) {
		// TODO Auto-generated method stub
		laborDataDao.delLaborInfo(li);
	}

	public void upLaborInfo(LsLaborInfo li) {
		// TODO Auto-generated method stub
		laborDataDao.upLaborInfo(li);
	}

	public void upLaborService(LsLaborMonth li) {
		// TODO Auto-generated method stub
		laborDataDao.upLaborService(li);
	}

	public List<LsLaborInfo> isGetUserCoo(int UID) {
		// TODO Auto-generated method stub
		return laborDataDao.isGetUserCoo(UID);
	}

	public List<LsLaborCooItem> isGetTeam(int ll) {
		// TODO Auto-generated method stub
		return laborDataDao.isGetTeam(ll);
	}

	public LsLaborInfo isGetCooInfo(int id) {
		// TODO Auto-generated method stub
		return laborDataDao.isGetCooInfo(id);
	}

	public LsLaborCooItem addLaborCooItem(LsLaborCooItem li) {
		// TODO Auto-generated method stub
		return laborDataDao.addLaborCooItem(li);
	}

	public void delLaborCooItem(int li) {
		// TODO Auto-generated method stub
		laborDataDao.delLaborCooItem(li);
	}

	public void upLaborCooItem(LsLaborCooItem li) {
		// TODO Auto-generated method stub
		laborDataDao.upLaborCooItem(li);
	}

}
