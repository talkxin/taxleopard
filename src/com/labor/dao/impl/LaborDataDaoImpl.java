package com.labor.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.labor.dao.LaborDataDao;
import com.labor.entity.LsLaborCooItem;
import com.labor.entity.LsLaborInfo;
import com.labor.entity.LsLaborMonth;
import com.labor.entity.LsLaborService;
@SuppressWarnings("unchecked")
public class LaborDataDaoImpl implements LaborDataDao {
	private SqlMapClient sqlMapClient;
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public LsLaborInfo addLaborInfo(LsLaborInfo li) {
		// TODO Auto-generated method stub
		try {
			return (LsLaborInfo) sqlMapClient.queryForObject("addLaborInfo",li);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addLaborService(List<LsLaborService> li) {
		// TODO Auto-generated method stub
		try{
//            // 开始批处理  
			sqlMapClient.startBatch();  
		for (LsLaborService ls:li) {
			sqlMapClient.insert("addLaborService", ls);   
		}
        // 执行批处理  
		sqlMapClient.executeBatch();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void delLaboService(int li) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delLaboService",li);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delLaborInfo(int li) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delLaborInfo",li);
			sqlMapClient.delete("delLaborCooItem2",li);
			sqlMapClient.delete("delLaboService2",li);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upLaborInfo(LsLaborInfo li) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upLaborInfo",li);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upLaborService(LsLaborMonth li) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upLaborService",li);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addLaborTax(LsLaborService li) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.insert("addLaborTax",li);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<LsLaborInfo> isGetUserCoo(int UID) {
		try {
			return sqlMapClient.queryForList("isGetUserCoo",UID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<LsLaborCooItem> isGetTeam(int ll) {
		try {
			return sqlMapClient.queryForList("isGetTeam",ll);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public LsLaborInfo isGetCooInfo(int id) {
		try {
			return (LsLaborInfo) sqlMapClient.queryForObject("isGetCooInfo",id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public LsLaborCooItem addLaborCooItem(LsLaborCooItem li) {
		// TODO Auto-generated method stub
		try {
			return (LsLaborCooItem) sqlMapClient.queryForObject("addLaborCooItem",li);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void delLaborCooItem(int li) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delLaborCooItem",li);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upLaborCooItem(LsLaborCooItem li) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upLaborCooItem",li);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
