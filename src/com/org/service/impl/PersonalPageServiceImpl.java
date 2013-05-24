package com.org.service.impl;

import java.util.List;

import com.org.dao.PersonalPageDao;
import com.org.entity.PeoPersonalPage;
import com.org.entity.TaxPayer;
import com.org.service.PersonalPageService;

public class PersonalPageServiceImpl implements PersonalPageService{

	private PersonalPageDao personalPageDao;
	
	public PersonalPageDao getPersonalPageDao() {
		return personalPageDao;
	}

	public void setPersonalPageDao(PersonalPageDao personalPageDao) {
		this.personalPageDao = personalPageDao;
	}

	
	public List<PeoPersonalPage> findPersonal(String pids) {
		return personalPageDao.findPersonal(pids);
	}

	public void upPersonal(TaxPayer tp) {
		// TODO Auto-generated method stub
		personalPageDao.upPersonal(tp);
	}

	public List<PeoPersonalPage> findPerAll() {
		// TODO Auto-generated method stub
		return personalPageDao.findPerAll();
	}

	
}
