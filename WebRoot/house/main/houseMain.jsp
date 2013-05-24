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
		<!--link href="house/artDialog4.1.2/artDialog/_doc/demo.css"
			rel="stylesheet" type="text/css" /-->
		<link rel="stylesheet" type="text/css"
			href="labor/css/onServiceLoad.css" />
		<link rel="stylesheet" type="text/css" href="house/css/divstyle.css" />
		<link rel="stylesheet" type="text/css" href="labor/css/reportCss.css" />
		<script type="text/javascript" src="share/js/hashmapjs.js"
	language="jscript" charset="UTF-8"></script>
		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/paychexD.js'></script>
		<script type='text/javascript' src='dwr/interface/houseData.js'></script>
		<script type='text/javascript' src='labor/js/jquery.min.js'></script>
		<script type="text/javascript">
	var j$ = jQuery.noConflict();
</script>
		<script type='text/javascript' src='labor/js/onServiceLoad.js'></script>
		<script type="text/javascript"
			src="paychex/main/js/datepicker/WdatePicker.js" language="jscript"></script>
		<script type='text/javascript' src='house/js/houseMain.js'
			language="jscript" charset="UTF-8"></script>

		<script type='text/javascript' src='house/js/houseReport.js'></script>
		<script type='text/javascript' src='dwr/interface/houseReportD.js'></script>
	       <script type='text/javascript' src='paychex/reportForm/js/swfobject.js'></script>
</head>

	<body>
		<!-- 主操作层 -->
		<div id="housePageMain">
			<div id="housePage"></div>
		</div>
		<!-- 添加房产信息 -->
		<div id="addHouseInfoPage" style="display: none;">
			<div class="main">
				<ul id="ul">
					<li>
						您的房产昵称：
						<label>
							<input type="text" id="houseName" />
						</label>
					</li>
					<li>
						您的房产所在地：
						<label>
							<select name="select" id="houseCity"
								onchange="onGetCity(this.value,'houseAdd');">
							</select>
							<select name="select2" id="houseAdd">
							</select>
						</label>
					</li>
					<li>
						您该房产的够买时间：
						<label>
							<input type="text" id="houseTime" onfocus="WdatePicker();" />
						</label>
					</li>
					<li>
						您的房产类型：
						<label>
							<select id="houseType" onchange="oncompensationDisplay()">
							</select>
						</label>
					</li>
					<li id="compensationDisplay" style="display: none;">
						您的补偿款：&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
							<input type="text" id="houseCompensation" value="0"
								onkeyup=
	replaceNotNumber(this);
/>
						</label>
					</li>
					<li>
						你的房产面积：
						<label>
							<input type="text" id="houseArea" onkeyup=
	replaceNotNumber(this);
/>
						</label>
					</li>
					<li>
						您的房产购买合同款：
						<label>
							<input type="text" id="houseNumber"
								onkeyup=
	replaceNotNumber(this);
/>
						</label>
					</li>
					<li>
						您购买房产时所交税费：
						<label>
							<input type="text" id="housetaxedNumber"
								onkeyup=
	replaceNotNumber(this);
/>
						</label>
					</li>
					<li>
						您的装修费用：
						<label>
							<input type="text" id="houseRenovation"
								onkeyup=
	replaceNotNumber(this);
/>
						</label>
					</li>
					<li>
						您的房产房产总花费是：
						<label>
							<input type="text" id="houseAllNumber" readonly="readonly"
								onfocus="onhouseAllNumber();" />
						</label>
					</li>
					<li>
						是否为家庭唯一住房：

						<label>
							<input type="radio" name="houseTaxType" id="houseTaxType_0"
								checked="checked" value="0" />
							是
						</label>

						<label>
							<input type="radio" name="houseTaxType" value="1"
								id="houseTaxType_1" />
							否
						</label>
					</li>
				</ul>
			</div>
		</div>
		<div id="Houselabor" class="main" style="display: none;">
			<ul class="ul1">
				<li>
					<img src="house/images/Housezulin.png" onclick=
	onOpenZlPage();
/>
					<br />
					<br />
					房产租赁
				</li>
				<li>
					<img src="house/images/Housesold.png" onclick=
	onOpenHouseSold();
