var uid;
var time;
function showPic(ml) {
	document.getElementById("twelvePic").innerHTML = "<div style=\"width:200px; display:none; height:20px; margin-bottom:60px;margin-left:"
			+ ml
			+ "px;\" id=\"1\" ><a href=\"openpaychex\" ><img src=\"paychex/open/images/WindowAdd.png\" align=\"absmiddle\" style=\"border:0\" /><font style=\"font-family:'微软雅黑'; font-size:14px;\"></font></a>"
			+ "<a href=\"#\" onclick='isDelmm();'><img src=\"paychex/open/images/WindowDelete.png\" align=\"absmiddle\" style=\"border:0\" /><font style=\"font-family:'微软雅黑'; font-size:14px;\"></font></a></div>";
}
var old = null;
function display(id, ml) {
	showPic(ml)
	var obj = document.getElementById(id);
	if (old != null && old != obj)
		old.style.display = 'none';
	old = obj;
	if (obj.style.display == 'none') {
		obj.style.display = 'block';
	} else {
		obj.style.display = 'none';
	}

}
window.onload = function() {
	onloadPay();
}

function onloadPay() {
	var myYear = new Date().getFullYear();
	var sel = document.getElementById("nian");
	for ( var i = 0; i < nian.options.length; i++) {
		if (nian.options[i].value == myYear) {
			nian.options[i].selected = true;
		}
	}
	var year = document.getElementById("nian").value;
	countMonthNum(year);
	findWageYearPie("shuiJingNian", "201", "162", year);
}
function yearPie() {
	var year = document.getElementById("nian").value;
	countMonthNum(year);
	findWageYearPie("shuiJingNian", "201", "162", year);

}
function toMonthWritten(id2) {
	if (window.data == null || window.data == "") {
		document.getElementById(id2).innerHTML = "<center><a style='text-decoration: underline;color:#0000cc;font-size:15px;margin-top:60px;' href='paychexin'>该月没有工资薪金记录</a></center>";
	} else {
		document.getElementById(id2).innerHTML = "<center><a style='text-decoration: underline;color:#0000cc;font-size:15px;margin-top:60px;' href='toMonthWritten'>该月的个人所得税为"
				+ window.data.taxNumber + "元,点击查看该月详细</a></center>";
	}
}

function amplification() {
	self.location.href = "toMonthPie";
}
function amplificationYear() {
	var year = document.getElementById("nian").value;
	if (window.dataYear.inPayYear == year)
		self.location.href = "toYearPie?year=" + year;
	else {
		alert("请在下拉框选择与饼状图对应的年份")
	}
}

function findWageMonthPie(id, id2, hight, width) {

	paychexD
			.getUser(function(data) {
				uid = data['userId'];
				time = data['addTime'];
				dwrTest
						.findWageMonth(
								uid,
								time,
								function(data) {
									if (data == null || data == "") {
										document.getElementById(id).innerHTML = "<center><a style='text-decoration: underline;color:#0000cc;font-size:15px;margin-top:60px;' href='openpaychex'>该月没有工资薪金记录</a></center>";
										document.getElementById(id2).innerHTML = "<center><a style='text-decoration: underline;color:#0000cc;font-size:15px;margin-top:60px;' href='openpaychex'>该月没有工资薪金记录</a></center>";
									} else {
										eval("window.data = data;");
										DrawWageMonthPie(id, hight, width);
										document.getElementById(id2).innerHTML = "<center><a style='text-decoration: underline;color:#0000cc;font-size:15px;margin-top:60px;' href='toMonthWritten'>该月的个人所得税为"
												+ window.data.taxNumber
												+ "元,点击查看该月详细</a></center>";
									}
								});
			});

}
function DrawWageMonthPie(id, hight, width) {// 月工资汇总
	var so = new SWFObject(
			"paychex/reportForm/actionscript/open-flash-chart.swf", "ofc",
			hight, width, "9", "#FFFFFF");
	var valueData = "";
	var linksData = "";
	var labelsData = "";
	if (window.data.basicWage != null) {
		valueData += window.data.basicWage + ",";
		linksData += "javascript:amplification(),";
		labelsData += "基础工资,";
	}
	if (window.data.monthPrize != null) {
		valueData += window.data.monthPrize + ",";
		linksData += "javascript:amplification(),";
		labelsData += "奖金,";
	}
	if (window.data.monthSubsidy != null) {
		valueData += window.data.monthSubsidy + ",";
		linksData += "javascript:amplification(),";
		labelsData += "补贴,";
	}
	if (window.data.monthBonus != null) {
		valueData += window.data.monthBonus + ",";
		linksData += "javascript:amplification(),";
		labelsData += "分红,";
	}
	if (window.data.insuranceSum != null) {
		valueData += window.data.insuranceSum + ",";
		linksData += "javascript:amplification(),";
		labelsData += "五险一金,";
	}
	if (window.data.taxNumber != null) {
		valueData += window.data.taxNumber + ",";
		linksData += ",";
		labelsData += "个人所得税,";
	}
	valueData = valueData.substring(0, valueData.length - 1);
	linksData = linksData.substring(0, linksData.length - 1);
	labelsData = labelsData.substring(0, labelsData.length - 1);

	so.addVariable("variables", "true");
	so.addVariable("bg_colour", "#FFFFFF");
	so.addVariable("title", window.data.payMonth + "工资薪金,{font-size: 20;}");
	so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
	so.addVariable("values", valueData);
	so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
	so.addVariable("links", linksData);
	so.addVariable("pie_labels", labelsData);
	so.addVariable("tool_tip", "工资薪金(月)<br>#x_label#<br>Value: #val#");
	so.addParam("allowScriptAccess", "always");
	so.write(id);
}

