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
		onFindEveryHouseHg(22);
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
    function onDrawHg(hight,width,title,valueData,linksData,xLabels,max,id){
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

	//查询各个房产所有承租人某年的房租和,有转让则加上转让
	function onFindEveryHouseHg(uid) {
		houseReportD.findEveryHouse(uid,function(data) {
			eval("window.everyHouseHg = data;");
			onDrawEveryHouseHg();
		});
	}

	function onDrawEveryHouseHg() {
         var hight,width,title,id;
         var valueData="";
         var linksData="";
         var xLabels="";
         var max=parseFloat(window.everyHouseHg[0].rentalNumSum)+parseFloat(window.everyHouseHg[0].bieTransferNum);
         if(window.everyHouseHg==null || window.everyHouseHg==""){
              alert("game over");
         }

         else{
        	 hight="1000"; width="500";
             for(var i=0;i<window.everyHouseHg.length;i++){
               if(window.everyHouseHg[i].rentalNumSum!=0 || window.everyHouseHg[i].bieTransferNum!=0){
            	  valueData+=parseFloat(window.everyHouseHg[i].rentalNumSum)+parseFloat(window.everyHouseHg[i].bieTransferNum)+",";
            	  xLabels+=window.everyHouseHg[i].houseName+",";
                  linksData+="javascript:onFindSingleHouseHg("+window.everyHouseHg[i].hid+"),";
                  if(max<parseFloat(window.everyHouseHg[i].rentalNumSum)+parseFloat(window.everyHouseHg[i].bieTransferNum)){
                	  max=parseFloat(window.everyHouseHg[i].rentalNumSum)+parseFloat(window.everyHouseHg[i].bieTransferNum);
                  }
               }
             }
             valueData=valueData.substring(0,valueData.length-1);
             xLabels=xLabels.substring(0,xLabels.length-1); 
             linksData=linksData.substring(0,linksData.length-1); 
             title="房产管理";
             id="houseHg";
             onDrawHg(hight,width,title,valueData,linksData,xLabels,max,id);
         }
     }
	//查询某房产所有承租人某年的房租和 
	 function onFindSingleHouseHg(hid){
            houseReportD.findHouse(22,hid,function(data){ //记得传参数
            	eval("window.singleHouseHg = data;");
            	onDrawSingleHouseHg();
            });
     }
     function onDrawSingleHouseHg(){
    	 var hight,width,title,id;
         var valueData="";
         var linksData="";
         var xLabels="";
         var max="";
         if(window.singleHouseHg==null || window.singleHouseHg=="")
       	    alert("该年没有此房产出租或转让信息");
         else{
        	 hight="1000"; width="500";
        	 if(window.singleHouseHg.rentalNumSum!=null){
        		 valueData+=window.singleHouseHg.rentalNumSum+",";
        		 xLabels+="出租,";
        		 linksData+="javascript:onFindEveryLesseeHg("+window.singleHouseHg.hid+"),";
        		 max=parseFloat(window.singleHouseHg.rentalNumSum);
             }
        	 if(window.singleHouseHg.transferEndNumber!=null){
        		 valueData+=window.singleHouseHg.transferEndNumber+",";
        		 xLabels+="转让,";
        		 linksData+=",";
        		 max=parseFloat(window.singleHouseHg.transferEndNumber);
             }
             if(window.singleHouseHg.rentalNumSum!=null && window.singleHouseHg.transferEndNumber!=null){
                if(parseFloat(window.singleHouseHg.rentalNumSum)>parseFloat(window.singleHouseHg.transferEndNumber)){
                   max=parseFloat(window.singleHouseHg.rentalNumSum);
                }
             }
         }
         valueData=valueData.substring(0,valueData.length-1);
         xLabels=xLabels.substring(0,xLabels.length-1); 
         linksData=linksData.substring(0,linksData.length-1); 
         title="房产管理";
         id="houseHg";
         onDrawHg(hight,width,title,valueData,linksData,xLabels,max,id);
     }
 	//查询某房产各个承租人某年的房租和 
	 function onFindEveryLesseeHg(hid){
            houseReportD.findLessee(22,hid,function(data){//记得传参
            	eval("window.everyLesseeHg = data;");
            	onDrawEveryLesseeHg();
            });
     }
     function onDrawEveryLesseeHg(){
    	 var hight,width,title,id;
         var valueData="";
         var linksData="";
         var xLabels="";
         var max=parseFloat(window.everyLesseeHg[0].rentalNumSum);
         if(window.everyLesseeHg==null || window.everyLesseeHg==""){
             alert("game over");
        }

        else{
            hight="1000"; width="500";
            for(var i=0;i<window.everyLesseeHg.length;i++){
                 valueData+=window.everyLesseeHg[i].rentalNumSum+",";
                 xLabels+=window.everyLesseeHg[i].rentalName+",";
                 linksData+="javascript:onfindSingleHouseHg("+"  "+"),";
                 if(max<parseFloat(window.everyLesseeHg[i].rentalNumSum)){
                	 max=parseFloat(window.everyLesseeHg[i].rentalNumSum);
                 }
            }
            valueData=valueData.substring(0,valueData.length-1);
            xLabels=xLabels.substring(0,xLabels.length-1); 
            linksData=linksData.substring(0,linksData.length-1); 
            title="各承租人";
            id="houseHg";
            onDrawHg(hight,width,title,valueData,linksData,xLabels,max,id);
        }
     }
</script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>

		<div style="width: 50px; height: 250px;" id="houseHg">
		</div>
		<div align="right" style="position: fixed; bottom: 0; z-index: 1000;">

		</div>

	</body>
</html>