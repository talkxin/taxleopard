function drawPie(hight, width, title, valueData, linksData, labelsData, tooltip, id) {
    var so = new SWFObject("/TaxPersonalReporting1.0/paychex/reportForm/actionscript/open-flash-chart.swf", "ofc", hight, width, "9", "#FFFFFF");
    so.addVariable("variables", "true");
    so.addVariable("title", title + ",{font-size: 20;}");
    so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
    so.addVariable("values", valueData);
    so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
    so.addVariable("links", linksData);
    so.addVariable("pie_labels", labelsData);
    so.addVariable("tool_tip", tooltip + "<br>#x_label#<br>Value: #val#");
    so.addParam("allowScriptAccess", "always");
    so.write(id);

}
function findLaborYearPie(yearAll) {
    laborReportD.findLaborYear(window.sessionUID, yearAll,
    function(data) {
        eval("window.dataPieYear = data;");
        drawLaborYearPie();
    });
}

function findLaborItemPie(lid) {
    laborReportD.findLaborItem(window.sessionUID, yearAll, lid,
    function(data) {
        eval("window.dataPieItem = data;");
        drawLaborItemPie();
    });
}
function findLaborMonthPie(ltid) {
    laborReportD.findLaborMonth(window.sessionUID, yearAll, ltid,
    function(data) {
        eval("window.dataPieMonth = data;");
        drawLaborMonthPie();

    });
}
function drawLaborYearPie() { //年劳务报酬
    var hight, width, title, tooltip, id;
    var valueData = "";
    var linksData = "";
    var labelsData = "";
    if (window.dataPieYear == null || window.dataPieYear == "") document.getElementById("JKDiv_2").innerHTML = "<center><a style='text-decoration: underline;color:#0000cc;font-size:15px;margin-top:60px;' href='#'>该年无劳务报酬记录</a></center>";
    else {
        hight = "600";
        width = "300";
        for (var i = 0; i < window.dataPieYear.length; i++) {
            valueData += window.dataPieYear[i].payOutNumSum + ",";
            labelsData += window.dataPieYear[i].companyName + ",";
            linksData += "javascript:findLaborItemPie('" + window.dataPieYear[i].lid + "'),";
        }
        valueData = valueData.substring(0, valueData.length - 1);
        labelsData = labelsData.substring(0, labelsData.length - 1);
        linksData = linksData.substring(0, linksData.length - 1);
        title = window.dataPieYear[0].laborYear.substring(0, 7) + "年劳务报酬";
        tooltip = "劳务报酬(年)";
        id = "JKDiv_2";
        drawPie(hight, width, title, valueData, linksData, labelsData, tooltip, id);
    }
}
function drawLaborItemPie() { //公司项目
    var hight, width, title, tooltip, id;
    var valueData = "";
    var linksData = "";
    var labelsData = "";
    if (window.dataPieItem == null || window.dataPieItem == "") alert("");
    else {
        hight = "600";
        width = "300";
        for (var i = 0; i < window.dataPieItem.length; i++) {
            valueData = valueData + window.dataPieItem[i].itemNumSum + ",";
            labelsData = labelsData + window.dataPieItem[i].itemName + ",";
            linksData += "javascript:findLaborMonthPie(" + window.dataPieItem[i].ltid + "),";
        }
        valueData = valueData.substring(0, valueData.length - 1);
        labelsData = labelsData.substring(0, labelsData.length - 1);
        linksData = linksData.substring(0, linksData.length - 1);
        title = "项目";
        tooltip = "项目(年)";
        id = "JKDiv_2";
        drawPie(hight, width, title, valueData, linksData, labelsData, tooltip, id);
    }
}
function drawLaborMonthPie() { //某项目各月明细
    var hight, width, title, tooltip, id;
    var valueData = "";
    var linksData = "";
    var labelsData = "";
    if (window.dataPieMonth == null || window.dataPieMonth == "") alert("");
    else {
        hight = "600";
        width = "300";
        for (var i = 0; i < window.dataPieMonth.length; i++) {
            valueData = valueData + window.dataPieMonth[i].payOutNum + ",";
            labelsData = labelsData + window.dataPieMonth[i].laborInDay + ",";
        }
        valueData = valueData.substring(0, valueData.length - 1);
        labelsData = labelsData.substring(0, labelsData.length - 1);
        title = "项目各月明细";
        tooltip = "项目(月)";
        id = "JKDiv_2";
        drawPie(hight, width, title, valueData, linksData, labelsData, tooltip, id);
    }
}