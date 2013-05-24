package com.org.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.Press;
import com.org.service.PressService;

@SuppressWarnings("serial")
public class PressAction extends ActionSupport {
	private Press press;
	private PressService pressService;
	private int pressID;


	public int getPressID() {
		return pressID;
	}

	public void setPressID(int pressID) {
		this.pressID = pressID;
	}

	public Press getPress() {
		return press;
	}

	public void setPress(Press press) {
		this.press = press;
	}

	public PressService getPressService() {
		return pressService;
	}

	public void setPressService(PressService pressService) {
		this.pressService = pressService;
	}

	/**
	 * 添加新闻
	 * */
	public String addPress() throws Exception {
		press.setPressIntercept(str(press.getPressContent()));
		System.out.println("++++++++++++++" + press.getPressIntercept());
		pressService.addPress(press);
		return "addPressSuccess";
	}

	/***
	 * 查询新闻
	 * */
	public String findPress() throws Exception {
		List<Press> list = pressService.findPress();
		if (list.size() > 0) {
			ActionContext.getContext().put("list", list);
			return "findPressSuccess";
		} else {
			return "findPressError";
		}
	}

	private String upPress;
	private String nextPress;
	public String getUpPress() {
		return upPress;
	}
	public void setUpPress(String upPress) {
		this.upPress = upPress;
	}
	public String getNextPress() {
		return nextPress;
	}
	public void setNextPress(String nextPress) {
		this.nextPress = nextPress;
	}

	/**
	 * 根据ID查询新闻
	 * */
	public String findPressByID() throws Exception {
		press = pressService.findPressByID(pressID);
		String str = str1(press.getPressContent());
		if (press != null) {
			Press upPressOb=pressService.findUpPress(press.getPressID());
			Press nextPressOb=pressService.findNextPress(press.getPressID());
			upPress=upPressOb==null?"":upPressOb.getPressTitle();
			nextPress=nextPressOb==null?"":nextPressOb.getPressTitle();
			ActionContext.getContext().put("str", str);
			ActionContext.getContext().put("press", press);
			return "findPressByIDSuccess";
		} else {
			return "findPressByIDError";
		}
	}

	/**
	 * 上一篇
	 * */
	public String findUpPress() throws Exception {
		press = pressService.findUpPress(pressID);
		if (press == null) {
			return findPressByID();
		} else {
			Press upPressOb=pressService.findUpPress(press.getPressID());
			Press nextPressOb=pressService.findNextPress(press.getPressID());
			upPress=upPressOb==null?"":upPressOb.getPressTitle();
			nextPress=nextPressOb==null?"":nextPressOb.getPressTitle();
			String str = str1(press.getPressContent());
			ActionContext.getContext().put("str", str);
			ActionContext.getContext().put("press", press);
			return "findUpPressSuccess";

		}
	}

	/***
	 * 下一篇
	 * */
	public String findNextPress() throws Exception {
		press = pressService.findNextPress(pressID);
		String str = str1(press.getPressContent());
		if (press == null) {
			return findPressByID();
		} else {
			Press upPressOb=pressService.findUpPress(press.getPressID());
			Press nextPressOb=pressService.findNextPress(press.getPressID());
			upPress=upPressOb==null?"":upPressOb.getPressTitle();
			nextPress=nextPressOb==null?"":nextPressOb.getPressTitle();
			ActionContext.getContext().put("str", str);
			ActionContext.getContext().put("press", press);
			return "findNextPressSuccess";
		}
	}

	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		System.out.println(title);
		this.title = title;
	}

	/**
	 * 分页
	 * */
	public String pageFind() throws Exception {
		List<Press> list = new ArrayList<Press>();
		press.setRecordCount(pressService.recordCount("%"+((title==null?"":title).equals("新闻搜索")?"":title)+"%"));
		press.setPageCount(pageCount(press.getRecordCount(), 10));
		press.setPressTitle("%"+((title==null?"":title).equals("新闻搜索")?"":title)+"%");
		if (press.getPages() > press.getPageCount()) {
			return "findPageError";
		} else if (press.getPages() < 0) {
			return "findPageError";
		} else {
			list = pressService.findPage(press);
			System.out.println(list.size());
			if (list.size() > 0) {
				ActionContext.getContext().put("list", list);
				return "findPageSuccess";
			} else {
				return "findPageError";
			}
		}
	}

	/***
	 * 上一页
	 * */
	public String pageUp() throws Exception {
		List<Press> list = new ArrayList<Press>();
		press.setRecordCount(pressService.recordCount("%"+((title==null?"":title).equals("新闻搜索")?"":title)+"%"));
		press.setPageCount(pageCount(press.getRecordCount(), 10));
		press.setPressTitle("%"+((title==null?"":title).equals("新闻搜索")?"":title)+"%");
		if (press.getPages() == 1) {
			list = pressService.findPage(press);
			if (list.size() > 0) {
				ActionContext.getContext().put("list", list);
				return "findPageSuccess";
			} else {
				return "findPageError";
			}
		} else {
			press.setPages(press.getPages() - 1);
			list = pressService.findPage(press);
			if (list.size() > 0) {
				ActionContext.getContext().put("list", list);
				return "findPageSuccess";
			} else {
				return "findPageError";
			}

		}
	}

	/***
	 * 下一页
	 * */
	public String pageDown() throws Exception {
		List<Press> list = new ArrayList<Press>();
		if (press.getPages() < press.getPageCount()) {
			press.setPages(press.getPages() + 1);
			press.setRecordCount(pressService.recordCount("%"+((title==null?"":title).equals("新闻搜索")?"":title)+"%"));
			press.setPageCount(pageCount(press.getRecordCount(), 10));
			press.setPressTitle("%"+((title==null?"":title).equals("新闻搜索")?"":title)+"%");
			list = pressService.findPage(press);
			if (list.size() > 0) {
				ActionContext.getContext().put("list", list);
				return "findPageSuccess";
			} else {
				return "findPageError";
			}
		} else if (press.getPages() == press.getPageCount()) {
			list = pressService.findPage(press);
			if (list.size() > 0) {
				ActionContext.getContext().put("list", list);
				return "findPageSuccess";
			} else {
				return "findPageError";
			}
		} else {
			return "findPageError";
		}
	}

	/***
	 * 截取字符串
	 * */
	public static String str(String title) {
		StringBuffer sb = new StringBuffer(title);
		return sb.substring(0, 20);
	}

	/**
	 * 截取标头
	 * */
	public static String str1(String title) {
		StringBuffer sb = new StringBuffer(title);
		int result = sb.indexOf(")");
		return sb.substring(1, result);
	}

	/**
	 * 计算总页数
	 * */
	public static int pageCount(int recordCount, int pageSize) {
		return (recordCount + pageSize - 1) / pageSize;
	}
	public String pageSelectNewIndex(){
		List<Press> list = new ArrayList<Press>();
		try {
			list=pressService.selectNewIndex();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ActionContext.getContext().put("list", list);
		return "selectNewIndex";
	}
	
}
