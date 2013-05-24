package com.remuneration.dao;

import java.util.List;

import com.remuneration.entity.RePressType;
import com.remuneration.entity.RePublish;
import com.remuneration.entity.ReRemunerationInfo;

public interface RemunerationDataDao {
	/**\
	 * 增加作品信息
	 * @param re
	 */
	public ReRemunerationInfo addRemunerationInfo(ReRemunerationInfo re);
	/**
	 * 修改作品信息
	 * @param re
	 */
	public void upRemunerationInfo(ReRemunerationInfo re);
	/**
	 * 删除作品信息
	 * @param re
	 */
	public void delRemunerationInfo(int re);
	/**
	 * 添加出版社
	 * @param re
	 * @return
	 */
	public RePressType addRePressType(RePressType re);
	/**
	 * 修改出版社
	 * @param re
	 */
	public void upRePressType(RePressType re);
	/**
	 * 删除出版社
	 * @param re
	 */
	public void delRePressType(int re);
	/**
	 * 增加稿酬信息
	 * @param re
	 * @return
	 */
	public void addRePublish(RePublish re);
	/**
	 * 修改稿酬信息
	 * @param re
	 */
	public void upRePublish(RePublish re);
	/**
	 * 删除稿酬信息
	 * @param re
	 */
	public void delRePublish(int re);
	/**
	 * 返回用户所有的作品
	 * @param re
	 * @return
	 */
	public List<ReRemunerationInfo> isGetReRemunerationInfo(int re);
	/**
	 * 返回当前作品的出版社
	 * @param re
	 * @return
	 */
	public List<RePressType> isGetRePressType(int re);
	/**
	 * 返回用户添加的所有出版社
	 * @param re
	 * @return
	 */
	public List<RePressType> isGetAllRePressType(int re);
}
