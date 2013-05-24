package com.Util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.entity.TaxPayer;
/**粗粒度权限控制*/
public class PrivilegeFilter implements Filter {
	public void destroy() {
		

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest request=(HttpServletRequest)req;
		 HttpServletResponse response=(HttpServletResponse)resp;
		 TaxPayer t=(TaxPayer)request.getSession().getAttribute("taxPayer");
         if(t==null){
        	 response.sendRedirect("/TaxPersonalReporting1.0/index");
        	 return;
         }
         chain.doFilter(req, resp);

	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
