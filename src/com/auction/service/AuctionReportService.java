package com.auction.service;

import java.util.List;

import com.auction.entity.AcAuction;

public interface AuctionReportService {

	/***
	 * 查询所有的拍卖
	 */
		public List<AcAuction> find(AcAuction auction);
}
