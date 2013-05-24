// 创建报表图标
var _baobiaoIco = {
	id : 'baobiao',
	name : '全局报表'
};
// 全局报表事件
var BaobiaoOnclick = "onOpenFullRemuReport();onFindFullRemuCombine();";
// 是否需要加载全局报表
var _isitBaobiao = true;
// 点击图片时加载方法
var _onloadPageclick;
// 关闭窗口是触发的方法
var _onWindowCloseclick = "window.wriRemuByPress=null;_isitBaobiao = true;_allRePressType = new JHashMap();_onloadPageclick=null;_isitBaobiao=true;mainPage();onRefreshMainPage('remunerationPage', 'remunerationMain',_allRemuneration.values(),610,830);";
// 记录窗口id
var _isWindowCloseclickID = 'RePublishPageArt';
// 存储uid
var _userID;
// 存储作品类型
var _allRemunerationType = [ {
	id : 0,
	name : '文字作品'
}, {
	id : 1,
	name : '书画'
}, {
	id : 2,
	name : '摄影'
}, {
	id : 3,
	name : '剧本'
}, {
	id : 4,
	name : '广告'
} ];
// 个人身份
var _publishType2 = [ {
	id : 0,
	name : '自由撰稿人'
}, {
	id : 1,
	name : '出版社专业作者'
}, {
	id : 2,
	name : '刊物记者'
}, {
	id : 3,
	name : '其他'
} ];
// 判断是否为出版社专业作者
function onShenfen() {
	if ($('publishType2').value == 1) {
		onPutong("警告", "您如果是该出版社的员工，那么您的收入属于工资薪金")
	}
}
// 页面加载时事件
window.onload = function() {
	// 关闭dwr异步
	DWREngine.setAsync(false);
	// 获取session中的用户ID
	paychexD.getUser(function(data) {
		_userID = data["userId"];
	});
	// 装载模具
	mainPage();
	// 加载页面
	j$(function() {
		onServiceLoad("remunerationPage", 610, 830, _allRemuneration.values());
	});
}

// 存储所有作品
var _allRemuneration = new JHashMap();

// 主页面模具
function mainPage() {
	// 初始化图片路径
	eval("window.addImg = 'house/images/Addhouse.png';");
	eval("window.loadImg = 'house/images/House.png';");
	eval("window.baobiaoImg = 'house/images/report2.png';");
	// 初始化最后一张图片的名称
	eval("window.lastName = '稿酬管理'");
	// 设置添加作品的按钮
	// var _userAdd = [ {
	// id : "id1",
	// image : "house/images/Addhouse.png",
	// imageName : "添加作品",
	// onclick : 'new Function("onRemunerationInfo();")'
	// } ];
	var _userAdd = "onRemunerationInfo()";
	// 设置房产的操作组
	var _imageOnclick = [ {
		id : "id1",
		image : "house/images/fangchanxiugai.png",
		imageName : "修改作品",
		onclick : 'new Function("onUpRemunerationInfo();")'
	}, {
		id : "id2",
		image : "house/images/Delete.png",
		imageName : "删除作品",
		onclick : 'new Function("ondelRemunerationInfo();")'
	}, {
		id : "id3",
		image : "house/images/Install.png",
		imageName : "稿酬操作",
		onclick : 'new Function("onRePublishPageToOpen()")'
	}, {
		id : "id4",
		image : "house/images/report.png",
		imageName : "查看报表",
		onclick : 'new Function("onOpenRemuReport();onFindRemuCombine();")'
	} ];
	// 操作加入至页面栏
	eval("window.userAddCoo=_userAdd;");
	eval("window._lodingOnclick=_imageOnclick;");

	// 开始加载页面
	if (_allRemuneration == null || _allRemuneration.size() == 0) {
		remunerationData.isGetReRemunerationInfo(_userID, function(data) {
			if (data != null && data.length != 0) {
				_allRemuneration = isReturnPageData(data, 'rid',
						'remunerationName');
				_allRemuneration.put(null, _baobiaoIco);
			}
		});
	}
}
// 弹出添加作品
function onRemunerationInfo() {
	onPutong("添加作品", document.getElementById("addRemunerationPage"),
			"onaddRemunerationInfo(0)");
	// 清屏
	qingping1();
	DWRUtil.removeAllOptions("remunerationType");
	DWRUtil.addOptions("remunerationType", _allRemunerationType, "id", "name");
}

