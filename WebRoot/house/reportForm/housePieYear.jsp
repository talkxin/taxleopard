<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type='text/javascript'
			src='/TaxPersonalReporting1.0/dwr/interface/houseReportD.js'></script>
		<script type='text/javascript'
			src='/TaxPersonalReporting1.0/dwr/engine.js'></script>
		<script type='text/javascript'
			src='/TaxPersonalReporting1.0/dwr/util.js'></script>
		<script type='text/javascript'
			src='/TaxPersonalReporting1.0/paychex/reportForm/js/swfobject.js'></script>

<script type="text/javascript">
	window.onload = function() {
		onFindEveryHosePie(22);
	}

	//画饼状图
	function onDrawPie(hight, width, title, valueData, linksData, labelsData,tooltip, id) {
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

	//查询各个房产针对所有承租人房租和,有转让则加上转让
	function onFindEveryHosePie(uid) {
		houseReportD.findEveryHouse(uid,function(data) {
			eval("window.everyHousePie = data;");
			onDrawEveryHousePie();
		});
	}

	function onDrawEveryHousePie() {
		var hight,width,title,tooltip,id;
         var valueData="";
         var linksData="";
         var labelsData="";
         if(window.everyHousePie==null || window.everyHousePie==""){
              alert("game over");
         }

         else{
             hight="1000"; width="500";
             for(var i=0;i<window.everyHousePie.length;i++){
               if(window.everyHousePie[i].rentalNumSum!=0 || window.everyHousePie[i].bieTransferNum!=0){
            	  valueData+=parseFloat(window.everyHousePie[i].rentalNumSum)+parseFloat(window.everyHousePie[i].bieTransferNum)+",";
            	  labelsData+=window.everyHousePie[i].houseName+",";
                  linksData+="javascript:onFindSingleHousePie("+window.everyHousePie[i].hid+"),";
               }
             }
             valueData=valueData.substring(0,valueData.length-1);
             labelsData=labelsData.substring(0,labelsData.length-1); 
             linksData=linksData.substring(0,linksData.length-1); 
             title="房产管理";
             tooltip="所有房产";
             id="housePie";
             onDrawPie(hight,width,title,valueData,linksData,labelsData,tooltip,id);
         }
     }
    
	//查询某房产针对所有承租人的房租和  有转让的展开转让
	 
	 function onFindSingleHousePie(hid){
            houseReportD.findHouse(22,hid,function(data){   //记得传参数
            	eval("window.singleHousePie = data;");
            	onDrawSingleHousePie();
            });
     }
     function onDrawSingleHousePie(){
 		var hight,width,title,tooltip,id;
        var valueData="";
        var linksData="";
        var labelsData="";
         if(window.singleHousePie==null || window.singleHousePie=="")
       	    alert("没有此房产出租或转让信息");
         else{
        	 hight="1000"; width="500";
        	 if(window.singleHousePie.rentalNumSum!=null){
        		 valueData+=window.singleHousePie.rentalNumSum+",";
        		 labelsData+="出租,";
        		 linksData+="javascript:onfindEveryLesseePie("+window.singleHousePie.hid+"),";
        		 
             }
        	 if(window.singleHousePie.transferEndNumber!=null){
        		 valueData+=window.singleHousePie.transferEndNumber+",";
        		 labelsData+="转让,";
        		 linksData+=",";
        		 //tooltip=window.singleHousePie.houseName+"房产<br>转让时间："+window.singleHousePie.transferTime+",";
             }
         }
         valueData=valueData.substring(0,valueData.length-1);
         labelsData=labelsData.substring(0,labelsData.length-1); 
         linksData=linksData.substring(0,linksData.length-1); 
         title="房产管理";
         tooltip="某房产";
         id="housePie";
         onDrawPie(hight,width,title,valueData,linksData,labelsData,tooltip,id);
     }
 	//查询某房产各个承租人某年的房租和 
	 function onfindEveryLesseePie(hid){
            houseReportD.findLessee(22,hid,function(data){  //记得传参数
            	eval("window.everyLesseePie = data;");
            	onDrawEveryLesseePie();
            });
     }
     function onDrawEveryLesseePie(){
    	 var hight,width,title,tooltip,id;
         var valueData="";
         var linksData="";
         var labelsData="";
         if(window.everyLesseePie==null || window.everyLesseePie==""){
             alert("game over");
        }

        else{
            hight="1000"; width="500";
            for(var i=0;i<window.everyLesseePie.length;i++){
                 valueData+=window.everyLesseePie[i].rentalNumSum+",";
                 labelsData+=window.everyLesseePie[i].rentalName+",";
                 linksData+=",";
            }
            valueData=valueData.substring(0,valueData.length-1);
            labelsData=labelsData.substring(0,labelsData.length-1); 
            linksData=linksData.substring(0,linksData.length-1); 
            title="各承租人";
            tooltip="各承租人";
            id="housePie";
            onDrawPie(hight,width,title,valueData,linksData,labelsData,tooltip,id);
        }
     }
</script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<div style="width: 50px; height: 250px;" id="housePie">
		</div>
		<div align="right" style="position: fixed; bottom: 0; z-index: 1000;">

		</div>

	</body>
</html>