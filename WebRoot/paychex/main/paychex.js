var _isWindowCloseclickID;
//页面加载时事件
window.onload=function(){
	getUser();
}
// 获取session中的用户ID与用户添加的月份
function getUser(){
	eval("window.divName = 'tabCot_product_1';");
	paychexD.getUser(function(data){
		var id=data["userId"];
		var time=data["addTime"];
		eval("window.sessionUID = id;");
		eval("window.sessionTime = time;");
		getUserInfo();
	});
}

// 获取国家
function getNation(){
	paychexD.getNation(backNation);
}
function backNation(list){
	// DWRUtil.removeAllOptions('orgNation');
	if(window.CityToProvinceToNation!=null && window.CityToProvinceToNation.nid!=null){
		DWRUtil.addOptions('orgNation',[{nid:window.CityToProvinceToNation.nid,langName:window.CityToProvinceToNation.nationLangName}],'nid','langName');
		DWRUtil.addOptions('orgProvince',[{pid:window.CityToProvinceToNation.pid,provinceName:window.CityToProvinceToNation.provinceName}],'pid','provinceName');
		DWRUtil.addOptions('orgCity',[{cid:window.CityToProvinceToNation.cid,langName:window.CityToProvinceToNation.cityLangName}],'cid','langName');
	}else{
	DWRUtil.addOptions('orgNation',[{nid:'-1',langName:'请选择国家'}],'nid','langName');
	DWRUtil.addOptions('orgProvince',[{pid:'-1',provinceName:'请选择省份'}],'pid','provinceName');
	DWRUtil.addOptions('orgCity',[{cid:'-1',langName:'请选择城市'}],'cid','langName');
	}
	DWRUtil.addOptions('orgNation',list,'nid','langName');
}
// 获取省
function getProvince(value){
// var province=$('orgNation').value;
	paychexD.getProvince(value,backProvince);
}
function backProvince(list){
	DWRUtil.removeAllOptions('orgProvince');
	DWRUtil.addOptions('orgProvince',[{pid:'-1',provinceName:'请选择省份'}],'pid','provinceName');
	DWRUtil.addOptions('orgProvince',list,'pid','provinceName');
	DWRUtil.removeAllOptions('orgCity');
	DWRUtil.addOptions('orgCity',[{cid:'-1',langName:'请选择城市'}],'cid','langName');
}
// 获得市
function getCity(value){
// var city=$('orgProvince').value;
	paychexD.getCity(value,backCity);
}
function backCity(list){
	DWRUtil.removeAllOptions('orgCity');
	DWRUtil.addOptions('orgCity',[{cid:'-1',langName:'请选择城市'}],'cid','langName');
	DWRUtil.addOptions('orgCity',list,'cid','langName');
}
// 加载个人信息
function getUserInfo(){
	paychexD.getUserInfo(window.sessionUID,backUserInfo);
}
function backUserInfo(data){
	eval("window.payInfo = data;");
	var time;
	if(data.companyName!=null){
		$('companyName').value=data.companyName;
	}
	if(data.incomeDay!=null){
		$('incomeDay').value=data.incomeDay;
	}
	if(data.payType!=null && data.payType==0){
		document.getElementById('payTypeM').checked="checked";
		document.getElementById("nfxsj").style.display="none";
		document.getElementById("yfxsj").style.display="block";
	}
	if(data.payType!=null && data.payType==1){
		document.getElementById('payTypeY').checked="checked";
		document.getElementById("nfxsj").style.display="block";
		document.getElementById("yfxsj").style.display="none";
		$('nianfaxinriqi').value=data.payDay2;
	}if(data.payNumber!=null){
		$('payNumber').value=data.payNumber;
	}if(data.companyAdd!=null){
		paychexD.getCityToProvinceToNation(data.companyAdd,backCityToProvinceToNation);
	}else{
		getNation();
	}if(data.payDay!=null){
		time=data.payDay+'日';
		
	}else{time='请选择发薪时间';}
	if(data.payDay2!=null){
		$('nfxsj').value=data.payDay2;
	}
	DWRUtil.addOptions('yuexinriqi',[{rvalue:data.payDay,riqi:time}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:1,riqi:'1日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:2,riqi:'2日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:3,riqi:'3日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:4,riqi:'4日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:5,riqi:'5日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:6,riqi:'6日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:7,riqi:'7日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:8,riqi:'8日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:9,riqi:'9日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:10,riqi:'10日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:11,riqi:'11日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:12,riqi:'12日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:13,riqi:'13日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:14,riqi:'14日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:15,riqi:'15日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:16,riqi:'16日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:17,riqi:'17日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:18,riqi:'18日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:19,riqi:'19日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:20,riqi:'20日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:21,riqi:'21日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:22,riqi:'22日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:23,riqi:'23日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:24,riqi:'24日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:25,riqi:'25日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:26,riqi:'26日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:27,riqi:'27日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:28,riqi:'28日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:29,riqi:'29日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:30,riqi:'30日'}],'rvalue','riqi');
	DWRUtil.addOptions('yuexinriqi',[{rvalue:31,riqi:'31日'}],'rvalue','riqi');

	if(data.companType!=null){
		DWRUtil.removeAllOptions('companType');
		var a={id:0,text:'中国境内注册公司支付'};
		var b={id:1,text:'中国境外注册公司支付'};
		var c={id:2,text:'中国境内和境外注册公司支付'};
		switch(data.companType){
		case 0:
			DWRUtil.addOptions('companType',[a,b,c],'id','text');
			break;
		case 1:
			DWRUtil.addOptions('companType',[b,a,c],'id','text');
			break;
		case 2:
			DWRUtil.addOptions('companType',[c,a,b],'id','text');
			break;
		}
	}
}
// 以市求省及国家，并加载国家
function backCityToProvinceToNation(data){
	eval("window.CityToProvinceToNation = data;");
	getNation();
}
// 年薪月薪切换
function payType(){
	if($('payTypeM').checked==true){
		document.getElementById("nfxsj").style.display="none";
		document.getElementById("yfxsj").style.display="block";
	}else{
		document.getElementById("nfxsj").style.display="block";
		document.getElementById("yfxsj").style.display="none";
	}
}
// 基础工资信息存储
function saveUserInfo(){
	var u=window.payInfo;
	var companyName=$('companyName').value;
	var incomeDay=$('incomeDay').value;
	var orgCity=$('orgCity').value;
	var payType;
	var companType=$('companType').value;
	
	var time=$('yuexinriqi').value;
	var time2=$('nianfaxinriqi').value;
	var payNumber=$('payNumber').value;

	var temp=document.getElementsByName("RadioGroup1"); 
	for (i=0;i<temp.length;i++){ 
	// 遍历Radio
	if(temp[i].checked) 
	{payType=temp[i].value;
	} 
	}
	if(companyName!=null && companyName!='' && incomeDay!=null && incomeDay!='' && orgCity!='' && payType!=null && payType!='' && payNumber!=null && payNumber!=''){
		if(u.companyName!=companyName || u.companType!=companType || u.companyAdd!=orgCity || u.payType!=payType || u.payNumber!=payNumber || u.payDay!=time || u.payDay2!=time2){
			u.companyName=companyName;
			u.companType=companType;
			u.incomeDay=incomeDay;
			u.companyAdd=orgCity;
			u.payType=payType;
			if(payType==0 && time!=null){
				u.payDay=time;
				u.payDay2='';
			}
			u.payDay2=time2;
			u.payNumber=payNumber;
			paychexD.upPayrollInfo(u);
		}
	}
}

// /////////////////////////////////////////////////////////////////////////////////
// 添加奖金
function addPrize(){
	if(prizeIsNotNull()){
	if(window.prizeList==null || window.prizeList.length==0){
		var list=[];
		eval("window.prizeList = list;");
	}
	var out=document.getElementById("prizeOutPut");
	var prizeNumber=$('prizeNumber').value;
	if(out.tableType==null || out.tableID==null){
		var map=addPrizeType(out.value);
		out.tableType=map.prizeType;
		out.tableID=map.ptid;
	}
	if($('prizeOutPut').tableType==0){
		var newPrize={pid:null,uid:window.sessionUID,prizeInDay:window.sessionTime,ptid:out.tableID,prizeNumber:prizeNumber,prizeType:out.tableType,prizeTax:0,prizeName:out.value,prizeTypeDate:0};
	}
	else{
		var prizeTax=paychexD.getPrizeTax(ptid,prizeNumber);
		var newPrize={pid:null,uid:window.sessionUID,prizeInDay:window.sessionTime,ptid:out.tableID,prizeNumber:prizeNumber,prizeType:out.tableType,prizeTax:prizeTax,prizeName:out.value,prizeTypeDate:0}
	}
	window.prizeList.push(newPrize);
	addPrizeTr();
	$('prizeOutPut').value='';
	$('prizeNumber').value='';
	// 修改是否存储标识
	window.PrizeListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}
	
	
	
// 添加奖金类型
function addPrizeType(name){
	var ptid;
	 DWREngine.setAsync(false);
	 paychexD.tePrizeType(name,function(data){ptid = data;});
	 DWREngine.setAsync(true);
	 return ptid;
}
// 添加奖金行
function addPrizeTr(){
	DWRUtil.removeAllRows("prizeTable");
	DWRUtil.addRows("prizeTable",window.prizeList,[　　 
　　　　　  function(object){return object.prizeName;},
　　　　　  function(object){return object.prizeNumber;},
		  function(object){if(object.prizeTax==0) return '综合计算'; else return object.prizeTax;} ,
		  function(object){return '<a href="#" onclick="upPrizeTr(this.parentNode.parentNode,this);">修改</a> <a href="#" onclick="removePrizeTr(this.parentNode.parentNode,this);">删除</a>'}
 ]
);
	}
// 删除奖金行
function removePrizeTr(object,td){
	if(confirm('您确定要删除么？')){
	var tdN=td.parentElement.parentElement.rowIndex;
			var root = object.parentNode;
    var allRows = root.getElementsByTagName('tr')
        root.removeChild(object);
        if (tdN==1) { 
        	window.prizeList.shift();
   			 } 
        else if(tdN!=1 && tdN!=window.prizeList.length ){
        	window.prizeList.splice(tdN-1, 1); 
        }
        else if(tdN==window.prizeList.length){
        	window.prizeList.pop();
        }
      // 修改是否存储标识
    	window.PrizeListReturn=true;
	}
	}
// 修改奖金行
function upPrizeTr(object,td){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Prizecaozuo");
	var cao2=document.getElementById("prizeOutPut");
	var cao3=document.getElementById("prizeNumber");
	var list=window.prizeList;
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 找到list中的需修改行
			cao2.value=list[i].prizeName;
			cao2.tableID=list[i].ptid;
			cao3.value=list[i].prizeNumber;
			cao1.innerText="修改";
			cao1.onclick=function()
        {
				upPrizeTr2(object,td);
        }
			return;
		}
	}
}



// 修改奖金行2
function upPrizeTr2(object,td){
	if(prizeIsNotNull()){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Prizecaozuo");
	var list=window.prizeList;
	var output=$('prizeOutPut');
	if(output.tableType==null || output.tableID==null){
		var map=addPrizeType(output.value);
		output.tableType=map.prizeType;
		output.tableID=map.ptid;
	}
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 进行修改
			list[i].ptid=output.tableID;
			list[i].prizeName=output.value;
			list[i].prizeNumber=$('prizeNumber').value;
			if(output.tableType==0){
				list[i].prizeTax=0;
			}else{
				list[i].prizeTax=getPrizeTax($('prizeOutPut').tableID,$('prizeNumber').value);
			}
		}
	}
	// 重新绑定奖金行
	addPrizeTr();
	cao1.innerText="添加";
	cao1.onclick=function(){addPrize();}
	// 清空
	$('prizeOutPut').value='';
	$('prizeNumber').value='';
	// 修改是否存储标识
	window.PrizeListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}



