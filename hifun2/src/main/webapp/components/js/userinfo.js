$(document).ready(function(){
	ajaxGet(
			$("#base").val()+'/headpage/showapplyfriend.do', 
			{applyusername : $("#applyusername").text()}, 
			'json', doShowApplyFriendSucc
			);
});

function applyFriend(){
	ajaxGet(
			$("#base").val()+'/headpage/applyfriend.do', 
			{applyusername : $("#applyusername").text()}, 
			'json', doApplyFriendSucc
			);
}

function doShowApplyFriendSucc(res){
	if(res.data == 1){
		$("#apply").html("<a class='normal-a floatnone-a curson-a user-link' id='applyFriend' onclick='applyFriend()'>加为好友</a>");
	}
}

function doApplyFriendSucc(res){
	
}
