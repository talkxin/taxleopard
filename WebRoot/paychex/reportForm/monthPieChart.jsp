<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type='text/javascript' src='dwr/interface/dwrTest.js'></script>
    <script type='text/javascript' src='dwr/engine.js'></script>
    <script type='text/javascript' src='dwr/util.js'></script>
    <script type='text/javascript' src='paychex/reportForm/js/swfobject.js'></script>
    
    <script type='text/javascript' src='dwr/interface/dwrTest.js'></script>
    <script type="text/javascript" src="paychex/reportForm/js/monthPieChart.js"></script>
    <script type='text/javascript' src='dwr/interface/paychexD.js'></script>
    <script type="text/javascript">
    function toDataEntry(){
    	self.location.href="toDataEntry"
    }
    function toMonthHg(){
    	self.location.href="toMonthHg"
    }

    </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   
    <div style="width:50px;height:250px;" id="month_chart">
    </div>
    <div align="right" style="position:fixed;bottom:0;z-index:1000;">
        <input type="button" onclick="javascript:findWageMonthPie('month_chart','1000','500');"value="月总" />
        <input type="button" onclick="javascript:toMonthHg()" value="柱状图" />
        <input type="button" onclick="javascript:toDataEntry()" value="返回数据录入模式" />
    </div>
   
</body>
</html>