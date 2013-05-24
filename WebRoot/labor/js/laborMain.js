//用户工作组
var userService=new Array();
// 判断修改还是添加还是无操作
var isUpOrAdd = 0;
// 判断是修改工作还是添加共组
var isServiceUOA = false;
//是否需要加载全局报表
var _isitBaobiao=true;
// 工作修改时对象
var upUserService;
//点击图片时触发的方法
var _onloadPageclick;
// 创建报表图标
var baobiaoIco = {
    id: 'baobiao',
    name: ''
};
// 报表打开事件存储
var BaobiaoOnclick = "openLayer('laborPage','laborYearReport',600,320);selYear();yearTurn();";
// 页面加载时事件
window.onload = function() {
	//关闭dwr异步
	DWREngine.setAsync(false);
    // 初始化图片路径
    eval("window.addImg = 'labor/images/Addcompany.png';");
    eval("window.loadImg = 'labor/images/NewCompany.png';");
    eval("window.baobiaoImg = 'labor/images/report2.png';");
    // 初始化最后一张图片的名称
    eval("window.lastName = ''");
    // 获取session中的值
    
    paychexD.getUser(function(data) {
        var id = data["userId"];
        eval("window.sessionUID = id;");
    });
    // 设置按钮展开事件
//    var userAddCoo = [{
//        id: "id1",
//        image: "labor/images/Addcompany.png",
//        imageName: "添加公司",
//        onclick: 'new Function("isOpenAddCompany(\'添加公司\');isGetHY();")'
//    }];
    var userAddCoo="isOpenAddCompany(\'添加公司\');isGetHY();";
    eval("window.userAddCoo=userAddCoo;");
    var CooOnclick = [    {
        id: "id2",
        image: "labor/images/Delete.png",
        imageName: "",
        onclick: 'new Function("delCoo();")'
    },    {
        id: "id4",
        image: "labor/images/update.png",
        imageName: "",
        onclick: 'new Function("isOpenAddCompany(\'修改公司\');loadCooInfo();")'
    },{
        id: "id1",
        image: "labor/images/Addwork.png",
        imageName: "",
        onclick: 'new Function("isOpenAddService(\'添加工作\');getProvince();")'
    },
    {
        id: "id3",
        image: "labor/images/history.png",
        imageName: "",
        onclick: 'new Function("isOpenCooP();")'
    }];
    eval("window._lodingOnclick=CooOnclick;");
    // 初始化绑定页面
    isGetUserCoo();
}
// 添加公司还是修改
function isOpenAddCompany(str) {
    document.getElementById("innerAddCompany").Value = str;
    openLayer('laborPage', 'addCompany',600,320);
}
// 添加工作还是修改工作
function isOpenAddService(str) {
    document.getElementById("innerAddService").Value = str;
    openLayer('laborPage', 'addLaborService',600,320);
}
// 打开公司报表绑定公司名
function isOpenCooP() {
    openLayer('laborPage', 'laborReport',600,320);
    if (window.pageData != null) {
        for (var i = 0; i < window.pageData.length; i++) {
            if (window.cooID == window.pageData[i].id) {
                document.getElementById("isInnerCoo").value = window.pageData[i].name;
            }
        }
    }
    selYear();
    yearPie();
}
// 获取行业
function isGetHY() {
    laborServiceDwr.isGetIndustry(function(data) {
        DWRUtil.removeAllOptions('industry');
        DWRUtil.addOptions('industry', data, 'piid', 'industryName');
    });
}
// 转向paychex
function toPaychex() {
    window.location.href = 'paychexin';
}
// 存储公司
function saveCoo() {
    var a = false;
    if ($('companyName').value != null && $('companyName').value != "") {
        var coo = new Object();
        coo.lid = 0;
        coo.uid = window.sessionUID;
        coo.companyName = $('companyName').value;
        coo.laborType = $('laborType').value;
        coo.industry = $('industry').value;
        laborServiceDwr.isSaveCoo(coo,
        function(data) {
            if (data != null) {
                if (window.pageData == null) {
                    eval("window.pageData = new Array();");
                }
                window.pageData.unshift({
                    id: data.lid,
                    name: data.companyName,
                    laborType: data.laborType,
                    industry: data.industry
                });
                if (window.pageData.length == 1) {
                    // 添加报表图标
                    window.pageData.unshift(baobiaoIco);
                }
                a = true;
            } else {
                alert("该公司已存在");
            }
        });
        return a;
    } else {
        alert("您没有填写完全");
        return a;
    }
}
// 加载公司信息
function loadCooInfo() {
    for (var int = 0; int < window.pageData.length; int++) {
        if (window.pageData[int].id == window.cooID) {
            var coo = window.pageData[int];
            $('companyName').value = coo.name;
            $('laborType').value = coo.laborType;
            laborServiceDwr.isGetIndustry(function(data) {
                DWRUtil.removeAllOptions('industry');
                for (var int2 = 0; int2 < data.length; int2++) {
                    if (data.piid == coo.industry) {
                        var ind = data[int2];
                        DWRUtil.addOptions('industry', ind, 'piid', 'industryName');
                    }
                }
                DWRUtil.addOptions('industry', data, 'piid', 'industryName');
            });
            document.getElementById("addTocoo").onclick = function() {
                upCoo();
            }
        }
    }
}
// 修改公司信息
function upCoo() {
    if ($('companyName').value != null && $('companyName').value != "" && $('laborType').value != null && $('laborType').value != "" && $('industry').value != null && $('industry').value != "") {
        var coo = new Object();
        coo.lid = window.cooID;
        coo.uid = window.sessionUID;
        coo.companyName = $('companyName').value;
        coo.laborType = $('laborType').value;
        coo.industry = $('industry').value;
        laborServiceDwr.isupCoo(coo);
        document.getElementById("addTocoo").onclick = function() {
            addCompanyName();
        }
        // 修改完后重新加载页面
        for (var int = 0; int < window.pageData.length; int++) {
            if (window.pageData[int].id == window.cooID) {
                window.pageData[int] = {
                    id: coo.lid,
                    name: coo.companyName,
                    laborType: coo.laborType,
                    industry: coo.industry
                };
                window.pageData[int].name;
            }
        }
        reviveDiv("laborPage", "laborPageMain");
        j$(function() {
            onServiceLoad("laborPage", 610, 830, window.pageData);
        });
        closeLayer();
    } else {
        alert("您没有填写完全");
    }
}

