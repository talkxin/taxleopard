<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�ޱ����ĵ�</title>
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
<div style="font-size:24px; margin-left:20px; margin-bottom:20px;font-family:'΢���ź�'; margin-right:20px;border-bottom:1px solid #000000; margin-top:20px">������Ϣ</div>
<div  style="margin:auto; width:650px; height:510px;background:#FFFFFF;" >
<div style=" margin-left:30px; padding-top:20px" >
	<s:form action="payxd3" >
	<s:select name="wenti1" label="����������й����ھ�ס�Ƿ���һ��?" cssStyle="font-family:'΢���ź�'; font-size:16px" list="#{1:'��',2:'��' }"></s:select>
	

        <br />
        <s:select name="wenti1" label="���ڽ�����Ƿ����й�������������ס��5����˰���?" cssStyle="font-family:'΢���ź�'; font-size:16px" list="#{1:'��',2:'��' }"></s:select>

        <br />
        <s:select name="wenti1" label="���һ��������ס��5���ں������У��Ƿ���һ����Ⱦ�ס����90��?(��1994��1��1����)" cssStyle="font-family:'΢���ź�'; font-size:16px" list="#{1:'��',2:'��' }"></s:select>
    	<br />
    	<s:select name="wenti1" label="�������й��ĵ������Ƿ�ס��һ��?" cssStyle="font-family:'΢���ź�'; font-size:16px" list="#{1:'��',2:'��' }"></s:select>
		<br/>
        <div div class="rowElem" title="���뾳��ȷ����" style=" width:200px; height:20px" >
        <input type="button" value="������뾳����Ԫ"    onclick="window.location='/paycrj'" />
        </div><br />
        	
          <input type="button" value="��һ��"  onclick="window.location='/payxd2'" />
           <s:submit value="���"></s:submit>
        </div>
   	</s:form>
    </div>
    </div>
</div>
</div>
</body>
</html>
