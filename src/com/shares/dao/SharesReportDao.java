package com.shares.dao;



import java.util.List;

import com.shares.entity.ShIsGetFirstShare;
import com.shares.entity.ShIsGetShareIn;
import com.shares.entity.ShIsGetShareOut;
import com.shares.entity.ShSharesInfo;

public interface SharesReportDao {

	/**
	 * 查询用户某股票的首次添加信息
	 * @param sinfo
	 * @return
	 */
	public ShIsGetFirstShare findFirst(ShIsGetFirstShare sinfo);
	/**
	 * 查询用户某股票及股权的追加信息
	 * @param sin
	 * @return
	 */
	public List<ShIsGetShareIn> findIn(ShIsGetShareIn sin);
	/**
	 * 查询用户某股票及股权的转让信息
	 * @param sout
	 * @return
	 */
	public List<ShIsGetShareOut> findOut(ShIsGetShareOut sout);
	
	/**
	 * 查询用户所有股票首次添加信息
	 * @param sinfo
	 * @return
	 */
	public List<ShIsGetFirstShare> findFullFirst(ShIsGetFirstShare sinfo);
}
