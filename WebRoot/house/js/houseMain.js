// 创建报表图标
var _baobiaoIco = {
    id: 'baobiao',
    name: '全局报表'
};
// 全局报表事件
var BaobiaoOnclick="onOpenOverallReport();onfindOverallWriEveryHouse(window.sessionUID);";
// 是否需要加载全局报表
var _isitBaobiao=true;
// 房产类型
var _houseType=[{id:-1,name:'请选择房产类型'},{id:1,name:'商品房住宅'},{id:2,name:'店铺'},{id:3,name:'仓库'},{id:4,name:'其他商业房'},{id:5,name:'写字楼'},{id:6,name:'自建住房'},{id:7,name:'经济适用房'},
                {id:8,name:'已购公有住房'},{id:9,name:'城镇拆迁安置住房'},{id:10,name:'取得货币补偿后购置房屋'},{id:11,name:'产权调换且取得部分货币补偿后购置房屋'},{id:12,name:'产权调换且支付部分货币后购置房屋'}];
// 城建税级别
var _cityConstructionTax=[{id:0.01,name:'1%'},{id:0.05,name:'5%'},{id:0.07,name:'7%'}];
// 需要修改的房产
var _upHouseObj;
// 存储所有房产信息的变量
var _houseInfo;
// 某房屋在数组中的位置
var _houseInfoTo;
// 存储某房屋
var _onehouse;
// 房产转让状态
var _houseStart=false;
// 存储当前页面房产转让信息
var _houseSellInfo=new Array();
// 页面加载时事件
window.onload = function() {
	// 关闭dwr异步
	DWREngine.setAsync(false);
    // 获取session中的用户ID
    paychexD.getUser(function(data) {
        var id = data["userId"];
        eval("window.sessionUID = id;");
    });
    // 初始化模具
    onFirstImg();
    // 开始加载页面
    onLoadHousePage();
}

