function onrollout() {
    tmp = findSWF("ofc");
    x = tmp.rollout();
}

function onrollout2() {
    tmp = findSWF("ofc");
    x = tmp.rollout();
}

function findSWF(movieName) {
    if (navigator.appName.indexOf("Microsoft") != -1) {
        return window[movieName];
    } else {
        return document[movieName];
    }
}
function drawHg(hight, width, title, valueData, linksData, xLabels, max, id) {
    var so = new SWFObject("/TaxPersonalReporting1.0/paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", hight, width, "9", "#FFFFFF");
    so.addVariable("variables", "true");
    so.addVariable("title", title + ",{font-size: 20;}");
    so.addVariable("y_legendx", "Open Flash Chart,12,0x736AFF");
    so.addVariable("y_label_size", "15"); //不起啥作用
    so.addVariable("y_ticks", "5,10,4"); //控制
    so.addVariable("bar", "50,0x9933CC,￥,10");
    so.addVariable("values", valueData);
    so.addVariable("links", linksData);
    so.addVariable("x_labels", xLabels);
    so.addVariable("x_labels", xLabels);
    so.addVariable("x_axis_steps", "1");
    so.addVariable("y_max", max);
    so.addParam("allowScriptAccess", "always");
    so.addParam("onmouseout", "onrollout2();");
    so.write(id);

}
function findLaborYearHg(yearAll) {
    laborReportD.findLaborYear(window.sessionUID, yearAll,
    function(data) {
        eval("window.dataHgYear = data;");
        drawLaborYearHg();
    });
}

function findLaborItemHg(lid) {
    laborReportD.findLaborItem(window.sessionUID, yearAll, lid,
    function(data) {
        eval("window.dataHgItem = data;");
        drawLaborItemHg();
    });
}
function findLaborMonthHg(ltid) {
    laborReportD.findLaborMonth(window.sessionUID, yearAll, ltid,
    function(data) {
        eval("window.dataHgMonth = data;");
        drawLaborMonthHg();

    });
}
function drawLaborYearHg() { //年劳务报酬
    var hight, width, title, id;
    var valueData = "";
    var linksData = "";
    var xLabels = "";
    //var max=parseFloat(window.dataHgYear[0].payOutNumSum);
    if (window.dataHgYear == null || window.dataHgYear == "") document.getElementById("JKDiv_1").innerHTML = "<center><a style='text-decoration: underline;color:#0000cc;font-size:15px;margin-top:60px;' href='#'>该年无劳务报酬记录</a></center>";
    else {
        var max = parseFloat(window.dataHgYear[0].payOutNumSum);
        hight = "600";
        width = "300";
        for (var i = 0; i < window.dataHgYear.length; i++) {
            //if(window.dataHgYear[i].payOutNumSum==null || window.dataHgYear[i].payOutNumSum==""){
            //window.dataHgYear[i].payOutNumSum=0;

            //}
            valueData += window.dataHgYear[i].payOutNumSum + ",";
            xLabels += window.dataHgYear[i].companyName + ",";
            linksData += "javascript:findLaborItemHg('" + window.dataHgYear[i].lid + "'),";
            if (max < parseFloat(window.dataHgYear[i].payOutNumSum)) {
                max = parseFloat(window.dataHgYear[i].payOutNumSum);
            }
        }
        valueData = valueData.substring(0, valueData.length - 1);
        xLabels = xLabels.substring(0, xLabels.length - 1);
        linksData = linksData.substring(0, linksData.length - 1);
        title = window.dataHgYear[0].laborYear.substring(0, 7) + "年劳务报酬";
        id = "JKDiv_1";
        drawHg(hight, width, title, valueData, linksData, xLabels, max, id);
    }
}
function drawLaborItemHg() { //公司项目
    var hight, width, title, id;
    var valueData = "";
    var linksData = "";
    var xLabels = "";
    var max = parseFloat(window.dataHgItem[0].itemNumSum);
    if (window.dataHgItem == null || window.dataHgItem == "") alert("");
    else {
        hight = "600";
        width = "300";
        for (var i = 0; i < window.dataHgItem.length; i++) {
            valueData = valueData + window.dataHgItem[i].itemNumSum + ",";
            xLabels = xLabels + window.dataHgItem[i].itemName + ",";
            linksData += "javascript:findLaborMonthHg(" + window.dataHgItem[i].ltid + "),";
            if (max < parseFloat(window.dataHgItem[i].itemNumSum)) {
                max = parseFloat(window.dataHgItem[i].itemNumSum);
            }
        }
        valueData = valueData.substring(0, valueData.length - 1);
        xLabels = xLabels.substring(0, xLabels.length - 1);
        linksData = linksData.substring(0, linksData.length - 1);
        title = "项目";
        id = "JKDiv_1";
        drawHg(hight, width, title, valueData, linksData, xLabels, max, id);
    }
}
function drawLaborMonthHg() { //某项目各月明细
    var hight, width, title, id;
    var valueData = "";
    var linksData = "";
    var xLabels = "";
    var max = parseFloat(window.dataHgMonth[0].payOutNum);
    if (window.dataHgMonth == null || window.dataHgMonth == "") alert("");
    else {
        hight = "600";
        width = "300";
        for (var i = 0; i < window.dataHgMonth.length; i++) {
            valueData = valueData + window.dataHgMonth[i].payOutNum + ",";
            xLabels = xLabels + window.dataHgMonth[i].laborInDay + ",";
            if (max < parseFloat(window.dataHgMonth[i].payOutNum)) {
                max = parseFloat(window.dataHgMonth[i].payOutNum);
            }
        }
        valueData = valueData.substring(0, valueData.length - 1);
        xLabels = xLabels.substring(0, xLabels.length - 1);
        title = "项目各月明细";
        id = "JKDiv_1";
        drawHg(hight, width, title, valueData, linksData, xLabels, max, id);
    }
}