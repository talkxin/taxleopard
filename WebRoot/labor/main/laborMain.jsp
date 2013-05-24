<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css"
			href="labor/css/onServiceLoad.css" />
		<link rel="stylesheet" type="text/css" href="labor/css/reportCss.css" />
		<script type="text/javascript" src="share/js/hashmapjs.js"
	language="jscript" charset="UTF-8"></script>
		<script type='text/javascript' src='dwr/interface/paychexD.js'></script>
		<script type='text/javascript' src='dwr/interface/laborServiceDwr.js'></script>
		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='labor/js/jquery.min.js'></script>
		<script type="text/javascript">
  		var j$ = jQuery.noConflict();
  	</script>
		<script type='text/javascript' src='labor/js/onLayer.js'></script>
		<script type='text/javascript' src='labor/js/onServiceLoad.js'></script>
		<script type="text/javascript"
			src="paychex/main/js/datepicker/WdatePicker.js" language="jscript"></script>
		<script type='text/javascript' src='labor/js/laborMain.js'
			language="jscript" charset="UTF-8"></script>
		<script type='text/javascript' src='dwr/interface/laborReportD.js'></script>
		<script type='text/javascript' src='labor/js/laborItemWritten.js'></script>
		<script type='text/javascript' src='labor/js/laborYearWritten.js'></script>
		<script type='text/javascript'
			src='paychex/reportForm/js/swfobject.js'></script>
		<script type='text/javascript' src='labor/js/laborHistogramYear.js'></script>
		<script type='text/javascript' src='labor/js/laborPieYear.js'></script>
	</head>
	<body id="laborBody">
		<!-- 主操作层 -->
		<div id="laborPageMain">
			<div id="laborPage"></div>
		</div>
		<!-- 添加公司 -->
		<div id="addCompany"
			style="display: none; clear: both; margin: 0 auto; text-align: center; width: 600px; height: 350px">
			<div>
				<input id="innerAddCompany" disabled="disabled" readonly="readonly"
					style="border: 0; float: left; width: 70px; height: 30px; line-height: 30px; background: #f0f0f0; border-left: #CCCCCC 1px solid; border-right: #CCCCCC 1px solid; border-top: #CCCCCC 1px solid; text-align: center;"
					value="" />
			</div>
			<div style="float: left; width: 20px; margin-left: 500px">
				<a href="#"><img src="labor/images/shanchu.png" border="0"
						onclick="closAddCompanyName();" /> </a>
			</div>
			<br />
			<div
				style="width: 600px; height: 320px; background: #F2F2F2; margin-top: 14px; border: #CCCCCC 1px solid;">
				<div style="padding-top: 20px;">
					<ul style="list-style: none;">
						<li style="margin-left: 50px">
							您所在的公司名称：
							<input id="companyName" name="公司名称" type="text"
								style="height: 20px; width: 120px" />
						</li>
						<br />
						<li style="margin-left: 85px">
							公司的性质：
							<select name="劳务性质" id="laborType">
								<option value="0">
									私营企业
								</option>
								<option value="1">
									国企
								</option>
							</select>
						</li>
						<br />
						<li style="margin-left: 60px">
							您所从事的行业：
							<select id="industry">
								<option value="-1">
									请选择行业
								</option>
							</select>
						</li>
						<br />
						<li>
							您是否是该公司的正式员工：

							<input type="radio" name="RadioGroup1" value="是" onclick="bian()" />
							是
							<input type="radio" name="RadioGroup1" value="否"
								checked="checked" onclick="bian1()" />
							否
						</li>
						<br />
						<li>
							<input type="button" name="button2" id="button"
								onclick="toPaychex();" style="display: none;" size="45"
								value="您若是该公司的正式员工，那么您的该项收入属于工资薪金，是否为您转向工资薪金应用？" />
						</li>
						<br />
						<li>

							<input type="button" name="button3" id="addTocoo" value="确定"
								onclick="addCompanyName();"
								style="margin-left: 100px; margin-right: 20px;" />

							<input type="button" name="button4" id="button3" value="取消"
								onclick="closAddCompanyName();" />

						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- 添加工作 -->
		<div id="addLaborService"
			style="display: none; clear: both; margin: 0 auto; text-align: center; width: 600px; height: 350px">
			<div>
				<input id="innerAddService" disabled="disabled" readonly="readonly"
					style="border: 0; float: left; width: 70px; height: 30px; line-height: 30px; background: #f0f0f0; border-left: #CCCCCC 1px solid; border-right: #CCCCCC 1px solid; border-top: #CCCCCC 1px solid; text-align: center;"
					value="" />
			</div>
			<div style="float: left; width: 20px; margin-left: 500px">
				<a href="#"><img src="labor/images/shanchu.png" border="0"
						onclick="serviceDis();" /> </a>
			</div>
			<br />
			<div
				style="width: 600px; height: 320px; background: #F2F2F2; margin-top: 12px; border: #CCCCCC 1px solid;">
				<div style="padding-top: 10px; z-index: 1; position: absolute">
					<ul style="list-style: none">
						<li>
							获取劳务报酬的项目是：
							<input id="itemName" onkeyup="isUpOrAddToup();" type="text"
								style="width: 120px; height: 20px" />
							<input type="button" id="button4" value="查询" onclick="display( 'selectItem');isGetItem();"/>
						</li>
						<br />
						<li style="margin-left: 23px;">
							获取劳务报酬日期：
							<input id="laborInDay" type=text
								style="width: 120px; height: 20px" onfocus="WdatePicker();">
						</li>
						<br />
						<li style="margin-left: 20px;">
							获取劳务报酬地点：
							<select id=laborCity onchange="getCity(this.value);">
								<option value="-2">
									请选择省
								</option>
							</select>
							<select id="laborAdd" name="select">
								<option value="-2">
									请选择市
								</option>
							</select>
						</li>
						<br />
						<li style="margin-left: 20px;">
							获取劳务报酬金额：
							<input type="text" id="laborNumber" name="textfield2"
								onkeyup="replaceNotNumber(this);"
								style="width: 120px; height: 20px" />
						</li>
						<br />
						<li style="margin-left: 20px">
							您的收入是否含税：
							<input id="hanshui" checked="checked" type="radio"
								name="laborTaxEd" ed="0" value="是" id="RadioGroup1_0"
								onclick="laborTaxEdNumberD(0);" />
							是
							<input id="nothanshui" type="radio" name="laborTaxEd" ed="1"
								value="否" id="RadioGroup1_1" onclick="laborTaxEdNumberD(1);" />
							否
						</li>
						<br/>
						<li id="laborTaxEdNumberD"
							style="display: block; margin-left: 43px;">
							您的已交税款：
							<input id="laborTaxEdNumber" type="text"
								style="width: 120px; height: 20px;" value="0">
						</li>
						<br />
						<li>
							<input type="button" id="addToUserService" value="确定"
								onclick="serviceReturn();"
								style="margin-left: 80px; margin-right: 20px" />
							<input type="button" name="button3" value="取消"
								onclick="serviceDis();" />
						</li>
					</ul>
				</div>
				<div id="selectItem"
					style="background: #CCCCCC; display: none; z-index: 2; position: absolute; margin-left: 305px; margin-top: 55px; width: 130px; height: 107px; border: #000000 1px solid; overflow: scroll;">
					<table cellpadding="0" cellspacing="0">
						<tr>
							<th style="width: 55px;"></th>
							<th style="width: 55px;"></th>
							<tbody id="cooItem"></tbody>
						</tr>
					</table>
				</div>
			</div>
		</div>


		<div id="laborReport" class="tabContainer"
			style="overflow: scroll; display: none; clear: both; magin-left: auto; margin-right: auto; margin: 0 auto; text-align: center; height: 600px; width: 700px">

			<div>
				<input id="isInnerCoo" disabled="disabled" readonly="readonly"
					style="border: 0; float: left; width: 70px; height: 30px; line-height: 30px; background: #f0f0f0; border-left: #CCCCCC 1px solid; border-right: #CCCCCC 1px solid; border-top: #CCCCCC 1px solid; text-align: center;"
					value="" />
			</div>
			<div style="float: left; width: 20px; margin-left: 500px">
				<a href="#"><img src="labor/images/shanchu.png" border="0"
						onclick="closeLayer();" /> </a>
			</div>
			<h1 id="h1" style="text-align: center; font-size: 18px">
				劳务报酬
			</h1>
			<div id="rep" align="left"
				style="font-family: '微软雅黑'; margin-left: 100px; font-size: 16px;">
				请选择年份：
				<select id="nian" onchange="yearPie()" name="nianFen">
					<option value="2005">
						2005
					</option>
					<option value="2006">
						2006
					</option>
					<option value="2007">
						2007
					</option>
					<option value="2008">
						2008
					</option>
					<option value="2009">
						2009
					</option>
					<option value="2010">
						2010
					</option>
					<option value="2011">
						2011
					</option>
					<option value="2012">
						2012
					</option>
					<option value="2013">
						2013
					</option>
					<option value="2014">
						2014
					</option>
					<option value="2015">
						2015
					</option>
				</select>
			</div>
			<br>
				<div id="report">

				</div>

				<div id="yearWriReport">

				</div>
		</div>

		<div id="laborYearReport" class="tabContainer"
			style="overflow: scroll; display: none; clear: both; magin-left: auto; margin-right: auto; margin: 0 auto; text-align: center; height: 600px; width: 700px">
			<div>
				<input id="" disabled="disabled" readonly="readonly"
					style="border: 0; float: left; width: 70px; height: 30px; line-height: 30px; background: #f0f0f0; border-left: #CCCCCC 1px solid; border-right: #CCCCCC 1px solid; border-top: #CCCCCC 1px solid; text-align: center;"
					value="全局报表" />
			</div>
			<div style="float: left; width: 20px; margin-left: 500px">
				<a href="#"><img src="labor/images/shanchu.png" border="0"
						onclick="closeLayer();" /> </a>
			</div>
			<h1 id="h1" style="text-align: center; font-size: 18px">
				劳务报酬
			</h1>
			<div id="rep" align="left"
				style="font-family: '微软雅黑'; margin-left: 80px; font-size: 16px;">
				请选择年份：
				<select id="nian" onchange="yearTurn()" name="nianFen">
					<option value="2005">
						2005
					</option>
					<option value="2006">
						2006
					</option>
					<option value="2007">
						2007
					</option>
					<option value="2008">
						2008
					</option>
					<option value="2009">
						2009
					</option>
					<option value="2010">
						2010
					</option>
					<option value="2011">
						2011
					</option>
					<option value="2012">
						2012
					</option>
					<option value="2013">
						2013
					</option>
					<option value="2014">
						2014
					</option>
					<option value="2015">
						2015
					</option>
				</select>
			</div>
			<br>

				<span onclick="JavaScript:ChangeDiv('0','JKDiv_',2)"
					style="cursor: hand;">文字报表</span> <span
					onclick="JavaScript:ChangeDiv('1','JKDiv_',2);findLaborYearHg(yearAll);"
					style="cursor: hand;">柱状图</span> <span
					onclick="JavaScript:ChangeDiv('2','JKDiv_',2);findLaborYearPie(yearAll);"
					style="cursor: hand;">饼状图</span>

				<div id="JKDiv_0">
					<br>
				</div>
				<div id="JKDiv_1" style="display: none;"></div>
				<div id="JKDiv_2" style="display: none;"></div>
		</div>
	</body>
</html>
