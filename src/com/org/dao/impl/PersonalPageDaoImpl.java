package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.PersonalPageDao;
import com.org.entity.PeoPersonalPage;
import com.org.entity.TaxPayer;

public class PersonalPageDaoImpl implements PersonalPageDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public List<PeoPersonalPage> findPersonal(String pids) {
		try {
			return sqlMapClient.queryForList("findPer",pids);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void upPersonal(TaxPayer tp) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upPersonal",tp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<PeoPersonalPage> findPerAll() {
		// TODO Auto-generated method stub
		try {
			return sqlMapClient.queryForList("findPerAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
