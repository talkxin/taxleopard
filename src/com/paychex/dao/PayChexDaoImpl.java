package com.paychex.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.WebService.ServiceRute;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.paychex.entity.IsGetPrize;
import com.paychex.entity.IsGetSubsidy;
import com.paychex.entity.PcBonus;
import com.paychex.entity.PcCooinsurance;
import com.paychex.entity.PcDeduction;
import com.paychex.entity.PcFrontier;
import com.paychex.entity.PcIndustry;
import com.paychex.entity.PcInsurance;
import com.paychex.entity.PcPayroll;
import com.paychex.entity.PcPayrollInfo;
import com.paychex.entity.PcPrize;
import com.paychex.entity.PcPrizeType;
import com.paychex.entity.PcRetired;
import com.paychex.entity.PcRetirement;
import com.paychex.entity.PcSubsidy;
import com.paychex.entity.PcSubsidyType;

public class PayChexDaoImpl implements PayChexDao  {
	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public void addBonus(List<PcBonus> pb) {
		
		try {
			sqlMapClient.startBatch();
			 for(int i=0,count=pb.size();i<count;i++)   
			 {       
				 sqlMapClient.insert("addBonus", pb.get(i));   
			     if (i % 50 == 0) {   
			    	 sqlMapClient.executeBatch();   
			     }   
			 }   
			 sqlMapClient.executeBatch();
		} catch (SQLException e) { e.printStackTrace(); e.printStackTrace();
			
			
		}   
	}

	public void addCooinsurance(List<PcCooinsurance> pc) {
		
		try{
		sqlMapClient.startBatch();   
		 for(int i=0,count=pc.size();i<count;i++)   
		 {       
			 sqlMapClient.insert("addCooinsurance", pc.get(i));   
		     if (i % 50 == 0) {   
		    	 sqlMapClient.executeBatch();   
		     }   
		 }   
		 sqlMapClient.executeBatch();
		}catch(SQLException e){
			
		}
	}

	public void addDeduction(List<PcDeduction> pd) {
		
		try{
			sqlMapClient.startBatch();   
			 for(int i=0,count=pd.size();i<count;i++)   
			 {       
				 sqlMapClient.insert("addDeduction", pd.get(i));   
			     if (i % 50 == 0) {   
			    	 sqlMapClient.executeBatch();   
			     }   
			 }   
			 sqlMapClient.executeBatch();
			}catch(SQLException e){
				
			}
	}

	public void addFrontier(PcFrontier pf) {
		
		try {
			sqlMapClient.insert("addFrontier",pf);
		} catch (SQLException e) { e.printStackTrace();
			
			e.printStackTrace();
		}
	}

