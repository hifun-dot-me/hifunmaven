var letter = '';

$(document).ready(function(){
	$(".letter-li").not(".nofriend").click(function(){
		$(".letter-li").removeClass('curr-letter-li').addClass('normal-letter-li');
		$(this).addClass('curr-letter-li');
	});
	$("#homeBtn").click(function(){
		locationTo($("#base").val());
	});
});

UE.getEditor('letter', {
	toolbars:[['emotion']]
}).ready(function() {
    //this是当前创建的编辑器实例
	letter = this.getContent();
});

function sendletter(e){
	//ajax发送信息到后端，返回历史记录
}

function locationTo(href){
	location.href = href;
}
