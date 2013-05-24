<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>功能-填写表单</title>
<head>
   <script>
	(function() {
		var _skin, _jQuery;
		var _search = window.location.search;

		document
				.write('<scr'
						+ 'ipt src="house/artDialog4.1.2/artDialog/artDialog.source.js?skin='
						+ (_skin || 'default') + '"></sc' + 'ript>');
		window._isDemoSkin = !!_skin;
	})();
     </script>
 	 <script type='text/javascript' src='dwr/interface/paychexD.js'></script>
 	 <script type='text/javascript' src='dwr/engine.js'></script>

 	 <script type='text/javascript' src='dwr/util.js'></script>
	<script type="text/javascript" src="paychex/main/paychex.js" language="jscript" charset="UTF-8"></script>
	<script type="text/javascript" src="paychex/main/js/datepicker/WdatePicker.js" language="jscript"></script>
	<script type="text/javascript" src="paychex/main/js/prizeList.js" language="jscript"></script>
<link rel="stylesheet" type="text/css" href="paychex/main/frame091107[1].css" />
<link rel="stylesheet" type="text/css" href="paychex/main/regForm.css">

<style type="text/css">
.ui-helper-hidden { display: none; }
.ui-helper-clearfix:after { content: "."; display: block; height: 0; clear: both; visibility: hidden; }
.ui-helper-clearfix { display: inline-block; }
/* required comment for clearfix to work in Opera \*/
* html .ui-helper-clearfix { height:1%; }
.ui-helper-clearfix { display:block; }
.title{
	width:70px;
	float:left;
	padding-bottom:5px;
	padding-top:10px;
	}
	.button{
	width:500px;
	float:left;
	padding-bottom:5px;
	padding-top:10px;}
.list{
text-align:center;
border: 1px solid #ccc;
font-size:12px;
               
}
.list1{
background: #e5e5e5  top left repeat-x;
	
}
</style>

</head>
<body>

<div  class="tabContainer ui-helper-clearfix ui-corner-all"style="clear:both; margin:0 auto; text-align:center; height:550px; width:700px">
<h1><script>window.sessionTime</script>工资薪金信息</h1>
<div style=" width:630px; height:30px; margin:0 auto; padding-top:15px; ">
<ul  id="tabCot_product-li-currentBtn-">
   <li class="currentBtn"><a href="javascript:void(0)" title="基础工资" rel="1">基础工资</a></li>
   <li><a href="javascript:void(0)" title="奖金" rel="2">奖金</a></li>
   <li><a href="javascript:void(0)" title="补贴" rel="3">补贴</a></li>
   <li><a href="javascript:void(0)" title="分红" rel="4">分红</a></li>
   <li><a href="javascript:void(0)" title="五险一金" rel="5">五险一金</a></li>
   <li><a href="javascript:void(0)" title="商业保险" rel="6">商业保险</a></li>
   <li><a href="javascript:void(0)" title="扣除费用" rel="7">扣除费用</a></li>
   <li><a href="javascript:void(0)" title="退职费" rel="8">退职费</a></li>
   <li><a href="javascript:void(0)" title="退养费" rel="9">退养费</a></li>
   <li style="display: none;"><a href="javascript:void(0)" title="其他" rel="10">其他</a></li>
</ul>
</div>
<br />
<form>

