package com.paychex.action;

import com.opensymphony.xwork2.ActionSupport;

public class WageReportAction extends ActionSupport {
    private static final long serialVersionUID = -6257866114383329182L;
    /***
     * 数据录入页
     * */
    public String toDataEntry(){
    	return "toDataEntry";
    }
    /***
     * 月文字报表
     * */
    public String toMonthWritten(){
    	return "toMonthWritten";
    }
    /***
     * 年文字报表
     * */
    public String toYearWritten(){
    	return "toYearWritten";
    }
    /***
     * 饼状图
     * */
    public String toMonthPie(){
    	return "toMonthPie";
    }
    /***
     * 柱状图
     * */
    public String toMonthHg(){
    	return "toMonthHg";
    }
    /***
     * 年饼状图
     * */
    public String toYearPie(){
    	return "toYearPie";
    }
    /***
     * 年柱状图
     * */
    public String toYearHg(){
    	return "toYearHg";
    }
}
