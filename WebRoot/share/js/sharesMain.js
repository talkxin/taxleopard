// 创建报表图标
var _baobiaoIco = {
	id : 'baobiao',
	name : '全局报表'
};
// 窗口关闭事件
var _isWindowCloseclickID = "all";
var _onWindowCloseclick = "allNullPage();";
// 全局报表事件
var BaobiaoOnclick="onOpenFullSharesReport();onfindFullFirst(window.sessionUID)";
// 是否需要加载全局报表
var _isitBaobiao = true;
// 点击某些图片时加载
_onloadPageclick = null;

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
	onLoadPage();
}
// 筛选器
var _isOnloadImgMap;

// 初始页面图片路径
function onFirstImg() {
	// 股票管理图标
	window.addImg = 'share/images/zonggupiaoapp.png';
	// 全局报表图标
	window.baobiaoImg = 'share/images/report2.png';
	// 默认图标
	window.loadImg = 'share/images/gupiao.png';
	// 股票管理名称
	window.lastName = '股票管理';
//	window.userAddCoo = [ {
//		id : "id1",
//		image : "share/images/gupiaoappadd.png",
//		imageName : "添加股票",
//		onclick : 'new Function("openAddSharesOne();")'
//	} ];
	window.userAddCoo="openAddSharesOne();";
	// 默认图片加载方法
	window._lodingOnclick = [ {
		id : 'id1',
		image : 'share/images/update.png',
		imageName : '修改信息',
		onclick : 'new Function("onUpAllShares();")'
	}, {
		id : 'id2',
		image : 'share/images/Delete.png',
		imageName : '删除',
		onclick : 'new Function("deltetAllSharesOpen();")'
	}, {
		id : 'id3',
		image : 'share/images/Install.png',
		imageName : '操作',
		onclick : 'new Function("caozuoPage()")'
	}, {
		id : 'id4',
		image : 'share/images/report.png',
		imageName : '报表',
		onclick : 'new Function("onOpenSharesReport();onfindShareMessage(window.sessionUID,window.cooID);")'
	} ]
	// 初始化图片筛选器
	_isOnloadImgMap = new JHashMap();
	// 股权操作组
	var _guquan = {
		loadImg : 'share/images/guquan.png',
		lodingOnclick : null
	};
	var _gupiao = {
		loadImg : 'share/images/gupiao.png',
		lodingOnclick : null
	};
	// 加入筛选器
	_isOnloadImgMap.put(null, _lodingOnclick);
	_isOnloadImgMap.put(0, _gupiao);
	_isOnloadImgMap.put(1, _guquan);
	_isOnloadImgMap.put(2, _gupiao);
}
// 存放所有股票的变量值
var _PageData;
// 存放所有股票的变量的HashMap
var _PageDataMap = new JHashMap();
// 加载页面方法
function onLoadPage() {
	// 初始化pageData
	var _data;
	if (_PageData == null) {
		sharesData.isGetShareInfo(window.sessionUID, function(data) {
			if (data != null && data.length != 0) {
				_data = data;
				// 装入模具
				_PageData = isReturnPageData(data, 'sid', 'sharesName',
						'sharesType');
				_PageData.unshift(_baobiaoIco);
			}
		});
	}
	// 加载页面
	j$(function() {
		onServiceLoad("sharePage", 610, 830, _PageData);
	});
	// 装载以后触发的事件
	guquanxingquan(_data);
}
// 提示是否有股权到了行权日
function guquanxingquan(data) {
	if (data != null) {
		var _tishi = '';
		for ( var i = 0; i < data.length; i++) {
			if (data[i].sharesType != 1) {
				if (data[i].sharesType2 == null) {
					_tishi = _tishi + '  ' + data[i].sharesName;
				}
			}
		}
		if (_tishi != '') {
			art.dialog({
				title : '警告',
				content : '您的' + _tishi + '已经到了行权期,请修改该股票的股票类型',
				icon : 'warning'
			});
		}
	}
}
// 某股票的对象
var _oneShares = new Object();
// 添加股票第一步
function openAddSharesOne() {
	art.dialog({
		title : "添加向导",
		content : document.getElementById("addSharesOne"),
		lock : true,
		opacity : 0,
		ok : function() {
			openAddSharesTwo();
		},
		okVal : '下一步',
		cancelVal : '关闭',
		cancel : true
	});
}
var _sharesType2 = [ {
	id : 0,
	name : '普通股票'
}, {
	id : 1,
	name : '限售股'
}, {
	id : 2,
	name : '企业量化资产股'
} ];
var _sharesAdd = [ {
	id : 0,
	name : '上海'
}, {
	id : 1,
	name : '深圳'
}, {
	id : 2,
	name : '香港'
}, {
	id : 3,
	name : '美国'
}, {
	id : 4,
	name : '其他'
} ];
// 添加股票第二步
function openAddSharesTwo() {
	// 获取UID及选中的类型
	_oneShares.uid = window.sessionUID;
	_oneShares.sharesType = onReturnHouseTaxType('sharesType');
	// 选择弹出的页面
	var _page;
	var _title;
	if (_oneShares.sharesType == 0 || _oneShares.sharesType == 2) {
		_page = document.getElementById("gupiaoAdd");
		_title = '添加股票';
		bangDingType(_sharesType2, 'sharesType2');
		bangDingType(_sharesAdd, 'sharesAdd');
	} else {
		_page = document.getElementById("guquanAdd");
		_title = '添加股权';
		bangDingType(_sharesAdd, 'sharesAddE');
	}
	// 进行弹出
	art.dialog({
		title : _title,
		content : _page,
		lock : true,
		opacity : 0,
		ok : function() {
			saveSharesInfo();
		},
		okVal : '保存',
		cancelVal : '关闭',
		cancel : true
	});
}
// 保存股票信息
function saveSharesInfo() {
	if (_oneShares.sharesType == 0 || _oneShares.sharesType == 2) {
		_oneShares.uid = window.sessionUID;
		_oneShares.sharesName = $('sharesName').value;
		_oneShares.equityType = 0;
		_oneShares.sharesType2 = $('sharesType2').value;
		_oneShares.sharesAdd = $('sharesAdd').value;
		_oneShares.sharesInTime = $('sharesInTime').value;
		_oneShares.sharesNumber = $('sharesNumber').value;
		_oneShares.sharesAllNumber = $('sharesNumber').value;
		_oneShares.sharesInDayNumber = $('sharesInDayNumber').value;
		_oneShares.taxedNumber = $('taxedNumber').value;
		_oneShares.equityOutDay = '';
	} else {
		_oneShares.uid = window.sessionUID;
		_oneShares.sharesName = $('sharesNameE').value;
		_oneShares.equityType = onReturnHouseTaxType('equityType');
		_oneShares.sharesType2 = 0;
		_oneShares.sharesAdd = $('sharesAddE').value;
		_oneShares.sharesInTime = $('sharesInTimeE').value;
		_oneShares.sharesNumber = $('sharesNumberE').value;
		_oneShares.sharesAllNumber = $('sharesNumber').value;
		_oneShares.sharesInDayNumber = $('sharesInDayNumberE').value;
		_oneShares.taxedNumber = '';
		_oneShares.equityOutDay = $('equityOutDay').value;
	}
	sharesData.addSharesInfo(_oneShares, function(data) {
		if (data != null) {
			var _newShares = {
				id : data.sid,
				name : data.sharesName,
				type : data.sharesType,
				original : data
			};
			if (_PageData == null) {
				_PageData = new Array();
				_PageData.unshift(_baobiaoIco);
			}
			// 将新的加入进数组
			_PageData.unshift(_newShares);
			// 刷新页面
			onLoadingAllPage('sharePage', 'shareMain');
		} else {
			onErroeAlert('您已经添加过该股票');
		}
	});
	// 清空对象
	_oneShares = new Object();
	// 清空页面
	allNullPage();
}
// 删除股票或股权
function deltetAllSharesOpen() {
	art.dialog({
		lock : true,
		background : '#666666',
		opacity : 0.0,
		icon : 'error',
		content : '您需要删除该股票么？',
		ok : function() {
			art.dialog({
				lock : true,
				background : '#666666',
				opacity : 0.2,
				icon : 'error',
				content : '本次删除将删除该股票及该股票所有信息',
				ok : function() {
					deltetAllShares();
				},
				cancelVal : '关闭',
				cancel : true
			});
		},
		cancelVal : '关闭',
		cancel : true
	});
}
// 确认删除
function deltetAllShares() {
	for ( var i = 0; i < _PageData.length; i++) {
		if (_PageData[i].original != null) {
			if (_PageData[i].original.sid == window.cooID) {
				// 删除数组内
				_PageData.splice(i, 1);
				// 删除数据库
				sharesData.delSharesInfo(window.cooID);
				if (_PageData.length == 1)
					_PageData = null;
				// 刷新页面
				onLoadingAllPage('sharePage', 'shareMain');
				return true;
			}
		}
	}
}
// 修改页面
function onUpAllShares() {
	// 选择弹出的页面
	for ( var i = 0; i < _PageData.length; i++) {
		if (_PageData[i].original != null) {
			if (_PageData[i].original.sid == window.cooID) {
				var _page;
				var _title;
				var _onClickFunction;
				allPageBang(_PageData[i].original);
				if (_PageData[i].original.sharesType == 0
						|| _PageData[i].original.sharesType == 2) {
					_page = document.getElementById("gupiaoAdd");
					_title = '修改股票信息';
					bangDingType(_sharesType2, 'sharesType2',
							_PageData[i].original.sharesType2);
					bangDingType(_sharesAdd, 'sharesAdd',
							_PageData[i].original.sharesAdd);
					_onClickFunction = 0;
				} else {
					_page = document.getElementById("guquanAdd");
					_title = '修改股权信息';
					bangDingType(_sharesAdd, 'sharesAddE',
							_PageData[i].original.sharesAdd);
					onReturnHouseTaxType('equityType',
							_PageData[i].original.equityType);
					_onClickFunction = 1;
				}
				// 进行弹出
				art.dialog({
					title : _title,
					content : _page,
					lock : true,
					opacity : 0,
					ok : function() {
						if (_onClickFunction == 0)
							saveUpShares(0, i);
						else if (_onClickFunction == 1)
							saveUpShares(1, i);
					},
					okVal : '确定修改',
					cancelVal : '关闭',
					cancel : true
				});
				return false;
			}
		}
	}
}
// 保存修改
function saveUpShares(str, i) {
	if (str == 0) {
		// 修改数组
		_PageData[i].original.uid = window.sessionUID;
		_PageData[i].original.sharesName = $('sharesName').value;
		_PageData[i].original.equityType = 0;
		_PageData[i].original.sharesType2 = $('sharesType2').value;
		_PageData[i].original.sharesAdd = $('sharesAdd').value;
		_PageData[i].original.sharesInTime = $('sharesInTime').value;
		_PageData[i].original.sharesNumber = $('sharesNumber').value;
		_PageData[i].original.sharesAllNumber = $('sharesNumber').value;
		_PageData[i].original.sharesInDayNumber = $('sharesInDayNumber').value;
		_PageData[i].original.taxedNumber = $('taxedNumber').value;
		_PageData[i].original.equityOutDay = '';
		sharesData.upShares(_PageData[i].original);
	} else if (str == 1) {
		_PageData[i].original.uid = window.sessionUID;
		_PageData[i].original.sharesName = $('sharesNameE').value;
		_PageData[i].original.equityType = onReturnHouseTaxType('equityType');
		_PageData[i].original.sharesType2 = 0;
		_PageData[i].original.sharesAdd = $('sharesAddE').value;
		_PageData[i].original.sharesInTime = $('sharesInTimeE').value;
		_PageData[i].original.sharesNumber = $('sharesNumberE').value;
		_PageData[i].original.sharesAllNumber = $('sharesNumber').value;
		_PageData[i].original.sharesInDayNumber = $('sharesInDayNumberE').value;
		_PageData[i].original.taxedNumber = '';
		_PageData[i].original.equityOutDay = $('equityOutDay').value;
		sharesData.upEquity(_PageData[i].original);
	}
	return true;
}
// 页面操作
function caozuoPage() {
	// 选择弹出的页面
	var _document = null;
	for ( var i = 0; i < _PageData.length; i++) {
		if (_PageData[i].original != null) {
			if (_PageData[i].original.sid == window.cooID) {
				if (_PageData[i].original.sharesType == 0
						|| _PageData[i].original.sharesType == 2) {
					// 股票操作栏
					_document = document.getElementById("gupiaocaozuo");
				} else {
					// 股权操作栏
					_document = document.getElementById("guquancaozuo");
				}
			}
		}
	}
	art.dialog({
		title : '操作',
		content : _document,
		lock : true,
		opacity : 0
	});
}
// 清空页面
function allNullPage() {
	$('sharesName').value = '';
	$('sharesInTime').value = '';
	$('sharesNumber').value = '';
	$('sharesInDayNumber').value = '0';
	$('taxedNumber').value = '0';
	$('sharesNameE').value = '';
	$('sharesInTimeE').value = '';
	$('sharesNumberE').value = '';
	$('sharesInDayNumberE').value = '0';
	$('equityOutDay').value = '';
}
// 绑定内容
function allPageBang(data) {
	$('sharesName').value = data.sharesName;
	$('sharesInTime').value = data.sharesInTime;
	$('sharesNumber').value = data.sharesNumber;
	$('sharesInDayNumber').value = data.sharesInDayNumber;
	$('taxedNumber').value = data.taxedNumber;
	$('sharesNameE').value = data.sharesName;
	$('sharesInTimeE').value = data.sharesInTime;
	$('sharesNumberE').value = data.sharesNumber;
	$('sharesInDayNumberE').value = data.sharesInDayNumber;
	$('equityOutDay').value = data.equityOutDay;
}
// 弹出追加股权
var _lishiData = new Array();
var _zhuijiaType;
function Onzhuijiaguquan(data) {
	if (_isSaveOrUpZhuijia == 'update') {
		for ( var i = 0; i < _lishiData.length; i++) {
			if (_lishiData[i].eiid == _eiid) {
				$('sharesInTimezhui').value = _lishiData[i].sharesInTime;
				$('sharesInNumber').value = _lishiData[i].sharesInNumber;
				$('sharesInPrice').value = _lishiData[i].sharesInPrice;
				$('InOtherCost').value = _lishiData[i].inOtherCost;
			}
		}
	}
	data = window.cooID + ',' + data;
	// 判断是股权还是股票
	if (data != _zhuijiaType) {
		if (data.split(",")[1] == 0) {
			document.getElementById("xingquanri").style.display = "none";
		} else {
			document.getElementById("xingquanri").style.display = "block";
			for ( var i = 0; i < _PageData.length; i++) {
				if (_PageData[i].id == window.cooID) {
					var _a = _PageData[i].original;
					$('newequityOutDay').value = _a.equityOutDay;
				}
			}
		}
	}
	_zhuijiaType = data;
	art.dialog({
		id : 'onSharesZhuiPage',
		title : '详情',
		content : document.getElementById("zhuijiapage")
	});
	sharesData.isGetGupiaolishi(window.cooID, function(data) {
		_lishiData = data;
	});
	DWRUtil.removeAllRows("lishiList");
	DWRUtil.addRows("lishiList", _lishiData, [
			function(data) {
				return data.sharesInTime;
			},
			function(data) {
				return data.sharesInNumber;
			},
			function(data) {
				return data.sharesInPrice;
			},
			function(data) {
				return data.inOtherCost;
			},
			function(data) {
				return "<a href='#' onclick='onUpZhuijia(" + data.eiid
						+ ")'>修改</a><a href='#' onclick='delzhuijia("
						+ data.eiid + ")'>删除</a>";
			} ]);
}
// 保存追加
var _isSaveOrUpZhuijia = 'save';
function onSaveZhuijia() {
	// 判断是保存命令还是修改命令
	if (_zhuijiaType != null && _zhuijiaType.split(",")[1] != 0) {
		for ( var i = 0; i < _PageData.length; i++) {
			if (_PageData[i].id == _zhuijiaType.split(",")[0]) {
				var _a = _PageData[i].original;
				if (_a.equityOutDay != $('newequityOutDay').value) {
					_a.equityOutDay = $('newequityOutDay').value;
					sharesData.upShares(_a);
				}
			}
		}
	}
	var _obj = new Object();
	_obj.sid = window.cooID;
	_obj.uid = window.sessionUID;
	_obj.sharesInTime = $('sharesInTimezhui').value;
	_obj.sharesInNumber = $('sharesInNumber').value;
	_obj.sharesInPrice = $('sharesInPrice').value;
	_obj.inOtherCost = $('InOtherCost').value;
	if (_isSaveOrUpZhuijia == 'save')
		sharesData.addSharesIn(_obj);
	else {
		_isSaveOrUpZhuijia = 'save';
		_obj.eiid = _eiid;
		sharesData.upSharesIn(_obj);
	}
	// 清屏
	qingping2();
	// 刷新
	art.dialog({
		id : 'onSharesZhuiPage'
	}).close();
	Onzhuijiaguquan(_zhuijiaType.split(",")[1]);
}
// 删除追加记录
function delzhuijia(id) {
	art.dialog({
		title : '删除',
		content : '您是否要删除',
		icon : 'warning',
		ok : function() {
			sharesData.delSharesIn(id);
			// 刷新
			art.dialog({
				id : 'onSharesZhuiPage'
			}).close();
			Onzhuijiaguquan(_zhuijiaType.split(",")[1]);
		},
		okVal : '确定',
		cancelVal : '关闭',
		cancel : true
	});
}
// 修改追加记录
var _eiid;
function onUpZhuijia(data) {
	_isSaveOrUpZhuijia = 'update';
	_eiid = data;
	Onzhuijiaguquan(_zhuijiaType.split(",")[1]);
}
// 清屏
function qingping2() {
	$('sharesInTimezhui').value = '';
	$('sharesInNumber').value = '';
	$('sharesInPrice').value = '';
	$('InOtherCost').value = '';
}
// 清屏
function qingping3() {
	$('sharesOutTime').value = '';
	$('sharesOutNumber').value = '';
	$('sharesOutPrice').value = '';
	$('OutOtherCost').value = '';
	$('taxNumber').value = '';
}
// 存储转让历史的list
var _zhuanrangList;
// 打开转让页面
function openZhuanrang() {
	art.dialog({
		id : 'onGupiaozhuanrang',
		title : '详情',
		content : document.getElementById("gupiaozhuanrang")
	});
	var _sid = window.cooID;
	sharesData.isGetZhuanrang(_sid, function(data) {
		_zhuanrangList = data;
	});
	DWRUtil.removeAllRows("outTable");
	DWRUtil.addRows("outTable", _zhuanrangList, [
			function(data) {
				return data.sharesOutTime;
			},
			function(data) {
				return data.sharesOutNumber;
			},
			function(data) {
				return data.sharesOutPrice;
			},
			function(data) {
				return data.outOtherCost;
			},
			function(data) {
				return "<a href='#' onclick='onUpZhuanrang(" + data.eoid
						+ ")'>修改</a><a href='#' onclick='delzhuanrang("
						+ data.eoid + ")'>删除</a>";
			} ]);
}