<!--基础工资-->
    <div id="tabCot_product_1" class="form-panel " align="center" style="width:700px; height:410px">
     <div style="font-size:12px; text-align:left; padding-bottom:5px;  padding-left:35px; font-weight:bold;"> 基础工资</div>
      <fieldset class="ui-corner-all" style="width:630px; height:355px">
       <table width="500px" align="center">
       <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
       		<tr><td height="30px" align="right">
        您的公司名称：
        </td>
        <td align="left">
        <input id="companyName" type="text"/>
               	</td>
       		</tr>
       		<tr>
       		<td align="right">您的工资是由：</td>
       		<td align="left"><select id="companType">
       		<option value="0">中国境内注册公司支付</option>
       		<option value="1">中国境外注册公司支付</option>
       		<option value="2">中国境内和境外注册公司支付</option>
       		</select></td>
       		</tr>
            <tr><td height="30px" align="right">
        您的入职时间：
        </td>
        <td align="left">
        <input id="incomeDay" type="text" onClick="WdatePicker();"/> 
        	</td></tr>
            <tr><td height="30px" align="right">
        您的工作地区：
        </td>
        <td align="left">
        <select id="orgNation" onchange="getProvince(this.value);"></select>
        <select id="orgProvince" onchange="getCity(this.value);"></select>
        <select id="orgCity"></select>
        	</td></tr>
            <tr><td align="right" height="30px">
       您的薪金制度：
       </td>
        <td align="left">
          <input id="payTypeM" name="RadioGroup1" type="radio" id="RadioGroup1_0" value="0" onclick="payType();" />
          月薪制
          <input id="payTypeY" type="radio" name="RadioGroup1" value="1" id="RadioGroup1_1" onclick="payType();"/>年薪制
                  
        	</td></tr>
	<tr id="yfxsj" style="display: block;"><td height="30px" align="right">
     	您的发薪时间：
        </td>
        <td align="left">
        <select id="yuexinriqi">
        </select>
        	</td></tr>
       <tr id="nfxsj" style="display: none;"><td height="30px" align="right">
        您的发薪时间：
        </td>
        <td align="left" >
        <input id="nianfaxinriqi" type="text" onclick="WdatePicker()"/>
        </td></tr>
		<tr><td height="30px" align="right">
        您的合同薪金为：
        </td>
        <td align="left">
        <input id="payNumber" onkeyup="replaceNotNumber(this);" type="text">
         
        </td></tr>

     </table>
      </fieldset>
    </div>
  
     <!--奖金-->
  <div id="tabCot_product_2" class="form-panel  ui-helper-hidden " align="center"  style="width:700px; height:410px">
 
  <div style="font-size:12px; text-align:left; padding-bottom:5px;  padding-left:35px; font-weight:bold;"> 奖金</div>
      <fieldset class="ui-corner-all" style="height:355px; width:630px">
