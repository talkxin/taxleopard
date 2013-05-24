<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
   <title>劳务报酬</title>
   <style type="text/css">
     body{font-size:12px; margin:0; font-family:"微软雅黑"}
     td{
        border:1px solid #000000;
     }
     .userlist{ background-color:#E7EFD3}
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
       var item;
       var kaiguan;
       function showRow(ltid){
           var h="tr[class='"+ltid+"']"   
           var trs = $(h); 
           for(var i = 0; i < trs.length; i++){
                trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
           }
           kaiguan=false;
       }

         
          function findLaborItem(lid){
            kaiguan=false;
          	laborReportD.findLaborItem(22,'2012',lid,callItem);
          }
          function findLaborMonth(ltid){
           if(kaiguan==false){
              item="#item"+ltid;
              laborReportD.findLaborMonth(22,'2012',ltid,callItemMonth);
              kaiguan=true;
            }else{
              showRow(ltid);}
          }
          function callItem(data){
              eval("window.item = data;");
              var laborItemData="<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">"
	                 +"<tr ><td width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">项目</span></td>"
                     +"<td width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">数额（人民币）￥</span></td>"
                     +"<td width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额（人民币）￥</span></td>"
                     +"<td width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">操作</span></td></tr>"
              for(var j=0;j<window.item.length;j++){
            	  laborItemData+="<tr onclick=\"findLaborMonth('"+window.item[j].ltid+"')\" class=\"userlist\" id=\"t"+j+"\">"
                            +"<td align=\"left\" height=\"30px\"><a"
                            
                            +" href=\"#\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\" style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"
                            
                            
                            
                            +window.item[j].itemName                                      
                            +"</td><td>"+window.item[j].itemNumSum+"</td><td>"
                           
                            +window.item[j].itemTaxSum+"</td><td>修改/删除</td></tr><p id=\"item"+window.item[j].ltid

                            +"\"></p>";
              }
              laborItemData+="</table>"; 
              if(window.item==null || window.item=="")
                  alert("无信息");
              else
               $("#report").html(laborItemData);
          }
          
          function callItemMonth(data){
              eval("window.itemMonth= data;");
              var monthData="";
              for(var j=0;j<window.itemMonth.length;j++){
            	  monthData+="<tr class=\""+window.itemMonth[j].ltid+"\" id=\"t0-"+j+"\"><td>"
                  +window.itemMonth[j].laborInDay                                       
                  +"</td><td>"+window.itemMonth[j].payOutNum+"</td>";

                   var count=0;
            	   for(var i=0;i<window.itemMonth.length;i++){   
               	     if(window.itemMonth[j].laborInDay.substring(0,7)==window.itemMonth[i].laborInDay.substring(0,7)){
                   	          count++;   
               	      }   
               	   } 
               	   
               	   if(count>1){
                   	   if(j<window.itemMonth.length-1 && window.itemMonth[j].laborInDay.substring(0,7)==window.itemMonth[j+1].laborInDay.substring(0,7)){
               		        monthData+="<td Rowspan="+count+">"+window.itemMonth[j].taxNum+"</td>";
                            monthData+="<td><input type=\"button\" value=\"修改\" onclick=\"upService(window.itemMonth[j]);\"/>"
                                 +"<input type=\"button\" value=\"删除\" onclick=\"delService(window.itemMonth[j]);\"/></td></tr>";
               	       }
                       else{
                    	   monthData+="<td><input type=\"button\" value=\"修改\" onclick=\"upService(window.itemMonth[j]);\"/>"
                               +"<input type=\"button\" value=\"删除\" onclick=\"delService(window.itemMonth[j]);\"/></td></tr>";
                       }

                   }
               	   else{monthData+="<td>"+window.itemMonth[j].taxNum+"</td>";
                        monthData+="<td><input type=\"button\" value=\"修改\" onclick=\"upService(window.itemMonth[j]);\"/>"
                        +"<input type=\"button\" value=\"删除\" onclick=\"delService(window.itemMonth[j]);\"/></td></tr>";}
              }
              
                              
                $(item).html(monthData);
              
          }
      </script>   
   
</head>

<body onload="findLaborItem(229);">
  <div  class="tabContainer" style="clear:both; margin:0 auto; text-align:center; height:550px; width:700px">
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
