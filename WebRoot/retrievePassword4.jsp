<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<base href="<%=basePath%>">
		<title>找回密码</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/layout.css" rel="stylesheet" type="text/css" />
		<SCRIPT type="text/javascript">
	function find() {
		document.getElementById("form").submit();
	}
</SCRIPT>
	</head>
	<body id="page1">
		<div class="splash">
			<div id="header" style="height: 480px">
				fore<%@include file="/homePage/top.jsp"%>
				<div class="row-2">
					<div class="slogan"
						style="top: 80px; width: 1024px; border-color: #a3a3a3; border-width: 5px;">
						<b>找回税豹密码： <img src="images/retrievePassword3.png"
								style="margin-top: -5px;" /> </b>
						<br />
						<form action="updPassWord" method="post" id="form">
							<div style="width: 400px; margin-left: 312px; margin-top: 60px;"
								align="center">
								<p>
									输入编码：
									<input />
								</p>
								<hr />
								<p style="margin-top: 10px">
									输入密码：
									<input type="password" name="taxPayer.taxPassWord" />
									<input type="hidden" value="<s:property value="#id"/>"
										name="id" />
									<br />
								</p>
								<p style="margin-top: 10px">
									重复密码：
									<input type="password" name="truePassWord" />
									<br />
								</p>
								<p style="margin-left: 100px;">
									<a href="javascript:find();"><img src="images/retrieve.png"
											width="150px" /> </a>
								</p>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div id="footer">
				<%@include file="/homePage/footer.jsp"%>
			</div>
		</div>
	</body>
	<s:debug></s:debug>
</html>
