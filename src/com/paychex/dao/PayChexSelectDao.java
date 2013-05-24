package com.paychex.dao;

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
import com.paychex.entity.PcIndustry;
import com.paychex.entity.PcInsurance;
import com.paychex.entity.PcPayrollInfo;
import com.paychex.entity.PcPrizeType;
import com.paychex.entity.PcRetired;
import com.paychex.entity.PcRetirement;
import com.paychex.entity.PcSubsidyType;

public interface PayChexSelectDao {
	/**
	 * 判断用户初始信息是否存在
	 * @param UID
	 * @return
	 */
	public boolean isGuide(int UID);
	/**
	 * 返回用户信息表
	 * @param UID
	 * @return
	 */
	public PcPayrollInfo isGetUserInfo(int UID);
	/**
	 * 返回行业
	 * @return
	 */
	public List<PcIndustry> isGetIndustry();
	/**
	 * 返回国家
	 * @return
	 */
	public List<OrgNation> isGetNation(int wai);
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
	/***
	 * 返回当月奖金
	 * @return
	 */
	public List<IsGetPrize> isGetPrizeToJsp(IsGetPrize ig);
	/**
	 * 获取个人信息全
	 * @param uid
	 * @return
	 */
	public IsGetPayrollInfoAll isGetPayrollInfoAll(int uid);
}
