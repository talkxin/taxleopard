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
var _onloadPageclick="onFindSavingsDwr(a);";
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
	onRefreshMainPage("SavingsPage", "SavingsMain", _allSavingsInfo.values(),
			150, 810);
	
	Date.prototype.pattern=function(fmt) {        
	    var o = {        
	    "M+" : this.getMonth()+1, //月份        
	    "d+" : this.getDate(), //日        
	    "h+" : this.getHours() == 0 ? 12 : this.getHours(), //小时        
	    "H+" : this.getHours(), //小时        
	    "m+" : this.getMinutes(), //分        
	    "s+" : this.getSeconds(), //秒        
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度        
	    "S" : this.getMilliseconds() //毫秒        
	    };        
	    var week = {        
	    "0" : "\u65e5",        
	    "1" : "\u4e00",        
	    "2" : "\u4e8c",        
	    "3" : "\u4e09",        
	    "4" : "\u56db",        
	    "5" : "\u4e94",        
	    "6" : "\u516d"       
	    };        
	    if(/(y+)/.test(fmt)){        
	        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));        
	    }        
	    if(/(E+)/.test(fmt)){        
	        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);        
	    }        
	    for(var k in o){        
	        if(new RegExp("("+ k +")").test(fmt)){        
	            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));        
	        }        
	    }        
	    return fmt;        
	} 
}
// 存储所有账户信息
var _allSavingsInfo = new JHashMap();
// 主页面模具
function mainPage() {
	// 初始化图片路径
	eval("window.addImg = 'house/images/Addhouse.png';");
	eval("window.loadImg = 'house/images/House.png';");
	eval("window.baobiaoImg = 'house/images/report2.png';");
	// 初始化最后一张图片的名称
	eval("window.lastName = '添加账户'");
	// 设置添加作品的按钮
	var _userAdd = "onaddSaSavingsInfo()";
	// 设置房产的操作组
	var _imageOnclick = [ {
		id : "id1",
		image : "house/images/fangchanxiugai.png",
		imageName : "修改账户信息",
		onclick : 'new Function("onupSaSavingsInfo()")'
	}, {
		id : "id2",
		image : "house/images/Delete.png",
		imageName : "删除账户",
		onclick : 'new Function("ondelSaSavingsInfo()")'
	}, {
		id : "id3",
		image : "house/images/Install.png",
		imageName : "账户操作",
		onclick : 'new Function("onOpenCaozuo()")'
	} ];
	// 操作加入至页面栏
	eval("window.userAddCoo=_userAdd;");
	eval("window._lodingOnclick=_imageOnclick;");

	// 开始加载页面缓存
	if (_allSavingsInfo == null || _allSavingsInfo.size() == 0) {
		SavingsData.isGetSavingsInfo(_userID,
				function(data) {
					if (data != null && data.length != 0) {
						_allSavingsInfo = isReturnPageData(data, "siid",
								"savingsName");
					}
				});
	}
}
// 弹出添加账户
function onaddSaSavingsInfo() {
	onPutong("添加账户", document.getElementById("addSaSavingsInfoPage"),
			"onSaveSavingsInfo(0)");
	// 清屏
	$("savingsName").value = '';
	$("savingsTime").value = '';
	$("savingsAccount").value = '';
}
// 修改账户信息
function onupSaSavingsInfo() {
	var _obj = _allSavingsInfo.get(window.cooID);
	onPutong("添加账户", document.getElementById("addSaSavingsInfoPage"),
			"onSaveSavingsInfo(1," + window.cooID + ")");
	// 填充屏幕
	onReturnHouseTaxType("savingsType", _obj.original.savingsType);
	$("savingsName").value = _obj.original.savingsName;
	$("savingsTime").value = _obj.original.savingsTime;
	$("savingsAccount").value = _obj.original.savingsAccount;
}
// 保存账户信息
function onSaveSavingsInfo(data, id) {
	if ($("savingsName").value != null && $("savingsTime").value != null
			&& $("savingsAccount").value != null
			&& $("savingsName").value != '' && $("savingsTime").value != ''
			&& $("savingsAccount").value != '') {
		_obj = new Object();
		_obj.uid = _userID;
		_obj.savingsType = onReturnHouseTaxType("savingsType");
		_obj.savingsName = $("savingsName").value;
		_obj.savingsTime = $("savingsTime").value;
		_obj.savingsAccount = $("savingsAccount").value;
		if (data == 0) {
			SavingsData.addSaSavingsInfo(_obj, function(data) {
				if (data != null) {
					var _a = isReturnPageData(data, "siid", "savingsName");
					_allSavingsInfo.put(_a.id, _a);
					// 弹出账户操作
					onOpenCaozuo();
				} else {
					onErroeAlert("已经存在该账户");
				}
			});
		} else {
			_obj.siid = id;
			SavingsData.upSaSavingsInfo(_obj);
			// 修改缓存
			_allSavingsInfo.get(id).name = _obj.savingsName;
			_allSavingsInfo.get(id).original = _obj;

		}
		// 刷新
		onRefreshMainPage("SavingsPage", "SavingsMain", _allSavingsInfo
				.values(), 150, 810);
	} else {
		onErroeAlert("您填写的不完全");
	}
}
// 删除账户
function ondelSaSavingsInfo() {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该账户么？',
		lock : true,
		opacity : 0,
		ok : function() {
			art.dialog({
				title : '警告',
				content : '此次删除将删除该账户所有资料',
				lock : true,
				opacity : 0,
				ok : function() {
					SavingsData.delSaSavingsInfo(window.cooID);
					_allSavingsInfo.remove(window.cooID);
					// 刷新
					onRefreshMainPage("SavingsPage", "SavingsMain",
							_allSavingsInfo.values(), 150, 810);
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
// 弹出对账户操作
function onOpenCaozuo() {
	onaddSaSavings();
//	onPutong("账户操作", document.getElementById("zhanghucaozuo"));
}
// 弹出添加账户信息
function onaddSaSavings() {
	onPutong("存款信息", document.getElementById("addSaSavingsPage"),
			"onSaveSavings(0)");
	$('savingsNumber').value = '';
	$('interestRate').value='';
	onReturnHouseTaxType("savingsAllTime", 3);
}
// 最新利率
var _newLilv;
// 弹出修改
function onupSaSavings(_obj) {

	onPutong("存款信息", document.getElementById("addSaSavingsPage"),
			"onSaveSavings(1," + _obj.sid + ")");
	$('savingsNumber').value = _obj.savingsNumber;
	$('interestRate').value=_obj.interestRate;
	onReturnHouseTaxType("savingsAllTime", _obj.savingsAllTime);
}
// 进行保存
function onSaveSavings(data, sid) {
	if ($('savingsNumber').value != null &&  $('savingsNumber').value != ''
			&& $('interestRate').value != null && $('interestRate').value != '') {
		var _obj = new Object();
		_obj.uid = _userID;
		_obj.siid = window.cooID;
		_obj.savingsType1 = 0;
		_obj.savingsType2 = 0;
		_obj.savingsNumber = $('savingsNumber').value;
		_obj.savingsStart = "0";
		_obj.savingsEnd = "0";
		_obj.savingsAllTime = onReturnHouseTaxType("savingsAllTime");
		_obj.interestRate=$('interestRate').value;
		_obj.taxNumber = 0;
		_obj.taxableNumber = 0;
		_obj.payOutNumber = 0;
		_obj.taxEdNumber = 0;
		_obj.interest=parseFloat(_obj.savingsNumber)*parseFloat(_obj.interestRate)*parseFloat(_obj.savingsAllTime);
			if (data == 0) {
				SavingsData.addSaSavings(_obj);
//				// 提示用户是否用最新利率
//				if (_newLilv == null)
//					SavingsData.isGetNewInterest(window.cooID,
//							function(data) {
//								if (data != null) {
//									_newLilv = data;
//									onPutong("利率", "您该账户的利率为"
//											+ _newLilv.interestRate + " 是否修改？",
//											"onupLilv()")
//								} else
//									onPutong("错误", "该账户没有添加过利率，是否现在添加？",
//											"onaddLilv()");
//							});
//				else
//					onPutong("错误", "该账户没有添加过利率，是否现在添加？", "onaddLilv()");
				// 刷新页面
			} else {
				_obj.sid = sid;
				SavingsData.upSaSavings(_obj);
			}
			onFindSavingsDwr(window.cooID);
	} else {
		onErroeAlert("对不起您填写的不完全");
	}
}
// 删除存款
function ondelSaSavings(sid) {
	art.dialog({
		title : '警告',
		content : '您是否要删除该条信息',
		lock : true,
		opacity : 0,
		ok : function() {
			SavingsData.delSaSavings(sid);
			// 刷新
			onFindSavingsDwr(window.cooID);
			return true;
		},
		okVal : '确定删除',
		cancelVal : '关闭',
		cancel : true
	});
}
// 添加利率
function onaddLilv() {
	onPutong("添加利率", document.getElementById("addLilv"), "onSaveLilv(0)");
	$('interestRate').value = '';
}

//弹出确认修改利率
function onupInterest(){
	if (_newLilv == null || _newLilv.iid==null) {
		SavingsData.isGetNewInterest(window.cooID, function(data) {
			if (data != null) {
				_newLilv = data;
				// 填充页面
				onPutong("修改利率", "您该银行的利率现为" + _newLilv.interestRate + "是否修改",
				"onupInterest1()");
			} else
				onPutong("添加利率", "该账户没有添加过利率，是否现在添加？", "onaddLilv()");
		});
	} else {
		onPutong("修改利率", "您该银行的利率现为" + _newLilv.interestRate + "是否修改",
				"onupInterest1()");
	}
}

// 弹出修改
function onupInterest1() {
	onPutong("修改利率", document.getElementById("addLilv"), "onSaveLilv(1)");
	if (_newLilv == null)
		SavingsData.isGetNewInterest(window.cooID, function(data) {
			if (data != null) {
				_newLilv = data;
				// 填充页面
				$('interestRate').value = _newLilv.interestRate;
			} else
				onPutong("添加利率", "该账户没有添加过利率，是否现在添加？", "onaddLilv()");
		});
	else
		// 填充页面
		$('interestRate').value = _newLilv.interestRate;
}
// 保存利率
function onSaveLilv(data, siid) {
	if ($('interestRate').value != null && $('interestRate').value != '') {
		var _obj = new Object();
		_obj.siid = window.cooID;
		_obj.interestTime = (new Date()).pattern("yyyy-MM-dd");
		_obj.interest = 0;
		_obj.interestRate = $('interestRate').value;
		if (data == 0) {
			SavingsData.addInterest(_obj);
			_newLilv = _obj;
		} else {
			if (_newLilv.iid != null) {
				_obj.iid = _newLilv.iid;
				_obj.interestTime = _newLilv.interestTime;
			} else {
				SavingsData.isGetNewInterest(window.cooID, function(data) {
					_obj.iid = data.iid;
					_obj.interestTime = data.interestTime;
				});
			}
			// 修改数据库
			SavingsData.upInterest(_obj);
			_newLilv = _obj;
		}
	}
}
// 删除利率(保留)
function onDelLilv() {
	art.dialog({
		title : '警告',
		content : '您是否要删除该账户利率',
		lock : true,
		opacity : 0,
		ok : function() {
			SavingsData.delInterest(windo.cooID);
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