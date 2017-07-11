var username;

/**
 * 页面获取初始数据，初始化登录按钮
 */
$(document)
		.ready(
				function() {
					var login = document.getElementById('login');
					if (login.children[0].innerHTML == "登录") {
						$.ajax({
							type : "POST",
							url : "/pb/restful/users/getCurrentUser",
							dataType : "json",
							success : function(data) {
								username = data.obj;
								if (username == null) {
								} else {
									login.innerHTML = "";
									var shtml = "<a class='button fit' id='login' onclick='exit()'>"
											+ username
											+ ",<font color='red'><bold>退出</bold></font></a>";
									$('#login').append(shtml);
								}
								loadData();
							}
						});
					}
				});


/**
 * 商品展示页面数据载入
 */
function loadData(){
	console.log("this is the part:"+document.getElementById("header").getAttribute("value"));
	$.ajax({
		type : "POST",
		url : "/pb/restful/item/getItemByPart",
		dataType : "json",
		data : {
			"part" : document.getElementById("header").getAttribute("value"),
		},
		success : function(data) {
			//console.log(data);
			document.getElementById("two").innerHTML = "";
			var id="";
			var shtml="";
			$.each(data.obj,function(index, item) {
				if(getNum(item.itemId)!=id){
					if(index!=0){
						shtml+="<div id='div"+id+"'><p></p></div><ul class='actions'><li><a class='button' onclick='addItem2Cart(this);' value='"+id+"'>加入购物车</a></li></ul></div></div></div></section>";
						//console.log(shtml);
						$('#two').append(shtml);
					}
					shtml="<section><a class='image'><img src='"+item.coverImage+"' alt='' data-position='center center' onerror=\"this.src='images/errorpic.jpg'\"/></a>"+
					"<div class='content'><div class='inner'><header class='major'><h3>"+item.clothesName+"</h3></header>"+
					"<p>"+item.clothesdetail+"</p><div name='sizeinput'>";
					shtml+="<input type='radio' id='"+item.itemId+"' name='"+getNum(item.itemId)+"' value='"+item.size+"' onclick='check_radio(this)' money='"+item.price+"'><label for='"+item.itemId+"'>"+item.size+"</label>"
					id=getNum(item.itemId);
				}
				else{
					shtml+="<input type='radio' id='"+item.itemId+"' name='"+getNum(item.itemId)+"' value='"+item.size+"' onclick='check_radio(this)' money='"+item.price+"'><label for='"+item.itemId+"' money='"+item.price+"'>"+item.size+"</label>"
				}
			})
			if(data.obj.length!=0){
				shtml+="<div id='div"+id+"'><p></p></div><ul class='actions'><li><a class='button' onclick='addItem2Cart(this);' value='"+id+"'>加入购物车</a></li></ul></div></div></div></section>"
				$('#two').append(shtml);
		
			}
		}
	});
	
}

/**
 * 型号选中时显示价格
 */
function check_radio(input){
	var money = input.getAttribute("money");
	var id = input.getAttribute("name")
	//console.log(money);
	$("#div"+id).html("￥："+money);
	$("#div"+id).slideDown("slow");
}



/**
 * 截取string中的数字
 */
function getNum(text){
	var value = text.replace(/[^0-9]/ig,"");
	return value;
}



/**
 * 退出登录
 */
function exit() {
	console.log();
	$.ajax({
		type : "POST",
		url : "/pb/restful/deleteSession/deleteUsers",
		dataType : "json",
		data : {
			"username" : username
		},
		success : function(data) {
			jumpurl();
		}

	});
}

/**
 * 获取当前session用户名
 */
function getUsername(){
	$.ajax({
		type : "POST",
		url : "/pb/restful/users/getCurrentUser",
		dataType : "json",
		success : function(data) {
			username = data.obj;
			console.log(username);
			return username;
		}
	});
	
}

/**
 * 添加条目到用户的购物车（cart）中
 * 
 * @param item
 *            添加购物车按钮
 */
function addItem2Cart(item) {
	var itemID = item.getAttribute("value");
	var size = document.getElementsByName(itemID);
	var flag = 1;
	for ( var i = 0; i < size.length; i++) {
		if (size[i].checked) {
			itemID += size[i].value;
			flag = 0;
		}
	}
	if (flag) {
		Lobibox.notify('info', {
			img : "images/warn.png",
			title : "请选择型号！"
		});
		return;
	}
	
	$.ajax({
		type : "POST",
		url : "/pb/restful/users/getCurrentUser",
		dataType : "json",
		success : function(data) {
			username = data.obj;
			if (username == null) {

				Lobibox.notify('info', {
					img : "images/warn.png",
					title : "您还没有登陆，请登录后购买 ",
					msg : "稍后将自动跳转到登录页面。"
				});
				setTimeout('jumplogin()', 5000);
				return;
			}
			else{
				$.ajax({
					type : "POST",
					url : "/pb/restful/item/addItem",
					dataType : "json",
					data : {
						"itemID" : itemID,
					},
					success : function(data) {
						Lobibox.notify('info', {
							img : "images/warn.png",
							title : "加入购物车成功",
							msg : "请到购物车查看。"
						});
					}

				});
			}
		}
	});
}


/**
 * 跳转到主页
 */
function jumpurl(){
	window.location.href="index.html"; 
}

/**
 * 跳转到登录界面
 */
function jumplogin() {
	window.location.href = "login.html";
}

/*
 * 功能：获取cookies函数 参数：name，cookie名字
 */
function getCookie(name) {
	var arr = document.cookie.match(new RegExp("(^| )" + name
			+ "=([^;]*)(;|$)"));
	if (arr != null) {
		return unescape(arr[2]);
	} else {
		return null;
	}
}
/*
 * 功能：删除cookies函数 参数：name，cookie名字
 */

 function delCookie(name){
     var exp = new Date();  // 当前时间
     exp.setTime(exp.getTime() - 1);
     var cval=getCookie(name);
     if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
 }
 
 /*
	 * 功能：保存cookies函数 参数：name，cookie名字；value，值
	 */
 function SetCookie(name,value){
     var Days = 0.02;   // cookie 将被保存半小时
     var exp  = new Date();  // 获得当前时间
     exp.setTime(exp.getTime() + Days*24*60*60*1000);  // 换成毫秒
     document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
 } 