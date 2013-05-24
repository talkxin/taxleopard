<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

		<title>My JSP 'findDuty.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<form action="find/findDuty">
			<table>
				<tr>
					<td>
						税项名称
					</td>
					<td>
						税率
					</td>
					<td>
						速算扣除数
					</td>
					<td>
						含税
					</td>
					<td>
						不含税
					</td>
					<td>
						公式编号
					</td>
					<td>
						税模块编号
					</td>
					<td>
						操作
					</td>
				</tr>
				<s:iterator value="#list" var="item">
					<tr>
						<td>
							<s:property value="#item.dutyName" />
						</td>
						<td>
							<s:property value="#item.dutyName" />
						</td>
						<td>
							<s:property value="#item.dutyName" />
						</td>
						<td>
							<s:property value="#item.dutyName" />
						</td>
						<td>
							<s:property value="#item.dutyName" />
						</td>
						<td>
							<s:property value="#item.dutyName" />
						</td>
						<td>
							<s:property value="#item.dutyName" />
						</td>
						<td>
							<a href="del/delDuty?dutyID=<s:property value="#item.dutyID" />">删除</a>
							<a href="">更改</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</form>
	</body>
</html>
