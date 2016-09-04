var websocket = null;

$(document).ready(function(){
	initWebSocket();
	
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
	this.setContent('');
});

function sendletter(e){
	send();
}

function locationTo(href){
	location.href = href;
}

function initWebSocket(){
    
    //判断当前浏览器是否支持WebSocket
    if('WebSocket' in window){
//        websocket = new WebSocket("ws://hifun.me:8080/hilettersocket");
        websocket = new WebSocket("ws://localhost:8080/hifunmaven/hilettersocket");
    }
    else{
        alert('Not support websocket')
    }
    
    //连接发生错误的回调方法
    websocket.onerror = function(){
    	consoleLog("error");
        setMessageInnerHTML("error<br/>");
        $("#sendBtn").remove();
    };
     
    //连接成功建立的回调方法
    websocket.onopen = function(event){
    	consoleLog("open");
//        setMessageInnerHTML("<br/>");
    }
     
    //接收到消息的回调方法
    websocket.onmessage = function(event){
        setMessageInnerHTML(event.data);
    }
     
    //连接关闭的回调方法
    websocket.onclose = function(){
    	consoleLog("close");
//        setMessageInnerHTML("<br/>");
    }
     
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function(){
        websocket.close();
    }
}

//将消息显示在网页上
function setMessageInnerHTML(innerHTML){
    var mesHtml = $('#message').html();
    $('#message').html(mesHtml + innerHTML);
	//滚动条默认到最底部(注：暂时注释该句，为防止正在查看历史记录时，新接收消息导致滚动条跳转到最后)
//	$('#message').scrollTop( $('#message')[0].scrollHeight );
	initCurrUser();
}

//关闭连接
function closeWebSocket(){
    websocket.close();
}
 
//发送消息
function send(){
	var letter = UE.getEditor('letter').getContent();
    if(letter == null || letter === '' || letter.trim() === ''){
  	  alert('content unvalidate.');
  	  return false;
    }
    websocket.send(letter);
    UE.getEditor('letter').setContent('');
    
    //发送后将滚动条拖到最底部
    $('#message').scrollTop( $('#message')[0].scrollHeight );
}

//加载当前用户的显示场景
function initCurrUser(){
	var currUsername = $("#usernameHid").val();//当前用户
	var ut = "label.user-title";
	for(var i = 0;i < $(ut).length;i++){
		if($("a.hi-letter-user").eq(i).text() == currUsername){
			$("a.hi-letter-user").eq(i).parent("label.user-title").css({"color": "green"});
		}
	}
}
