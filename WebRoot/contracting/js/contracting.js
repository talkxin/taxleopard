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
var _onloadPageclick = "onFindContractDwr(a);";
// 关闭窗口是触发的方法
var _onWindowCloseclick;
// 记录窗口id
var _isWindowCloseclickID;

var _userID;
window.onload = function() {
	DWREngine.setAsync(false);
	paychexD.getUser(function(data) {
		_userID = data["userId"];
	});
	mainPage();
	onRefreshMainPage("contractingPage", "contractingMain", _allContractInfo
			.values(), 150, 810);
}

// 所有承包承租机构
var _allContractInfo = new JHashMap();
// 主页面模具
function mainPage() {
	// 初始化图片路径
	eval("window.addImg = 'house/images/Addhouse.png';");
	eval("window.loadImg = 'house/images/House.png';");
	eval("window.baobiaoImg = 'house/images/report2.png';");
	// 初始化最后一张图片的名称
	eval("window.lastName = '添加机构'");
	// 设置添加作品的按钮
	var _userAdd = "onaddContractInfo()";
	// 设置房产的操作组
	var _imageOnclick = [ {
		id : "id1",
		image : "house/images/fangchanxiugai.png",
		imageName : "修改",
		onclick : 'new Function("onupContractInfo()")'
	}, {
		id : "id2",
		image : "house/images/Delete.png",
		imageName : "删除",
		onclick : 'new Function("ondelContractInfo()")'
	}, {
		id : "id3",
		image : "house/images/Install.png",
		imageName : "添加合同",
		onclick : 'new Function("onaddContract()")'
	} ];
	// 操作加入至页面栏
	eval("window.userAddCoo=_userAdd;");
	eval("window._lodingOnclick=_imageOnclick;");

	// 开始加载页面缓存
	if (_allContractInfo == null || _allContractInfo.size() == 0) {
		ContractingData.isGetUserContractInfo(_userID, function(data) {
			if (data != null && data.length != 0) {
				_allContractInfo = isReturnPageData(data, "ciid",
						"contractName");

			}
		});
	}
}
// 弹出添加承保机构
function onaddContractInfo() {
	onPutong("添加机构", document.getElementById("addContractInfo"),
			"onsaveContractInfo(0)");
	// 清屏
	$("contractName").value = '';
	$("allPay").value = '';
	onReturnHouseTaxType("contractCoType", 0);
}
// 弹出修改承包机构
function onupContractInfo() {
	onPutong("修改机构", document.getElementById("addContractInfo"),
			"onsaveContractInfo(1," + window.cooID + ")");
	// 填充屏幕
	var _obj = _allContractInfo.get(window.cooID).original;
	$("contractName").value = _obj.contractName;
	$("allPay").value = _obj.allPay;
	onReturnHouseTaxType("contractCoType", _obj.contractCoType);
}
// 删除承包机构
function ondelContractInfo() {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该机构么？',
		lock : true,
		opacity : 0,
		ok : function() {
			art.dialog({
				title : '警告',
				content : '此次删除将删除该机构所有资料',
				lock : true,
				opacity : 0,
				ok : function() {
					ContractingData.delContractInfo(window.cooID);
					_allContractInfo.remove(window.cooID);
					onRefreshMainPage("contractingPage", "contractingMain",
							_allContractInfo.values(), 150, 810);
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
// 保存或者修改
function onsaveContractInfo(data, obj) {
	if ($("contractName").value != null && $("allPay").value != null
			&& $("contractName").value != '' && $("allPay").value != '') {
		var _obj = new Object();
		_obj.uid = _userID;
		_obj.contractName = $("contractName").value;
		_obj.allPay = $("allPay").value;
		_obj.contractCoType = onReturnHouseTaxType("contractCoType");
		if (data == 0) {
			ContractingData.addContractInfo(_obj, function(data) {
				if (data != null) {
					var _a = isReturnPageData(data, "ciid", "contractName");
					_allContractInfo.put(_a.id, _a);
					onRefreshMainPage("contractingPage", "contractingMain",
							_allContractInfo.values(), 150, 810);
				}
			});
		}
	} else
		onErroeAlert("您没有填写完全");
}
// 弹出添加承包信息
function onaddContract() {
	onPutong("添加承包信息", document.getElementById("addContract"),
			"onSaveContract(0)");
	$('contractStart').value = '';
	$('contractEnd').value = '';
	$('contractNumber1').value = '';
	$('contractNumber2').value = '';
	onReturnHouseTaxType("contractType2", 0);
	onReturnHouseTaxType("contractType", 0);

}
// 弹出修改
function onupContract(_obj) {
	onPutong("添加承包信息", document.getElementById("addContract"),
			"onSaveContract(1," + _obj.cid + ")");
	// 填充屏幕
	$('contractStart').value = _obj.contractStart;
	$('contractEnd').value = _obj.contractEnd;
	$('contractNumber1').value = _obj.contractNumber1;
	$('contractNumber2').value = _obj.contractNumber2;
	onReturnHouseTaxType("contractType2", _obj.contractType2);
	onReturnHouseTaxType("contractType", _obj.contractType);
	
}
// 删除
function ondelContract(cid) {
	art.dialog({
		title : '警告',
		content : '您要删除该信息么',
		lock : true,
		opacity : 0,
		ok : function() {
			ContractingData.delContract(cid);
			// 刷新
			onFindContractDwr(window.cooID);
			return true;
		},
		okVal : '确定删除',
		cancelVal : '关闭',
		cancel : true
	});
}
// 保存或修改
function onSaveContract(data, obj) {
	if ($("contractStart").value != null && $("contractEnd").value != null
			&& $("contractNumber1").value != null
			&& $("contractNumber2").value != null
			&& $("contractStart").value != '' && $("contractEnd").value != ''
			&& $("contractNumber1").value != ''
			&& $("contractNumber2").value != '') {
		var _obj = new Object();
		_obj.contractStart = $('contractStart').value;
		_obj.contractEnd = $('contractEnd').value;
		var _nian = parseInt(_obj.contractEnd.split('-')[0])
				- parseInt(_obj.contractStart.split('-')[0]);
		var _yue = parseInt(_obj.contractEnd.split('-')[1])
				- parseInt(_obj.contractStart.split('-')[1]);
		var _zong = _yue + _nian * 12;
		_zong == 0 ? _zong = 1 : true;
		if (_zong >= 0) {
			_obj.uid = _userID;
			_obj.ciid = window.cooID;
			_obj.contractType = onReturnHouseTaxType("contractType");
			_obj.contractType2 = onReturnHouseTaxType("contractType2");
			_obj.taxed = 0;
			_obj.contractAllTime = _zong;
			_obj.contractNumber1 = $('contractNumber1').value;
			_obj.contractNumber2 = $('contractNumber2').value;
			_obj.taxNumber = 0;
			_obj.taxableNumber = 0;
			_obj.payOutNumber = 0;
			_obj.taxEdNumber = 0;
			if (data == 0) {
				
				ContractingData.addContract(_obj);
			} else {
				_obj.cid = obj;
				ContractingData.upContract(_obj);
			}
			onFindContractDwr(window.cooID);
		} else {
			onErroeAlert("结束时间大于开始时间");
		}
	} else
		onErroeAlert("您没有填写完全");
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
function onPutong(title, content, fun, fun2) {
	if (fun != null && fun != '') {
		art.dialog({
			title : title,
			content : content,
			lock : true,
			opacity : 0,
			button : [ {
				name : '确定',
				callback : function() {
					eval(fun);
					return true;
				}
			}, {
				name : '取消',
				callback : function() {
					if (fun2 != null)
						eval(fun2);
					return true;
				}
			} ],
			// ok : function() {
			// eval(fun);
			// return true;
			// },
			// okVal : '确定',
			// cancelVal : '关闭',
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