$(document).ready(function(){
	$(".letter-li").click(function(){
		$(".letter-li").removeClass('curr-letter-li').addClass('normal-letter-li');
		$(this).addClass('curr-letter-li');
	});
	$("#homeBtn").click(function(){
		locationTo($("#base").val());
	});
});

function sendletter(e){
	//ajax发送信息到后端，返回历史记录
}

function locationTo(href){
	location.href = href;
}
