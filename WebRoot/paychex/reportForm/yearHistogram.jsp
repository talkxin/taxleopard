<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type='text/javascript' src='dwr/interface/dwrTest.js'></script>
    <script type='text/javascript' src='dwr/engine.js'></script>
    <script type='text/javascript' src='dwr/util.js'></script>
    <script type='text/javascript' src='paychex/reportForm/js/swfobject.js'></script>
    <script type="text/javascript" src="paychex/reportForm/js/yearHistogram.js"></script>
    <script type="text/javascript">
       function toDataEntry(){
    	self.location.href="toDataEntry"
       }
       function toYearPie(){
         var year=yearHg;
    	 self.location.href="toYearPie?year="+year
       }
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
  <body>
    <div id="my_chart" style="padding: 0px; margin:10px; border: 1px solid lightblue; width: 250px; height: 200px;" onmouseout="__onrollout();"></div>
    <div id="month_chart"></div>
    <div align="right" style="position:fixed;bottom:0;z-index:1000;">
        <input type="button" onclick="javascript:findWageYearHg('my_chart','1000','500',yearHg);" value="年总" />
        <input type="button" onclick="javascript:toYearPie()" value="饼状图" />
        <input type="button" onclick="javascript:toDataEntry()" value="返回数据录入模式" />
    </div>
 </body>
</html>