package com.org.dao;
import java.util.List;

import com.org.entity.PeoPersonalPage;
import com.org.entity.TaxPayer;

public interface PersonalPageDao {

	/**
	 * 根据多个pid查询个人首页多个应用的信息
	 * 
	 * 
	 * */
	public  List<PeoPersonalPage> findPersonal(String pids);
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
