package com.paychex.dwr;
import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.org.entity.TaxPayer;
import com.paychex.entity.Bonus;
import com.paychex.entity.BonusMonth;
import com.paychex.entity.Cooinsurance;
import com.paychex.entity.Deduction;
import com.paychex.entity.DeductionMonth;
import com.paychex.entity.Insurance;
import com.paychex.entity.PayrollMonth;
import com.paychex.entity.PrizeJoin;
import com.paychex.entity.PrizeMonth;
import com.paychex.entity.SubsidyJoin;
import com.paychex.entity.SubsidyMonth;
import com.paychex.entity.WageMonth;
import com.paychex.entity.WageYear;
import com.paychex.service.BonusMonthService;
import com.paychex.service.BonusService;
import com.paychex.service.CooinsuranceService;
import com.paychex.service.DeductionMonthService;
import com.paychex.service.DeductionService;
import com.paychex.service.InsuranceService;
import com.paychex.service.PayrollMonthService;
import com.paychex.service.PrizeMonthService;
import com.paychex.service.PrizeService;
import com.paychex.service.SubsidyMonthService;
import com.paychex.service.SubsidyService;
import com.paychex.service.WageMonthService;
import com.paychex.service.WageYearService;
public class WageReportDwr {
    private PrizeService prizeService;
    private PrizeMonthService prizeMonthService;
	private BonusService bonusService;
	private BonusMonthService bonusMonthService;
    private SubsidyService subsidyService;
    private SubsidyMonthService subsidyMonthService;
    private InsuranceService insuranceService;
    private PayrollMonthService payrollMonthService;
    private DeductionService deductionService;
    private DeductionMonthService deductionMonthService;
    private CooinsuranceService cooinsuranceService;
    private WageYearService wageYearService;
    private WageMonthService wageMonthService;
    
	
	
	public void setPrizeService(PrizeService prizeService) {
		this.prizeService = prizeService;
	}

	public void setPrizeMonthService(PrizeMonthService prizeMonthService) {
		this.prizeMonthService = prizeMonthService;
	}

	public void setBonusService(BonusService bonusService) {
		this.bonusService = bonusService;
	}

	public void setBonusMonthService(BonusMonthService bonusMonthService) {
		this.bonusMonthService = bonusMonthService;
	}

	public void setSubsidyService(SubsidyService subsidyService) {
		this.subsidyService = subsidyService;
	}

	public void setSubsidyMonthService(SubsidyMonthService subsidyMonthService) {
		this.subsidyMonthService = subsidyMonthService;
	}

	public void setInsuranceService(InsuranceService insuranceService) {
		this.insuranceService = insuranceService;
	}

	public void setPayrollMonthService(PayrollMonthService payrollMonthService) {
		this.payrollMonthService = payrollMonthService;
	}
    
	public void setDeductionService(DeductionService deductionService) {
		this.deductionService = deductionService;
	}
    
	public void setDeductionMonthService(DeductionMonthService deductionMonthService) {
		this.deductionMonthService = deductionMonthService;
	}

	
	public void setCooinsuranceService(CooinsuranceService cooinsuranceService) {
		this.cooinsuranceService = cooinsuranceService;
	}

	public void setWageYearService(WageYearService wageYearService) {
		this.wageYearService = wageYearService;
	}

	public void setWageMonthService(WageMonthService wageMonthService) {
		this.wageMonthService = wageMonthService;
	}

	/**
	 *查询某个用户某月所有奖金
	 * 
	 * @throws SQLException
	 * */
    public List<PrizeJoin> findPrize(PrizeJoin prizeJoin,String month) {
		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	     Integer uid=taxPayer.getTaxID();
			prizeJoin.setUid(uid);
			prizeJoin.setPrizeInDay(month);
		    return prizeService.find(prizeJoin);
	}
	
    /**
	 *查询某个用户某月所有补贴
	 * 
	 * @throws SQLException
	 * */
    public List<SubsidyJoin> findSubsidy(SubsidyJoin subsidyJoin,String month)  {

		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	     Integer uid=taxPayer.getTaxID();
			subsidyJoin.setUid(uid);
			subsidyJoin.setSubsidyInDay(month);
		return subsidyService.find(subsidyJoin);
	}
	
	/**
	 *查询某个用户某月所有分红
	 * 
	 * @throws SQLException
	 * */
    public List<Bonus> findBonus(Bonus bonus,String month) {

		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	     Integer uid=taxPayer.getTaxID();
			bonus.setUid(uid);
			bonus.setBonusInDay(month);
	
	   return bonusService.find(bonus);
		
	}
    /**
	 *社保
	 * 
	 * @throws SQLException
	 * */
    public Insurance findInsurance(Insurance insurance){

		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	     Integer uid=taxPayer.getTaxID();
			insurance.setUid(uid);
			
	    return insuranceService.findSingle(insurance);
	}
	/**
	 *查询某个用户某月所有扣除项
	 * 
	 * @throws SQLException
	 * */
    public List<Deduction> findDeduction(Deduction deduction,String month) {
		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	     Integer uid=taxPayer.getTaxID();
	        deduction.setUid(uid);
	        deduction.setDeductionDay(month);
	
	   return deductionService.find(deduction);
		
	}

