<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<title>用户注册</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/layout.css" rel="stylesheet" type="text/css" />
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/verifyCode.js"  type="text/javascript"></script>
	</head>
	<body id="page1">
		<div class="splash">
			<!-- top -->
			<div id="header">
				<%@include file="/homePage/top.jsp"%>
				<div class="row-2">
					<div class="slider">
						<%@include file="/registerPage/welcomeByRegister.jsp"%>
					</div>
					<form action="addTaxPayer" method="post">
						<div class="slogan" style="top: 80px">
						   <div>
							E-Mail：
							<br />
							<br />
							  <s:if test="taxPayer!=null">
								<input type="text" id="taxPayer" name="taxPayer.taxUserName" value="<s:property value="taxPayer.taxUserName"/>"/>
								<div id="taxUserName"></div>
							  </s:if>
							  <s:if test="taxPayer==null">
								<input type="text" id="taxPayer" name="taxPayer.taxUserName"/>
								<div id="taxUserName"></div>
							  </s:if>
							<br />
							<br />
							Password：
							<br />
							<br />
							<input type="password" name="taxPayer.taxPassWord" />
							<br />
							<br />
							<hr style="size: 3px; width: 260px" />
							Confirm Password:
						
							<br />
							<br />
							<input type="password" name="confirmPass" />
							</div>
							
							<br />
							<br />
							请输入验证码
							<br />
							<br />
							<div>
								<div style="float: left">
									<img id="imgObj"  src="verifyimage.create" onclick="changeImg()" border="0" height="30" width="70"/>
									<input size="6" id="veryCode"  type="text" name="veryCode" onchange="isRightCode()"/>
									<br/><font size="-1" id="change" onclick="changeImg()">不区分大小写：看不清</font>
								</div>
								<div id="info" style="float: right;height=30px"></div>
							</div>
							<br />
							<br />
							<br />
							<br />
							<input type="checkbox" name="checked" value="1" checked="checked" />
							<a href="#">阅读并同意用户条款</a>
							<br />
							<br />
							<div>
							<input type="submit" style="margin-left: 70px" value="提交" />
							<input type="button" value="取消" />
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- footer -->
			<div id="footer">
				<%@include file="/homePage/footer.jsp"%>
			</div>
		</div>
	</body>
</html>
