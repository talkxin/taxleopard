package com.org.dwr;

import java.util.List;

import com.org.entity.PeoPersonalPage;
import com.org.entity.TaxPayer;
import com.org.service.PersonalPageService;

public class PersonalPageDwr {

	private PersonalPageService personalPageService;

	public PersonalPageService getPersonalPageService() {
		return personalPageService;
	}

	public void setPersonalPageService(PersonalPageService personalPageService) {
		this.personalPageService = personalPageService;
	}
	/**
	 * 查询应用
	 * @param tp
	 * @return
	 */
	public List<PeoPersonalPage> isGetUserPersonal(String tp){
		return personalPageService.findPersonal(tp);
	}
	/**
	 * 修改个人用户
	 * @param tp
	 */
	public void upPersonal(int id,String pid){
		TaxPayer tp=new TaxPayer();
		tp.setTaxID(id);
		tp.setPid(pid);
		personalPageService.upPersonal(tp);
	}
	/**
	 * 查询所有应用图标
	 * @return
	 */
	public List<PeoPersonalPage> isGetAllApp(){
		return personalPageService.findPerAll();
	}
}
