//查询用户某个的储蓄信息
function onFindContractDwr(ciid){
	contractD.findConDwr(_userID,ciid,function(data){
		eval("window.wriContract=data;");
		onCallWriContract();
	});
}
function onCallWriContract(){
	if (window.wriContract != null && window.wriContract != "") {	
		var _obj;
		j$("#contractBody").html("");
		
	    for (var j = 0; j < window.wriContract.length; j++) {
	    	var _contractData=""; 
	    	var _contractCoType="";//存储承包企业类型的文本
	    	var _contractType="";//存储合同类型的文本
	    	var _contractType2="";//存储是否拥有收益的文本
	    	switch (window.wriContract[j].contractCoType)
            {
              case 0:
            	  _contractCoType="国内企业";
                break;
              case 1:
            	  _contractCoType="外商企业";
                break;
            }
	    	switch (window.wriContract[j].contractType)
            {
              case 0:
            	  _contractType="一次性合同";
                break;
              case 1:
            	  _contractType="分次合同";
                break;
            }
	    	switch (window.wriContract[j].contractType2)
            {
              case 0:
            	  _contractType2="拥有";
                break;
              case 1:
            	  _contractType2="不拥有";
                break;
            }
	    	
	    	_obj=toJSON(window.wriContract[j]);
	    	_contractData= "<tr onclick=\"\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\">"

	        + "<span style=\"font-weight:bold\">"+ window.wriContract[j].contractName 
            + "</td><td class=\"lie\">" + _contractCoType
	        + "</td><td class=\"lie\">" + window.wriContract[j].allPay
	        + "</td><td class=\"lie\">" + _contractType2
	        + "</td><td class=\"lie\">" + window.wriContract[j].contractStart
	        + "</td><td class=\"lie\">" + window.wriContract[j].contractEnd
	        + "</td><td class=\"lie\">" + window.wriContract[j].contractNumber1
	        + "</td><td class=\"lie\">" + window.wriContract[j].contractNumber2
	        + "</td><td class=\"lie\">"+ window.wriContract[j].taxNumber
	        + "</td><td class=\"lie\">"+ window.wriContract[j].payOutNumber
	    	+ "</td><td class=\"lie\"><input type=\"button\" value=\"修改\" onclick=\"onupContract(window.wriContract["+j+"])\"/>" 
            + "<input type=\"button\" value=\"删除\" onclick=\"ondelContract("+window.wriContract[j].cid+")\"/></td></tr>";
	    	
	    	j$("#contractBody").append(_contractData);
	    }
		  
	  }
	  else{
		  j$("#contractBody").html("");
		  j$("#contractBody").html("<tr><td colspan=\"12\"><h1 style='color:#FA0707;font-size:18px;border: 3px solid #abadac;'>没有承包承租信息</h1></td></tr>");
	  }
}