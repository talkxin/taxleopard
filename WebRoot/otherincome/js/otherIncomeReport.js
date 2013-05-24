//查找所有其他所得
function onFindOtherIncome(uid){
	otherincomeD.findOtherIncomeDwr(uid,function(data){
		eval("window.wriOtherIncome=data;");
		onCallWriOtherIncome();
	});
}

function onCallWriOtherIncome(){
	if (window.wriOtherIncome != null && window.wriOtherIncome != "") {	
		var _otherIncomData="";
		j$("#otherIncomeReport").html("");
	    for (var j = 0; j < window.wriOtherIncome.length; j++) {
	    	 _otherIncomData="";
	    	_otherIncomData = "<tr onclick=\"\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\">"

	        + "<span style=\"font-weight:bold\">"+ window.wriOtherIncome[j].otherName 
	        
	        + "</td><td class=\"lie\">" + window.wriOtherIncome[j].otherTime
	        + "</td><td class=\"lie\">" + window.wriOtherIncome[j].otherNumber
	        + "</td><td class=\"lie\">" + window.wriOtherIncome[j].otherTax
	        + "</td><td class=\"lie\"><input type=\"button\" value=\"修改\" onclick=\"upOtherincome("+j+")\"/>" 
            + "<input type=\"button\" value=\"删除\" onclick=\"ondelOtherincome("+window.wriOtherIncome[j].oid+")\"/></td></tr>";

	    	j$("#otherIncomeReport").append(_otherIncomData);
	    	
	    }
	    //reviveDiv("report","paimai");
	  }
	  else{
		  //j$("#otherIncomeReport").html("<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>您没有其他所得信息</h1></center>");
		  j$("#otherIncomeReport").html("");
		  j$("#otherIncomeReport").html("<tr><td colspan=\"5\"><h1 style='color:#FA0707;font-size:18px;'>您没有其他所得信息</h1></td></tr>");
			 
      }
}