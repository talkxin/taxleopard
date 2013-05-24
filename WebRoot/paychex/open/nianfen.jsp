<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <head>
	    <title>DENON STUDIO - Timeline</title>
        <link href="paychex/open/css/layout.css" rel="stylesheet" type="text/css" media="all" />
	    <link href="paychex/open/css/timeline.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="paychex/open/css/easyui.css" />
        <link rel="stylesheet" type="text/css" href="paychex/open/css/icon.css"/>
        <script type="text/javascript" src="js/jquery-1.5.2.min.js"></script>
        <script type="text/javascript" src="paychex/open/js/timeline-min.js"></script>
        <script type="text/javascript" src="paychex/open/js/jquery.easyui.min.js"></script>

        <script type='text/javascript' src='dwr/interface/dwrTest.js'></script>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/util.js'></script>
        <script type='text/javascript' src='paychex/reportForm/js/swfobject.js'></script>
        <script type="text/javascript" src="paychex/open/js/nianfen.js"></script>
        
        <script type='text/javascript' src='dwr/interface/paychexD.js'></script>
       

	    <style type="text/css">
		 .tabContainer{ margin:0 auto; position:relative; margin:0 auto;  background-color:#e0e3e2; border:3px solid #abadac; }
	a,a:link,a:visited,a:active{ color:#000000;text-decoration:none;}      
  
    .tabContainer li{float:left; background:#F0F0F0; }
.tabContainer li a{display:block!important;display:inline-block;height:30px;line-height:30px;}
#body .tabContainer li a{color:#ffffff;font-size:12px;font-weight:bolder;}
.tabContainer li.currentBtn{background:#e0e3e2;}
#body .tabContainer li.currentBtn a{height:24px; background:#ffffff;}
#body .tabContainer li a:hover{text-decoration:none;color:#ffffff;}
#body .tabContainer li.currentBtn a:hover{color:#ffffff;}
.tabCot ul{line-height:20px;}
.ui-helper-hidden { display: none; }
.ui-helper-clearfix:after { content: "."; display: block; height: 0; clear: both; visibility: hidden; }
.ui-helper-clearfix { display: inline-block; }
/* required comment for clearfix to work in Opera \*/
* html .ui-helper-clearfix { height:1%; }
.ui-helper-clearfix { display:block; }
	       
	       #wrap {
		   margin:40px 0;
		   padding:0;;
        
	           width : 900px;
	       }
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
  
    <div id="nianfen" class="tabContainer" style="clear:both; margin:0 auto;  height:550px; width:810px">
    <div>
    <ul  id="tabCot_product-li-currentBtn-">
   <li class="currentBtn" style="border:1px solid  #CCCCCC;"><a href="javascript:void(0)" title="基础工资" rel="1" style="font-family:'微软雅黑'; font-size:14px; margin-left:10px; margin-right:10px;">数据录入模式</a></li>
   <li style="border:1px solid  #CCCCCC;"><a href="javascript:void(0)" title="奖金" rel="2" style="font-family:'微软雅黑'; font-size:14px ;margin-left:10px; margin-right:10px;">出入境管理</a></li>
   </ul>
   </div>
     <!--数据录入模式-->

    <div  style="margin:auto; margin-top:60px;width:750px; height:440px;background:#FFFFFF;" id="tabCot_product_1"  >
    
      <div id="wrap" style="margin-left:20px">
        <div style="font-family:'微软雅黑'; font-size:14px;">请选择年份：
        <select id="nian" onchange=yearPie() name="nianFen">
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
        </select></div>
        <br />
        <div style="font-family:'微软雅黑'; font-size:14px;">请选择月份：</div>
        <br />
        <div id="s-left" ></div>
	 <div id="s-tabs-bd">	
     <ul id="scroller" >
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="01" onmouseover="this.style.cursor='hand'" onclick="display('1','50');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">1月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="02" onmouseover="this.style.cursor='hand'" onclick="display('1','100');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">2月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="03" onmouseover="this.style.cursor='hand'" onclick="display('1','140');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');" >3月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="04" onmouseover="this.style.cursor='hand'" onclick="display('1','180');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">4月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="05" onmouseover="this.style.cursor='hand'" onclick="display('1','220');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">5月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="06" onmouseover="this.style.cursor='hand'" onclick="display('1','270');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">6月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="07" onmouseover="this.style.cursor='hand'" onclick="display('1','310');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">7月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="08" onmouseover="this.style.cursor='hand'" onclick="display('1','350');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">8月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="09" onmouseover="this.style.cursor='hand'" onclick="display('1','390');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">9月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="10" onmouseover="this.style.cursor='hand'" onclick="display('1','430');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">10月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="11" onmouseover="this.style.cursor='hand'" onclick="display('1','470');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">11月</a></li>
         <li class="currentBtn" style="border:1px solid  #CCCCCC; text-align:center; line-height:24px;" ><a rel="12" onmouseover="this.style.cursor='hand'" onclick="display('1','520');isReturnTime(this,'shuiJingYue','wenZiYue','201','162');">12月</a></li>
     </ul>
	 </div> 
     <div id="s-right"></div>
        </div>
        
    <div id="twelvePic">

     </div>                                                                  
                
     <ul class="shortcut-buttons-set">

        	<li style="margin-left:12px;">

                <div style="width:50px;height:250px; position:absolute; z-index:1; ">

                    <div id="wenZiYue" class="easyui-panel" title="当月文字性报表"  style="width:230px;height:200px;padding:10px;background:#fafafa;">

                        
                    </div>
                        
                </div>

        </li>

        <li>

                <div style="z-index:1; width:50px;height:250px; margin-left:250px; position:absolute;">

                            <div id="shuiJingYue" class="easyui-panel" title="当月水晶报表" style="z-index:5;width:230px;height:200px;padding:10px;background:#fafafa;">
                           </div>
                </div>
        </li>

        

      <li>

        		<div style="width:50px; height:300px;  margin-left:490px; position:absolute; z-index:5;">

                			<div id="shuiJingNian" class="easyui-panel" title="年终水晶报表" style="width:230px; height:200px; padding:10px; background:#fafafa;">
                </div>
            </div>
        

        </li>

       </ul>
           


       </div>
       
       
       
       <!--出入镜管理-->
       <div style="margin:auto; margin-top:60px;width:750px; height:440px;background:#FFFFFF;"  id="tabCot_product_2" class="ui-helper-hidden">
<form >
<br />
<table width="500px" align="center">
<tr>
<td width="74" height="30px"><span style="font-family:'微软雅黑'; font-size:14px">入境时间:</span></td>
<td width="414"><input name="" type="text" /></td>
</tr>
<tr>
<td height="30px"><span style="font-family:'微软雅黑'; font-size:14px">出境时间:</span></td>
<td><input name="" type="text" /></td>
</tr>
<tr>
<td height="30px" align="right"></td>
<td><div style="margin-left:50px;"><input type="button" value="添加" />
    &nbsp;
    <input type="button" value="取消"  onclick="window.location='xiangdao2.html'"/></div></td>
</tr>
</table>
<br />
  <table width="500px" height="80px" border="0"  cellpadding="0" cellspacing="0" class="list" align="center" >
         <tr class="list1">
           <td>入境时间</td>
           <td>出境时间</td>
           <td>在华总天数</td>
           <td>操作</td>
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

       
<script language="javascript" type="text/javascript" src="paychex/open/js/yao.js"></script>
<script language="javascript" type="text/javascript">
<!--
var oCarousel = new YAO.Carousel({
	btnPrevious: YAO.getEl('s-left'),
	Container: YAO.getEl('s-tabs-bd'),
	Scroller: YAO.getEl('scroller'),
	items: 'li',
	btnNext: YAO.getEl('s-right')
});


//-->
</script>
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
    $(this['link']['id']+'_'+this['link']['cur']['Index']).style.display = 'none';
    $(this['link']['id']+'_'+this['Index']).style.display = 'block';
   }catch(e){}
   this.callBack.call(this);
   this['link']['cur'] = this;
}
}
/*
tab 使用方法:
   new tab(标签ID, id分隔符, 单击事触发函数, 什么事件触发TAB切换);
    标签ID:        ID命名格式为: 前缀+分隔符+TAB标签的HTML标签名+激活状态下标签样式+分隔符+非激活状态下标签样式(必须)
    id分隔符:       分隔符(必须)
    TAB切换时触发函数: TAB切换时触发函数(可选)
    什么事件触发TAB切换:可选(默认为onclick)
    注: 标签ID命名时的前缀将做为 该标签的新ID值,所以前缀不要与现在任何元素的ID值相同.
   返回值为: 标签ID所对象的对象.
   切换标签时对应的 项目名称命名规则:
    前缀+_+顺序值
    具体理解,可以看上面的代码,比如
    ID为 "test3_li_now_" 的对象代表的意思是:
     前缀为 test3
     li 为 id为 "test3_li_now_" 标签下面的 li 标签 做为TAB项.
     now 为 标签激活时的样式
     "" 最后的空为 非激活状态下的样式
    每个标签项 激活 状态下对应的元素的ID应该命名为:
     test3_1   第一个标签项对应项目
     test3_2   第二个标签项对应项目
     test3_3   第三个标签项对应项目
     等等
*/
new tab('tabCot_product-li-currentBtn-', '-');
</script>
<div style="width: 810px;height: 630;display: none;" id="ceshi1"></div>
    </body>
</html>
