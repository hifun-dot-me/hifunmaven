$(document).ready(function(){
	$("#search-btn").click(function(){
		$("#mainForm").attr("action", $("#base").val()+'/headpage/hifunplayground.do');
		$("#mainForm").submit();
	});
});

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

function zan(e, evaluateId){
	$(e).blur();
	//以下用ajax提交点赞数据
	evaluatePost(e, evaluateId, 1, 'hithings');
}

function cai(e, evaluateId){
	$(e).blur();
	//以下用ajax提交点踩数据
	evaluatePost(e, evaluateId, -1, 'hithings');
}

function evaluatePost(e, evaluateId, evaluateTypeId, relateTypeName){
	ajaxPost(
			$("#base").val()+'/headpage/evaluate.do', 
			{
				evaluateId: evaluateId,
				evaluateTypeId: evaluateTypeId,
				relateTypeName: relateTypeName
			}, 
			'json', function(res){
				if(res.data == 1){
					//界面计数＋1
					$(e).next().addClass('curr-choice').html(parseInt($(e).next().text()) + 1);
					//赞计数+1，踩不增加
					if(evaluateTypeId == 1){
						$("#givezan").html(parseInt($("#givezan").text())+1);
					}
				}else if(res.date == -2 || res.date == -3){
					window.wxc.xcConfirm('参数异常，请联系管理员', window.wxc.xcConfirm.typeEnum.info);
				}else if(res.data == -1){
					window.wxc.xcConfirm('已赞/踩过，请勿重复操作哦', window.wxc.xcConfirm.typeEnum.info);
				}else if(res.data == 0){
					window.wxc.xcConfirm('请先登录', window.wxc.xcConfirm.typeEnum.info);
					$("a.evaluate").attr("onclick", "blurutil(this)");
				}
			}
			);
	$(e).parent().children("a.evaluate").attr("onclick", "blurutil(this)");
}

function mouseonblackboard(e){
	$(e).children(".hiplayground-tip-div").show().animate({height:"60px"});
}

