package com.paychex.service;

import java.util.HashMap;
import java.util.List;

import com.org.entity.OrgCity;
import com.org.entity.OrgNation;
import com.org.entity.OrgProvince;
import com.paychex.dao.PayChexDao;
import com.paychex.dao.PayChexSelectDao;
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

public class PayChexServiceImpl implements PayChexService {
	private PayChexDao payChexDao;
	private PayChexSelectDao payChexSelectDao;
	public PayChexSelectDao getPayChexSelectDao() {
		return payChexSelectDao;
	}

	public void setPayChexSelectDao(PayChexSelectDao payChexSelectDao) {
		this.payChexSelectDao = payChexSelectDao;
	}

	public PayChexDao getPayChexDao() {
		return payChexDao;
	}

	public void setPayChexDao(PayChexDao payChexDao) {
		this.payChexDao = payChexDao;
	}

	public void addBonus(List<PcBonus> pb) {
		// TODO Auto-generated method stub
		payChexDao.addBonus(pb);
	}

	public void addCooinsurance(List<PcCooinsurance> pc) {
		// TODO Auto-generated method stub
		payChexDao.addCooinsurance(pc);
	}

	public void addDeduction(List<PcDeduction> pd) {
		// TODO Auto-generated method stub
		payChexDao.addDeduction(pd);
	}

	public void addFrontier(PcFrontier pf) {
		// TODO Auto-generated method stub
		payChexDao.addFrontier(pf);
	}

	public void addIndustry(PcIndustry pi) {
		// TODO Auto-generated method stub
		payChexDao.addIndustry(pi);
	}

	public void addInsurance(PcInsurance pi) {
		// TODO Auto-generated method stub
		payChexDao.addInsurance(pi);
	}

	public PcPayroll addPayroll(PcPayroll pp) {
		// TODO Auto-generated method stub
		return payChexDao.addPayroll(pp);
	}

	public void addPayrollInfo(PcPayrollInfo ppi) {
		// TODO Auto-generated method stub
		payChexDao.addPayrollInfo(ppi);
	}

	public void addPrize(List<IsGetPrize> pp) {
		// TODO Auto-generated method stub
		payChexDao.addPrize(pp);
	}

	public void addPrizeType(PcPrizeType ppt) {
		// TODO Auto-generated method stub
		payChexDao.addPrizeType(ppt);
	}

	public int addReference(int uid, String inTime, String[] mm, String[] module) {
		// TODO Auto-generated method stub
		return payChexDao.addReference(uid, inTime, mm, module);
	}

	public void addRetired(List<PcRetired> pr) {
		// TODO Auto-generated method stub
		payChexDao.addRetired(pr);
	}

	public void addRetirement(PcRetirement pr) {
		// TODO Auto-generated method stub
		payChexDao.addRetirement(pr);
	}

	public void addSubsidy(List<IsGetSubsidy> ps) {
		// TODO Auto-generated method stub
		payChexDao.addSubsidy(ps);
	}

	public void addSubsidyType(PcSubsidyType pst) {
		// TODO Auto-generated method stub
		payChexDao.addSubsidyType(pst);
	}

	public void delBonus(PcBonus pb) {
		// TODO Auto-generated method stub
		payChexDao.delBonus(pb);
	}

	public void delCooinsurance(int uid) {
		// TODO Auto-generated method stub
		payChexDao.delCooinsurance(uid);
	}

	public void delDuction(PcDeduction pd) {
		// TODO Auto-generated method stub
		payChexDao.delDuction(pd);
	}

	public void delFrotier(PcFrontier pf) {
		// TODO Auto-generated method stub
		payChexDao.delFrotier(pf);
	}

	public void delIndustry(PcIndustry pi) {
		// TODO Auto-generated method stub
		payChexDao.delIndustry(pi);
	}

	public void delInsurance(PcInsurance pi) {
		// TODO Auto-generated method stub
		payChexDao.delInsurance(pi);
	}

	public void delPayroll(PcPayroll pp) {
		// TODO Auto-generated method stub
		payChexDao.delPayroll(pp);
	}

	public void delPayrollInfo(PcPayrollInfo ppi) {
		// TODO Auto-generated method stub
		payChexDao.delPayrollInfo(ppi);
	}

	public void delPrize(PcPrize pp) {
		// TODO Auto-generated method stub
		payChexDao.delPrize(pp);
	}

	public void delPrizeType(PcPrizeType ppt) {
		// TODO Auto-generated method stub
		payChexDao.delPrizeType(ppt);
	}

	public void delRetired(PcRetired pr) {
		// TODO Auto-generated method stub
		payChexDao.delRetired(pr);
	}

	public void delRetirement(PcRetirement pr) {
		// TODO Auto-generated method stub
		payChexDao.delRetirement(pr);
	}

