package com.org.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.dao.RecordOfWorkDao;
import com.org.entity.RecordOfWork;
import com.org.service.RecordOfWorkService;

public class RecordOfWorkServiceImpl implements RecordOfWorkService {
	private RecordOfWorkDao recordOfWorkDao;
	public RecordOfWorkDao getRecordOfWorkDao() {
		return recordOfWorkDao;
	}
	public void setRecordOfWorkDao(RecordOfWorkDao recordOfWorkDao) {
		this.recordOfWorkDao = recordOfWorkDao;
	}
	
	public void delete(Integer id) throws SQLException {
		this.recordOfWorkDao.delete(id);
	}

	public void insert(RecordOfWork recordOfWork) throws SQLException {
		this.recordOfWorkDao.insert(recordOfWork);
	}

	public List<RecordOfWork> selectAll(Integer userID) throws SQLException {
		return this.recordOfWorkDao.selectAll(userID);
	}

	public RecordOfWork selectByID(Integer id) throws SQLException {
		return this.recordOfWorkDao.selectByID(id);
	}

	public List<RecordOfWork> selectByTime(RecordOfWork recordOfWork) throws SQLException {
		return this.recordOfWorkDao.selectByTime(recordOfWork);
	}

	public void update(RecordOfWork recordOfWork) throws SQLException {
		this.recordOfWorkDao.update(recordOfWork);
	}
	
	//处理1
	//用户提醒机制写到JSP界面上用JS实现。
	//处理办法<script>function定时器：登录弹框提醒</script>定时器
	//实现效果弹框提醒
	//圆滑的JQuery弹框效果
	
	//处理2
	//用户的查看、修改或删除机制  AJAX 实现
	//处理办法JQuery的AJAX为了框架之间不起冲突 由于日志本身核心文件为JQuery编写
	//实现效果及时删除
	//页面实现鼠标点击弹出层进行查看 并有 修改 和 删除 按钮。
	
	//处理3
	//用户增加日志点击弹出层浮动。
	//采用JQuery AJAX技术实现。
	//及时更新到日志及后台。
	//鼠标点击边框空白处弹出增加层

}
