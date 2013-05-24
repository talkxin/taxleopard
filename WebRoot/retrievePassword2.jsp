<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'retrievePassword5.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/layout.css" rel="stylesheet" type="text/css" />
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<body id="page1">
		<div class="splash">
			<div id="header" style="height: 480px">
				<%@include file="/homePage/top.jsp"%>
				<div class="row-2">
					<div class="slogan"
						style="top: 80px; width: 1024px; border-color: #a3a3a3; border-width: 5px;">
						<b>找回税豹密码： <img src="images/retrievePassword2.png"
								style="margin-top: -5px;" /> </b>
						<br />
						<div
							style="width: 700px; margin-left: 150px; margin-top: 60px; color: #a3a3a3;">
							请选择找回方式：
							<div style="width: 100%;">
								<table width="100%" align="center">
									<tr>
										<td width="50%" align="center">
											<a href="skipTaxPayer?taxID=<s:property value='#tx.taxID'/>"><img
													src="images/phone.png" /> </a>
										</td>
										<td width="50%" align="center">
											<a href="retrievePassword4.jsp"><img
													src="images/phone2.png" width="112" /> </a>
										</td>
									</tr>
									<tr>
										<td>
											通过问题找回：
											<br />
											三个初设密码问题及答案只要答对一个便可以找回密码， 如果三次答不对。就需要回答所有问题才能对密码进行修改。
											否则你没有权利修改密码。
										</td>
										<td>
											通过邮箱找回：
											<br />
											需要选择邮箱进行下一步操作。点击邮箱后会发一封验证 码数字到邮箱中，在1个小时内完成找回操作，否则问题过期
											需要重新获取。然后进行操作。
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="footer">
				<%@include file="/homePage/footer.jsp"%>
			</div>
		</div>
		<s:debug></s:debug>
	</body>
</html>
