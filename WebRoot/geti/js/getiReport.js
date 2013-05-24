//查找所有其他所得
function onFindGeti(uid){
	getiD.findGe(uid,function(data){
		eval("window.wriGeti=data;");
		onCallWriOtherIncome();
	});
}

function onCallWriOtherIncome(){
	if (window.wriGeti != null && window.wriGeti != "") {	
		var _getiData="";
		j$("#getiReport").html("");
	    for (var j = 0; j < window.wriGeti.length; j++) {
	    	 _getiData="";
	    	_getiData = "<tr onclick=\"\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\">"

	        + "<span style=\"font-weight:bold\">"+ window.wriGeti[j].gtiTime 
	        
	        + "</td><td class=\"lie\">" + window.wriGeti[j].gtiNumber
	        + "</td><td class=\"lie\">" + window.wriGeti[j].taxNumber
	        + "</td><td class=\"lie\">" + window.wriGeti[j].taxableNumber
	        + "</td><td class=\"lie\">" + window.wriGeti[j].payOutNumber
	        + "</td><td class=\"lie\">" + window.wriGeti[j].taxEdNumber
	        + "</td><td class=\"lie\"><input type=\"button\" value=\"修改\" onclick=\"onupGetti(window.wriGeti["+j+"])\"/>" 
            + "<input type=\"button\" value=\"删除\" onclick=\"delGetti("+window.wriGeti[j].gid+")\"/></td></tr>";

	    	j$("#getiReport").append(_getiData);
	    	
	    }
	    //reviveDiv("report","paimai");
	  }
	  else{
		  //j$("#otherIncomeReport").html("<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>您没有其他所得信息</h1></center>");
		  j$("#getiReport").html("");
		  j$("#getiReport").html("<tr><td colspan=\"7\"><h1 style='color:#FA0707;font-size:18px;'>没有信息</h1></td></tr>");
			 
      }
}