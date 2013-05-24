package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.NationalityDao;
import com.org.entity.Nationality;

public class NationalityDaoImpl implements NationalityDao{

	private SqlMapClient sqlMapClient;
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	public void deleteNationality(int nationalityID) throws SQLException {
		sqlMapClient.delete("deleteNationality", nationalityID);
	}

	public void insertNationality(Nationality nationality) throws SQLException {
		sqlMapClient.insert("insertNationality",nationality);
	}

	@SuppressWarnings("unchecked")
	public List<Nationality> selectAllNationality() throws SQLException {
		return sqlMapClient.queryForList("selectAllNationality");
	}

	public Nationality selectNationalityByID(int nationalityID) throws SQLException {
		return (Nationality) sqlMapClient.queryForObject("selectNationalityByID",nationalityID);
	}

	public void updateNationality(Nationality nationality) throws SQLException {
		sqlMapClient.update("updateNationality", nationality);
	}

}
