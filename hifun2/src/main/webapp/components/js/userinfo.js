$(document).ready(function(){
	ajaxGet(
			$("#base").val()+'/headpage/showapplyfriend.do', 
			{applyTo : $("#applyTo").text()}, 
			'json', doShowApplyFriendSucc
			);
});

function applyFriend(){
	ajaxGet(
			$("#base").val()+'/headpage/applyfriend.do', 
			{applyTo : $("#applyTo").text()}, 
			'json', doApplyFriendSucc
			);
}

function doShowApplyFriendSucc(res){
	if(res.data == 1){
		$("#apply").html("<a class='normal-a floatnone-a curson-a user-link' id='applyFriend' onclick='applyFriend()'>加为好友</a>");
	}else if(res.data == 2){
		applying();
	}
}

function doApplyFriendSucc(res){
	if(res.data == 1){
		applying();
	}
}

function applying(){
	$("#apply").html("<span class='red'>申请中...</span>");
}
