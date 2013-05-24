<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>稿酬测试</title>
    <link rel="stylesheet" type="text/css" href="/TaxPersonalReporting1.0/labor/css/reportCss.css" />
		<script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/engine.js'></script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/util.js'></script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/interface/remuD.js'></script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/labor/js/jquery.min.js'></script>
		<script type="text/javascript">
	           var j$ = jQuery.noConflict();
        </script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/labor/js/onServiceLoad.js'></script>
        <script type='text/javascript' src='/TaxPersonalReporting1.0/paychex/reportForm/js/swfobject.js'></script>
        <script type='text/javascript' src='/TaxPersonalReporting1.0/Remuneration/js/remunerationReport.js'></script>
       <script type='text/javascript' src='/TaxPersonalReporting1.0/Remuneration/js/remunerationReport.js'></script>
</head>

<body onload="onFindRemuByPress(4,1);">
  <div id="report" class="tabContainer" style="overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:750px">
    
    <h1 id="h1" style="text-align:center;font-size:18px">稿酬</h1>
    <div align="left" style="font-family:'微软雅黑';margin-left:110px;font-size:16px;">请选择年份：
        <select id="nian" onchange="onChooseYear();" name="nianFen">
          <option value="2005">2005</option>
          <option value="2006">2006</option>
          <option value="2007">2007</option>
          <option value="2008">2008</option>
          <option value="2009">2009</option>
          <option value="2010">2010</option>
          <option value="2011">2011</option>
          <option value="2012">2012</option>
          <option value="2013">2013</option>
          <option value="2014">2014</option>
          <option value="2015">2015</option>
        </select>
    </div>
    <br/>
    <div id="remuReport">

     </div>
   </div>
   
  <div id="allReport" class="tabContainer" style="overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:750px">
    
    <h1 id="h1" style="text-align:center;font-size:18px">稿酬</h1>
    <div align="left" style="font-family:'微软雅黑';margin-left:110px;font-size:16px;">请选择年份：
        <select id="nianFull" onchange="onChooseFullYear();" name="nianFen">
          <option value="2005">2005</option>
          <option value="2006">2006</option>
          <option value="2007">2007</option>
          <option value="2008">2008</option>
          <option value="2009">2009</option>
          <option value="2010">2010</option>
          <option value="2011">2011</option>
          <option value="2012">2012</option>
          <option value="2013">2013</option>
          <option value="2014">2014</option>
          <option value="2015">2015</option>
        </select>
    </div>
    <br/>
    <div id="allRemuReport">

     </div>
   </div>
   
    
   <div id="reportByPr" class="tabContainer" style="overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:750px">
    
    <h1 id="h1" style="text-align:center;font-size:18px">稿酬</h1>

    <br/>
    <div id="remuReportByPr">

    </div>
    </div>
</body>
</html>
