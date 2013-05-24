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
<script type='text/javascript' src='dwr/interface/SavingsData.js'></script>
<link rel="stylesheet" type="text/css"
	href="labor/css/onServiceLoad.css" />
<script type='text/javascript' src='labor/js/jquery.min.js'></script>
<script type="text/javascript">
	var j$ = jQuery.noConflict();
</script>
<script type='text/javascript' src='labor/js/onServiceLoad.js'></script>
<script type="text/javascript" src="savings/js/savings.js"
	language="jscript" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="labor/css/reportCss.css" />
<script type='text/javascript' src='dwr/interface/savingsD.js'></script>
<script type="text/javascript" src="savings/js/savingsReport.js"
	language="jscript" charset="UTF-8"></script>
</head>
<body>
	<!-- 个人储蓄主页面 -->
	<div id="gerenchuxuPage">
		<div>
			<div id="SavingsMain">
				<div id="SavingsPage"></div>
			</div>
		    <div style="margin-top: -50px">
				<div id="report" class="tabContainer"
					style="clear: both; margin: 0 auto; text-align: center; height: 300px; width: 810px;overflow: scroll;">
					<h1 id="h1" style="text-align: center; font-size: 18px">个人储蓄信息</h1>
					<br />
					<div id="savingsReport">
                      <table width="501" id="tb" style="border:1px solid #000000;" cellpadding="0" cellspacing="0"  bgcolor="#FFFFFF" align="center">
 	                    <tr >
 	                      <td class="lie" width="172" height="40px" ><span style="font-size:14px; font-weight:bold;">账户名</span></td>
                          <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">开户银行</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">储蓄类型</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">存储类型</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">操作金额(￥)</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">开始时间</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">结束时间</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">应纳税额(￥)</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">税后收入(￥)</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">利率</span></td>
                          <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">利息(￥)</span></td>
                          <td class="lie" width="150" ><span style="font-size:14px; font-weight:bold;">操作</span></td>
                        </tr>
                       <tbody id="savingsBody"></tbody>
                     </table>
                   </div>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加账户 -->
	<div id="addSaSavingsInfoPage" style="display: none;">
		<ul>
			<li>户口名：<input type="text" id="savingsName" /></li>
			<li>户口类型：储蓄卡<input type="radio" name="savingsType" value="0"
				checked="checked" />存折<input type="radio" name="savingsType"
				value="1" /></li>
			<li>开户时间：<input type="text" id="savingsTime" onfocus="WdatePicker();"/></li>
			<li>开户银行：<input type="text" id="savingsAccount" /></li>
		</ul>
	</div>
	<!-- 账户操作 -->
	<div id="zhanghucaozuo" style="display: none;">
		<ul>
			<li><img src="savings/images/xucun.png" onclick="onaddSaSavings()" /></li>
			<li><img src="savings/images/xiugaililv.png" onclick="onupInterest()" /></li>
		</ul>
	</div>
	<!-- 账户信息 -->
	<div id="addSaSavingsPage" style="display: none;">
		<ul>
			<li>存入金额：<input type="text" id="savingsNumber" onkeyup="replaceNotNumber(this);"/>
			</li>
			<li>存款类型：3月<input type="radio" name="savingsAllTime" value="3" />
				6月<input type="radio" name="savingsAllTime" value="6" />1年<input
				type="radio" name="savingsAllTime" value="12" />2年<input
				type="radio" name="savingsAllTime" value="24" />5年或5年以上<input
				type="radio" value="60" /></li>
			<li>利率：<input type="text" id="interestRate" onkeyup="replaceNotNumber(this);"/></li>
		</ul>
	</div>
<!--	 利率 -->
<!--	<div id="lilvPage" s>-->
<!--		<table>-->
<!--			<tr>-->
<!--				<th>时间</th>-->
<!--				<th>利率</th>-->
<!--				<th>操作</th>-->
<!--			</tr>-->
<!--			<tbody id="lilvTable"></tbody>-->
<!--		</table>-->
<!--	</div>-->
	<!-- 添加利率 -->
<%--	<div id="addLilv" style="display: none;">--%>
<%--	<ul><li>利率为：<input id="interestRate"/></li></ul>--%>
<%--	</div>--%>
</body>
</html>