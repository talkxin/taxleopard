package com.org.entity;

public enum MumoFlag {

	SINGLE{public String getName(){return "单次";} },
	EVERYDAY{public String getName(){return "每天";} },
	EVERYWEEK{public String getName(){return "每周";} },
	EVERYMONTH{public String getName(){return "每月";} },
	EVERYYEAR{public String getName(){return "每年";}};
	public abstract String getName();
}
