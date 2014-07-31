if (typeof(jQuery) != 'undefined') {
    $(document).ajaxError(function (event, request, settings) {
        if (request.getResponseHeader("X-timeout") && request.status == 401) {
            // 页面跳转
        	top.location.href = ctx;
        }else{
        	alert("系统异常");
        }
    });
}

var Gloable = $.extend(window.Gloable || {},{
	logout:function(){
		$.ajax({
			type: "POST",
		    url: ctx + 'logout.do',
		  	dataType:'json',
		    success: function(result){
				if (result.success){
					location.reload();
				} 
			},
			error:function(){
				location.reload();
			}
		});
	}
});
