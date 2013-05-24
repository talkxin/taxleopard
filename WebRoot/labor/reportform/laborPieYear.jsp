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
    	findLaborYearPie();
    }
    function drawPie(hight,width,title,valueData,linksData,labelsData,tooltip,id){
     	 var so = new SWFObject("/TaxPersonalReporting1.0/paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", hight, width, "9", "#FFFFFF");
              so.addVariable("variables","true");
              so.addVariable("title",title+",{font-size: 20;}");
              so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
              so.addVariable("values",valueData);
              so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
              so.addVariable("links",linksData);
              so.addVariable("pie_labels", labelsData);
              so.addVariable("tool_tip", tooltip+"<br>#x_label#<br>Value: #val#");
              so.addParam("allowScriptAccess", "always" );
              so.write(id);  
          
   }
    function findLaborYearPie(){
    	laborReportD.findLaborYear('2011',function(data){
            	eval("window.dataPieYear = data;");
            	drawLaborYearPie();
        });
    }

    function findLaborItemPie(lid){
    	laborReportD.findLaborItem(22,'2011',lid,function(data){
            	eval("window.dataPieItem = data;");
            	drawLaborItemPie();
        });
    }
    function findLaborMonthPie(ltid){
    	laborReportD.findLaborMonth(22,'2011',ltid,function(data){
    		eval("window.dataPieMonth = data;");
        	drawLaborMonthPie();

        });
    }
    function drawLaborYearPie(){//年劳务报酬
         var hight,width,title,tooltip,id;
         var valueData="";
         var linksData="";
         var labelsData="";
         if(window.dataPieYear==null || window.dataPieYear=="")
              alert("该年无劳务报酬");
         else{
             hight="1000"; width="500";
             for(var i=0;i<window.dataPieYear.length;i++){
                  valueData+=window.dataPieYear[i].payOutNumSum+",";
                  labelsData+=window.dataPieYear[i].companyName+",";
                  linksData+="javascript:findLaborItemPie('"+window.dataPieYear[i].lid+"'),";
             }
             valueData=valueData.substring(0,valueData.length-1);
             labelsData=labelsData.substring(0,labelsData.length-1); 
             linksData=linksData.substring(0,linksData.length-1); 
             title=window.dataPieYear[0].laborYear.substring(0,7)+"年劳务报酬";
             tooltip="劳务报酬(年)";
             id="laborPie";
             drawPie(hight,width,title,valueData,linksData,labelsData,tooltip,id);
         }
    }
    function drawLaborItemPie(){//公司项目
    	var hight,width,title,tooltip,id;
        var valueData="";
        var linksData="";
        var labelsData="";
        if(window.dataPieItem==null || window.dataPieItem=="")
             alert("");
        else{
        	hight="1000"; width="500";
            for(var i=0;i<window.dataPieItem.length;i++){
                 valueData=valueData+window.dataPieItem[i].itemNumSum+",";
                 labelsData=labelsData+window.dataPieItem[i].itemName+",";
                 linksData+="javascript:findLaborMonthPie("+window.dataPieItem[i].ltid+"),";
               }
            valueData=valueData.substring(0,valueData.length-1);
            labelsData=labelsData.substring(0,labelsData.length-1); 
            linksData=linksData.substring(0,linksData.length-1);
            title="项目";
            tooltip="项目(年)";
            id="laborPie";
            drawPie(hight,width,title,valueData,linksData,labelsData,tooltip,id); 
        }
    }
    function drawLaborMonthPie(){//某项目各月明细
    	   var hight,width,title,tooltip,id;
           var valueData="";
           var linksData="";
           var labelsData="";
           if(window.dataPieMonth==null || window.dataPieMonth=="")
                alert("");
           else{
        	   hight="1000"; width="500";
               for(var i=0;i<window.dataPieMonth.length;i++){
                    valueData=valueData+window.dataPieMonth[i].payOutNumber+",";
                    labelsData=labelsData+window.dataPieMonth[i].laborInDay+",";
                  }
               valueData=valueData.substring(0,valueData.length-1);
               labelsData=labelsData.substring(0,labelsData.length-1);  
               title="项目各月明细";
               tooltip="项目(月)";
               id="laborPie";
               drawPie(hight,width,title,valueData,linksData,labelsData,tooltip,id); 
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
    <div style="width:50px;height:250px;" id="laborPie">
    </div>
    <div align="right" style="position:fixed;bottom:0;z-index:1000;">

    </div>
   
</body>
</html>