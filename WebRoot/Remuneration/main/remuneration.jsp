<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
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
<link rel="stylesheet" type="text/css"
	href="labor/css/onServiceLoad.css" />
<link rel="stylesheet" type="text/css" href="labor/css/reportCss.css" />
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/paychexD.js'></script>
<script type='text/javascript' src='dwr/interface/remunerationData.js'></script>
<script type='text/javascript' src='labor/js/jquery.min.js'></script>
<script type="text/javascript">
	var j$ = jQuery.noConflict();
</script>
<script type='text/javascript' src='labor/js/onServiceLoad.js'></script>
<script type="text/javascript"
	src="paychex/main/js/datepicker/WdatePicker.js" language="jscript"></script>
<script type="text/javascript" src="Remuneration/js/remuneration.js"
	language="jscript" charset="UTF-8"></script>
<script type='text/javascript'
	src='Remuneration/js/remunerationReport.js'></script>
<script type='text/javascript' src='dwr/interface/remuD.js'></script>
</head>
<body>
	<!-- 主页面 -->
	<div id="remunerationMain">
		<div id="remunerationPage"></div>
	</div>
	<!-- 添加作品 -->
	<div id="addRemunerationPage" style="display: none;">
		<ul>
			<li>您作品的名称： <label> <input id="remunerationName" /> </label>
			</li>
			<li>您作品的类型： <label> <select id="remunerationType"></select>
			</label>
			</li>
		</ul>
	</div>
	<!-- 稿酬管理 -->
	<div id="gaochouPage" style="display: none;">
		<div>
			<div id="RePressTypeMain">
				<div id="RePressTypePage"></div>
			</div>
			<div style="margin-top: -50px">
				<div id="reportByPr" class="tabContainer"
					style="clear: both; margin: 0 auto; text-align: center; height: 300px; width: 810px;overflow: scroll;">
					<h1 id="h1" style="text-align: center; font-size: 18px">稿酬信息</h1>
					<br />
					<div id="remuReportByPr"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- 出版社页 -->
	<div id="addPressType" style="display: none;">
		<ul>
			<li>出版社名称：<label><input id="pressName" type="text" /><input
					id="openAllPressName" type="button" onclick="onOpenLishi()" value="查询所有出版社" />
			</label></li>
		</ul>
	</div>
	<!-- 所有出版社 -->
	<div id="allPressType" style="display: none;">
		<table>
			<tr>
				<th>出版社名称</th>
			</tr>
			<tbody id="allPressPage"></tbody>
		</table>
	</div>
	<!-- 出版类型 -->
	<div id="addPublishPage" style="display: none;">
		<ul>
			<li><img src="Remuneration/images/lianzai.png"
				onclick="addPublishPageAll(3,'连载')" /></li>
			<li id="dchuban"><img src="Remuneration/images/chuban.png"
				onclick="addPublishPageAll(0,'出版')" /></li>
			<li id="dzaiban"><img src="Remuneration/images/zaiban.png"
				onclick="addPublishPageAll(1,'再版')" /></li>
			<li id="djiayin"><img src="Remuneration/images/jiayin.png"
				onclick="addPublishPageAll(2,'加印')" /></li>
			<li><img src="Remuneration/images/qita.png"
				onclick="addPublishPageAll(4,'其他')" /></li>
			<li><img src="Remuneration/images/tuigaofei.png"
				onclick="addPublishPageAll(5,'退稿费')" /></li>
		</ul>
	</div>
	<!-- 稿酬页面 -->
	<div id="addPublish" style="display: none;">
		<ul>
			<li>个人身份：<label><select id="publishType2" onchange="onShenfen();"></select> </label></li>
			<li>出版时间：<label><input id="publishTime" type="text"
					onfocus="WdatePicker();" /> </label></li>
			<li>是否含税：<label>含税：<input type="radio" name="taxed"
					value="0" checked="checked" />不含税<input type="radio" name="taxed"
					value="1" /> </label></li>
			<li>稿酬所得：<label><input id="publishNumber" type="text" onkeyup="replaceNotNumber(this);"/>
			</label></li>
		</ul>
	</div>
	<!-- 点击某个作品打开报表页面 -->
	<div id="report" class="tabContainer"
		style="display:none;overflow:scroll; clear:both; margin:0 auto; text-align:center; height:400px; width:600px">

		<h1 id="h1" style="text-align:center;font-size:18px">稿酬</h1>
		<div align="left"
			style="font-family:'微软雅黑';margin-left:110px;font-size:16px;">
			请选择年份： <select id="nian" onchange="onChooseYear();" name="nianFen">
				<option value="2005">2005</option>
				<option value="2006">2006</option>
				<option value="2007">2007</option>
				<option value="2008">2008</option>
				<option value="2009">2009</option>
				<option value="2010">2010</option>
				<option value="2011">2011</option>
				<option value="2012">2012</option>
				<option value="2013">2013</option>
				<option value="2014">2014</option>
				<option value="2015">2015</option>
			</select>
		</div>
		<br />
		<div id="remuReport"></div>
	</div>

	<!-- 点击全局打开报表页面 -->
	<div id="allReport" class="tabContainer"
		style="display:none;overflow:scroll; clear:both; margin:0 auto; text-align:center; height:400px; width:600px">

		<h1 id="h1" style="text-align:center;font-size:18px">稿酬</h1>
		<div align="left"
			style="font-family:'微软雅黑';margin-left:110px;font-size:16px;">
			请选择年份： <select id="nianFull" onchange="onChooseFullYear();"
				name="nianFen">
				<option value="2005">2005</option>
				<option value="2006">2006</option>
				<option value="2007">2007</option>
				<option value="2008">2008</option>
				<option value="2009">2009</option>
				<option value="2010">2010</option>
				<option value="2011">2011</option>
				<option value="2012">2012</option>
				<option value="2013">2013</option>
				<option value="2014">2014</option>
				<option value="2015">2015</option>
			</select>
		</div>
		<br />
		<div id="allRemuReport"></div>
	</div>
</body>
</html>