// 返回特殊奖金税值
function getPrizeTax(id,number){
	var tax='';
	 DWREngine.setAsync(false);
	 paychexD.getPrizeTax(id,number,function(data){tax = data;});
	 DWREngine.setAsync(true);
	 return tax;
}
// 加载奖金信息
function openPrize(){
	var type=0;
	paychexD.isGetPrize(window.sessionUID,window.sessionTime,type,function(data){
		if(data!=null){
			window.prizeList=data;
			addPrizeTr();
		}
	});
}

// 奖金上月参照
function canzhaoPrize(){
	var type=1;
	paychexD.isGetPrize(window.sessionUID,window.sessionTime,type,function(data){
		if(data!=null && data.length!=0){
			window.prizeList=data;
			addPrizeTr();
		}else{
			alert('您上月没有填写过奖金信息');
		}
	});
}
// 奖金存储
function savePrize(){
	if(window.PrizeListReturn){
		paychexD.savePrize(window.prizeList);
		window.prizeList=null;
		window.PrizeListReturn=false;
	}
}
// 验证是否为空
function prizeIsNotNull(){
	if($('prizeNumber').value!=null && $('prizeOutPut').value!=null && $('prizeNumber').value!='' && $('prizeOutPut').value!=''){
		return true;
	}else{
		return false;
	}
}

