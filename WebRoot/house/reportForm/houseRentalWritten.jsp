<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
   <title>房产管理</title>
    <style type="text/css">
     body{font-size:12px; margin:0; font-family:"微软雅黑"}
     td{
        border:1px solid #000000;
     }
     .userlist{ background-color:#AFEEEE}
     .userlist1{background-color:#E7EFD3}
     .list1{
        padding-top:10px;
        border-bottom:1px solid #CCCCCC;
     }
     .tabContainer{ margin:0 auto; position:relative; margin:0 auto;  background-color:#e0e3e2; border:3px solid #abadac; }
    </style>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/interface/houseReportD.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/engine.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/util.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/paychex/reportForm/js/jquery-1.4.2.min.js'></script>
   <!--   <script type='text/javascript' src='/TaxPersonalReporting1.0/house/js/houseReport.js'></script> -->
    <script type="text/javascript">
	      var j$ = jQuery.noConflict();
    </script>
    <script type="text/javascript">
    var _houseRentalReportArray=new Array();
    var _houseRentalReport;
   //判断有没有该数据
    function onReturnHouseRentalReport(para){
      for ( var i = 0; i < _houseRentalReportArray.length; i++) {
    		if(_houseRentalReportArray[i].lesseeId==para){
    			_houseRentalReport=_houseRentalReportArray[i];
    			return false;
    		}
    		
    	}
        return true;
    }

     //某房产针对某个承租人的房租合同
     function onfindSingleLessee(uid,hid,rid){
        if(uid!=null && hid!=null && rid!=null){
          if(onReturnHouseRentalReport(rid)){
             DWREngine.setAsync(false);
         	houseReportD.findSingleLessee(uid,hid,rid, function(data){
         		_houseRentalReportArray.unshift({lesseeId:rid,value:data});
         		_houseRentalReport={lesseeId:rid,value:data};
             });
         	DWREngine.setAsync(false);
           }
           eval("window.wriSingleLessee= _houseRentalReport.value;");
           onCallWriEveryLessee();
         }else{j$("#wriLesseeReport").html("<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>没有该承租人信息</center>");}
       }
       function onCallWriEveryLessee(){
           
           var wriEveryLesseeData="<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">"
	                 +"<tr ><td width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">承租人</span></td>"
	                 +"<td width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">租期</span></td>"
                  +"<td width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">数额（人民币）￥</span></td>"
                  +"<td width=\"130\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额（人民币）￥</span></td>"
                  +"<td width=\"150\" ><span style=\"font-size:14px; font-weight:bold;\">月租金（人民币）￥</span></td>"
                  +"<td width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">操作</span></td></tr>"

                  for(var j=0;j<window.wriSingleLessee.length;j++){
                	  
                 	 wriEveryLesseeData+="<tr onclick=\"\" style=\"background-color:#E7EFD3\" class=\"Le\" id=\"\">"
                                +"<td ><span style=\"font-weight:bold\">"+window.wriSingleLessee[j].rentalName
                                +"</td><td height=\"30px\">"+window.wriSingleLessee[j].rentalStartTime+"<br/>"+"至"+"<br/>"+window.wriSingleLessee[j].rentalEndTime                                    
                                +"</td><td>"+window.wriSingleLessee[j].rentalTaxEndNumber+"</td><td>"
                               
                                +window.wriSingleLessee[j].rentalTax+"</td><td>"+window.wriSingleLessee[j].rentalNumber
                                +"</td><td><input type=\"button\" value=\"修改\" onclick=\"\"/>" 
                                +"<input type=\"button\" value=\"删除\" onclick=\"\"/></td></td></tr><p id=\"\"></p>";
                  }

            wriEveryLesseeData+="</table>"; 
           if(window.wriSingleLessee==null || window.wriSingleLessee=="")
         	  j$("#wriLesseeReport").html("<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>无该承租人信息</center>");
           else
            j$("#wriLesseeReport").html(wriEveryLesseeData);
       }
       
    
    </script>
</head>

<body>
  <div  class="tabContainer" style="clear:both; margin:0 auto; text-align:center; height:550px; width:700px">
    <h1 id="h1" style="text-align:center;font-size:18px">房产管理出租信息</h1>
    <br>
    <div><input type="button" value="打开出租信息报表" onclick="onfindSingleLessee(22,1,3)"/></div>
    <div id="wriLesseeReport">
       
    </div>
  </div>

</body>
</html>
