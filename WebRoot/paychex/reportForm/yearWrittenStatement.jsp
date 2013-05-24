<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
   <title>年文字报表</title>
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
    <script type='text/javascript' src='dwr/interface/dwrTest.js'></script>
    <script type='text/javascript' src='dwr/engine.js'></script>
    <script type='text/javascript' src='dwr/util.js'></script>
    <script type='text/javascript' src='paychex/reportForm/js/jquery-1.4.2.min.js'></script>
    <script type="text/javascript">   
      var url,s,yearW;
      function initTable(){      
           var tableRows=tb.rows;    
           for(i=0;i<tableRows.length;i++){
              if(tableRows[i].id.length>2)
              tableRows[i].style.display="none";
           }
           url = window.location.href;
           s=url.indexOf("?"); 
           yearW=url.substring(s+7);
           countMonthNum(yearW);
           findWageYear(yearW);
           
       }   
       var countP=0;
       var countS=0;
       var countB=0;
       var countI=0;
       var countT=0;
       var countBasic=0;
       function showRow(tid){ 
    	   if(tid.id=="t0") countP++;
           if(tid.id=="t1") countS++;
           if(tid.id=="t2") countB++; 
           if(tid.id=="t3") countI++; 
           if(tid.id=="t4") countT++;
           if(tid.id=="t5") countBasic++;  
           var tableRows=tb.rows;
           for(j=0;j<tableRows.length;j++){
              var s=tableRows[j].id;
              if(s.indexOf(tid.id)!=-1 && s!=tid.id && s.length>2){
                 //alert(s);
                 if(tableRows[j].style.display=="")              
                    tableRows[j].style.display="none";   
                 else   
                    tableRows[j].style.display=""; 
             }
          }
          
       }
       
       
         var p="";
         var s="";
         var b="";
         var i="";
         function findPrize(month){
            var prizeJoin=new Object();
            dwrTest.findPrize(prizeJoin,month,callPrize);
            p="#p"+month;
         }
         function findSubsidy(month){
            var subsidyJoin=new Object();
            dwrTest.findSubsidy(subsidyJoin,month,callSubsidy);
            s="#s"+month;
         }
         function findBonus(month){
            var bonus=new Object();
            dwrTest.findBonus(bonus,month,callBonus);
            b="#b"+month;
         }
         function findInsurance(month){
            var insurance=new Object();
            dwrTest.findInsurance(insurance,callInsurance);
            i="#i"+month;
         }
         function findWageYear(yearW){
            dwrTest.findWageYear(yearW,callBack);
          
         }

         function findBasicWage(){
           if(countBasic%2==0){
        	   dwrTest.findPayrollMonth(yearW,callBasicWage);
           }
         }
         function findPrizeMonth(){
            if(countP%2==0){
            	dwrTest.findPrizeMonth(yearW,callPrizeMonth);
             }
         }
         function findSubsidyMonth(){
        	if(countS%2==0){
        		dwrTest.findSubsidyMonth(yearW,callSubsidyMonth);
        	}
         }
         function findBonusMonth(){
        	if(countB%2==0){
        		dwrTest.findBonusMonth(yearW,callBonusMonth);
        	}
         }
         function findInsuranceMonth(){
        	if(countI%2==0){
        	  countMonthNum(yearW);
              var insuranceMonth=new Object();
              dwrTest.findInsurance(insuranceMonth,callInsuranceMonth);
        	}
         }
          function findTaxMonth(){
        	if(countT%2==0){
        		dwrTest.findPayrollMonth(yearW,callTaxMonth);
        	}
         }
         
  //回调函数       
         function callBack(data){
            eval("window.dataYear = data;");
            if(window.dataYear.basicWageSum==null){
                $("#t5").hide();
            }
            if(window.dataYear.prizeSum==null){
                $("#t0").hide();
            }
            if(window.dataYear.subsidySum==null){
                $("#t1").hide();
            }
            if(window.dataYear.bonusSum==null){
                $("#t2").hide();
            }
            if(window.dataYear.insuranceSum==null){
            	$("#t3").hide();
            }
            if(window.dataYear.taxNumberSum==null){
                $("#t4").hide();
            }
            var bs=parseFloat(window.dataYear.basicWageSum)/parseFloat(window.dataYear.payOutNumberSum);
  	        var bsWagePercent=round(bs,1);

  	        var pr=parseFloat(window.dataYear.prizeSum)/parseFloat(window.dataYear.payOutNumberSum);
  	        var prizePercent=round(pr,1);

  	        var su=parseFloat(window.dataYear.subsidySum)/parseFloat(window.dataYear.payOutNumberSum);
  	        var subsidyPercent=round(su,1);

  	        var bo=parseFloat(window.dataYear.bonusSum)/parseFloat(window.dataYear.payOutNumberSum);
  	        var bonusPercent=round(bo,1);

  	        var yearInsurance= parseFloat(window.dataYear.insuranceSum)* parseFloat(window.dataNum.length);
  	        var ins=parseFloat(yearInsurance)/parseFloat(window.dataYear.payOutNumberSum);
  	        var insurancePercent=round(ins,1);
  	       
  	        
  	        var ta=parseFloat(window.dataYear.taxNumberSum)/parseFloat(window.dataYear.payOutNumberSum);
  	        var taxNumberPercent=round(ta,1);

            
  	        $("#h1").append(window.dataYear.inPayYear+"年工资薪金详细");
  	        $("#bsWageNumber").append(window.dataYear.basicWageSum);
  	        $("#bsWagePercent").append(bsWagePercent);
            $("#prizeNumber").append(window.dataYear.prizeSum);
            $("#prizePercent").append(prizePercent);
            $("#subsidyNumber").append(window.dataYear.subsidySum);
            $("#subsidyPercent").append(subsidyPercent);
            $("#bonusNumber").append(window.dataYear.bonusSum);
            $("#bonusPercent").append(bonusPercent);
            $("#insuranceNumber").append(yearInsurance);
            $("#insurancePercent").append(insurancePercent);
            $("#taxNumber").append(window.dataYear.taxNumberSum);
            $("#taxNumberPercent").append(taxNumberPercent);
          }

     //基础工资
         function callBasicWage(data){
             for(var i=0;i<data.length;i++){
                 eval("window.dataBs = data;");
             }
             
             var basicWageData="";
             for(var j=0;j<window.dataBs.length;j++){
               basicWageData=basicWageData+"<tr class=\"userlist1\" id=\"t5-"+j+"\"><td style=\"font-weight:bold\">"
                         +window.dataBs[j].payMonth                                      
                         +"</td><td>"+window.dataBs[j].basicWage+"</td><td>";
               basicWageData+=round(parseFloat(window.dataBs[j].basicWage)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr>";
                         
             }
               
               $("#basicWageChild").html(basicWageData);
          }


      //奖金  
          function callPrizeMonth(data){
            for(var i=0;i<data.length;i++){
                eval("window.dataP = data;");
            }
            var prizeMonthData="";
            for(var j=0;j<window.dataP.length;j++){
              prizeMonthData=prizeMonthData+"<tr onclick=\"showRow(this);\" class=\"userlist1\" id=\"t0-"+j+"\">"
                        +"<td height=\"30px\"><a onclick=\"javascript:findPrize('"+window.dataP[j].prMonth
                        
                        +"')\" href=\"#\"><img src=\"paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\"     style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"
                        
                        
                        
                        +window.dataP[j].prMonth                                       
                        +"</td><td>"+window.dataP[j].monthPrize+"</td><td>";
                       
              prizeMonthData+=round(parseFloat(window.dataP[j].monthPrize)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr><p id=\"p"+window.dataP[j].prMonth

                        +"\"></p>";
              
            }
            
            $("#prizeChild").html(prizeMonthData);
            
          }
          
          function callPrize(data){
            for(var i=0;i<data.length;i++){
                eval("window.dataP1 = data;");
            }
            var prizeData="";
            
           
               for(var j=0;j<window.dataP1.length;j++){
                   prizeData=prizeData+"<tr id=\"t00-"+j+"\"><td>"
                        +window.dataP1[j].prizeName                                       
                        +"</td><td>"+window.dataP1[j].prizeNumber+"</td><td>";
                   prizeData+=round(parseFloat(window.dataP1[j].prizeNumber)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr>";
                        
                      
               }
                    
                  $(p).html(prizeData);
          }
          

       //补贴
          function callSubsidyMonth(data){
              for(var i=0;i<data.length;i++){
                  eval("window.dataS = data;");
              }
              var subsidyMonthData="";
              for(var j=0;j<window.dataS.length;j++){
                subsidyMonthData=subsidyMonthData+"<tr class=\"userlist1\" id=\"t1-"+j+"\">"
                          +"<td height=\"30px\"><a onclick=\"javascript:findSubsidy('"+window.dataS[j].suMonth
                          
                          +"')\" href=\"#\"><img src=\"paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\"     style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"
                          
                          +window.dataS[j].suMonth                                      
                          +"</td><td>"+window.dataS[j].monthSubsidy+"</td><td>";
                subsidyMonthData+=round(parseFloat(window.dataS[j].monthSubsidy)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr><p id=\"s"+window.dataS[j].suMonth

                          +"\"></p>";
              }
              
              $("#subsidyChild").html(subsidyMonthData);
              
            }
          function callSubsidy(data){
            for(var i=0;i<data.length;i++){
                eval("window.dataS1 = data;");
            }
            var subsidyData="";
            for(var j=0;j<window.dataS1.length;j++){
              subsidyData=subsidyData+"<tr id=\"t11-"+j+"\"><td>"
                        +window.dataS1[j].subsidyName                                       
                        +"</td><td>"+window.dataS1[j].subsidyNumber+"</td><td>";
              subsidyData+=round(parseFloat(window.dataS1[j].subsidyNumber)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr>";
            }
            
              $(s).html(subsidyData);
          }


      //分红
          function callBonusMonth(data){
              for(var i=0;i<data.length;i++){
                  eval("window.dataB = data;");
              }
              var bonusMonthData="";
              for(var j=0;j<window.dataB.length;j++){
                bonusMonthData=bonusMonthData+"<tr class=\"userlist1\" id=\"t2-"+j+"\">"
                          +"<td height=\"30px\"><a onclick=\"javascript:findBonus('"+window.dataB[j].boMonth
                          
                          +"')\" href=\"#\"><img src=\"paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\"     style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"
                          
                          +window.dataB[j].boMonth                                       
                          +"</td><td>"+window.dataB[j].monthBonus+"</td><td>";
                bonusMonthData+=round(parseFloat(window.dataB[j].monthBonus)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr><p id=\"b"+window.dataB[j].boMonth

                          +"\"></p>";
              }
              
              $("#bonusChild").html(bonusMonthData);
              
            }
          function callBonus(data){
            for(var i=0;i<data.length;i++){
                eval("window.dataB1 = data;");
            }
            
            var bonusData="";
            for(var j=0;j<window.dataB1.length;j++){
              bonusData=bonusData+"<tr id=\"t22-"+j+"\"><td>bonus"+j                                     
                        +"</td><td>"+window.dataB1[j].bonusNumber+"</td><td>";
              bonusData+=round(parseFloat(window.dataB1[j].bonusNumber)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr>";
            }
              
              $(b).html(bonusData);
          }
          

     //社保
          function callInsuranceMonth(data){
              
              eval("window.dataI = data;");
              
              var insuranceMonthData="";
              for(var j=0;j<window.dataNum.length;j++){
                  insuranceMonthData=insuranceMonthData+"<tr class=\"userlist1\" id=\"t3-"+j+"\">"
                          +"<td height=\"30px\"><a onclick=\"javascript:findInsurance('"+window.dataNum[j].payMonth
                          +"')\" href=\"#\"><img src=\"paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\" style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"
                          
                          +window.dataNum[j].payMonth                                       
                          +"</td><td>"+window.dataI.insSum+"</td><td>";
                  insuranceMonthData+=round(parseFloat(window.dataI.insSum)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr><p id=\"i"+window.dataNum[j].payMonth

                  +"\"></p>";
              }
              //alert(window.data.insuranceSum);
              $("#insuranceChild").html(insuranceMonthData);
              
          }
          function callInsurance(data){
            
            eval("window.dataI1 = data;");
            
            var insuranceData="";
            insuranceData=insuranceData+"<tr id=\"t33-0\"><td>养老保险"                                      
            +"</td><td>"+window.dataI1.pensionP+"</td><td>";
            
            insuranceData+=round(parseFloat(window.dataI1.pensionP)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr>"
           
            +"<tr id=\"t33-1\"><td>医疗保险"                                  
            +"</td><td>"+window.dataI1.medicalP+"</td><td>";
            insuranceData+=round(parseFloat(window.dataI1.medicalP)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr>"
            +"<tr id=\"t33-2\"><td>失业保险"                                      
            +"</td><td>"+window.dataI1.unemploymentP+"</td><td>";
            insuranceData+=round(parseFloat(window.dataI1.unemploymentP)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr>"
            +"<tr id=\"t33-3\"><td>公积金"                                      
            +"</td><td>"+window.dataI1.housingP+"</td><td>";
            insuranceData+=round(parseFloat(window.dataI1.housingP)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr>";
            
            
            $(i).html(insuranceData);
            
          }

      //个税
          function callTaxMonth(data){
              for(var i=0;i<data.length;i++){
                  eval("window.dataT = data;");
              }
              
              var taxMonthData="";
              for(var j=0;j<window.dataT.length;j++){
                taxMonthData=taxMonthData+"<tr class=\"userlist1\" id=\"t4-"+j+"\"><td style=\"font-weight:bold\">"
                          +window.dataT[j].payMonth                                       
                          +"</td><td>"+window.dataT[j].taxNumber+"</td><td>";
                taxMonthData+=round(parseFloat(window.dataT[j].taxNumber)/parseFloat(window.dataYear.payOutNumberSum),1)+"</td></tr>";

                
              }
                
                $("#taxChild").html(taxMonthData);
           }


           function callMonthNum(dataNum){
              for(var i=0;i<dataNum.length;i++){
                 eval("window.dataNum = dataNum;");
              }
              //findWageYear();
           }
           function countMonthNum(yearW){//该年已有工资信息记录的月份个数
              var payroll=new Object();
              DWREngine.setAsync(false);//设置成同步
              dwrTest.findPayrollMonth(yearW,callMonthNum);
              DWREngine.setAsync(true);//恢复异步
           }

           function round(v,e){//四舍五入函数，扩大了100倍 
               var t=1; 
               for(;e>0;t*=10,e--); 
               for(;e<0;t/=10,e ); 
               return Math.round(100*v*t)/t+"%"; 
            } 
      </script>   
   
</head>

<body onload="initTable()">
  <div  class="tabContainer" style="clear:both; margin:0 auto; text-align:center; height:550px; width:700px">
    <div style="position:absolute; margin-left:680px"><a href="#"><img src="paychex/reportForm/images/delete1.png"  border="0"/></a>
    </div>
    <div style=" position:absolute;margin-left:450px; margin-top:20px;"> <input type="button" value="文字详单"  /><input type="button" value="水晶报表" />
    </div>
    <h1 id="h1" style="text-align:center;font-size:18px"></h1>

    <div id="report">
       <table width="501" id="tb" style="border:1px solid #000000;" cellpadding="0" cellspacing="0"  bgcolor="#FFFFFF" align="center">
         <tr >
           <td width="172" height="40px" ></td>
           <td width="145" ><span style="font-size:14px; font-weight:bold;">数额（人民币）￥</span></td>
           <td width="171"><span style="font-size:14px; font-weight:bold;">所占年总工资百分比</span></td>
         </tr>
         <tr id="t5" onclick="showRow(this);" class="userlist">
           <td  align="left" height="30px"><a onclick="javascript:findBasicWage();" href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10" style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">基本工资</span></td>
           <td style="font-weight:bold" id="bsWageNumber"></td>
           <td style="font-weight:bold" id="bsWagePercent"></td>
         </tr>
         <p id="basicWageChild"></p>
         
         <tr id="t0" onclick="showRow(this);" class="userlist">
           <td   align="left" height="30px"><a onclick="javascript:findPrizeMonth()" href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10"     style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">奖金</span></td>
           <td style="font-weight:bold" id="prizeNumber"></td>
           <td style="font-weight:bold" id="prizePercent"></td>
         </tr>
         <p id="prizeChild"></p>
        
         <tr id="t1"  onclick="showRow(this)" class="userlist">
           <td align="left" height="30px"><a onclick="javascript:findSubsidyMonth();" href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10" style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">补贴</span></td>
           <td style="font-weight:bold" id="subsidyNumber"></td>
           <td style="font-weight:bold" id="subsidyPercent"></td>
         </tr>
         <p id="subsidyChild"></p>
        
         <tr id="t2" onclick="showRow(this)" class="userlist">
           <td   align="left" height="30px"><a onclick="javascript:findBonusMonth();" href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10" style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">分红</span></td>
           <td style="font-weight:bold" id="bonusNumber"></td>
           <td style="font-weight:bold" id="bonusPercent"></td>
         </tr>
         <p id="bonusChild"></p>
         
         <tr id="t3" onclick="showRow(this)" class="userlist">
           <td  align="left" height="30px"><a onclick="javascript:findInsuranceMonth();" href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10" style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">五险一金</span></td>
           <td style="font-weight:bold" id="insuranceNumber"></td>
           <td style="font-weight:bold" id="insurancePercent"></td>
         </tr>
         <p id="insuranceChild"></p>
         
         <tr id="t4"  onclick="showRow(this)" class="userlist">
           <td  align="left" height="30px"><a onclick="javascript:findTaxMonth();" href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10" style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">个人所得税</span></td>
           <td style="font-weight:bold" id="taxNumber"></td>
           <td style="font-weight:bold" id="taxNumberPercent"></td>
         </tr>
         <p id="taxChild"></p>
       </table>
    </div>
  </div>

</body>
</html>
