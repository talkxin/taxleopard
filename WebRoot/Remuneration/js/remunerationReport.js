var publishYear;//作品出版的年份
var fullPublishYear;//作品出版的年份

//查找某作品的出版信息
function onFindRemuCombine(){
	onGetSystemYear("nian");
	onChooseYear();
}
//点击某个作品年份下拉框调用此方法
function onChooseYear() {
    //点击年下拉框调用此方法
	publishYear = document.getElementById("nian").value;
	onFindRemu(window.cooID,publishYear);
}
//查找全局的出版信息
function onFindFullRemuCombine(){
	onGetSystemYear("nianFull");
	onChooseFullYear();
}
//点击全局年份下拉框调用此方法
function onChooseFullYear() {
	fullPublishYear = document.getElementById("nianFull").value;
	onFindAllRemu(fullPublishYear);
}

//让下拉框默认选定到当前年
function onGetSystemYear(para) {
    var myYear = new Date().getFullYear();
    var sel = document.getElementById(para);
    for (var i = 0; i < sel.options.length; i++) {
        if (sel.options[i].value == myYear) {
            sel.options[i].selected = true;
        }
    }
}


//查找用户某年某作品的出版情况
function onFindRemu(rid,publishYear){
	remuD.findRemuDwr(_userID,rid,publishYear,function(data){
		eval("window.wriRemu=data;");
		onCallWriRemu();
	});
}
var _remuReportData="";//存储某作品的详细信息
function onCallWriRemu(){
  if (window.wriRemu != null && window.wriRemu != "") {	
	 _remuReportData = "<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">"
		             + "<tr ><td class=\"lie\" width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">作品名</span></td>"
		             + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">出版社</span></td>" 
		             + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">出版时间</span></td>" 
	                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">出版类型</span></td>" 
	                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">个人身份</span></td>"
	                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">所得稿酬</span></td>" 
	                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额</span></td>" 
	                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">税后收入</span></td></tr>";
    for (var j = 0; j < window.wriRemu.length; j++) {
    	var publishName1="";//出版类型的文本信息
    	if(window.wriRemu[j].publishType1==0){publishName1="出版";}
    	else if(window.wriRemu[j].publishType1==1){publishName1="再版";}
    	else if(window.wriRemu[j].publishType1==2){publishName1="加印";}
    	else if(window.wriRemu[j].publishType1==3){publishName1="连载";}
    	else if(window.wriRemu[j].publishType1==4){publishName1="其他";}
    	else{publishName1="退稿费";}
    	
    	var publishName2="";//个人身份的文本信息
    	if(window.wriRemu[j].publishType2==0){publishName2="自由撰稿人";}
    	else if(window.wriRemu[j].publishType2==1){publishName2="出版社专业作者";}
    	else{publishName2="刊物记者";}
    	
    	
    	_remuReportData += "<tr onclick=\"\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\">"

        + "<span style=\"font-weight:bold\">"+ window.wriRemu[j].remunerationName 
        + "</td><td class=\"lie\">" + window.wriRemu[j].pressName
        + "</td><td class=\"lie\">" + window.wriRemu[j].publishTime
        + "</td><td class=\"lie\">" + publishName1
        + "</td><td class=\"lie\">" + publishName2
        + "</td><td class=\"lie\">" + window.wriRemu[j].publishNumber
        + "</td><td class=\"lie\">" + window.wriRemu[j].taxNumber
        + "</td><td class=\"lie\">"+ window.wriRemu[j].payOutNumber+"</td></tr>";

    }
	  _remuReportData += "</table>";
	  j$("#remuReport").html(_remuReportData);
  }
  else{
        document.getElementById("remuReport").innerHTML = "<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>该作品在该年没有出版信息</center>";
  }
}


//查找用户在某出版社某作品的出版情况
function onFindRemuByPress(rid,ptid){
	remuD.findReByPressDwr(_userID,rid,ptid,function(data){
		eval("window.wriRemuByPress=data;");
		onCallWriRemuByPress();
	});
}
var _remuDataByPress="";
function onCallWriRemuByPress(){
	if (window.wriRemuByPress != null && window.wriRemuByPress != "") {	
		_remuDataByPress = "<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">"
			             + "<tr ><td class=\"lie\" width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">出版社</span></td>"
			             + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">作品名</span></td>"
	                     + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">出版时间</span></td>" 
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">出版类型</span></td>" 
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">个人身份</span></td>"
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">所得稿酬</span></td>" 
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额</span></td>" 
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">税后收入</span></td>"
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">操作</span></td></tr>";
	    for (var j = 0; j < window.wriRemuByPress.length; j++) {
	    	var publishName1="";//出版类型的文本信息
	    	if(window.wriRemuByPress[j].publishType1==0){publishName1="出版";}
	    	else if(window.wriRemuByPress[j].publishType1==1){publishName1="再版";}
	    	else if(window.wriRemuByPress[j].publishType1==2){publishName1="加印";}
	    	else if(window.wriRemuByPress[j].publishType1==3){publishName1="连载";}
	    	else if(window.wriRemuByPress[j].publishType1==4){publishName1="其他";}
	    	else{publishName1="退稿费";}
	    	
	    	var publishName2="";//个人身份的文本信息
	    	if(window.wriRemuByPress[j].publishType2==0){publishName2="自由撰稿人";}
	    	else if(window.wriRemuByPress[j].publishType2==1){publishName2="出版社专业作者";}
	    	else{publishName2="刊物记者";}
	    	
	    	var obj=toJSON(window.wriRemuByPress[j]);
	    	_remuDataByPress += "<tr onclick=\"\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\">"

	        + "<span style=\"font-weight:bold\">"+ window.wriRemuByPress[j].pressName 
	        
	        + "</td><td class=\"lie\">" + window.wriRemuByPress[j].remunerationName
	        + "</td><td class=\"lie\">" + window.wriRemuByPress[j].publishTime
	        + "</td><td class=\"lie\">" + publishName1
	        + "</td><td class=\"lie\">" + publishName2
	        + "</td><td class=\"lie\">" + window.wriRemuByPress[j].publishNumber
	        + "</td><td class=\"lie\">" + window.wriRemuByPress[j].taxNumber
	        + "</td><td class=\"lie\">"+ window.wriRemuByPress[j].payOutNumber+"</td>"
	    	+ "</td><td class=\"lie\"><input type=\"button\" value=\"修改\" onclick=\"onUpPublish("+j+");\"/>" 
            + "<input type=\"button\" value=\"删除\" onclick=\"ondelRePublish("+window.wriRemuByPress[j].pid+");\"/></td></td></tr>";

	    }
		  _remuDataByPress += "</table>";
		  j$("#remuReportByPr").html(_remuDataByPress);
	  }
	  else{
	        document.getElementById("remuReportByPr").innerHTML = "<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>该出版社没有作品出版信息</center>";
	  }
	
}





