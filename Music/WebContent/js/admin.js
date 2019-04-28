$(function(){
	$("#nav>li").click(function(){
		if($(this).next().css("display") == "block"){
			$(this).next().css("display","none");
		}else{
			$(this).next().css("display","block").siblings(".menu").css("display","none");
		}
	});
});