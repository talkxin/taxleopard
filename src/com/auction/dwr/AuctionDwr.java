package com.auction.dwr;

import com.auction.entity.AcAuction;
import com.auction.service.AuctionService;

public class AuctionDwr {
	private AuctionService auctionService;

	public AuctionService getAuctionService() {
		return auctionService;
	}

	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}

	/**
	 * 增加拍卖信息
	 * 
	 * @param ac
	 */
	public void addAuctionInfo(AcAuction ac) {
		auctionService.addAuctionInfo(ac);
	}

	/**
	 * 修改拍卖信息
	 * 
	 * @param ac
	 */
	public void upAuctionInfo(AcAuction ac) {
		auctionService.upAuctionInfo(ac);
	}

	/**
	 * 删除拍卖信息
	 * 
	 * @param ac
	 */
	public void delAuctionInfo(int ac) {
		auctionService.delAuctionInfo(ac);
	}
}
