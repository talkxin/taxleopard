/**//* 处理用户相关搜索 */
function change(data) {

	var tab;
	var Related;
	var x;
	var txtHistory;
	var result;
	if(window.wType=='subsidyOutPut'){
		tab=document.getElementById("subsidyTab");
		Related=document.getElementById("subsidyRelated");
		x=document.getElementById("subsidyX");
		txtHistory="subsidyHistory";
		result="subsidyResult";
	}else if(window.wType=='prizeOutPut'){
		tab=document.getElementById("prizeTab");
		Related=document.getElementById("prizeRelated");
		x=document.getElementById("prizeX");
		txtHistory="prizeHistory";
		result="prizeResult";
	}
//	try{
 // 得到表格中的行数
 var count = tab.rows.length;
 // 如果表中存在行,将所有行删除
//	}catch(err){
//		var count=0;
//	}
 if (count > 0) {
  for (var i = count - 1; i >= 0; i--) {
   tab.deleteRow(i);
  }
 }

 // 如果存在相关搜索记录
 if (data.length > 0) {
	 Related.style.display = '';   //使层显示
	 x.style.display = '';         //是关闭超链接也显示
  for (var i = 0; i < data.length; i++) {
	  var Oname;
	  var Oid;
	  var Otype;
	  if(data[i]!=null && data[i].prizeName!=null){
		  Oname=data[i].prizeName;
		  Oid=data[i].ptid;
		  Otype=data[i].prizeType;
	  }else{
		  Oname=data[i].subsidyName;
		  Oid=data[i].stid;
		  Otype=data[i].subsidyType;
	  }
   var objTr = tab.insertRow(); //想表格插入一行数据
   var objTd1 = objTr.insertCell(0);       //向每行中插入第1个单元格
   objTd1.innerHTML = "<input readonly type='text' "   //向单元格插入内容
     + "size='10' name='"+txtHistory+"' style='border:none;background:#FFFFFF'"
     + " value='" + Oname
     + "' onmouseover='overChangeColor(this);'"  //鼠标以上去
     + " onmouseleave='leaveChangeColor(this)' "  //鼠标移走
     + " tableID='"+Oid+"' tableType='"+Otype+"'>";
   var objTd2 = objTr.insertCell(1);      //向每行中插入第2个单元格
   objTd2.innerHTML = "<input type='text' name='result' readonly"
     + " size='15' style='display: none;border:none;background:#FFFFFF;text-align:right'"
     + " value='' align='right'/>";
   objTd2.align = 'right';
  }
 } else {
	 Related.style.display = 'none';
 }

}

/**//* 关闭历史查询记录 */
function myClose(type) {
	var Related;
	if(type==0){
		Related=document.getElementById("prizeRelated");
	}else if(type==1){
		Related=document.getElementById("subsidyRelated");
	}
	Related.style.display = 'none'; //关闭显示数据
}
/**//* 鼠标在相关搜索内容上方时执行 */
function overChangeColor(object) {
	var outPut;
	var Related;
	if(object.name=='prizeHistory'){
		outPut=document.getElementById("prizeOutPut");
		Related=document.getElementById("prizeRelated");
	}else{
		outPut=document.getElementById("subsidyOutPut");
		Related=document.getElementById("subsidyRelated");
	}
	outPut.value=object.value;
	outPut.tableID=object.tableID;
	outPut.tableType=object.tableType;
	
 var histories ;
 if(object.name=='prizeHistory'){
	 histories=document.getElementsByName('prizeHistory');
 }else{
	 histories=document.getElementsByName('subsidyHistory');
 }
 /*= document.getElementsByName('txtHistory'); //获取文本框中的对象*/
 for (var i = 0; i < histories.length; i++) {
  // 如果当前鼠标停留在某一行上
  if (histories[i].style.background == '#ccffcc') {
   histories[i].style.background = '#FFFFFF';
   var tdObj1 = histories[i].parentElement;// td单元格
   var trObj1 = tdObj1.parentElement;  //tr 行
   var childObj1 = trObj1.childNodes(1); //td单元格  
   var x1 = childObj1.childNodes(0);  //文本框
   x1.style.background = '#FFFFFF';
   break;
  }
 }
 object.style.background = '#CCFFCC';
 var tdObj = object.parentElement;// td
 var trObj = tdObj.parentElement;// tr
 var childObj = trObj.childNodes(1);
 var x = childObj.childNodes(0);
 x.style.background = '#CCFFCC';
}

