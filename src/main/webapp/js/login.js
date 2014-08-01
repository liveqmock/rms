(function ($) {
	function js_alert(divid, msg) {
		var msg_box = $("#"+divid + " .login_box_msg");
		if (msg == "") {
			if (/MQQBrowser/.test(navigator.userAgent)){
				msg_box.hide();
			} else {
				msg_box.slideUp();
			}
			
		} else {
			if (/MQQBrowser/.test(navigator.userAgent)){
				msg_box.show();
			} else {
				msg_box.slideDown();
			}
			
		}
		msg_box.find("dd").html(msg);
	}
	
	window.js_alert = js_alert;
		
	//输入框
	function login_operate() { 
		var li = $(".login_operate ul li");
		var input = $(".login_operate ul li.password input");
		var li_hover = "li_hover";
		var li_press = "li_press";
		var phone_input = $(".phone input");
		var sms_input = $(".sms input");
		var username_input = $(".username input");
		var password_input = $(".password input");
		var password_input_new = $(".password_new input");
		var password_input_n = $(".password_n input");
		
		/*聚焦*/
		$(".focus").focus();
		/*选中*/
		$(input).click(function(){
			$(this).select();
		});
		
		//提示
		var inputs = $('.input');
		
		inputs.bind('focus',function(){
			$(this).siblings('label').css('opacity',$.trim(this.value)=='' ? 0.5 : 0);
		}).bind('keydown',function(){
			$(this).siblings('label').css('opacity',0);
		}).bind('blur',function(){
			$(this).siblings('label').css('opacity',$.trim(this.value)=='' ? 1 : 0);
		});
		setTimeout(function (){
			$.each(inputs, function (index, item){
				if ($.trim(this.value) !== ''){
					$(item).siblings('label').css('opacity',0);
				}
			});
		}, 800);
				
		if(!/(Mobile|Android|Windows Phone)/.test(navigator.userAgent))
		{
			/*悬停与聚焦后效果*/
			li.hover(function(){
				$(this).addClass(li_hover);
			  },function(){
				$(this).removeClass(li_hover);
			});
		}
		var mode_password, mode_sms;
		if (/IE/.test(navigator.userAgent) || /MQQBrowser/.test(navigator.userAgent)) {
			mode_password = function () {
				$("#mode_sms").hide();
				$("#mode_password").show();
				$(".username .focus").focus();
			}
			
			mode_sms = function () {
				$("#mode_password").hide();
				$("#mode_sms").show();
				$(".phone .focus").focus();
			} 
		} else {
		//切换
			mode_password = function () { 
				$("#mode_sms").fadeOut();
				$("#mode_password").fadeIn();
				$(".username .focus").focus(); 
			}
			
			mode_sms = function () {
				$("#mode_password").fadeOut(); 
				$("#mode_sms").fadeIn();
				$(".phone .focus").focus();		
			} 
		}
		window.mode_password = mode_password;
		window.mode_sms = mode_sms;
		$(".sms_go").hover(function(){
			$(this).removeClass(li_hover);
		  });
		
		$(phone_input).focus(function(){
			$(".phone").addClass(li_press);
			  });
		$(phone_input).blur(function(){
			$(".phone").removeClass(li_press);
			  });
			  
		$(sms_input).focus(function(){
			$(".sms").addClass(li_press);
			  });
		$(sms_input).blur(function(){
			$(".sms").removeClass(li_press);
			  });
			  
		$(username_input).focus(function(){
			$(".username").addClass(li_press);
			  });
		$(username_input).blur(function(){
			$(".username").removeClass(li_press);
			  });
			  
		$(password_input).focus(function(){
			$(".password").addClass(li_press);
			  });
		$(password_input).blur(function(){
			$(".password").removeClass(li_press);
			  });
			  
		$(password_input_new).focus(function(){
			$(".password_new").addClass(li_press);
			  });
		$(password_input_new).blur(function(){
			$(".password_new").removeClass(li_press);
			  });
			  
		$(password_input_n).focus(function(){
			$(".password_n").addClass(li_press);
			  });
		$(password_input_n).blur(function(){
			$(".password_n").removeClass(li_press);
			  });
			  	   
	};  
	
	
	//按钮
	function btn() { 
		var btn = $(".login_btn");
		$(btn).hover(function(){
			$(this).addClass("login_btn_hover");
		  },function(){
			$(this).removeClass("login_btn_hover");
		});
		$(btn).mousedown(function(){
			$(this).addClass("login_btn_press");
		});
		$(btn).mouseup( function (){
			$(this).removeClass("login_btn_press");
		});	
	}; 
	/*检测大写锁定*/
	function detectCapsLock(ae){
		var uO=ae.keyCode||ae.charCode,
			Uc=ae.shiftKey;			 
		if((uO>=65&&uO<=90&&!Uc)||(uO>=97&&uO<=122&&Uc))
			{
				js_alert("mode_password", "大写锁定已打开");
			}
			else if((uO>=97&&uO<=122&&!Uc)||(uO>=65&&uO<=90&&Uc))
			{
				js_alert("mode_password", "");
			}
			else
			{
				js_alert("mode_password", "");
			}
	};
	
	// JavaScript Document
	$(document).ready(function(){
		login_operate();
		btn();
		$(":password").keypress(detectCapsLock);
	}); 
	
})(jQuery);
