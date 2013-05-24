package com.otherincome.dao;

import com.otherincome.entity.OiOtherincome;

public interface OtherincomeDao {
	/**
	 * 增加其他所得
	 * 
	 * @param oo
	 */
	public void addOtherincome(OiOtherincome oo);

	/**
	 * 修改其他所得
	 * 
	 * @param oo
	 */
	public void upOtherincome(OiOtherincome oo);

	/**
	 * 删除其他所得
	 * 
	 * @param oo
	 */
	public void delOtherincome(int oo);
}
