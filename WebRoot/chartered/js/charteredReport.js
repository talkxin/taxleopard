//查找用户某专利的详细情况
function onFindChartered(ciid){
	charteredD.findCharDwr(_userID,ciid,function(data){
		eval("window.wriChartered=data;");
		onCallWriChartered();
	});
}
function onCallWriChartered(){
	if (window.wriChartered != null && window.wriChartered != "") {	
		var _obj;
		j$("#charteredBody").html("");
		
	    for (var j = 0; j < window.wriChartered.length; j++) {
	    	var _charteredData="";
	    	_obj=toJSON(window.wriChartered[j]);
	    	_charteredData= "<tr onclick=\"\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\">"

	        + "<span style=\"font-weight:bold\">"+ window.wriChartered[j].charteredInfoName 
	        
	        + "</td><td class=\"lie\">" + window.wriChartered[j].charteredStart
	        + "</td><td class=\"lie\">" + window.wriChartered[j].charteredEnd
	        + "</td><td class=\"lie\">" + window.wriChartered[j].charteredTime
	        + "</td><td class=\"lie\">" + window.wriChartered[j].charteredNumber
	        + "</td><td class=\"lie\">" + window.wriChartered[j].taxNumber
	        + "</td><td class=\"lie\">" + window.wriChartered[j].payOutNumber
	        + "</td><td class=\"lie\">"+ window.wriChartered[j].taxEdNumber
	    	+ "</td><td class=\"lie\"><input type=\"button\" value=\"修改\" onclick=\"onupCrChartered(window.wriChartered["+j+"])\"/>" 
            + "<input type=\"button\" value=\"删除\" onclick=\"ondelCrChartered("+window.wriChartered[j].cid+")\"/></td></tr>";

	    	j$("#charteredBody").append(_charteredData);

	    }
		  
	  }
	  else{
		  j$("#charteredBody").html("");
		  j$("#charteredBody").html("<tr><td colspan=\"9\"><h1 style='color:#FA0707;font-size:18px;border: 3px solid #abadac;'>没有该特许权信息</h1></td></tr>");
	  }

}