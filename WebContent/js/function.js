function change(img){
	img.src="getCode?"+new Date().getTime();
}
var flag=true;//标记位


//鼠标点击时的二维码的判断
function FocusItem(obj){
	if($(obj).attr('name')=='veryCode'){
	$(obj).next().next().html('').removeClass('error');
	}else{
		$(obj).next('span').html('').removeClass('error');
	}	
}
//鼠标移出时的验证
function CheckItem(obj){
	var msgBox =$(obj).next('span');
	switch($(obj).attr('name')){
	case "username":
		if(obj.value==""){
			msgBox.html('用户名不能为空');
			msgBox.addClass('error');
			flag=false;
		}else{
			var url="usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
			
			$.get(url,function(data){
				if(data=="false"){
				msgBox.html('用户名不能使用！');
				msgBox.addClass('error');
				flag=false;
			}else{
				msgBox.html().removeClass('error');
				flag=true;
			}	
			});
		}
		break;
	case "password":
		if(obj.value==""){
			msgBox.html('密码不能为空');
			msgBox.addClass('error');
			flag=false;
		}else{
			flag=true;
		}
		break;
	case "repassword":
		if(obj.value==""){
			msgBox.html('确认密码不能为空');
			msgBox.addClass('error');
			flag=false;
		}else if($(obj).val() !=$('input(name="password")').val()){
			msgBox.html('两次输入的密码不一致');
			msgBox.addClass('error');
			flag=false;
		}else{
			flag=true;
		}
		break;
	case "veryCode":
		var numshow=$(obj).next().next();
		if(obj.value==""){
			numshow.html('验证码不能为空');
			numshow.addClass('error');
			flag=false;
		}else{
             var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
			
			$.get(url,function(numdata){
			
				if(numdata=="false"){
				numshow.html('验证码不能使用！');
				numshow.addClass('error');
				flag=false;
			}else{
				numshow.html().removeClass('error');
				flag=true;
			}	
			});
		}
		break;	
	}
}
//批量验证
function checkForm(frm){
	var els=frm.getElementsByTagName('input');
	//使带有onblur这个属性的才需要验证
	for(var i=0;i<els.length;i++){
		if(els[i]!=null){
			if(els[i].getAttribute("onblur")){
				CheckItem(els[i]);
			}
		}
	}
	return flag;
}