<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type='text/javascript' src='dwr/interface/dwrTest.js'></script>
    <script type='text/javascript' src='dwr/engine.js'></script>
    <script type='text/javascript' src='dwr/util.js'></script>
    <script type='text/javascript' src='paychex/reportForm/js/swfobject.js'></script>
    <script type="text/javascript" src="paychex/reportForm/js/monthHistogram.js"></script>
    <script type='text/javascript' src='dwr/interface/paychexD.js'></script>
    <script type="text/javascript">

      function toDataEntry(){
      	self.location.href="toDataEntry"
      }
      function toMonthPie(){
      	self.location.href="toMonthPie"
      }
      
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div id="month_chart"></div>
    <div  style="text-align:center;position:fixed;bottom:0;z-index:1000;">
        <input type="button" onclick="javascript:findWageMonthHg('month_chart','1000','500');"value="月总" />
        <input type="button" onclick="javascript:toMonthPie()" value="饼状图" />
        <input type="button" onclick="javascript:toDataEntry()" value="返回数据录入模式" />
    </div>
</body>
</html>