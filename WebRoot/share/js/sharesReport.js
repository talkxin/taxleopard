 
function onfindShareMessage(uid,sid){
	//alert(sid);
	DWREngine.setAsync(false);
	onfindFirst(uid,sid);
	onfindIn(uid,sid);
	onfindOut(uid,sid);
	findResults();
}

//查询用户某股票或者股权的首次添加信息
 function onfindFirst(uid,sid){
	 sharesReportD.findFirstDwr(uid,sid,function(data){
        	eval("window.wriFirstShare=data;");
            onCallWriFirstShare();
     });          	 
 }
 function onCallWriFirstShare(){
      var _firstShareData="<tr onclick=\"\" style=\"background-color:#E9967A\" class=\"Le\" id=\"\">"
                 +"<td class=\"lie\" height=\"30px\"><span style=\"font-weight:bold\">"
                 
                 +window.wriFirstShare.sharesInTime                                     
                 +"</td><td class=\"lie\"> 首次购买</td><td class=\"lie\">"
                 +window.wriFirstShare.sharesNumber
                 +"</td><td class=\"lie\">"+window.wriFirstShare.sharesInDayNumber
                 +"</td><td class=\"lie\">"+parseFloat(window.wriFirstShare.sharesInDayNumber)*parseFloat(window.wriFirstShare.sharesNumber)
                 +"</td><td class=\"lie\">0"
                 +"</td><td class=\"lie\">"+window.wriFirstShare.taxedNumber+"</td></tr>";
      
      j$("#sharesFirst").html(_firstShareData);
 }
 //查询用户某股票或股权的追加信息
 function onfindIn(uid,sid){
	 sharesReportD.findInDwr(uid,sid,function(data){
        	eval("window.wriInShare=data;");
            onCallWriInShare();
     });  
	
 }

  var _sharesInPriceSum=0;//记录某股票或股权总的追加的价格
  var _sharesInNumSum=0;//记录某股票或股权总的追加的股数
  var _inOtherCostSum=0;//记录某股票或股权追加的其他费用的和
  
 function onCallWriInShare(){
	   	
 	_sharesInPriceSum=0;//再次清零一下，否则多次点击报表数据会出错累加
 	_sharesInNumSum=0;
 	_inOtherCostSum=0;
    if(window.wriInShare!="" && window.wriInShare.length!=0 && window.wriInShare!=null){
    	var _inShareData="";//存储追加某股票或股权的信息
 
	  for(var j=0;j<window.wriInShare.length;j++){
        _inShareData+="<tr onclick=\"\" style=\"background-color:#CAFF70\" class=\"Le\" id=\"\">"
                +"<td class=\"lie\" height=\"30px\"><span style=\"font-weight:bold\">"
                
                +window.wriInShare[j].sharesInTime                                     
                +"</td><td class=\"lie\"> 追加</td><td class=\"lie\">"
                +window.wriInShare[j].sharesInNumber
                +"</td><td class=\"lie\">"+window.wriInShare[j].sharesInPrice
                +"</td><td class=\"lie\">"+parseFloat(window.wriInShare[j].sharesInNumber)*parseFloat(window.wriInShare[j].sharesInPrice)
                +"</td><td class=\"lie\">0"
                +"</td><td class=\"lie\">"+window.wriInShare[j].inOtherCost+"</td></tr>";
        _sharesInPriceSum+=parseFloat(window.wriInShare[j].sharesInNumber)*parseFloat(window.wriInShare[j].sharesInPrice);
        _sharesInNumSum+=parseFloat(window.wriInShare[j].sharesInNumber);
		_inOtherCostSum+=parseFloat(window.wriInShare[j].inOtherCost);
	  }
	  j$("#sharesIn").html(_inShareData);
     }else{j$("#sharesIn").html("");}
}
 var _sharesOutPriceSum=0;//记录某股票或股权总的转让的价格
 var _sharesOutNumSum=0;//记录某股票或股权总的转让的股数
 var _outOtherCostSum=0;//记录某股票或股权转让的其他费用的和
 var _taxNumberSum=0;////记录某股票或股权转让的应纳税额的和
 
 
