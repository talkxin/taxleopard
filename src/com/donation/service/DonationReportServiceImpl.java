package com.donation.service;

import java.util.List;

import com.donation.dao.DonationReportDao;
import com.donation.entity.JzIsGetDonation;

public class DonationReportServiceImpl implements DonationReportService{

	private DonationReportDao donationReportDao;
	
	public DonationReportDao getDonationReportDao() {
		return donationReportDao;
	}

	public void setDonationReportDao(DonationReportDao donationReportDao) {
		this.donationReportDao = donationReportDao;
	}

	public List<JzIsGetDonation> find(JzIsGetDonation isDo) {
		return donationReportDao.find(isDo);
	}
}
