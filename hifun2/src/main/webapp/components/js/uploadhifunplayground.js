var second = 2;//跳转时间间隔
$(document).ready(function(){
	$("#submit").click(function(){
		
	});
});

function checkForm(){
	var content = $("#content").val();
	if(content == '' || content.length > 300){
		window.wxc.xcConfirm('内容长度不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
}