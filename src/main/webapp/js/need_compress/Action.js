var Action = {
	ajsxSucc:function(e,succFun){
		if(succFun){
			succFun(e);
		}
	},
	/**
	 * 异步请求
	 */
	jsonAsyncActByData:function(url,data,succFun){
		$.ajax({
			type: "POST",
			url: url,
			async:true,
			traditional:true,
			dataType: "json",
			data:data,
			success: function(e){
				Action.ajsxSucc(e,succFun);
			},
			error:function(hxr,type,error){
				Action._showError('后台出错，请查看日志');
			}
		});
	},
	/**
	 * 同步请求
	 */
	jsonSyncActByData:function(url,data,succFun){
		$.ajax({
			type: "POST",
			url: url,
			async:false,
			traditional:true,
			dataType: "json",
			data:data,
			success: function(e){
				Action.ajsxSucc(e,succFun);
			},
			error:function(hxr,type,error){
				Action._showError('后台出错，请查看日志');
			}
		});
	}
	/**
	 * 获取url后面的参数
	 */
	,getQueryString:function (key){ 
		var url=location.href; 
		url = url.toLowerCase();
		key = key.toLowerCase();
		if(url.indexOf('?')==-1)return "";	
		var urlarr = url.split("?");
		urlarr = urlarr[urlarr.length-1];
		urlarr = urlarr.split("&");	
		for(var i=0;i<urlarr.length;i++){
			var s=urlarr[i].split("=");
			if(s[0]==key){
				return s[1];
			}
		}
		return "";
	}
	,_showError:function(msg,title){
		title = title || "提示";
		var $ = parent.$ || $;
		$.messager.show({
			title: title,
			msg: msg,
			style:{
				right:'',
				top:document.body.scrollTop+document.documentElement.scrollTop,
				bottom:''
			}
		});
	}
}
