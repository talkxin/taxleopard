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

		<title>My JSP 'addDuty.jsp' starting page</title>

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
		<form action="addDuty" method="post">
			<table>
				<tr>
					<td>
						税项名称
					</td>
					<td>
						<input type="text" name="duty.dutyName" />
					</td>
				</tr>
				<tr>
					<td>
						税率
					</td>
					<td>
						<input type="text" name="duty.dutyCess" />
					</td>
				</tr>
				<tr>
					<td>
						速算扣除数
					</td>
					<td>
						<input type="text" name="duty.dutyQuick" />
					</td>
				</tr>
				<tr>
					<td>
						含税
					</td>
					<td>
						<input type="text" name="duty.dutyPrice" />
					</td>
				</tr>
				<tr>
					<td>
						不含税
					</td>
					<td>
						<input type="text" name="duty.dutySales" />
					</td>
				</tr>
				<tr>
					<td>
						公式
					</td>
					<td>
						<select name="duty.fuormulaID">
							<option value="1">
								aaa
							</option>
							<option value="2">
								aaa
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						税模块
					</td>
					<td>
						<select name="duty.dutysID">
							<option value="1">
								aaa
							</option>
							<option value="2">
								aaa
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="提交" />
					</td>
				</tr>
			</table>
		</form>
	</body>
	<s:debug></s:debug>
</html>