// 是保存还是修改
var isZhuanrang = 'save';
function onSaveZhuanrang() {
	var _obj = new Object();
	_obj.uid=window.sessionUID;
	_obj.sid=window.cooID;
	_obj.sharesOutTime = $('sharesOutTime').value;
	_obj.sharesOutNumber = $('sharesOutNumber').value;
	_obj.sharesOutPrice = $('sharesOutPrice').value;
	_obj.outOtherCost = $('OutOtherCost').value;
	// 预留
	_obj.outChina = 0;
	_obj.sharesAllNumber = parseFloat(_obj.sharesOutNumber)
			* parseFloat(_obj.sharesOutPrice);
	_obj.taxNumber = '0';
	_obj.taxableNumber = '0';
	_obj.payOutNumber = '0';
	_obj.taxEdNumber = '0';
	_obj.taxEdType = '0';

	if (isZhuanrang == 'save') {
		sharesData.addSharesOut(_obj);
	} else {
		_obj.eoid=_eoid;
		sharesData.upSharesOut(_obj);
		// 修改完并还原
		isZhuanrang = 'save';
	}
	// 清平并刷新
	qingping3();
	// 关闭
	art.dialog({
		id : 'onGupiaozhuanrang'
	}).close();
	// 重新打开
	openZhuanrang();
}
// 修改
// 记录ID
var _eoid;
function onUpZhuanrang(id) {
	//修改保存状态
	isZhuanrang = 'update';
	//记录id
	_eoid=id;
	var _obj;
	//填充页面
	for ( var i = 0; i < _zhuanrangList.length; i++) {
		if(_zhuanrangList[i].eoid==id){
			_obj=_zhuanrangList[i];
		}
	}
	$('sharesOutTime').value=_obj.sharesOutTime;
	$('sharesOutNumber').value=_obj.sharesOutNumber;
	$('sharesOutPrice').value=_obj.sharesOutPrice;
	$('OutOtherCost').value=_obj.outOtherCost;
	$('taxNumber').value=_obj.taxNumber;
}
//删除转让信息
function delzhuanrang(id) {
	art.dialog({
		title : '删除',
		content : '您是否要删除',
		icon : 'warning',
		ok : function() {
			sharesData.delSharesOut(id);
			// 清平并刷新
			qingping3();
			art.dialog({
				id : 'onGupiaozhuanrang'
			}).close();
			// 重新打开
			openZhuanrang();
		},
		okVal : '确定',
		cancelVal : '关闭',
		cancel : true
	});
}

