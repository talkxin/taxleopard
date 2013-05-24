//判断哪个ID触发关闭方法
var _isWindowCloseclickID;
// 页面加载时事件
window.onload = function() {
	// 关闭dwr异步
	DWREngine.setAsync(false);
	// 获取session中的用户ID
	paychexD.getUser(function(data) {
		var id = data["userId"];
		var pids = data["pids"];
		eval("window.sessionUID = id;");
		eval("window.userModule = pids;");
	});
	// 初始化应用栏
	loadingPage();
	// 初始化主操作
	onLoadAllPage();
	// 判断浏览器类型是否为IE9
	isBrowserType();
	
	adaptResolution('personalMain');
}
window.onresize=function(){
	adaptResolution('personalMain');
}
// 添加应用全局
var _insertApp = {
	pid : 'insertApp',
	moduleName : '添加应用',
	imageUrl : 'personalPage/smallImages/insertAppB.png',
	smallImages : 'personalPage/smallImages/insertApp.png',
	isOpen : 'personalPage/smallImages/insertApp.png',
	openUrl : '',
	closeUrl : ''
};
// 存储所有应用图标
var _AppAll=new JHashMap();
// 存储当前用户的应用图标
var _allUserApp = new JHashMap();
// 查询该用户的应用并初始化加载
function loadingPage() {
	var _add=isReturnPageData(_insertApp, "pid", "moduleName");
	if (_allUserApp == null || _allUserApp.size()==0) {
		if(window.userModule==null || window.userModule=='')
			window.userModule=0;
		personalPageD.isGetUserPersonal(window.userModule, function(data) {
			if(data!=null){
			_allUserApp.put(_add.id,_add);
			_allUserApp.putAll(isReturnPageData(data, "pid", "moduleName"));
			}else{
				_allUserApp.put(_add.id,_add);
					}
		});
	}
	var _trhtml = onLoadAppPage(_allUserApp.values(), 3);
	// 插入页面
	$(_trhtml).appendTo('#personalLeft');
}

// 生成代码
function onLoadAppPage(data, num) {
	var _isto = true;
	if (data.length <= num)
		_isto = false;
	var _trhtml = "<table><tr>";
	for ( var i = 0; i < data.length; i++) {
		if (_isto) {
			if (i % num == 0) {
				_trhtml = _trhtml + "</tr><tr>"
			}
		}
		_trhtml = _trhtml + "<td><div><img id='peo"+data[i].original.pid+"' alt='"
				+ data[i].original.moduleName + "' src='" + data[i].original.imageUrl
				+ "'  onclick='imageOnclick(this)'/><br/><p style='text-align:center;'>"
				+ data[i].original.moduleName + "</p></div></td>";
	}
	_trhtml = _trhtml + "</tr></table>";
	return _trhtml;
}

// 初始化页面
function onLoadAllPage() {
	$().ready(function() {
		$('#personalMain').resizable( {
			handler : '#personalDiv',
			onResize : function() {
				$.fn.jerichoTab.resize();
			}
		});
		$.fn.initJerichoTab( {
			renderTo : '#personalMain',
			uniqueId : 'myJerichoTab',
			tabs : [ {
				title : '首页',
				closeable : false,
				data : {
					dataType : 'formtag',
					dataLink : '#tbNews'
				},
				onLoadCompleted : function(h) {
					$('<div style="color:red" />').html('预留首页').appendTo(h);
				}
			} ],
			activeTabIndex : 0,
			loadOnce : true
		});
	});
}
// 点击打开某应用
function imageOnclick(obj) {
	var _dataLink;
	var imobj=_allUserApp.get(obj.id.split('peo')[1]).original;
	if (imobj.isOpen == 0)
		_dataLink = imobj.openUrl;
	else
		_dataLink = imobj.closeUrl;
	if (obj.id != 'peoinsertApp') {
		// 加载选项卡
		$.fn.jerichoTab.addTab( {
			tabFirer : $("#" + obj.id),
			title : imobj.moduleName,
			iconImg : imobj.smallImages,
			closeable : true,
			data : {
				dataType : 'iframe',
				dataLink : _dataLink
			}
		}).showLoader().loadData();
	} else {
		// 添加应用
		onInsertApp(obj, imobj,5);
	}
}
// 添加应用的页面
function onInsertApp(obj, imobj,len) {
	// 组成数组
	var _a;
	eval("_a=[" + window.userModule + "];");
	// 初始化数组
	if (_AppAll == null || _AppAll.size()==0) {
		personalPageD.isGetAllApp(function(data) {
			_AppAll = isReturnPageData(data, "pid", "moduleName");;
		});
	}
	var _List=_AppAll.values()
	// 是否换行
	var _isto = true;
	if (_List.length <= 10)
		_isto = false;
	var _trhtml = "<table cellspacing='0'><tr>";
	var _isInsertButton = "";
	for ( var i = 0; i < _List.length; i++) {
		if (_isto) {
			if (i % len == 0) {
				_trhtml = _trhtml + "</tr><tr>"
			}
		}

		if (in_array(_List[i].original.pid, _a)) {
			_isInsertButton = "<img id='peo1"+_List[i].original.pid+"' style='cursor:pointer;' src='personalPage/smallImages/shanchu.png'  class='left-1' onclick='onUpUserApp(this)'>";
		} else {
			_isInsertButton = "<img id='peo1"+_List[i].original.pid+"' style='cursor:pointer;' src='personalPage/smallImages/tianjia.png' class='left-1' onclick='onUpUserApp(this)'>";
		}

		_trhtml = _trhtml
				+ "<td><div id='yingYong' style='width:170px; height:100px;'><div class='left'><img width='50' height='50' class='left-1' id='"
				+ _List[i].original.pid
				+ "' alt='"
				+ _List[i].original.moduleName
				+ "' src='"
				+ _List[i].original.imageUrl
				+ "'/>"
				+ _isInsertButton
				+ "</div>  <div  class='right'><h4 class='STYLE1'>"
				+ _List[i].original.moduleName
				+ "</h4>"
				+ "<span style='color:#838B8B;font-size:10px;'>"+_List[i].original.introduce.substring(0, 10)
				+ "...</span><span style='text-decoration:underline;color:#0000CC;font-size:10px;cursor:pointer;' onclick='showIntroduce("+i+")'>查看详情</span></div></div> </td>";

	}
	_trhtml = _trhtml + "</tr></table>";

	// 展开选项卡
	$.fn.jerichoTab.addTab( {
		tabFirer : $("#" + obj.id),
		title : imobj.moduleName,
		iconImg : imobj.smallImages,
		closeable : true,
		data : {
			dataType : 'formtag',
			dataLink : '#tbNews'
		},
		onLoadCompleted : function(h) {
			$('<div/>').html(_trhtml).appendTo(h);
		}
	}).showLoader().loadData();

}

