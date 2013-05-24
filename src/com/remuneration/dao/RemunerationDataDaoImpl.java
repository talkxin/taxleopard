package com.remuneration.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.remuneration.entity.RePressType;
import com.remuneration.entity.RePublish;
import com.remuneration.entity.ReRemunerationInfo;

public class RemunerationDataDaoImpl implements RemunerationDataDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public ReRemunerationInfo addRemunerationInfo(ReRemunerationInfo re) {
		// TODO Auto-generated method stub
		try {
			return (ReRemunerationInfo) sqlMapClient.queryForObject("addRemunerationInfo",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void upRemunerationInfo(ReRemunerationInfo re) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upRemunerationInfo",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delRemunerationInfo(int re) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delRemunerationInfo",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RePressType addRePressType(RePressType re) {
		// TODO Auto-generated method stub
		try {
			return (RePressType) sqlMapClient.queryForObject("addRePressType",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void upRePressType(RePressType re) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upRePressType",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delRePressType(int re) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delRePressType",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addRePublish(RePublish re) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.insert("addRePublish",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upRePublish(RePublish re) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upRePublish",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delRePublish(int re) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delRePublish",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ReRemunerationInfo> isGetReRemunerationInfo(int re) {
		// TODO Auto-generated method stub
		try {
			return sqlMapClient.queryForList("isGetReRemunerationInfo",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<RePressType> isGetRePressType(int re) {
		// TODO Auto-generated method stub
		try {
			return sqlMapClient.queryForList("isGetRePressType",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<RePressType> isGetAllRePressType(int re) {
		// TODO Auto-generated method stub
		try {
			return sqlMapClient.queryForList("isGetAllRePressType",re);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
