package com.shares.service;

import java.util.List;

import com.shares.dao.SharesData;
import com.shares.entity.ShSharesIn;
import com.shares.entity.ShSharesInfo;
import com.shares.entity.ShSharesOut;
import com.shares.entity.ShSharesPrice;

public class SharesDataServiceImpl implements SharesDataService {
	private SharesData sharesData;

	public SharesData getSharesData() {
		return sharesData;
	}

	public void setSharesData(SharesData sharesData) {
		this.sharesData = sharesData;
	}

	public void addSharesIn(ShSharesIn sh) {
		// TODO Auto-generated method stub
		sharesData.addSharesIn(sh);
	}

	public ShSharesInfo addSharesInfo(ShSharesInfo sh) {
		// TODO Auto-generated method stub
		return sharesData.addSharesInfo(sh);
	}

	public void addSharesOut(ShSharesOut sh) {
		// TODO Auto-generated method stub
		sharesData.addSharesOut(sh);
	}

	public void addSharesPrice(ShSharesPrice sh) {
		// TODO Auto-generated method stub
		sharesData.addSharesPrice(sh);
	}

	public void delSharesIn(int sh) {
		// TODO Auto-generated method stub
		sharesData.delSharesIn(sh);
	}

	public void delSharesInfo(int sh) {
		// TODO Auto-generated method stub
		sharesData.delSharesInfo(sh);
	}

	public void delSharesOut(int sh) {
		// TODO Auto-generated method stub
		sharesData.delSharesOut(sh);
	}

	public void delSharesPrice(int sh) {
		// TODO Auto-generated method stub
		sharesData.delSharesPrice(sh);
	}

	public void upEarlyWarning(ShSharesInfo sh) {
		// TODO Auto-generated method stub
		sharesData.upEarlyWarning(sh);
	}

	public void upEquity(ShSharesInfo sh) {
		// TODO Auto-generated method stub
		sharesData.upEquity(sh);
	}

	public void upShares(ShSharesInfo sh) {
		// TODO Auto-generated method stub
		sharesData.upShares(sh);
	}

	public void upSharesIn(ShSharesIn sh) {
		// TODO Auto-generated method stub
		sharesData.upSharesIn(sh);
	}

	public void upSharesOut(ShSharesOut sh) {
		// TODO Auto-generated method stub
		sharesData.upSharesOut(sh);
	}

	public void upSharesPrice(ShSharesPrice sh) {
		// TODO Auto-generated method stub
		sharesData.upSharesPrice(sh);
	}

	public List<ShSharesInfo> isGetShares(int sh) {
		// TODO Auto-generated method stub
		return sharesData.isGetShares(sh);
	}

	public List<ShSharesIn> isGetGupiaolishi(int sh) {
		// TODO Auto-generated method stub
		return sharesData.isGetGupiaolishi(sh);
	}

	public List<ShSharesOut> isGetZhuanrang(int sh) {
		// TODO Auto-generated method stub
		return sharesData.isGetZhuanrang(sh);
	}
}
