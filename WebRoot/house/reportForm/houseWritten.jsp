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
    <script type="text/javascript">
	      var j$ = jQuery.noConflict();
    </script>
</head>

<body onload="onfindWriHouse(22,1);">
  <div  class="tabContainer" style="clear:both; margin:0 auto; text-align:center; height:550px; width:700px">
    <h1 id="h1" style="text-align:center;font-size:18px">房产管理</h1>

    <br>
    <div id="report">
       
    </div>
  </div>

</body>
</html>
