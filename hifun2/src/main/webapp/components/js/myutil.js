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
