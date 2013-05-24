<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
   <title>年劳务报酬文字报表</title>
   <style type="text/css">
     body{font-size:12px; margin:0; font-family:"微软雅黑"}
     td{
        border:1px solid #000000;
     }
     .userlist1{ background-color:#AFEEEE}
     .userlist{background-color:#E7EFD3}
     .list1{
        padding-top:10px;
        border-bottom:1px solid #CCCCCC;
     }
     .tabContainer{ margin:0 auto; position:relative; margin:0 auto;  background-color:#e0e3e2; border:3px solid #abadac; }
  </style>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/interface/laborReportD.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/engine.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/dwr/util.js'></script>
    <script type='text/javascript' src='/TaxPersonalReporting1.0/paychex/reportForm/js/jquery-1.4.2.min.js'></script>
    <script type="text/javascript">
        var company;
        var item;
        var kaiguan1,kaiguan2;
        function hideRow1(para){ 
           var pa="tr[class='C"+para+"']"   
           var trs = $(pa); 
           for(var i = 0; i < trs.length; i++){
                trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
           }
           kaiguan1=false;
           if(kaiguan2==true){

            kaiguan2=false;
           }
        }
        function hideRow2(para){
            var pa="tr[class='I"+para+"']"   
            var trs = $(pa); 
            for(var i = 0; i < trs.length; i++){
                 trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
            }
            kaiguan2=false;
         }

          function findLaborYear(){
            kaiguan1=false;
            kaiguan2=false;
            laborReportD.findLaborYear('2011',callYear);
          }
          function findLaborItem(lid){
            if(kaiguan1==false){ 
              company="#company"+lid;
                    if(window.wriItem==null){
            	       DWREngine.setAsync(false);
          	           laborReportD.findLaborItem(22,'2011',lid,function(data){
           			   eval("window.wriItem = data;");
           	        });
          	        DWREngine.setAsync(true);
              }
               callWriItem();
          	   kaiguan1=true;
          	}
            else{hideRow1(lid);}
          }
          function findLaborMonth(ltid){
            if(kaiguan2==false){
              item="#item"+ltid;
              laborReportD.findLaborMonth(22,'2011',ltid,callItemMonth);
              kaiguan2=true;
            }
            else{hideRow2(ltid);}
          }

          function callYear(data){
              eval("window.year=data;");
              var laborYearData="<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">"
	                 +"<tr ><td width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">公司</span></td>"
                  +"<td width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">数额（人民币）￥</span></td>"
                  +"<td width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额（人民币）￥</span></td></tr>";
              for(var j=0;j<window.year.length;j++){
            	  laborYearData+="<tr onclick=\"findLaborItem('"+window.year[j].lid+"');\" class=\"userlist1\" id=\"t"+j+"\">"
                            +"<td align=\"left\" height=\"30px\"><a "
                            
                            +" href=\"#\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\"     style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"
                            
                            +window.year[j].companyName                                      
                            +"</td><td>"+window.year[j].payOutNumSum+"</td><td>"
                           
                            +window.year[j].taxNumSum+"</td></tr><p id=\"company"+window.year[j].lid

                            +"\"></p>";
              }
              laborYearData+="</table>"; 
              if(window.year==null || window.year=="")
                  alert("无信息");
              else
               $("#report").html(laborYearData);
        }
          function callWriItem(){
        	  
             // eval("window.wriItem=data;");
              var laborItemData="";
              for(var j=0;j<window.wriItem.length;j++){
            	  
            	  laborItemData+="<tr onclick=\"findLaborMonth("+window.wriItem[j].ltid+");\" style=\"background-color:#E7EFD3\" class=\"C"+window.wriItem[j].lid+"\" id=\"t0"+j+"\">"
                            +"<td height=\"30px\"><a "
                            
                            +" href=\"#\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\"     style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"
                            
                            
                            
                            +window.wriItem[j].itemName                                      
                            +"</td><td>"+window.wriItem[j].itemNumSum+"</td><td>"
                           
                            +window.wriItem[j].itemTaxSum+"</td></tr><p id=\"item"+window.wriItem[j].ltid

                            +"\"></p>";
              }
             
               $(company).html(laborItemData);
          }
          function callItemMonth(data){
              eval("window.wriItemMonth= data;");
              var monthData="";
              for(var j=0;j<window.wriItemMonth.length;j++){
            	  monthData+="<tr class=\"I"+window.wriItemMonth[j].ltid+"\" id=\"t00-"+j+"\"><td>"
                          +window.wriItemMonth[j].laborInDay                                       
                          +"</td><td>"+window.wriItemMonth[j].payOutNumber+"</td><td>"
                          +window.wriItemMonth[j].taxNumber+"</td></tr>";
              }
              
                $(item).html(monthData);
          }
      </script>   
   
</head>

<body onload="findLaborYear();">
  <div  class="tabContainer" style="overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:700px">
    <div  style="position:absolute; margin-left:680px"><a onclick="javascript:toReportForm();" href="#"><img src="/TaxPersonalReporting1.0/paychex/reportForm/images/delete1.png"  border="0"/></a>
    </div>
    <div style="position:absolute;margin-left:450px; margin-top:20px"> <input type="button"  value="返回" onclick="javascript:history.go(-1)"/>
    </div>
    <h1 id="h1" style="text-align:center;font-size:18px">劳务报酬</h1>
    <div align="left" style="font-family:'微软雅黑';margin-left:100px;font-size:16px;">请选择年份：
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
    <br>
    <div id="report">
       
    </div>
  </div>

</body>
</html>
