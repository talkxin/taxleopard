package com.donation.dao;

import java.util.List;

import com.donation.entity.JzIsGetDonation;
public interface DonationReportDao {

	/**
	 * 查询用户某个捐赠的详细信息
	 * @param isOccasional
	 */
    public List<JzIsGetDonation> find(JzIsGetDonation isDo);
}
