<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta name="gmapkey" content="" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />

	<title>jqtransform-download by http://www.codefans.net</title>
    <style>
   .tabContainer{ margin:0 auto; position:relative; margin:0 auto;  background-color:#e0e3e2; border:3px solid #abadac; }
    </style>

<!--	<link rel="stylesheet" href="jqtransformplugin/jqtransform.css" type="text/css" media="all" />
	<link rel="stylesheet" href="demo.css" type="text/css" media="all" />
	
	<script type="text/javascript" src="requiered/jquery.js" ></script>
	<script type="text/javascript" src="jqtransformplugin/jquery.jqtransform.js" ></script>
	<script language="javascript">
		$(function(){
			$('form').jqTransform({imgPath:'jqtransformplugin/img/'});
		});
	</script>-->
	
    <script type="text/javascript">
    window.onload=function()//��window��onload�¼������������ϵ�ʱ��
	{
  		document.getElementById("payxd2_waiguo").style.display="none";
	}
    
    	function returnWaiguo(){
		var temp=document.getElementsByName("guojia");
    for(i=0;i<temp.length;i++){
        if(temp[i].checked){
			if(temp[i].value==3){
			document.getElementById("payxd2_waiguo").style.display="block";
			document.getElementById("payxd2_0").value="��һ��";
			}else{
				document.getElementById("payxd2_waiguo").style.display="none";
				document.getElementById("payxd2_0").value="���";
				}
        }
    }
       }
    </script>




	  
</head>
<body >
<div  class="tabContainer" style="clear:both; margin:0 auto;  height:550px; width:700px">
<div style="font-size:24px; margin-left:20px; border-bottom:1px solid #000000; margin-right:20px;margin-bottom:20px;font-family:'΢���ź�'; margin-top:20px">������Ϣ</div>
<div  style="margin:auto; width:600px; height:440px;background:#FFFFFF;" >
<div style=" margin-left:5px; padding-top:20px" >
	<s:form action="payxd2" >
        	<s:select name="hangye" label="������ҵ��" cssStyle="font-family:'΢���ź�'; font-size:16px" list="#session.hangye" listKey="piid" listValue="industryName"></s:select>	
       <br />
       <br />
   		 	<s:radio name="xingzhi" cssStyle="font-family:'΢���ź�'; font-size:16px" label="����ְҵ������" list="#{0:'��ͨ��Ա',1:'�߼�������Ա',2:'��������Ա'}"></s:radio>
        <br />
        <br />
        	<s:radio name="guojia" onclick="returnWaiguo();" cssStyle="font-family:'΢���ź�'; font-size:16px" label="���Ĺ���(����)��" list="#{1:'�й���½',2:'�й��ۣ��ģ�̨',3:'���'}"></s:radio>
        	<s:select name="waiguo" cssStyle="font-family:'΢���ź�'; font-size:16px;" list="#session.guojia" listKey="nid" listValue="langName"></s:select>
       </div>
       
       <br />
	   <br />
		<div align="center" style="display:none; width:200px; height:100px" id="4">
				<s:submit align="center" value="���"></s:submit>
	  </div>
				

	</s:form>
    </div>
    </div>
    </div>
</body>
</html>