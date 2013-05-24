package com.org.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.org.entity.TaxPayer;

public class PersonalPageAction {
	public String personalMain(){
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		TaxPayer tr=(TaxPayer) session.get("taxPayer");
		if(tr==null)
			return "LoginEcho";
		else
			return "toPersonal";
	}
}
