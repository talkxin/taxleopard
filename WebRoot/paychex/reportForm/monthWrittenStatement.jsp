<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
   <title>月文字报表</title>
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
    <script type='text/javascript' src='dwr/interface/dwrTest.js'></script>
    <script type='text/javascript' src='dwr/engine.js'></script>
    <script type='text/javascript' src='dwr/util.js'></script>
    <script type='text/javascript' src='paychex/reportForm/js/jquery-1.4.2.min.js'></script>
    
    <script type='text/javascript' src='dwr/interface/paychexD.js'></script>
    <script type="text/javascript"> 
	 var uid;
     var time;
     var total;
     var kaiguanP,kaiguanS,kaiguanB,kaiguanI,kaiguanD;
       function hideRow(para,tid){ 
             var pa="tr[class='"+para+"']"   
             var trs = $(pa); 
             for(var i = 0; i < trs.length; i++){
                 trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
             }
             if(tid.id=="t0"){kaiguanP=false;}
             else if(tid.id=="t1"){kaiguanS=false;}
             else if(tid.id=="t2"){kaiguanB=false;}
             else if(tid.id=="t3"){kaiguanI=false;}
             else{kaiguanD=false;}
       }
       function initTable(){      
           var tableRows=tb.rows;    
           for(i=0;i<tableRows.length;i++){
           if(tableRows[i].id.length>2)
            tableRows[i].style.display="none";
           }
           findMonthC();
           findWageMonth1();
           kaiguanP=false;
           kaiguanS=false;
           kaiguanB=false;
           kaiguanI=false;
           kaiguanD=false;
       }
        
       function findMonthC(){//查询月商业保险
    	   DWREngine.setAsync(false);
           paychexD.getUser(function(data){
        	     uid=data['userId'];
        	     time=data['addTime'];
        	   
               dwrTest.findMonthCoo(uid,time,function(data){
                  eval("window.cooMonth=data;");
               });
               
           });
           DWREngine.setAsync(true);
       } 
      
       function toDataEntry(){
       	self.location.href="toDataEntry"
       }
       
       var countP=0;
       var countS=0;
       var countB=0;
       var countI=0;
       var countDe=0;
       function showRow(tid){ 
           if(tid.id=="t0")countP++;
           if(tid.id=="t1") countS++;
           if(tid.id=="t2") countB++; 
           if(tid.id=="t3") countI++; 
           if(tid.id=="t6") countDe++;
           var tableRows=tb.rows;
           for(j=0;j<tableRows.length;j++){
              var s=tableRows[j].id;
              if(s.indexOf(tid.id)!=-1 && s!=tid.id){
              //alert(s);
                 if(tableRows[j].style.display=="")              
                    tableRows[j].style.display="none";   
                 else   
                    tableRows[j].style.display="none"; 
               }
            }
       }

        var month;
        function findPrize(tid){
           month=window.dataMonth.payMonth;
           if(kaiguanP==false){ 
              var prizeJoin=new Object();
              dwrTest.findPrize(prizeJoin,month,callPrize);
              kaiguanP=true;
            }else{
                hideRow("p"+month,tid);}
        }
         function findSubsidy(tid){
        	 month=window.dataMonth.payMonth;
             if(kaiguanS==false){
                 var subsidyJoin=new Object();
                dwrTest.findSubsidy(subsidyJoin,month,callSubsidy);
                kaiguanS=true;
             }else{
                 hideRow("s"+month,tid);}
         }
         function findBonus(tid){
           month=window.dataMonth.payMonth;
           if(kaiguanB==false){
             var bonus=new Object();
             dwrTest.findBonus(bonus,month,callBonus);
             kaiguanB=true;
           }else{
               hideRow("b"+month,tid);}
         }
         function findInsurance(tid){
        	month=window.dataMonth.payMonth;
           if(kaiguanI==false){
             var insurance=new Object();
             dwrTest.findInsurance(insurance,callInsurance);
             kaiguanI=true;
           } else{
               hideRow("i"+month,tid);}
         }

         function findDeduction(tid){
        	 month=window.dataMonth.payMonth;
             if(kaiguanD==false){
               var deduction=new Object();
               dwrTest.findDeduction(deduction,month,callDeduction);
               kaiguanD=true;
             } else{
                 hideRow("d"+month,tid);}
           }
         function findWageMonth1(){
        	 DWREngine.setAsync(false);
              dwrTest.findWageMonth(uid,time,callBack);
              DWREngine.setAsync(true);
         }
         
         function callBack(data){
            eval("window.dataMonth = data;");
            if(window.dataMonth.basicWage==null){
                $("#t5").hide();
                data.basicWage=0;
            }
            if(window.dataMonth.monthPrize==null){//该月没奖金的话则隐藏
                $("#t0").hide();
                data.monthPrize=0;
            }
            if(window.dataMonth.monthSubsidy==null){
                $("#t1").hide();
                data.monthSubsidy=0;
            }
            if(window.dataMonth.monthBonus==null){
            	$("#t2").hide();
            	data.monthBonus=0;
            }
            if(window.dataMonth.insuranceSum==null){
                $("#t3").hide();
                data.insuranceSum=0;
            }
            if(window.dataMonth.monthDeduction==null){
                $("#t6").hide();
                data.monthDeduction=0;
            }
            if(window.cooMonth==null){
                $("#t7").hide();
                window.cooMonth=0;
            }
            if(window.dataMonth.retiredNumber==null){
                $("#t8").hide();
                data.retiredNumber=0; 
            }
            if(window.dataMonth.retirementNumber==null){
                $("#t9").hide();
                data.retirementNumber=0;
            }
            if(window.dataMonth.taxNumber==null){
                $("#t4").hide();
                data.taxNumber=0;
            }
            total=parseFloat(data.basicWage)+parseFloat(data.monthPrize)+parseFloat(data.monthSubsidy)+parseFloat(data.monthBonus)+parseFloat(data.insuranceSum)
            +parseFloat(data.monthDeduction)+parseFloat(window.cooMonth)+parseFloat(data.retiredNumber)+parseFloat(data.retirementNumber)+parseFloat(data.taxNumber);

            var bs=parseFloat(window.dataMonth.basicWage)/total;
  	        var bsWagePercent=round(bs,1);

  	        var pr=parseFloat(window.dataMonth.monthPrize)/total;
  	        var prizePercent=round(pr,1);

  	        var su=parseFloat(window.dataMonth.monthSubsidy)/total;
  	        var subsidyPercent=round(su,1);

  	        var bo=parseFloat(window.dataMonth.monthBonus)/total;
  	        var bonusPercent=round(bo,1);
  	        
  	        var ins=parseFloat(window.dataMonth.insuranceSum)/total;
  	        var insurancePercent=round(ins,1);

  	        var de=parseFloat(window.dataMonth.monthDeduction)/total;
	        var deductionPercent=round(de,1);

	        var coo=parseFloat(window.cooMonth)/total;
	        var cooInsurancePercent=round(coo,1);

	        var ret=parseFloat(window.dataMonth.retiredNumber)/total;
	        var retiredPercent=round(ret,1);

	        var retm=parseFloat(window.dataMonth.retirementNumber)/total;
	        var retirementPercent=round(retm,1);
  	        
  	        var ta=parseFloat(window.dataMonth.taxNumber)/total;
  	        var taxNumberPercent=round(ta,1);

  	        $("#h1").append(window.dataMonth.payMonth+"工资薪金详细");
  	        $("#bsWageNumber").append(window.dataMonth.basicWage);
  	        $("#bsWagePercent").append(bsWagePercent);
  	        $("#prizeNumber").append(window.dataMonth.monthPrize);
            $("#prizePercent").append(prizePercent);
            $("#subsidyNumber").append(window.dataMonth.monthSubsidy);
            $("#subsidyPercent").append(subsidyPercent);
            $("#bonusNumber").append(window.dataMonth.monthBonus);
            $("#bonusPercent").append(bonusPercent);
            $("#insuranceNumber").append(window.dataMonth.insuranceSum);
            $("#insurancePercent").append(insurancePercent);

            $("#deductionNumber").append(window.dataMonth.monthDeduction);
            $("#deductionPercent").append(deductionPercent);
            $("#cooInsuranceNumber").append(window.cooMonth);
            $("#cooInsurancePercent").append(cooInsurancePercent);
            $("#retiredNumber").append(window.dataMonth.retiredNumber);
            $("#retiredPercent").append(retiredPercent);
            $("#retirementNumber").append(window.dataMonth.retirementNumber);
            $("#retirementPercent").append(retirementPercent);
            
            $("#taxNumber").append(window.dataMonth.taxNumber);
            $("#taxNumberPercent").append(taxNumberPercent);

          }
          function callPrize(data){
            for(var i=0;i<data.length;i++){
                eval("window.data = data;");
            }
            
            var prizeData="";
            for(var j=0;j<window.data.length;j++){
              prizeData=prizeData+"<tr class=\"p"+window.dataMonth.payMonth+"\" id=\"t0-"+j+"\"><td>"
                        +window.data[j].prizeName                                       
                        +"</td><td>"+window.data[j].prizeNumber+"</td><td>";
                        
              prizeData+=round(parseFloat(window.data[j].prizeNumber)/total,1)+"</td></tr>";
              
            }
            
            $("#prizeChild").html(prizeData);
            
          }
          function callSubsidy(data){
            for(var i=0;i<data.length;i++){
                eval("window.data = data;");
            }
            var subsidyData="";
            for(var j=0;j<window.data.length;j++){
              subsidyData=subsidyData+"<tr class=\"s"+window.dataMonth.payMonth+"\" id=\"t1-"+j+"\"><td>"
                        +window.data[j].subsidyName                                       
                        +"</td><td>"+window.data[j].subsidyNumber+"</td><td>";
                        
              subsidyData+=round(parseFloat(window.data[j].subsidyNumber)/total,1)+"</td></tr>";
            }
            
              $("#subsidyChild").html(subsidyData);
          }
          function callBonus(data){
            for(var i=0;i<data.length;i++){
                eval("window.data = data;");
            }
            
            var bonusData="";
            for(var j=0;j<window.data.length;j++){
              bonusData=bonusData+"<tr class=\"b"+window.dataMonth.payMonth+"\" id=\"t2-"+j+"\"><td>bonus"+j                                     
                        +"</td><td>"+window.data[j].bonusNumber+"</td><td>";
                        
              bonusData+=round(parseFloat(window.data[j].bonusNumber)/total,1)+"</td></tr>";
            }
              
              $("#bonusChild").html(bonusData);
          }
          function callInsurance(data){
            
            eval("window.data = data;");
            
            var insuranceData="";
            insuranceData=insuranceData+"<tr class=\"i"+window.dataMonth.payMonth+"\" id=\"t3-0\"><td>养老保险"                                      
                        +"</td><td>"+window.data.pensionP+"</td><td>";
                        
            insuranceData+=round(parseFloat(window.data.pensionP)/total,1)+"</td></tr>"
                       
                        +"<tr class=\"i"+window.dataMonth.payMonth+"\" id=\"t3-1\"><td>医疗保险"                                  
                        +"</td><td>"+window.data.medicalP+"</td><td>";
            insuranceData+=round(parseFloat(window.data.medicalP)/total,1)+"</td></tr>"
                        +"<tr class=\"i"+window.dataMonth.payMonth+"\" id=\"t3-2\"><td>失业保险"                                      
                        +"</td><td>"+window.data.unemploymentP+"</td><td>";
            insuranceData+=round(parseFloat(window.data.unemploymentP)/total,1)+"</td></tr>"
                        +"<tr class=\"i"+window.dataMonth.payMonth+"\" id=\"t3-3\"><td>公积金"                                      
                        +"</td><td>"+window.data.housingP+"</td><td>";
            insuranceData+=round(parseFloat(window.data.housingP)/total,1)+"</td></tr>";
            
            
            $("#insuranceChild").html(insuranceData);
            
          }

          function callDeduction(data){
              for(var i=0;i<data.length;i++){
                  eval("window.data = data;");
              }
              
              var deductionData="";
              for(var j=0;j<window.data.length;j++){
            	  deductionData=deductionData+"<tr class=\"d"+window.dataMonth.payMonth+"\" id=\"t6-"+j+"\"><td>"+window.data[j].deductionName                                    
                          +"</td><td>"+window.data[j].deductionNumber+"</td><td>";
                          
                  deductionData+=round(parseFloat(window.data[j].deductionNumber)/total,1)+"</td></tr>";
              }
                
                $("#deductionChild").html(deductionData);
            }
          function round(v,e){//四舍五入函数，扩大了100倍 
             var t=1; 
             for(;e>0;t*=10,e--); 
             for(;e<0;t/=10,e ); 
             return Math.round(100*v*t)/t+"%"; 
          } 

          function toReportForm(){
              $("#reportForm").slideDown("slow");
              $("#monthWritten").slideUp("slow");
           }
      </script>   
   
