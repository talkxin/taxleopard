package com.otherincome.service;

import com.otherincome.entity.OiOtherincome;

public interface OtherincomeService {
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
