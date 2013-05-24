         var url,s,year;

         window.onload = function(){
             
             url = window.location.href;
             s=url.indexOf("?"); 
             year=url.substring(s+6);
             countMonthNum(year);
             findYearC();
             findWageYearPie("my_chart","1000","500",year);
         }
         function findYearC(){//查询年总商业保险
             DWREngine.setAsync(false);
             dwrTest.findYearCoo(year,function(data){
                 eval("window.coo=data");
             });
             DWREngine.setAsync(true);
         }
         function findWageYearPie(id,hight,width,year){
             dwrTest.findWageYear(year,function(data){
                 	eval("window.data=data;");
                     DrawWageYearPie(id,hight,width);
         		
              }); 
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
         function findBasicWage(){
            dwrTest.findPayrollMonth(year,callBasicWage);
            
         }
         function findPrizeMonth(){
           
            dwrTest.findPrizeMonth(year,callPrizeMonth);
            
         }
         function findSubsidyMonth(){
            
            dwrTest.findSubsidyMonth(year,callSubsidyMonth);
            
         }
          function findBonusMonth(){

            dwrTest.findBonusMonth(year,callBonusMonth);
            
         }
         function findInsuranceMonth(){
            countMonthNum(year);
            var insurance=new Object();
            dwrTest.findInsurance(insurance,callInsuranceMonth);
            
         }
         function findDeductionMonth(){
             dwrTest.findDeductionMonth(year,callDeductionMonth);
             
          }
         function findDeduction(month){
             var deduction=new Object();
             dwrTest.findDeduction(deduction,month,callDeduction);
             
          }
         function findCooinsurance(){
             
             dwrTest.findCooinsurance(year,callCooinsurance);
             
          }
          function findTaxMonth(){

        	dwrTest.findPayrollMonth(year,callTaxMonth);
            
         }
         
         
   //回调函数     
          function callWageYear(data){
            eval("window.data = data;");
  	        DrawWageYearPie(id,hight,width);
          }
          function callBasicWage(data){
             for(var i=0;i<data.length;i++){
                eval("window.data = data;");
             }
             DrawBasicWagePie();
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
          function callSubsidyMonth(data){
             for(var i=0;i<data.length;i++){
                eval("window.data = data;");
             }
              
             DrawSubsidyMonthPie();
          }
          function callSubsidy(data){
             for(var i=0;i<data.length;i++){
                eval("window.data = data;");
             }
             DrawSubsidyPie();
          }
          
          function callBonusMonth(data){
             for(var i=0;i<data.length;i++){
                eval("window.data = data;");
             }
              
             DrawBonusMonthPie();
          }
          function callBonus(data){
             for(var i=0;i<data.length;i++){
                eval("window.data = data;");
             }
             DrawBonusPie();
          }
          function callInsuranceMonth(data){
             eval("window.data = data;");
             DrawInsuranceMonthPie();
          }
          function callInsurance(data){
             eval("window.data = data;");
             DrawInsurancePie();
          }
          function callDeductionMonth(data){
               eval("window.data = data;");
              DrawDeductionMonthPie();
          }
          
          function callDeduction(data){
              eval("window.data = data;");
              DrawDeductionPie();
           }
          function callCooinsurance(data){
              
                 eval("window.data = data;");

              DrawCooinsurancePie();
           }
          function callTaxMonth(data){
             for(var i=0;i<data.length;i++){
                eval("window.data = data;");
             }
             
             DrawTaxMonthPie();
          }
          
          
          
          function callMonthNum(dataNum){
             for(var i=0;i<dataNum.length;i++){
                eval("window.dataNum = dataNum;");
             }
             //findWageYear();
          }
          function countMonthNum(year){//该年已有工资信息记录的月份个数
             var payroll=new Object();
             DWREngine.setAsync(false);
             dwrTest.findPayrollMonth(year,callMonthNum);
             DWREngine.setAsync(true);
          }
          
          
          
          
          function DrawWageYearPie(id,hight,width){//年工资汇总
              var valueData="";
              var linksData="";
              var labelsData="";
              if(window.data.basicWageSum!=null){ 
                valueData+=window.data.basicWageSum+",";
                linksData+="javascript:findBasicWage(),";
                labelsData+="基础工资,";
              } 
              if(window.data.prizeSum!=null){ 
                  valueData+=window.data.prizeSum+",";
                  linksData+="javascript:findPrizeMonth(),";
                  labelsData+="奖金,";
              } 
              if(window.data.subsidySum!=null){ 
                  valueData+=window.data.subsidySum+",";
                  linksData+="javascript:findSubsidyMonth(),";
                  labelsData+="补贴,";
              }
              if(window.data.bonusSum!=null){ 
                  valueData+=window.data.bonusSum+",";
                  linksData+="javascript:findBonusMonth(),";
                  labelsData+="分红,";
              } 
              var yearInsurance= parseFloat(window.data.insuranceSum)* parseFloat(window.dataNum.length);
              //年社保扣缴=每个月的社保扣缴*该年有工资薪金记录的月份数
              if(window.data.insuranceSum!=null){ 
                  valueData+=yearInsurance+",";
                  linksData+="javascript:findInsuranceMonth(),";
                  labelsData+="五险一金,";
              }   
              if(window.data.deductionSum!=null){ 
                  valueData+=window.data.deductionSum+",";
                  linksData+="javascript:findDeductionMonth(),";
                  labelsData+="扣除项,";
              }
              if(window.coo!=null){ 
                  valueData+=window.coo+",";
                  linksData+=",";
                  labelsData+="商业保险,";
              }
              if(window.data.retSum!=null){ 
                  valueData+=window.data.retSum+",";
                  linksData+=",";
                  labelsData+="退职费,";
              }
              if(window.data.retmSum!=null){ 
                  valueData+=window.data.retmSum+",";
                  linksData+=",";
                  labelsData+="退养费,";
              }
              if(window.data.taxNumberSum!=null){ 
                  valueData+=window.data.taxNumberSum+",";
                  linksData+="javascript:findTaxMonth(),";
                  labelsData+="个人所得税,";
              } 

              valueData=valueData.substring(0,valueData.length-1);
              linksData=linksData.substring(0,linksData.length-1);
              labelsData=labelsData.substring(0,labelsData.length-1);
              var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", hight, width, "9", "#FFFFFF");
               so.addVariable("variables","true");
               so.addVariable("title",window.data.inPayYear+"年工资薪金,{font-size: 20;}");
               so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
               so.addVariable("values",valueData);
               so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
               so.addVariable("links",linksData);
               so.addVariable("pie_labels", labelsData);
               so.addVariable("tool_tip", "工资薪金(年)<br>#x_label#<br>Value: #val#");
               so.addParam("allowScriptAccess", "always" );
               so.write(id);       
            }
            function DrawBasicWagePie(){//查询某年各月的基础工资
          	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
          	 var dataPie="";
               var month="";
               for(var i=0;i<window.data.length;i++){
                    dataPie=dataPie+window.data[i].basicWage+",";
                    month=month+window.data[i].payMonth+",";
               }
               dataPie=dataPie.substring(0,dataPie.length-1);
               month=month.substring(0,month.length-1);
              
               so.addVariable("variables","true");
               so.addVariable("title","各月基础工资,{font-size: 20;}");
               so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
               so.addVariable("values",dataPie);
               so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
               so.addVariable("pie_labels", month);
               so.addVariable("tool_tip", "基础工资<br>#x_label#<br>Value: #val#");
               so.addParam("allowScriptAccess", "always" );
               so.write("my_chart");       
            }
            function DrawPrizeMonthPie(){//查询某年的月奖金和
          	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
               var dataPie="";
               var month="";
               var linksData="";
               for(var i=0;i<window.data.length;i++){
                    dataPie=dataPie+window.data[i].monthPrize+",";
                    month=month+window.data[i].prMonth+",";
                    linksData+="javascript:findPrize('"+window.data[i].prMonth+"'),";
                  }
               dataPie=dataPie.substring(0,dataPie.length-1);
               month=month.substring(0,month.length-1);
               linksData=linksData.substring(0,linksData.length-1);
               so.addVariable("variables","true");
               so.addVariable("title","各月的奖金和,{font-size: 20;}");
               so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
               so.addVariable("values",dataPie);
               so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
               so.addVariable("links",linksData);
               so.addVariable("pie_labels", month);
               so.addVariable("tool_tip", "月奖金和<br>#x_label#<br>Value: #val#");
               so.addParam("allowScriptAccess", "always" );
               so.write("my_chart");       
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
               so.write("my_chart");       
            }
            
            function DrawSubsidyMonthPie(){//查询某年的月补贴和
          	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
          	 var dataPie="";
               var month="";
               var linksData="";
               for(var i=0;i<window.data.length;i++){
                    dataPie=dataPie+window.data[i].monthSubsidy+",";
                    month=month+window.data[i].suMonth+",";
                    linksData+="javascript:findSubsidy('"+window.data[i].suMonth+"'),";
                  }
               dataPie=dataPie.substring(0,dataPie.length-1);
               month=month.substring(0,month.length-1);
               linksData=linksData.substring(0,linksData.length-1);
               so.addVariable("variables","true");
               so.addVariable("title","各月的补贴和,{font-size: 20;}");
               so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
               so.addVariable("values",dataPie);
               so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
               so.addVariable("links",linksData);
               so.addVariable("pie_labels", month);
               so.addVariable("tool_tip", "月补贴和<br>#x_label#<br>Value: #val#");
               so.addParam("allowScriptAccess", "always" );
               so.write("my_chart");       
            }
            
            function DrawSubsidyPie(){//查询某年某月的各项补贴
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
               so.write("my_chart");       
            }
            
            function DrawBonusMonthPie(){//查询某年的月分红和
          	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
          	 var dataPie="";
               var month="";
               var linksData="";
               for(var i=0;i<window.data.length;i++){
                    dataPie=dataPie+window.data[i].monthBonus+",";
                    month=month+window.data[i].boMonth+",";
                    linksData+="javascript:findBonus('"+window.data[i].boMonth+"'),";
                  }
               dataPie=dataPie.substring(0,dataPie.length-1);
               month=month.substring(0,month.length-1);
               linksData=linksData.substring(0,linksData.length-1);
               so.addVariable("variables","true");
               so.addVariable("title","各月分红和,{font-size: 20;}");
               so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
               so.addVariable("values",dataPie);
               so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
               so.addVariable("links",linksData);
               so.addVariable("pie_labels", month);
               so.addVariable("tool_tip", "月分红和<br>#x_label#<br>Value: #val#");
               so.addParam("allowScriptAccess", "always" );
               so.write("my_chart");       
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
               so.write("my_chart");       
            }
            function DrawInsuranceMonthPie(){//查询某年各月的社保(养老，医疗，失业，公积金的和)
          	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
               var dataPie="";
               var month="";
               var linksData="";
               for(var i=0;i<window.dataNum.length;i++){
                    dataPie=dataPie+window.data.insSum+",";
                    month=month+window.dataNum[i].payMonth+",";
                    linksData+="javascript:findInsurance(),";
                  }
               dataPie=dataPie.substring(0,dataPie.length-1);    
               month=month.substring(0,month.length-1);
               linksData=linksData.substring(0,linksData.length-1);
               so.addVariable("variables","true");
               so.addVariable("title","各月社保扣缴,{font-size: 20;}");
               so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
               so.addVariable("values",dataPie);
               so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
               so.addVariable("links",linksData);
               so.addVariable("pie_labels", month);
               so.addVariable("tool_tip", "月社保<br>#x_label#<br>Value: #val#");
               so.addParam("allowScriptAccess", "always" );
               so.write("my_chart");       
            }
            function DrawInsurancePie(){//查询社保各项的详细信息
          	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
                
               so.addVariable("variables","true");
               so.addVariable("title","社保,{font-size: 20;}");
               so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
               so.addVariable("values",""+window.data.pensionP+","+window.data.medicalP+","+window.data.unemploymentP+","+window.data.housingP);
               so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
               so.addVariable("pie_labels", "养老保险,医疗保险,失业保险,公积金");
               so.addVariable("tool_tip", "社保<br>#x_label#<br>Value: #val#");
               so.addParam("allowScriptAccess", "always" );
               so.write("my_chart");       
            }
            function DrawTaxMonthPie(){//查询某年的月纳税额
               
          	  var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
          	  var dataPie="";
                var month="";
                for(var i=0;i<window.data.length;i++){
                     dataPie=dataPie+window.data[i].taxNumber+",";
                     month=month+window.data[i].payMonth+",";
                }
                dataPie=dataPie.substring(0,dataPie.length-1);
                month=month.substring(0,month.length-1);
                
                so.addVariable("variables","true");
                so.addVariable("title","各月纳税额,{font-size: 20;}");
                so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
                so.addVariable("values",dataPie);
                so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
                so.addVariable("pie_labels", month);
                so.addVariable("tool_tip", "月纳税额<br>#x_label#<br>Value: #val#");
                so.addParam("allowScriptAccess", "always" );
                so.write("my_chart");       
            }
            
            
            function DrawDeductionMonthPie(){//查询某年的月扣除项和
             	 var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
             	 var dataPie="";
                  var month="";
                  var linksData="";
                  for(var i=0;i<window.data.length;i++){
                       dataPie=dataPie+window.data[i].monthDeduction+",";
                       month=month+window.data[i].dedMonth+",";
                       linksData+="javascript:findDeduction('"+window.data[i].dedMonth+"'),";
                     }
                  dataPie=dataPie.substring(0,dataPie.length-1);
                  month=month.substring(0,month.length-1);
                  linksData=linksData.substring(0,linksData.length-1);
                  so.addVariable("variables","true");
                  so.addVariable("title","各月扣除项和,{font-size: 20;}");
                  so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
                  so.addVariable("values",dataPie);
                  so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
                  so.addVariable("links",linksData);
                  so.addVariable("pie_labels", month);
                  so.addVariable("tool_tip", "月扣除项和<br>#x_label#<br>Value: #val#");
                  so.addParam("allowScriptAccess", "always" );
                  so.write("my_chart");       
               }
            function DrawDeductionPie(){//查询某月的各项扣除项
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
                  so.addVariable("tool_tip", "月扣除项<br>#x_label#<br>Value: #val#");
                  so.addParam("allowScriptAccess", "always" );
                  so.write("my_chart");       
               }
            
            
            function DrawCooinsurancePie(){//查询某年的各月商业保险
            	var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
                var dataPie="";
                var month="";
                var linksData="";
                for(var i=0;i<window.data.length;i++){
                     dataPie=dataPie+window.data[i].insuranceNumber+",";
                     month=month+window.data[i].insuranceDate.substring(0,7)+",";
                     
                   }
                dataPie=dataPie.substring(0,dataPie.length-1);
                month=month.substring(0,month.length-1);
                so.addVariable("variables","true");
                so.addVariable("title","各月的商业保险,{font-size: 20;}");
                so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
                so.addVariable("values",dataPie);
                so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
                so.addVariable("links",linksData);
                so.addVariable("pie_labels", month);
                so.addVariable("tool_tip", "月商业保险<br>#x_label#<br>Value: #val#");
                so.addParam("allowScriptAccess", "always" );
                so.write("my_chart");            
            }
           