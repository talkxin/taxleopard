       var _houseRentalReportArray=new Array();
       var _houseRentalReport;
      //判断有没有该数据
       function onReturnHouseRentalReport(para1,para2){
         for ( var i = 0; i < _houseRentalReportArray.length; i++) {
       		if(_houseRentalReportArray[i].houseId==para1 && _houseRentalReportArray[i].lesseeId==para2){
       			_houseRentalReport=_houseRentalReportArray[i];
       			return false;
       		}
       		
       	}
           return true;
       }

        //某房产针对某个承租人的房租合同
        function onfindSingleLessee(uid,hid,rid){
           if(uid!=null && hid!=null && rid!=null){
             
            	houseReportD.findSingleLessee(uid,hid,rid, function(data){
            		 eval("window.wriSingleLessee= data;");
            		 onCallWriEveryLessee();
                });
              
             
              
            }else{j$("#wriLesseeReport").html("<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>没有该承租人信息</center>");}
          }
        function onCallWriEveryLessee(){
            
            var wriEveryLesseeData="<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">"
 	                 +"<tr ><td class=\"lie\" width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">承租人</span></td>"
 	                +"<td class=\"lie\" width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">房产名</span></td>"
 	                 +"<td class=\"lie\" width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">租期</span></td>"
                   +"<td class=\"lie\" width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">数额（人民币）￥</span></td>"
                   +"<td class=\"lie\" width=\"130\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额（人民币）￥</span></td>"
                   +"<td class=\"lie\" width=\"150\" ><span style=\"font-size:14px; font-weight:bold;\">月租金（人民币）￥</span></td>"
                   +"<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">操作</span></td></tr>"

                   for(var j=0;j<window.wriSingleLessee.length;j++){
                 	  
                  	 wriEveryLesseeData+="<tr onclick=\"\" style=\"background-color:#E7EFD3\" class=\"Le\" id=\"\">"
                                 +"<td class=\"lie\" ><span style=\"font-weight:bold\">"+window.wriSingleLessee[j].rentalName
                                 +"<td class=\"lie\" ><span style=\"font-weight:bold\">"+window.wriSingleLessee[j].houseName
                                 +"</td><td class=\"lie\" height=\"30px\">"+window.wriSingleLessee[j].rentalStartTime+"<br/>"+"至"+"<br/>"+window.wriSingleLessee[j].rentalEndTime                                    
                                 +"</td><td class=\"lie\">"+window.wriSingleLessee[j].rentalTaxEndNumber+"</td><td class=\"lie\">"
                                
                                 +window.wriSingleLessee[j].rentalTax+"</td><td class=\"lie\">"+window.wriSingleLessee[j].rentalNumber
                                 +"</td><td class=\"lie\"><input type=\"button\" value=\"修改\" onclick=\"onUpRentInfoOpen("+j+")\"/>" 
                                 +"<input type=\"button\" value=\"删除\" onclick=\"onDelOneRent("+j+");\"/></td></td></tr><p id=\"\"></p>";
                   }

             wriEveryLesseeData+="</table>"; 
            if(window.wriSingleLessee==null || window.wriSingleLessee=="")
          	  j$("#wriLesseeReport").html("<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>无该承租人信息</center>");
            else
             j$("#wriLesseeReport").html(wriEveryLesseeData);
        }
          
          
 //出租与转让合并js
          var kaiguan1;
          var _houseLesseeReportArray=new Array();
          var _houseLesseeReport;
         //判断有没有该数据
          function onReturnHouseLesseeReport(para){
            for ( var i = 0; i < _houseLesseeReportArray.length; i++) {
          		if(_houseLesseeReportArray[i].houseId==para){
          			_houseLesseeReport=_houseLesseeReportArray[i];
          			return false;
          		}
          		
          	}
              return true;
          }
          function hideRow1(para){ 
              var pa="tr[class='"+para+"']"   
              var trs = j$(pa); 
              for(var i = 0; i < trs.length; i++){
                   trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
              }
              kaiguan1=false;
           }
           //某房产针对所有承租人的房租和
           function onfindWriHouse(uid,hid){
               kaiguan1=false;
                   houseReportD.findHouse(uid,hid,function(data){
                   	eval("window.wriHouse= data;");
                       onCallWriHouse();
                   });
                
             }
          function onCallWriHouse(){
                 if(window.wriHouse.rentalNumSum!=null || window.wriHouse.transferEndNumber!=null){
                     var wriHouseData="<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">"
   	                    +"<tr ><td class=\"lie\" width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">房产名</span></td>"
   	                    +"<td class=\"lie\" width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">出租/转让</span></td>"
                        +"<td class=\"lie\" width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">数额（人民币）￥</span></td>"
                        +"<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额（人民币）￥</span></td></tr>";
       
                    if(window.wriHouse.rentalNumSum!=null){
                       	 wriHouseData+="<tr onclick=\"onfindWriLessee("+window.wriHouse.hid+")\" class=\"userlist\" id=\"\">"
                            +"<td class=\"lie\" height=\"30px\"><span style=\"font-weight:bold\">"+window.wriHouse.houseName
                       	    +"</td><td class=\"lie\" align=\"left\"><a"
                            
                            +" href=\"#\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\" style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"
                            +"出租"                                      
                            +"</td><td class=\"lie\">"+window.wriHouse.rentalNumSum+"</td><td class=\"lie\">"
                           
                            +window.wriHouse.rentalTaxSum+"</td></tr><p id=\"lessee\"></p>";

                        }
                        
                    if(window.wriHouse.transferEndNumber!=null){
                   	wriHouseData+="<tr onclick=\"\" class=\"userlist\" id=\"\">"
                   		       +"<td class=\"lie\" height=\"30px\"><span style=\"font-weight:bold\">"+window.wriHouse.houseName
                               +"</td><td class=\"lie\"  height=\"30px\">"
                               +"转让   ("+window.wriHouse.transferTime                                      
                               +")</td><td class=\"lie\">"+window.wriHouse.transferEndNumber+"</td><td class=\"lie\">"
                              
                               +window.wriHouse.transferTax+"</td></tr><p id=\"\"></p>";
                    }
                     wriHouseData+="</table>"; 
                 }
                 if(window.wriHouse.rentalNumSum==null && window.wriHouse.transferEndNumber==null)
               	  j$("#report").html("<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>该房产没有租赁或转让信息</center>");
                 else
                  j$("#report").html(wriHouseData);
             }

             //某房产针对各个承租人房租和
             function onfindWriLessee(hid){
                if(kaiguan1==false){ 
                  if(onReturnHouseLesseeReport(hid)) { 
                   houseReportD.findLessee(window.sessionUID,hid,function(data){
                	   _houseLesseeReportArray.unshift({houseId:hid,value:data});
                	   _houseLesseeReport={houseId:hid,value:data};
                   });
                  } 
           	    eval("window.wriLessee= _houseLesseeReport.value;");
           	    onCallWriLessee()
           	    kaiguan1=true;
                }
                else{hideRow1("Le")}
             }
             function onCallWriLessee(){
           	  var houseLesseeData="";
                 for(var j=0;j<window.wriLessee.length;j++){
             	        houseLesseeData+="<tr onclick=\"\" style=\"background-color:#E7EFD3\" class=\"Le\" id=\"\">"
                             +"<td class=\"lie\"></td><td class=\"lie\" height=\"30px\"><span style=\"font-weight:bold\">"
                             
                             +window.wriLessee[j].rentalName                                     
                             +"</td><td class=\"lie\">"+window.wriLessee[j].rentalNumSum+"</td><td class=\"lie\">"
                            
                             +window.wriLessee[j].rentalTaxSum+"</td></tr><p id=\"\"></p>";
                
               }
              
                j$("#lessee").html(houseLesseeData);
              }
             
             