// ////////////////////////////////////////////////////////////////////////////
// 添加补贴
function addSubsidy(){
	if(subsidyIsNotNull()){
	if(window.subsidyList==null || window.subsidyList.length==0){
		var list=[];
		eval("window.subsidyList = list;");
	}
	var out=document.getElementById("subsidyOutPut");
	var subsidyNumber=$('subsidyNumber').value;
	if(out.tableType==null || out.tableID==null){
		var map=addSubsidyType(out.value);
		out.tableType=map.subsidyType;
		out.tableID=map.stid;
	}
	if($('subsidyOutPut').tableType==0){
		var newSubsidy={sid:null,uid:window.sessionUID,subsidyInDay:window.sessionTime,stid:out.tableID,subsidyNumber:subsidyNumber,subsidyType:out.tableType,subsidyTax:0,subsidyName:out.value};
	}
	else{
		var subsidyTax=paychexD.getSubsidyTax(stid,subsidyNumber);
		var newSubsidy={sid:null,uid:window.sessionUID,subsidyInDay:window.sessionTime,stid:out.tableID,subsidyNumber:subsidyNumber,subsidyType:out.tableType,subsidyTax:0,subsidyName:out.value};
	}
	window.subsidyList.push(newSubsidy);
	addSubsidyTr();
	$('subsidyOutPut').value='';
	$('subsidyNumber').value='';
	// 修改是否存储标识
	window.subsidyListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}
	
	
	
// 添加补贴类型
function addSubsidyType(name){
	var stid;
	 DWREngine.setAsync(false);
	 paychexD.teSubsidyType(name,function(data){stid = data;});
	 DWREngine.setAsync(true);
	 return stid;
}
// 添加补贴行
function addSubsidyTr(){
	DWRUtil.removeAllRows("subsidyTable");
	DWRUtil.addRows("subsidyTable",window.subsidyList,[　　 
　　　　　  function(object){return object.subsidyName;},
　　　　　  function(object){return object.subsidyNumber;},
		  function(object){if(object.subsidyTax==0 && object.subsidyType==0) return '综合计算'; else if(object.subsidyType==2) return '免税补贴'; else return object.subsidyTax;} ,
		  function(object){return '<a href="#" onclick="upSubsidyTr(this.parentNode.parentNode,this);">修改</a> <a href="#" onclick="removeSubsidyTr(this.parentNode.parentNode,this);">删除</a>'}
 ]
);
	}
// 删除补贴行
function removeSubsidyTr(object,td){
	if(confirm('您确定要删除么？')){
	var tdN=td.parentElement.parentElement.rowIndex;
			var root = object.parentNode;
    var allRows = root.getElementsByTagName('tr')
        root.removeChild(object);
        if (tdN==1) { 
        	window.subsidyList.shift();
   			 } 
        else if(tdN!=1 && tdN!=window.subsidyList.length ){
        	window.subsidyList.splice(tdN-1, 1); 
        }
        else if(tdN==window.subsidyList.length){
        	window.subsidyList.pop();
        }
      // 修改是否存储标识
    	window.subsidyListReturn=true;
	}
	}
// 修改补贴行
function upSubsidyTr(object,td){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Subsidycaozuo");
	var cao2=document.getElementById("subsidyOutPut");
	var cao3=document.getElementById("subsidyNumber");
	var list=window.subsidyList;
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 找到list中的需修改行
			cao2.value=list[i].subsidyName;
			cao2.tableID=list[i].stid;
			cao3.value=list[i].subsidyNumber;
			cao1.innerText="修改";
			cao1.onclick=function()
        {
				upSubsidyTr2(object,td);
        }
			return;
		}
	}
}



