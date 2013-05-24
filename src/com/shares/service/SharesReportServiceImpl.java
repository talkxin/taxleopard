package com.shares.service;

import java.util.List;

import com.shares.dao.SharesReportDao;
import com.shares.entity.ShIsGetFirstShare;
import com.shares.entity.ShIsGetShareIn;
import com.shares.entity.ShIsGetShareOut;

public class SharesReportServiceImpl implements SharesReportService{

	private SharesReportDao sharesReportDao;
	
	public SharesReportDao getSharesReportDao() {
		return sharesReportDao;
	}

	public void setSharesReportDao(SharesReportDao sharesReportDao) {
		this.sharesReportDao = sharesReportDao;
	}

	public ShIsGetFirstShare findFirst(ShIsGetFirstShare sinfo) {
        return sharesReportDao.findFirst(sinfo);
	}

	public List<ShIsGetShareIn> findIn(ShIsGetShareIn sin) {
        return sharesReportDao.findIn(sin);
	}

	public List<ShIsGetShareOut> findOut(ShIsGetShareOut sout) {
        return sharesReportDao.findOut(sout);
	}

	public List<ShIsGetFirstShare> findFullFirst(ShIsGetFirstShare sinfo) {
		
		return sharesReportDao.findFullFirst(sinfo);
	}

}