// 查看各个应用的详情
function showIntroduce(i){
	for ( var j = 0; j < _AppAll.values().length; j++) {
		if(i==j){
			var imgId="peo1"+_AppAll.values()[j].original.pid;
			art.dialog({
				title: _AppAll.values()[j].original.moduleName+"详情",
				content: "<p>"+"   "+_AppAll.values()[j].original.introduce+"</p>",
		        width: 200,
                follow:document.getElementById(imgId)
			   }
			);
		}
	}
}
// 修改用户应用
function onUpUserApp(obj) {
	// 组成数组
	var _a;
	eval("_a=[" + window.userModule + "];");
	// 修改页面
	var _imgObj=_AppAll.get(obj.id.split('peo1')[1]).original;
	if (in_array(_imgObj.pid, _a)) {
		var strs;
		strs = window.userModule.split(","); // 字符分割
		for (i = 0; i < strs.length; i++) {
			if (strs[i] == _imgObj.pid) {
				// 更改pid
				strs.splice(i, 1);

			}
		}
//		for ( var j = 0; j < _allUserApp.length; j++) {
//			if (_allUserApp[j].pid == _imgObj.pid){
				// 更改图片
				_allUserApp.remove(_imgObj.pid);
				document.getElementById("peo1"+_imgObj.pid).src="personalPage/smallImages/tianjia.png";
//			}
//		}
		// 重新组成
		window.userModule = strs.join(",");
	} else {
		window.userModule = window.userModule + "," + _imgObj.pid;
		var _newobj=isReturnPageData(_imgObj, "pid", "moduleName");
		_allUserApp.put(_newobj.id, _newobj);
		document.getElementById("peo1"+_imgObj.pid).src="personalPage/smallImages/shanchu.png";
	}
	// 修改数据库
	for(var i=0,len=window.userModule.length;i<len;i++){
		  if(!window.userModule[i]|| window.userModule[i]==''){
			  window.userModule.splice(i,1);
		  len--;
		  i--;
		  }
		  }
	personalPageD.upPersonal(window.sessionUID, window.userModule);
	reviveDiv('personalLeft', 'personalApp');
	// 修改应用
	loadingPage();
	if (!in_array(_imgObj.pid, _a)){
		var ob=document.getElementById("peo"+_imgObj.pid);
		imageOnclick(ob);
	}
}

function in_array(needle, haystack) {
	if (typeof needle == 'string' || typeof needle == 'number') {
		for ( var i in haystack) {
			if (haystack[i] == needle) {
				return true;
			}
		}
	}
	return false;
}

// 判断浏览器类型是否为IE9
function isBrowserType(){
//	var browser=navigator.appName;
//	var b_version=navigator.appVersion; 
//	var version=b_version.split(";"); 
//	var trim_Version=version[1].replace(/[ ]/g,""); 
//	if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") 
//	{ 
//	    alert("抱歉！本软件仅支持IE9以下版本。"); 
//	} 
}
// 适应分辨率
function adaptResolution(id){
	var main_j = document.documentElement.clientHeight-140;
	document.getElementById(id).style.height = main_j + 'px';
	var main_w = document.documentElement.clientWidth-262;
	document.getElementById(id).style.width = main_w + 'px';

}

//////////////////全局方法分割线/////////////////
//深度克隆对象
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

//转换json
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

//重新构建div
function reviveDiv(delDiv, inDiv) {
	var div = document.getElementById(delDiv);
	div.parentNode.removeChild(div);
	document.getElementById(inDiv).innerHTML += "<div id='" + delDiv
			+ "'></div>";
}
//只允许输入数字
function replaceNotNumber(hehe) {
	var pattern = /[^0-9|\.]/g;
	if (pattern.test(hehe.value)) {
		hehe.value = hehe.value.replace(pattern, "");
	}
}

//遍历数据源返回结构
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
//普通弹框
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

//弹出的错误框
function onErroeAlert(str) {
	art.dialog({
		title : '错误',
		content : str,
		icon : 'warning'
	});
}

//获取选中哪个
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
//刷新主页面
function onRefreshMainPage(delDiv, inDiv, data, height, width) {
	reviveDiv(delDiv, inDiv);
	j$(function() {
		onServiceLoad(delDiv, height, width, data);
	});
}
