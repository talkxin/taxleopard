package com.contracting.dao;

import java.util.List;

import com.contracting.entity.ConIsGetContract;

public interface ContractingReportDao {

/***
 * 查询用户某个承包承租的详细信息
 * @param con
 * @return
 */

	public List<ConIsGetContract> findCon(ConIsGetContract con);
}
