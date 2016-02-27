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
function userinfo(e){
	$(e).blur();
	window.wxc.xcConfirm('工程师正在玩命开发中，请稍后...', window.wxc.xcConfirm.typeEnum.info);
}
function logout(e){
	$(e).blur();
	location.href=$("#base").val()+"/userAuthen/logout.do";
}
function mailto(e){
	$(e).blur();
	location.href="mailto:790634031@qq.com";
}
function locationTo(e, loc){
	$(".menu-li").removeClass('curr-li');
	$(e).addClass('curr-li');
	$("#content-frame").attr('src', $("#base").val()+loc);
}
function mouseoverhiletter(e){
	$(e).addClass("hitool-mouseon-li");
}
function mouseouthiletter(e){
	$(e).removeClass("hitool-mouseon-li");
}