package com.paychex.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.paychex.dao.WageDao;
import com.paychex.entity.WageMonth;
@SuppressWarnings("unchecked")
public class WageDaoImpl<T> implements WageDao<T>{
	private SqlMapClient sqlMapClient;
    public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	/**
	 * 查询某个用户某月所有奖金(补贴，分红)及
	 * 12个月各月的奖金和（补贴和，分红和）
	 * @throws SQLException
	 * */
	public List<T> find(T t) {
		String findX="find"+t.getClass().getSimpleName();
		try {
			return this.getSqlMapClient().queryForList(findX,t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public T findSingle(T t){
		String findX="find"+t.getClass().getSimpleName();
		try {
			return (T)sqlMapClient.queryForObject(findX, t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String findMap(Integer uid,String year,String zsybx){
		HashMap map=new HashMap();
		map.put("uid",uid);
		map.put("year",year);
		map.put("zsybx",0);
		try {
			sqlMapClient.queryForObject("findCoo",map);
			return map.get("zsybx").toString();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String findMonthMap(Integer uid,String month,String sybx){
		HashMap map=new HashMap();
		map.put("uid",uid);
		map.put("month",month);
		map.put("sybx",0);
		try {
			sqlMapClient.queryForObject("findCooMonth",map);
			return map.get("sybx").toString();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
    
}
