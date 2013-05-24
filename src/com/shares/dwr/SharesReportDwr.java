package com.shares.dwr;

import java.util.List;

import com.shares.entity.ShIsGetFirstShare;
import com.shares.entity.ShIsGetShareIn;
import com.shares.entity.ShIsGetShareOut;
import com.shares.service.SharesReportService;

public class SharesReportDwr {

	private SharesReportService sharesReportService;

	public SharesReportService getSharesReportService() {
		return sharesReportService;
	}

	public void setSharesReportService(SharesReportService sharesReportService) {
		this.sharesReportService = sharesReportService;
	}
	/**
	 * 查询用户某股票的首次添加信息
	 *
	 * @return
	 */
	public ShIsGetFirstShare findFirstDwr(Integer uid,Integer sid){
		ShIsGetFirstShare sinfo=new ShIsGetFirstShare();
		sinfo.setUid(uid);
		sinfo.setSid(sid);
		return sharesReportService.findFirst(sinfo);
    }
	/**
	 * 查询用户某股票及股权的追加信息
	 * 
	 * @return
	 */
	public List<ShIsGetShareIn> findInDwr(Integer uid,Integer sid){
		ShIsGetShareIn sin=new ShIsGetShareIn();
		sin.setUid(uid);
		sin.setSid(sid);
		return sharesReportService.findIn(sin);
	}
	/**
	 * 查询用户某股票及股权的转让信息
	 * 
	 * @return
	 */
	public List<ShIsGetShareOut> findOutDwr(Integer uid,Integer sid){
		ShIsGetShareOut sout=new ShIsGetShareOut();
		sout.setUid(uid);
		sout.setSid(sid);
		return sharesReportService.findOut(sout);
	}
	/**
	 * 查询用户所有股票首次添加信息
	 * @param sinfo
	 * @return
	 */
	public List<ShIsGetFirstShare> findFullFirstDwr(Integer uid){
		ShIsGetFirstShare sinfo=new ShIsGetFirstShare();
		sinfo.setUid(uid);
		return sharesReportService.findFullFirst(sinfo);
	}
}
