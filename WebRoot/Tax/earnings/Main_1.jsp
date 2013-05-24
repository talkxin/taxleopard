<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
.Main_1{
	width: 600px;
	height: 500px;
	background-color: #FFFFCC;
	overflow:hidden; 
	position:absolute;
}
select{margin:-1px; border:0px solid #FF3300;}
.c{ background-color:#FFCCCC;}
.e{ background-color:#FFFFCC;}
a {
	color:#868b6e; 
	outline:none;
	text-decoration:none;
}
a:hover{
	text-decoration:underline;
}

h2 {
	font-size:30px;
	line-height:1.2em;
	font-weight:normal;
	margin-bottom:20px;
}
h3 {
	font-size:24px;
	line-height:2.3em;
	font-weight:normal;
	width:100%;
	overflow:hidden;
}
</style>
<script type="text/javascript">
</script>
<div align="center" class="Main_1">
<form action="">
<h3>您的国籍（地区）是？</h3>
<input type="radio" checked="checked" name="Nation"/>中国
<input type="radio" name="Nation"/>港澳台（地区）
<input type="radio" name="Nation"/>外国
<select>
<option selected="selected" id="selected">--请选择--</option>
<option class="c">美国(USA)</option>
<option class="e">英国</option>
</select>
<h3>您的行业是？</h3>
<select>
<option selected="selected" id="selected">--请选择--</option>
<option class="c">软件</option>
<option class="e">财务</option>
<option class="c">煤炭</option>
<option class="e">司机</option>
</select>
<a href="#">该行业属于劳务报酬引用处理，是否给您转向</a>
<h3>您的职位性质是：</h3>
<p>
      <input name="xingzhi" type="radio" checked="checked" value="putongrenyuan" />
      <span class="style1_5">普通人员
      <input name="xingzhi" type="radio" value="gaojiguanlirenyuan" />
      高级管理人员
      <input name="xingzhi" type="radio" value="lituixiurenyuan" />
      离退休人员 </span>
    <p>
	<input type="button" value="进入"/><input type="button" value="下一步"/>
</form>
</div>
