package com.occasional.service;

import java.util.List;

import com.occasional.dao.OccasionalDataDao;
import com.occasional.entity.IsOccasional;
import com.occasional.entity.LuckOccasional;
import com.occasional.entity.LuckOccasionalInfo;

public class OccasionalDataServiceImpl implements OccasionalDataService{
    private OccasionalDataDao occasionalDataDao;
	
	public OccasionalDataDao getOccasionalDataDao() {
		return occasionalDataDao;
	}

	public void setOccasionalDataDao(OccasionalDataDao occasionalDataDao) {
		this.occasionalDataDao = occasionalDataDao;
	}

	public LuckOccasional addOccasional(LuckOccasional lo) {
		return occasionalDataDao.addOccasional(lo);
	}
	public void delOccasional(int id) {
		occasionalDataDao.delOccasional(id);
	}

	public void upOccasional(LuckOccasional lo) {
	    occasionalDataDao.upOccasional(lo);
	}
	
	public void addOccasionalInfo(LuckOccasionalInfo lf) {
		occasionalDataDao.addOccasionalInfo(lf);
		
	}

	public void delOccasionalInfo(int id) {
		occasionalDataDao.delOccasionalInfo(id);
	}

	public void upOccasionalInfo(LuckOccasionalInfo lf) {
		occasionalDataDao.upOccasionalInfo(lf);
	}
	public List<LuckOccasional> isGetOccasional(int uid) {
        return occasionalDataDao.isGetOccasional(uid);
	}
	public List<IsOccasional> findByName(IsOccasional isOccasional) {
		return occasionalDataDao.findByName(isOccasional);
	}
}
