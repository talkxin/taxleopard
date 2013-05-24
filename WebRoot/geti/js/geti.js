var _userID;
window.onload = function() {
	DWREngine.setAsync(false);
	paychexD.getUser(function(data) {
		_userID = data["userId"];
	});
	onFindGeti(_userID);
}
// 弹出添加
function onaddGetti() {
	onPutong("添加收入", document.getElementById("getiPage"), "savegeti(0)");
	$('gtiTime').value = '';
	$('gtiNumber').value = '';
	$('taxEdNumber').value = '';
	onReturnHouseTaxType("taxed", 0);
}
// 修改
function onupGetti(_obj) {
	onPutong("添加收入", document.getElementById("getiPage"), "savegeti(1,"
			+ _obj.gid + ")");
	$('gtiTime').value = _obj.gtiTime;
	$('gtiNumber').value = _obj.gtiNumber;
	$('taxEdNumber').value = _obj.taxEdNumber;
	onReturnHouseTaxType("taxed", _obj.taxed);
}
// 保存
function savegeti(data, gid) {
	if ($('gtiTime').value != null && $('gtiTime').value != ''
			&& $('gtiNumber').value != null && $('gtiNumber').value != ''
			&& $('taxEdNumber').value != null && $('taxEdNumber').value != '') {
		var _obj = new Object();
		_obj.uid = _userID;
		_obj.gtiTime = $('gtiTime').value
		_obj.taxed = onReturnHouseTaxType("taxed");
		_obj.gtiNumber = $('gtiNumber').value;
		_obj.taxNumber = 0
		_obj.taxableNumber = 0
		_obj.payOutNumber = 0
		_obj.taxEdNumber = $('taxEdNumber').value;
		if (data == 0) {
			
			getiData.addGetti(_obj);
		} else {
			_obj.gid = gid;
			getiData.upGetti(_obj);
		}
		onFindGeti(_userID);
	} else
		onErroeAlert("您没有填写完全");
}
// 删除
function delGetti(gid) {
	art.dialog({
		title : '警告',
		content : '您是否要删除该笔收入',
		lock : true,
		opacity : 0,
		ok : function() {
			getiData.delGetti(gid);
			onFindGeti(_userID);//刷新
			return true;
		},
		okVal : '确定删除',
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