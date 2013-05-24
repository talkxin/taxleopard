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

		<title>My JSP 'findPress.jsp' starting page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="/TaxPersonalReporting1.0/css/style_1.css" rel="stylesheet" type="text/css" />
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
					href="loginMain.jsp">个人首页|</a><a href="index">税豹主页|</a>
			</div>

		</div>
		<!--main-->
		<div id="main">
			<div class="main1">
				<div class="main1-1">
				<form action="find/pageFind" method="post">
					<input name="press.pages" type="hidden" value="1">
					<input name="title" type="text" class="search" value="新闻搜索"
						onblur="if(this.value==''){this.value='新闻搜索'}"
						onfocus="if(this.value=='新闻搜索'){this.value=''}" />
					&nbsp;
					<input type="submit" value="新闻搜索" />
				</form>
				</div>
			</div>
			<div class="main2">
				<div class="main3">
					<ul class="main3-1">
						<s:iterator value="#list" var="item">
							<li>
								<span class="main3-2"><a href="find/findPressByID?pressID=<s:property value="#item.pressID"/>"><s:property
											value="#item.pressTitle" />&nbsp;&nbsp;<s:property
											value="#item.pressDate" /> </a> </span>
								<br />
								<s:property value="#item.pressIntercept" />
								<a href="find/findPressByID?pressID=<s:property value="#item.pressID"/>">
									[详情]</a>
							</li>
						</s:iterator>
						<li class="main3-3">
							<form action="find/pageFind">
								<a href="find/pageFind?press.pages=1">首页</a>
								<a
									href="find/pageUp?press.pages=<s:property value="press.pages"/>&title=<s:property value="title" />">上一页</a>
								<a
									href="find/pageDown?press.pages=<s:property value="press.pages"/>&title=<s:property value="title" />">下一页</a>
								<a
									href="find/pageFind?press.pages=<s:property value="press.pageCount" />&title=<s:property value="title" />">尾页</a>

								<input style="width: 20;" type="text" name="press.pages" />
								<input value="GO" type="submit" />

								当前是第
								<s:property value="press.pages" />
								页 共
								<s:property value="press.pageCount" />
								页 共
								<s:property value="press.recordCount" />
								条
							</form>
						</li>
					</ul>
				</div>
			</div>
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
				<a href="#"><img src="images/images1/icon-facebook.jpg" alt=""
						border="0" /> </a>
				<a href="#"><img src="images/images1/icon-myspace.jpg" alt=""
						border="0" /> </a>
				<a href="#"><img src="images/images1/icon-flickr.jpg" alt=""
						border="0" /> </a>
				<a href="#"><img src="images/images1/icon-twitter.jpg" alt=""
						border="0" /> </a>
			</div>
			<div class="footer4-2">
				City Business &copy; 2011 &nbsp;北京赛克尚诚科技有限公司
			</div>
		</div>
	</body>
</html>