// 点击添加承租人
function onOpenczr(){
	//添加之前先清空
	onlznull();
	//弹出
	art.dialog({
		title: "添加",
		content: document.getElementById("chengzuren"),
		lock: true,
		opacity: 0,
		ok:function(){
		onSaveOpenczr();
	},
	    cancelVal: '关闭',
	    cancel: true
		});
}
// 存储一个承租人
var _chengzuren;
// 存储一个承租人ID
var _chengzurenID;
// 是否保存承租人
var _isSaveChengzuren=true;
// 下一步租赁信息
function onSaveOpenczr(){
	if($('rentalName').value!=null && $('rentalName').value!="" &&$('rentalIdNumber').value!=null && $('rentalIdNumber').value!=''){
		// 存储
	_chengzuren={uid:window.sessionUID,rentalName:$('rentalName').value,rentalIdNumber:$('rentalIdNumber').value,rentalIdType:0,rentalImage:'#'};
	// 展开租赁合同登记
	art.dialog({
		title: "添加租赁信息",
		content: document.getElementById("fangchanchuzu"),
		lock: true,
		opacity: 0,
		ok:function(){
		// 存储信息
		onSaveAllChengzu();
	},
	    cancelVal: '关闭',
	    cancel: true
		});
	}else{
		art.dialog({
			title: "警告",
			content: '您没有填写完全'
				});
	}
}
// 续租
function onxuzu(){
	_isSaveChengzuren=false;
	_chengzurenID=window.cooID;
	// 展开租赁合同登记
	art.dialog({
		title: "添加租赁信息",
		content: document.getElementById("fangchanchuzu"),
		lock: true,
		opacity: 0,
		ok:function(){
		// 存储信息
		onSaveAllChengzu();
	},
	    cancelVal: '关闭',
	    cancel: true
		});
}
// 存储所有租赁信息
function onSaveAllChengzu(){
	if($('rentalStartTime').value!=null && $('rentalStartTime')!='' &&$('rentalEndTime').value!=null && $('rentalEndTime')!='' &&$('rentalNumber').value!=null && $('rentalNumber')!='' &&$('rentalRenovation').value!=null && $('rentalRenovation')!='' &&$('rentalTaxed').value!=null && $('rentalTaxed')!=''){
	// 承租人操作
	var _newPop;
	if(_isSaveChengzuren){
		houseData.addRentPopDwr(_chengzuren,function(data){
			if(data!=null)
			_newPop=data.rid;
			else{
				art.dialog({
					title: "警告",
					content: '您没有选择用户'
						});
				return;
			}
		});
	}else{
		// 复位
		_isSaveChengzuren=true;
		_newPop=_chengzurenID;
	}
	// 添加租赁信息
	var _rentalStartTime=$('rentalStartTime').value;
	var _rentalEndTime=$('rentalEndTime').value;
	// 计算一共过了多少月
    var _nian=parseInt(_rentalEndTime.split('-')[0])-parseInt(_rentalStartTime.split('-')[0]);
    var _yue=parseInt(_rentalEndTime.split('-')[1])-parseInt(_rentalStartTime.split('-')[1]);
    var _zong=_yue+_nian*12;
    _zong==0?_zong=1:true;
    if(_zong>=0){
	var _newHouseZu={
			hid:_onehouse.hid,
			uid:window.sessionUID,
			rid:_newPop,
			rentalStartTime:_rentalStartTime,
			rentalEndTime:_rentalEndTime,
			rentalMM:_zong,
			rentalNumber:$("rentalNumber").value,
			rentalRenovation:$('rentalRenovation').value,
			rentalTaxed:$('rentalTaxed').value,
			rentalTaxType:0,
			rentalTaxNumber:0,
			rentalTax:0,
			rentalTaxEndNumber:0
			};
		houseData.addRentInfoDwr(_newHouseZu);
		// 清空
		onlznull();
		art.dialog({id: '_zulinisArt'}).close();
		onOpenZlPage();
	}else{
		art.dialog({
			title: "警告",
			content: '您的结束时间小于开始时间'
				});
	}
	}else{
		art.dialog({
			title: "警告",
			content: '您没有填写完全'
				});
	}
}
// 点击图片时加载方法
var _onloadPageclick;
// 关闭窗口是触发的方法
var _onWindowCloseclick;
// 判断哪个ID触发关闭方法
var _isWindowCloseclickID;
// 租赁窗口关闭时方法
function zlClose(){
	// 触发ID清空
	_isWindowCloseclickID=null;
	onDeleteAllWindow();
	// 需要加载报表
	_isitBaobiao=true;
	// 初始化模具
	onFirstImg();
	// 加载模具
	onLoadHousePage();
	// 从新加载
	onLoadingAllPage("housePage","housePageMain");
	// 删除方法
	_onloadPageclick=null;
	// 取消关闭
	_onWindowCloseclick=null;
}
// 清空操作组
function onDeleteAllWindow(){
	window.pageData=null;
	window.addImg=null;
	window.loadImg=null;
	window.baobiaoImg=null;
	window.lastName=null;
	window.userAddCoo=null;
	window._lodingOnclick=null;
}
// 展开房产租赁时
function onOpenZlPage(){
	// 设置触发ID
	_isWindowCloseclickID='_zulinisArt';
	reviveDiv("housePopPage2","housePopPage1");
	onDeleteAllWindow();
	// 取消加载全局报表
	_isitBaobiao=false;
	// 弹出页面
	art.dialog({
		id:'_zulinisArt',
		title: "房产租赁",
		content: document.getElementById("fangchanchuzuPage"),
		lock: true}
	);
	// 初始化图片组
	onOpenZL();
	// 开始展开
	houseData.isGetRentalInfoDwr(_onehouse.hid,function(data){
		if(data!=null && data.length!=0)
		onfindSingleLessee(window.sessionUID,_onehouse.hid,data[0].rid);
		else
			reviveDiv("wriLesseeReport","wriLesseeReport1");
		window.pageData=isReturnPageData(data,"rid","rentalName");
	});
	j$(function() {
        onServiceLoad("housePopPage2", 150, 810, window.pageData);
    });
}
// 查询该用户的所有已添加承租人
function onOpenZlpop(){
	art.dialog({
		id:"_czr",
		title: "承租人",
		content: document.getElementById("zlpopPage"),
		lock: true
		});
	houseData.isGetUserAllRentalInfoDwr(window.sessionUID,function(data){
		
		DWRUtil.removeAllRows("zlpopTb");
		if(data!=null){
		DWRUtil.addRows("zlpopTb",data,[function(object){
			return "<a href='#' onclick='onSetZlpop(this);' thisobj='"+toJSON(object)+"'/>"+object.rentalName+"</a>";
		}]);
		}else{
			DWRUtil.addRows("zlpopTb",[{a1:1}],[function(object){
				return "您没有添加过承租人信息"+object.rentalName+"</a>";
			}]);
		}
	});
}
// 关闭弹出层，并赋值
function onSetZlpop(data){
	_isSaveChengzuren=false;
	art.dialog({id: '_czr'}).close();
	var _ren;
	eval("_ren="+data.thisobj);
	_chengzurenID=_ren.rid;
	$("rentalName").value=_ren.rentalName;
	$("rentalName").rid=_ren.rid;
	$("rentalIdNumber").value=_ren.rentalIdNumber;
}
// 清空房产租赁各项
function onlznull(){
	$('rentalName').value='';
	$('rentalIdNumber').value='';
	$('rentalStartTime').value='';
	$('rentalEndTime').value='';
	$('rentalNumber').value='';
	$('rentalRenovation').value='';
	$('rentalTaxed').value='';
}
// 房产租赁页面图片路径
function onOpenZL(){
	// 初始化图片路径
	eval("window.addImg = 'house/images/AddUser.png';");
	eval("window.loadImg = 'house/images/User.png';");
	eval("window.baobiaoImg = 'house/images/report2.png';");
	// 初始化房产租赁最后一张图片名称
	eval("window.lastName = '添加承租人'");
	// 设置添加用户按钮
//	var _addUser=[{
//		id:"id1",
//    	image:"house/images/AddUser.png",
//    	imageName:"添加承租人",
//    	onclick:'new Function("onOpenczr();")'
//	}];
	var _addUser="onOpenczr();";
	// 设置用户操作组
	var _userOnclick=[{
    	id:"id1",
    	image:"house/images/fangchanxiugai.png",
    	imageName:"修改",
    	onclick:'new Function("onUpPop();")'
    },
    {
    	id:"id2",
    	image:"house/images/Delete.png",
    	imageName:"删除",
    	onclick:'new Function("onDelHouseRentPopAll();")'
    },
    {
    	id:"id3",
    	image:"house/images/xuzu.png",
    	imageName:"续租",
    	onclick:'new Function("onxuzu();")'
    }];
	// 当点击页面的时候触发
	_onloadPageclick="onfindSingleLessee("+window.sessionUID+","+_onehouse.hid+",a);"
	 // 操作加入至页面栏
    eval("window.userAddCoo=_addUser;");
    eval("window._lodingOnclick=_userOnclick;");
    // 当租赁关闭时
    _onWindowCloseclick="zlClose();";
}
// 初始页面图片路径
function onFirstImg(){
    // 初始化图片路径
    eval("window.addImg = 'house/images/Addhouse.png';");
    eval("window.loadImg = 'house/images/House.png';");
    eval("window.baobiaoImg = 'house/images/report2.png';");
    // 初始化最后一张图片的名称
    eval("window.lastName = '房产管理'");
    // 设置添加房产的按钮
//    var _userAddHouse=[{
//    	id:"id1",
//    	image:"house/images/Addhouse.png",
//    	imageName:"添加房产",
//    	onclick:'new Function("onOpenHouseInfoPage(\'添加房产\');onGetProvince(\'houseCity\');onGethouseType(null);")'
//    }];
    var _userAddHouse="onOpenHouseInfoPage(\'添加房产\');onGetProvince(\'houseCity\');onGethouseType(null);";
    // 设置房产的操作组
    var _houseOnclick=[{
    	id:"id1",
    	image:"house/images/fangchanxiugai.png",
    	imageName:"修改房产",
    	onclick:'new Function("onOpenHouseInfoPage(\'修改房产\');onUpLoadHouseInfo();")'
    },
    {
    	id:"id2",
    	image:"house/images/Delete.png",
    	imageName:"删除房产",
    	onclick:'new Function("onDelHouseInfo();")'
    },
    {
    	id:"id3",
    	image:"house/images/Install.png",
    	imageName:"房产操作",
    	onclick:'new Function("onOpenHouseLabor();")'
    },
    {
    	id:"id4",
    	image:"house/images/report.png",
    	imageName:"查看报表",
    	onclick:'new Function("onOpenRenTraReport();onfindWriHouse(window.sessionUID,window.cooID);remind();")'
    }
    ];
    // 操作加入至页面栏
    eval("window.userAddCoo=_userAddHouse;");
    eval("window._lodingOnclick=_houseOnclick;");
}
// 删除承租人
function onDelHouseRentPopAll(){
	art.dialog({
		lock: true,
	    background: '#666666',
	    opacity: 0.0,
	    icon: 'error',
	    content: '您需要删除该承租人么？',
	    ok: function () {
		art.dialog({
			lock: true,
		    background: '#666666',
		    opacity: 0.2,
		    icon: 'error',
		    content: '本次删除将删除该承租人及该承租人所有合同',
		    ok: function () {
			houseData.delRentPopDwr(window.cooID);
			// 刷新页面
			art.dialog({id: '_zulinisArt'}).close();
			onOpenZlPage();
		    },
		    cancelVal: '关闭',
		    cancel: true
		});
	    },
	    cancelVal: '关闭',
	    cancel: true
	});
}
// 删除单个合同
function onDelOneRent(data){
	if(data!=null){
	art.dialog({
		lock: true,
	    background: '#666666',
	    opacity: 0.0,
	    icon: 'error',
	    content: '您需要删除该合同吗？',
	    ok: function () {
		houseData.delRentInfoDwr(window.wriSingleLessee[data].rhid);
		// 刷新页面
		onfindSingleLessee(window.sessionUID,_onehouse.hid,window.cooID);
		art.dialog({id: '_zulinisArt'}).close();
		onOpenZlPage();
	    },
	    cancelVal: '关闭',
	    cancel: true
	});
	}
}
// 承租人修改
function onUpPop(){
	art.dialog({
		title: "添加",
		content: document.getElementById("chengzuren"),
		lock: true,
		opacity: 0,
		ok:function(){
		onUpOpenczr();
	},
	    cancelVal: '关闭',
	    cancel: true
		});
	for ( var i = 0; i < window.pageData.length; i++) {
		if(window.pageData[i].id==window.cooID){
			var _obj=window.pageData[i].original;
			$('rentalName').value=_obj.rentalName;
			$('rentalIdNumber').value=_obj.rentalIdNumber;
			return false;
		}
	}
}
// 保存修改承租人
function onUpOpenczr(){
	if($('rentalName').value!=null && $('rentalName').value!="" &&$('rentalIdNumber').value!=null && $('rentalIdNumber').value!=''){
		_chengzuren={rid:window.cooID,uid:window.sessionUID,rentalName:$('rentalName').value,rentalIdNumber:$('rentalIdNumber').value,rentalIdType:0,rentalImage:'#'};
		houseData.upRentPopDwr(_chengzuren);
		// 清空
		onlznull();
		//刷新页面
		art.dialog({id: '_zulinisArt'}).close();
		onOpenZlPage();	
	}else{
		art.dialog({
			title: "警告",
			content: '您没有填写完全'
				});	
	}
}
// 修改单个合同
function onUpRentInfoOpen(data){
	_obj=window.wriSingleLessee[data];
	$('rentalStartTime').value=_obj.rentalStartTime;
	$('rentalEndTime').value=_obj.rentalEndTime;
	$('rentalNumber').value=_obj.rentalNumber;
	$('rentalRenovation').value=_obj.rentalRenovation;
	$('rentalTaxed').value=_obj.rentalTaxed;
	// 添加信息
	art.dialog({
		title: "添加租赁信息",
		content: document.getElementById("fangchanchuzu"),
		lock: true,
		opacity: 0,
		ok:function(){
		// 存储信息
		onUpRentInfo(_obj);
		onfindSingleLessee(window.sessionUID,_onehouse.hid,window.cooID);

	},
	    cancelVal: '关闭',
	    cancel: true
		});
}
// 保存修改
function onUpRentInfo(data){
	if($('rentalStartTime').value!=null && $('rentalStartTime')!='' &&$('rentalEndTime').value!=null && $('rentalEndTime')!='' &&$('rentalNumber').value!=null && $('rentalNumber')!='' &&$('rentalRenovation').value!=null && $('rentalRenovation')!='' &&$('rentalTaxed').value!=null && $('rentalTaxed')!=''){
		var _rentalStartTime=$('rentalStartTime').value;
		var _rentalEndTime=$('rentalEndTime').value;
		// 计算一共过了多少月
	    var _nian=parseInt(_rentalEndTime.split('-')[0])-parseInt(_rentalStartTime.split('-')[0]);
	    var _yue=parseInt(_rentalEndTime.split('-')[1])-parseInt(_rentalStartTime.split('-')[1]);
	    var _zong=_yue+_nian*12;
	    _zong==0?_zong=1:true;
	    if(_zong>=0){
		var _newHouseZu={
				rhid:data.rhid,
				hid:_onehouse.hid,
				uid:window.sessionUID,
				rid:window.cooID,
				rentalStartTime:_rentalStartTime,
				rentalEndTime:_rentalEndTime,
				rentalMM:_zong,
				rentalNumber:$("rentalNumber").value,
				rentalRenovation:$('rentalRenovation').value,
				rentalTaxed:$('rentalTaxed').value,
				rentalTaxType:0,
				rentalTaxNumber:0,
				rentalTax:0,
				rentalTaxEndNumber:0
				};
			houseData.upRentInfoDwr(_newHouseZu);
			// 清空
			onlznull();
			art.dialog({id: '_zulinisArt'}).close();
			onOpenZlPage();	
			}
	}else{
		art.dialog({
			title: "警告",
			content: '您没有填写完全'
				});	
	}
}
// 点击房产转让
function onOpenHouseSold(){
	// 获取点击房屋
	_onehouse=onReturnHouseObj();
	if(_onehouse.houseState!=null && _onehouse.houseState==2){
		// 如果是已经转让，询问是否撤销上次转让重新填写
		art.dialog({
			title: "房产操作",
			icon:"warning",
			content: "您已经填写过房产转让信息，是否撤销上次填写内容？",
			lock: true,
			button:[
			{
				name:"撤销",
				callback:function(){
				// 删除该房产转让信息恢复状态
				houseData.delSellHouseDwr(window.cooID);
				// 弹出
				onOpenFCZH(true);
			},
				focus: true
			},
			{
				name:"查看报表",
				callback:function(){ 
				// 弹出报表
				onOpenRenTraReport();
				onfindWriHouse(window.sessionUID,_onehouse.hid);
			}
			},
			{
				name:"修改转让信息",
				callback:function(){ 
				// 弹出报表
				onOpenFCZH(false);
			}
			},
			{
				name:"不撤销"
			}
			],
			opacity: 0
			});
	}else if(_onehouse.houseState==1){
		// 如果是已出租，询问是否提前终止所有该房屋租房合约
		art.dialog({
			title: "房产操作",
			icon:"warning",
			content: "您的该房产现在还在租赁期，是否提前终止租赁合同？",
			lock: true,
			button:[
			{
				name:"是",
				callback:function(){
				// 终止所有的合同到本月
				_houseStart=true;
				// 弹出
				onOpenFCZH(true);
			},
				focus: true
			},
			{
				name:"查看报表",
				callback:function(){
				// 弹出报表
				onOpenRenTraReport();
				onfindWriHouse(window.sessionUID,_onehouse.hid);
			}
			},
			{
				name:"不是"
			}
			],
			opacity: 0
			});
	}else{
		onOpenFCZH(true);
	}
}
// 打开房产转让页面
function onOpenFCZH(data){
	if(data){
	art.dialog({
		title: "房产转让",
		content: document.getElementById("fangchanzhuanrangPage"),
		lock: true,
		opacity: 0,
		ok:function(){onHouseSellSave(true)},
	    cancelVal: '关闭',
	    cancel: true
		});
	// 绑定城建税
	DWRUtil.removeAllOptions("cityConstructionTax");
	DWRUtil.addOptions("cityConstructionTax",_cityConstructionTax,"id","name");
	// 绑定装修费用
	$("ishouseRenovation").value=_onehouse.houseRenovation
	}else{
		// 找到或获取该信息
		var _mouHouseT;
		if(_houseSellInfo==null || _houseSellInfo.length==0){
			houseData.isGetHouseSellAllDwr(_onehouse.hid,function(data){
				_mouHouseT=data;
				_houseSellInfo.unshift(data);
			});
		}else{
			for ( var i = 0; i < _houseSellInfo.length; i++) {
				if(_houseSellInfo[i].hid=_onehouse.hid){
					_mouHouseT=_houseSellInfo[i];
				}
			}
		}
		// 弹出页面
		art.dialog({
			title: "房产转让",
			content: document.getElementById("fangchanzhuanrangPage"),
			lock: true,
			opacity: 0,
			ok:function(){onHouseSellSave(false)},
		    cancelVal: '关闭',
		    cancel: true
			});
		// 绑定数据
		$('transferTime').value=_mouHouseT.transferTime;
		$('transferNumber').value=_mouHouseT.transferNumber;
		$("ishouseRenovation").value=_onehouse.houseRenovation;
		$('Intermediary').value=_mouHouseT.intermediary;
		// 绑定城建税
		DWRUtil.removeAllOptions("cityConstructionTax");
		for ( var j = 0; j < _cityConstructionTax.length; j++) {
			if(_cityConstructionTax[j].id==_mouHouseT.cityConstructionTax)
			{
				DWRUtil.addOptions("cityConstructionTax",[_cityConstructionTax[j]],"id","name");
			}
		}
		DWRUtil.addOptions("cityConstructionTax",_cityConstructionTax,"id","name");
	}
}
// 保存房产转让
function onHouseSellSave(data){
	if(onSetHouseSell()){
	if(_houseStart){
		// 房产租赁截止日期修改
		houseData.upAllRantDwr({hid:_onehouse.hid,rentalEndTime:$("transferTime").value});
	}
	if($('ishouseRenovation').value!=_onehouse.houseRenovation){
		// 修改装修费用
		_onehouse.houseRenovation=$('ishouseRenovation').value;
		_houseInfo[_houseInfoTo].original.houseRenovation=$('ishouseRenovation').value;
		houseData.upHouseDwr(_onehouse);
	}
	// 返回税款
	var _houseSell={htid:0,hid:_onehouse.hid,uid:_onehouse.uid,taxType:0,transferNumber:$('transferNumber').value,transferTime:$("transferTime").value,cityConstructionTax:$('cityConstructionTax').value,taxEdNumber:0,transferTaxNumber:0,tranceferTax:0,transferEndNumber:parseFloat($('transferNumber').value)-parseFloat($('Intermediary').value)-0,intermediary:$('Intermediary').value,tax1:0,tax2:0,tax3:0,tax4:0,tax5:0,tax6:0};
	if(data){
	// 存储
	houseData.addSellHouseDwr(_houseSell);
	// 将其放入数组
	_houseSellInfo.unshift(_houseSell);
	// 修改当前页某房屋状态为已转让
	_houseInfo[_houseInfoTo].original.houseState=2;
	}else{
		// 修改
		houseData.upSellHouseDwr(_houseSell);
		for ( var i = 0; i < _houseSellInfo.length; i++) {
			if(_houseSellInfo[i].hid=_houseSell.hid){
				_houseSellInfo[i]=_houseSell;
			}
		}
	}
	// 清空页面
	$('transferTime').value=""; $('transferNumber').value=""; $('ishouseRenovation').value=""; $('Intermediary').value="";
	}else{
		art.dialog({
			lock: true,
			content: "您没有填写完全"
		});
	}
}
// 判断房产转让是否填全
function onSetHouseSell(){
	if($('transferTime').value!=null && $('transferTime').value!="" && $('transferNumber').value!=null && $('transferNumber').value!="" && $('ishouseRenovation').value!=null && $('ishouseRenovation').value!="" && $('Intermediary').value!=null && $('Intermediary').value!=""){
		return true;
	}else{
		return false;
	}
}
// 返回列表中某一个房产的对象
function onReturnHouseObj(){
	for ( var i = 0; i < _houseInfo.length; i++) {
		if(_houseInfo[i].original!=null)
		if (_houseInfo[i].original.hid==window.cooID) {
			_houseInfoTo=i;
			return clone(_houseInfo[i].original);
		}
	}
}
// 房产操作页面
function onOpenHouseLabor(){
	// 同时更新模具
	_houseInfo=window.pageData;
	// 获取房屋
	_onehouse=onReturnHouseObj();
	// 弹出页面
	art.dialog({
		title: "房产操作",
		content: document.getElementById("Houselabor"),
		lock: true,
		opacity: 0
		});
}
// 加载房产管理页面
function onLoadHousePage(){
	if(_houseInfo==null){
		// 访问数据库取出数据
	houseData.isGetHouseDwr(window.sessionUID,function(data){
		if(data!=null && data.length!=0){
			var _houseAll=isReturnPageData(data,"hid","houseName");
			// 装载进模具
			eval("window.pageData=_houseAll");
			// 并加入全局报表
			window.pageData.unshift(_baobiaoIco);
		}else{
			eval("window.pageData=null;");
		}
	});
	}else{
		// 装载进模具
		var _houseAll=clone(_houseInfo);
		eval("window.pageData=_houseAll");
		// 并加入全局报表
		window.pageData.unshift(_baobiaoIco);
	}
	// 加载页面
	j$(function() {
        onServiceLoad("housePage", 610, 830, window.pageData);
    });
}
// 是添加房产还是修改房产
function onOpenHouseInfoPage(str){
	if(str=='添加房产'){
		onOpenAllPage("addHouseInfoPageArt",str,"addHouseInfoPage",function(){
			// 存储房产信息方法
			var _a=onSaveHouseInfo();
			if(_a==1){
				art.dialog({content: '该房屋已存在', lock: true});
				return false;
			}else if(_a==2){
				art.dialog({content: '您没有填写完全', lock: true});
				return false;
			}
		});
	}else{
		onOpenAllPage("addHouseInfoPageArt",str,"addHouseInfoPage",function(){
			// 修改房产信息方法
			onUpHouseInfo();
		});
	}
}
// 取消或关闭
function onCloseHouseInfoPage(){
	// 清空input
	$('houseName').value="" ; $('houseTime').value="" ; $('compensationDisplay').value="" ;  $('houseArea').value="" ;$('houseNumber').value="" ;  $('housetaxedNumber').value="" ;  $('houseRenovation').value="" ; $('houseAllNumber').value="";
// art.dialog.list["addHouseInfoPageArt"].title('数据已存储').time(0.5);
	// 从新加载
	onLoadingAllPage("housePage","housePageMain");

}
// 存储房产信息
function onSaveHouseInfo(){
	if(onReturnAddHousePageIsfine()){
		var _a;
		var _houseTaxType=onReturnHouseTaxType("houseTaxType",null);
		var _houseAllNumber=onhouseAllNumber();
		var _houseSingleNumber=parseFloat($("houseNumber").value)/parseFloat($('houseArea').value);
		var _housetaxedNumber=$('housetaxedNumber').value;
		var _houseInfoSerivce={
				hid:0,
				uid:window.sessionUID,
				houseName:$('houseName').value,
				houseAdd:$('houseAdd').value,
				houseTime:$('houseTime').value,
				houseType:$('houseType').value,
				houseCompensation:$('houseCompensation').value,
				houseArea:$("houseArea").value,
				houseNumber:$('houseNumber').value,
				houseSingleNumber:_houseSingleNumber,
				houseTaxedNumber:_housetaxedNumber,
				houseTaxType:_houseTaxType,
				houseRenovation:$('houseRenovation').value,
				houseAllNumber:_houseAllNumber,
				houseState:0
				};
		houseData.addHouseDwr(_houseInfoSerivce,function(data){
			if(data!=null){
			var _newHouse={id:data.hid,name:data.houseName,original:data};
			// 将新房屋装入
			if(window.pageData==null)
				window.pageData=new Array();
			window.pageData.unshift(_newHouse);
			if(window.pageData.length==1){
				// 并加入全局报表
				window.pageData.unshift(_baobiaoIco);
			}
			// 关闭页面
			onCloseHouseInfoPage();
			}else{
				_a=1;
			}
		});
	}else{
		_a=2;
	}
	return _a;
}
// 删除房产
function onDelHouseInfo(){
	art.dialog({
		lock: true,
	    background: '#666666',
	    opacity: 0.0,
	    icon: 'error',
	    content: '您需要删除该房产么？',
	    ok: function () {
		art.dialog({
			lock: true,
		    background: '#666666',
		    opacity: 0.2,
		    icon: 'error',
		    content: '本次删除将删除该房产目录下所有数据',
		    ok: function () {
			for ( var i = 0; i < window.pageData.length; i++) {
			if(window.pageData[i].id==window.cooID){
				// 数据库内删除
				houseData.delHouseDwr(window.pageData[i].original);
				window.pageData.splice(i, 1);
			}
		}
			if (window.pageData.length == 1) {
				window.pageData = null;
            }
			// 从新加载
			onLoadingAllPage("housePage","housePageMain");
		    },
		    cancelVal: '关闭',
		    cancel: true
		});
	    },
	    cancelVal: '关闭',
	    cancel: true
	});
}
// 修改房产
function onUpLoadHouseInfo(){
	for ( var i = 0; i < window.pageData.length; i++) {
		if(window.pageData[i].id==window.cooID){
			_upHouseObj=i;
			// 绑定页面
			var _number=window.pageData[i].original.houseTaxedNumber;
			$('houseName').value=window.pageData[i].original.houseName;
			onGetLaborAddName(window.pageData[i].original.houseAdd,"houseCity","houseAdd");
			$('houseTime').value=window.pageData[i].original.houseTime;
			onGethouseType(window.pageData[i].original.houseType);
			oncompensationDisplay();
			$('houseCompensation').value=window.pageData[i].original.houseCompensation;
			$('houseArea').value=window.pageData[i].original.houseArea;
			$('houseNumber').value=window.pageData[i].original.houseNumber;
			document.getElementById("housetaxedNumber").value=_number;
			$('houseRenovation').value=window.pageData[i].original.houseRenovation;
			$('houseAllNumber').value=window.pageData[i].original.houseAllNumber;
			onReturnHouseTaxType("houseTaxType",window.pageData[i].original.houseTaxType);
		}
	}
}
// 确认修改
function onUpHouseInfo(){
	var _houseTaxType=onReturnHouseTaxType("houseTaxType",null);
	var _houseAllNumber=onhouseAllNumber();
	var _houseSingleNumber=parseFloat($("houseNumber").value)/parseFloat($('houseArea').value);
	var _housetaxedNumber=$('housetaxedNumber').value;
	var _houseInfoSerivce={
			hid:window.cooID,
			uid:window.sessionUID,
			houseName:$('houseName').value,
			houseAdd:$('houseAdd').value,
			houseTime:$('houseTime').value,
			houseType:$('houseType').value,
			houseCompensation:$('houseCompensation').value,
			houseArea:$("houseArea").value,
			houseNumber:$('houseNumber').value,
			houseSingleNumber:_houseSingleNumber,
			houseTaxedNumber:_housetaxedNumber,
			houseTaxType:_houseTaxType,
			houseRenovation:$('houseRenovation').value,
			houseAllNumber:_houseAllNumber,
			houseState:0
			};
	if(_houseInfoSerivce!=window.pageData[_upHouseObj].original){
		for ( var i = 0; i < window.pageData.length; i++) {
			if(window.pageData[i].id==window.cooID){
				window.pageData[i].name=_houseInfoSerivce.houseName;
				_houseInfoSerivce.houseState=window.pageData[i].original.houseState;
				window.pageData[i].original=_houseInfoSerivce;
			}
			}
		// 修改数据库
		houseData.upHouseDwr(_houseInfoSerivce);
	}
	// 关闭页面
	onCloseHouseInfoPage();
}
// 遍历数据源返回结构
function isReturnPageData(indata,id,name){
	if(indata!=null){
		var outData=new Array();
		for ( var i = 0; i < indata.length; i++) {
			var obj={
					id:eval("indata[i]."+id),
					name:eval("indata[i]."+name),
					original:indata[i]
			}
			outData.unshift(obj);
		}
		return outData;
	}else{
		return null;
	}
}
// 绑定房产类型
function onGethouseType(id){
	if(id==null){
	DWRUtil.removeAllOptions("houseType");
	DWRUtil.addOptions("houseType",_houseType,"id","name");
	}
	else{
		for ( var i = 0; i < _houseType.length; i++) {
			if(_houseType[i].id==id){
				// 获取锁定对象
				var _type=_houseType[i];
			}
		}
		var _newType=_houseType.concat();
		_newType.unshift(_type);
		DWRUtil.removeAllOptions("houseType");
		DWRUtil.addOptions("houseType",_newType,"id","name");
	}
}
// 获取省
function onGetProvince(id) {
    paychexD.getProvince(1,
    function(data) {
        DWRUtil.removeAllOptions(id);
        DWRUtil.addOptions(id, [{
            pid: '-1',
            provinceName: '请选择省份'
        }], 'pid', 'provinceName');
        DWRUtil.addOptions(id, data, 'pid', 'provinceName');
    });
}
// 获取市
function onGetCity(value,id) {
    paychexD.getCity(value,
    function(data) {
        DWRUtil.removeAllOptions(id);
        DWRUtil.addOptions(id, [{
            cid: '-1',
            langName: '请选择城市'
        }], 'cid', 'langName');
        DWRUtil.addOptions(id, data, 'cid', 'langName');
    });
}
// 以市求省求国家
function onGetLaborAddName(cid,cityID,addID) {
    paychexD.getCityToProvinceToNation(cid,
    function(data) {
        DWRUtil.removeAllOptions(cityID);
        DWRUtil.removeAllOptions(addID);
        DWRUtil.addOptions(cityID, [{
            pid: data.pid,
            provinceName: data.provinceName
        }], 'pid', 'provinceName');
        DWRUtil.addOptions(addID, [{
            cid: data.cid,
            langName: data.cityLangName
        }], 'cid', 'langName');
    });
    paychexD.getProvince(cid,
    function(data) {
        DWRUtil.addOptions(cityID, data, 'pid', 'provinceName');
    });
}
// 现实隐藏补偿款项
function oncompensationDisplay(){
	var dis=document.getElementById("compensationDisplay");
	if($('houseType').value==10){
		dis.style.display="block";
	}else if($('houseType').value==11){
		dis.style.display="block";
	}else if($('houseType').value==12){
		dis.style.display="block";
	}else{
		dis.style.display="none";
	}
}
// 房产总价值
function onhouseAllNumber(){
	var _allNumber=parseFloat($('houseNumber').value)+parseFloat($('housetaxedNumber').value)+parseFloat($('houseRenovation').value);
	$('houseAllNumber').value=_allNumber;
	return _allNumber;
}
// 获取选中哪个
function onReturnHouseTaxType(name,value){
	for (var int = 0; int < document.getElementsByName(name).length; int++) {
		if(value==null){
		if(document.getElementsByName(name)[int].checked){
			return document.getElementsByName(name)[int].value;
		}
		}else{
			if(document.getElementsByName(name)[int].value==value){
				document.getElementsByName(name)[int].checked=true;
			}else{
				document.getElementsByName(name)[int].checked=false;
			}
		}
	}
}
// 判断增加房产填写完全
function onReturnAddHousePageIsfine(){
	if($('houseName').value!=null && $('houseName').value!="" && $('houseAdd').value!=-1 && $('houseTime').value!=null && $('houseTime').value!="" && $('houseType').value!=-1 && $('houseCompensation').value!=null && $('houseArea').value!=null && $('houseArea').value!="" && $('houseNumber').value!=null && $('houseNumber').value!="" && $('housetaxedNumber').value!=null && $('housetaxedNumber').value!="" && $('houseRenovation').value!=null && $('houseRenovation').value!="" && $('houseAllNumber').value!=null && $('houseAllNumber').value!=""){
		return true;		
	}else{
		return false;
	}
}
// 重新构建div
function reviveDiv(delDiv, inDiv) {
    var div = document.getElementById(delDiv);
    div.parentNode.removeChild(div);
    document.getElementById(inDiv).innerHTML += "<div id='" + delDiv + "'></div>";
}
// 只允许输入数字
function replaceNotNumber(hehe) {
    var pattern = /[^0-9|\.]/g;
    if (pattern.test(hehe.value)) {
        hehe.value = hehe.value.replace(pattern, "");
    }
}
// 弹出窗体
function onOpenAllPage(artid,titleName,pageID,okFunctoin){
	art.dialog({
		id:artid,
	    title: titleName,
		content: document.getElementById(pageID),
	     ok: okFunctoin,
	     cancelVal: '关闭',
	     cancel: function(){
		onCloseHouseInfoPage();
	},
	     lock: true
	});
}
// 重新加载页面
function onLoadingAllPage(delDiv,inDiv){
	// 重构主DIV
	reviveDiv(delDiv, inDiv);
	// 加载页面
	j$(function() {
        onServiceLoad("housePage", 610, 830, window.pageData);
    });
}