// 删除公司信息
function delCoo() {
    if (confirm('您需要删除该公司么？')) {
        if (confirm('本次删除将删除该公司目录下的所有数据')) {
            for (var int = 0; int < window.pageData.length; int++) {
                if (window.pageData[int].id == window.cooID) {   window.pageData.splice(int, 1);
                }
            }
            if (window.pageData.length == 1) {
                window.pageData = null;
            }
            reviveDiv("laborPage", "laborPageMain");
            j$(function() {
                onServiceLoad("laborPage", 610, 830, window.pageData);
            });
            laborServiceDwr.isdelCoo(window.cooID);
        }
    }
}

// 获取数据库中的list
function isGetUserCoo() {
    laborServiceDwr.isGetUserCoo(window.sessionUID,
    function(data) {
        if (data != null && data.length != 0) {
            var ind = isRetuenPageData(data);
            eval("window.pageData=ind");
            window.pageData.unshift(baobiaoIco);
        } else {
            eval("window.pageData=null;");
        }
        j$(function() {
            onServiceLoad("laborPage", 610, 830, window.pageData);
        });
    });
}

// 查询已有项目
function isGetItem() {
    if ($('selectItem').style.display != "none") {
        laborServiceDwr.isGetCooItem(window.cooID,
        function(data) {
            if (data != null && data.length != 0) {
                DWRUtil.removeAllRows("cooItem");
                DWRUtil.addRows("cooItem", data, [
                function(object) {
                    return '<a href="#" onclick="onItemName(\'' + object.itemName + '\',\'' + object.ltid + '\');">' + object.itemName + '</p>';
                },
                function(object) {
                    return '<a href="#" cooItemName=\'' + object.itemName + '\' cooItemID=\'' + object.ltid + '\' onclick="isupItem(this);">修改</a> <a href="#" cooItemID=\'' + object.ltid + '\' onclick="isdelItem(this)">删除</a>'
                }]);
            } else {
                DWRUtil.addRows("cooItem", data, [function(object) {return '该公司下没有项目';},
                ]);}
        });
    }
}
// 绑定项目名称
function onItemName(value, id) {
    $('itemName').value = value;
    eval("window.cooItemID=id");
    display('selectItem');
}
// 将变成添加项目
function isUpOrAddToup() {
    isUpOrAdd = 0;
}
// 添加未知项目
function isaddItem() {
    var obj = new Object();
    obj.lid = window.cooID;
    obj.uid = window.sessionUID;
    obj.itemName = $('itemName').value;
    laborServiceDwr.addCooItem(obj,
    function(data) {
        eval("window.cooItemID=data.ltid;");
    });
}
// 删除某项目
function isdelItem(obj) {
    if (confirm('您需要删除该项目么？')) {
        var id = obj.cooItemID;
        laborServiceDwr.delCooItem(id);
        display("selectItem");
    }
}
// 修改某项目名
function isupItem(obj) {
    isUpOrAdd = 1;
    $('itemName').value = obj.cooItemName;
    window.cooItemID = obj.cooItemID;
    display("selectItem");
}
// 生成一个工作
function addService() {
    // 对项目名的操作
    if ($('itemName').value != '' && $('itemName').value != null && $('laborInDay').value != '' && $('laborInDay').value != -2 && $('laborAdd').value != -1 && $('laborNumber').value != '' && $('laborNumber').value != null) {
        if (isUpOrAdd == 1) {
            var item = {
                ltid: window.cooItemID,
                lid: null,
                uid: null,
                itemName: $('itemName').value
            };
            laborServiceDwr.upCooItem(item);
        } else if (isUpOrAdd == 0) {
            isaddItem();
        }
        var ed;
        var taxEdNumber;
        for (var int = 0; int < document.getElementsByName("laborTaxEd").length; int++) {
            if (document.getElementsByName("laborTaxEd")[int].checked) {
                ed = document.getElementsByName("laborTaxEd")[int].ed;
                if (ed == 0) {
                    taxEdNumber = $('laborTaxEdNumber').value;
                } else {
                    taxEdNumber = 0;
                }
            }
        }
        var taxNumber=null;
        var taxableNumber=null;
        var payOutNumber=null;
        if(parseFloat($('laborNumber').value)>800){
        taxNumber=(parseFloat($('laborNumber').value)-800)*0.2;
        taxableNumber=(parseFloat($('laborNumber').value)-800);
        payOutNumber=parseFloat($('laborNumber').value)-parseFloat(taxNumber);
        }
        var service = {
                lsid: null,
                lid: window.cooID,
                ltid: window.cooItemID,
                laborInDay: $('laborInDay').value,
                laborAdd: $('laborAdd').value,
                laborTaxEd: ed,
                laborTaxEdNumber: taxEdNumber,
                laborNumber: $('laborNumber').value,
                taxNumber: taxNumber,
                taxableNumber: taxableNumber,
                payOutNumber: payOutNumber,
                laborTaxNumber: 0
            };
        // 将不含税收入转为含税收入
//        service = taxedTotax(service);
        // 将工作填入组
        userService.unshift(service);
        return true;
    } else {
        alert("您的内容没有填写完全");
        return false;
    }
}
// 点击确认
function serviceReturn() {
    if (addService()) {
        if (confirm('您需要继续添加么？')) {
            $('itemName').value = '';
            $('laborInDay').value = '';
            $('laborNumber').value = '';
        } else {
            laborServiceDwr.addUserService(userService);
            userService = new Array();
            $('itemName').value = '';
            $('laborInDay').value = '';
            $('laborNumber').value = '';
            closeLayer();
        }
    }
}
// 点击取消，隐藏层
function serviceDis() {
    if (userService != null && userService.length != 0) {
        laborServiceDwr.addUserService(userService);
        userService = new Array();
    }
    $('itemName').value = '';
    $('laborInDay').value = ''; ('laborNumber').value = '';
    closeLayer();
}
// 点击删除某月工作
function delService(ltid,j) {
	var object;
	for ( var i = 0; i < _laborMonthreportArray.length; i++) {
		if(_laborMonthreportArray[i].id==ltid){
			object=_laborMonthreportArray[i].value[j]
		}
	}
    if (confirm('您需要删除该工作么？')) {
        for (var int = 0; int < window.itemMonth.length; int++) {
            if (window.itemMonth[int].lsid == object.lsid) {   
            	window.itemMonth.splice(int, 1);
            }
        }
        if (window.itemMonth.length == 0) {
            findWriLaborItem(year, window.cooID);
            // alert("该工作已无信息");
        }
        laborServiceDwr.delService(object.lsid);
        findWriLaborItem(year, window.cooID);
    }
}
// 点击修改按钮弹出层
function upService(ltid,j) {
    //eval("upUserService = "+j+";");
	//var object;
	for ( var i = 0; i < _laborMonthreportArray.length; i++) {
		if(_laborMonthreportArray[i].id==ltid){
			upUserService=_laborMonthreportArray[i].value[j]
		}
	}
    isOpenAddService('修改工作');
    getLaborAddName(upUserService.laborAdd);
    eval("window.SerivceID = upUserService.lsid;");
    $('itemName').value = upUserService.itemName;
    $('laborInDay').value = upUserService.laborInDay;
    $('laborNumber').value = upUserService.laborNumber;
    if (upUserService.laborTaxEd == 0) {
        document.getElementById("hanshui").checked = "checked";
        laborTaxEdNumberD(0);
    } else {
        document.getElementById("nothanshui").checked = "checked";
        laborTaxEdNumberD(1);
    }
    document.getElementById("addToUserService").onclick = function() {
        upServiceReturn();
    }

}
// 确认修改
function upServiceReturn() {
    var ed;
    var laborTaxEdNumber = 0;
    for (var int = 0; int < document.getElementsByName("laborTaxEd").length; int++) {
        if (document.getElementsByName("laborTaxEd")[int].checked) {
            ed = document.getElementsByName("laborTaxEd")[int].ed;
            if (ed == 0) {
                laborTaxEdNumber = $('laborTaxEdNumber').value;
            } else {
                laborTaxEdNumber = 0;
            }
        }
    }
    if ($('itemName').value != upService.itemName) {
        isaddItem();
        var ltid = window.cooItemID;
    } else {
        var ltid = upService.ltid;
    }
    if ($('itemName').value != upService.itemName || $('laborInDay').value != upService.laborInDay || $('laborInDay').value != upService.laborInDay || $('laborAdd').value != upService.laborAdd || $('laborNumber').value != upService.laborNumber) {
        var service = {
            lsid: window.SerivceID,
            ltid: ltid,
            laborInDay: $('laborInDay').value,
            laborAdd: $('laborAdd').value,
            laborTaxEd: ed,
            laborTaxEdNumber: laborTaxEdNumber,
            laborNumber: $('laborNumber').value,
            taxNumber: null,
            taxableNumber: null,
            payOutNumber: null
        };
        laborServiceDwr.upUserServicedwr(service);
    }
    document.getElementById("addToUserService").onclick = function() {
        serviceReturn();
    }
    serviceDis();
    openLayer("laborPage", "laborReport",600,320);
    var sel = document.getElementById("nian");
    for (var i = 0; i < sel.options.length; i++) {
        if (sel.options[i].value == year) {
            sel.options[i].selected = true;
        }
    }
    findWriLaborItem(year, window.cooID);
}
// 添加公司
function addCompanyName() {
    if (saveCoo()) {
        $('companyName').value = "";
        $('laborType').value = "";
        $('industry').value = "";
        closeLayer();

        // 重新绑定
        reviveDiv("laborPage", "laborPageMain");
        j$(function() {
            onServiceLoad("laborPage", 610, 830, window.pageData);
        });
    }
}
// 取消添加
function closAddCompanyName() {
    $('companyName').value = "";
    $('laborType').value = "";
    $('industry').value = "";
    closeLayer();
}