    /**
	 *查询某个用户某年各月的奖金和
	 * 
	 * @throws SQLException
	 * */
    public List<PrizeMonth> findPrizeMonth(String year)  {

		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	    Integer uid=taxPayer.getTaxID();
		PrizeMonth prizeMonth=new PrizeMonth();
			prizeMonth.setUid(uid);
		    prizeMonth.setPrizeYear(year);
		    List<PrizeMonth> list=prizeMonthService.find(prizeMonth);
		return list;
	}
    /**
	 *查询某个用户某年各月的补贴和
	 * 
	 * @throws SQLException
	 * */
    public List<SubsidyMonth> findSubsidyMonth(String year)  {

		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	     Integer uid=taxPayer.getTaxID();
         SubsidyMonth subsidyMonth=new SubsidyMonth();
			subsidyMonth.setUid(uid);
		    subsidyMonth.setSubsidyYear(year);
		return subsidyMonthService.find(subsidyMonth);
	}
    /**
	 *查询某个用户某年各月的分红和
	 * 
	 * @throws SQLException
	 * */
    public List<BonusMonth> findBonusMonth(String year)  {

		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	    Integer uid=taxPayer.getTaxID();
		BonusMonth bonusMonth=new BonusMonth();
            bonusMonth.setUid(uid);
            bonusMonth.setBonusYear(year);
		return bonusMonthService.find(bonusMonth);
	}
    /**
	 *查询某个用户某年各月的扣除项和
	 * 
	 * @throws SQLException
	 * */
    public List<DeductionMonth> findDeductionMonth(String year)  {
		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	    Integer uid=taxPayer.getTaxID();
	    DeductionMonth deductionMonth=new DeductionMonth();
	    deductionMonth.setUid(uid);
	    deductionMonth.setDeductionYear(year);
		return deductionMonthService.find(deductionMonth);
	}
    /**
	 *查询某个用户某年各月的商业保险
	 * 
	 * @throws SQLException
	 * */
    public List<Cooinsurance> findCooinsurance(String year)  {

		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	    Integer uid=taxPayer.getTaxID();
	    Cooinsurance cooinsurance=new Cooinsurance();
	    cooinsurance.setUid(uid);
	    cooinsurance.setInsuranceDate(year+"%");
		return cooinsuranceService.find(cooinsurance);
	}
    /**
	 *查询某个用户某年各月的基础工资/纳税额
	 * 
	 * @throws SQLException
	 * */
    public List<PayrollMonth> findPayrollMonth(String year)  {

		 TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	     Integer uid=taxPayer.getTaxID();
		 PayrollMonth payrollMonth=new PayrollMonth();
		 payrollMonth.setUid(uid);
		 payrollMonth.setPayrollYear(year);
		 return payrollMonthService.find(payrollMonth);
	}
    
	/**
	 * 查询某个用户全年工资信息汇总
	 * 
	 * @throws SQLException
	 * */
    public WageYear findWageYear(String year) {

		TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	    Integer uid=taxPayer.getTaxID();
		WageYear wageYear=new WageYear();
         wageYear.setTaxID(uid);
	     wageYear.setInPayYear(year);
		return wageYearService.findSingle(wageYear);
	}
	/**
	 * 查询某个用户月信息汇总
	 * 
	 * @throws SQLException
	 * 
	 * */
    public WageMonth findWageMonth(int uid,String time) {
    	WageMonth wageMonth=new WageMonth();
		wageMonth.setTaxID(uid);
		wageMonth.setPayMonth(returnMMString(time));
		return wageMonthService.findSingle(wageMonth);
	}
    private String returnMMString(String time){
    	String[] mm=time.split("-");
    	return mm[0]+"-"+mm[1]+"%";
    }
    
    public String findYearCoo(String year){
    	TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	    Integer uid=taxPayer.getTaxID();
	    String zsybx="";
    	return wageYearService.findMap(uid,year,zsybx);
    }
    public String findMonthCoo(Integer uid,String month){
    	//TaxPayer taxPayer=(TaxPayer)ActionContext.getContext().getSession().get("taxPayer");
	    //Integer uid=taxPayer.getTaxID();
	    String sybx="";
    	return wageMonthService.findMonthMap(uid,month,sybx);
    }
}
