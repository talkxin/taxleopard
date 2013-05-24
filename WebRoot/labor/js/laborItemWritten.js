var itemR;
var itemName;
var year;
var _laborMonthreportArray=new Array();
var _laborMonthreport;
function yearPie() {
    //点击年下拉框调用此方法
    year = document.getElementById("nian").value;
    findWriLaborItem(year, window.cooID);
}
function selYear() {
    var myYear = new Date().getFullYear();
    var sel = document.getElementById("nian");
    for (var i = 0; i < sel.options.length; i++) {
        if (sel.options[i].value == myYear) {
            sel.options[i].selected = true;
        }
    }
}

var kaiguan;
function showRow(ltid) {
    var h = "tr[class='" + ltid + "']"
    var trs = j$(h);
    for (var i = 0; i < trs.length; i++) {
        trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
    }
    kaiguan = false;
}

function findWriLaborItem(year, lid) {
    //查询某用户某年在某公司的各项目
    kaiguan = false;
    laborReportD.findLaborItem(window.sessionUID, year, lid, callItem);
}
function findWriLaborMonth(ltid) { //查询某用户某年在某公司某个项目各月的明细
    if (kaiguan == false) {
        itemR = "#item" + ltid;
        if(onReturnMonthreport(ltid)){
        laborReportD.findLaborMonth(window.sessionUID, year, ltid, function(data){
        	_laborMonthreportArray.unshift({id:ltid,value:data});
        	_laborMonthreport={id:ltid,value:data};
        });
        }
        eval("window.itemMonth = _laborMonthreport.value;");
        var monthData = "";
        for (var j = 0; j < window.itemMonth.length; j++) {
            monthData += "<tr class=\"" + window.itemMonth[j].ltid + 
            "\" id=\"t0-" + j + "\" style=\"text-align:center\"><td class=\"lie\">" + 
            window.itemMonth[j].laborInDay + "</td><td class=\"lie\">" + 
            window.itemMonth[j].payOutNum + "</td><td class=\"lie\">" + 
            window.itemMonth[j].taxNum + 
            "</td><td class=\"lie\"><input type=\"button\" value=\"修改\" onclick=\"upService("+ltid+","+j+");\"/>" + 
            "<input type=\"button\" value=\"删除\" onclick=\"delService("+ltid+","+j+");\"/></td></tr>";

        }
        j$(itemR).html(monthData);
        kaiguan = true;
    } else {
        showRow(ltid);
    }
}
function callItem(data) {
    eval("window.cooitem = data;");
    var laborItemData = "<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">" + "<tr ><td class=\"lie\" width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">项目</span></td>" + "<td class=\"lie\" width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">数额（人民币）￥</span></td>" + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额（人民币）￥</span></td>" + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">操作</span></td></tr>"
    for (var j = 0; j < window.cooitem.length; j++) {
        laborItemData += "<tr onclick=\"findWriLaborMonth('" + window.cooitem[j].ltid + "')\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\" align=\"left\" height=\"30px\"><a"

        + " href=\"#\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\" style=\"margin-right:10px; border:0;\" /></a><span style=\"font-weight:bold\">"

        + window.cooitem[j].itemName + "</td><td class=\"lie\" style=\"text-align:center\">" + window.cooitem[j].itemNumSum + "</td><td class=\"lie\" style=\"text-align:center\">"

        + window.cooitem[j].itemTaxSum + "</td><td class=\"lie\"></td></tr><p id=\"item" + window.cooitem[j].ltid

        + "\"></p>";
    }
    laborItemData += "</table>";
    if (window.cooitem == null || window.cooitem == "") {
        //alert("无信息");
        document.getElementById("report").innerHTML = "<center><a style='text-decoration: underline;color:#0000cc;font-size:15px;margin-top:60px;' href='#'>该年无劳务报酬记录</a></center>";
    }

    else j$("#report").html(laborItemData);
}
//判断有没有该数据
function onReturnMonthreport(ltid){
    for ( var i = 0; i < _laborMonthreportArray.length; i++) {
		if(_laborMonthreportArray[i].id==ltid){
			_laborMonthreport=_laborMonthreportArray[i];
			return false;
		}
	}
    return true;
}

//向报表插一条数据
function addCooItem(objItem, objItemMonth) {
    window.itemMonth.unshift(objItemMonth);
    var isItemTrue = false;
    var ids;
    for (var i = 0; i < window.cooitem.length; i++) {
        if (window.cooitem[i].ltid == objItem.ltid) {
            dengyu = true;
            ids = i;
        }
    }
    if (!dengyu) {
        objItem.itemNumSum = objItemMonth.payOutNumber;
        objItem.itemTaxSum = objItemMonth.taxNumber;
        window.cooitem.unshift(objItem);
    } else {
        window.cooitem[ids].itemNumSum += objItemMonth.payOutNumber;
        window.cooitem[ids].itemTaxSum += objItemMonth.taxNumber;
    }
}
//修改报表
function upCooItem(objItemMonth) {
    var cooitemID;
    for (var i = 0; i < window.itemMonth.length; i++) {
        if (window.itemMonth[i].lsid == objItemMonth.lsid) {
            cooitemID = window.itemMonth[i].ltid;
            if (window.itemMonth[i].ltid == objItemMonth.itid) {
                window.cooitem[cooitemID].itemNumSum += objItemMonth.payOutNumber - window.itemMonth[i].payOutNumber;
                window.cooitem[cooitemID].itemTaxSum += objItemMonth.taxNumber - window.itemMonth[i].taxNumber;
            } else if (window.itemMonth[i].ltid != objItemMonth.itid) {
                window.cooitem[cooitemID].itemNumSum - window.itemMonth[i].payOutNumber;
                window.cooitem[cooitemID].itemTaxSum - window.itemMonth[i].taxNumber;
            }
        }
    }
}

function toAddItem() {
    document.getElementById("laborReport").style.display = "none";
    openLayer("laborPage", "addLaborService");
    getProvince();
}