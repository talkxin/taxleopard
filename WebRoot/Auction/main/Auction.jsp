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
<link rel="stylesheet" type="text/css" href="labor/css/reportCss.css" />
<script type="text/javascript" src="share/js/hashmapjs.js"
	language="jscript" charset="UTF-8"></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/paychexD.js'></script>
<script type='text/javascript' src='dwr/interface/AuctionData.js'></script>
<script type='text/javascript' src='labor/js/jquery.min.js'></script>
<script type="text/javascript">
	var j$ = jQuery.noConflict();
</script>
<script type="text/javascript"
	src="paychex/main/js/datepicker/WdatePicker.js" language="jscript"></script>
<script type="text/javascript" src="Auction/js/Auction.js"
	language="jscript" charset="UTF-8"></script>
<script type='text/javascript' src='dwr/interface/auctionD.js'></script>
<script type='text/javascript' src='Auction/js/AuctionReport.js' language="jscript" charset="UTF-8"></script>
</head>

<body>
	<!-- 添加拍卖 -->
	<div id="addAuctionInfo" style="display: none;">
		<ul>
			<li>拍卖品名称:<label><input type="text" id="auctionName" />
			</label>
			</li>
			<li>拍卖时间：<label><input type="text" id="auctionTime"
					onfocus="WdatePicker();" />
			</label>
			</li>
			<li>拍卖品原值：<label><input type="text"
					id="auctionOldNumber" onkeyup="replaceNotNumber(this);"/>
			</label>
			</li>
			<li>拍卖所得：<label><input type="text" id="auctionNumber" onkeyup="replaceNotNumber(this);"/>
			</label>
			</li>
			<li>是否含税：<label>含税<input type="radio" name="taxed" checked="checked" value="0"/>不含税<input
					type="radio" name="taxed" value="1"/>
			</label>
			</li>
			<li>其他费用：<label><input type="text" id="outCastNumber"
					value="0" onkeyup="replaceNotNumber(this);"/>
			</label>
			</li>
		</ul>
	</div>
	
	<div id="report" class="tabContainer" style="overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:750px">
    
    <h1 id="h1" style="text-align:center;font-size:18px">拍卖</h1>
    <input type="button" value="添加" onclick="onaddAuctionInfo()"/>
    <br/><br/>
    <div id="auctionReport">

    </div>
    </div>
</body>
</html>
