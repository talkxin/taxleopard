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
<script type="text/javascript" src="share/js/hashmapjs.js"
	language="jscript" charset="UTF-8"></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/paychexD.js'></script>
<script type='text/javascript' src='dwr/interface/getiData.js'></script>
<script type="text/javascript"
	src="paychex/main/js/datepicker/WdatePicker.js" language="jscript"></script>
<script type='text/javascript' src='labor/js/jquery.min.js'></script>
<script type="text/javascript">
	var j$ = jQuery.noConflict();
</script>
<script type='text/javascript' src='geti/js/geti.js' language="jscript"
	charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="labor/css/reportCss.css" />
<script type='text/javascript' src='dwr/interface/getiD.js'></script>
<script type='text/javascript' src='geti/js/getiReport.js' language="jscript"
	charset="UTF-8"></script>	
</head>
<body>
	<!-- 添加个体工商收入 -->
	<div id="getiPage" style="display: none;">
		<ul>
			<li>收入时间：<input id="gtiTime" /></li>
			<li>收入额：<input id="gtiNumber" /></li>
			<li>是否含税：是<input type="radio" name="taxed" checked="checked"
				value="0" />否<input value="1" type="radio" name="taxed" />
			</li>
			<li>已纳税额：<input id="taxEdNumber" />
			</li>
		</ul>
	</div>
	
	<div id="geti" class="tabContainer" style="overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:750px">
    
    <h1 id="h1" style="text-align:center;font-size:18px">个体工商</h1>
    <input type="button" value="添加" onclick="onaddGetti();"/>
    <br/><br/>
    <div id="report">
       <table width="501" id="tb" style="border:1px solid #000000;" cellpadding="0" cellspacing="0"  bgcolor="#FFFFFF" align="center">
 	         <tr >
 	               <td class="lie" width="172" height="40px" ><span style="font-size:14px; font-weight:bold;">时间</span></td>
 	               <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">收入</span></td>
                   <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">应纳税额</span></td>
                   <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">应纳税所得额</span></td>
                   <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">税后收入</span></td>
                   <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">已交税额</span></td>
                   <td class="lie" width="150" ><span style="font-size:14px; font-weight:bold;">操作</span></td>
             </tr>
            <tbody id="getiReport"></tbody>
       </table>
       <div id="noMessage"></div>
    </div>
    </div>
</body>
</html>