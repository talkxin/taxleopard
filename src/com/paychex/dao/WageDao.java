package com.paychex.dao;
import java.util.HashMap;
import java.util.List;
public interface WageDao<T> {

	public List<T> find(T t);
	public T findSingle(T t);
	public String findMap(Integer uid,String year,String zsybx);
	public String findMonthMap(Integer uid,String month,String sybx);
}
