package com.shares.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.shares.entity.ShSharesIn;
import com.shares.entity.ShSharesInfo;
import com.shares.entity.ShSharesOut;
import com.shares.entity.ShSharesPrice;

public class SharesDataImpl implements SharesData {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public void addSharesIn(ShSharesIn sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.insert("addSharesIn",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ShSharesInfo addSharesInfo(ShSharesInfo sh) {
		// TODO Auto-generated method stub
		try {
			return (ShSharesInfo) sqlMapClient.queryForObject("addSharesInfo",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addSharesOut(ShSharesOut sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.insert("addSharesOut",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addSharesPrice(ShSharesPrice sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.insert("addSharesPrice",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delSharesIn(int sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delSharesIn",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delSharesInfo(int sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delSharesInfo",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delSharesOut(int sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delSharesOut",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delSharesPrice(int sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delSharesPrice",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upEarlyWarning(ShSharesInfo sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upEarlyWarning",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upEquity(ShSharesInfo sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upEquity",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upShares(ShSharesInfo sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upShares",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upSharesIn(ShSharesIn sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upSharesIn",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upSharesOut(ShSharesOut sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upSharesOut",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upSharesPrice(ShSharesPrice sh) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upSharesPrice",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ShSharesInfo> isGetShares(int sh){
		try {
			return sqlMapClient.queryForList("isGetShares",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<ShSharesIn> isGetGupiaolishi(int sh) {
		// TODO Auto-generated method stub
		try {
			return sqlMapClient.queryForList("isGetGupiaolishi",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<ShSharesOut> isGetZhuanrang(int sh) {
		// TODO Auto-generated method stub
		try {
			return sqlMapClient.queryForList("isGetZhuanrang",sh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