// 打开全局报表
function onOpenOverallReport(){
	art.dialog({
		title: "所有房产综合报表",
		content: document.getElementById("quanJu"),
		ok:function(){
		    this.title('3秒后自动关闭').time(3);
	        return false;
        },
        cancelVal: '关闭',
		cancel: true 
	   }
	);
}

// 打开某房产租赁与转让合并的报表
function onOpenRenTraReport(){
	art.dialog({
		title: "出租转让信息",
		content: document.getElementById("renTra"),
		ok:function(){
		    this.title('3秒后自动关闭').time(3);
	        return false;
        },
        cancelVal: '关闭',
		cancel: true 
	   }
	);
}
// 深度克隆对象
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

// 转换json
function toJSON(txtOrObj, hasIndent) {
	var data = txtOrObj;
	if (typeof data == 'string')
		try {
			data = eval('(' + data + ')')
		} catch (e) {
			return ""
		}
	;
	var draw = [], last = false, isLast = true, indent = 0;
	function notify(name, value, isLast, formObj) {
		if (value && value.constructor == Array) {
			draw.push((formObj ? ('"' + name + '":') : '') + '[');
			for ( var i = 0; i < value.length; i++)
				notify(i, value[i], i == value.length - 1, false);
			draw.push(']' + (isLast ? '' : (',')));
		} else if (value && typeof value == 'object') {
			draw.push((formObj ? ('"' + name + '":') : '') + '{');
			var len = 0, i = 0;
			for ( var key in value)
				len++;
			for ( var key in value)
				notify(key, value[key], ++i == len, true);
			draw.push('}' + (isLast ? '' : (',')));
		} else {
			if (typeof value == 'string')
				value = '"' + value + '"';
			draw.push((formObj ? ('"' + name + '":') : '') + value
					+ (isLast ? '' : ','));
		}
		;
	}
	;
	notify('', data, isLast, false);
	return draw.join('');
};

