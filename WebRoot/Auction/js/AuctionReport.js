//查找所有的拍卖
function onFindAllAuction(uid){
	auctionD.findAuctionDwr(uid,function(data){
		eval("window.wriAuction=data;");
		onCallWriAuction();
	});
}

function onCallWriAuction(){
	if (window.wriAuction != null && window.wriAuction != "") {	
		var _auctionData ="<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">"
                         + "<tr ><td class=\"lie\" width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">拍卖品名称</span></td>"
			             + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">拍卖品原值</span></td>" 
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">拍卖金额</span></td>" 
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">拍卖时间</span></td>"
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">其他税费</span></td>"
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额</span></td>" 
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">税后收入</span></td>" 
		                 + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">操作</span></td></tr>";
		
	    for (var j = 0; j < window.wriAuction.length; j++) {

	    	_auctionData += "<tr onclick=\"\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\">"

	        + "<span style=\"font-weight:bold\">"+ window.wriAuction[j].auctionName 
	        
	        + "</td><td class=\"lie\">" + window.wriAuction[j].auctionOldNumber
	        + "</td><td class=\"lie\">" + window.wriAuction[j].auctionNumber
	        + "</td><td class=\"lie\">" + window.wriAuction[j].auctionTime
	        + "</td><td class=\"lie\">" + window.wriAuction[j].outCastNumber
	        + "</td><td class=\"lie\">" + window.wriAuction[j].taxNumber
	        + "</td><td class=\"lie\">" + window.wriAuction[j].payOutNumber
	        + "</td><td class=\"lie\"><input type=\"button\" value=\"修改\" onclick=\"onupAuctionInfo("+j+")\"/>" 
            + "<input type=\"button\" value=\"删除\" onclick=\"ondelAuctionInfo("+window.wriAuction[j].aid+")\"/></td></td></tr>";

	    }
	     _auctionData += "</table>";
		  j$("#auctionReport").html(_auctionData);
	  }
	  else{
	        document.getElementById("auctionReport").innerHTML = "<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>您没有拍卖信息</center>";
	  }
}