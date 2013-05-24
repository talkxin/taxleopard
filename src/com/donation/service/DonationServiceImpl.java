package com.donation.service;

import java.sql.SQLException;

import com.donation.dao.DonationDao;
import com.donation.entity.JzDonationInfo;

public class DonationServiceImpl implements DonationService{
	private DonationDao donationDao;
	public DonationDao getDonationDao() {
		return donationDao;
	}

	public void setDonationDao(DonationDao donationDao) {
		this.donationDao = donationDao;
	}

	public JzDonationInfo addDonation(JzDonationInfo donationInfo)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void upDonation(JzDonationInfo donationInfo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void delDonation(JzDonationInfo donationInfo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
