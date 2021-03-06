package com.paychex.service;

import java.util.HashMap;
import java.util.List;

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

public interface PayChexService {
	/**
	 *  初始化用户工资薪金基本信息
	 * @param ppi
	 */
		public void addPayrollInfo(PcPayrollInfo ppi);
		/**
		 * 修改用户工资薪金基本信息
		 * @param ppi
		 */
		public void upPayrollInfo(PcPayrollInfo ppi);
		/**
		 * 删除用户工资薪金基本信息
		 * @param ppi
		 */
		public void delPayrollInfo(PcPayrollInfo ppi);
		/**
		 * 添加工资信息
		 * @param pp
		 */
		public PcPayroll addPayroll(PcPayroll pp);
		/**
		 * 修改工资信息
		 * @param pp
		 */
		public void upPayroll(PcPayroll pp);
		/**
		 * 删除工资信息
		 * @param pp
		 */
		public void delPayroll(PcPayroll pp);
		/**
		 * 添加奖金类型
		 * @param ppt
		 */
		public void addPrizeType(PcPrizeType ppt);
		/**
		 * 修该奖金类型
		 * @param ppt
		 */
		public void upPrizeType(PcPrizeType ppt);
		/**
		 * 删除奖金类型
		 * @param ppt
		 */
		public void delPrizeType(PcPrizeType ppt);
		/**
		 * 添加奖金信息
		 * @param pp
		 */
		public void addPrize(List<IsGetPrize> pp);
		/**
		 * 修改奖金信息
		 * @param pp
		 */
		public void upPrize(PcPrize pp);
		/**
		 * 删除奖金信息
		 * @param pp
		 */
		public void delPrize(PcPrize pp);
		/**
		 * 添加补贴类型
		 * @param pst
		 */
		public void addSubsidyType(PcSubsidyType pst);
		/**
		 * 修改补贴类型
		 * @param pst
		 */
		public void upSubsidyType(PcSubsidyType pst);
		/**
		 * 删除补贴类型
		 * 
		 * @param pst
		 */
		public void delSubsidyType(PcSubsidyType pst);
		/**
		 * 添加补贴信息
		 * @param ps
		 */
		public void addSubsidy(List<IsGetSubsidy> ps);
		/**
		 * 修改补贴信息
		 * @param ps
		 */
		public void upSubsidy(PcSubsidy ps);
		/**
		 * 删除补贴信息
		 * @param ps
		 */
		public void delsubsidy(PcSubsidy ps);
		/**
		 * 添加社保信息
		 * @param pi
		 */
		public void addInsurance(PcInsurance pi);
		/**
		 * 修改社保信息
		 * @param pi
		 */
		public void upInsurance(PcInsurance pi);
		/**
		 * 删除社保信息
		 * @param pi
		 */
		public void delInsurance(PcInsurance pi);
		/**
		 * 添加商业保险信息
		 * @param pc
		 */
		public void addCooinsurance(List<PcCooinsurance> pc);
		/**
		 * 修改商业保险信息
		 * @param pc
		 */
		public void upCooinsurance(PcCooinsurance pc);
		/**
		 * 删除商业信息
		 * @param pc
		 */
		public void delCooinsurance(int uid);
		/**
		 * 添加分红信息
		 * @param pb
		 */
		public void addBonus(List<PcBonus> pb);
		/**
		 * 修改分红信息
		 * @param pb
		 */
		public void upBonus(PcBonus pb);
		/**
		 * 删除分红信息
		 * @param pb
		 */
		public void delBonus(PcBonus pb);
		/**
		 * 添加扣除项
		 * @param pd
		 */
		public void addDeduction(List<PcDeduction> pd);
		/**
		 * 修改扣除项
		 * @param pd
		 */
		public void upDeduction(PcDeduction pd);
		/**
		 * 删除扣除项
		 * @param pd
		 */
		public void delDuction(PcDeduction pd);
		/**
		 * 添加退职费
		 * @param pr
		 */
		public void addRetired(List<PcRetired> pr);
		/**
		 * 修改退职费
		 * @param pr
		 */
		public void upRetired(PcRetired pr);
		/***
		 * 删除退职费
		 * @param pr
		 */
		public void delRetired(PcRetired pr);
		/**
		 * 添加退养费
		 * @param pr
		 */
		public void addRetirement(PcRetirement pr);
		/**
		 * 修改退养费
		 * @param pr
		 */
		public void upretirement(PcRetirement pr);
		/**
		 * 删除退养费
		 * @param pr
		 */
		public void delRetirement(PcRetirement pr);
		/**
		 * 添加行业信息
		 * @param pi
		 */
		public void addIndustry(PcIndustry pi);
		/**
		 * 修改行业信息
		 * @param pi
		 */
		public void upIndustry(PcIndustry pi);
		/**
		 * 删除行业信息
		 * @param pi
		 */
		public void delIndustry(PcIndustry pi);
		/**
		 * 添加新的出入境管理信息
		 * @param pf
		 */
		public void addFrontier(PcFrontier pf);
		/**
		 * 修改出入境管理信息
		 * @param pf
		 */
		public void upFrontier(PcFrontier pf);
		/**
		 * 删除出入境管理信息
		 * @param pf
		 */
		public void delFrotier(PcFrontier pf);
	/**
	 * 工资薪金参照功能
	 * @param uid
	 * @param inTime
	 * @param mm
	 * @param module
	 */
		public int addReference(int uid,String inTime,String[]mm,String[] module);
		
		
		
		
		