function findWageYearPie(id, hight, width, year) {
	dwrTest
			.findWageYear(
					year,
					function(data) {
						if (data == null || data == "") {
							document.getElementById(id).innerHTML = "<center><a style='text-decoration: underline;color:#0000cc;font-size:15px;margin-top:60px;' href='paychexin'>该年没有工资薪金记录</a></center>";
						} else {
							eval("window.dataYear = data;");
							DrawWageYearPie(id, hight, width);
						}
					});
}
function DrawWageYearPie(id, hight, width) {// 年工资汇总
	var valueData = "";
	var linksData = "";
	var labelsData = "";
	if (window.dataYear.basicWageSum != null) {
		valueData += window.dataYear.basicWageSum + ",";
		linksData += "javascript:amplificationYear(),";
		labelsData += "基础工资,";
	}
	if (window.dataYear.prizeSum != null) {
		valueData += window.dataYear.prizeSum + ",";
		linksData += "javascript:amplificationYear(),";
		labelsData += "奖金,";
	}
	if (window.dataYear.subsidySum != null) {
		valueData += window.dataYear.subsidySum + ",";
		linksData += "javascript:amplificationYear(),";
		labelsData += "补贴,";
	}
	if (window.dataYear.bonusSum != null) {
		valueData += window.dataYear.bonusSum + ",";
		linksData += "javascript:amplificationYear(),";
		labelsData += "分红,";
	}
	var yearInsurance = parseFloat(window.dataYear.insuranceSum)
			* parseFloat(window.dataNum.length);
	// 年社保扣缴=每个月的社保扣缴*该年有工资薪金记录的月份数
	if (window.dataYear.insuranceSum != null) {
		valueData += yearInsurance + ",";
		linksData += "javascript:amplificationYear(),";
		labelsData += "五险一金,";
	}
	if (window.dataYear.taxNumberSum != null) {
		valueData += window.dataYear.taxNumberSum + ",";
		linksData += "javascript:amplificationYear(),";
		labelsData += "个人所得税,";
	}
	valueData = valueData.substring(0, valueData.length - 1);
	linksData = linksData.substring(0, linksData.length - 1);
	labelsData = labelsData.substring(0, labelsData.length - 1);
	var so = new SWFObject(
			"paychex/reportForm/actionscript/open-flash-chart.swf", "ofc",
			hight, width, "9", "#FFFFFF");
	so.addVariable("variables", "true");
	so.addVariable("bg_colour", "#FFFFFF");
	so.addVariable("title", window.dataYear.inPayYear
			+ "年工资薪金,{font-size: 20;}");
	so.addVariable("pie", "60,#9933CC,{font-size:12px;color:#000000}");
	so.addVariable("values", valueData);
	so.addVariable("colours", "#d01f3c,#356aa0,#C79810");
	so.addVariable("links", linksData);
	so.addVariable("pie_labels", labelsData);
	so.addVariable("tool_tip", "工资薪金(年)<br>#x_label#<br>Value: #val#");
	so.addParam("allowScriptAccess", "always");
	so.write(id);
}
function callMonthNum(dataNum) {
	for ( var i = 0; i < dataNum.length; i++) {
		eval("window.dataNum = dataNum;");
	}
	// findWageYear();
}
function countMonthNum(year) {// 该年已有工资信息记录的月份个数
	var payroll = new Object();
	DWREngine.setAsync(false);
	dwrTest.findPayrollMonth(year, callMonthNum);
	DWREngine.setAsync(true);
}

function isReturnTime(object, id, id2, hight, width) {
	paychexD.returnDay(function(data) {
		if (!isNaN(data)) {
			var a;
			if (data < 10)
				a = '0' + data;
			else
				a = data;
			time = $('nian').value + '-' + object.rel + '-' + a;
			paychexD.intoTime(time);
		} else if (data != null && data != '') {
			time = data;
		} else {
			time = $('nian').value + '-' + object.rel + '-01';
			paychexD.intoTime(time);
		}
		findWageMonthPie(id, id2, hight, width);

	});
}
function isDelmm() {
	if (confirm('您确定要删除该月工资薪金？')) {
		paychexD.delPayRoll(uid, time);
		var object = new Object();
		object.rel = time.substring(5, 7);
		isReturnTime(object, 'shuiJingYue', 'wenZiYue', '201', '162');
		var year = time.substring(0, 4);
		countMonthNum(year);
		findWageYearPie("shuiJingNian", "201", "162", year);

	}
}