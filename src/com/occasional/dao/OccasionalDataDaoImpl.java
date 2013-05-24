package com.occasional.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.occasional.entity.IsOccasional;
import com.occasional.entity.LuckOccasional;
import com.occasional.entity.LuckOccasionalInfo;

public class OccasionalDataDaoImpl implements OccasionalDataDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	public LuckOccasional addOccasional(LuckOccasional lo) {
		try {
			return (LuckOccasional) sqlMapClient.queryForObject("addOccasional",lo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

    public void upOccasional(LuckOccasional lo) {
    	try {
			sqlMapClient.update("upOccasional",lo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	public void delOccasional(int id) {
		try {
			sqlMapClient.delete("delOccasional",id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addOccasionalInfo(LuckOccasionalInfo lf) {
		try {
			sqlMapClient.insert("addOccasionalInfo",lf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void upOccasionalInfo(LuckOccasionalInfo lf) {
		try {
			sqlMapClient.update("upOccasionalInfo",lf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delOccasionalInfo(int id) {
		try {
			sqlMapClient.delete("delOccasionalInfo",id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<LuckOccasional> isGetOccasional(int uid) {
		try {
			return sqlMapClient.queryForList("isGetOccasional",uid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IsOccasional> findByName(IsOccasional isOccasional) {
		try {
			return sqlMapClient.queryForList("findOccaById", isOccasional);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
