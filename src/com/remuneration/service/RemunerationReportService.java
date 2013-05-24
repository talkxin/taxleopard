package com.remuneration.service;

import java.util.List;

import com.remuneration.entity.ReIsGetAllRemu;
import com.remuneration.entity.ReIsGetRemu;

public interface RemunerationReportService {

	/**
	 * 查询用户某作品某年的出版情况
	 * @param remu
	 * @return
	 */
	public List<ReIsGetRemu> findRe(ReIsGetRemu remu);
	/**
	 * 查询用户在某出版社某个作品的出版信息
	 * @param remu
	 * @return
	 */
	public List<ReIsGetRemu> findReByPress(ReIsGetRemu remu);
	/**
	 * 查询用户所有作品某年的出版情况
	 * @param remu
	 * @return
	 */
	public List<ReIsGetAllRemu> findAllRe(ReIsGetAllRemu remu);
}
