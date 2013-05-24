package com.savings.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.org.entity.TaxPayer;

public class SavingsAction {
	public String goMain() {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		TaxPayer tr = (TaxPayer) session.get("taxPayer");
		if (tr == null)
			return "LoginEcho";
		else
			return "tomain";
	}
}
