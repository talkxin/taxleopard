package com.org.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class VerifyResult extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String validateC = ((String) request.getSession().getAttribute("rand")).toLowerCase();//session中的验证码
		System.out.println(validateC);
		String veryCode = (request.getParameter("c")).toLowerCase();//用户输入的验证码，这里接收参数的时候注意中文的乱码问题
		System.out.println(veryCode);
		PrintWriter out = response.getWriter();
		out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.print("<TY>");
		if (veryCode != null) {
			if (validateC.equals(veryCode)) {
				request.getSession().setAttribute("verifyResult", true);
				System.out.println(request.getSession().getAttribute("verifyResult"));
				out.println("<name>验证码正确</name><value>true</value>");
			} else {
				request.getSession().setAttribute("verifyResult", false);
				out.println("<name>验证码错误</name><value>false</value>");
			}
		} else {
			request.getSession().setAttribute("verifyResult", false);
			out.println("<name>验证码错误</name><value>false</value>");
		}
		out.print("</TY>");
		request.getSession().setAttribute("rand", null);
		out.flush();
		out.close();
	}

}