<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<link rel="stylesheet" type="text/css"
	href="labor/css/onServiceLoad.css" />
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/paychexD.js'></script>
<script type='text/javascript' src='dwr/interface/sharesData.js'></script>
<script type='text/javascript' src='labor/js/jquery.min.js'></script>
<script type="text/javascript">
	var j$ = jQuery.noConflict();
</script>
<script type='text/javascript' src='labor/js/onServiceLoad.js'></script>
<script type="text/javascript"
	src="paychex/main/js/datepicker/WdatePicker.js" language="jscript"></script>
<script type="text/javascript" src="share/js/hashmapjs.js"
	language="jscript" charset="UTF-8"></script>
<script type='text/javascript' src='share/js/sharesMain.js'
	language="jscript" charset="UTF-8"></script>

<link rel="stylesheet" type="text/css" href="labor/css/reportCss.css" />
<script type='text/javascript' src='dwr/interface/sharesReportD.js'></script>	
<script type='text/javascript' src='paychex/reportForm/js/swfobject.js'></script>
<script type='text/javascript' src='share/js/sharesReport.js'></script>
</head>

<body>
	<div id="shareMain">
		<div id="sharePage"></div>
	</div>
	<!-- 添加股票 -->
	<div id="addSharesOne" style="display: none;">
		<div>
			<ul id="ul">
				<li>境内股票转让现阶段为免税</li>
				<li><input type="radio" name="sharesType" value="0" /> 股票 <br />
					<input type="radio" name="sharesType" value="1" /> 股权<br /> <input
					type="radio" name="sharesType" value="2" />债卷</li>
			</ul>
		</div>
	</div>
	<!--股票-->
	<div id="gupiaoAdd" style="display: none;">
		<div>
			<ul id="ul">
				<li>您购买的股票名称： <input type="text" id="sharesName" />
				</li>
				<li>您的股票类型： <select id="sharesType2">
				</select>
				</li>
				<li>股票上市地： <select id="sharesAdd">
				</select>
				</li>
				<li>您购入该股的日期： <input type="text" id="sharesInTime"
					onfocus="WdatePicker();" />
				</li>
				<li>您购买的股票数量： <input type="text" id="sharesNumber"
					onkeyup=replaceNotNumber(this); /></li>
				<li>股票当日交易价格： <input type="text" id="sharesInDayNumber"
					value="0" onkeyup=replaceNotNumber(this); />
				</li>
				<li>其他税费： <input type="text" id="taxedNumber" value="0"
					onkeyup=replaceNotNumber(this); />
			</ul>
		</div>
	</div>
	<!--股权-->
	<div id="guquanAdd" style="display: none;">
		<div>
			<ul id="ul">
				<li>您所获取的股票名称： <input type="text" id="sharesNameE" /></li>
				<li>您所获取的期权为： <input type="radio" name="equityType"
					checked="checked" value="0" /> 公开交易股票 <input type="radio"
					name="equityType" value="1" /> 非公开交易股票</li>
				<li>股票上市地： <select id="sharesAddE">
				</select></li>
				<li>您获取期权的日期： <input type="text" id="sharesInTimeE"
					onfocus="WdatePicker();" /></li>
				<li>您接受的股权数： <input type="text" id="sharesNumberE"
					onkeyup=replaceNotNumber(this); /></li>
				<li>股票当日交易价格： <input type="text" id="sharesInDayNumberE"
					value="0" onkeyup=replaceNotNumber(this); />
				</li>
				<li>股票行权日： <input type="text" id="equityOutDay"
					onfocus="WdatePicker();" /></li>
			</ul>
		</div>
	</div>
	<!-- 股权操作 -->
	<div id="guquancaozuo"
		style="display: none;">
		<ul>
			<li><img src="share/images/zizhuijiaguquan.png"
				onclick="Onzhuijiaguquan(1)" /><br /></li>
			<li><img src="share/images/zixingquan.png" onclick="openZhuanrang()" /><br />
