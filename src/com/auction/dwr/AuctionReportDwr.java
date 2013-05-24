package com.auction.dwr;

import java.util.List;

import com.auction.entity.AcAuction;
import com.auction.service.AuctionReportService;

public class AuctionReportDwr {

	private AuctionReportService auctionReportService;

	public AuctionReportService getAuctionReportService() {
		return auctionReportService;
	}

	public void setAuctionReportService(AuctionReportService auctionReportService) {
		this.auctionReportService = auctionReportService;
	}
	/***
	 * 查询所有的拍卖
	 */
    public List<AcAuction> findAuctionDwr(Integer uid){
    	AcAuction auction=new AcAuction();
    	auction.setUid(uid);
    	return auctionReportService.find(auction);
    }
}
