<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<title>Tax leopard --主页</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/layout.css" rel="stylesheet" type="text/css" />
		<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
		<script src="js/jquery.faded.js" type="text/javascript"></script>
		<script src="js/script.js" type="text/javascript"></script>
		<script src="js/verifyCode.js"  type="text/javascript"></script>
		<script type='text/javascript'>
		<!--
			document.oncontextmenu=new Function('event.returnValue=false;');
			document.onselectstart=new Function('event.returnValue=false;');
		-->
  		</script>
		<style>
/*=====footer =====*/
.footer li {
	
	color: #000000;
	float: left;

	list-style-type: none;
}
.footer li a {
	
	color: #000000;
}
.foot li {
	float: left;
	
	list-style-type: none;
	
}
#footer {
	background-color: #FFFFFF;
	font-family: "微软雅黑";
	font-size: 12px;
}</style>
	</head>
	<body id="page1">
		<div class="splash">
			<!-- header -->
			<div id="header">
				<%@include file="/homePage/top.jsp"%>
				<div class="row-2">
					<div class="container">
						<!-- .logo -->
						<div class="logo">
							<a href="#"><img src="images/logo.png" alt="" /> </a>
						</div>
						<!-- /.logo -->
					</div>
					<!-- .slider -->
					<%@include file="/homePage/imagesAll.jsp"%>
					<!-- /.slider -->
					<div class="clear"></div>
					<!-- .slogan -->
					<div class="slogan">
						<img src="images/slogan.png" alt=""/>
					</div>
					<!-- /.slogan -->
				</div>
			</div>
			<!-- content -->
			<div id="content">
				<div class="container">
					<div class="row-1">
						<!-- .box -->
						<div class="box">
							<div class="inner">
								<div class="line-ver">
									<div class="wrapper line-ver1">
										<div class="col-1">
											<div class="indent">
												<h3>
													<img src="images/icon1.jpg" alt="" />
													<font face="微软雅黑">热门新闻</font>
												</h3>
												<ul class="list1 col-1">
													<s:iterator value="pressList" var="obj">
														<li>
															<a href="find/findPressByID?pressID=<s:property value="#obj.pressID"/>"><p class="p1">
																	<s:property value="#obj.pressTitle"/>
																</p> </a>
														</li>
													</s:iterator>
												</ul>
												<div class="wrapper">
													<a href="find/pageFind?press.pages=1&title=" class="link1"><b>Read
															More</b> </a>
												</div>
											</div>
										</div>
										<div class="col-2">
																						<div class="indent">
												<h3>
													<img src="images/icon2.jpg" alt="" />
													<font face="微软雅黑">Taxleopard热点</font>
												</h3>
												<ul class="list1 col-2">
													<li>
														<a href="#"><p class="p1">
																快讯：个税草案3000元起征点不变 第1级税率大幅降低
															</p> </a>
													</li>
													<li>
														<a href="#">
															<p class="p1">
																快讯：个税草案3000元起征点不变 第1级税率大幅降低
															</p> </a>
													</li>
													<li>
														<a href="#">
															<p class="p1">
																快讯：个税草案3000元起征点不变 第1级税率大幅降低
															</p> </a>
													</li>
													<li>
														<a href="#"><p class="p1">
																快讯：个税草案3000元起征点不变 第1级税率大幅降低
															</p> </a>
													</li>
												</ul>
												<div class="wrapper">
													<a href="#" class="link1"><b>Read More</b> </a>
												</div>
											</div>
										</div>
										<div class="col-3" style="background-image:url(images/biaodan4.png); background-repeat:no-repeat; height:386px; width:260px">
									<%@include file="/homePage/login.jsp"%>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.box -->

					</div>
				</div>
			
                <!-- footer -->
    <div id="footer">
    	<div class="container">
       <div >
            <ul class="footer"  style="margin-left:280px;">
            <li><a href="aboutMe/gongsijianjie.html">公司简介 |</a></li>
              <li><a href="aboutMe/zhaoxiannashi.html">招贤纳士 |</a></li>
                <li><a href="aboutMe/guanggaofuwu.html">广告服务 |</a></li>
                  <li><a href="aboutMe/lianxifangshi.html">联系方式 |</a></li>
                    <li><a href="aboutMe/banquanshengming.html">版权声明 |</a></li>
                    <li><a href="aboutMe/falvguwen.html">法律顾问 |</a></li>
                    <li><a href="aboutMe/wentibaogao.html">问题报告 </a></li>
            </ul>
          </div>
          <br />
            <div align="center">
            <ul class="footer"  style="margin-left:230px;">
            <li><a href="#">客服电话:010-84410985 |</a> </li>
             <li><a href="#">北京朝阳区嘉美中心写字楼1021 |</a> </li>
              <li><a href="#">客服信箱:aobsoft@126.com </a> </li>
            </ul>
             <br />
           </div> 
          <div align="center">City Business 2011 &copy; 北京赛克尚城科技有限公司</div>
       
  
    </div>
  </div>
			</div>
	</body>
</html>