// 修改补贴行2
function upSubsidyTr2(object,td){
	if(subsidyIsNotNull()){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Subsidycaozuo");
	var list=window.subsidyList;
	var output=$('subsidyOutPut');
	if(output.tableType==null || output.tableID==null){
		var map=addSubsidyType(output.value);
		output.tableType=map.subsidyType;
		output.tableID=map.stid;
	}
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 进行修改
			list[i].stid=output.tableID;
			list[i].subsidyName=output.value;
			list[i].subsidyNumber=$('subsidyNumber').value;
			if(output.tableType==0 || output.tableType==2){
				list[i].subsidyTax=0;
			}else{
				list[i].subsidyTax=getSubsidyTax($('subsidyOutPut').tableID,$('subsidyNumber').value);
			}
		}
	}
	// 重新绑定补贴行
	addSubsidyTr();
	cao1.innerText="添加";
	cao1.onclick=function(){addSubsidy();}
	// 清空
	$('subsidyOutPut').value='';
	$('subsidyNumber').value='';
	// 修改是否存储标识
	window.subsidyListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}



// 返回特殊补贴税值
function getSubsidyTax(id,number){
	var tax='';
	 DWREngine.setAsync(false);
	 paychexD.getSubsidyTax(id,number,function(data){tax = data;});
	 DWREngine.setAsync(true);
	 return tax;
}
// 加载补贴信息
function openSubsidy(){
	var type=0;
	paychexD.isGetSubsidy(window.sessionUID,window.sessionTime,type,function(data){
		if(data!=null){
			window.subsidyList=data;
			addSubsidyTr();
		}
	});
}

// 补贴上月参照
function canzhaoSubsidy(){
	var type=1;
	paychexD.isGetSubsidy(window.sessionUID,window.sessionTime,type,function(data){
		if(data!=null && data.length!=0){
			window.subsidyList=data;
			addSubsidyTr();
		}else{
			alert('您上月没有填写过补贴信息');
		}
	});
}
// 补贴存储
function saveSubsidy(){
	if(window.subsidyListReturn){
		paychexD.saveSubsidy(window.subsidyList);
		window.subsidyList=null;
		window.subsidyListReturn=false;
	}
}
// 验证是否为空
function subsidyIsNotNull(){
	if($('subsidyNumber').value!=null && $('subsidyOutPut').value!=null && $('subsidyNumber').value!='' && $('subsidyOutPut').value!=''){
		return true;
	}else{
		return false;
	}
}

// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 添加分红
function addBonus(){
	if(bonusIsNotNull()){
	if(window.bonusList==null || window.bonusList.length==0){
		var list=[];
		eval("window.bonusList = list;");
	}
	// var out=document.getElementById("bonusOutPut");
	var bonusNumber=$('bonusNumber').value;
	// if(out.tableType==null || out.tableID==null){
	// var map=addBonusType(out.value);
	// out.tableType=map.bonusType;
	// out.tableID=map.stid;
	// }
	// if($('bonusOutPut').tableType==0){
		var newBonus={bid:null,uid:window.sessionUID,bonusInDay:window.sessionTime,bonusNumber:bonusNumber,bonusTax:0};
	// }
	// else{
		// var bonusTax=paychexD.getBonusTax(stid,bonusNumber);
	// var
	// newBonus={sid:null,uid:window.sessionUID,bonusInDay:window.sessionTime,stid:out.tableID,bonusNumber:bonusNumber,bonusType:out.tableType,bonusTax:0,bonusName:out.value};
	// }
	window.bonusList.push(newBonus);
	addBonusTr();
	// $('bonusOutPut').value='';
	$('bonusNumber').value='';
	// 修改是否存储标识
	window.bonusListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}
	
	
	
// 添加分红类型
// function addBonusType(name){
// var stid;
// DWREngine.setAsync(false);
// paychexD.teBonusType(name,function(data){stid = data;});
// DWREngine.setAsync(true);
// return stid;
// }
// 添加分红行
function addBonusTr(){
	DWRUtil.removeAllRows("bonusTable");
	DWRUtil.addRows("bonusTable",window.bonusList,[　　 
　　　　　  function(object){return '现金分红';},
　　　　　  function(object){return object.bonusNumber;},
		  function(object){return '综合计算'} ,
		  function(object){return '<a href="#" onclick="upBonusTr(this.parentNode.parentNode,this);">修改</a> <a href="#" onclick="removeBonusTr(this.parentNode.parentNode,this);">删除</a>'}
]
);
	}
// 删除分红行
function removeBonusTr(object,td){
	if(confirm('您确定要删除么？')){
	var tdN=td.parentElement.parentElement.rowIndex;
			var root = object.parentNode;
    var allRows = root.getElementsByTagName('tr')
        root.removeChild(object);
        if (tdN==1) { 
        	window.bonusList.shift();
   			 } 
        else if(tdN!=1 && tdN!=window.bonusList.length ){
        	window.bonusList.splice(tdN-1, 1); 
        }
        else if(tdN==window.bonusList.length){
        	window.bonusList.pop();
        }
      // 修改是否存储标识
    	window.bonusListReturn=true;
	}
	}
// 修改分红行
function upBonusTr(object,td){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Bonuscaozuo");
	// var cao2=document.getElementById("bonusOutPut");
	var cao3=document.getElementById("bonusNumber");
	var list=window.bonusList;
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 找到list中的需修改行
			// cao2.value=list[i].bonusName;
			// cao2.tableID=list[i].ptid;
			cao3.value=list[i].bonusNumber;
			cao1.innerText="修改";
			cao1.onclick=function()
        {
				upBonusTr2(object,td);
        }
			return;
		}
	}
}



