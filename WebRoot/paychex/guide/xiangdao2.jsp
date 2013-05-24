<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
   .tabContainer{ margin:0 auto; position:relative; margin:0 auto;  background-color:#e0e3e2; border:3px solid #abadac; }
    </style>
   	    <link rel="stylesheet" href="jqtransformplugin/jqtransform.css" type="text/css" media="all" />
        <link rel="stylesheet" href="demo.css" type="text/css" media="all" />
        
      <!--  <script type="text/javascript" src="requiered/jquery.js" ></script>
        <script type="text/javascript" src="jqtransformplugin/jquery.jqtransform.js" ></script>
        <script language="javascript">
            $(function(){
                $('form').jqTransform({imgPath:'jqtransformplugin/img/'});
            });
        
        </script>-->
        
        <script language="javascript">

		</script>
</head>

<body>
<div  class="tabContainer" style="clear:both; margin:0 auto;  height:610px; width:750px">
<div style="font-size:24px; margin-left:20px; margin-bottom:20px;font-family:'微软雅黑'; margin-right:20px;border-bottom:1px solid #000000; margin-top:20px">个人信息</div>
<div  style="margin:auto; width:650px; height:510px;background:#FFFFFF;" >
<div style=" margin-left:30px; padding-top:20px" >
	<s:form action="payxd3" >
	<s:select name="wenti1" label="您今年度在中国境内居住是否满一年?" cssStyle="font-family:'微软雅黑'; font-size:16px" list="#{1:'是',2:'否' }"></s:select>
	

        <br />
        <s:select name="wenti1" label="您在今年度是否在中国境内有连续居住满5个纳税年度?" cssStyle="font-family:'微软雅黑'; font-size:16px" list="#{1:'是',2:'否' }"></s:select>

        <br />
        <s:select name="wenti1" label="最近一个连续居住满5年期后的年度中，是否有一个年度居住少于90天?(自1994年1月1日起)" cssStyle="font-family:'微软雅黑'; font-size:16px" list="#{1:'是',2:'否' }"></s:select>
    	<br />
    	<s:select name="wenti1" label="最您在中国的第六年是否住满一年?" cssStyle="font-family:'微软雅黑'; font-size:16px" list="#{1:'是',2:'否' }"></s:select>
		<br/>
        <div div class="rowElem" title="出入境精确管理" style=" width:200px; height:20px" >
        <input type="button" value="进入出入境管理单元"    onclick="window.location='/paycrj'" />
        </div><br />
        	
          <input type="button" value="上一步"  onclick="window.location='/payxd2'" />
           <s:submit value="完成"></s:submit>
        </div>
   	</s:form>
    </div>
    </div>
</div>
</div>
</body>
</html>
