         var url,s,yearHg;
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
    
         window.onload = function(){
             url = window.location.href;
             s=url.indexOf("?"); 
             yearHg=url.substring(s+8);
             countMonthNum(yearHg);
             findYearC();
            findWageYearHg("my_chart","1000","500",yearHg);
         }
         function findYearC(){//查询年总商业保险
             DWREngine.setAsync(false);
             dwrTest.findYearCoo(yearHg,function(data){
                 eval("window.coo=data");
             });
             DWREngine.setAsync(true);
         }
         function findWageYearHg(id,hight,width,yearHg){
             dwrTest.findWageYear(yearHg,function(data){
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
             dwrTest.findPayrollMonth(yearHg,callBasicWage);
             
          }
          function findPrizeMonth(){
            
             dwrTest.findPrizeMonth(yearHg,callPrizeMonth);
             
          }
          function findSubsidyMonth(){
             
             dwrTest.findSubsidyMonth(yearHg,callSubsidyMonth);
             
          }
           function findBonusMonth(){

             dwrTest.findBonusMonth(yearHg,callBonusMonth);
             
          }
          function findInsuranceMonth(){
             countMonthNum(yearHg);
             var insurance=new Object();
             dwrTest.findInsurance(insurance,callInsuranceMonth);
             
          }
          function findDeductionMonth(){
              dwrTest.findDeductionMonth(yearHg,callDeductionMonth);
              
           }
          function findDeduction(month){
              var deduction=new Object();
              dwrTest.findDeduction(deduction,month,callDeduction);
              
           }
          function findCooinsurance(){
              
              dwrTest.findCooinsurance(yearHg,callCooinsurance);
              
           }
           function findTaxMonth(){

         	dwrTest.findPayrollMonth(yearHg,callTaxMonth);
             
          }
         
         
   //回调函数     
          function callWageYear(data){
            eval("window.data = data;");
  	        DrawWageYearPie();
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
          function countMonthNum(yearHg){//该年已有工资信息记录的月份个数
              var payroll=new Object();
              DWREngine.setAsync(false);
              dwrTest.findPayrollMonth(yearHg,callMonthNum);
              DWREngine.setAsync(true);
           }
          
          
          function DrawWageYearPie(id,hight,width){//年工资汇总
              var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", hight, width, "9", "#FFFFFF");
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
              
              so.addVariable("variables","true");
              so.addVariable("title",window.data.inPayYear+"年工资薪金,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",valueData);
              so.addVariable("x_labels",labelsData);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",window.data.basicWageSum);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
              so.addVariable("links", linksData);
              so.write(id);
           }
           
           function DrawBasicWagePie(){//查询某年各月的基础工资
              var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
              var dataPie="";
              var month="";
              for(var i=0;i<window.data.length;i++){
                   dataPie=dataPie+window.data[i].basicWage+",";
                   month=month+window.data[i].inPayDay.substring(0,7)+",";
              }
              dataPie=dataPie.substring(0,dataPie.length-1);
              month=month.substring(0,month.length-1);
             
              so.addVariable("variables","true");
              so.addVariable("title","各月的基础工资,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",dataPie);
              so.addVariable("x_labels",month);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",window.data[0].basicWage);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
              so.write("my_chart");         
           }
           function DrawPrizeMonthPie(){//查询某年的月奖金和
              var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
              var dataPie="";
              var month="";
              var linksData="";
              for(var i=0;i<window.data.length;i++){
                   dataPie=dataPie+window.data[i].monthPrize+",";
                   month=month+window.data[i].prizeInDay.substring(0,7)+",";
                   linksData+="javascript:findPrize('"+window.data[i].prizeInDay+"'),";
                 }
              dataPie=dataPie.substring(0,dataPie.length-1);
              month=month.substring(0,month.length-1);
              linksData=linksData.substring(0,linksData.length-1);

              var max=parseFloat(window.data[0].monthPrize);//查最大的月奖金和
              for(var i=0;i<window.data.length;i++){
                	   if(max<parseFloat(window.data[i].monthPrize)){
                	   max= parseFloat(window.data[i].monthPrize);
                	   }
              }
            
              so.addVariable("variables","true");
              so.addVariable("title","各月的奖金和,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",dataPie);
              so.addVariable("x_labels",month);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",max);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
              so.addVariable("links",linksData);
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

              var max=parseFloat(window.data[0].prizeNumber);//查最大的奖金
              for(var i=0;i<window.data.length;i++){
                	   if(max<parseFloat(window.data[i].prizeNumber)){
                	   max= parseFloat(window.data[i].prizeNumber);
                	   }
              }
                 
              so.addVariable("variables","true");
              so.addVariable("title","奖金,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",dataPie);
              so.addVariable("x_labels",prizeName);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",max);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
              so.write("my_chart");
              
           }
           function DrawSubsidyMonthPie(){//查询某年的月补贴和
              var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
              var dataPie="";
              var month="";
              var linksData="";
              for(var i=0;i<window.data.length;i++){
                   dataPie=dataPie+window.data[i].monthSubsidy+",";
                   month=month+window.data[i].subsidyInDay.substring(0,7)+",";
                   linksData+="javascript:findSubsidy('"+window.data[i].subsidyInDay+"'),";
                 }
              dataPie=dataPie.substring(0,dataPie.length-1);
              month=month.substring(0,month.length-1);
              linksData=linksData.substring(0,linksData.length-1);

              var max=parseFloat(window.data[0].monthSubsidy);//查最大的月补贴和
              for(var i=0;i<window.data.length;i++){
                	   if(max<parseFloat(window.data[i].monthSubsidy)){
                	   max= parseFloat(window.data[i].monthSubsidy);
                	 }
              }
              
              so.addVariable("variables","true");
              so.addVariable("title","各月的补贴和,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",dataPie);
              so.addVariable("x_labels",month);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",max);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
               so.addVariable("links",linksData);
              so.write("my_chart");      
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

              var max=parseFloat(window.data[0].subsidyNumber);//查最大的补贴
              for(var i=0;i<window.data.length;i++){
                	   if(max<parseFloat(window.data[i].subsidyNumber)){
                	   max= parseFloat(window.data[i].subsidyNumber);
                	   }
              }
                 
              so.addVariable("variables","true");
              so.addVariable("title","补贴,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",dataPie);
              so.addVariable("x_labels",subsidyName);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",max);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
              so.write("my_chart");
              
           }
           function DrawBonusMonthPie(){//查询某年的月分红和
              var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
              var dataPie="";
              var month="";
              var linksData="";
              for(var i=0;i<window.data.length;i++){
                   dataPie=dataPie+window.data[i].monthBonus+",";
                   month=month+window.data[i].bonusInDay.substring(0,7)+",";
                   linksData+="javascript:findBonus('"+window.data[i].bonusInDay+"'),";
                 }
              dataPie=dataPie.substring(0,dataPie.length-1);
              month=month.substring(0,month.length-1);
              linksData=linksData.substring(0,linksData.length-1);

              var max=parseFloat(window.data[0].monthBonus);//查最大的月分红和
              for(var i=0;i<window.data.length;i++){
                	   if(max<parseFloat(window.data[i].monthBonus)){
                	   max= parseFloat(window.data[i].monthBonus);
                  }
              }
              
              so.addVariable("variables","true");
              so.addVariable("title","各月的分红和,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",dataPie);
              so.addVariable("x_labels",month);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",max);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
               so.addVariable("links",linksData);
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

              var max=parseFloat(window.data[0].bonusNumber);//查最大的分红
              for(var i=0;i<window.data.length;i++){
                	   if(max<parseFloat(window.data[i].bonusNumber)){
                	   max= parseFloat(window.data[i].bonusNumber);
                	   }
              }
               
              so.addVariable("variables","true");
              so.addVariable("title","分红,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",dataPie);
              so.addVariable("x_labels",bonusName);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",max);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
              so.write("my_chart");
                
           }
           
           function DrawInsuranceMonthPie(){//查询某年各月的社保（养老，医疗，失业，公积金的和）
              var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
              var dataPie="";
              var month="";
              var linksData="";
              for(var i=0;i<window.dataNum.length;i++){
                   dataPie=dataPie+window.data.insSum+",";
                   month=month+window.dataNum[i].inPayDay.substring(0,7)+",";
                   linksData+="javascript:findInsurance(),";
                 }
              dataPie=dataPie.substring(0,dataPie.length-1);    
              month=month.substring(0,month.length-1);
              linksData=linksData.substring(0,linksData.length-1);
              so.addVariable("variables","true");
              so.addVariable("title","各月社保扣缴,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",dataPie);
              so.addVariable("x_labels",month);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",window.data.insSum);
              so.addVariable("links",linksData);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
              so.write("my_chart"); 
              
                 
           }
           function DrawInsurancePie(){//查询社保的详细信息
              var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
               
              so.addVariable("variables","true");
              so.addVariable("title","社保,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",""+window.data.pensionP+","+window.data.medicalP+","+window.data.unemploymentP+","+window.data.housingP);
              so.addVariable("x_labels","养老保险,医疗保险,失业保险,公积金");
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max","1000");
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
              so.write("my_chart");      
           }
           
           function DrawTaxMonthPie(){//查询某年的月纳税额
              var so = new SWFObject("paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", "1000", "500", "9", "#FFFFFF");
              var dataPie="";
              var month="";
              for(var i=0;i<window.data.length;i++){
                   dataPie=dataPie+window.data[i].taxNumber+",";
                   month=month+window.data[i].inPayDay.substring(0,7)+",";
              }
              dataPie=dataPie.substring(0,dataPie.length-1);
              month=month.substring(0,month.length-1);

              var max=parseFloat(window.data[0].taxNumber);//查最大的月纳税额
              for(var i=0;i<window.data.length;i++){
                	   if(max<parseFloat(window.data[i].taxNumber)){
                	   max= parseFloat(window.data[i].taxNumber);
                	   }
              }
              so.addVariable("variables","true");
              so.addVariable("title","各月纳税额,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",dataPie);
              so.addVariable("x_labels",month);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",max);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
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
                var max=parseFloat(window.data[0].monthDeduction);//查最大的月扣除项和
                for(var i=0;i<window.data.length;i++){
                  	   if(max<parseFloat(window.data[i].monthDeduction)){
                  	   max= parseFloat(window.data[i].monthDeduction);
                  	 }
                }
                
                so.addVariable("variables","true");
                so.addVariable("title","各月的扣除项和,{font-size: 20;}");
                so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
                so.addVariable("y_label_size","15");//不起啥作用
                so.addVariable("y_ticks","5,10,4");//控制
                so.addVariable("bar","50,0x9933CC,￥,10");
                so.addVariable("values",dataPie);
                so.addVariable("x_labels",month);
                so.addVariable("x_axis_steps","1");
                so.addVariable("y_max",max);
                so.addParam("allowScriptAccess", "always" );//"sameDomain");
                so.addParam("onmouseout", "onrollout2();" );
                 so.addVariable("links",linksData);
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
                
                var max=parseFloat(window.data[0].deductionNumber);//查最大的扣除项
                for(var i=0;i<window.data.length;i++){
                  	   if(max<parseFloat(window.data[i].deductionNumber)){
                  	   max= parseFloat(window.data[i].deductionNumber);
                  	   }
                }
                so.addVariable("variables","true");
                so.addVariable("title","扣除项,{font-size: 20;}");
                so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
                so.addVariable("y_label_size","15");//不起啥作用
                so.addVariable("y_ticks","5,10,4");//控制
                so.addVariable("bar","50,0x9933CC,￥,10");
                so.addVariable("values",dataPie);
                so.addVariable("x_labels",deductionName);
                so.addVariable("x_axis_steps","1");
                so.addVariable("y_max",max);
                so.addParam("allowScriptAccess", "always" );//"sameDomain");
                so.addParam("onmouseout", "onrollout2();" );
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
              
              var max=parseFloat(window.data[0].insuranceNumber);//查最大的月商业保险
              for(var i=0;i<window.data.length;i++){
                	   if(max<parseFloat(window.data[i].insuranceNumber)){
                	   max= parseFloat(window.data[i].insuranceNumber);
                	 }
              }
              dataPie=dataPie.substring(0,dataPie.length-1);
              month=month.substring(0,month.length-1);
              so.addVariable("variables","true");
              so.addVariable("title","各月的商业保险,{font-size: 20;}");
              so.addVariable("y_legendx","Open Flash Chart,12,0x736AFF");
              so.addVariable("y_label_size","15");//不起啥作用
              so.addVariable("y_ticks","5,10,4");//控制
              so.addVariable("bar","50,0x9933CC,￥,10");
              so.addVariable("values",dataPie);
              so.addVariable("x_labels",month);
              so.addVariable("x_axis_steps","1");
              so.addVariable("y_max",max);
              so.addParam("allowScriptAccess", "always" );//"sameDomain");
              so.addParam("onmouseout", "onrollout2();" );
               so.addVariable("links",linksData);
              so.write("my_chart");      
             }