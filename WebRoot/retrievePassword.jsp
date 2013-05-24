<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<title>找回密码</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/layout.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>    
        <script type="text/javascript" src="js/verifyCode.js"></script>
		<script type="text/javascript">
	function find() {
		if(as){
			document.getElementById("findByName").submit();
		}
	}
</script>
	</head>

	<body id="page1">
			<div class="splash">
				<div id="header" style="height: 480px">
					<%@include file="/homePage/top.jsp"%>
					<div class="row-2">
						<div class="slogan"
							style="top: 80px; width: 1024px; border-color: #a3a3a3; border-width: 5px;">
							<b>找回税豹密码： <img src="images/retrievePassword1.png"
									style="margin-top: -5px;" /> </b>
							<br />
							<form action="findTaxPayerByName" method="post" id="findByName">
							<div style="width: 400px; margin-left: 312px; margin-top: 60px;">
								<p>
									注册E-Mail账户：
									<input type="text" name="taxPayer.taxUserName" />
								</p>
								<p style="margin-left: 63px">
									验证码：
									<input size="6" id="veryCode"  type="text" name="veryCode" onchange="isRightCode()"/>
									<br />
									<font size="-1" style="margin-left: 60px" id="change" onclick="changeImg()">不区分大小写：看不清</font>
									<br />
									<img id="imgObj"  src="verifyimage.create" onclick="changeImg()" border="0" height="30" width="70"/>
									<div id="info"></div>
								</p>
								<p style="margin-left: 100px;">
									<a href="javascript:find();"><img src="images/Next.png"
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
</html>