//全局js
       //文字报表      
             var kaiguanOver,kaiguanOver1,house,lessee;
             var _houseRenTraOverArray=new Array();
             var _houseRenTraOver;
             var _houseLesseeOverArray=new Array();
             var _houseLesseeOver;

             //判断房产展开有没有该数据
             function onReturnHouseRenTraOverall(para){
               for ( var i = 0; i < _houseRenTraOverArray.length; i++) {
             		if(_houseRenTraOverArray[i].houseId1==para){
             			_houseRenTraOver=_houseRenTraOverArray[i];
             			return false;
             		}
             		
             	}
                 return true;
             }
             
            //判断展开承租人有没有该数据
             function onReturnHouseLesseeOverall(para){
               for ( var i = 0; i < _houseLesseeOverArray.length; i++) {
             		if(_houseLesseeOverArray[i].houseId==para){
             			_houseLesseeOver=_houseLesseeOverArray[i];
             			return false;
             		}
             		
             	}
                 return true;
             }


             //关闭某个房产下的出租或转让
            function onHideRowOver(para){ 
                 var pa="tr[class='H"+para+"']" 
                 var trs = j$(pa); 
                 for(var i = 0; i < trs.length; i++){
                      trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
                 }
                 kaiguanOver=false;
                 if(kaiguanOver1==true){
                   //kaiguanOver1=false;
                	 onHideRowOver1(para); 
                 }
              }
            //关闭承租人
             function onHideRowOver1(para){ 
                 var pa="tr[class='Le"+para+"']"   
                 var trs = j$(pa); 
                 for(var i = 0; i < trs.length; i++){
                      trs[i].style.display = "none"; 
                 }
                 kaiguanOver1=false;
              }

             //某用户各个房产的租赁和，有转让加上转让
              function onfindOverallWriEveryHouse(uid){
                 kaiguanOver=false;
                 kaiguanOver1=false;
                 houseReportD.findEveryHouse(uid,function(data) {
   			      eval("window.wriEveryHouse = data;");
   			      onCallOverallWriEveryHouse();
   		       });
   		       
              }
              function onCallOverallWriEveryHouse(){
           	   var wriEveryHouseData="<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">"
    	                 +"<tr ><td class=\"lie\" width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">房产</span></td>"
                         +"<td class=\"lie\" width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">数额（人民币）￥</span></td>"
                         +"<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额（人民币）￥</span></td></tr>"

                   for(var i=0;i<window.wriEveryHouse.length;i++){
                   	if(window.wriEveryHouse[i].rentalNumSum!=0 || window.wriEveryHouse[i].bieTransferNum!=0){
                   		wriEveryHouseData+="<tr onclick=\"onfindOverallWriHouse("+window.wriEveryHouse[i].hid+")\" class=\"userlist\" id=\"\">"
                           +"<td class=\"lie\" align=\"left\" height=\"30px\"><a"
                           
                           +" href=\"#\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\" style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"
                           +window.wriEveryHouse[i].houseName                                   
                           +"</td><td class=\"lie\">"+(parseFloat(window.wriEveryHouse[i].rentalNumSum)+parseFloat(window.wriEveryHouse[i].bieTransferNum))+"</td><td class=\"lie\">"
                          
                           +(parseFloat(window.wriEveryHouse[i].rentalTaxSum)+parseFloat(window.wriEveryHouse[i].bieTransferTax))+"</td></tr><p id=\"house"+window.wriEveryHouse[i].hid+"\"></p>";
                       }
                   }
           	   wriEveryHouseData+="</table>";
                  if(window.wriEveryHouse==null || window.wriEveryHouse=="")
                   	  j$("#JKDiv_0").html("您没有房产出租或转让信息");
                     else
                      j$("#JKDiv_0").html(wriEveryHouseData);
              }

              
              //某房产针对所有承租人的房租和
              function onfindOverallWriHouse(hid){
                   if(kaiguanOver==false){
                     house="#house"+hid;
                     if(onReturnHouseRenTraOverall(hid)){
                         houseReportD.findHouse(window.sessionUID,hid,function(data){
                       	  _houseRenTraOverArray.unshift({houseId1:hid,value:data});
                      	      _houseRenTraOver={houseId1:hid,value:data};
                      });
                     }
                      eval("window.wriHouse= _houseRenTraOver.value;");
                      onCallOverallWriHouse();
                      kaiguanOver=true;
                  }else onHideRowOver(hid);
             }
             function onCallOverallWriHouse(){
                    
                    var wriHouseData="";

                           if(window.wriHouse.rentalNumSum!=null){
                          	 wriHouseData+="<tr onclick=\"onfindOverallWriLessee("+window.wriHouse.hid+")\" style=\"background-color:#E7EFD3\" class=\"H"+window.wriHouse.hid+"\" id=\"\">"
                               +"<td class=\"lie\" height=\"30px\"><a"
                               
                               +" href=\"#\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\" style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"
                               +"出租"                                      
                               +"</td><td class=\"lie\">"+window.wriHouse.rentalNumSum+"</td><td class=\"lie\">"
                              
                               +window.wriHouse.rentalTaxSum+"</td></tr><p id=\"lessee"+window.wriHouse.hid+"\"></p>";

                           }
                           
                       if(window.wriHouse.transferEndNumber!=null){
                      	wriHouseData+="<tr onclick=\"\" style=\"background-color:#E7EFD3\" class=\"H"+window.wriHouse.hid+"\" id=\"\">"
                                  +"<td class=\"lie\"  height=\"30px\"><span style=\"font-weight:bold\">"
                                  +"转让   ("+window.wriHouse.transferTime                                      
                                  +")</td><td class=\"lie\">"+window.wriHouse.transferEndNumber+"</td><td class=\"lie\">"
                                 
                                  +window.wriHouse.transferTax+"</td></tr><p id=\"\"></p>" 

                       }
                    if(window.wriHouse==null || window.wriHouse=="")
                  	  j$(house).html("无房产出租或转让信息");
                    else
                     j$(house).html(wriHouseData);
                }

                //某房产针对各个承租人房租和
                function onfindOverallWriLessee(hid){
                   if(kaiguanOver1==false){ 
                      lessee="#lessee"+hid;
                     if(onReturnHouseLesseeOverall(hid)) { 
                       houseReportD.findLessee(window.sessionUID,hid,function(data){
                   	   _houseLesseeOverArray.unshift({houseId:hid,value:data});
                   	   _houseLesseeOver={houseId:hid,value:data};
                      });
                     } 
              	    eval("window.wriLessee= _houseLesseeOver.value;");
              	    onCallOverallWriLessee();
              	    kaiguanOver1=true;
                   }
                   else{onHideRowOver1(hid)}
                }
                function onCallOverallWriLessee(){
              	  var houseLesseeData="";
                    for(var j=0;j<window.wriLessee.length;j++){
                	    
                	        houseLesseeData+="<tr onclick=\"\" class=\"Le"+window.wriLessee[j].hid+"\" id=\"\">"
                                +"<td class=\"lie\" height=\"30px\"><span style=\"font-weight:bold\">"
                                
                                +window.wriLessee[j].rentalName                                     
                                +"</td><td class=\"lie\">"+window.wriLessee[j].rentalNumSum+"</td><td class=\"lie\">"
                               
                                +window.wriLessee[j].rentalTaxSum+"</td></tr><p id=\"\"></p>";
                   
                  }
                 
                   j$(lessee).html(houseLesseeData);
                 }


    //柱状
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
              function onDrawHg(width,height,title,valueData,linksData,xLabels,max,id){
               	      var so = new SWFObject("/TaxPersonalReporting1.0/paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", width, height, "9", "#FFFFFF");
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
                   var width,height,title,id;
                   var valueData="";
                   var linksData="";
                   var xLabels="";
                   var max=parseFloat(window.everyHouseHg[0].rentalNumSum)+parseFloat(window.everyHouseHg[0].bieTransferNum);
                   if(window.everyHouseHg==null || window.everyHouseHg==""){
                        art.dialog({content:"game over"});
                   }

                   else{
                  	 width="550"; height="300";
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
                       id="JKDiv_1";
                       onDrawHg(width,height,title,valueData,linksData,xLabels,max,id);
                   }
               }
          	//查询某房产所有承租人某年的房租和 
          	 function onFindSingleHouseHg(hid){
                      houseReportD.findHouse(window.sessionUID,hid,function(data){ //记得传参数
                      	eval("window.singleHouseHg = data;");
                      	onDrawSingleHouseHg();
                      });
               }
               function onDrawSingleHouseHg(){
              	 var width,height,title,id;
                   var valueData="";
                   var linksData="";
                   var xLabels="";
                   var max="";
                   if(window.singleHouseHg==null || window.singleHouseHg=="")
                 	    alert("该年没有此房产出租或转让信息");
                   else{
                  	 width="550"; height="300";
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
                   id="JKDiv_1";
                   onDrawHg(width,height,title,valueData,linksData,xLabels,max,id);
               }
           	//查询某房产各个承租人某年的房租和 
          	 function onFindEveryLesseeHg(hid){
                      houseReportD.findLessee(window.sessionUID,hid,function(data){//记得传参
                      	eval("window.everyLesseeHg = data;");
                      	onDrawEveryLesseeHg();
                      });
               }
               function onDrawEveryLesseeHg(){
              	 var width,height,title,id;
                   var valueData="";
                   var linksData="";
                   var xLabels="";
                   var max=parseFloat(window.everyLesseeHg[0].rentalNumSum);
                   if(window.everyLesseeHg==null || window.everyLesseeHg==""){
                       art.dialog({content:"game over"});
                  }

                  else{
                      width="550"; height="300";
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
                      id="JKDiv_1";
                      onDrawHg(width,height,title,valueData,linksData,xLabels,max,id);
                  }
               }


    //饼状图
          //画饼状图
          	function onDrawPie(width, height, title, valueData, linksData, labelsData,tooltip, id) {
          		 var so = new SWFObject("/TaxPersonalReporting1.0/paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", width, height, "9", "#FFFFFF");
                   so.addVariable("variables","true");
                  // so.addVariable("bg_colour","#E0E3E2");//设置背景色
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
          	function onFindEveryHousePie(uid) {
          		houseReportD.findEveryHouse(uid,function(data) {
          			eval("window.everyHousePie = data;");
          			onDrawEveryHousePie();
          		});
          	}

          	function onDrawEveryHousePie() {
          		var width,height,title,tooltip,id;
                   var valueData="";
                   var linksData="";
                   var labelsData="";
                   if(window.everyHousePie==null || window.everyHousePie==""){
                        art.dialog({content:"game over"});
                   }

                   else{
                       width="550"; height="300";
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
                       title="房产管理"+"\r";
                       tooltip="所有房产";
                       id="JKDiv_2";
                       onDrawPie(width,height,title,valueData,linksData,labelsData,tooltip,id);
                   }
               }
              
          	//查询某房产针对所有承租人的房租和  有转让的展开转让
          	 
          	 function onFindSingleHousePie(hid){
                      houseReportD.findHouse(window.sessionUID,hid,function(data){   //记得传参数
                      	eval("window.singleHousePie = data;");
                      	onDrawSingleHousePie();
                      });
               }
               function onDrawSingleHousePie(){
           		var width,height,title,tooltip,id;
                  var valueData="";
                  var linksData="";
                  var labelsData="";
                   if(window.singleHousePie==null || window.singleHousePie=="")
                 	    alert("没有此房产出租或转让信息");
                   else{
                  	 width="550"; height="300";
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
                   id="JKDiv_2";
                   onDrawPie(width,height,title,valueData,linksData,labelsData,tooltip,id);
               }
           	//查询某房产各个承租人某年的房租和 
          	 function onfindEveryLesseePie(hid){
                      houseReportD.findLessee(window.sessionUID,hid,function(data){  //记得传参数
                      	eval("window.everyLesseePie = data;");
                      	onDrawEveryLesseePie();
                      });
               }
               function onDrawEveryLesseePie(){
              	 var width,height,title,tooltip,id;
                   var valueData="";
                   var linksData="";
                   var labelsData="";
                   if(window.everyLesseePie==null || window.everyLesseePie==""){
                	   art.dialog({content:"game over"});
                  }

                  else{
                      width="550"; height="300";
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
                      id="JKDiv_2";
                      onDrawPie(width,height,title,valueData,linksData,labelsData,tooltip,id);
                  }
               }

               //切换层
               function ChangeDiv(divId, divName, zDivCount) {
                   for (i = 0; i <= zDivCount; i++) {
                       document.getElementById(divName + i).style.display = "none";
                   }
                   document.getElementById(divName + divId).style.display = "block";
              }