$(document).ready(function(){
	$(".letter-li").click(function(){
		$(".letter-li").removeClass('curr-letter-li');
		$(this).addClass('curr-letter-li');
	});
});