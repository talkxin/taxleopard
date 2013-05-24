package com.otherincome.dwr;

import com.otherincome.entity.OiOtherincome;
import com.otherincome.service.OtherincomeService;

public class OtherincomeDwr {
	private OtherincomeService otherincomeService;

	public OtherincomeService getOtherincomeService() {
		return otherincomeService;
	}

	public void setOtherincomeService(OtherincomeService otherincomeService) {
		this.otherincomeService = otherincomeService;
	}

	/**
	 * 增加其他所得
	 * 
	 * @param oo
	 */
	public void addOtherincome(OiOtherincome oo) {
		otherincomeService.addOtherincome(oo);
	}

	/**
	 * 修改其他所得
	 * 
	 * @param oo
	 */
	public void upOtherincome(OiOtherincome oo) {
		otherincomeService.upOtherincome(oo);
	}

	/**
	 * 删除其他所得
	 * 
	 * @param oo
	 */
	public void delOtherincome(int oo) {
		otherincomeService.delOtherincome(oo);
	}
}
