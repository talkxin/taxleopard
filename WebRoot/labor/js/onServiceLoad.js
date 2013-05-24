//Data1:  data=[{id:'id1',name:'name1'},{ id:'id2',name:'name2’}]
//Data2：格式为[{id:id,image:图片地址,imageName:图片名称,onclick:点击事件}]
var baobiao = 0;
// 记录以开启的层
var openId;
var onServiceLoad = (function(j$) {
	// DATA对象数组数据源
	function init(id, height, width, data) {
		var h = height || 630, w = width || 810, DATA = data || {}, OBJ = j$("#"
				+ id);
		OBJ.css({
			width : w + "px",
			height : h + "px"
		});
		if (data) {
			new j(OBJ, h, w, data);
		} else {
			new g(OBJ, h, w);
		}
	}
	// 加载图片
	function loadImg(src, callback) {
		var img = new Image();
		img.onload = function() {
			callback();
			img.onload = function() {
			};
		}
		img.src = src;
	}
	// 当数据源Data为空时
	var g = function(OBJ, h, w) {
		this.obj = OBJ;
		// 加载css
		this.obj.addClass('isPagenull');
		this.h = h;
		this.w = w;
		this.ids = []; // 存图片id的数组
		this.init();
	};
	g.prototype = {
		init : function() {
			this.displayCenterImg();
		},
		displayCenterImg : function() {
			var ss = "<div><img id='lastImage' src='" + window.addImg
					+ "'/><p>" + window.lastName + "</p></div>";
			j$("<div>", {
				'class' : 'imgCenter',
				html : ss
			}).css({
				position : 'absolute',
				left : this.w / 2 - 20,
				top : this.h / 2 - 20
			}).appendTo(this.obj);
			// j$("<img>", { src: window.addImg, "class": "imgCenter" }).css({
			// left: this.w / 2 - 20, top: this.h / 2 - 20
			// }).appendTo(this.obj);
			this.bindEvent();
		},
		// 中心图片点击事件
		bindEvent : function() {
			if (window.userAddCoo.constructor == window.Array) {
				var self = this;
				self.obj
						.delegate(
								"div.imgCenter",
								"click",
								function() {
									var j$this = j$(this);
									if (!j$this.data("click")) {
										var arr = window.userAddCoo, img, i = 0, length = arr.length, item, left = parseInt(j$this
												.css("left")), top = parseInt(j$this
												.css("top"));
										j$this.data("click", "1"); // 表明已经请求过一次
										for (; i < length; i++) {
											item = arr[i];
											self.ids.push(item.id);
											var _left, _top, s = "<img src='labor/images/blank.png' id='"
													+ item.id
													+ "'/><p style='margin-left: -5px'>"
													+ item.imageName + "</p>", div;
											switch (i) {
											case 0:
												_left = left - 52;
												_top = top;
												break;
											case 1:
												_left = left;
												_top = top - 52;
												break;
											case 2:
												_left = left + 52;
												_top = top;
												break;
											case 3:
												_left = left;
												_top = top + 52;
												break;
											}
											div = j$("<div>", {
												"class" : "sideImg",
												html : s
											}).css({
												"left" : _left,
												"top" : _top
											}).appendTo(self.obj);
											// 闭包加载每个图片
											(function(s, item) {
												setTimeout(
														function() {
															loadImg(
																	item.image,
																	function() {
																		s
																				.find(
																						"img")
																				.attr(
																						"src",
																						item.image)
																				.click(
																						eval(item.onclick));
																	})
														}, "500");
											})(div, item);
										}
									} else { // 已点击过,在点击图片切换隐藏
										j$this.siblings(".sideImg")
												.toggleClass("dis");
									}
								});
			} else {
				// 如果最后一个图片是一个事件直接触发该事件
				j$('#lastImage').click(function() {
					eval(window.userAddCoo);
				});
			}
		}
	};
	// 当数据源data不为空时
	var j = function(OBJ, h, w, data) {
		this.obj = OBJ;
		// 加载css
		this.obj.addClass('isPagenotnull');
		this.h = h;
		this.w = w;
		this.data = data;
		this.init();
	};
	j.prototype = {
		init : function() {
			this.displayCenterImg();
		},
		displayCenterImg : function() {
			var i = 0, l = this.data.length, s;
			// 图片方法筛选器
			var clickFunction = new JHashMap();
			// 增加默认方法
			clickFunction.put(null, window._lodingOnclick);
			for (; i < l; i++) {

				if (this.data[i].id != 'baobiao') {
					// 通过筛选器进行筛选图标及方法
					var loadImg;
					if (typeof (_isOnloadImgMap) != 'undefined'
							&& _isOnloadImgMap != null) {
						if (this.data[i].type != null
								&& _isOnloadImgMap.get(this.data[i].type) != null) {
							loadImg = _isOnloadImgMap.get(this.data[i].type).loadImg;
							clickFunction.put(this.data[i].id, _isOnloadImgMap
									.get(this.data[i].type).lodingOnclick);
						} else
							loadImg = window.loadImg;
					} else {
						loadImg = window.loadImg;
					}
					s = "<div class='centerImg'><img src='" + loadImg
							+ "' id='" + this.data[i].id + "' data-url=''/><p>"
							+ this.data[i].name + "</p></div>";
					j$("<div>", {
						'class' : 'centerPicCon',
						html : s
					}).appendTo(this.obj);
				} else {
					baobiao = 1;
				}
			}
			if (!_isitBaobiao) {
				baobiao = 0;
			}
			if (baobiao == 1) {
				// 加载报表
				s = "<div class='centerImg'><img src='" + window.baobiaoImg
						+ "' id='baobiao' data-url=''/></div>";
				j$("<div>", {
					'class' : 'centerPicCon',
					html : s
				}).appendTo(this.obj);
			}
			// 数据源最后的一张图片
			s = "<div class='centerImg'><img src='" + window.addImg
					+ "' id='lastTodo' data-url=''/><p>" + window.lastName
					+ "</p></div>";
			j$("<div>", {
				'class' : 'centerPicCon',
				html : s
			}).appendTo(this.obj);
			this.bindEvent(clickFunction, window.userAddCoo);
		},
		// 中心图片点击事件
		bindEvent : function(data, data2) {
			var self = this;
			self.obj
					.delegate(
							".centerImg img",
							"click",
							function() {
								var a = j$(this).attr("id");
								if (a == "lastTodo") {
									if (data2.constructor == window.Array) {
										// 如果是最后一张图片的话加载其他事件
										var j$this = j$(this);
										if (!j$this.data("click")) {
											var arr = data2, img, i = 0, length = arr.length, item, left = parseInt(j$this
													.parent().css("left")), top = parseInt(j$this
													.parent().css("top"));
											j$this.data("click", "1"); // 表明已经请求过一次
											for (; i < length; i++) {
												item = arr[i];
												var _left, _top, s = "<img src='labor/images/blank.png' id='"
														+ item.id
														+ "'/><p>"
														+ item.imageName
														+ "</p>", div;
												switch (i) {
												case 0:
													_left = left - 52;
													_top = top;
													break;
												case 1:
													_left = left;
													_top = top - 52;
													break;
												case 2:
													_left = left + 52;
													_top = top;
													break;
												case 3:
													_left = left;
													_top = top + 52;
													break;
												}
												div = j$("<div>", {
													"class" : "sideImg",
													html : s
												}).css({
													"left" : _left,
													"top" : _top
												}).insertAfter(j$this.parent());
												// 闭包加载每个图片
												(function(s, item) {
													setTimeout(
															function() {
																loadImg(
																		item.image,
																		function() {
																			s
																					.find(
																							"img")
																					.attr(
																							"src",
																							item.image)
																					.click(
																							eval(item.onclick));
																		})
															}, "500");
												})(div, item);
											}

										} else { // 已点击过,在点击图片切换隐藏
											j$this.parent()
													.siblings(".sideImg")
													.toggleClass("dis");
										}
									} else {
										// 如果最后一个图片是一个事件直接触发该事件
										eval(window.userAddCoo);
									}
								} else if (a == "baobiao") {
									// 如果是报表，加载报表
									eval(BaobiaoOnclick);
								} else {
									// 当正常加载的时候触发方法
									if (_onloadPageclick != null)
										eval(_onloadPageclick);
									// 如果不是正常加载
									var j$this = j$(this);
									if (!j$this.data("click")) {
										// 当加载的时候，隐藏其他公司
										if (window.cooID != null) {
											j$("#" + window.cooID).parent()
													.siblings(".sideImg")
													.toggleClass("dis");
											eval("window.cooID = a;");
										} else {
											eval("window.cooID = a;");
										}
										// 通过传入的方法筛选器进行筛选该图片的方法若为空则用默认方法
										var _clickFunction;
										if (data.get(a) != null)
											_clickFunction = data.get(a);
										else
											_clickFunction = data.get(null);
										var arr = _clickFunction, img, i = 0, length = arr.length, item, left = parseInt(j$this
												.parent().css("left")), top = parseInt(j$this
												.parent().css("top"));
										j$this.data("click", "1"); // 表明已经请求过一次
										for (; i < length; i++) {
											item = arr[i];
											var _left, _top, s = "<img src='labor/images/blank.png' id='"
													+ item.id
													+ "'/><p>"
													+ item.imageName + "</p>", div;
											switch (i) {
											case 0:
												//左
												_left = left - 50;
												_top = top+1;
												break;
											case 1:
												//上
												_left = left+5;
												_top = top - 52;
												break;
											case 2:
												//右
												_left = left + 58;
												_top = top;
												break;
											case 3:
												//下
												_left = left+5;
												_top = top + 60;
												break;
											}
											div = j$("<div>", {
												"class" : "sideImg",
												html : s
											}).css({
												"left" : _left,
												"top" : _top
											}).insertAfter(j$this.parent());
											// 闭包加载每个图片
											(function(s, item) {
												setTimeout(
														function() {
															loadImg(
																	item.image,
																	function() {
																		s
																				.find(
																						"img")
																				.attr(
																						"src",
																						item.image)
																				.click(
																						eval(item.onclick));
																	})
														}, "500");
											})(div, item);
										}

									} else { // 已点击过,在点击图片切换隐藏
										// 以加载过后，隐藏其他层，展现
										if (window.cooID != null) {
											if (a != window.cooID) {
												if ((j$("#" + window.cooID)
														.parent().siblings(
																".sideImg")
														.attr("class") != "sideImg dis"))
													j$("#" + window.cooID)
															.parent().siblings(
																	".sideImg")
															.toggleClass("dis");
												eval("window.cooID = a;");
												j$("#" + window.cooID).parent()
														.siblings(".sideImg")
														.toggleClass("dis");
											} else {
												eval("window.cooID = a;");
												j$("#" + window.cooID).parent()
														.siblings(".sideImg")
														.toggleClass("dis");
											}
										} else {
											eval("window.cooID = a;");
											j$("#" + window.cooID).parent()
													.siblings(".sideImg")
													.toggleClass("dis");
										}
										// j$this.parent().siblings(".sideImg").toggleClass("dis");
									}
								}
							});
		}
	};
	return init;
})(jQuery);