function display(id) {

    var traget = document.getElementById(id);
    if (traget.style.display == "none") {
        traget.style.display = "";
    } else {
        traget.style.display = "none";
    }
}
/* 只允许输入数字 */
function replaceNotNumber(hehe) {
    var pattern = /[^0-9|\.]/g;
    if (pattern.test(hehe.value)) {
        hehe.value = hehe.value.replace(pattern, "");
    }
}
// 重新构建div
function reviveDiv(delDiv, inDiv) {
    var div = document.getElementById(delDiv);
    div.parentNode.removeChild(div);
    document.getElementById(inDiv).innerHTML += "<div id='" + delDiv + "'></div>";
}
// 获取省
function getProvince() {
    paychexD.getProvince(1,
    function(data) {
        DWRUtil.removeAllOptions('laborCity');
        DWRUtil.addOptions('laborCity', [{
            pid: '-1',
            provinceName: '请选择省份'
        }], 'pid', 'provinceName');
        DWRUtil.addOptions('laborCity', data, 'pid', 'provinceName');
    });
}
// 获取市
function getCity(value) {
    paychexD.getCity(value,
    function(data) {
        DWRUtil.removeAllOptions('laborAdd');
        DWRUtil.addOptions('laborAdd', [{
            cid: '-1',
            langName: '请选择城市'
        }], 'cid', 'langName');
        DWRUtil.addOptions('laborAdd', data, 'cid', 'langName');
    });
}
// 以市求省求国家
function getLaborAddName(cid) {
    paychexD.getCityToProvinceToNation(cid,
    function(data) {
        DWRUtil.removeAllOptions('laborCity');
        DWRUtil.removeAllOptions('laborAdd');
        DWRUtil.addOptions('laborCity', [{
            pid: data.pid,
            provinceName: data.provinceName
        }], 'pid', 'provinceName');
        DWRUtil.addOptions('laborAdd', [{
            cid: data.cid,
            langName: data.cityLangName
        }], 'cid', 'langName');
    });
    paychexD.getProvince(cid,
    function(data) {
        DWRUtil.addOptions('laborCity', data, 'pid', 'provinceName');
    });
}
// 含税与否
function laborTaxEdNumberD(type) {
    var obj = document.getElementById("laborTaxEdNumberD");
    if (type == 0) {
        obj.style.display = "block";
    } else if (type == 1) {
        obj.style.display = "none";
    }
}
// 遍历返回数据结构
function isRetuenPageData(indata) {
    if (indata != null) {
        var outData = new Array();
        for (var i = 0; i < indata.length; i++) {
            var obj = {
                id: indata[i].lid,
                name: indata[i].companyName,
                laborType: indata[i].laborType,
                industry: indata[i].industry
            };
            outData.unshift(obj);
        }
        return outData;
    } else {
        return null;
    }
}
// 将单次含税收入转为不含税收入
function taxedTotax(data) {
    if (data.laborTaxEd == 1) {
        return data;
    } else {
        return data;
    }
}

function bian() {
    document.getElementById("button").style.display = "block";
}
function bian1() {
    document.getElementById("button").style.display = "none";
}