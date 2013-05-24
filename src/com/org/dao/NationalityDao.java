package com.org.dao;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.Nationality;

public interface NationalityDao {
	public List<Nationality> selectAllNationality() throws SQLException;
	public Nationality selectNationalityByID(int nationalityID) throws SQLException;
	public void insertNationality(Nationality nationality) throws SQLException;
	public void deleteNationality(int nationalityID) throws SQLException;
	public void updateNationality(Nationality nationality) throws SQLException;
}
