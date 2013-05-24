package com.org.service;

import java.util.List;

import com.org.entity.PeoPersonalPage;
import com.org.entity.TaxPayer;

public interface PersonalPageService {

	public List<PeoPersonalPage> findPersonal(String pids);
	/***
	 * 修改个人模块
	 * @param tp
	 */
	public void upPersonal(TaxPayer tp);
	/**
	 * 查询所有
	 * @return
	 */
	public List<PeoPersonalPage> findPerAll();
}
