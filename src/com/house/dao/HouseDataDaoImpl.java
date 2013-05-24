package com.house.dao;

import java.sql.SQLException;
import java.util.List;

import com.house.entity.HpHouseInfo;
import com.house.entity.HpRentalHouseInfo;
import com.house.entity.HpRentalInfo;
import com.house.entity.HpTransfer;
import com.ibatis.sqlmap.client.SqlMapClient;



public class HouseDataDaoImpl implements HouseDataDao{
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public HpHouseInfo addHouse(HpHouseInfo hi) {
		// TODO Auto-generated method stub
		try {
			return (HpHouseInfo) sqlMapClient.queryForObject("addHouse",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addRentInfo(HpRentalHouseInfo hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.queryForObject("addRentInfo",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HpRentalInfo addRentPop(HpRentalInfo hi) {
		// TODO Auto-generated method stub
		try {
			return (HpRentalInfo) sqlMapClient.queryForObject("addRentPop",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addSellHouse(HpTransfer hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.queryForObject("addSellHouse",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delHouse(HpHouseInfo hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delHouse",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delRentInfo(int hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delRentInfo",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delRentPop(int hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delRentPop",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delSellHouse(int hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delSellHouse",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upHouse(HpHouseInfo hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upHouse",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upRentInfo(HpRentalHouseInfo hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upRentInfo",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upRentPop(HpRentalInfo hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upRentPop",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upSellHouse(HpTransfer hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upSellHouse",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<HpHouseInfo> isGetHouse(int uid) {
		// TODO Auto-generated method stub
		try {
			return sqlMapClient.queryForList("isGetHouse",uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<HpRentalInfo> isGetRentalInfo(int uid) {
		// TODO Auto-generated method stub
		try {
			return sqlMapClient.queryForList("isGetRentalInfo",uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void upHouseState(HpHouseInfo hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upHouseState",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upAllRant(HpRentalHouseInfo hi) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upAllRant",hi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HpTransfer isGetHouseSellAll(int hid){
		try {
			return (HpTransfer) sqlMapClient.queryForObject("isGetHouseSellAll",hid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<HpRentalInfo> isGetUserAllRentalInfo(int uid){
		try {
			return sqlMapClient.queryForList("isGetUserAllRentalInfo",uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
