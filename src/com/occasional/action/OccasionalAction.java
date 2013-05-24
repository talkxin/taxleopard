package com.occasional.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.TaxPayer;

public class OccasionalAction extends ActionSupport{

	public String occasionalMain(){
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		TaxPayer tr=(TaxPayer) session.get("taxPayer");
		if(tr==null)
			return "LoginEcho";
		else{
			return "toOccasionalmain";
		}
	}
}
