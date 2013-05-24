package com.labor.dao;

import java.util.List;

public interface LaborReportDao<T>{

	public List<T> find(T t);
}
