$(document).ready(function(){
	$("li.shopdetail-menu-li").click(function(){
		// 选项卡样式变化
		$("li.shopdetail-menu-li").removeClass("shopdetail-curr-li");
		$(this).addClass("shopdetail-curr-li");
		
		// 展示内容样式变化
		$(".shopdetail-info-div").hide();
		$($(this).attr("target")).show();
	});
});