// 保存方法
function onaddRemunerationInfo(data) {
	if ($('remunerationName').value == null
			|| $('remunerationName').value == '')
		onErroeAlert("您没有填写完全");
	else {
		if (data == 0) {
			remunerationData.addRemunerationInfo({
				uid : _userID,
				remunerationName : $('remunerationName').value,
				remunerationType : $('remunerationType').value
			}, function(data) {
				if (data != null && data != '') {
					// 加入缓存
					_allRemuneration.put(data.rid, {
						id : data.rid,
						name : data.remunerationName,
						original : data
					});
					// 刷新页面
					onRefreshMainPage("remunerationPage", "remunerationMain",
							_allRemuneration.values(), 610, 830);
				} else
					onErroeAlert("您已经添加过该作品，请点击该作品");
			});
		} else {
			// 修改缓存
			var _obj = _allRemuneration.get(window.cooID);
			if ($('remunerationName').value != _obj.original.remunerationName
					|| $('remunerationType').value != _obj.original.remunerationType) {
				_obj.name = $('remunerationName').value;
				_obj.original.remunerationName = $('remunerationName').value;
				_obj.original.remunerationType = $('remunerationType').value;
				_allRemuneration.put(window.cooID, _obj);
				// 修改数据库
				remunerationData.upRemunerationInfo(_obj.original);
			}
			// 刷新页面
			onRefreshMainPage("remunerationPage", "remunerationMain",
					_allRemuneration.values(), 610, 830);
		}
	}
}

// 修改作品
function onUpRemunerationInfo() {
	// 弹出页面
	onPutong("修改作品", document.getElementById("addRemunerationPage"),
			"onaddRemunerationInfo(1)");
	// 获取缓存内作品内容
	var _obj = _allRemuneration.get(window.cooID);
	// 填充页面
	$('remunerationName').value = _obj.original.remunerationName;
	DWRUtil.removeAllOptions("remunerationType");
	for ( var i = 0; i < _allRemunerationType.length; i++) {
		if (_allRemunerationType[i].id = _obj.original.remunerationType)
			DWRUtil.addOptions("remunerationType", [ _allRemunerationType[i] ],
					"id", "name");
	}
	DWRUtil.addOptions("remunerationType", _allRemunerationType, "id", "name");
}