//查询用户某股票或股权转让信息
 function onfindOut(uid,sid){
	 sharesReportD.findOutDwr(uid,sid,function(data){
        	eval("window.wriOutShare=data;");
            onCallWriOutShare();
	
     });          	 
 }
 function onCallWriOutShare(){
	   
	   _sharesOutPriceSum=0;//再次清零一下，否则多次点击报表数据会出错累加
	   _sharesOutNumSum=0;
	   _outOtherCostSum=0;
	   _taxNumberSum=0;
   if(window.wriOutShare!="" && window.wriOutShare.length!=0 && window.wriOutShare!=null){
	   var _outShareData="";//存储转让某股票或股权的信息   

	 for(var j=0;j<window.wriOutShare.length;j++){
        _outShareData+="<tr onclick=\"\" style=\"background-color:#8EE5EE\" class=\"Le\" id=\"\">"
                +"<td class=\"lie\" height=\"30px\"><span style=\"font-weight:bold\">"
                
                +window.wriOutShare[j].sharesOutTime                                     
                +"</td><td class=\"lie\"> 转让</td><td class=\"lie\">"
                +window.wriOutShare[j].sharesOutNumber
                +"</td><td class=\"lie\">"+window.wriOutShare[j].sharesOutPrice
                +"</td><td class=\"lie\">"+parseFloat(window.wriOutShare[j].sharesOutNumber)*parseFloat(window.wriOutShare[j].sharesOutPrice)
                +"</td><td class=\"lie\">"+window.wriOutShare[j].taxNumber
                +"</td><td class=\"lie\">"+window.wriOutShare[j].outOtherCost+"</td></tr>";
         _sharesOutPriceSum+=parseFloat(window.wriOutShare[j].sharesOutNumber)*parseFloat(window.wriOutShare[j].sharesOutPrice);
		 _sharesOutNumSum+=parseFloat(window.wriOutShare[j].sharesOutNumber);
		 _outOtherCostSum+=parseFloat(window.wriOutShare[j].outOtherCost);
		 _taxNumberSum+=parseFloat(window.wriOutShare[j].taxNumber);

	 }
	 j$("#sharesOut").html(_outShareData);
   }else{j$("#sharesOut").html("");}
}
 
//四舍五入函数
 function round(v,e){
     var t=1; 
     for(;e>0;t*=10,e--); 
     for(;e<0;t/=10,e ); 
     return Math.round(v*t)/t; 
  } 
 
 
 
