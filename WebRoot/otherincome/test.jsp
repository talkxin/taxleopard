<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>test</title>
<script>
var currentObj = null;
document.onmouseover=function(){
    currentObj = event.srcElement;
};
window.onload = function(){
    window.setInterval("showCurrentObj()",5);
}
function showCurrentObj(){
	var _a=currentObj.outerHTML;
	if ((window.event.keyCode >=32) && (window.event.keyCode <= 126)){
	}
}
</script>
</head>

<body>
<div id=d1 style="background-color:red">111</div>
<div id=d2 style="background-color:green">222</div>
<div id=d3 style="background-color:yellow">333</div>
<div id=d4 style="background-color:blue">444</div>
</body>

</html>
