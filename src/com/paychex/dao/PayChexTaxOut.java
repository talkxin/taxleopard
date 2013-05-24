package com.paychex.dao;

import java.util.List;

import com.paychex.entity.IsGetPrize;
import com.paychex.entity.IsGetSubsidy;
import com.paychex.entity.PcInsurance;
import com.paychex.entity.PcRetired;
import com.paychex.entity.PcRetirement;



public interface PayChexTaxOut {
	/**
	 * 计算当月工资薪金个人所得税
	 * 
	 */
	public void inFoPayrollTax();
	/**
	 * 计算特殊奖金个人所得税
	 */
	public List<IsGetPrize> inFoPrizeTax(List<IsGetPrize> list);
	/**
	 * 计算特殊补贴所得税
	 */
	public List<IsGetSubsidy> inFoSubsidyTax(List<IsGetSubsidy> list);
	/**
	 * 计算社保
	 */
	public PcInsurance inFoInsurance(PcInsurance pc);
	/**
	 * 计算退职费
	 * @param pr
	 * @return
	 */
	public PcRetired inFoRetired(PcRetired pr);
	/**
	 * 计算退养费
	 * @param pr
	 * @return
	 */
	public PcRetirement inFoRetirement(PcRetirement pr);
}
