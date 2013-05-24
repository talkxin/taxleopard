package com.auction.service;

import com.auction.dao.AuctionDao;
import com.auction.entity.AcAuction;

public class AuctionServiceImpl implements AuctionService{
	private AuctionDao auctionDao;

	public AuctionDao getAuctionDao() {
		return auctionDao;
	}

	public void setAuctionDao(AuctionDao auctionDao) {
		this.auctionDao = auctionDao;
	}

	public void addAuctionInfo(AcAuction ac) {
		// TODO Auto-generated method stub
		auctionDao.addAuctionInfo(ac);
	}

	public void upAuctionInfo(AcAuction ac) {
		// TODO Auto-generated method stub
		auctionDao.upAuctionInfo(ac);
	}

	public void delAuctionInfo(int ac) {
		// TODO Auto-generated method stub
		auctionDao.delAuctionInfo(ac);
	}
}
