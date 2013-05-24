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

		<title>My JSP 'List.jsp' starting page</title>

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
		<form action="">
			<table>
				<tr>
					<td>
						功能名称
					</td>
					<td>
						所属功能
					</td>
					<td>
						功能连接
					</td>
					<td>
						停用与否
					</td>
					<td>
						功能描述
					</td>
					<td>
						功能图片
					</td>
					<td>
						收费情况
					</td>
					<td>
						基本功能
					</td>
					<td>
						操作
					</td>
				</tr>
				<s:iterator value="#list" var="item">
					<tr>
						<td>
						<s:property value="#item.functionName"/>
						</td>
						<td>
						<s:property value="#item.functionName"/>
						</td>
						<td>
						<s:property value="#item.functionName"/>
						</td>
						<td>
						<s:property value="#item.functionName"/>
						</td>
						<td>
						<s:property value="#item.functionName"/>
						</td>
						<td>
						<s:property value="#item.functionName"/>
						</td>
						<td>
						<s:property value="#item.functionName"/>
						</td>
						<td>
						<s:property value="#item.functionID"/>
						</td>
						<td>
						<a href="del/delFunctions?functionID=<s:property value="#item.functionID"/>">删除</a>
						<a href="#">更改</a>
						</td>
					</tr>
				</s:iterator>
			</table>

		</form>

	</body>
</html>
