<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
	function login() {
		document.getElementById("newsletter-form").submit();
	}
</script>
<!-- 登录页 -->
<div
	style="background-image: url(images/biaodan4.png); background-repeat: no-repeat; height: 386px; width: 260px">
	<h4></h4>
	<form action="login" method="post" id="newsletter-form">
		<fieldset>
			<div id="userName" style="padding-top: 125px; padding-left: 32px">
				<label>
					<input type="text" class="text" name="taxPayer.TaxUserName" />
				</label>
			</div>
			<div style="padding-top: 41px; padding-left: 32px">
				<label>
					<input type="password" class="text" name="taxPayer.TaxPassWord" />
				</label>
			</div>
			<s:if test="#session.numError!=null">
				<s:if test="#session.numError>=3">
				<div>
					<div style="float: left">
					<img id="imgObj"  src="verifyimage.create" onclick="changeImg()" border="0" height="30" width="70"/>
					<input size="6" id="veryCode"  type="text" name="veryCode" onchange="isRightCode()"/>
					<br/><font size="-1" id="change" onclick="changeImg()">不区分大小写：看不清</font>
					</div>
					<div id="info" style="float: right;height=30px"></div>
				</div>
				</s:if>
			</s:if>
			<div class="wrapper" id="logins" style="padding-left: 190px"><!-- 65 -->
				<a href="javascript:login(); "><img src="images/button2.png" />
				</a>
			</div>
			<s:if test="#session.numError!=null">
				<s:if test="#session.numError>=3">
				<script type="text/javascript">
					$('#logins').css("padding-top",10);
				</script>
				</s:if>
			</s:if>
		</fieldset>
	</form>
</div>
