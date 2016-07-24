$(document).ready(function(){
	$("li.donate-menu-li").not(".no-donate").click(function(){
		optionClick(this, "donate");
	});
});
