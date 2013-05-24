         
         var uid;
         var time;
         window.onload = function(){
        	 findMonthC();
             findWageMonthPie("month_chart","1000","500");
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
         function findPrize(month){
            var prizeJoin=new Object();
            dwrTest.findPrize(prizeJoin,month,callPrize);
            
         }
         function findSubsidy(month){
            var subsidyJoin=new Object();
            dwrTest.findSubsidy(subsidyJoin,month,callSubsidy);
            
         }
         function findBonus(month){
            var bonus=new Object();
            dwrTest.findBonus(bonus,month,callBonus);
            
         }
         function findInsurance(){
             var insurance=new Object();
             dwrTest.findInsurance(insurance,callInsurance);
             
          }
         function findDeduction(month){
               var deduction=new Object();
               dwrTest.findDeduction(deduction,month,callDeduction);
             
         }
         
         function findWageMonthPie(id,hight,width){
 
               dwrTest.findWageMonth(uid,time,function(data){
               	eval("window.data = data;");
                   DrawWageMonthPie(id,hight,width);
               });


         }
         
         
          function callPrizeMonth(data){
             for(var i=0;i<data.length;i++){
                eval("window.data = data;");
             }
              
             DrawPrizeMonthPie();
          }
          function callPrize(data){
             for(var i=0;i<data.length;i++){
                eval("window.data = data;");
             }
              
             DrawPrizePie();
          }
          
          function callSubsidy(data){
             for(var i=0;i<data.length;i++){
                eval("window.data = data;");
             }
             DrawSubsidyPie();
          }
          
         
          function callBonus(data){
             for(var i=0;i<data.length;i++){
                eval("window.data = data;");
             }
             DrawBonusPie();
          }
          function callInsurance(data){
             eval("window.data = data;");
             DrawInsurancePie();
          }
          function callDeduction(data){
              for(var i=0;i<data.length;i++){
                 eval("window.data = data;");
              }
              DrawDeductionPie();
          }
          
          function callWageMonth(data){
            eval("window.data = data;");
           
  	        DrawWageMonthPie();
          }
          
          
          
          function DrawWageMonthPie(id,hight,width){//月工资汇总
         	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", hight, width, "9", "#OOFFOO");
              var valueData="";
              var linksData="";
              var labelsData="";
              if(window.data.basicWage!=null){ 
                valueData+=window.data.basicWage+",";
                linksData+=",";
                labelsData+="基础工资,";
              } 
              if(window.data.monthPrize!=null){ 
                  valueData+=window.data.monthPrize+",";
                  linksData+="javascript:findPrize('"+window.data.payMonth+"'),";
                  labelsData+="奖金,";
              } 
              if(window.data.monthSubsidy!=null){ 
                  valueData+=window.data.monthSubsidy+",";
                  linksData+="javascript:findSubsidy('"+window.data.payMonth+"'),";
                  labelsData+="补贴,";
              }
              if(window.data.monthBonus!=null){ 
                  valueData+=window.data.monthBonus+",";
                  linksData+="javascript:findBonus('"+window.data.payMonth+"'),";
                  labelsData+="分红,";
              } 
              if(window.data.insuranceSum!=null){ 
                  valueData+=window.data.insuranceSum+",";
                  linksData+="javascript:findInsurance(),";
                  labelsData+="五险一金,";
              }  
              
              if(window.data.monthDeduction!=null){ 
                  valueData+=window.data.monthDeduction+",";
                  linksData+="javascript:findDeduction('"+window.data.payMonth+"'),";
                  labelsData+="扣除项,";
              } 
              
              if(window.cooMonth!=null){ 
                  valueData+=window.cooMonth+",";
                  linksData+=",";
                  labelsData+="商业保险,";
              } 
              if(window.data.retiredNumber!=null){ 
                  valueData+=window.data.retiredNumber+",";
                  linksData+=",";
                  labelsData+="退职费,";
              } 
              if(window.data.retirementNumber!=null){ 
                  valueData+=window.data.retirementNumber+",";
                  linksData+=",";
                  labelsData+="退养费,";
              } 
              if(window.data.taxNumber!=null || window.data.taxNumber==0.00){ 
                  valueData+=window.data.taxNumber+",";
                  linksData+=",";
                  labelsData+="个人所得税,";
              } 
              valueData=valueData.substring(0,valueData.length-1);
              linksData=linksData.substring(0,linksData.length-1);
              labelsData=labelsData.substring(0,labelsData.length-1);
              
              so.addVariable("variables","true");
              so.addVariable("title",window.data.payMonth+"工资薪金,{font-size: 20;}");
              so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
              so.addVariable("values",valueData);
              so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
              so.addVariable("links",linksData);
              so.addVariable("pie_labels", labelsData);
              so.addVariable("tool_tip", "工资薪金(月)<br>#x_label#<br>Value: #val#");
              so.addParam("allowScriptAccess", "always" );
              so.write(id);       
           }
           function DrawPrizePie(){//查询某月的各项奖金
         	  var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
              var dataPie="";
              for(var i=0;i<window.data.length;i++){
                   dataPie=dataPie+window.data[i].prizeNumber+",";
                 }
              dataPie=dataPie.substring(0,dataPie.length-1);
              
              var prizeName="";
              for(var i=0;i<window.data.length;i++){
                   prizeName=prizeName+window.data[i].prizeName+",";
                 }
              prizeName=prizeName.substring(0,prizeName.length-1);     
              
              so.addVariable("variables","true");
              so.addVariable("title","奖金,{font-size: 20;}");
              so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
              so.addVariable("values",dataPie);
              so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
              so.addVariable("pie_labels", prizeName);
              so.addVariable("tool_tip", "月奖金<br>#x_label#<br>Value: #val#");
              so.addParam("allowScriptAccess", "always" );
              so.write("month_chart");       
           }
           function DrawSubsidyPie(){//查询某月的各项补贴
         	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
              var dataPie="";
              for(var i=0;i<window.data.length;i++){
                   dataPie=dataPie+window.data[i].subsidyNumber+",";
                 }
              dataPie=dataPie.substring(0,dataPie.length-1);
              
              var subsidyName="";
              for(var i=0;i<window.data.length;i++){
                   subsidyName=subsidyName+window.data[i].subsidyName+",";
                 }
              subsidyName=subsidyName.substring(0,subsidyName.length-1);     
              
              so.addVariable("variables","true");
              so.addVariable("title","补贴,{font-size: 20;}");
              so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
              so.addVariable("values",dataPie);
              so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
              so.addVariable("pie_labels", subsidyName);
              so.addVariable("tool_tip", "月补贴<br>#x_label#<br>Value: #val#");
              so.addParam("allowScriptAccess", "always" );
              so.write("month_chart");       
           }
           function DrawBonusPie(){//查询某月的各项分红
         	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
              var dataPie="";
              for(var i=0;i<window.data.length;i++){
                   dataPie=dataPie+window.data[i].bonusNumber+",";
                 }
              dataPie=dataPie.substring(0,dataPie.length-1);
              
              var bonusName="";
              for(var i=1;i<=window.data.length;i++){
                   bonusName=bonusName+"bonus"+i+",";
                 }
              bonusName=bonusName.substring(0,bonusName.length-1);     
              
              so.addVariable("variables","true");
              so.addVariable("title","分红,{font-size: 20;}");
              so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
              so.addVariable("values",dataPie);
              so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
              so.addVariable("pie_labels", bonusName);
              so.addVariable("tool_tip", "月分红<br>#x_label#<br>Value: #val#");
              so.addParam("allowScriptAccess", "always" );
              so.write("month_chart");       
           }
           function DrawInsurancePie(){//查询社保的详细信息
         	  var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000","500","9", "#FFFFFF");
               
              so.addVariable("variables","true");
              so.addVariable("title","社保,{font-size: 20;}");
              so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
              so.addVariable("values",""+window.data.pensionP+","+window.data.medicalP+","+window.data.unemploymentP+","+window.data.housingP);
              so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
              so.addVariable("pie_labels", "养老保险,医疗保险,失业保险,公积金");
              so.addVariable("tool_tip", "社保<br>#x_label#<br>Value: #val#");
              so.addParam("allowScriptAccess", "always" );
              so.write("month_chart");       
           }
           function DrawDeductionPie(){//查询某月的各扣除项
           	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
                var dataPie="";
                for(var i=0;i<window.data.length;i++){
                     dataPie=dataPie+window.data[i].deductionNumber+",";
                   }
                dataPie=dataPie.substring(0,dataPie.length-1);
                
                var deductionName="";
                for(var i=0;i<window.data.length;i++){
                	deductionName=deductionName+window.data[i].deductionName+",";
                  }
                deductionName=deductionName.substring(0,deductionName.length-1);      
                
                so.addVariable("variables","true");
                so.addVariable("title","扣除项,{font-size: 20;}");
                so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
                so.addVariable("values",dataPie);
                so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
                so.addVariable("pie_labels", deductionName);
                so.addVariable("tool_tip", "扣除项<br>#x_label#<br>Value: #val#");
                so.addParam("allowScriptAccess", "always" );
                so.write("month_chart");       
            }