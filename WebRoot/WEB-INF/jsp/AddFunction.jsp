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

		<title>My JSP 'AddFunction.jsp' starting page</title>

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
		<form action="add/addFunction" method="post">
			<table>
				<tr>
					<td>
						功能名称
					</td>
					<td>
						<input type="text" name="function.functionName" />
					</td>
				</tr>
				<tr>
					<td>
						所属功能
					</td>
					<td>
						<input type="text" name="function.functionReside" />
					</td>
				</tr>
				<tr>
					<td>
						功能连接
					</td>
					<td>
						<select name="function.functionLink">
							<option value="1">
								是
							</option>
							<option value="0">
								否
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						停用与否
					</td>
					<td>
						<select name="function.functionWhether">
							<option value="1">
								是
							</option>
							<option value="0">
								否
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						功能描述
					</td>
					<td>
						<input type="text" name="function.functionBewrite" />
					</td>
				</tr>
				<tr>
					<td>
						功能图片
					</td>
					<td>
						<input type="text" name="function.functionImages" />
					</td>
				</tr>
				<tr>
					<td>
						收费情况
					</td>
					<td>
						<input type="text" name="function.functionCharge" />
					</td>
				</tr>
				<tr>
					<td>
						基本功能
					</td>
					<td>
						<input type="text" name="function.functionBasic" />
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
