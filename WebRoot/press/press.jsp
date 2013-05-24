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

		<title>My JSP 'press.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta content="text/html;charset=UTF-8" http-equiv="Content-Type">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="/TaxPersonalReporting1.0/css/style_2.css" rel="stylesheet" type="text/css" />

		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<!--header-->
		<div id="header">
			<div class="line1">
				新闻中心
			</div>
			<div class="line2">
				<a href="#">关于税豹|</a><a href="#">安全性|</a><a href="#">最新推荐|</a><a
					href="#">个人首页|</a><a href="index">税豹主页|</a>
			</div>
		</div>
		<!--main-->
		<div id="main">

			<div class="main1">
				<a href="http://localhost:8080/TaxPersonalReporting1.0/find/pageFind?press.pages=1">新闻中心</a> >新闻正文
			</div>
			<div class="main2">
			</div>
			<div class="main3">
				<div class="main3-1">
					<h4 align="center">
						<s:property value="#press.pressTitle" />
					</h4>
					<h5 align="center">
						<s:property value="#press.pressDate" />
						&nbsp;&nbsp;&nbsp;
						<s:property value="#str" />
					</h5>
					<s:property value="#press.pressContent" />
				</div>
			</div>
			<s:if test="''!=nextPress">
			<a href="find/findNextPress?pressID=<s:property value="#press.pressID" />" style="font-size: 12px;">上一篇:<s:property value="nextPress" /></a>
			</s:if>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<s:if test="''!=upPress">
			<a href="find/findUpPress?pressID=<s:property value="#press.pressID" />" style="font-size: 12px;">下一篇:<s:property value="upPress" /></a>
			</s:if>
		</div>
		<!--footer-->
		<div id="footer">
			<div class="footer1"></div>
			<div class="footer2">
				<ul class="footer2-1">
					<li>
						<a href="aboutMe/zhaoxiannashi.html">招贤纳士 |</a>
					</li>
					<li>
						<a href="aboutMe/guanggaofuwu.html">广告服务 |</a>
					</li>
					<li>
						<a href="aboutMe/lianxifangshi.html">联系方式 |</a>
					</li>
					<li>
						<a href="aboutMe/banquanshengming.html">版权声明 |</a>
					</li>
					<li>
						<a href="aboutMe/falvguwen.html">法律顾问 |</a>
					</li>
					<li>
						<a href="aboutMe/wentibaogao.html">问题报告 </a>
					</li>
				</ul>
			</div>
			<div class="footer3">
				<ul class="footer3-1">
					<li>
						<a href="#">客服电话:010-62121399 |</a>
					</li>
					<li>
						<a href="#">北京朝阳区嘉美中心写字楼1021 |</a>
					</li>
					<li>
						<a href="#">客服信箱:aobsoft@126.com </a>
					</li>
				</ul>
			</div>
			<div class="footer4">
				<a href="#"><img src="/TaxPersonalReporting1.0/images/images2/icon-facebook.jpg" alt=""
						border="0" /> </a>
				<a href="#"><img src="images/images2/icon-myspace.jpg" alt=""
						border="0" /> </a>
				<a href="#"><img src="images/images2/icon-flickr.jpg" alt=""
						border="0" /> </a>
				<a href="#"><img src="images/images2/icon-twitter.jpg" alt=""
						border="0" /> </a>
			</div>
			<div class="footer4-2">
				City Business &copy; 2011 &nbsp;北京赛克尚诚科技有限公司
			</div>
		</div>
	</body>
</html>
