// 是否需要加载全局报表
var _isitBaobiao = true;
// 点击图片时加载方法
var _onloadPageclick;
// 关闭窗口是触发的方法
var _onWindowCloseclick;
// 记录窗口id
var _isWindowCloseclickID;
//存储用户ID
var _userID;
// 页面加载时事件
window.onload = function() {
	// 关闭dwr异步
	DWREngine.setAsync(false);
	// 获取session中的用户ID
	paychexD.getUser(function(data) {
		_userID = data["userId"];
	});
	// 查找拍卖信息
	onFindAllAuction(_userID);
}
// 弹出添加拍卖品菜单
function onaddAuctionInfo() {
	onPutong("添加拍卖品", document.getElementById("addAuctionInfo"),
			"saveAuctionInfo(0)");
	qingping1();
}
// 填充修改
function onupAuctionInfo(j) {
	var _obj=window.wriAuction[j];
	onPutong("修改拍卖品", document.getElementById("addAuctionInfo"),
			"saveAuctionInfo(1," + _obj.aid + ")");
	// 填充页面
	onReturnHouseTaxType("taxed", _obj.taxed);
	$('auctionName').value = _obj.auctionName;
	$('auctionOldNumber').value = _obj.auctionOldNumber;
	$('auctionNumber').value = _obj.auctionNumber;
	$('auctionTime').value = _obj.auctionTime;
	$('outCastNumber').value = _obj.outCastNumber;
	
}
// 清屏1
function qingping1() {
	$('auctionName').value = '';
	$('auctionOldNumber').value = '';
	$('auctionNumber').value = '';
	$('auctionTime').value = '';
	$('outCastNumber').value = '';
}
// 保存和修改
function saveAuctionInfo(data, obj) {
	if ($('auctionName').value != null && $('auctionOldNumber').value != null
			&& $('auctionNumber').value != null
			&& $('auctionTime').value != null
			&& $('outCastNumber').value != null && $('auctionName').value != ''
			&& $('auctionOldNumber').value != ''
			&& $('auctionNumber').value != '' && $('auctionTime').value != ''
			&& $('outCastNumber').value != '') {
		var _obj = new Object();
		_obj.uid = _userID;
		_obj.taxed = onReturnHouseTaxType("taxed");
		_obj.auctionName = $('auctionName').value;
		_obj.auctionOldNumber = $('auctionOldNumber').value;
		_obj.auctionNumber = $('auctionNumber').value;
		_obj.auctionTime = $('auctionTime').value;
		_obj.outCastNumber = $('outCastNumber').value;
		_obj.taxNumber = 0;
		_obj.taxableNumber = 0;
		_obj.payOutNumber = 0;
		_obj.taxEdNumber = 0;
		if (data == 0) {
			// 存储数据库并刷新
			AuctionData.addAuctionInfo(_obj);
		} else {
			_obj.aid = obj;
			// 修改并刷新
			AuctionData.upAuctionInfo(_obj);
		}
		onFindAllAuction(_userID);
	} else {
		onErroeAlert('对不起，您填写的不完全');
	}
}
// 删除拍卖
function ondelAuctionInfo(aid) {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该拍卖品么？',
		lock : true,
		opacity : 0,
		ok : function() {
			AuctionData.delAuctionInfo(aid);
//			// 刷新
			onFindAllAuction(_userID);
			return true;
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
