<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人首页</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	color: #555;
	background: #f0f0f0 url('personalPage/images/bg-body.gif') top left
		repeat-y;
	font-size: 12px;
}

h2 {
	font-size: 26px;
	padding: 0 0 10px 0;
}

h3 {
	font-size: 17px;
	padding: 0 0 10px 0;
}

.side {
	width: 221px;
	padding-top: 20px;
	float: left;
	height: 600px;
}

.side1 {
	color: #FFFFFF;
	text-align: center;
	width: 221px;
	margin-top: 20px;
}

.main-content {
	padding: 30px 0 0 0;
	float: left;
}

.row1 {
	height: 79px;
	margin-top: -25px
}

.row1-1 {
	width: 200px;
	float: left
}

.row1-2 {
	float: left;
	margin-left: 200px;
}

.row2 {
	width: 400px;
	float: left;
	margin-top: 10px;
}

.row2--1 {
	background: #e5e5e5;
	border: 1px solid #cccccc;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
}

.row2-1 {
	width: 400px;
	float: left;
	margin-left: 18px;
	margin-top: 10px;
}

.row2-2 {
	background: #FFFFFF;
	height: 70px;
	border: 1px solid #cccccc;
}

.row3 {
	background: #e5e5e5 top left repeat-x;
	margin-top: 30px;
	height: 40px;
	border: 1px solid #cccccc;
	width: 810px;
}

.footer {
	margin: 40px 0 0 0;
	padding: 90px 0;
	font-size: 14px;
}

.personalDiv {
	margin-left: 20px;
	width: 1000px;
	height: 1000px;
}

ul {
	list-style: none;
	text-aline: center;
}

.STYLE1 {
	color: #000000;
	margin-top: 15px;
	font-size: 15px;
}

.left {
	float: left;
	width: 70px;
	height: 100px;
}

.left-1 {
	margin-left: 20px;
	margin-top: 10px;
}

.right {
	float: left;
	width: 70px;
	margin-left: 20px;
}
</style>
<script type='text/javascript' src='prompt/js/prompt.js'
	language="jscript" charset="UTF-8"></script>
<script>
	(function() {
		var _skin, _jQuery;
		var _search = window.location.search;

		document
				.write('<scr'
						+ 'ipt src="house/artDialog4.1.2/artDialog/artDialog.source.js?skin='
						+ (_skin || 'idialog') + '"></sc' + 'ript>');
		window._isDemoSkin = !!_skin;
	})();
</script>
<script type="text/javascript" src="share/js/hashmapjs.js"
	language="jscript" charset="UTF-8"></script>
<link rel="Stylesheet" href="personalPage/css/jquery.jerichotab.css" />
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='labor/js/jquery.min.js'></script>
<script type='text/javascript' src='dwr/interface/paychexD.js'></script>
<script type='text/javascript' src='dwr/interface/personalPageD.js'></script>
<script type='text/javascript' src='dwr/interface/promptData.js'></script>
<script type="text/javascript"
	src="personalPage/js/jquery.jerichotab.js"></script>
<script type="text/javascript" src="personalPage/js/jquery.resizable.js"></script>
<script type='text/javascript' src='personalPage/js/personal.js'
	language="jscript" charset="UTF-8"></script>
</head>

<body>
	<div id="personalApp" class="side">
		<div>
			<img src="personalPage/images/logo.png" />
		</div>
		<div class="side1">
			<a href="index">返回主页</a>| <a href="quit">安全退出</a> |<a href="#" onclick="onclickto()">智能提示</a>
		</div>
		<div id="personalLeft"></div>
	</div>
	<div class="main-content">
		<div id="personalMain" class="personalDiv">
			<div id="personalDiv">&nbsp;</div>
		</div>

	</div>

</body>
</html>
