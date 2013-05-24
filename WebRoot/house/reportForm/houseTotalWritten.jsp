<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
   <title>房产管理</title>
    <style type="text/css">
     body{font-size:12px; margin:0; font-family:"微软雅黑"}
     td{
        border:1px solid #000000;
     }
     .userlist{ background-color:#AFEEEE}
     .userlist1{background-color:#E7EFD3}
     .list1{
        padding-top:10px;
        border-bottom:1px solid #CCCCCC;
     }
     .tabContainer{ margin:0 auto; position:relative; margin:0 auto;  background-color:#e0e3e2; border:3px solid #abadac; }
    </style>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/interface/houseReportD.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/engine.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/util.js'></script>
     <script type='text/javascript' src='/TaxPersonalReporting1.0/house/js/houseReport.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/paychex/reportForm/js/jquery-1.4.2.min.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/paychex/reportForm/js/swfobject.js'></script>
    <script type="text/javascript">
	      var j$ = jQuery.noConflict();
    </script>
    <script type="text/javascript" src='/TaxPersonalReporting1.0/house/js/houseReport.js'></script>
</head>

<body onload="onfindOverallWriEveryHouse(22);">
  <div  class="tabContainer" style="clear:both; margin:0 auto; text-align:center; height:450px; width:700px;overflow:scroll ">
    <h1 id="h1" style="text-align:center;font-size:18px">房产管理</h1>

    <br>
       <span onclick="JavaScript:ChangeDiv('0','JKDiv_',2)"style="cursor: hand;color:#FA0707;font-size:18px;">文字报表</span> 
       <span onclick="JavaScript:ChangeDiv('1','JKDiv_',2);onFindEveryHouseHg(22);;" style="cursor: hand;color:#FA0707;font-size:18px;">柱状图</span> 
       <span onclick="JavaScript:ChangeDiv('2','JKDiv_',2);onFindEveryHousePie(22);;" style="cursor: hand;color:#FA0707;font-size:18px;">饼状图</span>
       <p></p><p></p>
       <div id="JKDiv_0"></div>
	   <div id="JKDiv_1" style="display: none;"></div>
	   <div id="JKDiv_2" style="display: none;"></div>
  </div>

</body>
</html>
