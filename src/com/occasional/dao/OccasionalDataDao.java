package com.occasional.dao;

import java.util.List;

import com.occasional.entity.IsOccasional;
import com.occasional.entity.LuckOccasional;
import com.occasional.entity.LuckOccasionalInfo;

public interface OccasionalDataDao {
	/**
	 * 添加偶然所得
	 * @param lo
	 */
    public LuckOccasional addOccasional(LuckOccasional lo);
    /**
	 * 修改偶然所得
	 * @param lo
	 */
    public void upOccasional(LuckOccasional lo);
    /**
	 * 删除偶然所得
	 * @param id
	 */
    public void delOccasional(int id);
	/**
	 * 添加偶然所得信息
	 * @param lo
	 */
    public void addOccasionalInfo(LuckOccasionalInfo lf);
    /**
	 * 修改偶然所得信息
	 * @param lo
	 */
    public void upOccasionalInfo(LuckOccasionalInfo lf);
    /**
	 * 删除偶然所得信息
	 * @param id
	 */
    public void delOccasionalInfo(int id);
    /**
	 * 查询用户的偶然所得
	 * @param isOccasional
	 */
    public List<LuckOccasional> isGetOccasional(int uid);
	/**
	 * 根据用户的某个偶然所得名称来查询
	 * @param isOccasional
	 */
    public List<IsOccasional> findByName(IsOccasional isOccasional);
    
    
}