</li>
		</ul>
	</div>
	<!-- 股票操作 -->
	<div id="gupiaocaozuo"
		style="display: none;">
		<ul>
			<li><img src="share/images/gupiaozhuanrangzi.png" onclick="openZhuanrang();" /><br /></li>
			<li><img src="share/images/zhuijiagupiaozi.png"
				onclick="Onzhuijiaguquan(0);" /></li>
		</ul>
	</div>
	<!-- 股票股权的追加 -->
	<div id="zhuijiapage" style="display: none;">
		<ul id="ul">
			<li>追加时间： <input id="sharesInTimezhui" type="text"
				onfocus="WdatePicker();" />
			</li>
			<li>追加数额： <input id="sharesInNumber" type="text" />
			</li>
			<li>当天交易价格：<input id="sharesInPrice" type="text" size="20" />
			</li>
			<li>其他税费<input id="InOtherCost" type="text" value="0" />
			</li>
			<li id="xingquanri" style="display: none;">行权日期： <input
				id="newequityOutDay" type="text" onfocus="WdatePicker();" /></li>
			<li><input type="button" id="isOnSaveZhui" value="保存"
				onclick="onSaveZhuijia()" /></li>
			<li><div style="border-bottom:#666666 1px solid;">追加历史</div></li>
			<li>
				<table width="300" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<th>追加时间</th>
						<th>追加股票数</th>
						<th>当天购买价</th>
						<th>其他税费</th>
						<th>操作</th>
						<tbody id="lishiList"></tbody>
					</tr>
				</table>
			</li>
		</ul>
	</div>
	<!--转让或行权-->
	<div id="gupiaozhuanrang" style="display: none;">
		<ul id="ul">
			<li>操作时间：<input type="text" id="sharesOutTime" onfocus="WdatePicker();" />
			</li>
			<li>操作股票的数量： <input type="text" id="sharesOutNumber"
				class="form1" />
			</li>
			<li>实际每股交易价：<input type="text" id="sharesOutPrice" class="form1" />
			</li>
			<li>其他费用： <input type="text" id="OutOtherCost" /></li>
			<li>个人所得税为：<input type="text" id="taxNumber" /></li>
			<li><input type="button" id="isOnSaveZhui" value="保存"
				onclick="onSaveZhuanrang()" /></li>
			<li>
				<table width="500" border="1" cellpadding="0" cellspacing="0"
					bordercolor="#000000">
					<tr>
						<th>转让日期</th>
						<th>转让数量</th>
						<th>应纳税额</th>
						<th>其他税费</th>
						<th>操作</th>
					</tr>
					<tbody id="outTable"></tbody>
				</table>
			</li>
			<li></li>
		</ul>
	</div>
<!-- 某股票或股权的报表 -->	 
 <div id="report" class="tabContainer" style="display:none;clear:both; margin:0 auto; text-align:center; height:400px; width:600px;overflow:scroll">
    <h1 id="h1" style="text-align:center;font-size:18px">报表信息</h1>
    <br/>
    <div id="shareReport">
       <table width="501" id="tb" style="border:1px solid #000000;" cellpadding="0" cellspacing="0"  bgcolor="#FFFFFF" align="center">
 	         <tr >
 	               <td class="lie" width="172" height="40px" ><span style="font-size:14px; font-weight:bold;">时间</span></td>
 	               <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">状态</span></td>
                   <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">操作股数</span></td>
                   <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">单价（人民币）￥</span></td>
                   <td class="lie" width="150" ><span style="font-size:14px; font-weight:bold;">总价格（人民币）￥</span></td>
                   <td class="lie" width="171"><span style="font-size:14px; font-weight:bold;">应纳税额（人民币）￥</span></td>
                   <td class="lie" width="171"><span style="font-size:14px; font-weight:bold;">其他费用（人民币）￥</span></td>
             </tr>
             <p id="sharesFirst"></p>
             <p id="sharesIn"></p>
             <p id="sharesOut"></p>
             <p id="sharesResult"></p>
       </table>
    </div>
 </div>
 
 <div id="fullReport" class="tabContainer" style="display:none;overflow:scroll; clear:both; margin:0 auto; text-align:center; height:400px; width:600px">
    
    <h1 id="h1" style="text-align:center;font-size:18px">股票管理全局</h1>
    <div id="shareFullReport">
       <table width="501" id="tb" style="border:1px solid #000000;" cellpadding="0" cellspacing="0"  bgcolor="#FFFFFF" align="center">
 	         <tr >
 	               <td class="lie" width="172" height="40px" ><span style="font-size:14px; font-weight:bold;">股票名称</span></td>
 	               <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">时间</span></td>
 	               <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">状态</span></td>
                   <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">操作股数</span></td>
                   <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">单价（人民币）￥</span></td>
                   <td class="lie" width="150" ><span style="font-size:14px; font-weight:bold;">总价格（人民币）￥</span></td>
                   <td class="lie" width="171"><span style="font-size:14px; font-weight:bold;">应纳税额（人民币）￥</span></td>
                   <td class="lie" width="171"><span style="font-size:14px; font-weight:bold;">其他费用（人民币）￥</span></td>
             </tr>
             <p id="sharesFullFirst"></p>
             <p id="sharesFullIn"></p>
             <p id="sharesFullOut"></p>
             <p id="sharesFullResult"></p>
       </table>
    </div>
  </div>
</body>
</html>