//以下为全局

var kaiguan=false;
function hideRow(para) {
    var pa = "tr[class='Re" + para + "']";
    var trs = j$(pa);
    for (var i = 0; i < trs.length; i++) {
        trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
    }
    kaiguan = false;
}

//查找用户某年所有作品的出版情况
function onFindAllRemu(fullPublishYear){
  	
	remuD.findAllRemuDwr(_userID,fullPublishYear,function(data){
		eval("window.wriAllRemu=data;");
		onCallWriAllRemu();
	});

}
function onCallWriAllRemu(){
	if (window.wriAllRemu != null && window.wriAllRemu != "") {	
		var _allRemuData = "<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">"
			             + "<tr ><td class=\"lie\" width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">作品名</span></td>"
                         + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">所得稿酬</span></td>" 
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额</span></td>" 
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">税后收入</span></td></tr>";
		
	    for (var j = 0; j < window.wriAllRemu.length; j++) {

	    	_allRemuData += "<tr onclick=\"onFindFullRemu("+window.wriAllRemu[j].rid+")\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\" style=\"margin-right:10px; border:0;\"/>"

	        + "<span style=\"font-weight:bold\">"+ window.wriAllRemu[j].remunerationName 
	        
	        + "</td><td class=\"lie\">" + window.wriAllRemu[j].publishNumSum
	        + "</td><td class=\"lie\">" + window.wriAllRemu[j].taxNumSum
	        + "</td><td class=\"lie\">" + window.wriAllRemu[j].payOutNumSum+"</td></tr><p id=\"fullRemu"+window.wriAllRemu[j].rid+"\"></p>";

	    }
	     _allRemuData += "</table>";
		  j$("#allRemuReport").html(_allRemuData);
	  }
	  else{
	        document.getElementById("allRemuReport").innerHTML = "<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>该年没有出版信息</center>";
	  }
}

//全局点击某作品展开查找用户某年该作品的出版情况
function onFindFullRemu(rid){
   if (kaiguan== false) {	
	remuD.findRemuDwr(_userID,rid,fullPublishYear,function(data){
		eval("window.wriFullRemu=data;");
		onCallFullWriRemu();
		j$("#fullRemu"+rid).html(_remuFullReportData);
	});
	kaiguan=true;
    }else{hideRow(rid);}
}
var _remuFullReportData="";//存储某作品的详细信息
function onCallFullWriRemu(){
	  if (window.wriFullRemu != null && window.wriFullRemu != "") {	
		   _remuFullReportData="";
	    for (var j = 0; j < window.wriFullRemu.length; j++) {
	    	var publishName1="";//出版类型的文本信息
	    	if(window.wriFullRemu[j].publishType1==0){publishName1="出版";}
	    	else if(window.wriFullRemu[j].publishType1==1){publishName1="再版";}
	    	else if(window.wriFullRemu[j].publishType1==2){publishName1="加印";}
	    	else if(window.wriFullRemu[j].publishType1==3){publishName1="连载";}
	    	else if(window.wriFullRemu[j].publishType1==4){publishName1="其他";}
	    	else{publishName1="退稿费";}

	    	
	    	_remuFullReportData += "<tr onclick=\"\" style=\"background-color:#E7EFD3\" class=\"Re" + window.wriFullRemu[j].rid + "\" id=\"t" + j + "\">" 
	    	+ "<td class=\"lie\"  height=\"30px\">"
            + "<span style=\"font-weight:bold\">"+ window.wriFullRemu[j].pressName+"("+publishName1+")"
	        + "</td><td class=\"lie\">" + window.wriFullRemu[j].publishNumber
	        + "</td><td class=\"lie\">" + window.wriFullRemu[j].taxNumber
	        + "</td><td class=\"lie\">"+ window.wriFullRemu[j].payOutNumber+"</td></tr>";

	    }
		  
	  }
}
