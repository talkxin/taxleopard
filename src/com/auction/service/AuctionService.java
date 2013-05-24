package com.auction.service;

import com.auction.entity.AcAuction;

public interface AuctionService {
	/**
	 * 增加拍卖信息
	 * @param ac
	 */
	public void addAuctionInfo(AcAuction ac);
	/**
	 *修改拍卖信息
	 * @param ac
	 */
	public void upAuctionInfo(AcAuction ac);
	/**
	 * 删除拍卖信息
	 * @param ac
	 */
	public void delAuctionInfo(int ac);
}
