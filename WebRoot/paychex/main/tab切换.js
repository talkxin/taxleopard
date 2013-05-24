function tab(o, s, cb, ev){//tab切换类
var $ = function(o){return document.getElementById(o)};
var css = o.split((s||'_'));
if(css.length!=4)return;
this.event = ev || 'onclick';
o = $(o);
if(o){
   this.ITEM = [];
   o.id = css[0];
   var item = o.getElementsByTagName(css[1]);
   var j=1;
   for(var i=0;i<item.length;i++){
    if(item[i].className.indexOf(css[2])>=0 || item[i].className.indexOf(css[3])>=0){
     if(item[i].className == css[2])o['cur'] = item[i];
     item[i].callBack = cb||function(){};
     item[i]['css'] = css;
     item[i]['link'] = o;
     this.ITEM[j] = item[i];
     item[i]['Index'] = j++;
     item[i][this.event] = this.ACTIVE;
    }
   }
   return o;
}
}
tab.prototype = {
ACTIVE:function(){
   var $ = function(o){return document.getElementById(o)};
   this['link']['cur'].className = this['css'][3];
   this.className = this['css'][2];
   try{
    $(this['link']['id']+'_'+this['link']['cur']['Index']).style.display = 'none';
    $(this['link']['id']+'_'+this['Index']).style.display = 'block';
   }catch(e){}
   this.callBack.call(this);
   this['link']['cur'] = this;
}
}
/*
tab 使用方法:
   new tab(标签ID, id分隔符, 单击事触发函数, 什么事件触发TAB切换);
    标签ID:        ID命名格式为: 前缀+分隔符+TAB标签的HTML标签名+激活状态下标签样式+分隔符+非激活状态下标签样式(必须)
    id分隔符:       分隔符(必须)
    TAB切换时触发函数: TAB切换时触发函数(可选)
    什么事件触发TAB切换:可选(默认为onclick)
    注: 标签ID命名时的前缀将做为 该标签的新ID值,所以前缀不要与现在任何元素的ID值相同.
   返回值为: 标签ID所对象的对象.
   切换标签时对应的 项目名称命名规则:
    前缀+_+顺序值
    具体理解,可以看上面的代码,比如
    ID为 "test3_li_now_" 的对象代表的意思是:
     前缀为 test3
     li 为 id为 "test3_li_now_" 标签下面的 li 标签 做为TAB项.
     now 为 标签激活时的样式
     "" 最后的空为 非激活状态下的样式
    每个标签项 激活 状态下对应的元素的ID应该命名为:
     test3_1   第一个标签项对应项目
     test3_2   第二个标签项对应项目
     test3_3   第三个标签项对应项目
     等等
*/
new tab('tabCot_product-li-currentBtn-', '-');