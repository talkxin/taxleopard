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
import javax.servlet.http.HttpSession;

import com.org.entity.TaxPayer;

public class Login_Filter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}
	//匹配一通过项目开放文件
	//匹配二通过项目用户开放文件
	//匹配三通过管理员开放文件
	//文件配置文件<web-lock><open value=""/><userOpen value=""/><adminOpen value=""/></web-lock>
	//通过查询得到内容String path="/open[value="+value+"]";or String path="/userOpen[value="+value+"];String path="/adminOpen[value="+value+"];
	//普通页面映射通过映射查询得到对象不为空document.getXMLMapDocument("/open[value=值]")!=null通过else不通过
	//用户映射document.getXMLMapDocument("/userOpen[value=值]")!=null and Session Object != null
	//管理员映射document.getXMLMapDocument("/adminOpen[value=值]")!=null and Session Object !=null and Session userType=管理员
	//错误页面404 400 500 Exception NullPointerException ServletException 交由用户界面执行
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		//获取response
		HttpServletResponse response=(HttpServletResponse)arg1;
		//获取Session
		HttpSession session=request.getSession();
		//获取项目根路径
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		/**
		 * 获取session中储存的taxPayer值
		 */
		TaxPayer taxPayer=(TaxPayer)session.getAttribute("taxPayer");
		//获取访问路径
		String url=request.getRequestURI();
		int star=url.lastIndexOf("/")+1;
		String workName=url.substring(star);
		int typeStar=workName.lastIndexOf(".");
		String type="";//文件类型名
		if(typeStar!=-1){
			type=workName.substring(typeStar).toLowerCase();
		}
		if("html".equals(type)||"jsp".equals(type)||"".equals(type)||"action".equals(type)||"create".equals(type)){//如果是HTML,JSP,action,create进入
			if(LoginXMLMain.xmlDoucument.getXMLMapDocument(LoginXMLMain.path+workName+LoginXMLMain.down)!=null){//如果是浏览者身份的直接进入
				chain.doFilter(request, response);
				return;
			}
			if(taxPayer!=null){
				if(LoginXMLMain.xmlDoucument.getXMLMapDocument(LoginXMLMain.userPath+workName+LoginXMLMain.down)!=null){
					//VIP用户级别控制
					chain.doFilter(request, response);
					return;
				}
				if(LoginXMLMain.xmlDoucument.getXMLMapDocument(LoginXMLMain.adminPath+workName+LoginXMLMain.down)!=null&&"管理员".equals(taxPayer.getTaxPart())){
					chain.doFilter(request, response);
					return;
				}
			}else{
				response.sendRedirect(basePath+"loginMain.jsp");
				return;
			}
		}else{
			chain.doFilter(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