	public void addIndustry(PcIndustry pi) {
		
		try {
			sqlMapClient.insert("addIndustry",pi);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void addInsurance(PcInsurance pi) {
		
		try {
			if(pi.getPensionP()!=null)
			sqlMapClient.insert("addInsurance",pi);
			else if(pi.getUid()!=null)
				sqlMapClient.insert("addInsurance1",pi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PcPayroll addPayroll(PcPayroll pp) {
		
		HashMap map=new HashMap();
		map.put("uid", pp.getUid());
		map.put("inTime", pp.getInPayDay());
		try {
			return (PcPayroll) sqlMapClient.queryForObject("inPayroll",map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addPayrollInfo(PcPayrollInfo ppi) {
		
		try {
			sqlMapClient.insert("addPayrollInfo",ppi);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void addPrize(List<IsGetPrize> pp) {
		
		try {
			sqlMapClient.startBatch();   
			 for(int i=0,count=pp.size();i<count;i++)   
			 {       
				 sqlMapClient.insert("addPrize",pp.get(i));  
			     if (i % 50 == 0) {   
			    	 sqlMapClient.executeBatch();   
			     }   
			 }   
			 sqlMapClient.executeBatch();
			
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void addPrizeType(PcPrizeType ppt) {
		
		try {
			sqlMapClient.insert("addPrizeType",ppt);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public int addReference(int uid,String inTime,String[] mm, String[] module) {
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("UID", uid);
		map.put("inTime", inTime);
		map.put("hs",null);
		for (int i = 0; i < mm.length; i++) {
			String ouTime=mm[i];
			map.put("outTime", ouTime);
			for (int j = 0; j < module.length; j++) {
				try {
					sqlMapClient.insert(module[j],map);
					if(map.get("hs")!=null){
						return 1;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 0;
				}
			}
		}
		return 0;
	}

	public void addRetired(List<PcRetired> pr) {
		try {
			sqlMapClient.startBatch();
			 for(int i=0,count=pr.size();i<count;i++)   
			 {       
					sqlMapClient.insert("addRetired",pr.get(i)); 
			     if (i % 50 == 0) {   
			    	 sqlMapClient.executeBatch();   
			     }   
			 }   
			 sqlMapClient.executeBatch();
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void addRetirement(PcRetirement pr)  {
		
		try {
			sqlMapClient.insert("addRetirement",pr);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void addSubsidy(List<IsGetSubsidy> ps) {
		
		try {
			sqlMapClient.startBatch();
			 for(int i=0,count=ps.size();i<count;i++)   
			 {       
				 sqlMapClient.insert("addSubsidy", ps.get(i));   
			     if (i % 50 == 0) {   
			    	 sqlMapClient.executeBatch();   
			     }   
			 }   
			 sqlMapClient.executeBatch();
		} catch (SQLException e) { e.printStackTrace();
			
			
		}   
	}

	public void addSubsidyType(PcSubsidyType pst) {
		
		try {
			sqlMapClient.insert("addSubsidyType",pst);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void delBonus(PcBonus pb) {
		try {
			sqlMapClient.delete("delBonus",pb);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void delCooinsurance(int uid) {
		try {
			sqlMapClient.delete("delCooinsurance",uid);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void delDuction(PcDeduction pd) {
		
		try {
			sqlMapClient.delete("delDuction",pd);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void delFrotier(PcFrontier pf) {
		try {
			sqlMapClient.delete("delFrotier",pf);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void delIndustry(PcIndustry pi) {
		try {
			sqlMapClient.delete("delIndustry",pi);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void delInsurance(PcInsurance pi) {
		
		try {
			sqlMapClient.delete("delInsurance",pi);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void delPayroll(PcPayroll pp) {
		
		try {
			sqlMapClient.delete("delPayroll",pp);
		} catch (SQLException e) { e.printStackTrace();
		}
	}

	public void delPayrollInfo(PcPayrollInfo ppi) {
		try {
			sqlMapClient.delete("delPayrollInfo",ppi);
		} catch (SQLException e) { e.printStackTrace();
		}

	}

	public void delPrize(PcPrize pp) {
		
		try {
			sqlMapClient.delete("delPrize",pp);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void delPrizeType(PcPrizeType ppt) {
		try {
			sqlMapClient.delete("delPrizeType",ppt);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void delRetired(PcRetired pr) {
		try {
			sqlMapClient.delete("delRetired",pr);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void delRetirement(PcRetirement pr) {
		
		try {
			sqlMapClient.delete("delRetirement",pr);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void delSubsidyType(PcSubsidyType pst) {
		try {
			sqlMapClient.delete("delSubsidyType",pst);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void delsubsidy(PcSubsidy ps) {
		try {
			sqlMapClient.delete("delsubsidy",ps);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void upBonus(PcBonus pb) {
		try {
			sqlMapClient.update("upBonus",pb);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void upCooinsurance(PcCooinsurance pc) {
		
		try {
			sqlMapClient.update("upCooinsurance",pc);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void upDeduction(PcDeduction pd) {
		try {
			sqlMapClient.update("upDeduction",pd);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void upFrontier(PcFrontier pf) {
		try {
			sqlMapClient.update("upFrontier",pf);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void upIndustry(PcIndustry pi) {
		
		try {
			sqlMapClient.update("upIndustry",pi);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void upInsurance(PcInsurance pi) {
		try {
			sqlMapClient.update("upInsurance",pi);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void upPayroll(PcPayroll pp) {
		try {
			sqlMapClient.update("upPayroll",pp);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void upPayrollInfo(PcPayrollInfo ppi) {
		
		try {
			sqlMapClient.update("upPayrollInfo",ppi);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void upPrize(PcPrize pp) {
		try {
			sqlMapClient.update("upPrize",pp);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void upPrizeType(PcPrizeType ppt) {
		try {
			sqlMapClient.update("upPrizeType",ppt);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void upRetired(PcRetired pr) {
		try {
			sqlMapClient.update("upRetired",pr);
		} catch (SQLException e) { e.printStackTrace();
			

		}

	}

	public void upSubsidy(PcSubsidy ps) {
		
		try {
			sqlMapClient.update("upSubsidy",ps);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void upSubsidyType(PcSubsidyType pst) {
		
		try {
			sqlMapClient.update("upSubsidyType",pst);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}

	public void upretirement(PcRetirement pr) {
		
		try {
			sqlMapClient.update("upretirement",pr);
		} catch (SQLException e) { e.printStackTrace();
			

		}
	}
	/**
	 * 向导1添加入数据库
	 * @param ppl
	 */
	public void addXiangdao1(PcPayrollInfo ppl){
		try {
			sqlMapClient.insert("xiangdao",ppl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 修改向导1
	 * @param ppl
	 */
	public void upXiangdao1(PcPayrollInfo ppl){
		try {
			sqlMapClient.update("upxiangdao",ppl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PcPrizeType tePrizeType(String name) {
		try {
			return (PcPrizeType) sqlMapClient.queryForObject("tePrizeType",name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public PcSubsidyType teSubsidyType(String name) {
		try {
			return (PcSubsidyType) sqlMapClient.queryForObject("teSubsidyType",name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void upPayrollType(PcPayroll pc) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upPayrollType",pc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upPayrollTax(PcPayroll pc) {
		try {
			sqlMapClient.update("upPayrollTax",pc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
