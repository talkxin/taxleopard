package com.occasional.dwr;

import java.util.List;

import com.occasional.entity.IsOccasional;
import com.occasional.entity.LuckOccasional;
import com.occasional.entity.LuckOccasionalInfo;
import com.occasional.service.OccasionalDataService;

public class OccasionalDataDwr {

	private OccasionalDataService occasionalDataService;

	public OccasionalDataService getOccasionalDataService() {
		return occasionalDataService;
	}

	public void setOccasionalDataService(OccasionalDataService occasionalDataService) {
		this.occasionalDataService = occasionalDataService;
	}
	/**
	 * 添加偶然所得
	 * @param lo
	 */
	public LuckOccasional addOccasionalDwr(LuckOccasional lo){
		return occasionalDataService.addOccasional(lo);
	}
	/**
	 * 修改偶然所得
	 * @param lo
	 */
    public void upOccasionalDwr(LuckOccasional lo){
    	occasionalDataService.upOccasional(lo);
    }
    /**
	 * 删除偶然所得信息
	 * @param id
	 */
    public void delOccasionalDwr(int id){
    	occasionalDataService.delOccasional(id);
    }
	
	/**
	 * 添加偶然所得信息
	 * @param lf
	 */
	public void addOccasionalInfoDwr(LuckOccasionalInfo lf){
		occasionalDataService.addOccasionalInfo(lf);
	}
	 /**
	 * 修改偶然所得信息
	 * @param lf
	 */
    public void upOccasionalInfoDwr(LuckOccasionalInfo lf){
    	occasionalDataService.upOccasionalInfo(lf);
    }
    /**
	 * 删除偶然所得信息
	 * @param id
	 */
    public void delOccasionalInfoDwr(int id){
    	occasionalDataService.delOccasionalInfo(id);
    }
    /**
	 * 查询用户的偶然所得
	 * @param isOccasional
	 */
    public List<LuckOccasional> isGetOccasionalDwr(int uid){
    	return occasionalDataService.isGetOccasional(uid);
    }
	/**
	 * 根据用户的某个偶然所得名称来查询
	 * @param isOccasional
	 */
    public List<IsOccasional> findByIdDwr(Integer uid,Integer oid){
    	IsOccasional isOccasional=new IsOccasional();
    	isOccasional.setUid(uid);
    	isOccasional.setOid(oid);
    	return occasionalDataService.findByName(isOccasional);
    }
}
