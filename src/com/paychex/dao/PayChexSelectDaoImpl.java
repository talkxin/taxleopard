package com.paychex.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.entity.OrgCity;
import com.org.entity.OrgNation;
import com.org.entity.OrgProvince;
import com.paychex.entity.IsCityToProvinceToNation;
import com.paychex.entity.IsGetPayrollInfoAll;
import com.paychex.entity.IsGetPrize;
import com.paychex.entity.IsGetSubsidy;
import com.paychex.entity.PcBonus;
import com.paychex.entity.PcCooinsurance;
import com.paychex.entity.PcDeduction;
import com.paychex.entity.PcIndustry;
import com.paychex.entity.PcInsurance;
import com.paychex.entity.PcPayrollInfo;
import com.paychex.entity.PcPrizeType;
import com.paychex.entity.PcRetired;
import com.paychex.entity.PcRetirement;
import com.paychex.entity.PcSubsidyType;

public class PayChexSelectDaoImpl implements PayChexSelectDao {
	private SqlMapClient sqlMapClient;
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public List<PcBonus> isGetBonus(PcBonus ig) {
		try {
			return sqlMapClient.queryForList("getListBonus",ig);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public List<PcCooinsurance> isGetCooinsurance(int uid) {
		try {
			return sqlMapClient.queryForList("isGetCooinsurance",uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<PcDeduction> isGetDeduction(PcDeduction ig) {
		try {
			return sqlMapClient.queryForList("isGetDeduction",ig);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<PcIndustry> isGetIndustry() {
		try {
			return sqlMapClient.queryForList("isGetIndustry");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public PcInsurance isGetInsurance(int uid) {
		try {
			return (PcInsurance) sqlMapClient.queryForObject("isGetInsurance",uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<OrgNation> isGetNation(int wai) {
		if(wai==1){
			try {
				return sqlMapClient.queryForList("getWaiListNation");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
		try {
			return sqlMapClient.queryForList("getListNation");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return null;
	}

	public List<IsGetPrize> isGetPrize(IsGetPrize ig) {
		try {
			return sqlMapClient.queryForList("getListPrize",ig);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<PcRetired> isGetRetired(int uid) {
		try {
			return sqlMapClient.queryForList("isGetRetired",uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<PcRetirement> isGetRetirement(int uid) {
		try {
			return sqlMapClient.queryForList("isGetRetirement",uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<IsGetSubsidy> isGetSubsidy(IsGetSubsidy ig) {
		try {
			return sqlMapClient.queryForList("getListSubsidy",ig);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean isGuide(int UID) {
		try {
			if(sqlMapClient.queryForObject("getPayrollInfo",UID)!=null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<OrgCity> isGetCity(int id) {
		
		try {
			return sqlMapClient.queryForList("getListCity",id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<OrgProvince> isGetProvince(int id) {
		try {
			return sqlMapClient.queryForList("getListProvince",id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public PcPayrollInfo isGetUserInfo(int UID) {
		// TODO Auto-generated method stub
		try {
			return (PcPayrollInfo) sqlMapClient.queryForObject("getPayrollInfo",UID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}

	public IsCityToProvinceToNation isGetCityToProvinceToNation(int cid) {
		// TODO Auto-generated method stub
		try {
			return (IsCityToProvinceToNation) sqlMapClient.queryForObject("isCityToProvinceToNation",cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<PcPrizeType> isGetPrizeType(String name) {
		try {
			return sqlMapClient.queryForList("isGetPrizeType",name+"%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<PcSubsidyType> isGetSubsidyType(String name) {
		try {
			return sqlMapClient.queryForList("isGetSubsidyType",name+"%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<IsGetPrize> isGetPrizeToJsp(IsGetPrize ig) {
		try {
			return sqlMapClient.queryForList("isGetPrizeToJsp",ig);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public IsGetPayrollInfoAll isGetPayrollInfoAll(int uid) {
		try {
			return (IsGetPayrollInfoAll) sqlMapClient.queryForObject("isGetPayrollInfoAll",uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
