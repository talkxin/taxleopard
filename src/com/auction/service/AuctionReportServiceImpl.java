package com.auction.service;

import java.util.List;

import com.auction.dao.AuctionReportDao;
import com.auction.entity.AcAuction;

public class AuctionReportServiceImpl implements AuctionReportService{

	private AuctionReportDao auctionReportDao;
	
	public AuctionReportDao getAuctionReportDao() {
		return auctionReportDao;
	}

	public void setAuctionReportDao(AuctionReportDao auctionReportDao) {
		this.auctionReportDao = auctionReportDao;
	}

	public List<AcAuction> find(AcAuction auction) {
		return auctionReportDao.find(auction);
	}

}