<div style="float:left; margin-top:20px; margin-left:40px; width:250px">
           奖金类型:<input type="text" id="prizeOutPut" name="prizeOutPut"
                onkeyup="keySelectHistory(this)" onblur="myClose(0);"/>
            <div id="prizeRelated"
                style="border:1px solid #f990033;display:'none';width:335;">
                <table id="prizeTab" cellpadding="0" border="0" cellspacing="0">
                </table>
                <a id="prizeX" href='javascript:;' onclick='myClose(0)'
                    style="display:none">关闭</a>
            </div>
       </div>
      <div  style="float:left; margin-top:20px; margin-left:20px">
        奖金数额:<input id="prizeNumber" onkeyup="replaceNotNumber(this);" type="text" style="width:150px">
        </div>
           
          <div style="margin-left:300px; margin-top:60px; margin-bottom:60px"> <ul><li style="width:80px; height:30px; text-align:center ;line-height:30px; margin-left:60px"><a href="#" onclick="canzhaoPrize();">参照上月</a></li><li style="width:60px; height:30px; text-align:center ;line-height:30px;margin-left:10px"><a id="Prizecaozuo" href="#" onclick="addPrize();">添加</a></li></ul></div>
      
   
        <table width="500px" height="80px" border="0"  cellpadding="0" cellspacing="0"align="center" class="list"  style="margin-top:120px"  >
        
    <tr class="list1">
        	  <th>奖金类型</th>
        	  <th>奖金数额</th>
        	  <th>应纳税额</th> 
        	  <th>操作</th>
        	</tr>
            <tbody id="prizeTable"></tbody>
        </table>
      </fieldset>
    </div>
    
    <!--补贴-->
     <div id="tabCot_product_3" class="form-panel ui-helper-hidden"  align="center" style="width:700px; height:410px">
     <div style="font-size:12px; text-align:left; padding-bottom:5px;  padding-left:35px; font-weight:bold;"> 补贴</div>
       		
      <fieldset class="ui-corner-all"  style="width:630px; height:355px">
     <div style="float:left; margin-top:20px; margin-left:40px; width:250px">补贴类型：
        <input type="text" id="subsidyOutPut" name="subsidyOutPut"
                onkeyup="keySelectHistory(this);" onblur="myClose(1);"/>
            <div id="subsidyRelated"
                style="border:1px solid #f990033;display:'none';width:335;">
                <table id="subsidyTab" cellpadding="0" border="0" cellspacing="0">
                </table>
                <a id="subsidyX" href='javascript:;' onclick='myClose(1);'
                    style="display:none">关闭</a>
            </div>
     </div>
       <div style="float:left; margin-top:20px; margin-left:20px">
        补贴数额:
        	<input id="subsidyNumber" onkeyup="replaceNotNumber(this);" type="text" style="width:150px"></div>
       <div style="margin-left:300px; margin-top:60px; margin-bottom:60px;"> <ul><li style="width:80px; height:30px; text-align:center ;line-height:30px; margin-left:60px"><a onclick="canzhaoSubsidy();" href="#">参照上月</a></li><li style="width:60px; height:30px; text-align:center ;line-height:30px;margin-left:10px"><a id="Subsidycaozuo" onclick="addSubsidy();" href="#">添加</a></li></ul></div>
            
       
      <table width="500px" height="80px" border="0"  cellpadding="0" cellspacing="0"align="center" class="list" style="margin-top:120px">
        	<tr class="list1">
        	  <th>补贴类型</th>
        	  <th>补贴数额</th>
        	  <th>应纳税额</th>
        	  <th>操作</th>
        	</tr>
            <tbody id="subsidyTable"></tbody>
            
      </table>
      </fieldset>
    </div>
    
    
     <!--分红-->
    
   <div id="tabCot_product_4" class="form-panel  ui-helper-hidden "  align="center" style="width:700px; height:410px">
      <div style="font-size:12px; text-align:left; padding-bottom:5px;  padding-left:35px; font-weight:bold;"> 分红</div>
      <fieldset class="ui-corner-all" style="width:630px; height:355px">
      <table width="630px"><tr><td width="65px"></td><td>
      <table align="right" width="500px">
