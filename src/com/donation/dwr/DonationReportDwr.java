package com.donation.dwr;

import java.util.List;

import com.donation.entity.JzIsGetDonation;
import com.donation.service.DonationReportService;

public class DonationReportDwr {

	private DonationReportService donationReportService;

	public DonationReportService getDonationReportService() {
		return donationReportService;
	}

	public void setDonationReportService(DonationReportService donationReportService) {
		this.donationReportService = donationReportService;
	}
	/**
	 * 查询用户某个捐赠的详细信息
	 * @param isOccasional
	 */
    public List<JzIsGetDonation> find(Integer uid,Integer dtid){
    	JzIsGetDonation isDo=new JzIsGetDonation();
    	isDo.setUid(uid);
    	isDo.setDtid(dtid);
    	return donationReportService.find(isDo);
    }
}
