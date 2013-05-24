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
var _onloadPageclick="onfindOccasionalInfo(a);";
// 关闭窗口是触发的方法
var _onWindowCloseclick;
// 记录窗口id
var _isWindowCloseclickID;
// 特许权类型
var _occasionalType = [ {
	id : 0,
	name : '购买体育彩票的中奖收入'
}, {
	id : 1,
	name : '购买社会福利有奖募捐奖券一次中奖收入'
}, {
	id : 2,
	name : '单张有奖发票奖金'
}, {
	id : 3,
	name : '其他'
} ];
var _userID;
window.onload = function() {
	DWREngine.setAsync(false);
	paychexD.getUser(function(data) {
		_userID = data["userId"];
	});
	mainPage();
	onRefreshMainPage("occaPage", "occaMain", _allOcca.values(),
			150, 810);
};
// 存数所有特许权作品
var _allOcca= new JHashMap();
// 主页面模具
function mainPage() {
	// 初始化图片路径
	eval("window.addImg = 'house/images/Addhouse.png';");
	eval("window.loadImg = 'house/images/House.png';");
	eval("window.baobiaoImg = 'house/images/report2.png';");
	// 初始化最后一张图片的名称
	eval("window.lastName = '添加'");
	// 设置添加偶然所得的按钮
	var _userAdd = "onOpenOcca()";
	// 设置房产的操作组
	var _imageOnclick = [ {
		id : "id1",
		image : "house/images/fangchanxiugai.png",
		imageName : "修改",
		onclick : 'new Function("onOpenUpOcca()")'
	}, {
		id : "id2",
		image : "house/images/Delete.png",
		imageName : "删除",
		onclick : 'new Function("ondelOcca();")'
	}, {
		id : "id3",
		image : "house/images/Install.png",
		imageName : "添加信息",
		onclick : 'new Function("onaddOccaInfo()")'
	} ];
	// 操作加入至页面栏
	eval("window.userAddCoo=_userAdd;");
	eval("window._lodingOnclick=_imageOnclick;");

	// 开始加载页面缓存
	if (_allOcca == null || _allOcca.size() == 0) {
		occasionalD.isGetOccasionalDwr(_userID, function(data) {
			if (data != null && data.lengtn != 0) {
				_allOcca = isReturnPageData(data, "oid",
						"occasionalName");
			}
		});
	}
}
// 弹出添加专利信息
function onOpenOcca() {
	onPutong("添加偶然所得", document.getElementById("addOcca"),
			"onaddOcca(0)");
	$('occasionalName').value = '';
}
// 弹出修改专利信息
function onOpenUpOcca() {
	onPutong("修改偶然所得", document.getElementById("addOcca"),
			"onaddOcca(1," + window.cooID + ")");
	// 填充页面
	var _obj = _allOcca.get(window.cooID);
	$('occasionalName').value = _obj.original.occasionalName;
}
// 保存或修改
function onaddOcca(data, id) {
	var _obj = new Object();
	_obj.uid = _userID;
	_obj.occasionalName = $('occasionalName').value;
	//_obj.charteredInfoType = 0;
	if (data == 0) {
		occasionalD.addOccasionalDwr(_obj, function(data) {
			if(data!=null){
			var a = isReturnPageData(data, "oid", "occasionalName");
			_allOcca.put(a.id, a);
			// 刷新页面
			onRefreshMainPage("occaPage", "occaMain", _allOcca
					.values(), 150, 810);
			}else
				onErroeAlert("该名称已存在");
		});
	} else {
		_obj.oid = id;
		_allOcca.get(id).name = _obj.occasionalName;
		_allOcca.get(id).original.occasionalName = _obj.occasionalName;
		// occasionalD.upCrCharteredInfo(_obj);
		// 刷新页面
		onRefreshMainPage("occaPage", "occaMain", _allOcca
				.values(), 150, 810);
	}
}
// 删除特许权
function ondelOcca() {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该偶然所得么？',
		lock : true,
		opacity : 0,
		ok : function() {
			art.dialog({
				title : '警告',
				content : '此次删除将删除该所得所有资料',
				lock : true,
				opacity : 0,
				ok : function() {
					occasionalD.delOccasionalDwr(window.cooID);
					_allOcca.remove(window.cooID);
					// 刷新页面
					onRefreshMainPage("occaPage", "occaMain",
							_allOcca.values(), 150, 810);
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
function onaddOccaInfo() {
	onPutong("添加偶然所得信息", document.getElementById("addOccaInfo"),
			"onSaveOcca(0)");
	// 加载类型
	DWRUtil.removeAllOptions("occasionalType");
	DWRUtil.addOptions("occasionalType", _occasionalType, "id", "name");
	// 清屏
	$('occasionalTime').value = '';
	$('occasionalNumber').value = '';
}
// 弹出修改特许权
function onupOccaInfo(_obj) {
	onPutong("修改特许权信息", document.getElementById("addOccaInfo"),
			"onSaveOcca(1," + _obj.oiid + ")");
	$('occasionalTime').value = _obj.occasionalTime;
	$('occasionalNumber').value = _obj.occasionalNumber;
	onReturnHouseTaxType("taxed", _obj.taxed);
	// 加载类型
	DWRUtil.removeAllOptions("occasionalType");
	for ( var i = 0; i < _occasionalType.length; i++) {
		if (_occasionalType[i].id == _obj.occasionalType) {
			DWRUtil.addOptions("occasionalType", [ _occasionalType[i] ], "id",
					"name");
		}
	}
	DWRUtil.addOptions("occasionalType", _occasionalType, "id", "name");
}
// 保存或修改
function onSaveOcca(data, oiid) {
	if ($('occasionalNumber').value != null && $('occasionalTime').value != null
			&& $('occasionalNumber').value != '' && $('occasionalTime').value != ''
			) {
		var _obj = new Object();
		_obj.uid = _userID;
		_obj.oid = window.cooID;
		_obj.occasionalNumber = $('occasionalNumber').value;
		_obj.occasionalTime=$('occasionalTime').value;
		_obj.taxed = onReturnHouseTaxType("taxed");
		_obj.occasionalType = $('occasionalType').value;
		_obj.taxNumber = 0;
		_obj.taxableNumber = 0;
		
        if (data == 0) {
			
        	occasionalD.addOccasionalInfoDwr(_obj);
		} else {
			_obj.oiid = oiid;
			occasionalD.upOccasionalInfoDwr(_obj);
		}
		onfindOccasionalInfo(window.cooID);
	} else
		onErroeAlert("您没有填写完全");
}
// 删除特许权历史信息
function ondelOccaInfo(oiid) {
	art.dialog({
		title : '警告',
		icon : 'warning',
		content : '您确定要删除该所得么？',
		lock : true,
		opacity : 0,
		ok : function() {
			occasionalD.delOccasionalInfoDwr(oiid);
			//刷新
			onfindOccasionalInfo(window.cooID);
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



//以下为报表


   //根据某个偶然所得的名字查
   function onfindOccasionalInfo(oid){
	   
       	 occasionalD.findByIdDwr(_userID,oid, function(data){
     		eval("window.wriOccasional=data;");
     		onCallOccasional();
           });
         }
   
   function onCallOccasional(){
		if (window.wriOccasional != null && window.wriOccasional != "") {	
			var _obj;
			j$("#occaBody").html("");
			
		    for (var j = 0; j < window.wriOccasional.length; j++) {
		    	var _occaData="";
		    	
		    	_occaData= "<tr onclick=\"\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\">"

		        + "<span style=\"font-weight:bold\">"+ window.wriOccasional[j].occasionalName 
		        
		        + "</td><td class=\"lie\">" + window.wriOccasional[j].occasionalTime
		        + "</td><td class=\"lie\">" + window.wriOccasional[j].occasionalNumber
		        + "</td><td class=\"lie\">" + window.wriOccasional[j].taxNumber
		    	+ "</td><td class=\"lie\"><input type=\"button\" value=\"修改\" onclick=\"onupOccaInfo(window.wriOccasional["+j+"])\"/>" 
	            + "<input type=\"button\" value=\"删除\" onclick=\"ondelOccaInfo("+window.wriOccasional[j].oiid+")\"/></td></tr>";
		    	
		    	j$("#occaBody").append(_occaData);
		    }
			  
		  }
		  else{
			  j$("#occaBody").html("");
			  j$("#occaBody").html("<tr><td colspan=\"9\"><h1 style='color:#FA0707;font-size:18px;border: 3px solid #abadac;'>没有该所得信息</h1></td></tr>");
		  }

	}