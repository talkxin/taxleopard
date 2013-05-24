package com.paychex.dwr;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.opensymphony.xwork2.ActionContext;
import com.org.entity.OrgCity;
import com.org.entity.OrgNation;
import com.org.entity.OrgProvince;
import com.org.entity.TaxPayer;
import com.paychex.entity.IsCityToProvinceToNation;
import com.paychex.entity.IsGetPrize;
import com.paychex.entity.IsGetSubsidy;
import com.paychex.entity.PcBonus;
import com.paychex.entity.PcCooinsurance;
import com.paychex.entity.PcDeduction;
import com.paychex.entity.PcInsurance;
import com.paychex.entity.PcPayroll;
import com.paychex.entity.PcPayrollInfo;
import com.paychex.entity.PcPrize;
import com.paychex.entity.PcPrizeType;
import com.paychex.entity.PcRetired;
import com.paychex.entity.PcRetirement;
import com.paychex.entity.PcSubsidy;
import com.paychex.entity.PcSubsidyType;
import com.paychex.service.PayChexService;

public class PaychexDwr {
private PayChexService payChexService;
private int uid;
private String time;
private String day1;
private String day2;


public PayChexService getPayChexService() {
	return payChexService;
}

public void setPayChexService(PayChexService payChexService) {
	this.payChexService = payChexService;
}
public void addPayrollInfo(PcPayrollInfo pc){
	
}
/***
 * 获得国家
 * @return
 */
public List<OrgNation> getNation(){
	return payChexService.isGetNation(0);
}
/**
 * 获得省
 */
public List<OrgProvince> getProvince(int id){
	return payChexService.isGetProvince(id);
}
/**
 * 获得市
 * @param id
 * @return
 */
public List<OrgCity> getCity(int id){
	return payChexService.isGetCity(id);
}
/***
 * 获取个人信息
 * @param UID
 * @return
 */
public PcPayrollInfo getUserInfo(Integer id){
//	ActionContext actionContext = ActionContext.getContext();
//	Map session = actionContext.getSession();
//	TaxPayer tr=(TaxPayer) session.get("taxPayer");
	return payChexService.isGetUserInfo(id);
}
/**
 * 修改基础工资
 * @param pc
 */
public void upPayrollInfo(PcPayrollInfo pc){
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	if(session.get("addTime")!=null){
		String time=session.get("addTime").toString();
		if(pc.getPayType()==0 && time.split("-")[2]=="01"){
			String[] day=time.split("-");
			session.put("addTime", day[0]+"-"+day[1]+"-"+pc.getPayDay());
		}else if(pc.getPayType()==1){
			session.put("addTime", pc.getPayDay2());
		}
	}
	payChexService.upPayrollInfo(pc);
}
/**
 * 以市求省求国家
 */
public IsCityToProvinceToNation getCityToProvinceToNation(int cid){
	return payChexService.isGetCityToProvinceToNation(cid);
}
/**
 * 模糊查询奖金类型
 * @param name
 * @return
 */
public List<PcPrizeType> isGetPrizeType(String name){
	return payChexService.isGetPrizeType(name);
}
/**
 * 模糊查询补贴类型
 * @param name
 * @return
 */
public List<PcSubsidyType> isGetSubsidyType(String name){
	return payChexService.isGetSubsidyType(name);
}
/**
 * 获取session中的值
 * @return
 */
public HashMap getUser(){
	HashMap map=new HashMap();
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	TaxPayer tr=(TaxPayer) session.get("taxPayer");
	map.put("userId", tr.getTaxID());
	map.put("addTime", session.get("addTime"));
	map.put("pids", tr.getPid());
	uid=tr.getTaxID();
	if(session.get("addTime")!=null){
		time=session.get("addTime").toString();
	}
	return map;
}
/**
 * 特殊奖金税务计算
 * @param ptid
 * @return
 */
public String getPrizeTax(int ptid,String number){
	return null;
}
/**
 * 返回用户点击月奖金
 * @param uid
 * @param time
 * @return
 */
public List<IsGetPrize> isGetPrize(int uid,String time,int type){
		time=isReturnTime(time,type);
	IsGetPrize ig=new IsGetPrize();
	ig.setUid(uid);
	ig.setPrizeInDay(time);
	return payChexService.isGetPrize(ig);
}
/**
 * 特殊奖金返回ptid
 * @param name
 * @return
 */
public PcPrizeType tePrizeType(String name){
	return payChexService.tePrizeType(name);
}
/**
 * 奖金存储
 * @param list
 */
public void savePrize(IsGetPrize[] ur){	
	//删除所有当月奖金
	PcPrize pc=new PcPrize();
	if(ur!=null && ur.length!=0){
		pc.setUid(ur[0].getUid());
		pc.setPrizeInDay(ur[0].getPrizeInDay());
	payChexService.delPrize(pc);
	List<IsGetPrize> list=new ArrayList<IsGetPrize>();
	for (int i = 0; i < ur.length; i++) {
		list.add(ur[i]);
	}
	payChexService.addPrize(list);
	}else{
		pc.setUid(uid);
		pc.setPrizeInDay(time);
		payChexService.delPrize(pc);
	}
}
/**
 * 返回用户某月补贴
 * @param uid
 * @param time
 * @param type
 * @return
 */
public List<IsGetSubsidy> isGetSubsidy(int uid,String time,int type){
		time=isReturnTime(time,type);
	IsGetSubsidy is=new IsGetSubsidy();
	is.setUid(uid);
	is.setSubsidyInDay(time);
	return payChexService.isGetSubsidy(is);
}
/**
 * 返回特殊补贴
 * @param name
 * @return
 */
public PcSubsidyType teSubsidyType(String name){
	return payChexService.teSubsidyType(name);
}
/**
 * 存储用户补贴
 * @param is
 */
public void saveSubsidy(IsGetSubsidy[] ur){
	//删除所有当月补贴
	PcSubsidy pc=new PcSubsidy();
	if(ur!=null && ur.length!=0){
		pc.setUid(ur[0].getUid());
		pc.setSubsidyInDay(ur[0].getSubsidyInDay());
	payChexService.delsubsidy(pc);
	List<IsGetSubsidy> list=new ArrayList<IsGetSubsidy>();
	for (int i = 0; i < ur.length; i++) {
		list.add(ur[i]);
	}
	payChexService.addSubsidy(list);
	}else{
		pc.setUid(uid);
		pc.setSubsidyInDay(time);
		payChexService.delsubsidy(pc);
	}
}
/**
 * 返回特殊补贴税
 * @param stid
 * @param subsidyNumber
 * @return
 */
public String getSubsidyTax(int stid,String subsidyNumber){
	return null;
}

/**
 * 返回用户某月分红
 * @param uid
 * @param time
 * @param type
 * @return
 */
public List<PcBonus> isGetBonus(int uid,String time,int type){
		time=isReturnTime(time,type);
	PcBonus is=new PcBonus();
	is.setUid(uid);
	is.setBonusInDay(time);
	return payChexService.isGetBonus(is);
}

/**
 * 存储用户补贴
 * @param is
 */
public void saveBonus(PcBonus[] ur){
	//删除所有当月分红
	PcBonus pc=new PcBonus();
	if(ur!=null && ur.length!=0){
		pc.setUid(ur[0].getUid());
		pc.setBonusInDay(ur[0].getBonusInDay());
	payChexService.delBonus(pc);
	List<PcBonus> list=new ArrayList<PcBonus>();
	for (int i = 0; i < ur.length; i++) {
		list.add(ur[i]);
	}
	payChexService.addBonus(list);
	}else{
		pc.setUid(uid);
		pc.setBonusInDay(time);
		payChexService.delBonus(pc);
	}
}
/**
 * 获取用户五险一金
 * @return
 */
public PcInsurance isGetInsurance(int cid){
	PcInsurance pi=payChexService.isGetInsurance(uid);
	if(pi==null){
		///五险一金计算
		pi.setUid(uid);
//		returnInsurance(null,0,cid);
		payChexService.addInsurance(pi);
	}
	return pi;
}
/**
 * 存储五险一金
 * @param pi
 */
public void saveInsurance(PcInsurance pi){
	payChexService.upInsurance(pi);
}
/**
 * 计算五险一金
 * @param number
 * @param type
 * @param city
 * @return
 */
public PcInsurance returnInsurance(String number,int type,int city){
	return null;
}
/**
 * 返回商业保险
 * @param uid
 * @return
 */
public List<PcCooinsurance> isGetCooinsurance(int uid){
	return payChexService.isGetCooinsurance(uid);
}
/**
 * 存储商业保险
 * @param ur
 */
public void saveCooinsurance(PcCooinsurance[] ur){
	if(ur!=null && ur.length!=0){
		List<PcCooinsurance> list=new ArrayList<PcCooinsurance>();
		for (int i = 0; i < ur.length; i++) {
			list.add(ur[i]);
		}
		payChexService.delCooinsurance(uid);
		payChexService.addCooinsurance(list);
	}else{
		payChexService.delCooinsurance(uid);
	}
}
/**
 * 获取本月上月扣除
 * @param uid
 * @param time
 * @param type
 * @return
 */
public List<PcDeduction> isGetDeduction(int uid,String time,int type){
		time=isReturnTime(time,type);
	PcDeduction pc=new PcDeduction();
	pc.setUid(uid);
	pc.setDeductionDay(time);
	return payChexService.isGetDeduction(pc);
}
/***
 * 保存扣除项
 * @param ur
 */
public void saveDeduction(PcDeduction[] ur){
	PcDeduction pc=new PcDeduction();
	if(ur!=null && ur.length!=0){
		pc.setUid(ur[0].getUid());
		pc.setDeductionDay(ur[0].getDeductionDay());
		payChexService.delDuction(pc);
		List<PcDeduction> list=new ArrayList<PcDeduction>();
		for (int i = 0; i < ur.length; i++) {
			list.add(ur[i]);
		}
		payChexService.addDeduction(list);
		}else{
			pc.setUid(this.uid);
			pc.setDeductionDay(this.time);
			payChexService.delDuction(pc);
		}
	}
/**
 * 获取个人退职费信息
 * @param uid
 * @return
 */
public List<PcRetired> isGetRetired(int uid){
	return payChexService.isGetRetired(uid);
}
/**
 * 存储个人退职费信息
 * @param ur
 */
public void saveRetired(PcRetired[] ur){
	PcRetired pc=new PcRetired();
	if(ur!=null && ur.length!=0){
		pc.setUid(ur[0].getUid());
		payChexService.delRetired(pc);
		List<PcRetired> list=new ArrayList<PcRetired>();
		for (int i = 0; i < ur.length; i++) {
			list.add(ur[i]);
		}
		payChexService.addRetired(list);
	}else{
		pc.setUid(this.uid);
		payChexService.delRetired(pc);
	}
}
/**
 * 判断是添加还是修改
 * @return
 */
public int isSaveOrUpdate(String nian,String yue){
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	String ri=(String)session.get("payDay");
	if(ri==null || ri=="" || ri.equals("")){
		ri="01";
	}
	String addTime=nian+"-"+yue+"-"+ri;
	session.put("addTime", addTime);
	return 0;
}
/***
 * 获取用户，并填充session时间
 */
public String returnDay(){
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	TaxPayer tr=(TaxPayer) session.get("taxPayer");
//	if(day1==null && day2==null){
		PcPayrollInfo pc=payChexService.isGetUserInfo(tr.getTaxID());
		if(pc!=null && pc.getPayType()==0)
			return pc.getPayDay()+"";
		else if(pc!=null && pc.getPayType()==1){
			session.put("addTime", pc.getPayDay2());
			return pc.getPayDay2();
			}
		else
			return "";
//	}
//	return "";
}
/**
 * 将时间加入session
 * @param time
 */
public void intoTime(String time){
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	session.put("addTime",time);
}
/**
 * 删除某月工资薪金
 * @param uid
 * @param inPayDay
 */
public void delPayRoll(int uid,String inPayDay){
	PcPayroll pc=new PcPayroll();
	pc.setUid(uid);
	pc.setInPayDay(inPayDay);
	payChexService.delPayroll(pc);
}
/**
 * 返回模糊时间
 * @param time
 * @return
 */
private String isReturnTime(String time,int type){
	String[] a=time.split("-");
	if(type==1){
	if(!a[1].equals("01") && !a[1].equals("1")){
		if(Integer.parseInt(a[1])>=10)
		a[1]=Integer.parseInt(a[1])-1+"";
		else
		a[1]="0"+(Integer.parseInt(a[1])-1)+"";
	}else{
		a[0]=Integer.parseInt(a[0])-1+"";
		a[1]="12";
	}
		time=String.valueOf(a[0]+"-"+a[1]+"%");
	}else{
		time=String.valueOf(a[0]+"-"+a[1]+"%");
	}
	return time;
}
}

