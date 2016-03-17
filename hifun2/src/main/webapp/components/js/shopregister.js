$(document).ready(function(){
	ajaxGet(
			$("#base").val()+'/dictionary/querylist.do', 
			{}, 
			'json', doQuerySuccess
			);
});

function doQuerySuccess(res){
	var shoptypelist = eval(res.data);
	var shoptype = "<option value='0'>商家类型</option>";
	for(var i = 0;i < shoptypelist.length;i++){
		shoptype = shoptype + "<option value='" + shoptypelist[i].typeId + "'>" + shoptypelist[i].typeName + "</option>";
	}
	$("#shopType").html(shoptype);
}