//求结果
function findResults(){

	 //总的其他费用的和=首次购买的的其他费用+追加的其他费用的和+转让的其他费用的和
	 var _otherCostSum=parseFloat(window.wriFirstShare.taxedNumber)+_inOtherCostSum+_outOtherCostSum;
	 
	 //剩余股数=首次购买的股数+总的追加的股数-总的转让的股数
	 var _surplusSharesNum=parseFloat(window.wriFirstShare.sharesNumber)+_sharesInNumSum-_sharesOutNumSum;

	 //股票总花费=首次购买的总价+追加的总价
	 var _sharesCostSum=parseFloat(window.wriFirstShare.sharesInDayNumber)*parseFloat(window.wriFirstShare.sharesNumber)+_sharesInPriceSum;
	 //首次买进及追加时每股的平均价格
	 var _avgSharesInPirce=_sharesCostSum/(parseFloat(window.wriFirstShare.sharesNumber)+_sharesInNumSum);

	 //由转让的股数来计算买进时候的总价=_avgSharesInPirce*转让的股数和
	 var _sharesSomeCost=round(_avgSharesInPirce,2)*_sharesOutNumSum;
	 var _resultNum=0;//结果
	 if(_sharesOutNumSum==0){
	   //赚取=转让的总价-首次购买总价-追加的总价-总的其他费用的和-应纳税额的和
	   _resultNum=_sharesOutPriceSum-_sharesSomeCost;
	 }else{
		//赚取=转让的总价-首次购买总价-追加的总价-总的其他费用的和-应纳税额的和
		   _resultNum=_sharesOutPriceSum-_sharesSomeCost-_otherCostSum-_taxNumberSum;
	 }
	
	var _sharesResultData="<tr onclick=\"\" style=\"background-color:#FFFFFF\" class=\"Le\" id=\"\">"
                         +"<td class=\"lie\" height=\"30px\"><span style=\"font-weight:bold\">"
                         +window.wriFirstShare.sharesName
                         +"</td><td class=\"lie\">股票总花费<br/>"+_sharesCostSum
                         +"</td><td class=\"lie\">剩余股数<br/>"+_surplusSharesNum 
                         +"</td><td class=\"lie\">总纳税<br/>"+_taxNumberSum
                         +"</td><td class=\"lie\">其他费用总和<br/>"+_otherCostSum;
                  
	   
	if(_resultNum>=0){_sharesResultData+="</td><td style=\"color:#DC143C;font-size:20px;font-weight:bold\" colspan=\"2\" class=\"lie\">赚取："+_resultNum+"</td></tr>";}
	else{_sharesResultData+="</td><td style=\"color:#DC143C;font-size:20px;font-weight:bold\" colspan=\"2\" class=\"lie\">赔了："+_resultNum*(-1)+"</td></tr>";}
	
	j$("#sharesResult").html(_sharesResultData);
}



//以下为全局的

var kaiguan=false;
function hideRow(para) {
    var pa = "tr[class='S" + para + "']";
    var trs = j$(pa);
    for (var i = 0; i < trs.length; i++) {
        trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
    }
    kaiguan = false;
}

//查询用户所有股票或者股权的首次添加信息
function onfindFullFirst(uid){
	 sharesReportD.findFullFirstDwr(uid,function(data){
       	eval("window.wriFullFirstShare=data;");
           onCallWriFullFirstShare();
    });          	 
}

function onCallWriFullFirstShare(){
	var _fullFirstShareData="";
	for(var j=0;j<window.wriFullFirstShare.length;j++){
        _fullFirstShareData+="<tr onclick=\"findInAndOutShare("+window.wriFullFirstShare[j].sid+")\" style=\"background-color:#E9967A\" class=\"Le\" id=\"\">"
               +"<td class=\"lie\" height=\"30px\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\" style=\"margin-right:10px; border:0;\"/><span style=\"font-weight:bold\">"
               +window.wriFullFirstShare[j].sharesName
               +"</td><td class=\"lie\">"+window.wriFullFirstShare[j].sharesInTime                                     
               +"</td><td class=\"lie\"> 首次购买</td><td class=\"lie\">"
               +window.wriFullFirstShare[j].sharesNumber
               +"</td><td class=\"lie\">"+window.wriFullFirstShare[j].sharesInDayNumber
               +"</td><td class=\"lie\">"+parseFloat(window.wriFullFirstShare[j].sharesInDayNumber)*parseFloat(window.wriFullFirstShare[j].sharesNumber)
               +"</td><td class=\"lie\">0"
               +"</td><td class=\"lie\">"+window.wriFullFirstShare[j].taxedNumber+"</td></tr><p id=\"fullShare"+window.wriFullFirstShare[j].sid+"\"></p>";
	}
    j$("#sharesFullFirst").html(_fullFirstShareData);
}

var _fullInShareData="";

var _fullOutShareData="";