// 绑定各种类型
function bangDingType(data, id, value) {
	if (value == null) {
		DWRUtil.removeAllOptions(id);
		DWRUtil.addOptions(id, data, "id", "name");
	} else {
		for ( var i = 0; i < data.length; i++) {
			if (data[i].id == value) {
				var _yiyou = [ data[i] ];
				DWRUtil.removeAllOptions(id);
				DWRUtil.addOptions(id, _yiyou, "id", "name");
				DWRUtil.addOptions(id, data, "id", "name");
				return;
			}
		}
	}
}
// 弹出的错误框
function onErroeAlert(str) {
	art.dialog({
		title : '错误',
		content : str,
		icon : 'warning'
	});
}
// 刷新主页面
function onLoadingAllPage(delDiv, inDiv) {
	// 重构主DIV
	reviveDiv(delDiv, inDiv);
	// 加载页面
	j$(function() {
		onServiceLoad(delDiv, 610, 830, _PageData);
	});
}

// ////////////////全局方法分割线/////////////////
// 深度克隆对象
function clone(obj) {
	var objClone;
	if (obj.constructor == Object) {
		objClone = new obj.constructor();
	} else {
		objClone = new obj.constructor(obj.valueOf());
	}
	for ( var key in obj) {
		if (objClone[key] != obj[key]) {
			if (typeof (obj[key]) == 'object') {
				objClone[key] = clone(obj[key]);
			} else {
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

// 重新构建div
function reviveDiv(delDiv, inDiv) {
	var div = document.getElementById(delDiv);
	div.parentNode.removeChild(div);
	document.getElementById(inDiv).innerHTML += "<div id='" + delDiv
			+ "'></div>";
}
// 只允许输入数字
function replaceNotNumber(hehe) {
	var pattern = /[^0-9|\.]/g;
	if (pattern.test(hehe.value)) {
		hehe.value = hehe.value.replace(pattern, "");
	}
}

// 遍历数据源返回结构
function isReturnPageData(indata, id, name, type) {
	if (indata != null) {
		var outData = new Array();
		for ( var i = 0; i < indata.length; i++) {
			var _type;
			try {
				_type = eval("indata[i]." + type);
			} catch (a) {
				_type = null;
			}
			var obj = {
				id : eval("indata[i]." + id),
				name : eval("indata[i]." + name),
				type : _type,
				original : indata[i]
			}
			// 放入hashmap
			_PageDataMap.put(obj.id, obj.original);
			outData.unshift(obj);
		}
		return outData;
	} else
		return null;
}

// 获取选中哪个
function onReturnHouseTaxType(name, value) {
	for ( var int = 0; int < document.getElementsByName(name).length; int++) {
		if (value == null) {
			if (document.getElementsByName(name)[int].checked) {
				return document.getElementsByName(name)[int].value;
			}
		} else {
			if (document.getElementsByName(name)[int].value == value) {
				document.getElementsByName(name)[int].checked = true;
			} else {
				document.getElementsByName(name)[int].checked = false;
			}
		}
	}
}


//打开某股权或股票的报表
function onOpenSharesReport(){
	art.dialog({
		title: "报表信息",
		content: document.getElementById("report"),
		ok:function(){
		    this.title('3秒后自动关闭').time(3);
	        return false;
        },
        cancelVal: '关闭',
		cancel: true 
	   }
	);
}

//打开某股权或股票的全局报表
function onOpenFullSharesReport(){
	art.dialog({
		title: "全局报表信息",
		content: document.getElementById("fullReport"),
		ok:function(){
		    this.title('3秒后自动关闭').time(3);
	        return false;
        },
        cancelVal: '关闭',
		cancel: true 
	   }
	);
}