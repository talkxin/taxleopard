<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>���뾳����</title>
<link rel="stylesheet" href="jqtransformplugin/jqtransform.css" type="text/css" media="all" />
        <link rel="stylesheet" href="demo.css" type="text/css" media="all" />
        
     <!--   <script type="text/javascript" src="requiered/jquery.js" ></script>
        <script type="text/javascript" src="jqtransformplugin/jquery.jqtransform.js" ></script>
        <script language="javascript">
            $(function(){
                $('form').jqTransform({imgPath:'jqtransformplugin/img/'});
            });
        
        </script>-->
 <style type="text/css">
 body{
 font-size:12px;
 font-family:"΢���ź�";
 }
 .list{
text-align:center;
border: 1px solid #ccc;
font-size:12px;
               
}
.list1{
background: #e5e5e5  top left repeat-x;

}

 .tabContainer{ margin:0 auto; position:relative; margin:0 auto;  background-color:#e0e3e2; border:3px solid #abadac; }	

</style>
</head>

<body>
<div  class="tabContainer" style="clear:both; margin:0 auto;  height:400px; width:700px">
<div style="font-size:24px; margin-left:20px; margin-bottom:20px;font-family:'΢���ź�'; border-bottom:1px solid #000000; margin-right:20px; margin-top:20px">���뾳����</div>
<div  style=" margin:30px auto; width:600px; height:280px;background:#FFFFFF;" >
<form action="../nianfen.htm" method="post">
<br />
<table width="500px" align="center">
<tr>
<td width="74" height="30px"><span style="font-family:'΢���ź�'; font-size:14px">�뾳ʱ��:</span></td>
<td width="414"><input name="" type="text" /></td>
</tr>
<tr>
<td height="30px"><span style="font-family:'΢���ź�'; font-size:14px">����ʱ��:</span></td>
<td><input name="" type="text" /></td>
</tr>
<tr>
<td height="30px" align="right"></td>
<td><div style="margin-left:50px;"><input type="button" value="���" />
    &nbsp;
    <input type="button" value="ȡ��"  onclick="window.location='xiangdao2.html'"/></div></td>
</tr>
</table>
<br />
  <table width="500px" height="80px" border="0"  cellpadding="0" cellspacing="0" class="list" align="center" >
         <tr class="list1">
           <td>�뾳ʱ��</td>
           <td>����ʱ��</td>
           <td>�ڻ�������</td>
           <td>����</td>
         </tr>
         <tr>
           <td>&nbsp;</td>
           <td>&nbsp;</td>
           <td>&nbsp;</td>
           <td>&nbsp;</td>
         </tr>
         <tr>
           <td>&nbsp;</td>
           <td>&nbsp;</td>
           <td>&nbsp;</td>
           <td>&nbsp;</td>
         </tr>
  </table>


</form>
</div>
</div>
</body>
</html>
