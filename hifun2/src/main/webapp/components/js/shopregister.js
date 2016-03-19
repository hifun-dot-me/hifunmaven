var second = 2;//跳转时间间隔

$(document).ready(function(){
	ajaxGet(
			$("#base").val()+'/dictionary/querylist.do', 
			{dictionaryType : 'shopType'}, 
			'json', doQueryShopTypeSuccess
			);
	ajaxGet(
			$("#base").val()+'/dictionary/querylist.do', 
			{dictionaryType : 'shopLevel'}, 
			'json', doQueryShopLevelSuccess
			);
	
	$("#submit").click(function(){
		if(!checkForm()){
			return false;
		}
		ajaxPost(
				$("#base").val()+'/headpage/shopregister.do', 
				$("#mainForm").serialize(), 
				'json', doShopregisterSuccess
				);
		return false;
	});
});

function checkForm(){
	var shopName = $("#shopName").val();
	if(shopName == '' || shopName.length > 20){
		window.wxc.xcConfirm('商家名称输入不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	var shopType = $("#shopType").val();
	if(shopType == 0){
		window.wxc.xcConfirm('商家类型必选', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	var shopLevel = $("#shopLevel").val();
	if(shopLevel == 0){
		window.wxc.xcConfirm('商家级别必选', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	var shopDesc = $("#shopDesc").val();
	if(shopDesc == '' || shopDesc.length > 50){
		window.wxc.xcConfirm('商家描述输入不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	var shopAddr = $("#shopAddr").val();
	if(shopAddr == '' || shopAddr.length > 100){
		window.wxc.xcConfirm('商家地址输入不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
}

function doQueryShopTypeSuccess(res){
	var data = res.data;
	var type = "<option value='0'>商家类型</option>";
	for(var i = 0;i < data.length;i++){
		type = type + "<option value='" + data[i].typeId + "'>" + data[i].typeName + "</option>";
	}
	$("#shopType").html(type);
}

function doQueryShopLevelSuccess(res){
	var data = res.data;
	var type = "<option value='0'>商家级别</option>";
	for(var i = 0;i < data.length;i++){
		type = type + "<option value='" + data[i].typeId + "'>" + data[i].typeName + "</option>";
	}
	$("#shopLevel").html(type);
}

function doShopregisterSuccess(res){
	var data = res.data;
	if(data == 0){
		window.wxc.xcConfirm('请先登录', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}else if(data == -1){
		window.wxc.xcConfirm('保存商家信息失败', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}else if(data == 1){
		window.wxc.xcConfirm('注册成功，'+second+'秒后自动跳转', window.wxc.xcConfirm.typeEnum.success);
		setTimeout(function(){
			location.href=$("#base").val()+"/headpage/hifunplayground.do";
		}, second*1000);
	}else if(data == 2){
		window.wxc.xcConfirm('该用户名已注册过商家，不能重复注册', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
}

