//var _userID;
//window.onload = function() {
//	DWREngine.setAsync(false);
//	paychexD.getUser(function(data) {
//		_userID = data["userId"];
//	});
//}
var tos = true;
var clack = '';
document.onclick = function() {
	// eval("showCurrentObj(event.srcElement);");
	eval(clack);
};
function showCurrentObj(obj) {
	var b = getChars(obj.innerHTML);
	var c = '';
	for ( var i = 0; i < b.length; i++) {
		if (/^[\u4e00-\u9fa5]+$/.test(b[i])) {
			c = c + b[i];
		}
	}
	if (c != null && c != '') {
		promptData.isGetPrompt(c, function(data) {
			if (data != null) {
				art.dialog({
					id : 'prompt',
					title : c,
					content : data.proptText,
					follow : event.srcElement
				});
			}
		});
	}
}
function getChars(str) {
	var _chars = new Array();
	var _length = str.length;
	var a = 1;
	for ( var i = 0; i < _length; i++) {
		if (a < _length) {
			_chars.push(str.substring(i, a));
		} else {
			_chars.push(str.substring(_length - 1, _length));
		}
		a++;
	}
	return _chars;
}

function onclickto() {
	if (tos) {
		tos = false;
		document.body.style.cursor = "help";
		clack = 'showCurrentObj(event.srcElement);';
	} else {
		tos = true;
		document.body.style.cursor = "default";
		art.dialog({
			id : 'prompt'
		}).close();
		clack = '';
	}
}