<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>My JSP 'addUserFunction.jsp' starting page</title>
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
		<form action="add/addUserFunction" method="post">
			<table>
				<tr>
					<td>
						<input type="checkbox" name="functionID" value="1" />
						e
					</td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="functionID" value="2" />
						a
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="functionID" value="3" />
						b
					</td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="functionID" value="4" />
						c
					</td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="functionID" value="5" />
						d
					</td>
					<td>
						<input type="hidden" name="userFunction.taxID" value="1" />
						<input type="text" name="date" />
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
</html>