// 修改分红行2
function upBonusTr2(object,td){
	if(bonusIsNotNull()){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Bonuscaozuo");
	var list=window.bonusList;
	// var output=$('bonusOutPut');
	// if(output.tableType==null || output.tableID==null){
	// var map=addBonusType(output.value);
	// output.tableType=map.bonusType;
	// output.tableID=map.ptid;
	// }
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 进行修改
	// list[i].ptid=output.tableID;
	// list[i].bonusName=output.value;
			list[i].bonusNumber=$('bonusNumber').value;
	// if(output.tableType==0){
	// list[i].bonusTax=0;
	// }else{
	// list[i].bonusTax=getBonusTax($('bonusOutPut').tableID,$('bonusNumber').value);
// }
		}
	}
	// 重新绑定分红行
	addBonusTr();
	cao1.innerText="添加";
	cao1.onclick=function(){addBonus();}
	// 清空
	// $('bonusOutPut').value='';
	$('bonusNumber').value='';
	// 修改是否存储标识
	window.bonusListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}



// 返回特殊分红税值
// function getBonusTax(id,number){
// var tax='';
// DWREngine.setAsync(false);
// paychexD.getBonusTax(id,number,function(data){tax = data;});
// DWREngine.setAsync(true);
// return tax;
// }
// 加载分红信息
function openBonus(){
	var type=0;
	paychexD.isGetBonus(window.sessionUID,window.sessionTime,type,function(data){
		if(data!=null){
			window.bonusList=data;
			addBonusTr();
		}
	});
}

// 分红上月参照
function canzhaoBonus(){
	var type=1;
	paychexD.isGetBonus(window.sessionUID,window.sessionTime,type,function(data){
		if(data!=null && data.length!=0){
			window.bonusList=data;
			addBonusTr();
		}else{
			alert('您上月没有填写过分红信息');
		}
	});
}
// 分红存储
function saveBonus(){
	if(window.bonusListReturn){
		paychexD.saveBonus(window.bonusList);
		window.bonusList=null;
		window.bonusListReturn=false;
	}
}
// 验证是否为空
function bonusIsNotNull(){
	if($('bonusNumber').value!=null && $('bonusOutPut').value!=null && $('bonusNumber').value!='' && $('bonusOutPut').value!=''){
		return true;
	}else{
		return false;
	}
}

// ///////////////////////////////////////////////////////////////////////////////
// 初始化五险一金
function openInsurance(){
	if(window.CityToProvinceToNation!=null && window.CityToProvinceToNation.nid!=null){
		DWRUtil.addOptions('orgProvinceSB',[{pid:window.CityToProvinceToNation.pid,provinceName:window.CityToProvinceToNation.provinceName}],'pid','provinceName');
		DWRUtil.addOptions('orgCitySB',[{cid:window.CityToProvinceToNation.cid,langName:window.CityToProvinceToNation.cityLangName}],'cid','langName');
	}else{
		DWRUtil.addOptions('orgProvinceSB',[{pid:'-1',provinceName:'请选择省份'}],'pid','provinceName');
		DWRUtil.addOptions('orgCitySB',[{cid:'-1',langName:'请选择城市'}],'cid','langName');
	}
	paychexD.getProvince(1,function(list){
		DWRUtil.removeAllOptions('orgProvinceSB');
		DWRUtil.addOptions('orgProvinceSB',list,'pid','provinceName');
	});
	paychexD.isGetInsurance(window.CityToProvinceToNation.cid,function(data){
		$('insuranceInNumber').value=data.insuranceInNumber;
		$('insuranceCardinal').value=data.insuranceCardinal;
		$('fengdingshu').value=data.averageNum*3;
		$('insuranceInNumber').value=data.pensionP+data.medicalP+data.unemploymentP+data.housingP;
		$('pensionP').value=data.pensionP;
		$('medicalP').value=data.medicalP;
		$('unemploymentP').value=data.unemploymentP;
		$('housingP').value=data.housingP;
		$('pensionC').value=data.pensionC;
		$('medicalC').value=data.medicalC;
		$('unemploymentC').value=data.unemploymentC;
		$('industrialC').value=data.industrialC;
		$('birthC').value=data.birthC;
		$('housingC').value=data.housingC;
		eval("window.insuranceData = data;");
	});
}


// 获得城市
function getCity1(value){
	paychexD.getCity(value,function(list){
		DWRUtil.removeAllOptions('orgCitySB');
		DWRUtil.addOptions('orgCitySB',[{cid:'-1',langName:'请选择城市'}],'cid','langName');
		DWRUtil.addOptions('orgCitySB',list,'cid','langName');
	});
}

// 存储五险一金
function saveInsurance(){
	paychexD.saveInsurance(window.insuranceData);
}
// ////////////////////////////////////////////////////////////////////////////////////////////////

