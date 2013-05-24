package com.donation.dao;

import java.sql.SQLException;

import com.donation.entity.JzDonationInfo;
import com.house.entity.HpHouseInfo;

public interface DonationDao {
	/**
	 * 添加捐赠
	 * @param donationInfo
	 */
	public JzDonationInfo addDonation(JzDonationInfo donationInfo) throws SQLException;
	/**
	 * 修改捐赠
	 * @param donationInfo
	 */
	public void upDonation(JzDonationInfo donationInfo)throws SQLException;
	/**
	 * 删除捐赠
	 * @param donationInfo
	 */
	public void delDonation(JzDonationInfo donationInfo)throws SQLException;
}