</head>

<body onload="initTable()">
  <div  class="tabContainer" style="overflow:scroll; clear:both; margin:0 auto; text-align:center; height:550px; width:700px">
    
    <h1 id="h1" style="text-align:center;font-size:18px"></h1>
    <div id="report">
       <table width="501" id="tb" style="border:1px solid #000000;" cellpadding="0" cellspacing="0"  bgcolor="#FFFFFF" align="center">
         <tr >
           <td width="172" height="40px" ></td>
           <td width="145" ><span style="font-size:14px; font-weight:bold;">数额（人民币）￥</span></td>
           <td width="171"><span style="font-size:14px; font-weight:bold;">所占工资百分比</span></td>
         </tr>
         <tr id="t5" class="userlist">
           <td  align="left" height="30px"><a href="#"></a><span style="margin-left:20px;font-weight:bold">基础工资</span></td>
           <td id="bsWageNumber"></td>
           <td id="bsWagePercent"></td>
         </tr>
         <tr id="t0" onclick="findPrize(this)" class="userlist">
           <td  align="left" height="30px"><a  href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10"     style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">奖金</span></td>
           <td id="prizeNumber"></td>
           <td id="prizePercent"></td>
         </tr>
         <p id="prizeChild"></p>
        
         <tr id="t1"  onclick="findSubsidy(this)" class="userlist">
           <td align="left" height="30px"><a  href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10" style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">补贴</span></td>
           <td id="subsidyNumber"></td>
           <td id="subsidyPercent"></td>
         </tr>
         <p id="subsidyChild"></p>
        
         <tr id="t2" onclick="findBonus(this)" class="userlist">
           <td   align="left" height="30px"><a href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10" style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">分红</span></td>
           <td id="bonusNumber"></td>
           <td id="bonusPercent"></td>
         </tr>
         <p id="bonusChild"></p>
         
         <tr id="t3" onclick="findInsurance(this)" class="userlist">
           <td  align="left" height="30px"><a href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10" style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">五险一金</span></td>
           <td id="insuranceNumber"></td>
           <td id="insurancePercent"></td>
         </tr>
         <p id="insuranceChild"></p>
         
         <tr id="t6" onclick="findDeduction(this)" class="userlist">
           <td   align="left" height="30px"><a href="#"><img src="paychex/reportForm/images/Triangle.png" width="10" height="10" style="margin-right:10px; border:0;" /></a><span style="font-weight:bold">扣除项</span></td>
           <td id="deductionNumber"></td>
           <td id="deductionPercent"></td>
         </tr>
         <p id="deductionChild"></p>
         
         <tr id="t7"  onclick="" class="userlist">
           <td  align="left" height="30px"><a  href="#"></a><span style="margin-left:20px;font-weight:bold">商业保险</span></td>
           <td id="cooInsuranceNumber"></td>
           <td id="cooInsurancePercent"></td>
         </tr>
         
          <tr id="t8"  onclick="" class="userlist">
           <td  align="left" height="30px"><a  href="#"></a><span style="margin-left:20px;font-weight:bold">退职费</span></td>
           <td id="retiredNumber"></td>
           <td id="retiredPercent"></td>
         </tr>
         
         <tr id="t9"  onclick="" class="userlist">
           <td  align="left" height="30px"><a  href="#"></a><span style="margin-left:20px;font-weight:bold">退养费</span></td>
           <td id="retirementNumber"></td>
           <td id="retirementPercent"></td>
         </tr>

         <tr id="t4"  onclick="" class="userlist">
           <td  align="left" height="30px"><a  href="#"></a><span style="margin-left:20px;font-weight:bold">个人所得税</span></td>
           <td id="taxNumber"></td>
           <td id="taxNumberPercent"></td>
         </tr>
         
       </table>
    </div>
    <div style="float:left;margin-left:40%; margin-top:20px"> <input type="button"  value="返回数据录入模式" onclick="javascript:toDataEntry()"/>
    </div>
  </div>

</body>
</html>
