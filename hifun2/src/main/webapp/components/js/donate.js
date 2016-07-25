$(document).ready(function(){
	$("li.donate-menu-li").not(".no-donate").click(function(){
		optionClick(this, "donate");
	});
	
	$(".price-div").click(function(){
		$(".price-div").removeClass("price-div-curr");
		$(this).addClass("price-div-curr");
		
		//显示二维码
		$(".weixin-donate").addClass("hid");
		var imgindex = $(".price-div").index(this);
		//防止越界
		imgindex = imgindex + 1 > $(".price-div").length ? 0 : imgindex;
		$(".weixin-donate").eq(imgindex).removeClass("hid");
	});
});
