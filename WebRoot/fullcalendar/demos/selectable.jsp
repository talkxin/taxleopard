<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ page import ="com.opensymphony.xwork2.ActionContext"%>
<%@ page import ="com.org.entity.TaxPayer"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='/TaxPersonalReporting1.0/fullcalendar/fullcalendar/fullcalendar.css' />
<link rel='stylesheet' type='text/css' href='/TaxPersonalReporting1.0/fullcalendar/fullcalendar/fullcalendar.print.css' media='print' />
<style type='text/css'> 
<!--
body
a:visited
a:hover
a:link
-->
</style>

 <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/interface/memoServiceDwr.js'></script>
 <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/engine.js'></script>
 <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/util.js'></script>

    
<script type='text/javascript' src='/TaxPersonalReporting1.0/fullcalendar/jquery/jquery-1.5.2.min.js'></script>
<script type='text/javascript' src='/TaxPersonalReporting1.0/fullcalendar/jquery/jquery-ui-1.8.11.custom.min.js'></script>
<script type='text/javascript' src='/TaxPersonalReporting1.0/fullcalendar/fullcalendar/fullcalendar.min.js'></script>
<script type='text/javascript'>
<!--
//可以打包为js文件;
var x0=0,y0=0,x1=0,y1=0;
var offx=6,offy=6;
var moveable=false;
var hover='orange',normal='#336699';//color;
var index=10000;//z-index;
//开始拖动;
function startDrag(obj)
{
if(event.button==1)
{
//锁定标题栏;
obj.setCapture();
//定义对象;
var win = obj.parentNode;//父级节点
var sha = win.nextSibling;//内容节点
//记录鼠标和层位置;
x0 = event.clientX;
y0 = event.clientY;
x1 = parseInt(win.style.left);
y1 = parseInt(win.style.top);
//记录颜色;
normal = obj.style.backgroundColor;
//改变风格;
obj.style.backgroundColor = hover;
win.style.borderColor = hover;
obj.nextSibling.style.color = hover;
sha.style.left = x1+offx;
sha.style.top = y1+offy;
moveable = true;
}
}
//拖动;
function drag(obj)
{
if(moveable)
{
var win = obj.parentNode;
var sha = win.nextSibling;
alert(x1);
win.style.left = x1+ event.clientX - x0;
win.style.top = y1 + event.clientY - y0;
sha.style.left = parseInt(win.style.left) + offx;
sha.style.top = parseInt(win.style.top) + offy;
}
}
//停止拖动;
function stopDrag(obj)
{
if(moveable)
{
var win = obj.parentNode;
var sha = win.nextSibling;
var msg = obj.nextSibling;
win.style.borderColor = normal;
obj.style.backgroundColor = normal;
msg.style.color = normal;
sha.style.left = obj.parentNode.style.left;
sha.style.top = obj.parentNode.style.top;
obj.releaseCapture();
moveable = false;
}
}
//获得焦点;
function getFocus(obj)
{
if(obj.style.zIndex!=index)
{
index = index + 2;
var idx = index;
obj.style.zIndex=idx;
obj.nextSibling.style.zIndex=idx-1;
}
}
//最小化;
function min(obj)
{
var win = obj.parentNode.parentNode;
var sha = win.nextSibling;
var tit = obj.parentNode;
var msg = tit.nextSibling;
var flg = msg.style.display=="none";
if(flg)
{
win.style.height = parseInt(msg.style.height) + parseInt(tit.style.height) + 2*2;
sha.style.height = win.style.height;
msg.style.display = "block";
obj.innerHTML = "0";
}
else
{
win.style.height = parseInt(tit.style.height) + 2*2;
sha.style.height = win.style.height;
obj.innerHTML = "2";
msg.style.display = "none";
}
}
//创建一个对象;
function xWin(id,w,h,l,t,tit,msg)
{
index = index+2;
this.id = id;
this.width = w;
this.height = h;
this.left = l;
this.top = t;
this.zIndex = index;
this.title = tit;
this.message = msg;
this.obj = null;
this.bulid = bulid;
this.bulid();
}
//初始化;
function bulid()
{
var str = ""
+ "<div id='xMsg" + this.id + "' "
+ "style='"
+ "z-index:" + this.zIndex + ";"
+ "width:" + this.width + ";"
+ "height:" + this.height + ";"
+ "left:" + this.left + ";"
+ "top:" + this.top + ";"
+ "background-color:" + normal + ";"
+ "color:" + normal + ";"
+ "font-size:8pt;"
+ "font-family:Tahoma;"
+ "position:absolute;"
+ "cursor:default;"
+ "border:2px solid " + normal + ";"
+ "' "
+ "onmousedown='getFocus(this)'>"
+ "<div "
+ "style='"
+ "background-color:" + normal + ";"
+ "width:" + (this.width-2*2) + ";"
+ "height:20;"
+ "color:white;"
+ "' "
+ "onmousedown='startDrag(this)' "
+ "onmouseup='stopDrag(this)' "
+ "onmousemove='drag(this)' "
+ "ondblclick='min(this.childNodes[1])'"
+ ">"
+ "<span style='width:" + (this.width-2*12-4) + ";padding-left:3px;'>" + this.title + "</span>"
+ "<span style='width:12;border-width:0px;color:white;font-family:webdings;' onclick='min(this)'>0</span>"
+ "<span style='width:12;border-width:0px;color:white;font-family:webdings;' onclick='ShowHide(\""+this.id+"\",null)'>r</span>"
+ "</div>"
+ "<div style='"
+ "width:100%;"
+ "height:" + (this.height-20-4) + ";"
+ "background-color:white;"
+ "line-height:14px;"
+ "word-break:break-all;"
+ "padding:3px;"
+ "'>" + this.message + "</div>"
+ "</div>"
+ "<div id=xMsg" + this.id + "bg style='"
+ "width:" + this.width + ";"
+ "height:" + this.height + ";"
+ "top:" + this.top + ";"
+ "left:" + this.left + ";"
+ "z-index:" + (this.zIndex-1) + ";"
+ "position:absolute;"
+ "background-color:black;"
+ "filter:alpha(opacity=40);"
+ "'></div>";
document.body.insertAdjacentHTML("beforeEnd",str);
}
//显示隐藏窗口
function ShowHide(id,dis){
var bdisplay = (dis==null)?((document.getElementById("xMsg"+id).style.display=="")?"none":""):dis
document.getElementById("xMsg"+id).style.display = bdisplay;
document.getElementById("xMsg"+id+"bg").style.display = bdisplay;
}
//-->
</script>
 
