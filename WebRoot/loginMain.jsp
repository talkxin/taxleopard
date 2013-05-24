<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 <head>
    <title>登录主页</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<link href="css/style.css"  rel="stylesheet" type="text/css" />
	<link href="css/layout.css"  rel="stylesheet" type="text/css" />
	<script src="js/jquery-1.4.2.min.js"  type="text/javascript"></script>
	<script src="js/jquery.faded.js"  type="text/javascript"></script>
	<script src="js/script.js"  type="text/javascript"></script>
	<script src="js/verifyCode.js"  type="text/javascript"></script>

  </head>
  <body id="page1">
 <div class="splash">
    <!-- header -->
    <div id="header">
     <%@include file="/homePage/top.jsp" %>
      <div class="row-2">
        <!-- .slider -->
        <!-- 产品展示图片 -->
        <%@include file="/homePage/imagesAll.jsp" %>
        <!-- /.slider -->
        <div class="clear"></div>
        <!-- .slogan -->
        <div class="slogan" style="top: 70px">
          <%@include file="/homePage/login.jsp" %>
          <div>
          	用户忘记密码：
          	<a href="retrievePassword.jsp">找回密码</a><br/>
          	新用户注册：
          	<a href="register.jsp">注册新用户</a><br/>
          </div>
        </div>
        <!-- /.slogan -->
      </div>
    </div>
     <div id="footer">
     <%@include file="/homePage/footer.jsp" %>
     </div>
    </div>
  </body>
</html>
