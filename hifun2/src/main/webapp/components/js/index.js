var second = 2;//跳转时间间隔
$(document).ready(function(){
	$(".menu-li").first().addClass('curr-li');
	
	
	//登录按钮
	$("#loginBtn").click(function(){
		if(!checkForm()){
			return false;
		}
		ajaxPost(
				$("#base").val()+'/userAuthen/login.do', 
				$("#mainForm").serialize(), 
				'json', doLoginSuccess
				);
	});
	
	//注册按钮
	$("#registerBtn").click(function(){
		if(!checkForm2()){
			return false;
		}
		ajaxPost(
				$("#base").val()+'/userAuthen/register.do', 
				$("#mainForm2").serialize(), 
				'json', doRegisterSuccess
				);
	});
});
function checkForm(){
	var username = $("#login-username").val();
	var password = $("#login-password").val();
	if(username == '' || username.length > 20){
		window.wxc.xcConfirm('用户名输入不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	if(password == '' || password.length > 32){
		window.wxc.xcConfirm('密码输入不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
}
function checkForm2(){
	var username = $("#register-username").val();
	var password = $("#register-password").val();
	var passwordr = $("#register-passwordr").val();
	if(username == '' || username.length > 20){
		window.wxc.xcConfirm('用户名输入不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	if(password == '' || password.length > 32){
		window.wxc.xcConfirm('密码输入不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	if(passwordr == '' || passwordr.length > 32){
		window.wxc.xcConfirm('密码输入不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	if(!password === passwordr){
		window.wxc.xcConfirm('两次密码不一致', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
}
function doLoginSuccess(res){
	if(res.data){
		window.wxc.xcConfirm('登录成功，'+second+'秒后自动跳转', window.wxc.xcConfirm.typeEnum.success);
		setTimeout(function(){
			location.href=$("#base").val()+"/userAuthen/main.do";
		}, second*1000);
	}else{
		window.wxc.xcConfirm('用户名或密码错误', window.wxc.xcConfirm.typeEnum.info);
	}
}
function doRegisterSuccess(res){
	if(res.data){
		window.wxc.xcConfirm('注册成功，'+second+'秒后自动跳转', window.wxc.xcConfirm.typeEnum.success);
		setTimeout(function(){
			location.href=$("#base").val()+"/userAuthen/main.do";
		}, second*1000);
	}else{
		window.wxc.xcConfirm('注册失败', window.wxc.xcConfirm.typeEnum.info);
	}
}
function logout(e){
	$(e).blur();
	location.href=$("#base").val()+"/userAuthen/logout.do";
}
function mailto(e){
	$(e).blur();
	location.href="mailto:790634031@qq.com";
}
function clickhitoolli(e, tooldivid){
	$(tooldivid).show();
	$(e).addClass("hitool-mouseclick-li");
	$(tooldivid).css(
		{
			//元素顶距+元素高度
			"top": $(e).offset().top + $(e).height(),
			//元素左距
			"left": $(e).offset().left
		}
	).animate({
		//高度需适配
		"height": "49px"
	});
}
function mouseouthitoolli(e, tooldivid){
	calcposition(mousePosition().x, mousePosition().y, e, tooldivid);
}
function mouseouthitoolletterdiv(toolid, e){
	calcposition(mousePosition().x, mousePosition().y, toolid, e);
}
function locationTo(e, loc){
	$(".menu-li").removeClass('curr-li');
	$(e).addClass('curr-li');
	$("#content-frame").attr('src', $("#base").val()+loc);
}
/**
 * 计算元素位置
 */
function calcposition(x, y, e1, e2, flag){
	judgemouseout(x, y, e1, e2);
}
/**
 * 比较鼠标位置与元素位置，判断是否在元素内
 * @param x
 * @param y
 * @param e1
 * @param e2
 */
function judgemouseout(x, y, e1, e2){
	if((x >= $(e1).offset().left && x <= $(e1).offset().left + $(e1).width() 
			&& y >= $(e1).offset().top && y <= $(e1).offset().top + $(e1).height()) ||
		(x >= $(e2).offset().left && x <= $(e2).offset().left + $(e2).width() 
				&& y >= $(e2).offset().top && y <= $(e2).offset().top + $(e2).height())){
		
	}else{
		hidetool(e1, e2);
	}
}
/**
 * 隐藏元素
 * @param e1
 * @param e2
 */
function hidetool(e1, e2){
	$(e2).animate({
		"height": "0px",
		"border": "0px solid #0080FF"
	}, function(){
		$(e1).removeClass("hitool-mouseclick-li");
		$(e2).hide();
	});
}