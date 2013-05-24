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
		<SCRIPT type="text/javascript">
	function find() {
		document.getElementById("findMatter").submit();
	}
</SCRIPT>
	</head>

	<body id="page1">
		<div class="splash">
			<div id="header" style="height: 480px">
				<%@include file="/homePage/top.jsp"%>
				<div class="row-2">
					<div class="slogan"
						style="top: 80px; width: 1024px; border-color: #a3a3a3; border-width: 5px;">
						<b>找回税豹密码： <img src="images/retrievePassword3.png"
								style="margin-top: -5px;" /> </b>
						<br />
						<form action="findResult.action" method="post"
							id="findMatter">
							<div style="width: 400px; margin-left: 312px; margin-top: 60px;"
								align="center">
								<p style="padding-right: 25px">
									选择问题：
									<select name="Matter">
										<option selected="selected">
											--请选择--
										</option>
										<s:iterator value="#mlist" var="item">
											<option>
												<s:property value="#item.matter" />
											</option>
										</s:iterator>
									</select>
								</p>
								<p style="margin-left: 30px">
									答案：
									<input type="text" name="Result" />
									<br />
								</p>
								<hr />
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