<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
        	<tr><td id="bonusOutPut" align="left" value="1" height="30px">分红类型：<select><option value="0">当月现金分红</option></select> 
             	 </td>
                <td align="left">分红数额:
        	<input id="bonusNumber" onkeyup="keySelectHistory(this);" type="text" style="width:150px"></td>
        </tr>
        <tr>
        <td>&nbsp;</td>
        <td  height="30px" ><ul><li style="width:80px; height:30px; text-align:center ;line-height:30px; margin-left:60px"><a onclick="canzhaoBonus();" href="#">参照上月</a></li><li style="width:60px; height:30px; text-align:center ;line-height:30px;margin-left:10px"><a id="Bonuscaozuo" onclick="addBonus();" href="#">添加</a></li></ul>
   		  </td>
       </tr>
      
       </table>
       </td><td width="65px" align="right" valign="top"></td></tr></table>
       <br />
       <table width="500px" height="80px" border="0"  cellpadding="0" cellspacing="0"align="center" class="list">
         <tr class="list1">
           <th>分红类型</th>
           <th>分红数额</th>
           <th>应纳税额</th>
           <th>操作</th>
         </tr>
  			<tbody id="bonusTable"></tbody>
       </table>
      </fieldset>
    </div>
    
     <!--五险一金-->
   <div id="tabCot_product_5" class="form-panel ui-helper-hidden "  align="center" style="width:700px; height:410px">
     <div style="font-size:12px; text-align:left; padding-bottom:5px;  padding-left:35px; font-weight:bold;"> 五险一金</div>
      <fieldset class="ui-corner-all"  style="width:630px; height:355px; background-color:#FFF; ">
      <table width="630px"><tr><td width="65px"></td><td>
        <table align="right" width="500px">
        <tr><td height="5px"></td><td></td><td></td></tr>
        	<tr>
            	<td align="left" height="30px" colspan="3">您所在的工作地区：
          	 <select id="orgProvinceSB" onchange="getCity1(this.value);"></select>
        	 <select id="orgCitySB"></select>
                     
                    </td>
                 
            </tr>
            <tr>
            	<td  align="left" height="30px">您社保上缴类型：<select id="insuranceType" onchange=""><option value="0">最低基数</option><option value="1">合同薪金</option><option value="2">当地最高级</option></select>
                </td>
                <td>&nbsp;</td>
                <td align="left" colspan="2">
            	您当月已缴保险：
                <input id="insuranceInNumber" type="text" style="width:70px"></td>
            </tr>
              <tr>
            	<td height="30px" colspan="2" align="left">
               缴费基数：</font>
            	
            	<font>社保</font><font><input id="insuranceCardinal"  style="width:30px;" type="text"></font>
               
				<font>公积金</font><font><input id="housingCardinal" style="width:30px;" type="text"/></font>
				
				 <font>封顶数</font><input id="fengdingshu" style="width:30px;" readonly="readonly" type="text"/> </td>
            </tr>
        </table>
        </td><td width="65px"  align="right" valign="top"></td></tr></table>
       <table  width="500px" align="center" style="border-top-width: 1px;
	border-top-style: dashed;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
	border-top-color: #999999;	">
            	<tr >
                <td height="30px" colspan="2" align="left">个人缴费合计：<input id="gerenheji" readonly="value" type="text" style="width:30px;" align="left"/></td>
                <td width="204" >&nbsp;</td>
                <td colspan="2"  align="left">公司缴费合计：<input id="gongsiheji" type="text" readonly="value" style="width:30px;" align="left"/></td>
                </tr>
                <tr>
                <td width="56" align="right"><!--个人-->养老：</td>
                <td width="69" style="width:50px"> <div style=" align:left;"><input readonly="value" id="pensionP" type="text" style="width:30px;" align="left"/></div></td>
                <td >&nbsp;</td>
  </tr>
                <tr>
                <td id="medicalP" align="right"><!--个人-->医疗：</td>
                <td><input readonly="value" id="medicalP"  type="text" style="width:30px;" align="left"/></td>
                <td>
                <td id="pensionC" width="57" align="right"><!--公司-->养老：</td>
                <td width="90"> <input readonly="readonly" id="pensionC" type="text" style="width:30px;" align="left"/></td>
         </tr>	
              
    <tr>
                 <td align="right"><!--个人-->失业：</td>
                 <td> <input readonly="readonly" id="unemploymentP" type="text" style="width:30px;" align="left"/></td>
                 <td>&nbsp;</td>
                 <td align="right"><!--公司-->医疗：</td>
                 <td> <input readonly="readonly" id="medicalC" type="text" style="width:30px;" align="left"/></td>
                 </tr>
                 <tr>
                 <td>&nbsp;</td>
                 <td>&nbsp;</td>
                 <td>&nbsp;</td>
                 <td align="right"><!--公司-->失业：</td>
                 <td><input readonly="readonly" id="unemploymentC" type="text" style="width:30px;" align="left"/></td>
                 </tr>
                 <tr>
                 <td>&nbsp;</td>
                 <td>&nbsp;</td>
                 <td>&nbsp;</td>
                 <td align="right"><!--公司-->工伤：</td>
                 <td><input readonly="readonly" id="industrialC" type="text" style="width:30px;" align="left"/></td>
                 </tr>
                 <tr>
                 <td>&nbsp;</td>
                 <td>&nbsp;</td>
                 <td>&nbsp;</td>
                 <td align="right"><!--公司-->生育：</td>
                 <td><input readonly="readonly" id="birthC" type="text" style="width:30px;" align="left"/></td>
                 </tr>
                 <tr>

                 <td align="right"><!--个人-->公积金：</td>
                 <td> <input readonly="readonly" id="housingP" type="text" style="width:30px;" align="left"/></td>
                 <td>&nbsp;</td>
                 <td align="right"><!--公司-->公积金：</td>
                 <td><input readonly="readonly" id="housingC" type="text" style="width:30px;" align="left"/></td>

                 </tr>
       </table>
       
        
      </fieldset>
    </div>
    
    <!--商业保险-->
       <div id="tabCot_product_6" class="form-panel  ui-helper-hidden" align="center"  style="width:700px; height:410px">
        <div style="font-size:12px; text-align:left; padding-bottom:5px;  padding-left:35px; font-weight:bold;"> 商业保险</div>
      <fieldset class="ui-corner-all" style="width:630px; height:355px">
      <table width="630px"><tr ><td  width="65px"></td><td>
      <table align="right" width="520px">
      <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
         <tr>
         	<td width="188" height="30px" align="left">
       商业保险公司:
       <input id="cooinsuranceName" type="text"/>
       	   </td>
            <td width="154" align="left">
           投保类型:
        <input id="cooinsuranceType"  type="text"/>
        </td>
        <td width="142" align="left">
         投保时间:
        <input id="insuranceDate" onClick="WdatePicker();" type="text"/>
       	   </td>
        </tr>
        <tr>
        	<td align="left"  colspan="3" height="30px">
            投保金额:
        <input id="insuranceNumber" type="text" style="width:160px" onkeyup="replaceNotNumber(this);">
       
       续保时间间隔：
            <select id="insuranceType"><option value="0">每月</option><option value="1">每季度</option></select>
           
            </td>
        </tr>
       <tr>
   		  <td colspan="3" height="30px"><ul><li style="width:60px; height:30px; text-align:center ;line-height:30px;margin-left:440px"><a id="Cooinsurancecaozuo" onclick="addCooinsurance();" href="#">添加</a></li></ul></td>
       </tr>
      </table>
      </td><td width="65px" align="right" valign="top"> </td></tr></table>
     <br />
       <table width="520px" height="80px" border="0"  cellpadding="0" cellspacing="0"align="center" class="list">
         <tr class="list1">
           <th>商业保险公司</th>
           <th>投保类型</th>
           <th>投保时间</th>
           <th>投保金额</th>
           <th>操作</th>
         </tr>
         <tbody id="cooinsuranceTable"></tbody>
        </table></fieldset>
    </div>
    
    <!--扣除费用-->
     <div id="tabCot_product_7" class="form-panel ui-helper-hidden " align="center"  style="width:700px; height:410px">
      <div style="font-size:12px; text-align:left; padding-bottom:5px;  padding-left:35px; font-weight:bold;"> 扣除费用</div>
      <fieldset class="ui-corner-all" style="width:630px; height:355px">
      <table width="630px"><tr><td width="65px"></td><td>
      <table align="center" cellpadding="0" cellspacing="0" width="500px">
      <tr><td width="227">&nbsp;</td>
      <td width="271">&nbsp;</td>
      </tr>
         <tr>
         	<td height="30px" align="left">
         扣除项:
        <input id="deductionName" type="text"/>
         
        </td>
        <td align="left">
        扣除费用:
        <input id="deductionNumber" onkeyup="replaceNotNumber(this);" type="text"/>
            </td>
        </tr>
        <tr>
        	<td height="30px">&nbsp; </td>
        <td ><ul><li style="width:80px; height:30px; text-align:center ;line-height:30px; margin-left:60px"><a onclick="canzhaoDeduction()" href="#">参照上月</a></li><li style="width:60px; height:30px; text-align:center ;line-height:30px;margin-left:10px"><a id="Deductioncaozuo" onclick="addDeduction();" href="#">添加</a></li></ul></td>
        </tr>
      </table>
      </td><td width="65px" align="right" valign="top"></td></tr></table>
        <br />
       <table width="500px" height="80px" border="0"  cellpadding="0" cellspacing="0"align="center" class="list">
         <tr class="list1">
           <th>扣除类型</th>
           <th>扣除额度</th>
           <th>操作</th>
         </tr>
         <tbody id="deductionTable"></tbody>
        </table>
      </fieldset>
    </div>
    
    <!--退职费-->
     <div id="tabCot_product_8" class="form-panel ui-helper-hidden"  align="center" style="height:410px; width:700px;">
     <div style="font-size:12px; text-align:left; padding-bottom:5px;  padding-left:35px; font-weight:bold;"> 退职费</div>
      <fieldset class="ui-corner-all" style="height:355px; width:630px">
      <table width="630px"><tr><td width="65px"></td><td>
        <table width="500px" align="right">
        <tr><td width="99">&nbsp;</td>
        <td width="389">&nbsp;</td>
        </tr>
        	<tr>
            	<td height="30px" align="left" >退职所在公司：                </td><td align="left">
                	<input id="retiredCompanyName" type="text" style="width:130px" />
                </td>
                </tr>
                <tr>
                <td height="30px" align="left">
                	退职费数额：</td>
                    <td align="left"><input onkeyup="replaceNotNumber(this);" onclick="WdatePicker();" id="retiredNumber" type="text" style="width:130px" />                </td>
                </tr>
                <tr>
                	<td height="30px" align="left">工作年限：</td>
                    <td align="left"><input id="workYears" type="text" style="width:130px" />                 </td>
                </tr>
            <tr><td></td><td height="30px"><ul><li style="width:60px; height:30px; text-align:center ;line-height:30px;margin-left:72px"><a id="Retiredcaozuo" onclick="addRetired();" href="#">添加</a></li></ul></td></tr>
        </table>
        </td><td width="65px" align="right" valign="top"></td></tr></table>
          <br />
      <table width="500px" height="80px" border="0"  cellpadding="0" cellspacing="0"align="center" class="list">
         <tr class="list1">
           <th>退职公司</th>
           <th>退职费</th>
           <th>应纳税额</th>
           <th>操作</th>
         </tr>
         <tbody id="retiredTable"></tbody>
      </table>
      </fieldset>
    </div>
    
    
    <!--退养费-->
      <div id="tabCot_product_9" class="form-panel ui-helper-hidden"  align="center" style="width:700px; height:410px">
     <div style="font-size:12px; text-align:left; padding-bottom:5px;  padding-left:35px; font-weight:bold;"> 退养费</div>
      <fieldset class="ui-corner-all" style="width:630px;height:355px">
      <table width="630px"><tr><td width="65px"></td><td>
         <table width="500px" align="right" cellpadding="0" cellspacing="0">
        <tr> <td width="127">&nbsp;</td>
        <td width="139">&nbsp;</td> 
        <td width="102">&nbsp;</td>
        <td width="130">&nbsp;</td>
        </tr>
        	<tr>
            	<td height="30px" align="left">退养公司：                </td>
                <td align="left"><input id="" type="text" style="width:110px; float:left" /></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                </tr>
                <tr>
                <td height="30px" align="left">法定退休时间：</td>
                <td align="left"><input type="text" style="width:110px;float:left" /></td>
                <td align="right">内退时间：</td>
                <td align="left"><input type="text" style="width:130px;float:left" /></td>
                </tr>
               <tr>
                <td height="30px"align="left">内退当月工资薪金：</td>
                <td align="left"><input type="text" style="width:110px;float:left" /> </td>
                <td>&nbsp;</td>  
                <td>&nbsp;</td>
                    </tr>
                  <tr>
                  <td align="left" height="30px">您的薪金制度：</td>
                  <td><input name="input" type="text" style="width:110px; float:left" /> </td>
                  <td><input type="radio"  name="radio1"  id="1"style="width:20px" >一次性取得</td>
                  <td><input  name="radio1" type="radio"  id="2"style="width:20px" >
                  单月取得</td>
        	</tr>
             <tr><td>&nbsp;</td><td>&nbsp;</td><td colspan="2"><ul><li style="width:80px; height:30px; text-align:center ;line-height:30px; margin-left:70px"><a href="#">参照上月</a></li><li style="width:60px; height:30px; text-align:center ;line-height:30px;margin-left:10px"><a href="#">添加</a></li>
            </ul></td></tr>
        </table>
        </td><td width="65px" align="right" valign="top"></td></tr></table>
      <br />
       <table width="500px" height="80px" border="0"  cellpadding="0" cellspacing="0"align="center" class="list">
         <tr class="list1">
           <th>退养补偿金</th>
           <th>应纳税额</th>
           <th>退养补偿金总额</th>
           <th>操作</th>
         </tr>
         <tbody id=""></tbody>
        </table>
      </fieldset>
    </div>
    
    <!--其他-->
     <div id="tabCot_product_10" class="form-panel ui-helper-hidden" align="center"  style="width:700px; height:410px;display: none;">
      <div style="font-size:12px; text-align:left; padding-bottom:5px;  padding-left:35px; font-weight:bold;"> 其他</div>
      <fieldset class="ui-corner-all" style="width:630px; height:355px">
          <table width="500px" align="center">
        	<tr><td width="80">&nbsp;</td><td width="408">&nbsp;</td></tr>
                <tr>
                <td align="left">其他收入额：
                <td align="left" height="30px"><input type="text" style="width:130px" /> </td>
                </tr>
                <tr><td height="30px">&nbsp;</td><td ><ul><li style="width:60px; height:30px; text-align:center ;line-height:30px;margin-left:68px"><a href="#">添加</a></li></ul></td>
                </tr>
        </table>
      <br />
       <table width="500px" height="80px" border="0"  cellpadding="0" cellspacing="0"align="center" class="list">
         <tr class="list1">
           <td>其他收入额</td>
           <td>备注</td>
          
           <td>操作</td>
         </tr>
         <tr>
           <td>&nbsp;</td>
           <td>&nbsp;</td>
      
           
           <td>&nbsp;</td>
         </tr>
         <tr>
           <td>&nbsp;</td>
           <td>&nbsp;</td>
           
          
           <td>&nbsp;</td>
         </tr>
        </table>
      </fieldset>
    </div>
 
   <div align="center" style="width:630px; margin:0 auto; ">
   <ul>
   <li style="float:right; width:60px; height:30px;line-height: 30px; "><a href="#" onclick="saveAll(0)">取消</a></li>
   <li style="float:right;width:60px; height:30px;line-height: 30px; "><a href="#" onclick="askPerson();"> 完成</a></li>
   </ul>
    
 
  </div> 