// 删除作品
function ondelRemunerationInfo() {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该作品么？',
		lock : true,
		opacity : 0,
		ok : function() {
			art.dialog({
				title : '警告',
				content : '此次删除将删除该作品所有资料',
				lock : true,
				opacity : 0,
				ok : function() {
					remunerationData.delRemunerationInfo(window.cooID);
					_allRemuneration.remove(window.cooID);
					if (_allRemuneration.size() == 1)
						_allRemuneration = new JHashMap();
					onRefreshMainPage("remunerationPage", "remunerationMain",
							_allRemuneration.values(), 610, 830);
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
// 清屏1
function qingping1() {
	$('remunerationName').value = '';
}

// 记录某一个作品的信息
var _oneRemuneration;
// 点击展开稿酬所得
function onRePublishPageToOpen() {
	// 关闭全局报表
	_isitBaobiao = false;
	// 获取
	_oneRemuneration = _allRemuneration.get(window.cooID);
	// 打开稿酬所得
	art.dialog({
		id : 'RePublishPageArt',
		title : "稿酬所得",
		content : document.getElementById("gaochouPage"),
		lock : true,
		opacity : 0
	});
	// 添加数据
	onRePublishPage();
	// 加载页面
	onRefreshMainPage("RePressTypePage", "RePressTypeMain", _allRePressType
			.values(), 150, 810);
	// 清空报表下面的数据
	j$("#remuReportByPr").html("");
}
// 存储所有出版社信息
var _allRePressType = new JHashMap();
// 存储该用户所有出版社
var _allUserRePressType = new JHashMap();
// 打开稿酬所得
function onRePublishPage() {
	// 设置点击出版社的切换方法
	_onloadPageclick = "onFindRemuByPress(_oneRemuneration.id,a)";
	// 初始化图片路径
	eval("window.addImg = 'house/images/Addhouse.png';");
	eval("window.loadImg = 'house/images/House.png';");
	eval("window.baobiaoImg = 'house/images/report2.png';");
	// 初始化最后一张图片的名称
	eval("window.lastName = '添加出版社'");
	// 设置添加出版社的按钮
	// var _userAdd = [ {
	// id : "id1",
	// image : "house/images/Addhouse.png",
	// imageName : "添加作品",
	// onclick : 'new Function("onRemunerationInfo();")'
	// } ];
	var _userAdd = "onOpenPress()";
	// 设置房产的操作组
	var _imageOnclick = [
			{
				id : "id1",
				image : "house/images/fangchanxiugai.png",
				imageName : "修改出版社",
				onclick : 'new Function("onUpRePressType();")'
			},
			{
				id : "id2",
				image : "house/images/Delete.png",
				imageName : "删除出版社",
				onclick : 'new Function("delRePressType();")'
			},
			{
				id : "id3",
				image : "house/images/Install.png",
				imageName : "稿酬添加",
				onclick : 'new Function("	_newPress=_allRePressType.get(window.cooID).original;onAddPublishPage();")'
			} ];
	// 操作加入至页面栏
	eval("window.userAddCoo=_userAdd;");
	eval("window._lodingOnclick=_imageOnclick;");
	// 打开时绑定数据源
	if (_allRePressType == null || _allRePressType.size() == 0) {
		remunerationData.isGetRePressType(_oneRemuneration.id, function(data) {
			if (data != null && data.length != 0) {
				_allRePressType = isReturnPageData(data, 'ptid', 'pressName');
			}
		});
	}
}
// 弹出添加出版社
function onOpenPress() {
	onPutong('出版社信息', document.getElementById("addPressType"),
			"onaddRePressType(0)");
	qingping2();
}
// 弹出出版社历史
function onOpenLishi() {
	art.dialog({
		id : 'lishiPage',
		title : "历史出版社",
		content : document.getElementById("allPressType"),
		lock : true
	});
	remunerationData.isGetAllRePressType(_userID, function(data) {
		_allUserRePressType = isReturnPageData(data, 'ptid', 'pressName');
		DWRUtil.removeAllRows("allPressPage");
		DWRUtil.addRows("allPressPage", data, [ function(obj) {
			return "<a href='#' ptid='" + obj.ptid
					+ "' onclick='onlishichuban(this)'>" + obj.pressName
					+ "</a>";
		} ]);
	});

}
// 历史填充
function onlishichuban(obj) {
	var _obj = _allUserRePressType.get(obj.ptid);
	$('pressName').value = _obj.original.pressName;
	_newPress = _obj.original;
	_isSave = false;
	art.dialog({
		id : 'lishiPage'
	}).close();
}
// 保存开关
var _isSave = true;
// 新出版社
var _newPress;
// 保存出版社
function onaddRePressType(data) {
	if ($('pressName').value == null || $('pressName').value == '')
		onErroeAlert('您没有填写完全');
	else {
		var _obj = {
			uid : _userID,
			pressName : $('pressName').value
		};
		if (data == 0) {
			var _data;
			if (_isSave) {
				remunerationData
						.addRePressType(
								_obj,
								function(data) {

									if (data != null) {
										// 获取一个新的
										_newPress = data;
										_data = isReturnPageData(data, 'ptid',
												'pressName');
									} else {
										// 刷新总组
										remunerationData
												.isGetAllRePressType(
														_userID,
														function(data) {
															_allUserRePressType = isReturnPageData(
																	data,
																	'ptid',
																	'pressName');
														});
										// 取得对象
										for ( var i = 0; i < _allUserRePressType
												.values().length; i++) {
											if (_allUserRePressType.values()[i].name == $('pressName').value) {
												// 获取到对象
												_newPress = _allUserRePressType
														.values()[i].original;
												_data = _allUserRePressType
														.values()[i];
											}
										}
									}

								});
			} else {
				_isSave = true;
				_data = isReturnPageData(_newPress, 'ptid', 'pressName');
			}
			// 插入组，刷新
			_allRePressType.put(_data.id, _data);
			onRefreshMainPage("RePressTypePage", "RePressTypeMain",
					_allRePressType.values(), 150, 810);
			// 弹出添加稿酬的页面
			onAddPublishPage();
		} else {
			// 进行修改
			var _obj = _allRePressType.get(window.cooID);
			if (_obj.original.pressName != $('pressName').value) {
				_obj.original.pressName = $('pressName').value;
				_allRePressType.put(window.cooID, isReturnPageData(
						_obj.original, 'ptid', 'pressName'));
				// 修改数据库
				remunerationData.upRePressType(_obj.original);
			}
			onRefreshMainPage("RePressTypePage", "RePressTypeMain",
					_allRePressType.values(), 150, 810);
		}
	}
}
// 清屏2
function qingping2() {
	$('pressName').value = '';
}
// 删除出版社
function delRePressType() {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该出版社么？',
		lock : true,
		opacity : 0,
		ok : function() {
			art.dialog({
				title : '警告',
				content : '此次删除将删除该出版社的所有资料及所有历史',
				lock : true,
				opacity : 0,
				ok : function() {
					// 删除数据源
					_allRePressType.remove(window.cooID);
					remunerationData.delRePressType(window.cooID);
					// 刷新页面
					onRefreshMainPage("RePressTypePage", "RePressTypeMain",
							_allRePressType.values(), 150, 810);
					// 刷新报表
					var ptid;
					try {
						ptid = _allRePressType.values()[0].id;
					} catch (a) {
						ptid = 0;
					}
					onFindRemuByPress(_oneRemuneration.id, ptid);
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
// 修改出版社
function onUpRePressType() {
	var _obj = _allRePressType.get(window.cooID);
	$('pressName').value = _obj.original.pressName;
	onPutong('出版社信息', document.getElementById("addPressType"),
			"onaddRePressType(1)");
}
// 弹出出版社信息
function onAddPublishPage() {
	// var atype = 0;
	// atype = onInt();
	// switch (atype) {
	// case 0:
	// document.getElementById("dchuban").style.display = "none";
	// document.getElementById("dzaiban").style.display = "block";
	// document.getElementById("djiayin").style.display = "block";
	// break;
	// case 1:
	// document.getElementById("dchuban").style.display = "block";
	// document.getElementById("dzaiban").style.display = "none";
	// document.getElementById("djiayin").style.display = "none";
	// break;
	// }
	art.dialog({
		id : 'gaochouaddPage',
		title : "出版类型",
		content : document.getElementById("addPublishPage"),
		lock : true
	});
}
// 弹出出版机构类型
function onInt() {
	if (window.wriRemuByPress != null && window.wriRemuByPress.length != 0) {
		for ( var i = 0; i < window.wriRemuByPress.length; i++) {
			if (window.wriRemuByPress[i].ptid == _newPress.ptid) {
				if (window.wriRemuByPress[i].publishType1 == 0) {
					atype = 0;
					return atype;
				} else {
					atype = 1;
				}
			} else {
				atype = 1;
			}
		}
	} else {
		atype = 1;
	}
	return atype;
}
// 弹出稿酬添加的页面
function addPublishPageAll(data, title) {
	onPutong(title, document.getElementById("addPublish"), "onSavePublishPage("
			+ data + ",0)");
	qingping3();
	DWRUtil.removeAllOptions("publishType2");
	DWRUtil.addOptions("publishType2", _publishType2, "id", "name");
}
// 保存稿酬
function onSavePublishPage(data, iou, objjson) {
	try {
		var obj1 = window.wriRemuByPress[objjson];
	} catch (a) {
		var obj1 = null;
	}
	if ($('publishTime').value != null && $('publishTime').value != ''
			&& $('publishNumber').value != null
			&& $('publishNumber').value != '') {
		var _obj = new Object();
		_obj.rid = _oneRemuneration.id;
		try {
			_obj.ptid = _newPress.ptid;
		} catch (a) {
			_obj.ptid = window.cooID;
		}
		_obj.uid = _userID;
		_obj.publishType1 = data;
		_obj.publishType2 = $('publishType2').value;
		_obj.publishTime = $('publishTime').value;
		_obj.taxed = onReturnHouseTaxType("taxed");
		_obj.publishNumber = $('publishNumber').value;
		_obj.taxNumber = 0;
		_obj.taxableNumber = 0;
		_obj.payOutNumber = 0;
		_obj.taxEdNumber = 0;
		if (iou == 0) {
			// 存储数据库并刷新
			remunerationData.addRePublish(_obj);
			onFindRemuByPress(_oneRemuneration.id, _obj.ptid);
			// 关闭
			onClose("gaochouaddPage");
		} else {
			_obj.pid = obj1.pid;
			_obj.rid = obj1.rid;
			_obj.ptid = obj1.ptid;
			_obj.publishType1 = obj1.publishType1;
			remunerationData.upRePublish(_obj);
			onFindRemuByPress(_oneRemuneration.id, window.cooID);
		}

		return true;
	} else {
		onErroeAlert("您没有填写完全");
	}
	// 关闭
	art.dialog({
		id : 'gaochouaddPage'
	}).close();

}
// 删除稿酬
function ondelRePublish(pid) {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该作品么？',
		lock : true,
		opacity : 0,
		ok : function() {
			remunerationData.delRePublish(pid);
			// 刷新
			onFindRemuByPress(_oneRemuneration.id, window.cooID);
		},
		okVal : '删除',
		cancelVal : '关闭',
		cancel : true
	});
}
// 弹出修改稿酬信息填充页面
function onUpPublish(obj) {
	var _a = window.wriRemuByPress[obj];
	onPutong("修改稿酬", document.getElementById("addPublish"),
			"onSavePublishPage(null,1," + obj + ")");
	DWRUtil.removeAllOptions("publishType2");
	for ( var i = 0; i < _publishType2.length; i++) {
		if (_publishType2[i].id == _a._publishType2) {
			DWRUtil.addOptions("publishType2", [ _publishType2[i] ], "id",
					"name");
		}
	}
	DWRUtil.addOptions("publishType2", _publishType2, "id", "name");
	onReturnHouseTaxType("taxed", _a.taxed);
	$('publishTime').value = _a.publishTime;
	$('publishNumber').value = _a.publishNumber;
}
// 清屏3
function qingping3() {
	$('publishTime').value = '';
	$('publishNumber').value = '';
}
//打开某作品的报表
function onOpenRemuReport() {
	art.dialog({
		title : "稿酬信息",
		content : document.getElementById("report"),
		ok : function() {
			this.title('3秒后自动关闭').time(3);
			return false;
		},
		cancelVal : '关闭',
		cancel : true
	});
}
// 打开全局报表
function onOpenFullRemuReport() {
	art.dialog({
		title : "稿酬全局信息",
		content : document.getElementById("allReport"),
		ok : function() {
			this.title('3秒后自动关闭').time(3);
			return false;
		},
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

// 关闭某弹出窗
function onClose(cid) {
	if (cid != null && cid != '')
		art.dialog({
			id : cid
		}).close();
	else
		return;
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