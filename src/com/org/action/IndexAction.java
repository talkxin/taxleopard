package com.org.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.Press;
import com.org.service.PressService;

@SuppressWarnings("serial")
public class IndexAction extends ActionSupport {
	/*
	 * Spring注入
	 * 引入开始：首先引入首页新闻
	 * 其次引入：最新应用Tax leopard热点 
	 * 最后引入：欢迎
	 * 动态图片路径等等
	 * */
	private PressService pressService;
	public PressService getPressService() {
		return pressService;
	}
	public void setPressService(PressService pressService) {
		this.pressService = pressService;
	}
	/*
	 * 引入值栈内容列
	 * 网站新闻 最新应用 Tax leopard 热点
	 * 欢迎
	 * 动态图片路径
	 * */
	private List<Press> pressList=new ArrayList<Press>();
	
	public List<Press> getPressList() {
		return pressList;
	}
	public void setPressList(List<Press> pressList) {
		this.pressList = pressList;
	}
	
	public String index(){
		try {
			this.pressList=pressService.selectNewIndex();
			System.out.println(this.pressList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	

}