// 添加商业保险
function addCooinsurance(){
	if(cooinsuranceIsNotNull()){
	if(window.cooinsuranceList==null || window.cooinsuranceList.length==0){
		var list=[];
		eval("window.cooinsuranceList = list;");
	}
		var newCooinsurance={ccid:null,uid:window.sessionUID,cooinsuranceName:$('cooinsuranceName').value,cooinsuranceType:$('cooinsuranceType').value,insuranceDate:$('insuranceDate').value,insuranceNumber:$('insuranceNumber').value,insuranceType:$('insuranceType').value};
	window.cooinsuranceList.push(newCooinsurance);
	addCooinsuranceTr();
	$('cooinsuranceName').value='';
	$('cooinsuranceType').value='';
	$('insuranceDate').value='';
	$('insuranceNumber').value=''
	// 修改是否存储标识
	window.cooinsuranceListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}


// 添加商业保险行
function addCooinsuranceTr(){
	DWRUtil.removeAllRows("cooinsuranceTable");
	DWRUtil.addRows("cooinsuranceTable",window.cooinsuranceList,[　　 
　　　　　  function(object){return object.cooinsuranceName;},
　　　　　  function(object){return object.cooinsuranceType;},
		  			function(object){return object.insuranceDate} ,
		  			function(object){return object.insuranceNumber},
		 			  function(object){return '<a href="#" onclick="upCooinsuranceTr(this.parentNode.parentNode,this);">修改</a> <a href="#" onclick="removeCooinsuranceTr(this.parentNode.parentNode,this);">停保</a>'}
 ]
 );
	}
	
// 删除商业保险行
function removeCooinsuranceTr(object,td){
	if(confirm('您确定要停止么？')){
	var tdN=td.parentElement.parentElement.rowIndex;
			var root = object.parentNode;
    var allRows = root.getElementsByTagName('tr')
        root.removeChild(object);
        if (tdN==1) { 
        	window.cooinsuranceList.shift();
   			 } 
        else if(tdN!=1 && tdN!=window.cooinsuranceList.length ){
        	window.cooinsuranceList.splice(tdN-1, 1); 
        }
        else if(tdN==window.cooinsuranceList.length){
        	window.cooinsuranceList.pop();
        }
      // 修改是否存储标识
    	window.cooinsuranceListReturn=true;
	}
	}
	
// 修改商业保险行
function upCooinsuranceTr(object,td){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Cooinsurancecaozuo");
	var list=window.cooinsuranceList;
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 找到list中的需修改行
				$('cooinsuranceName').value=list[i].cooinsuranceName;
				$('cooinsuranceType').value=list[i].cooinsuranceType;
				$('insuranceDate').value=list[i].insuranceDate;
				$('insuranceNumber').value=list[i].insuranceNumber;
			cao1.innerText="修改";
			cao1.onclick=function()
        {
				upCooinsuranceTr2(object,td);
        }
			return;
		}
	}
}



// 修改商业保险行2
function upCooinsuranceTr2(object,td){
	if(cooinsuranceIsNotNull()){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Cooinsurancecaozuo");
	var list=window.cooinsuranceList;
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 进行修改
			list[i].cooinsuranceName=$('cooinsuranceName').value;
			list[i].cooinsuranceType=$('cooinsuranceType').value;
			list[i].insuranceDate=$('insuranceDate').value;
			list[i].insuranceNumber=$('insuranceNumber').value;
			list[i].insuranceType=$('insuranceType').value;
		}
	}
	// 重新绑定商业保险行
	addCooinsuranceTr();
	cao1.innerText="添加";
	cao1.onclick=function(){addCooinsurance();}
	// 清空
	$('cooinsuranceName').value='';
	$('cooinsuranceType').value='';
	$('insuranceDate').value='';
	$('insuranceNumber').value=''
	// 修改是否存储标识
	window.cooinsuranceListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}




// 加载商业保险信息
function openCooinsurance(){
	var type=0;
	paychexD.isGetCooinsurance(window.sessionUID,function(data){
		if(data!=null){
			window.cooinsuranceList=data;
			addCooinsuranceTr();
		}
	});
}

// 商业保险存储
function saveCooinsurance(){
	if(window.cooinsuranceListReturn){
		paychexD.saveCooinsurance(window.cooinsuranceList);
		window.cooinsuranceList=null;
		window.cooinsuranceListReturn=false;
	}
}
// 验证是否为空
function cooinsuranceIsNotNull(){
	if($('cooinsuranceName').value!=null && $('cooinsuranceType').value!=null){
		return true;
	}else{
		return false;
	}
}
// //////////////////////////////////////////////////////////////////////////////
// 添加扣除
function addDeduction(){
	if(deductionIsNotNull()){
	if(window.deductionList==null || window.deductionList.length==0){
		var list=[];
		eval("window.deductionList = list;");
	}
		var newDeduction={did:null,uid:window.sessionUID,deductionDay:window.sessionTime,deductionName:$('deductionName').value,deductionNumber:$('deductionNumber').value};
	window.deductionList.push(newDeduction);
	addDeductionTr();
	$('deductionName').value='';
	$('deductionNumber').value='';
	// 修改是否存储标识
	window.deductionListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}
	

// 添加扣除行
function addDeductionTr(){
	DWRUtil.removeAllRows("deductionTable");
	DWRUtil.addRows("deductionTable",window.deductionList,[　　 
　　　　　  function(object){return object.deductionName;},
　　　　　  function(object){return object.deductionNumber;},
		  function(object){return '<a href="#" onclick="upDeductionTr(this.parentNode.parentNode,this);">修改</a> <a href="#" onclick="removeDeductionTr(this.parentNode.parentNode,this);">删除</a>'}
]);}
	
// 删除扣除行
function removeDeductionTr(object,td){
	if(confirm('您确定要删除么？')){
	var tdN=td.parentElement.parentElement.rowIndex;
			var root = object.parentNode;
    var allRows = root.getElementsByTagName('tr')
        root.removeChild(object);
        if (tdN==1) { 
        	window.deductionList.shift();
   			 } 
        else if(tdN!=1 && tdN!=window.deductionList.length ){
        	window.deductionList.splice(tdN-1, 1); 
        }
        else if(tdN==window.deductionList.length){
        	window.deductionList.pop();
        }
      // 修改是否存储标识
    	window.deductionListReturn=true;
	}
	}
// 修改扣除行
function upDeductionTr(object,td){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Deductioncaozuo");
	var cao2=document.getElementById("deductionName");
	var cao3=document.getElementById("deductionNumber");
	var list=window.deductionList;
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 找到list中的需修改行
			cao2.value=list[i].deductionName;
			cao3.value=list[i].deductionNumber;
			cao1.innerText="修改";
			cao1.onclick=function()
        {
				upDeductionTr2(object,td);
        }
			return;
		}
	}
}