<script type='text/javascript'>
<!--
function initialize()
{
var str ="标         题:<input id=\"title\" type=\"text\" name=\"memo.title\"/></p>"+
         "开始时间:<input id=\"beginTime\" type=\"text\" name=\"memo.beginTime\" onClick=\"\"/></p>"+
         "结束时间:<input id=\"endTime\" type=\"text\" name=\"memo.endTime\" onClick=\"\"/></p>"+
         "内          容:<textarea id=\"neiRong\" name=\"memo.neiRong\" rows=\"10\" cols=\"18\"></textarea>"+"<br/>"+
                 "<input type=\"button\" value=\"提交\" onClick=\"addMemo()\"/><input type=\"button\" value=\"取消\"/>";
var a = new xWin("1",800,500,200,200,"添加备忘",str);
ShowHide("1","none");//隐藏窗口1
}
window.onload = initialize;
//-->
</script>

<script type='text/javascript'>


   $(document).ready(function() {
	
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		var calendar = $('#calendar').fullCalendar({
			header: {
				left: 'prevYear prev today next nextYear', 
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			buttonText:{ 
				month:'月视图', 
				agendaWeek:'议事周视图', 
				agendaDay:'议事日视图', 
				today:'今天',
				prevYear:'上一年',
				prev:'上一月',
				next:'下一月',
				nextYear:'下一年' 
			},
			titleFormat:{ 
				month:'yyyy年MMMM', 
				week:"yyyy年MMMd日{'&#8212;'[yyyy年][MMM]d日}", 
				day:'yyyy-MM-d dddd' 
			}, 
			timeFormat:{ 
				week:'HH:mm{-HH:mm}', 
				day:'HH:mm' 
			},
			columnFormat:{//header底下的第一行; 
				month:'dddd', 
				week:'ddd MM/dd', 
				day:'dddd MM/dd' 
			}, 
			allDayText:'全天',
			axisFormat:'HH:mm',
			monthNamesShort:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
			dayNamesShort:['周日','周一','周二','周三','周四','周五','周六'], 
			selectable: true,
			selectHelper: true,
			select: function(start, end, allDay) {//点击事件
				ShowHide('1',null);
				var title = prompt('Event Title:');
				alert(title);
				if (title) {
					calendar.fullCalendar('renderEvent',
						{
							title: title,
							start: start,
							end: end,
							allDay: allDay
						},
						true // make the event "stick"
					);
				}
				calendar.fullCalendar('unselect');
			},
			editable: true,
			events: [
				{
					title: 'All Day Event',
					start: new Date(y, m, 1)
				},
				{
					title: 'Long Event',
					start: new Date(y, m, d-5),
					end: new Date(y, m, d-2)
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: new Date(y, m, d-3, 16, 0),
					allDay: false
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: new Date(y, m, d+4, 16, 0),
					allDay: false
				},
				{
					title: 'Meeting',
					start: new Date(y, m, d, 10, 30),
					allDay: false
				},
				{
					title: 'Lunch',
					start: new Date(y, m, d, 12, 0),
					end: new Date(y, m, d, 14, 0),
					allDay: false
				},
				{
					title: 'Birthday Party',
					start: new Date(y, m, d+1, 19, 0),
					end: new Date(y, m, d+1, 22, 30),
					allDay: false
				},
				{
					title: 'Click for Google',
					start: new Date(y, m, 28),
					end: new Date(y, m, 29),
				}
			],
			eventClick: function(event) {
				var str2 ="<H2>母亲节</H2><p>今天是母亲节</p>";
				ShowHide('2',new xWin("2",160,200,200,200,"当前日志",str2));
			}
		});
		
	});

	

</script>
<style type='text/css'>

	body {
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		}

	#calendar {
		width:500px;
		height:500px;
		margin: 0 auto;
		}

</style>
</head>
<body background-color="#F00">
   
<div id='calendar' style="z-index:0;"></div>
</body>
</html>
