var second = 2;//跳转时间间隔
$(document).ready(function(){
	//加载好友申请信息
	initApplyFriend();
	//首页加载选择第一个菜单栏
	$(".menu-li").first().addClass('curr-li');
	$("#content-frame").attr("src", $("#base").val() + "/headpage/firstpage.do");
	
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
	
	$('#loginModal').on('hidden.bs.modal', function () {
		initLoginForm();
	});
	
	$('#registerModal').on('hidden.bs.modal', function () {
		initRegisterForm();
	});
	
	$('#hiapplyModal').on('hidden.bs.modal', function () {
		initApplyFriend();
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
	var nickname = $("#register-nickname").val();
	var password = $("#register-password").val();
	var passwordr = $("#register-passwordr").val();
	if(username == '' || username.length > 20){
		window.wxc.xcConfirm('用户名输入不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	if(nickname == '' || nickname.length > 20){
		window.wxc.xcConfirm('昵称输入不合法', window.wxc.xcConfirm.typeEnum.info);
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

function initLoginForm(){
	$("#login-username").val("");
	$("#login-password").val("");
}

function initRegisterForm(){
	$("#register-username").val("");
	$("#register-nickname").val("");
	$("#register-password").val("");
	$("#register-passwordr").val("");
}

function initApplyFriend(){
	ajaxGet(
			$("#base").val()+'/headpage/queryApplyFriend.do', 
			{}, 
			'json', doQueryApplyFriendSuccess
			);
}

function doQueryApplyFriendSuccess(res){
	var list = res.data;
	var html = "";
	$(".num-record").remove();
	if(list.length > 0){
		$("#hiapply-span").after("<span class='num-record'> (" + list.length + ")</span>");
		//嗨信icon
		$("#hiletter-span").after("<span class='hitooltip-span num-record'>" + list.length + "</span>");
		
		for(var i = 0;i < list.length;i++){
			html = html + "<ul class='normal-ul apply-ul'>" +
								"<li class='normal-li menu-horizontal apply-li' title='申请人'>" +
									"<a class='normal-a floatnone-a cursor-a user-link' onclick=\"userinfo(this, '" + list[i].username + "')\">" + list[i].nickname + "</a>" +
								"</li>" +
								"<li class='normal-li menu-horizontal apply-li' title='申请时间'>" + list[i].applyTime + "</li>" +
								"<li class='normal-li menu-horizontal apply-li right' title='操作'>" +
									"<a class='normal-a cursor-a user-link' onclick=\"agreeApplyFriend(this, '" + list[i].username + "', '2')\">同意</a>" +
									"<a class='normal-a cursor-a user-link margin-left10' onclick=\"agreeApplyFriend(this, '" + list[i].username + "', '-1')\">拒绝</a>" +
								"</li>" +
							"</ul>";
		}
	}
	if(html == ''){
		html = "暂无数据.";
	}
	$("#hiapply-div").html(html);
}
function doLoginSuccess(res){
	if(res.data){
		window.wxc.xcConfirm('登录成功，'+second+'秒后自动跳转', window.wxc.xcConfirm.typeEnum.success);
		setTimeout(function(){
			location.href=$("#base").val()+"/userAuthen/main.do";
		}, second*1000);
	}else{
		window.wxc.xcConfirm('输入信息有误', window.wxc.xcConfirm.typeEnum.info);
	}
}
function doRegisterSuccess(res){
	if(res.data == 1){
		window.wxc.xcConfirm('注册成功，'+second+'秒后自动跳转', window.wxc.xcConfirm.typeEnum.success);
		setTimeout(function(){
			location.href=$("#base").val()+"/userAuthen/main.do";
		}, second*1000);
	}else if(res.data == -2){
		window.wxc.xcConfirm('输入信息有误', window.wxc.xcConfirm.typeEnum.info);
	}else if(res.data == -1){
		window.wxc.xcConfirm('昵称已被使用过', window.wxc.xcConfirm.typeEnum.info);
		$("#register-nickname").val("");
	}else if(res.data == 0){
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
function agreeApplyFriend(e, username, applyStatus){
	var this_ = $(e);
	$(e).blur();
	ajaxPost(
			$("#base").val()+'/headpage/agreeApplyFriend.do', 
			{
				username : username, 
				applyStatus : applyStatus
			}, 'json', function(res){
				doAgreeApplyFriendSuccess(res, this_);
			}
			);
}
function doAgreeApplyFriendSuccess(res, e){
	if(res.data == -1){
		$(e).parent().html("<span class='red'>已拒绝</span>");
	}else if(res.data == 2){
		$(e).parent().html("<span class='red'>已同意</span>");
	}else if(res.data == -2){
		window.wxc.xcConfirm('操作失败，请联系管理员', window.wxc.xcConfirm.typeEnum.info);
	}else if(res.data == 0){
		window.wxc.xcConfirm('请先登录', window.wxc.xcConfirm.typeEnum.info);
	}else{
		window.wxc.xcConfirm('系统访问出错，请联系管理员！', window.wxc.xcConfirm.typeEnum.error);
	}
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