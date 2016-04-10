$(document).ready(function(){

	$(".home-link").click(function(){
		location.href = $("#base").val()+'/headpage/index.do';
	});
});

/**
 * 是否PC端
 * @returns {Boolean}
 */
function IsPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = ["Android", "iPhone",
                "SymbianOS", "Windows Phone",
                "iPad", "iPod"];
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
    return flag;
}

function encrypt(param){
	return $.base64.btoa(encodeURI(param));
}

/**
 * 计算鼠标位置
 * @param event
 * @returns 
 */
function mouseCoords(ev) { 
	if(ev.pageX || ev.pageY){ 
		return {x:ev.pageX, y:ev.pageY}; 
	} 
	return { 
		x:ev.clientX + document.body.scrollLeft - document.body.clientLeft, 
		y:ev.clientY + document.body.scrollTop - document.body.clientTop 
	}; 
}
function mousePosition(e){
	var ev = e || window.event;
	var mousePos = mouseCoords(ev);
	var x = mousePos.x;
	var y = mousePos.y;
	return {x:x, y:y};
}

function ajaxPost(url, data, dataType, doSuccess){
	ajaxParam(url, data, 'post', dataType, doSuccess);
}

function ajaxGet(url, data, dataType, doSuccess){
	ajaxParam(url, data, 'get', dataType, doSuccess);
}

function ajaxParam(url, data, type, dataType, doSuccess){
	$.ajax({
		url:url,
		data:data,
		type:type,
		dataType:dataType,
		success:doSuccess,
		error:function(res){
			window.wxc.xcConfirm('系统访问出错，请联系管理员！', window.wxc.xcConfirm.typeEnum.error);
		}
	});
}

function btnTest(e){
	$(e).blur();
	window.wxc.xcConfirm('工程师正在玩命开发中，请稍后...', window.wxc.xcConfirm.typeEnum.info);
}

function jumpTo(e, url){
	$(e).blur();
	window.open(url);
}

function iframeTo(linkType, linkTo){
	if(linkType == 1){
		window.parent.document.getElementById(linkTo).click();
	}else{
//		window.parent.document.getElementById("content-frame").src = url;
	}
}

function iframeToURL(url){
	window.parent.document.getElementById("content-frame").src = url;
}

function blurutil(e){
	$(e).blur();
}

function locationToNoSession(href){
	location.href = href;
}

function locationTo(e, href){
	ajaxGet(
			$("#base").val()+'/userAuthen/judgeSession.do', 
			{}, 
			'json', function(res){
				if(res.data){
					iframeToURL($("#base").val() + href);
				}else{
					window.wxc.xcConfirm('请先登录', window.wxc.xcConfirm.typeEnum.info);
					$(e).addClass("btn-block disabled").removeAttr("onclick");
				}
			}
			);
}

/**
 * 用户信息
 * @param e
 */
function userinfo(e, username){
	$(e).blur();
//	window.wxc.xcConfirm('工程师正在玩命开发中，请稍后...', window.wxc.xcConfirm.typeEnum.info);
	window.parent.location.href = $("#base").val() + "/userAuthen/userinfo.do?username=" + encrypt(username);
}

/**
 * 文本框根据输入内容自适应高度
 * @param                {HTMLElement}        输入框元素
 * @param                {Number}                设置光标与输入框保持的距离(默认0)
 * @param                {Number}                设置最大高度(可选)
 */
var autoTextarea = function (elem, extra, maxHeight) {
        extra = extra || 0;
        var isFirefox = !!document.getBoxObjectFor || 'mozInnerScreenX' in window,
        isOpera = !!window.opera && !!window.opera.toString().indexOf('Opera'),
                addEvent = function (type, callback) {
                        elem.addEventListener ?
                                elem.addEventListener(type, callback, false) :
                                elem.attachEvent('on' + type, callback);
                },
                getStyle = elem.currentStyle ? function (name) {
                        var val = elem.currentStyle[name];
 
                        if (name === 'height' && val.search(/px/i) !== 1) {
                                var rect = elem.getBoundingClientRect();
                                return rect.bottom - rect.top -
                                        parseFloat(getStyle('paddingTop')) -
                                        parseFloat(getStyle('paddingBottom')) + 'px';        
                        };
 
                        return val;
                } : function (name) {
                                return getComputedStyle(elem, null)[name];
                },
                minHeight = parseFloat(getStyle('height'));
 
        elem.style.resize = 'none';
 
        var change = function () {
                var scrollTop, height,
                        padding = 0,
                        style = elem.style;
 
                if (elem._length === elem.value.length) return;
                elem._length = elem.value.length;
 
                if (!isFirefox && !isOpera) {
                        padding = parseInt(getStyle('paddingTop')) + parseInt(getStyle('paddingBottom'));
                };
                scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
 
                elem.style.height = minHeight + 'px';
                if (elem.scrollHeight > minHeight) {
                        if (maxHeight && elem.scrollHeight > maxHeight) {
                                height = maxHeight - padding;
                                style.overflowY = 'auto';
                        } else {
                                height = elem.scrollHeight - padding;
                                style.overflowY = 'hidden';
                        };
                        style.height = height + extra + 'px';
                        scrollTop += parseInt(style.height) - elem.currHeight;
                        document.body.scrollTop = scrollTop;
                        document.documentElement.scrollTop = scrollTop;
                        elem.currHeight = parseInt(style.height);
                };
        };
 
        addEvent('propertychange', change);
        addEvent('input', change);
        addEvent('focus', change);
        change();
};
//调用方式：在textarea后添加js，id为textarea的id
//<script>
//var text = document.getElementById("bbapricedescription");
//autoTextarea(text);// 调用
//</script>