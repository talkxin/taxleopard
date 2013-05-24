package com.paychex.action;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.WebService.ServiceRute;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.OrgNation;
import com.org.entity.TaxPayer;
import com.paychex.entity.IsGetPayrollInfoAll;
import com.paychex.entity.PcPayroll;
import com.paychex.entity.PcPayrollInfo;
import com.paychex.service.PayChexService;
import com.tax.util.PeronalReportingEarnings;

public class PaychexAction extends ActionSupport {
	private PayChexService payChexService;
	private int hangye;
	private int xingzhi;
	private int guojia;
	private int waiguo;


	public int getHangye() {
		return hangye;
	}
	public void setHangye(int hangye) {
		this.hangye = hangye;
	}
	public int getXingzhi() {
		return xingzhi;
	}
	public void setXingzhi(int xingzhi) {
		this.xingzhi = xingzhi;
	}
	public int getGuojia() {
		return guojia;
	}
	public void setGuojia(int guoji) {
		this.guojia = guoji;
	}
	public int getWaiguo() {
		return waiguo;
	}
	public void setWaiguo(int waiguo) {
		this.waiguo = waiguo;
	}
	/**
	 * 判断用户是否初始化过
	 * @return
	 */
public String isInPayChex(){
	Date d=new Date();
	SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	session.put("addTime", f.format(d));
	TaxPayer tr=(TaxPayer) session.get("taxPayer");
	if(tr!=null && payChexService.isGuide(tr.getTaxID())){
		return "paychexMain";
	}else if(tr!=null){
		//放入行业与国家
		session.put("hangye", payChexService.isGetIndustry());
		session.put("guojia", payChexService.isGetNation(1));
	return "xiangdao1";
	}else{
		return "LoginEcho";
	}
}
public String openpaychex(){
	return "paychex";
}

public PayChexService getPayChexService() {
		return payChexService;
	}
	public void setPayChexService(PayChexService payChexService) {
		this.payChexService = payChexService;
	}
/***
 * 
 * @return
 */
public String isGotoXd2(){
	String url="";
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	 PcPayrollInfo ppl=new PcPayrollInfo();
	 ppl.setUid(((TaxPayer)session.get("taxPayer")).getTaxID());
	 ppl.setIndustry(hangye);
	 ppl.setIndustryXz(xingzhi);
	 if(guojia!=3){
		 ppl.setUserNation(guojia);
		 url="paychexMain";
	 }else{
		 ppl.setUserNation(waiguo);
		 url="xiangdao2";
	 }
	 if(!payChexService.isGuide(((TaxPayer)session.get("taxPayer")).getTaxID())){
		 payChexService.addXiangdao1(ppl);
	 }
	 else{
		 payChexService.upXiangdao1(ppl);
	 }
	return url;
}
/**
 * 完成添加
 * @return
 * @throws Exception 
 */
public String isOkPay() throws Exception{
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	PcPayroll pc=new PcPayroll();
	TaxPayer tr=(TaxPayer)session.get("taxPayer");
	pc.setUid(tr.getTaxID());
	pc.setInPayDay(session.get("addTime").toString());
	pc=payChexService.addPayroll(pc);
	ServiceRute serviceRute=new ServiceRute();//实例化对象
	IsGetPayrollInfoAll all=payChexService.isGetPayrollInfoAll(tr.getTaxID());
	HashMap map=new HashMap();
	map.put("moduleName", "PayChex");
	map.put("userTime", returnString(session.get("addTime").toString().split("-")));
	map.put("nationality", all.getNationSortName());
//	if(all.getIndustryType()==1)
	map.put("trade", "普通");
	map.put("taxed", "OnTaxed");
	map.put("paychexD", pc.getPayInNumber());
//	HashMap<String,HashMap> list=new HashMap<String,HashMap>();
	//将单一业务map加入批量业务map
//	list.put("one", map);
//	serviceRute.setMap(list);
//	map.putAll(serviceRute.getPojo().getBusinessList().get("one"));
//	pc.setPayType(1);
//	if((String)map.get("yingna")!=null)
//	pc.setTaxableNumber((String)map.get("yingna"));
//	else
//		pc.setTaxableNumber("0");
//	if((String)map.get("taxe")!=null)
//	pc.setTaxNumber((String)map.get("taxe"));
//	else
//		pc.setTaxNumber("0");
//	String a="";
//	String b="";
//	if(pc.getPayInNumber()==null || pc.getPayInNumber()=="")
//		a="0";
//	else
//		a=pc.getPayInNumber();
//	if(pc.getTaxNumber()==null || pc.getTaxNumber()=="")
//		b="0";
//	else
//		b=pc.getTaxNumber();
//	pc.setPayOutNumber(PeronalReportingEarnings.subtractNumber(a, b));
//	pc.setBasicWage(all.getPayNumber());
	payChexService.upPayrollTax(pc);
	return "returnPayPage";
}
/**
 * 取消添加
 * @return
 */
public String isReturnPay(){
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	PcPayroll pc=new PcPayroll();
	TaxPayer tr=(TaxPayer)session.get("taxPayer");
	pc.setUid(tr.getTaxID());
	pc.setInPayDay(session.get("addTime").toString());
	pc.setPayType(0);
	payChexService.upPayrollType(pc);
	return "openPay";
}
/**
 * 打开工资薪金
 * @return
 */
public String isOpenPay(){
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	TaxPayer tr=(TaxPayer) session.get("taxPayer");
	PcPayrollInfo pc=payChexService.isGetUserInfo(tr.getTaxID());
	if(pc.getPayDay()!=null){
		session.put("payDay", pc.getPayDay());
	}
	if(payChexService.isGuide(tr.getTaxID())){
		return "paychexin";
	}else{
		return "LoginEcho";
	}
	
}
public String isGotoXd3(){
	return "paychexMain";
}
public String isGotoCr(){
	return "churjing";
}
private String returnString(String[] srt){
	String a = "";
	for (int i = 0; i < srt.length; i++) {
		a=a+srt[i];
	}
	return a;
}
}