//提醒用户留意房屋租赁合同是否修改过
function remind(){
    art.dialog.notice({
        title: '请注意',
        width: 220,// 必须指定一个像素宽度值或者百分比，否则浏览器窗口改变可能导致artDialog收缩
        content: '尊敬的用户，请留意您的房屋租赁合同是否修改过！',
        //icon: 'face-sad',
        time: 5
    });
}

artDialog.notice = function (options) {
    var opt = options || {},
        api, aConfig, hide, wrap, top,
        duration = 800;
        
    var config = {
        id: 'Notice',
        left: '100%',
        top: '100%',
        fixed: true,
        drag: false,
        resize: false,
        follow: null,
        lock: false,
        init: function(here){
            api = this;
            aConfig = api.config;
            wrap = api.DOM.wrap;
            top = parseInt(wrap[0].style.top);
            hide = top + wrap[0].offsetHeight;
            
            wrap.css('top', hide + 'px')
                .animate({top: top + 'px'}, duration, function () {
                    opt.init && opt.init.call(api, here);
                });
        },
        close: function(here){
            wrap.animate({top: hide + 'px'}, duration, function () {
                opt.close && opt.close.call(this, here);
                aConfig.close = $.noop;
                api.close();
            });
            
            return false;
        }
    };	
    
    for (var i in opt) {
        if (config[i] === undefined) config[i] = opt[i];
    };
    
    return artDialog(config);
};