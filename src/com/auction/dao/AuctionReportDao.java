package com.auction.dao;

import java.util.List;

import com.auction.entity.AcAuction;

public interface AuctionReportDao {

/***
 * 查询所有的拍卖
 */
	public List<AcAuction> find(AcAuction auction);
}