	public void delSubsidyType(PcSubsidyType pst) {
		// TODO Auto-generated method stub
		payChexDao.delSubsidyType(pst);
	}

	public void delsubsidy(PcSubsidy ps) {
		// TODO Auto-generated method stub
		payChexDao.delsubsidy(ps);
	}

	public void upBonus(PcBonus pb) {
		// TODO Auto-generated method stub
		payChexDao.upBonus(pb);
	}

	public void upCooinsurance(PcCooinsurance pc) {
		// TODO Auto-generated method stub
		payChexDao.upCooinsurance(pc);
	}

	public void upDeduction(PcDeduction pd) {
		// TODO Auto-generated method stub
		payChexDao.upDeduction(pd);
	}

	public void upFrontier(PcFrontier pf) {
		// TODO Auto-generated method stub
		payChexDao.upFrontier(pf);
	}

	public void upIndustry(PcIndustry pi) {
		// TODO Auto-generated method stub
		payChexDao.upIndustry(pi);
	}

	public void upInsurance(PcInsurance pi) {
		// TODO Auto-generated method stub
		payChexDao.upInsurance(pi);
	}

	public void upPayroll(PcPayroll pp) {
		// TODO Auto-generated method stub
		payChexDao.upPayroll(pp);
	}

	public void upPayrollInfo(PcPayrollInfo ppi) {
		// TODO Auto-generated method stub
		payChexDao.upPayrollInfo(ppi);
	}

	public void upPrize(PcPrize pp) {
		// TODO Auto-generated method stub
		payChexDao.upPrize(pp);
	}

	public void upPrizeType(PcPrizeType ppt) {
		// TODO Auto-generated method stub
		payChexDao.upPrizeType(ppt);
	}

	public void upRetired(PcRetired pr) {
		// TODO Auto-generated method stub
		payChexDao.upRetired(pr);
	}

	public void upSubsidy(PcSubsidy ps) {
		// TODO Auto-generated method stub
		payChexDao.upSubsidy(ps);
	}

	public void upSubsidyType(PcSubsidyType pst) {
		// TODO Auto-generated method stub
		payChexDao.upSubsidyType(pst);
	}

	public void upretirement(PcRetirement pr) {
		// TODO Auto-generated method stub
		payChexDao.upretirement(pr);
	}

	public List<PcBonus> isGetBonus(PcBonus ig) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetBonus(ig);
	}

	public List<PcCooinsurance> isGetCooinsurance(int uid) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetCooinsurance(uid);
	}

	public List<PcDeduction> isGetDeduction(PcDeduction ig) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetDeduction(ig);
	}

	public List<PcIndustry> isGetIndustry() {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetIndustry();
	}

	public PcInsurance isGetInsurance(int uid) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetInsurance(uid);
	}

	public List<OrgNation> isGetNation(int wai) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetNation(wai);
	}

	public List<IsGetPrize> isGetPrize(IsGetPrize ig) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetPrize(ig);
	}

	public List<PcRetired> isGetRetired(int uid) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetRetired(uid);
	}

	public List<PcRetirement> isGetRetirement(int uid) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetRetirement(uid);
	}

	public List<IsGetSubsidy> isGetSubsidy(IsGetSubsidy ig) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetSubsidy(ig);
	}

	public boolean isGuide(int UID) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGuide(UID);
	}

	public void addXiangdao1(PcPayrollInfo ppl){
		payChexDao.addXiangdao1(ppl);
	}
	public void upXiangdao1(PcPayrollInfo ppl){
		payChexDao.upXiangdao1(ppl);
	}

	public List<OrgCity> isGetCity(int id) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetCity(id);
	}

	public List<OrgProvince> isGetProvince(int id) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetProvince(id);
	}

	public PcPayrollInfo isGetUserInfo(int UID) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetUserInfo(UID);
	}

	public IsCityToProvinceToNation isGetCityToProvinceToNation(int cid) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetCityToProvinceToNation(cid);
	}

	public List<PcPrizeType> isGetPrizeType(String name) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetPrizeType(name);
	}

	public List<PcSubsidyType> isGetSubsidyType(String name) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetSubsidyType(name);
	}

	public PcPrizeType tePrizeType(String name) {
		// TODO Auto-generated method stub
		return payChexDao.tePrizeType(name);
	}

	public PcSubsidyType teSubsidyType(String name) {
		// TODO Auto-generated method stub
		return payChexDao.teSubsidyType(name);
	}

	public IsGetPayrollInfoAll isGetPayrollInfoAll(int uid) {
		// TODO Auto-generated method stub
		return payChexSelectDao.isGetPayrollInfoAll(uid);
	}

	public void upPayrollType(PcPayroll pc) {
		// TODO Auto-generated method stub
		payChexDao.upPayrollType(pc);
	}

	public void upPayrollTax(PcPayroll pc) {
		// TODO Auto-generated method stub
		payChexDao.upPayrollTax(pc);
	}

}
