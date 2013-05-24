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
	DWREngine.setAsync(false);
	paychexD.getUser(function(data) {
		_userID = data["userId"];
	});
	onFindOtherIncome(_userID);
};
// 弹出添加
function onaddOtherincome() {
	onPutong("添加其他所得", document.getElementById("addOtherincome"),
			"savaOtherincome(0)");
	qingping1();
}
// 弹出修改
function upOtherincome(j) {
	var _obj=window.wriOtherIncome[j];
	//eval("_obj" + obj);
	onPutong("修改其他所得", document.getElementById("addOtherincome"),
			"savaOtherincome(1," + _obj.oid + ")");
	// 填充表单
	$("otherName").value = _obj.otherName;
	$("otherTime").value = _obj.otherTime;
	$("otherNumber").value = _obj.otherNumber;
	$("otherTax").value = _obj.otherTax;
}
// 保存或修改
function savaOtherincome(data, obj) {
	if ($("otherName").value != null && $("otherTime").value != null
			&& $("otherNumber").value != null && $("otherTax").value != null
			&& $("otherName").value != '' && $("otherTime").value != ''
			&& $("otherNumber").value != '' && $("otherTax").value != '') {
		var _obj = new Object();
		_obj.uid = _userID;
		_obj.otherName = $("otherName").value;
		_obj.otherTime = $("otherTime").value;
		_obj.otherNumber = $("otherNumber").value;
		_obj.otherTax = $("otherTax").value;
		if (data == 0) {
			// 保存并刷新
			OtherincomeData.addOtherincome(_obj);
		} else {
			_obj.oid = obj;
			// 修改并刷新
			OtherincomeData.upOtherincome(_obj);
		}
		onFindOtherIncome(_userID);
	} else {
		onErroeAlert('对不起，您填写的不完全');
	}
}
// 删除
function ondelOtherincome(oid) {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该所得么？',
		lock : true,
		opacity : 0,
		ok : function() {
			OtherincomeData.delOtherincome(oid);
			// 刷新
			onFindOtherIncome(_userID);
			return true;
		},
		okVal : '删除',
		cancelVal : '关闭',
		cancel : true
	});
}
// 清屏1
function qingping1() {
	$("otherName").value = "";
	$("otherTime").value = "";
	$("otherNumber").value = "";
	$("otherTax").value = "";
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
