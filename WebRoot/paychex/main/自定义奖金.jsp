<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>自定义奖金</title>
<style>
body{
font-size:12px;
}
*{margin:0;padding:0;}

a:link,a:visited{
	color:#000000;
	text-decoration:underline;
}
a:hover{color:#000000;text-decoration:none;}
ul,li{list-style-type:none;}
#s-left,#s-right{float:left;width:30px;height:25px;overflow:hidden;}
#s-left a:link,#s-left a:visited,#s-left a:hover,#s-right a:link,#s-right a:visited,#s-right a:hover{border:1px solid #B0BEC7;font-size:12px;line-height:23px;width:28px;height:23px;overflow:hidden;float:left;text-decoration:none;text-align:center;background-color:#EAEFF5;font-weight:bold;}
#s-left a:hover,#s-right a:hover{
	background-color:#FFF;
	color:#000000;
}
#s-left a.dis:link,#s-left a.dis:visited,#s-left a.dis:hover,#s-right a.dis:link,#s-right a.dis:visited,#s-right a.dis:hover{background-color:#EEE;color:#999;border:1px solid #999;cursor:default;}
#s-tabs-bd{position:relative;z-index:2;float:left;width:240px;margin:0 1px;display:inline;height:24px;overflow:hidden;border-bottom:1px solid #B0BEC7;}
#s-tabs-bd ul{position:absolute;z-index:1;left:0;top:0;width:1064px;height:24px;overflow:hidden; font:12px;}
#s-tabs-bd li{float:left;width:40px;height:24px;overflow:hidden;}
#s-tabs-bd li a:link{float:left;margin:0 1px;display:inline;width:40px;height:23px;line-height:23px;text-align:center;background-color:#EAEFF5;text-decoration:none;border:solid #B0BEC7;border-width:1px 1px 0;}
#s-tabs-bd li a:hover,#s-tabs-bd li.current a:link,#s-tabs-bd li.current a:hover{background-color:#EAEFF5;}
#s-tabs-bd li.current a:visited{
	float:left;
	margin:0 1px;
	display:inline;
	width:40px;
	height:23px;
	line-height:23px;
	text-align:center;
	background-color:#CCCCCC;
	text-decoration:none;
	border:solid #B0BEC7;
	border-width:1px 1px 0;
}



</style>
</head>

<body>
<form>
<div>您所填写的奖金名称：
     <input name="jiangjin" type="text" />
</div>
 <div style="margin-bottom:20px; margin-top:20px;">     
          <input type="radio" name="jiangjin" value="单月奖（每月都会发生）" id="jiangjin_0" />
单月奖（每月都会发生）
          <br />
      
          <input type="radio" name="jiangjin" value="非单月奖（非每月产生的）" id="jiangjin_1" />
非单月奖（非每月产生的）
  </div>
  <div id="s-left"><a href="#left"><<</a></div>
	 <div id="s-tabs-bd">	
     <ul id="scroller" >
         <li class="current" ><a href="#" rel="1">一月</a></li>
         <li class="current"><a href="#" rel="2">二月</a></li>
         <li class="current"><a href="#" rel="3">三月</a></li>
         <li class="current"><a href="#" rel="4">四月</a></li>
         <li class="current"><a href="#" rel="5">五月</a></li>
         <li class="current"><a href="#" rel="6">六月</a></li>
         <li class="current"><a href="#" rel="7">七月</a></li>
         <li class="current"><a href="#" rel="8">八月</a></li>
         <li class="current"><a href="#" rel="9">九月</a></li>
         <li class="current"><a href="#" rel="10">十月</a></li>
         <li class="current"><a href="#" rel="11">十一月</a></li>
         <li class="current"><a href="#" rel="12">十二月</a></li>
     </ul>
	 </div> 
     <div id="s-right"><a href="#right">>></a></div>	
<br />

<div style="margin-top:30px"><input type="button" value="确定" onclick="window.location.reload('index.html')" />
  <input name="input" type="button" value="取消" onclick="window.location.reload('index.html')" />
</div>
</form>

<script language="javascript" type="text/javascript" src="js/yao.js"></script>
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
</body>
</html>
