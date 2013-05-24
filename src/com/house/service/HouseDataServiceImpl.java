package com.house.service;

import java.util.List;

import com.house.dao.HouseDataDao;
import com.house.entity.HpHouseInfo;
import com.house.entity.HpRentalHouseInfo;
import com.house.entity.HpRentalInfo;
import com.house.entity.HpTransfer;

public class HouseDataServiceImpl implements HouseDataService {
	private HouseDataDao houseDataDao;

	public HouseDataDao getHouseDataDao() {
		return houseDataDao;
	}

	public void setHouseDataDao(HouseDataDao houseDataDao) {
		this.houseDataDao = houseDataDao;
	}

	public HpHouseInfo addHouse(HpHouseInfo hi) {
		// TODO Auto-generated method stub
		return houseDataDao.addHouse(hi);
	}

	public void addRentInfo(HpRentalHouseInfo hi) {
		// TODO Auto-generated method stub
		houseDataDao.addRentInfo(hi);
	}

	public HpRentalInfo addRentPop(HpRentalInfo hi) {
		// TODO Auto-generated method stub
		return houseDataDao.addRentPop(hi);
	}

	public void addSellHouse(HpTransfer hi) {
		// TODO Auto-generated method stub
		houseDataDao.addSellHouse(hi);
	}

	public void delHouse(HpHouseInfo hi) {
		// TODO Auto-generated method stub
		houseDataDao.delHouse(hi);
	}

	public void delRentInfo(int hi) {
		// TODO Auto-generated method stub
		houseDataDao.delRentInfo(hi);
	}

	public void delRentPop(int hi) {
		// TODO Auto-generated method stub
		houseDataDao.delRentPop(hi);
	}

	public void delSellHouse(int hi) {
		// TODO Auto-generated method stub
		houseDataDao.delSellHouse(hi);
	}

	public void upHouse(HpHouseInfo hi) {
		// TODO Auto-generated method stub
		houseDataDao.upHouse(hi);
	}

	public void upRentInfo(HpRentalHouseInfo hi) {
		// TODO Auto-generated method stub
		houseDataDao.upRentInfo(hi);
	}

	public void upRentPop(HpRentalInfo hi) {
		// TODO Auto-generated method stub
		houseDataDao.upRentPop(hi);
	}

	public void upSellHouse(HpTransfer hi) {
		// TODO Auto-generated method stub
		houseDataDao.upSellHouse(hi);
	}

	public void upHouseState(HpHouseInfo hi) {
		// TODO Auto-generated method stub
		houseDataDao.upHouseState(hi);
	}

	public List<HpHouseInfo> isGetHouse(int uid) {
		// TODO Auto-generated method stub
		return houseDataDao.isGetHouse(uid);
	}

	public List<HpRentalInfo> isGetRentalInfo(int uid) {
		// TODO Auto-generated method stub
		return houseDataDao.isGetRentalInfo(uid);
	}

	public void upAllRant(HpRentalHouseInfo hi) {
		// TODO Auto-generated method stub
		houseDataDao.upAllRant(hi);
	}

	public HpTransfer isGetHouseSellAll(int hid) {
		// TODO Auto-generated method stub
		return houseDataDao.isGetHouseSellAll(hid);
	}

	public List<HpRentalInfo> isGetUserAllRentalInfo(int uid) {
		// TODO Auto-generated method stub
		return houseDataDao.isGetUserAllRentalInfo(uid);
	}
}
