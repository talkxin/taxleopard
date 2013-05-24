package com.shares.dwr;

import java.util.List;

import com.shares.entity.ShSharesIn;
import com.shares.entity.ShSharesInfo;
import com.shares.entity.ShSharesOut;
import com.shares.entity.ShSharesPrice;
import com.shares.service.SharesDataService;

public class SharesDataDwr {
	private SharesDataService sharesDataService;

	public SharesDataService getSharesDataService() {
		return sharesDataService;
	}

	public void setSharesDataService(SharesDataService sharesDataService) {
		this.sharesDataService = sharesDataService;
	}

	/**
	 * 返回某用户所有股票
	 * 
	 * @param uid
	 * @return
	 */
	public List<ShSharesInfo> isGetShareInfo(int uid) {
		return sharesDataService.isGetShares(uid);
	}

	/**
	 * 添加股票信息
	 * 
	 * @param sh
	 * @return
	 */
	public ShSharesInfo addSharesInfo(ShSharesInfo sh) {
		return sharesDataService.addSharesInfo(sh);
	}

	/**
	 * 修改股票
	 * 
	 * @param sh
	 */
	public void upShares(ShSharesInfo sh) {
		sharesDataService.upShares(sh);
	}

	/**
	 * 修改股权
	 * 
	 * @param sh
	 */
	public void upEquity(ShSharesInfo sh) {
		sharesDataService.upEquity(sh);
	}

	/**
	 * 修改止蚀价
	 * 
	 * @param sh
	 */
	public void upEarlyWarning(ShSharesInfo sh) {
		sharesDataService.upEarlyWarning(sh);
	}

	/**
	 * 删除所有
	 * 
	 * @param sid
	 */
	public void delSharesInfo(int sh) {
		sharesDataService.delSharesInfo(sh);
	}

	/**
	 * 股票追加
	 * 
	 * @param sh
	 */
	public void addSharesIn(ShSharesIn sh) {
		sharesDataService.addSharesIn(sh);
	}

	/**
	 * 修改股票追加
	 * 
	 * @param sh
	 */
	public void upSharesIn(ShSharesIn sh) {
		sharesDataService.upSharesIn(sh);
	}

	/**
	 * 股票追加删除
	 * 
	 * @param sh
	 */
	public void delSharesIn(int sh) {
		sharesDataService.delSharesIn(sh);
	}

	/**
	 * 股票转让
	 * 
	 * @param sh
	 * @return
	 */
	public void addSharesOut(ShSharesOut sh) {
		sharesDataService.addSharesOut(sh);
	}

	/**
	 * 修改股票转让
	 * 
	 * @param sh
	 */
	public void upSharesOut(ShSharesOut sh) {
		sharesDataService.upSharesOut(sh);
	}

	/**
	 * 删除股票转让记录
	 * 
	 * @param sh
	 */
	public void delSharesOut(int sh) {
		sharesDataService.delSharesOut(sh);
	}

	/**
	 * 收盘价记录
	 * 
	 * @param sh
	 */
	public void addSharesPrice(ShSharesPrice sh) {
		sharesDataService.addSharesPrice(sh);
	}

	/**
	 * 修改收盘价
	 * 
	 * @param sh
	 */
	public void upSharesPrice(ShSharesPrice sh) {
		sharesDataService.upSharesPrice(sh);
	}

	/**
	 * 删除收盘价
	 * 
	 * @param sh
	 */
	public void delSharesPrice(int sh) {
		sharesDataService.delSharesPrice(sh);
	}
	/**
	 * 查询股票追加历史
	 * @param sh
	 * @return
	 */
	public List<ShSharesIn> isGetGupiaolishi(int sh){
		return sharesDataService.isGetGupiaolishi(sh);
	}
	/**
	 * 查询股票转让及行权历史
	 * @param sh
	 * @return
	 */
	public List<ShSharesOut> isGetZhuanrang(int sh){
		return sharesDataService.isGetZhuanrang(sh);
	}
}