		/**
		 * 判断用户初始信息是否存在
		 * @param UID
		 * @return
		 */
		public boolean isGuide(int UID);
		/**
		 * 返回行业
		 * @return
		 */
		public List<PcIndustry> isGetIndustry();
		/**
		 * 返回外国国家
		 * @return
		 */
		public List<OrgNation> isGetNation(int wai);
		/**
		 * 返回奖金列表
		 * @return
		 */
		public List<IsGetPrize> isGetPrize(IsGetPrize ig);
		/**
		 * 返回补贴列表
		 * @return
		 */
		public List<IsGetSubsidy> isGetSubsidy(IsGetSubsidy ig);
		/**
		 * 分红列表
		 * @return
		 */
		public List<PcBonus> isGetBonus(PcBonus ig);
		/**
		 * 社保
		 * @param uid
		 * @return
		 */
		public PcInsurance isGetInsurance(int uid);
		/**
		 * 商业保险
		 */
		public List<PcCooinsurance> isGetCooinsurance(int uid);
		/**
		 * 上月扣除项
		 * @param ig
		 * @return
		 */
		public List<PcDeduction> isGetDeduction(PcDeduction ig);
		/**
		 * 退职费
		 * @param uid
		 * @return
		 */
		public List<PcRetired> isGetRetired(int uid);
		/**
		 * 退养费
		 * @param uid
		 * @return
		 */
		public List<PcRetirement> isGetRetirement(int uid);
		/**
		 * 向导1添加入数据库
		 * @param ppl
		 */
		public void addXiangdao1(PcPayrollInfo ppl);
		/**
		 * 修改向导1
		 * @param ppl
		 */
		public void upXiangdao1(PcPayrollInfo ppl);
		/**
		 * 返回省
		 * @param id
		 * @return
		 */
		public List<OrgProvince> isGetProvince(int id);
		/**
		 * 返回城市
		 * @param id
		 * @return
		 */
		public List<OrgCity> isGetCity(int id);
		/**
		 * 返回用户信息表
		 * @param UID
		 * @return
		 */
		public PcPayrollInfo isGetUserInfo(int UID);
		/**
		 * 以市求省及国家
		 * @param cid
		 * @return
		 */
		public IsCityToProvinceToNation isGetCityToProvinceToNation(int cid);
		/**
		 * 模糊查询奖金类型
		 * @param name
		 * @return
		 */
		public List<PcPrizeType> isGetPrizeType(String name);
		/**
		 * 模糊查询补贴类型
		 * @param name
		 * @return
		 */
		public List<PcSubsidyType> isGetSubsidyType(String name);
		/**
		 * 特殊奖金添加
		 * @param name
		 * @return
		 */
		public PcPrizeType tePrizeType(String name);
		/**
		 * 特殊补贴添加
		 * @param name
		 * @return
		 */
		public PcSubsidyType teSubsidyType(String name);
		public IsGetPayrollInfoAll isGetPayrollInfoAll(int uid);
		public void upPayrollType(PcPayroll pc);
		public void upPayrollTax(PcPayroll pc);
}
