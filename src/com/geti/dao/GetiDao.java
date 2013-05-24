package com.geti.dao;

import java.sql.SQLException;

import com.geti.entity.GtGetigongshang;

public interface GetiDao {
	public void addGetti(GtGetigongshang gt) throws SQLException;
	public void upGetti(GtGetigongshang gt) throws SQLException;
	public void delGetti(int gt) throws SQLException;
}
