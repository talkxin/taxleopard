<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>拍卖测试</title>
    <link rel="stylesheet" type="text/css" href="/TaxPersonalReporting1.0/labor/css/reportCss.css" />
		<script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/engine.js'></script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/util.js'></script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/interface/auctionD.js'></script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/labor/js/jquery.min.js'></script>
		<script type="text/javascript">
	           var j$ = jQuery.noConflict();
        </script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/labor/js/onServiceLoad.js'></script>
        <script type='text/javascript' src='/TaxPersonalReporting1.0/paychex/reportForm/js/swfobject.js'></script>
        <script type='text/javascript' src='/TaxPersonalReporting1.0/Auction/js/auctionReport.js'></script>

</head>

<body onload="onFindAllAuction(22);">
  
     <div id="report" class="tabContainer" style="overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:750px">
    
    <h1 id="h1" style="text-align:center;font-size:18px">拍卖</h1>

    <br/>
    <div id="auctionReport">

    </div>
    </div>
</body>
</html>