// 修改扣除行2
function upDeductionTr2(object,td){
	if(deductionIsNotNull()){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Deductioncaozuo");
	var list=window.deductionList;
	var output=$('deductionName');
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 进行修改
			list[i].deductionName=output.value;
			list[i].deductionNumber=$('deductionNumber').value;
		}
	}
	// 重新绑定扣除行
	addDeductionTr();
	cao1.innerText="添加";
	cao1.onclick=function(){addDeduction();}
	// 清空
	$('deductionName').value='';
	$('deductionNumber').value='';
	// 修改是否存储标识
	window.deductionListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}


// 加载扣除信息
function openDeduction(){
	var type=0;
	paychexD.isGetDeduction(window.sessionUID,window.sessionTime,type,function(data){
		if(data!=null){
			window.deductionList=data;
			addDeductionTr();
		}
	});
}

// 扣除上月参照
function canzhaoDeduction(){
	var type=1;
	paychexD.isGetDeduction(window.sessionUID,window.sessionTime,type,function(data){
		if(data!=null && data.length!=0){
			window.deductionList=data;
			addDeductionTr();
		}else{
			alert('您上月没有填写过扣除信息');
		}
	});
}

// 扣除存储
function saveDeduction(){
	if(window.deductionListReturn){
		paychexD.saveDeduction(window.deductionList);
		window.deductionList=null;
		window.deductionListReturn=false;
	}
}
// 验证是否为空
function deductionIsNotNull(){
	if($('deductionNumber').value!=null && $('deductionName').value!=null && $('deductionNumber').value!='' && $('deductionName').value!=''){
		return true;
	}else{
		return false;
	}
}

// ///////////////////////////////////////////////////////////////////////////////////////
// 添加退职费
function addRetired(){
	if(retiredIsNotNull()){
	if(window.retiredList==null || window.retiredList.length==0){
		var list=[];
		eval("window.retiredList = list;");
	}

		var newRetired={rid:null,uid:window.sessionUID,retiredDay:window.sessionTime,retiredCompanyName:$('retiredCompanyName').value,retiredNumber:$('retiredNumber').value,workYears:$('workYears').value,retiredTax:0};
		var retiredTax;
// retiredTax=returnRetiredTax();
		if(retiredTax==null || retiredTax=='')
			retiredTax=0;
		newRetired.retiredTax=retiredTax;
	window.retiredList.push(newRetired);
	addRetiredTr();
	$('retiredCompanyName').value='';
	$('retiredNumber').value=''
	$('workYears').value='';
	// 修改是否存储标识
	window.retiredListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}
	

// 添加退职费行
function addRetiredTr(){
	DWRUtil.removeAllRows("retiredTable");
	DWRUtil.addRows("retiredTable",window.retiredList,[　　 
　　　　　  function(object){return object.retiredCompanyName;},
　　　　　  function(object){return object.retiredNumber;},
						function(object){return object.retiredTax},
		  function(object){return '<a href="#" onclick="upRetiredTr(this.parentNode.parentNode,this);">修改</a> <a href="#" onclick="removeRetiredTr(this.parentNode.parentNode,this);">删除</a>'}
 ]
　　　　 );
	}
	
// 删除退职费行
function removeRetiredTr(object,td){
	if(confirm('您确定要删除么？')){
	var tdN=td.parentElement.parentElement.rowIndex;
			var root = object.parentNode;
    var allRows = root.getElementsByTagName('tr')
        root.removeChild(object);
        if (tdN==1) { 
        	window.retiredList.shift();
   			 } 
        else if(tdN!=1 && tdN!=window.retiredList.length ){
        	window.retiredList.splice(tdN-1, 1); 
        }
        else if(tdN==window.retiredList.length){
        	window.retiredList.pop();
        }
      // 修改是否存储标识
    	window.retiredListReturn=true;
	}
	}
// 修改退职费行
function upRetiredTr(object,td){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Retiredcaozuo");
	var cao2=document.getElementById("retiredName");
	var cao3=document.getElementById("retiredNumber");
	var list=window.retiredList;
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 找到list中的需修改行
			cao2.value=list[i].retiredName;
			cao3.value=list[i].retiredNumber;
			$('workYears').value=list[i].workYears;
			cao1.innerText="修改";
			cao1.onclick=function()
        {
				upRetiredTr2(object,td);
        }
			return;
		}
	}
}



// 修改退职费行2
function upRetiredTr2(object,td){
	if(retiredIsNotNull()){
	var tdN=td.parentElement.parentElement.rowIndex;
	var cao1=document.getElementById("Retiredcaozuo");
	var list=window.retiredList;
	for(var i=0;i<list.length;i++){
		if(i==tdN-1){
			// 进行修改
			list[i].retiredCompanyName=$('retiredCompanyName').value;
			list[i].retiredNumber=$('retiredNumber').value;
			list[i].workYears=$('workYears').value;
			// 进行税务计算
			var retiredTax;
// retiredTax=returnRetiredTax(list[i]);
			if(retiredTax==null){
				retiredTax=0
			}
			list[i].retiredTax=retiredTax;
		}
	}
	// 重新绑定退职费行
	addRetiredTr();
	cao1.innerText="添加";
	cao1.onclick=function(){addRetired();}
	// 清空
	$('retiredCompanyName').value='';
	$('retiredNumber').value=''
	$('workYears').value='';
	// 修改是否存储标识
	window.retiredListReturn=true;
	}else{
		alert('您没有填写完全');
	}
}


