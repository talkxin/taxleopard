package com.donation.dwr;

import com.donation.service.DonationService;

public class DonationDwr {
	private DonationService donationService;

	public DonationService getDonationService() {
		return donationService;
	}

	public void setDonationService(DonationService donationService) {
		this.donationService = donationService;
	}
}