</form>

</div>

<script type="text/javascript" language="jscript">
function tab(o, s, cb, ev){//tab切换类
var $ = function(o){return document.getElementById(o)};
var css = o.split((s||'_'));
if(css.length!=4)return;
this.event = ev || 'onclick';
o = $(o);
if(o){
   this.ITEM = [];
   o.id = css[0];
   var item = o.getElementsByTagName(css[1]);
   var j=1;
   for(var i=0;i<item.length;i++){
    if(item[i].className.indexOf(css[2])>=0 || item[i].className.indexOf(css[3])>=0){
     if(item[i].className == css[2])o['cur'] = item[i];
     item[i].callBack = cb||function(){};
     item[i]['css'] = css;
     item[i]['link'] = o;
     this.ITEM[j] = item[i];
     item[i]['Index'] = j++;
     item[i][this.event] = this.ACTIVE;
    }
   }
   return o;
}
}
tab.prototype = {
ACTIVE:function(){
   var $ = function(o){return document.getElementById(o)};
   this['link']['cur'].className = this['css'][3];
   this.className = this['css'][2];
   try{
	   saveTemp($(this['link']['id']+'_'+this['link']['cur']['Index']).id);
    $(this['link']['id']+'_'+this['link']['cur']['Index']).style.display = 'none';
    $(this['link']['id']+'_'+this['Index']).style.display = 'block';
   }catch(e){}
   this.callBack.call(this);
   this['link']['cur'] = this;
   openTemp($(this['link']['id']+'_'+this['link']['cur']['Index']).id);
}
}
new tab('tabCot_product-li-currentBtn-', '-');
</script>

</body>
</html>