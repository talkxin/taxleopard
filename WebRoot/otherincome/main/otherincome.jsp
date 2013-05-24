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
<script type="text/javascript"
	src="paychex/main/js/datepicker/WdatePicker.js" language="jscript"></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/paychexD.js'></script>
<script type='text/javascript' src='dwr/interface/OtherincomeData.js'></script>
<script type='text/javascript' src='labor/js/jquery.min.js'></script>
<script type="text/javascript">
	var j$ = jQuery.noConflict();
</script>
<script type='text/javascript' src='otherincome/js/otherincome.js'
	language="jscript" charset="UTF-8"></script>
<script type='text/javascript' src='dwr/interface/otherincomeD.js'></script>
<script type='text/javascript' src='otherincome/js/otherIncomeReport.js' language="jscript" charset="UTF-8"></script>
</head>
<body>
	<div id="addOtherincome" style="display: none;">
		<ul>
			<li>其他所得名称：<label><input id="otherName" />
			</label>
			</li>
			<li>获取时间：<label><input id="otherTime"
					onfocus="WdatePicker();" />
			</label>
			</li>
			<li>您获取的金额：<label><input id="otherNumber" onkeyup="replaceNotNumber(this);"/>
			</label>
			</li>
			<li>个人所得税：<label><input id="otherTax" value="0" onkeyup="replaceNotNumber(this);"/> </label>
			</li>
		</ul>
	</div>
	
  <div id="paimai" class="tabContainer" style="overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:750px">
    
    <h1 id="h1" style="text-align:center;font-size:18px">其他所得</h1>
    <input type="button" value="添加" onclick="onaddOtherincome();"/>
    <br/><br/>
    <div id="report">
       <table width="501" id="tb" style="border:1px solid #000000;" cellpadding="0" cellspacing="0"  bgcolor="#FFFFFF" align="center">
 	         <tr >
 	               <td class="lie" width="172" height="40px" ><span style="font-size:14px; font-weight:bold;">其他所得名称</span></td>
 	               <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">获取时间</span></td>
                   <td class="lie" width="145" ><span style="font-size:14px; font-weight:bold;">获取金额</span></td>
                   <td class="lie" width="130"><span style="font-size:14px; font-weight:bold;">个人所得税</span></td>
                   <td class="lie" width="150" ><span style="font-size:14px; font-weight:bold;">操作</span></td>
             </tr>
            <tbody id="otherIncomeReport"></tbody>
       </table>
       <div id="noMessage"></div>
    </div>
    </div>
</body>
</html>