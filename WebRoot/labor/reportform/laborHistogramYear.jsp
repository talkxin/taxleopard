<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/interface/laborReportD.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/engine.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/util.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/paychex/reportForm/js/swfobject.js'></script>

    <script type="text/javascript">
    window.onload = function(){
    	findLaborYearHg();
    }
    function onrollout(){
        tmp = findSWF("ofc");
        x = tmp.rollout();
      }

      function onrollout2(){
        tmp = findSWF("ofc");
        x = tmp.rollout();
      }

     function findSWF(movieName) {
        if (navigator.appName.indexOf("Microsoft")!= -1) {
            return window[movieName];
        } else {
            return document[movieName];
        }
     }
    function drawHg(hight,width,title,valueData,linksData,xLabels,max,id){
     	      var so = new SWFObject("/TaxPersonalReporting1.0/paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", hight, width, "9", "#FFFFFF");
              so.addVariable("variables","true");
              so.addVariable("title",title+",{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",valueData);
              so.addVariable("links",linksData);
              so.addVariable("x_labels",xLabels);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",max);
              so.addParam("allowScriptAccess", "always" );
              so.addParam("onmouseout", "onrollout2();" );
              so.write(id);
          
   }
    function findLaborYearHg(){
    	laborReportD.findLaborYear('2011',function(data){
            	eval("window.dataHgYear = data;");
            	drawLaborYearHg();
        });
    }

    function findLaborItemHg(lid){
    	laborReportD.findLaborItem(22,'2011',lid,function(data){
            	eval("window.dataHgItem = data;");
            	drawLaborItemHg();
        });
    }
    function findLaborMonthHg(ltid){
    	laborReportD.findLaborMonth(22,'2011',ltid,function(data){
    		eval("window.dataHgMonth = data;");
        	drawLaborMonthHg();

        });
    }
    function drawLaborYearHg(){//年劳务报酬
         var hight,width,title,id;
         var valueData="";
         var linksData="";
         var xLabels="";
         var max=parseFloat(window.dataHgYear[0].payOutNumSum);
         if(window.dataHgYear==null || window.dataHgYear=="")
              alert("该年无劳务报酬");
         else{
             hight="1000"; width="500";
             for(var i=0;i<window.dataHgYear.length;i++){
                 if(window.dataHgYear[i].payOutNumSum==null || window.dataHgYear[i].payOutNumSum==""){
               	  window.dataHgYear[i].payOutNumSum=0;
               	  
                 }
                  valueData+=window.dataHgYear[i].payOutNumSum+",";
                  xLabels+=window.dataHgYear[i].companyName+",";
                  linksData+="javascript:findLaborItemHg('"+window.dataHgYear[i].lid+"'),";
                  if(max<parseFloat(window.dataHgYear[i].payOutNumSum)){
               	        max= parseFloat(window.dataHgYear[i].payOutNumSum);
               	  }
             }
             valueData=valueData.substring(0,valueData.length-1);
             xLabels=xLabels.substring(0,xLabels.length-1); 
             linksData=linksData.substring(0,linksData.length-1); 
             title=window.dataHgYear[0].laborYear.substring(0,7)+"年劳务报酬";
             id="laborHg";
             drawHg(hight,width,title,valueData,linksData,xLabels,max,id);
         }
    }
    function drawLaborItemHg(){//公司项目
    	var hight,width,title,id;
        var valueData="";
        var linksData="";
        var xLabels="";
        var max=parseFloat(window.dataHgItem[0].itemNumSum);
        if(window.dataHgItem==null || window.dataHgItem=="")
             alert("");
        else{
        	hight="1000"; width="500";
            for(var i=0;i<window.dataHgItem.length;i++){
                 valueData=valueData+window.dataHgItem[i].itemNumSum+",";
                 xLabels=xLabels+window.dataHgItem[i].itemName+",";
                 linksData+="javascript:findLaborMonthHg("+window.dataHgItem[i].ltid+"),";
                 if(max<parseFloat(window.dataHgItem[i].itemNumSum)){
            	        max= parseFloat(window.dataHgItem[i].itemNumSum);
            	 }
            }
            valueData=valueData.substring(0,valueData.length-1);
            xLabels=xLabels.substring(0,xLabels.length-1); 
            linksData=linksData.substring(0,linksData.length-1);
            title="项目";
            id="laborHg";
            drawHg(hight,width,title,valueData,linksData,xLabels,max,id); 
        }
    }
    function drawLaborMonthHg(){//某项目各月明细
    	   var hight,width,title,id;
           var valueData="";
           var linksData="";
           var xLabels="";
           var max=parseFloat(window.dataHgMonth[0].payOutNumber);
           if(window.dataHgMonth==null || window.dataHgMonth=="")
                alert("");
           else{
        	   hight="1000"; width="500";
               for(var i=0;i<window.dataHgMonth.length;i++){
                    valueData=valueData+window.dataHgMonth[i].payOutNumber+",";
                    xLabels=xLabels+window.dataHgMonth[i].laborInDay+",";
                    if(max<parseFloat(window.dataHgMonth[i].payOutNumber)){
            	        max= parseFloat(window.dataHgMonth[i].payOutNumber);
            	    }
               }
               valueData=valueData.substring(0,valueData.length-1);
               xLabels=xLabels.substring(0,xLabels.length-1);  
               title="项目各月明细";
               id="laborHg";
               drawHg(hight,width,title,valueData,linksData,xLabels,max,id); 
           }
    }
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div style="font-family:'微软雅黑'; font-size:16px;">请选择年份：
        <select id="nian" onchange="" name="nianFen">
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
        </select>
    </div>
    <div style="width:50px;height:250px;" id="laborHg">
    </div>
    <div align="right" style="position:fixed;bottom:0;z-index:1000;">

    </div>
   
</body>
</html>