// 加载退职费信息
function openRetired(){
	paychexD.isGetRetired(window.sessionUID,function(data){
		if(data!=null){
			window.retiredList=data;
			addRetiredTr();
		}
	});
}

// 退职费存储
function saveRetired(){
	if(window.retiredListReturn){
		paychexD.saveRetired(window.retiredList);
		window.retiredList=null;
		window.retiredListReturn=false;
	}
}
// 验证是否为空
function retiredIsNotNull(){
	if($('retiredNumber').value!=null && $('retiredCompanyName').value!=null && $('retiredNumber').value!='' && $('retiredCompanyName').value!=''){
		return true;
	}else{
		return false;
	}
}

// 点击完成或取消时保存当前页面
function saveAll(type){
	saveTemp(window.divName);
	if(type==0)
		window.location.href="breakPay";
	else
		window.location.href="returnPay";
}



// 变换标签时存储信息
function saveTemp(id){
	DWREngine.setAsync(false);
	if(id=='tabCot_product_1'){
		saveUserInfo();
	}else if(id=='tabCot_product_2'){
		savePrize();
	}else if(id=='tabCot_product_3'){
		saveSubsidy();
	}else if(id=='tabCot_product_4'){
		saveBonus();
	}else if(id=='tabCot_product_5'){
		saveInsurance();
	}else if(id=='tabCot_product_6'){
		saveCooinsurance();
	}else if(id=='tabCot_product_7'){
		saveDeduction();
	}else if(id=='tabCot_product_8'){
		saveRetired();
	}else if(id=='tabCot_product_9'){
		
	}else if(id=='tabCot_product_10'){
		
	}
	DWREngine.setAsync(true);
}


// 加载标签事件初始化
function openTemp(id){
	if(id=='tabCot_product_2'){
		window.divName ='tabCot_product_2';
		if(window.prizeList==null || window.prizeList.length==0){
			var list=[];
			eval("window.prizeList = list;");
		}if(window.PrizeListReturn==null){
			var list=false;
			eval("window.PrizeListReturn = list;");
		}
		openPrize();
	}else if(id=='tabCot_product_3'){
		window.divName ='tabCot_product_3';
		if(window.prizeList==null || window.prizeList.length==0){
			var list=[];
			eval("window.subsidyList = list;");
		}if(window.PrizeListReturn==null){
			var list=false;
			eval("window.subsidyListReturn = list;");
		}
		openSubsidy();
	}else if(id=='tabCot_product_4'){
		window.divName ='tabCot_product_4';
		if(window.bonusList==null || window.bonusList.length==0){
			var list=[];
			eval("window.bonusList = list;");
		}if(window.bonusListReturn==null){
			var list=false;
			eval("window.bonusListReturn = list;");
		}
		openBonus();
	}else if(id=='tabCot_product_5'){
		window.divName ='tabCot_product_5';
		if(window.insuranceListReturn==null){
			var list=false;
			eval("window.insuranceListReturn = list;");
		}
		openInsurance();
	}else if(id=='tabCot_product_6'){
		window.divName ='tabCot_product_6';
		if(window.cooinsuranceList==null || window.cooinsuranceList.length==0){
			var list=[];
			eval("window.cooinsuranceList = list;");
		}
		if(window.cooinsuranceListReturn==null){
			var list=false;
			eval("window.cooinsuranceListReturn = list;");
		}
		openCooinsurance();
	}else if(id=='tabCot_product_7'){
		window.divName ='tabCot_product_7';
		if(window.deductionList==null || window.deductionList.length==0){
			var list=[];
			eval("window.deductionList = list;");
		}
		if(window.deductionListReturn==null){
			var list=false;
			eval("window.deductionListReturn = list;");
		}
		openDeduction();
		
	}else if(id=='tabCot_product_8'){
		window.divName ='tabCot_product_8';
		if(window.retiredList==null || window.retiredList.length==0){
			var list=[];
			eval("window.retiredList = list;");
		}
		if(window.retiredListReturn==null){
			var list=false;
			eval("window.retiredListReturn = list;");
		}
		openRetired();
	}else if(id=='tabCot_product_9'){
		window.divName ='tabCot_product_9';
		
	}else if(id=='tabCot_product_10'){
		window.divName ='tabCot_product_10';
	}
}

// 克隆对象
function clone(obj){
	var objClone;
	if (obj.constructor == Object){
	objClone = new obj.constructor();
	}else{
	objClone = new obj.constructor(obj.valueOf());
	}
	for(var key in obj){
	if ( objClone[key] != obj[key] ){
	if ( typeof(obj[key]) == 'object' ){
	objClone[key] = clone(obj[key]);
	}else{
	objClone[key] = obj[key];
	}
	}
	}
	objClone.toString = obj.toString;
	objClone.valueOf = obj.valueOf;
	return objClone;
	}

// 只允许输入数字
function replaceNotNumber(hehe)
{
  var pattern = /[^0-9|\.]/g;
  if(pattern.test(hehe.value))
  {
    hehe.value = hehe.value.replace(pattern,"");
  }
}
// 点击完成时询问用户
function askPerson(){
	art.dialog({
	    content: '您还需要填写工资的其他模块吗？',
	    lock: true,
        button: [
	        {
	            name: '需要',
	            callback: function () {
	                return ;
	            },
	            focus: true
	        },
	        {
	            name: '不需要',
	            callback: function () {
	        	saveAll(1);
	            }
	        }
	    ]
	});
}