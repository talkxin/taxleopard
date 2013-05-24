package com.tax.util;

import java.math.BigDecimal;

public class PeronalReportingEarnings {
	/**
	 * 简单的加法运算
	 * @param num1 第一个数字
	 * @param num2 第二个数字
	 * @return 两个数字的和
	 * @throws Exception 数字转换错误
	 */
	public static String addNumber(String num1,String num2)throws Exception{
		if(num1==null||num2==null||"".equals(num1)||"".equals(num2)){
			throw new Exception("数字输入错误");
		}
		BigDecimal big=new BigDecimal(num1);
		BigDecimal big2=new BigDecimal(num2);
		return big.add(big2).toString();
	}
	/**
	 * 简单的减方法
	 * @param num1 第一个数字
	 * @param num2 第二个数字
	 * @return 第一个数字减去第二个数字的差
	 * @throws Exception 数字转换错误
	 */
	public static String subtractNumber(String num1,String num2)throws Exception{
		if(num1==null||num2==null||"".equals(num1)||"".equals(num2)){
			throw new Exception("数字输入错误");
		}
		BigDecimal big=new BigDecimal(num1);
		BigDecimal big2=new BigDecimal(num2);
		return big.subtract(big2).toString();
	}
	/**
	 * 简单的乘方法
	 * @param num1 第一个数字
	 * @param num2 第二个数字
	 * @return 两个数字的乘积
	 * @throws Exception 数字转换错误
	 */
	public static String multiplyNumber(String num1,String num2)throws Exception{
		if(num1==null||num2==null||"".equals(num1)||"".equals(num2)){
			throw new Exception("数字输入错误");
		}
		BigDecimal big=new BigDecimal(num1);
		BigDecimal big2=new BigDecimal(num2);
		return big.multiply(big2).toString();
	}
	/**
	 * 简单的除方法
	 * @param num1 第一个数字
	 * @param num2 第二个数字
	 * @return 第一个数除以第二个数的商
	 * @throws Exception 数字转换错误
	 */
	public static String divideNumber(String num1,String num2)throws Exception{
		if(num1==null||num2==null||"".equals(num1)||"".equals(num2)){
			throw new Exception("数字输入错误");
		}
		BigDecimal big=new BigDecimal(num1);
		BigDecimal big2=new BigDecimal(num2);
		return big.divide(big2).toString();
	}
	/**
	 * 计算应纳税额
	 * @param rate 税率
	 * @param quickCalculationDeduction 速算扣除数
	 * @param money 应纳税所得额
	 * @return 应纳税额
	 */
	public static String tax(String rate,String quickCalculationDeduction,String money) throws Exception{
		return subtractNumber(multiplyNumber(money, rate),quickCalculationDeduction);
	}
	/**
	 *  保险计算
	 * @param num1 基金
	 * @param num2 投保百分比
	 * @return 计算结果
	 */
	public static String baoxian(String num1,String num2) throws Exception{
		return multiplyNumber(num1, num2);
	}
}
