var yearAll;
function ChangeDiv(divId, divName, zDivCount) {
    for (i = 0; i <= zDivCount; i++) {
        document.getElementById(divName + i).style.display = "none";
    }
    document.getElementById(divName + divId).style.display = "block";
}
function yearTurn() {
    yearAll = document.getElementById("nian").value;
    findWriAllLaborYear(yearAll);
    if (document.getElementById("JKDiv_1").style.display == "block") {
        findLaborYearHg(yearAll);
    }
    if (document.getElementById("JKDiv_2").style.display == "block") {
        findLaborYearPie(yearAll)
    }
}

var company;
var item;
var kaiguan1, kaiguan2;
function hideRow1(para) {
    var pa = "tr[class='C" + para + "']"
    var trs = j$(pa);
    for (var i = 0; i < trs.length; i++) {
        trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
    }
    kaiguan1 = false;
    if (kaiguan2 == true) {
        kaiguan2 = false;
    }
}
function hideRow2(para) {
    var pa = "tr[class='I" + para + "']"
    var trs = j$(pa);
    for (var i = 0; i < trs.length; i++) {
        trs[i].style.display = "none"; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法
    }
    kaiguan2 = false;
}

function findWriAllLaborYear(yearAll) {
    kaiguan1 = false;
    kaiguan2 = false;
    laborReportD.findLaborYear(window.sessionUID, yearAll, callWriAllYear);
}
function findWriAllLaborItem(lid) {
    if (kaiguan1 == false) {
        company = "#company" + lid;
        laborReportD.findLaborItem(window.sessionUID, yearAll, lid, callWriAllItem)

        kaiguan1 = true;
    } else {
        hideRow1(lid);
    }
}
function findWriAllLaborMonth(ltid) {
    if (kaiguan2 == false) {
        item = "#item" + ltid;
        laborReportD.findLaborMonth(window.sessionUID, yearAll, ltid, callWriAllItemMonth);
        kaiguan2 = true;
    } else {
        hideRow2(ltid);
    }
}

function callWriAllYear(data) {
    eval("window.year=data;");
    var laborYearData = "<table width=\"501\" id=\"tb\" style=\"border:1px solid #000000;\" cellpadding=\"0\" cellspacing=\"0\"  bgcolor=\"#FFFFFF\" align=\"center\">" + "<tr ><td class=\"lie\" width=\"172\" height=\"40px\" ><span style=\"font-size:14px; font-weight:bold;\">公司</span></td>" + "<td class=\"lie\" width=\"145\" ><span style=\"font-size:14px; font-weight:bold;\">数额（人民币）￥</span></td>" + "<td class=\"lie\" width=\"171\"><span style=\"font-size:14px; font-weight:bold;\">应纳税额（人民币）￥</span></td></tr>";
    for (var j = 0; j < window.year.length; j++) {
        laborYearData += "<tr onclick=\"findWriAllLaborItem('" + window.year[j].lid + "');\" class=\"userlist\" id=\"t" + j + "\">" + "<td class=\"lie\"  height=\"30px\"><a "

        + " href=\"#\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\"     style=\"border:0\" /></a><span style=\"font-weight:bold\">"

        + window.year[j].companyName + "</td><td class=\"lie\" style=\"text-align:center\">" + window.year[j].payOutNumSum + "</td><td class=\"lie\" style=\"text-align:center\">"

        + window.year[j].taxNumSum + "</td></tr><p id=\"company" + window.year[j].lid

        + "\"></p>";
    }
    laborYearData += "</table>";
    if (window.year == null || window.year == "")
    //alert("无信息");
    document.getElementById("JKDiv_0").innerHTML = "<center><h1 style='color:#FA0707;font-size:18px;margin-top:80px;'>该年无劳务报酬记录</center>";
    else j$("#JKDiv_0").html(laborYearData);
}
function callWriAllItem(data) {

    eval("window.wriItem=data;");
    var laborItemData = "";
    for (var j = 0; j < window.wriItem.length; j++) {

        laborItemData += "<tr onclick=\"findWriAllLaborMonth(" + window.wriItem[j].ltid + ");\" style=\"background-color:#E7EFD3;text-align:center\" class=\"C" + window.wriItem[j].lid + "\" id=\"t0" + j + "\">" + "<td class=\"lie\" height=\"30px\"><a "

        + " href=\"#\"><img src=\"/TaxPersonalReporting1.0/paychex/reportForm/images/Triangle.png\" width=\"10\" height=\"10\"     style=\"margin-right:0px; border:0;\" /></a><span style=\"font-weight:bold\">"

        + window.wriItem[j].itemName + "</td><td class=\"lie\">" + window.wriItem[j].itemNumSum + "</td><td class=\"lie\">"

        + window.wriItem[j].itemTaxSum + "</td></tr><p id=\"item" + window.wriItem[j].ltid

        + "\"></p>";
    }

    j$(company).html(laborItemData);
}
function callWriAllItemMonth(data) {
    eval("window.wriItemMonth= data;");
    var monthData = "";
    for (var j = 0; j < window.wriItemMonth.length; j++) {
        monthData += "<tr class=\"I" + window.wriItemMonth[j].ltid + "\" id=\"t00-" + j + "\" style=\"text-align:center\"><td class=\"lie\">" + window.wriItemMonth[j].laborInDay + "</td><td class=\"lie\">" + window.wriItemMonth[j].payOutNum + "</td><td class=\"lie\">" + window.wriItemMonth[j].taxNum + "</td></tr>";
    }

    j$(item).html(monthData);
}