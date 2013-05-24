//查询用户某个账户的储蓄信息
function onFindSavingsDwr(siid){
	savingsD.findSavingsDwr(_userID,siid,function(data){
		eval("window.wriSavings=data;");
		onCallWriSavings();
	});
}
function onCallWriSavings(){
	if (window.wriSavings != null && window.wriSavings != "") {	
		var _obj;
		j$("#savingsBody").html("");
		
	    for (var j = 0; j < window.wriSavings.length; j++) {
	    	var _savingsData=""; 
	    	var _savingsType1="";//存储储蓄类型的文本
	    	var _savingsType2="";//存储存储类型的文本
	    	switch (window.wriSavings[j].savingsType1)
            {
              case 0:
            	  _savingsType1="活期";
                break;
              case 1:
            	  _savingsType1="定期";
                break;
            }
	    	switch (window.wriSavings[j].savingsType2)
            {
              case 0:
            	  _savingsType2="存款";
                break;
              case 1:
            	  _savingsType2="取款";
                break;
            }
	    	_obj=toJSON(window.wriSavings[j]);
	    	_savingsData= "<tr onclick=\"\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\">"

	        + "<span style=\"font-weight:bold\">"+ window.wriSavings[j].savingsName 
	        
	        + "</td><td class=\"lie\">" + window.wriSavings[j].savingsAccount
	        + "</td><td class=\"lie\">" + _savingsType1
	        + "</td><td class=\"lie\">" + _savingsType2
	        + "</td><td class=\"lie\">" + window.wriSavings[j].savingsNumber
	        + "</td><td class=\"lie\">" + window.wriSavings[j].savingsStart
	        + "</td><td class=\"lie\">" + window.wriSavings[j].savingsEnd
	        + "</td><td class=\"lie\">" + window.wriSavings[j].taxNumber
	        + "</td><td class=\"lie\">"+ window.wriSavings[j].payOutNumber
	        + "</td><td class=\"lie\">"+ window.wriSavings[j].interestRate
	        + "</td><td class=\"lie\">"+ window.wriSavings[j].interest
	    	+ "</td><td class=\"lie\"><input type=\"button\" value=\"修改\" onclick=\"onupSaSavings(window.wriSavings["+j+"])\"/>" 
            + "<input type=\"button\" value=\"删除\" onclick=\"ondelSaSavings("+window.wriSavings[j].sid+")\"/></td></tr>";
	    	//alert(_savingsData);
	    	j$("#savingsBody").append(_savingsData);

	    }
		  
	  }
	  else{
		  j$("#savingsBody").html("");
		  j$("#savingsBody").html("<tr><td colspan=\"12\"><h1 style='color:#FA0707;font-size:18px;border: 3px solid #abadac;'>没有该账户信息</h1></td></tr>");
	  }
}