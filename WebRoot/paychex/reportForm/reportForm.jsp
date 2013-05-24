<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <head>
	    <title>DENON STUDIO - Timeline</title>
        <link href="paychex/reportForm/css/layout.css" rel="stylesheet" type="text/css" media="all" />
	    <link href="paychex/reportForm/css/timeline.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="paychex/reportForm/css/easyui.css" />
        <link rel="stylesheet" type="text/css" href="paychex/reportForm/css/icon.css"/>
        <script type="text/javascript" src="paychex/reportForm/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="paychex/reportForm/js/timeline-min.js"></script>
        <script type="text/javascript" src="paychex/reportForm/js/jquery.easyui.min.js"></script>
   <script language="javascript">
      function bian1(){
         document.getElementById("1").style.display="block";
      }
      function toMonthStatement(){
         //document.getElementById("monthWritten").style.display="block";
         $("#reportForm").slideUp("slow");
         $("#monthWritten").slideDown("slow");
      }
      function toMonthPieChart(){
          $("#reportForm").slideUp("slow");
          $("#monthPieChart").slideDown("slow");
       }
   </script>
	    
   <style type="text/css">
	      
        .tabContainer{ margin:0 auto; position:relative; margin:0 auto;  background-color:#e0e3e2; border:3px solid #abadac; }
        #wrap {
		   margin:40px 0;
		   padding:0;;
        
	           width : 900px;
	       }
	</style>
	    
    </head>
    <body>
       <div id="reportForm" class="tabContainer" style="clear:both; margin:0 auto;  height:550px; width:810px">
           <div style="margin-left:30px; margin-top:20px; font-size:16px; font-family:'微软雅黑'">数据录入模式
               <input type="submit" name="button"  value="出入镜管理" style="font-size:16px; font-family:'微软雅黑'"/>
           </div>
            
           <div style="margin:auto; width:750px; height:440px;background:#FFFFFF;">
               <div id="wrap" style="margin-left:20px">
                   <div style="font-family:'微软雅黑'; font-size:14px;">请选择年份：
                      <select name="">
                         <option>2005</option>
                         <option>2006</option>
                         <option>2007</option>
                         <option>2008</option>
                         <option>2009</option>
                         <option>2010</option>
                         <option>2011</option>
                         <option>2012</option>
                         <option>2013</option>
                         <option>2014</option>
                         <option>2015</option>
                     </select>
                  </div>
                  <br/>
                  <div style="font-family:'微软雅黑'; font-size:14px;">请选择月份：
                  </div>
                  <br />
                  <div id="s-left" ><a href="#left"><<</a>
                  </div>
	              <div id="s-tabs-bd">	
                      <ul id="scroller" >
                         <li class="current" ><a href="#" rel="1" onclick="bian1()">一月</a></li>
                         <li class="current"><a href="#" rel="2" onclick="bian1()">二月</a></li>
                         <li class="current"><a href="#" rel="3" onclick="bian1()" >三月</a></li>
                         <li class="current"><a href="#" rel="4" onclick="bian1()">四月</a></li>
                         <li class="current"><a href="#" rel="5" onclick="bian1()">五月</a></li>
                         <li class="current"><a href="#" rel="6" onclick="bian1()">六月</a></li>
                         <li class="current"><a href="#" rel="7" onclick="bian1()">七月</a></li>
                         <li class="current"><a href="#" rel="8" onclick="bian1()">八月</a></li>
                         <li class="current"><a href="#" rel="9" onclick="bian1()">九月</a></li>
                         <li class="current"><a href="#" rel="10" onclick="bian1()">十月</a></li>
                         <li class="current"><a href="#" rel="11" onclick="bian1()">十一月</a></li>
                         <li class="current"><a href="#" rel="12" onclick="bian1()">十二月</a></li>
                      </ul>
	              </div> 
                  <div id="s-right"><a href="#right">>></a>
                  </div>
              </div>
              
              <div style="width:500px; height:20px; display:none; margin-bottom:60px; margin-left:90px;" id="1" ><a href="96/index.html" ><img src="paychex/reportForm/images/Window Add.png" align="absmiddle" style="border:0" /><font style="font-family:'微软雅黑'; font-size:14px;"></font></a>&nbsp;<a href="#"><img src="paychex/reportForm/images/Window Edit.png" align="absmiddle" style="border:0" /><font style="font-family:'微软雅黑'; font-size:14px;"></font></a>&nbsp;<a href="canzhao.html"><img src="paychex/reportForm/images/Window Canzhao.png" align="absmiddle" style="border:0" /><font style="font-family:'微软雅黑'; font-size:14px;"></font></a>&nbsp;<a href="#" ><img src="paychex/reportForm/images/Window Delete.png" align="absmiddle" style="border:0" /><font style="font-family:'微软雅黑'; font-size:14px;"></font></a>
              </div>
                   <ul class="shortcut-buttons-set" style="margin-left:20px">
        	           <li>
                           <div style="width:50px;height:250px;">
                               <div id="p" class="easyui-panel" title="当月文字性报表" icon="icon-save" collapsible="true" minimizable="true" maximizable=true closable="true" style="width:230px;height:200px;padding:10px;background:#fafafa">
                                  <input type=button value=当月文字性报表 onclick="javascript:toMonthStatement();">
                               </div>
                           </div>
                           
                       </li>
                       <li>
                           <div style="width:50px;height:250px; padding-left:190px;">
                               <div id="p" class="easyui-panel" title="当月水晶报表" icon="icon-save" collapsible="true" minimizable="true" maximizable=true closable="true" style="width:230px;height:200px;padding:10px;background:#fafafa;">
                                <jsp:include page="/paychex/reportForm/monthPieChart.jsp"/>
                              </div>
                          </div>
                      </li>
        
                      <li>
        		           <div style="width:50px; height:300px;  padding-left:190px;">
                			  <div id="p" class="easyui-panel" title="年终水晶报表" icon="icon-save" collapsible="true" minimizable="true" maximizable=true closable="true" style="width:230px; height:200px; padding:10px; background:#fafafa;">
                            	<p>panel</p>
                                <p>panel</p>
                                <p>panel</p>
                            	<p>panel</p>
                            	<p>panel</p>
                            	<p>panel</p>
                            	<p>panel</p>
                                <p>panel</p>
                                <p>panel</p>
                                <p>panel</p>
                                <p>panel</p>
                              </div>
                           </div>
                      </li>
                    </ul>
            </div>

   </div>
   <div id="monthWritten" style="display:none;z-index:1000;">
               <jsp:include page="/paychex/reportForm/monthWrittenStatement.jsp"/>
   </div>
<script language="javascript" type="text/javascript" src="paychex/reportForm/js/yao.js"></script>
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
