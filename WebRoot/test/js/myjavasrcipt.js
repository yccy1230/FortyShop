var username;

$(document)
		.ready(
				function() {
					var login = document.getElementById('login');
					if (login.children[0].innerHTML == "登录") {
						username = getCookie("username");
						if (username == null) {
							return;
						} else {
							login.innerHTML = "";
							var shtml = "<a class='button fit' id='login' onclick='exit()'>"
									+ username
									+ ",<font color='red'><bold>退出</bold></font></a>";
							console.log($('login'));
							$('#login').append(shtml);
						}
					}
				});

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
			delCookie("username");
			jumpurl();
		}

	});
}

// 跳转到主页
function jumpurl(){
	window.location.href="index.html"; 
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