package com.shares.service;

import java.util.List;

import com.shares.entity.ShSharesIn;
import com.shares.entity.ShSharesInfo;
import com.shares.entity.ShSharesOut;
import com.shares.entity.ShSharesPrice;

public interface SharesDataService {
	/**
	 * 增加基本信息
	 * @param sh
	 * @return
	 */
	public ShSharesInfo addSharesInfo(ShSharesInfo sh);
	/**
	 * 修改股票
	 * @param sh
	 */
	public void upShares(ShSharesInfo sh);
	/**
	 * 修改股权
	 * @param sh
	 */
	public void upEquity(ShSharesInfo sh);
	/**
	 * 修改止蚀价
	 * @param sh
	 */
	public void upEarlyWarning(ShSharesInfo sh);
	/**
	 * 删除所有
	 * @param sid
	 */
	public void delSharesInfo(int sh);
	/**
	 * 股票追加
	 * @param sh
	 */
	public void addSharesIn(ShSharesIn sh);
	/**
	 * 修改股票追加
	 * @param sh
	 */
	public void upSharesIn(ShSharesIn sh);
	/**
	 * 股票追加删除
	 * @param sh
	 */
	public void delSharesIn(int sh);
	/**
	 * 股票转让
	 * @param sh
	 * @return
	 */
	public void addSharesOut(ShSharesOut sh);
	/**
	 * 修改股票转让
	 * @param sh
	 */
	public void upSharesOut(ShSharesOut sh);
	/**
	 * 删除股票转让记录
	 * @param sh
	 */
	public void delSharesOut(int sh);
	/**
	 * 收盘价记录
	 * @param sh
	 */
	public void addSharesPrice(ShSharesPrice sh);
	/**
	 * 修改收盘价
	 * @param sh
	 */
	public void upSharesPrice(ShSharesPrice sh);
	/**
	 * 删除收盘价
	 * @param sh
	 */
	public void delSharesPrice(int sh);
	/**
	 * 查询用户所有股票
	 * @param sh
	 * @return
	 */
	public List<ShSharesInfo> isGetShares(int sh);
	/**
	 * 查询股票追加历史
	 * @param sh
	 * @return
	 */
	public List<ShSharesIn> isGetGupiaolishi(int sh);
	/**
	 * 查询股票转让及行权历史
	 * @param sh
	 * @return
	 */
	public List<ShSharesOut> isGetZhuanrang(int sh);
}