/**//* 鼠标离开相关搜索内容上方时执行 */
function leaveChangeColor(object) {
 object.style.background = '#FFFFFF';
 var tdObj = object.parentElement; // td
 var trObj = tdObj.parentElement; // tr
 var childObj = trObj.childNodes(1); // td
 var x = childObj.childNodes(0);  // input
 x.style.background = '#FFFFFF';
}
/**//* 鼠标点击相关搜索内容时执行 */
function clickHistory(object) {
	var outPut;
	var Related;
	if(object.name=='prizeHistory'){
		outPut=document.getElementById("prizeOutPut");
		Related=document.getElementById("prizeRelated");
	}else{
		outPut=document.getElementById("subsidyOutPut");
		Related=document.getElementById("subsidyRelated");
	}
	outPut.value=object.value;
	outPut.tableID=object.tableID;
	outPut.tableType=object.tableType;
 //document.frm.content.value = object.value;
	Related.style.display = 'none';
 // frm.submit();
}

/**//* 用户在搜索框中按键事件处理 */
function keySelectHistory(object) { 
 var nKeyCode = window.event.keyCode;
 if (nKeyCode == 38 || nKeyCode == 40) {
  var count; //= document.getElementById('tab').rows.length; //获取tab有多少行
  if(object.name=='prizeOutPut')
  {
	  count=document.getElementById("prizeTab");
  }else{
	  count=document.getElementById("subsidyTab");
  }
  var tempRowId;// 记录鼠标悬浮所在行
  var flag = false;// 标识是否有已经变色的行
  if (count > 0 && (nKeyCode == 38 || nKeyCode == 40)) {// 如果存在相关搜索信息
   var histories ;//= document.getElementsByName('txtHistory');
   if(object.name=='prizeOutPut'){
	   count=document.getElementById("prizeHistory");
   }else{
	   count=document.getElementById("subsidyHistory");
   }
   for (var i = 0; i < histories.length; i++) {
    // 如果当前鼠标停留在某一行上
    if (histories[i].style.background == '#ccffcc') {
     tempRowId = i;
     flag = true;
     break;
    }
   }
   if (!flag) {
    tempRowId = 0;
   }
   if (nKeyCode == 38) {// 向上键
    if (tempRowId > 0) {
     leaveChangeColor(histories[tempRowId]);
     overChangeColor(histories[tempRowId - 1]);
     object.value = (histories[tempRowId - 1]).value;
    } else {
     leaveChangeColor(histories[0]);
     overChangeColor(histories[count - 1]);
     object.value = (histories[count - 1]).value;
    }
   } else if (nKeyCode == 40) {// 向下键
    if (tempRowId == 0
      && histories[0].style.background != '#ccffcc') {
     overChangeColor(histories[0]);
     object.value = histories[0].value;
    } else if (tempRowId < count - 1) {
     leaveChangeColor(histories[tempRowId]);
     overChangeColor(histories[tempRowId + 1]);
     object.value = (histories[tempRowId + 1]).value;
    } else {
     leaveChangeColor(histories[tempRowId]);
     overChangeColor(histories[0]);
     object.value = histories[0].value;
    }
   }
  }  
 }
 else {// 搜索框内容发生改变时(手动使其变化,而非通过上下键)
  var str = object.value;
  eval("window.wType = '';");
  if(object.name=='prizeOutPut'){
	  window.wType='prizeOutPut';
	  paychexD.isGetPrizeType(str, change);
  }else if(object.name=='subsidyOutPut'){
	  window.wType='subsidyOutPut';
	  prizeOutPut='subsidyOutPut';
	  paychexD.isGetSubsidyType(str,change);
  }
 }
}