/>
					<br />
					<br />
					房产转让
				</li>
				<li style="display: none;">
					<img src="house/images/Housetax.png" />
					<br />
					<br />
					房产税
				</li>
			</ul>
		</div>
		<div id="fangchanzhuanrangPage" style="display: none;">
			<ul class="ul">
				<li>
					您房产转让的时间：
					<label>
						<input type="text" id="transferTime" size="17"
							onfocus="WdatePicker();" />
					</label>
				</li>
				<li>
					您房产交易价格：
					<input type="text" id="transferNumber" size="17" />
				</li>
				<li>
					城建税级别：
					<select id="cityConstructionTax">
					</select>
				</li>
				<li>
					您的装修费用：
					<label>
						<input type="text" id="ishouseRenovation" />
					</label>
				</li>
				<li>
					中介费用：
					<label>
						<input type="text" id="Intermediary" size="22" />
					</label>
				</li>
				<li style="display: none;">
					已交税款
					<label>
						<input type="text" id="taxEdNumber" />
					</label>
				</li>
			</ul>
		</div>
		<!-- 房产出租 -->
		<div id="fangchanchuzuPage" style="display: none;">
			<div>
				<div id="housePopPage1">
					<div id="housePopPage2"></div>
				</div>
				<div style="margin-top: -50px">
					<div id="wriLesseeReport1" class="tabContainer"
						style="clear: both; margin: 0 auto; text-align: center; height: 300px; width: 810px;overflow: scroll;">
						<h1 id="h1" style="text-align: center; font-size: 18px">
							房产出租信息
						</h1>
						<br />
						<div id="wriLesseeReport"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- 添加承租人 -->
		<div id="chengzuren" style="display: none;">
			<ul id="ul">
			<li>
				
				<label><input type="button" onclick="onOpenZlpop()" value="查询已添加的承租人"/></label>
			</li>
				<li>
					承租人姓名：
					<label>
						<input type="text" id="rentalName"/>
					</label>
				</li>
				<li>
					承租人身份号：

					<label>
						<input type="text" id="rentalIdNumber" />
					</label>
				</li>
			</ul>
		</div>
		<!-- 添加出租合同 -->
		<div id="fangchanchuzu" style="display: none;">
			<ul id="ul">
				<li>
					合同租期：
					<label>
						<input type="text" id="rentalStartTime" onfocus="WdatePicker();" />
						到
						<input type="text" id="rentalEndTime" onfocus="WdatePicker();" />
					</label>
				</li>
				<li>
					合同租金：

					<label>
						<input type="text" id="rentalNumber" onkeyup="replaceNotNumber(this);"/>
					</label>
				</li>
				<li>
					修缮费用：
					<label>
						<input type="text" id="rentalRenovation" onkeyup="replaceNotNumber(this);"/>
					</label>
				</li>
				<li>
					其他税费：
					<label>
						<input type="text" id="rentalTaxed" onkeyup="replaceNotNumber(this);"/>
					</label>
				</li>
		</div>
		<div id="zlpopPage" style="display: none;">
			<table>
				<tr>
					<th style="width: 55px;"></th>
					<th style="width: 55px;"></th>
					<tbody id="zlpopTb"></tbody>
				</tr>
			</table>
		</div>
<!-- 全局报表 -->		
 <div id="quanJu" class="tabContainer" style="display:none;clear:both; margin:0 auto; text-align:center; height:400px; width:600px;overflow:scroll">
     <h1 id="h1" style="text-align:center;font-size:18px">房产管理</h1>

     <br>
       <span onclick="JavaScript:ChangeDiv('0','JKDiv_',2);"style="cursor: hand;color:#FA0707;font-size:18px;">文字报表</span> 
       <span onclick="JavaScript:ChangeDiv('1','JKDiv_',2);onFindEveryHouseHg(window.sessionUID);" style="cursor: hand;color:#FA0707;font-size:18px;">柱状图</span> 
       <span onclick="JavaScript:ChangeDiv('2','JKDiv_',2);onFindEveryHousePie(window.sessionUID);" style="cursor: hand;color:#FA0707;font-size:18px;">饼状图</span>
       <p>
       <div id="JKDiv_0"></div>
	   <div id="JKDiv_1" style="display: none;"></div>
	   <div id="JKDiv_2" style="display: none;"></div>
  </div>
 <!-- 某房产租赁与转让合并的报表 -->	 
 <div id="renTra" class="tabContainer" style="display:none;clear:both; margin:0 auto; text-align:center; height:400px; width:600px;overflow:scroll">
    <h1 id="h1" style="text-align:center;font-size:18px">租赁与转让信息</h1>
    <br>
    <div id="report"></div>
 </div>
  </body>
</html>