//点击某个股票名称，展开该股票的追加及转让信息
function findInAndOutShare(sid){
	_fullInShareData="";
	_fullOutShareData="";
 if (kaiguan== false) {	
	sharesReportD.findInDwr(22,sid,function(data){
	  if(data!="" && data!=null){
    	eval("window.wriFullInShare=data;");
        onCallWriFullInShare();
        j$("#fullShare"+sid).html(_fullInShareData);
	  } 
    });  
	sharesReportD.findOutDwr(22,sid,function(data){
	  if(data!="" && data!=null){
    	eval("window.wriFullOutShare=data;");
        onCallWriFullOutShare();
        j$("#fullShare"+sid).append(_fullOutShareData);
	  } 
    });
	kaiguan=true;
  }	else{hideRow(sid);}
}


//全局某股票或股权的追加信息
function onCallWriFullInShare(){
    if(window.wriFullInShare!="" && window.wriFullInShare.length!=0 && window.wriFullInShare!=null){
	  
	  for(var j=0;j<window.wriFullInShare.length;j++){
		  _fullInShareData+="<tr onclick=\"\" style=\"background-color:#CAFF70\" class=\"S" + window.wriFullInShare[j].sid + "\" id=\"\"><td></td>"
                +"<td class=\"lie\" height=\"30px\"><span style=\"font-weight:bold\">"
                
                +window.wriFullInShare[j].sharesInTime                                     
                +"</td><td class=\"lie\"> 追加</td><td class=\"lie\">"
                +window.wriFullInShare[j].sharesInNumber
                +"</td><td class=\"lie\">"+window.wriFullInShare[j].sharesInPrice
                +"</td><td class=\"lie\">"+parseFloat(window.wriFullInShare[j].sharesInNumber)*parseFloat(window.wriFullInShare[j].sharesInPrice)
                +"</td><td class=\"lie\">0"
                +"</td><td class=\"lie\">"+window.wriFullInShare[j].inOtherCost+"</td></tr>";
        //_sharesInPriceSum+=parseFloat(window.wriFullInShare[j].sharesInNumber)*parseFloat(window.wriFullInShare[j].sharesInPrice);
        //_sharesInNumSum+=parseFloat(window.wriFullInShare[j].sharesInNumber);
		//_inOtherCostSum+=parseFloat(window.wriFullInShare[j].inOtherCost);
	  }
     }
}

//全局某股票或股权的转让信息
function onCallWriFullOutShare(){
	   if(window.wriFullOutShare!="" && window.wriFullOutShare.length!=0 && window.wriFullOutShare!=null){
		     
		 for(var j=0;j<window.wriFullOutShare.length;j++){
	        _fullOutShareData+="<tr onclick=\"\" style=\"background-color:#8EE5EE\" class=\"S" + window.wriFullOutShare[j].sid + "\" id=\"\"><td></td>"
	                +"<td class=\"lie\" height=\"30px\"><span style=\"font-weight:bold\">"
	                
	                +window.wriFullOutShare[j].sharesOutTime                                     
	                +"</td><td class=\"lie\"> 转让</td><td class=\"lie\">"
	                +window.wriFullOutShare[j].sharesOutNumber
	                +"</td><td class=\"lie\">"+window.wriFullOutShare[j].sharesOutPrice
	                +"</td><td class=\"lie\">"+parseFloat(window.wriFullOutShare[j].sharesOutNumber)*parseFloat(window.wriFullOutShare[j].sharesOutPrice)
	                +"</td><td class=\"lie\">"+window.wriFullOutShare[j].taxNumber
	                +"</td><td class=\"lie\">"+window.wriFullOutShare[j].outOtherCost+"</td></tr>";
	         //_sharesOutPriceSum+=parseFloat(window.wriFullOutShare[j].sharesOutNumber)*parseFloat(window.wriFullOutShare[j].sharesOutPrice);
			 //_sharesOutNumSum+=parseFloat(window.wriFullOutShare[j].sharesOutNumber);
			 //_outOtherCostSum+=parseFloat(window.wriFullOutShare[j].outOtherCost);
			 //_taxNumberSum+=parseFloat(window.wriFullOutShare[j].taxNumber);

		 }
	   }
	}

