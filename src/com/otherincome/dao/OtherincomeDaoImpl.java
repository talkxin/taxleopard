package com.otherincome.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.otherincome.entity.OiOtherincome;

public class OtherincomeDaoImpl implements OtherincomeDao{
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public void addOtherincome(OiOtherincome oo) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.insert("addOtherincome",oo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upOtherincome(OiOtherincome oo) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upOtherincome",oo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delOtherincome(int oo) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delOtherincome",oo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
