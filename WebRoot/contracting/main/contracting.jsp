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
<script type='text/javascript' src='dwr/interface/ContractingData.js'></script>
<link rel="stylesheet" type="text/css"
	href="labor/css/onServiceLoad.css" />
<script type='text/javascript' src='labor/js/jquery.min.js'></script>
<script type="text/javascript">
	var j$ = jQuery.noConflict();
</script>
<script type='text/javascript' src='labor/js/onServiceLoad.js'></script>
<script type="text/javascript" src="contracting/js/contracting.js"
	language="jscript" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="labor/css/reportCss.css" />
<script type="text/javascript" src="contracting/js/contractReport.js"
	language="jscript" charset="UTF-8"></script>
<script type='text/javascript' src='dwr/interface/contractD.js'></script>
</head>

<body>
	<!-- 承租承包主页面 -->
	<div id="chengzuchengbaoPage">
		<div>
			<div id="contractingMain">
				<div id="contractingPage"></div>
			</div>
			<div style="margin-top: -50px">
				<div id="report" class="tabContainer"
					style="clear: both; margin: 0 auto; text-align: center; height: 300px; width: 810px;overflow: scroll;">
					<h1 id="h1" style="text-align: center; font-size: 18px">承包承租信息</h1>
					<br />
					<div id="contractReport">
						<table width="501" id="tb" style="border:1px solid #000000;"
							cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" align="center">
							<tr>
								<td class="lie" width="172" height="40px"><span
									style="font-size:14px; font-weight:bold;">承包名</span></td>
								<td class="lie" width="130"><span
									style="font-size:14px; font-weight:bold;">承包企业类型</span></td>
								<td class="lie" width="130"><span
									style="font-size:14px; font-weight:bold;">工资薪金</span></td>
								<td class="lie" width="130"><span
									style="font-size:14px; font-weight:bold;">是否拥有收益</span></td>
								<td class="lie" width="145"><span
									style="font-size:14px; font-weight:bold;">开始时间</span></td>
								<td class="lie" width="130"><span
									style="font-size:14px; font-weight:bold;">结束时间</span></td>
								
								<td class="lie" width="130"><span
									style="font-size:14px; font-weight:bold;">承包费用(￥)</span></td>
								<td class="lie" width="130"><span
									style="font-size:14px; font-weight:bold;">承包收益(￥)</span></td>
								<td class="lie" width="130"><span
									style="font-size:14px; font-weight:bold;">应纳税额(￥)</span></td>
								<td class="lie" width="130"><span
									style="font-size:14px; font-weight:bold;">税后收入(￥)</span></td>
								<td class="lie" width="150"><span
									style="font-size:14px; font-weight:bold;">操作</span></td>
							</tr>
							<tbody id="contractBody"></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加承包机构 -->
	<div id="addContractInfo" style="display: none;">
		<ul>
			<li>企业及机构名称：<input id="contractName" /></li>
			<li>企业类型:国内企业<input type="radio" name="contractCoType" value="0"
				checked="checked" />国外企业<input type="radio" name="contractCoType"
				value="1" />
			</li>
			<li>该企业支付您的平均月薪<input id="allPay" onkeyup="replaceNotNumber(this);"/><input type="button"
				onclick="" value="提取上月工资薪金" /></li>
		</ul>
	</div>
	<!-- 承包信息 -->
	<div id="addContract" style="display: none;">
		<ul>
			<li>合同时间：<input id="contractStart" onfocus="WdatePicker();"/>至<input id="contractEnd" onfocus="WdatePicker();"/>
			</li>
			<li>承包费用：<input id="contractNumber1" onkeyup="replaceNotNumber(this);"/>
			</li>
			<li>承包收益：<input id="contractNumber2" onkeyup="replaceNotNumber(this);"/>
			</li>
			<li>是否拥有收益：是<input name="contractType2" type="radio" value="0"
				checked="checked" />否<input name="contractType2" type="radio"
				value="1" />
			</li>
			<li>该合同性质：一次性合同<input name="contractType" type="radio" value="0"
				checked="checked" />分次合同<input name="contractType" type="radio"
				value="1" />
			</li>
		</ul>
	</div>
</body>
</html>