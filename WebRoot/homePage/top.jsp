<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<script type="text/javascript">
function isSubmit(){
	 if (event.keyCode==13) 
	 {
		 if(document.getElementById("passWord").value==null || document.getElementById("passWord").value=='')
		 {
			 document.getElementById("passWord").focus();
		 }else{
		 document.loginForm.submit();
		 }
	 }
}
function onSubmit(){
	document.loginForm.submit();
}
//退出
function logout(){
    self.location.href="quit";
}
</script>
<div class="row-1">
	<div class="container">
		<div class="wrapper">
			<!-- .nav -->
			<ul class="nav">
				<li>
					<a href="index" class="current">主页</a>
				</li>
				<li>
				   <s:if test="#session.taxPayer==null">
					<a href="login">个人首页</a>
				   </s:if>
				   <s:if test="#session.taxPayer!=null">
					<a href="toPersonalPage">个人首页</a>
				   </s:if>
				</li>
				<li>
					<a href="#">最新推荐</a>
				</li>
				<li>
					<a href="#">安全性</a>
				</li>
				<li>
					<a href="#">关于税豹</a>
				</li>
					<li><a href="/TaxPersonalReporting1.0/toRegisterPage">注册</a></li>
			</ul>
			<!-- /.nav -->
			<form action="login" method="post" name="loginForm" id="search-form">
			  <s:if test="#session.taxPayer==null">
                <span style="color:#FFFFFF; font-size:10px">用户名：</span><input name="taxPayer.TaxUserName" type="text"  style="width:80px; height:15px" onkeyup="isSubmit()"/><span style="color:#FFFFFF; margin-left:20px;font-size:10px">密码：</span><input id="passWord" name="taxPayer.TaxPassWord" type="password" onkeyup="isSubmit()"  style="width:80px; height:15px;"/><input type="button" value="登 录" onclick="onSubmit();"  style="margin-left:20px;  font-size:10px; width:40px; height:25px;" />
              </s:if>
              <s:if test="#session.taxPayer!=null">
                <span style="color:#FF4040; font-size:20px">您好！${taxPayer.taxUserName}</span>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="退出" style="font-size:10px; width:40px; height:25px;" onclick="javascript:logout()"/>
              </s:if>
            </form>
		</div>
	</div>
</div>