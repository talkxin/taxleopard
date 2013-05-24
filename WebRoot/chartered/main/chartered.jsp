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
<script type="text/javascript"
	src="paychex/main/js/datepicker/WdatePicker.js" language="jscript"></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/paychexD.js'></script>
<script type='text/javascript' src='dwr/interface/CharteredData.js'></script>
<link rel="stylesheet" type="text/css"
	href="labor/css/onServiceLoad.css" />
<script type='text/javascript' src='labor/js/jquery.min.js'></script>
<script type="text/javascript">
	var j$ = jQuery.noConflict();
</script>
<script type='text/javascript' src='labor/js/onServiceLoad.js'></script>
<script type="text/javascript" src="chartered/js/chartered.js"
	language="jscript" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="labor/css/reportCss.css" />
<script type='text/javascript' src='dwr/interface/charteredD.js'></script>
<script type="text/javascript" src="chartered/js/charteredReport.js"
	language="jscript" charset="UTF-8"></script>

</head>
<body>
	<!-- 特许权主菜单 -->
	<div id="texuquanPage">
		<div>
			<div id="CharteredMain">
				<div id="CharteredPage"></div>
			</div>
			<div style="margin-top: -50px">
				<div id="report" class="tabContainer"
					style="clear: both; margin: 0 auto; text-align: center; height: 300px; width: 810px;overflow: scroll;">
					<h1 id="h1" style="text-align: center; font-size: 18px">特许权信息</h1>
					<br />
					<div id="charteredReport">
                      <table width="501" id="tb" style="border:1px solid #000000;" cellpadding="0" cellspacing="0"  bgcolor="#FFFFFF" align="center">
 	                    <tr >
 	                      <td class="lie" width="172" height="40px" ><span style="font-size:14px; font-weight:bold;">作品名</span></td>
                          <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">开始时间</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">结束时间</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">总月份数</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">特许权费用(￥)</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">应纳税额(￥)</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">税后收入(￥)</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">已交税款(￥)</span></td>
                          <td class="lie" width="150" ><span style="font-size:14px; font-weight:bold;">操作</span></td>
                        </tr>
                       <tbody id="charteredBody"></tbody>
                     </table>
                   </div>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加特许权基本 -->
	<div id="addCrCharteredInfo" style="display: none;">
		<ul>
			<li>专利名称：<input type="text" id="charteredInfoName" /></li>
		</ul>
	</div>
	<!-- 添加特许权基本信息 -->
	<div id="addCrChartered" style="display: none;">
		<ul>
			<li>特许权类型：<select id="charteredType"></select></li>
			<li>授权时间：<input type="text" id="charteredStart" onfocus="WdatePicker();"/>至<input
				type="text" id="charteredEnd" onfocus="WdatePicker();"/></li>
			<li>特许权费用：<input type="text" id="charteredNumber" onkeyup="replaceNotNumber(this);"/></li>
			<li>是否含税：含税<input type="radio" name="taxed" checked="checked"
				value="0" />不含税<input type="radio" name="taxed" value="1" />
			</li>

		</ul>
	</div>
</body>
</html>