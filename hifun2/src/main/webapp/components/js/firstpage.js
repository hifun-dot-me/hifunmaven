$(document).ready(function(){
	$(".menu-li").first().addClass('curr-li');
});

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

function signin(e){
	var this_ = $(e);
	$.ajax({
		url:$("#base").val()+'/headpage/signin.do',
		data:{},
		type:'post',
		dataType:'json',
		success:function(res){
			if(res.data == 1){
//				window.wxc.xcConfirm('签到成功', window.wxc.xcConfirm.typeEnum.success);
				this_.parent().html("<button type='button' class='btn btn-primary btn-lg btn-block disabled'>签 到 成 功</button>");
			}else if(res.data == 0){
				window.wxc.xcConfirm('请先登录', window.wxc.xcConfirm.typeEnum.info);
				this_.addClass("btn-block disabled");
			}else if(res.data == -1){
				window.wxc.xcConfirm('今日已经签到过了，明天再来吧', window.wxc.xcConfirm.typeEnum.info);
			}else{
				window.wxc.xcConfirm('签到的小伙伴太多了，请稍后再试', window.wxc.xcConfirm.typeEnum.info);
			}
		},
		error:function(res){
			window.wxc.xcConfirm('系统访问出错，请联系管理员！', window.wxc.xcConfirm.typeEnum.error);
		}
	});
}
function hifundetail(e){
	$(e).blur();
	window.wxc.xcConfirm('工程师正在玩命开发中，请稍后...', window.wxc.xcConfirm.typeEnum.info);
}
