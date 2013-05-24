// 创建报表图标
var _baobiaoIco = {
	id : 'baobiao',
	name : '全局报表'
};
// 全局报表事件
var BaobiaoOnclick;
// 是否需要加载全局报表
var _isitBaobiao = false;
// 点击图片时加载方法
var _onloadPageclick="onFindChartered(a);";
// 关闭窗口是触发的方法
var _onWindowCloseclick;
// 记录窗口id
var _isWindowCloseclickID;
// 特许权类型
var _charteredType = [ {
	id : 0,
	name : '拍卖文稿所得'
}, {
	id : 1,
	name : '广告中使用特许权所得'
}, {
	id : 2,
	name : '电影制片厂买断已出版作品或者向作者征稿支付的报酬'
}, {
	id : 3,
	name : '网上发表作品所得'
}, {
	id : 4,
	name : '个人取得专利赔偿所得'
}, {
	id : 5,
	name : '企业员工向本企业提供非专利技术取得收入'
}, {
	id : 6,
	name : '提供艺术照片所得'
}, {
	id : 7,
	name : '向个人转让采矿权'
} ];
var _userID;
window.onload = function() {
	DWREngine.setAsync(false);
	paychexD.getUser(function(data) {
		_userID = data["userId"];
	});
	mainPage();
	onRefreshMainPage("CharteredPage", "CharteredMain", _allChartered.values(),
			150, 810);
};
// 存数所有特许权作品
var _allChartered = new JHashMap();
// 主页面模具
function mainPage() {
	// 初始化图片路径
	eval("window.addImg = 'house/images/Addhouse.png';");
	eval("window.loadImg = 'house/images/House.png';");
	eval("window.baobiaoImg = 'house/images/report2.png';");
	// 初始化最后一张图片的名称
	eval("window.lastName = '添加专利'");
	// 设置添加作品的按钮
	var _userAdd = "onOpenCharteredInfo()";
	// 设置房产的操作组
	var _imageOnclick = [ {
		id : "id1",
		image : "house/images/fangchanxiugai.png",
		imageName : "修改专利",
		onclick : 'new Function("onOpenupCrCharteredInfo()")'
	}, {
		id : "id2",
		image : "house/images/Delete.png",
		imageName : "删除",
		onclick : 'new Function("ondelCrCharteredInfo()")'
	}, {
		id : "id3",
		image : "house/images/Install.png",
		imageName : "特许权",
		onclick : 'new Function("onaddCrChartered()")'
	} ];
	// 操作加入至页面栏
	eval("window.userAddCoo=_userAdd;");
	eval("window._lodingOnclick=_imageOnclick;");

	// 开始加载页面缓存
	if (_allChartered == null || _allChartered.size() == 0) {
		CharteredData.isGetCharteredInfo(_userID, function(data) {
			if (data != null && data.lengtn != 0) {
				_allChartered = isReturnPageData(data, "ciid",
						"charteredInfoName");
			}
		});
	}
}
// 弹出添加专利信息
function onOpenCharteredInfo() {
	onPutong("添加新专利", document.getElementById("addCrCharteredInfo"),
			"onaddCrCharteredInfo(0)");
	$('charteredInfoName').value = '';
}
// 弹出修改专利信息
function onOpenupCrCharteredInfo() {
	onPutong("添加新专利", document.getElementById("addCrCharteredInfo"),
			"onaddCrCharteredInfo(1," + window.cooID + ")");
	// 填充页面
	var _obj = _allChartered.get(window.cooID);
	$('charteredInfoName').value = _obj.original.charteredInfoName;
}
// 保存或修改
function onaddCrCharteredInfo(data, id) {
	var _obj = new Object();
	_obj.uid = _userID;
	_obj.charteredInfoName = $('charteredInfoName').value;
	_obj.charteredInfoType = 0;
	if (data == 0) {
		CharteredData.addCrCharteredInfo(_obj, function(data) {
			if(data!=null){
			var a = isReturnPageData(data, "ciid", "charteredInfoName");
			_allChartered.put(a.id, a);
			// 刷新页面
			onRefreshMainPage("CharteredPage", "CharteredMain", _allChartered
					.values(), 150, 810);
			}else
				onErroeAlert("该专利已存在");
		});
	} else {
		_obj.ciid = id;
		_allChartered.get(id).name = _obj.charteredInfoName;
		_allChartered.get(id).original.charteredInfoName = _obj.charteredInfoName;
		// CharteredData.upCrCharteredInfo(_obj);
		// 刷新页面
		onRefreshMainPage("CharteredPage", "CharteredMain", _allChartered
				.values(), 150, 810);
	}
}
// 删除特许权
function ondelCrCharteredInfo() {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该专利么？',
		lock : true,
		opacity : 0,
		ok : function() {
			art.dialog({
				title : '警告',
				content : '此次删除将删除该专利所有资料',
				lock : true,
				opacity : 0,
				ok : function() {
					CharteredData.delCrCharteredInfo(window.cooID);
					_allChartered.remove(window.cooID);
					// 刷新页面
					onRefreshMainPage("CharteredPage", "CharteredMain",
							_allChartered.values(), 150, 810);
					return true;
				},
				okVal : '确定删除',
				cancelVal : '关闭',
				cancel : true
			});
		},
		okVal : '删除',
		cancelVal : '关闭',
		cancel : true
	});
}
// 弹出添加特许权
function onaddCrChartered() {
	onPutong("添加特许权信息", document.getElementById("addCrChartered"),
			"onSaveCrChartered(0)");
	// 加载类型
	DWRUtil.removeAllOptions("charteredType");
	DWRUtil.addOptions("charteredType", _charteredType, "id", "name");
	// 清屏
	$('charteredStart').value = '';
	$('charteredEnd').value = '';
	$('charteredNumber').value = '';
}
// 弹出修改特许权
function onupCrChartered(_obj) {
	onPutong("修改特许权信息", document.getElementById("addCrChartered"),
			"onSaveCrChartered(1," + _obj.cid + ")");
	$('charteredStart').value = _obj.charteredStart;
	$('charteredEnd').value = _obj.charteredEnd;
	$('charteredNumber').value = _obj.charteredNumber;
	onReturnHouseTaxType("taxed", _obj.taxed);
	// 加载类型
	DWRUtil.removeAllOptions("charteredType");
	for ( var i = 0; i < _charteredType.length; i++) {
		if (_charteredType[i].id == _obj.charteredType) {
			DWRUtil.addOptions("charteredType", [ _charteredType[i] ], "id",
					"name");
		}
	}
	DWRUtil.addOptions("charteredType", _charteredType, "id", "name");
}
// 保存或修改
function onSaveCrChartered(data, cid) {
	if ($('charteredStart').value != null && $('charteredEnd').value != null
			&& $('charteredNumber').value != null
			&& $('charteredStart').value != '' && $('charteredEnd').value != ''
			&& $('charteredNumber').value != '') {
		var _obj = new Object();
		_obj.uid = _userID;
		_obj.ciid = window.cooID;
		_obj.charteredStart = $('charteredStart').value;
		_obj.charteredEnd = $('charteredEnd').value;
		_obj.charteredNumber = $('charteredNumber').value;
		_obj.taxed = onReturnHouseTaxType("taxed");
		_obj.charteredType = $('charteredType').value;
		var _nian = parseInt(_obj.charteredEnd.split('-')[0])
				- parseInt(_obj.charteredStart.split('-')[0]);
		var _yue = parseInt(_obj.charteredEnd.split('-')[1])
				- parseInt(_obj.charteredStart.split('-')[1]);
		var _zong = _yue + _nian * 12;
		_zong == 0 ? _zong = 1 : true;
		if (_zong >= 0) {
			_obj.charteredTime = _zong;
			_obj.taxNumber = 0;
			_obj.taxableNumber = 0;
			_obj.payOutNumber = 0;
			_obj.taxEdNumber = 0;
			if (data == 0) {
				// 保存数据库并刷新
				CharteredData.addCrChartered(_obj);
			} else {
				_obj.cid = cid;
				alert(_obj.cid);
				// 修改数据库并刷新
				CharteredData.upCrChartered(_obj);
			}
			onFindChartered(window.cooID);
		} else {
			onErroeAlert("结束时间大于开始时间");
		}
	} else {
		onErroeAlert("您填写的不完全");
	}
}
// 删除特许权历史信息
function ondelCrChartered(cid) {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该专利么？',
		lock : true,
		opacity : 0,
		ok : function() {
			CharteredData.delCrChartered(cid);
			//刷新
			onFindChartered(window.cooID);
		},
		okVal : '删除',
		cancelVal : '关闭',
		cancel : true
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
		if (indata.constructor == window.Array) {
			var outData = new JHashMap();
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
				};
				outData.put(obj.id, obj);
			}
			return outData;
		} else if (indata.constructor == window.Object) {
			var _type;
			try {
				_type = eval("indata." + type);
			} catch (a) {
				_type = null;
			}
			var obj = {
				id : eval("indata." + id),
				name : eval("indata." + name),
				type : _type,
				original : indata
			};
			return obj;
		}
	} else
		return null;
}
// 普通弹框
function onPutong(title, content, fun) {
	if (fun != null && fun != '') {
		art.dialog({
			title : title,
			content : content,
			lock : true,
			opacity : 0,
			ok : function() {
				eval(fun);
				return true;
			},
			okVal : '确定',
			cancelVal : '关闭',
			cancel : true
		});
	} else {
		art.dialog({
			title : title,
			content : content,
			lock : true
		});
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
// 刷新主页面
function onRefreshMainPage(delDiv, inDiv, data, height, width) {
	reviveDiv(delDiv, inDiv);
	j$(function() {
		onServiceLoad(delDiv, height, width, data);
	});
}