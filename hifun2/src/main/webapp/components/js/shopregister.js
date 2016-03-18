$(document).ready(function(){
	ajaxGet(
			$("#base").val()+'/dictionary/querylist.do', 
			{}, 
			'json', doQuerySuccess
			);
});

function doQuerySuccess(res){
	var data = res.data;
	var shoptype = "<option value='0'>商家类型</option>";
	for(var i = 0;i < data.length;i++){
		shoptype = shoptype + "<option value='" + data[i].typeId + "'>" + data[i].typeName + "</option>";
	}
	$("#shopType").html(shoptype);
}