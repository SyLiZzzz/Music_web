//用户名
function checkUser(){
	var code = document.getElementById("user").value;
	var span = document.getElementById("user_span");
	//var reg = /^[^/x00-x/xff]{1,5}$/;  双字节字符，包含中文
	//var reg = /^[\u4e00-\u9fa5]{1,5}$/;  中文
	var reg = /^[\u4e00-\u9fa5A-Za-z0-9_]{1,16}$/;
	if(reg.test(code)){
		span.innerHTML="√";
		span.className="ok";
		return true;
	}else{
		span.innerHTML="输入1-16位字符";
		span.className="err";
		return false;
	}
}

//电话
function checkEma(){
	var code = document.getElementById("phone").value;
	var span = document.getElementById("s");
	var reg = /^1[3|4|5|7|8][0-9]\d{8,11}$/;
	if(reg.test(code)){
		span.innerHTML="√";
		span.className="ok";
		return true;
	}else{
		span.innerHTML="请输入有效电话";
		span.className="err";
		return false;
	}
	
}

function checkPassword() {		// 验证密码
	var code = document.getElementById("pass").value;
	var span = document.getElementById("p");
	var reg = /^(\w|\d){6,16}$/;// 匹配字符, 6到16位
	if(reg.test(code)){
		span.innerHTML="√";
		span.className="ok";
		return true;
	}else{
		span.innerHTML="输入6-16位字符";
		span.className="err";
		return false;
	}
}

function checkConfirm() {	// 验证确认密码
	var pass =document.getElementById("pass").value;
	var pass1 =document.getElementById("pass1").value;
	var span=document.getElementById("p1");
	if(pass==pass1){
		span.innerHTML="√";
		span.className="ok";
		return true;
	}else{
		span.innerHTML="密码不一致";
		span.className="err";
		return false;
	}
}