$(document).ready(function(){
	if($("#applyTo").text() != ''){
		ajaxGet(
				$("#base").val()+'/headpage/showapplyfriend.do', 
				{applyTo : $("#applyTo").text()}, 
				'json', doShowApplyFriendSucc
		);
	}
});

function applyFriend(){
	if($("#applyTo").text() != ''){
		ajaxGet(
				$("#base").val()+'/headpage/applyfriend.do', 
				{applyTo : $("#applyTo").text()}, 
				'json', doApplyFriendSucc
		);
	}
}

function doShowApplyFriendSucc(res){
	if(res.data == 1){
		$("#apply").html("<a class='normal-a floatnone-a cursor-a user-link' id='applyFriend' onclick='applyFriend()'>加为好友</a>");
	}else if(res.data == 2){
		applying();
	}else if(res.data == 3){
		friendalready();
	}
}

function doApplyFriendSucc(res){
	if(res.data == 1){
		applying();
	}else if(res.data == -2){
		window.wxc.xcConfirm('系统访问出错，请联系管理员！', window.wxc.xcConfirm.typeEnum.error);
	}
}

function applying(){
	$("#apply").html("<span class='red'>申请中...</span>");
}

function friendalready(){
	$("#apply").html("<span class='user-link'>已是好友</span>");
}
