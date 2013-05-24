<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>测试股票管理</title>
    <link rel="stylesheet" type="text/css" href="/TaxPersonalReporting1.0/labor/css/reportCss.css" />
		<script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/engine.js'></script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/util.js'></script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/interface/sharesReportD.js'></script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/labor/js/jquery.min.js'></script>
		<script type="text/javascript">
	           var j$ = jQuery.noConflict();
        </script>
		<script type='text/javascript' src='/TaxPersonalReporting1.0/labor/js/onServiceLoad.js'></script>
        <script type='text/javascript' src='/TaxPersonalReporting1.0/paychex/reportForm/js/swfobject.js'></script>
        <script type='text/javascript' src='/TaxPersonalReporting1.0/share/js/sharesReport.js'></script>

</head>

<body onload="onfindShareMessage(22,14);onfindFullFirst(22);">
  <div  class="tabContainer" style="display:none; overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:750px">
    
    <h1 id="h1" style="text-align:center;font-size:18px">股票管理</h1>
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
    <div  class="tabContainer" style="overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:750px">
    
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
    <div style="float:left;margin-left:40%; margin-top:20px"> <input type="button"  value="算" onclick="javascript:findResults();"/>
    </div>
  </div>

</body>
</html>
