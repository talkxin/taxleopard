package com.geti.service;

import java.sql.SQLException;

import com.geti.entity.GtGetigongshang;

public interface GetiService {
	public void addGetti(GtGetigongshang gt) throws SQLException;
	public void upGetti(GtGetigongshang gt) throws SQLException;
	public void delGetti(int gt) throws SQLException;
}
