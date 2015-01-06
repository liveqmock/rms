<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div id="menu"></div>

<script type="text/javascript">
$(function(){
	var $menu = $("#menu");
	$menu.tree({
	    url : ctx + 'listUserMenu.do',
	    onClick : function (node) {
	    	var attr = node.attributes;
	        if (attr && attr.url) {
	        	openTab(node.text, attr.url + '?srId='+attr.srId);
	        }
	    }
	    ,loadFilter:function(menus,parent){
	    	for(var i=0,len=menus.length;i<len;i++){
				formatMenu(menus[i]);
			}
	    	// 追加全局菜单
// 	    	for(var i=0,len=globleMenu.length;i<len;i++){
// 	    		menus.push(globleMenu[i]);
// 			}
	    	return menus;
	    }
	});
	
	function formatMenu(data){
		if(data){
			data.attributes = {url:data.url,srId:data.srId}
		}
		var children = data.children;
		if(children && children.length > 0){
			for(var i=0,len=children.length;i<len;i++){
				formatMenu(children[i]);
			}
		}
	}
	
	var $mainTab = $("#mainTab");
	//在右边center区域打开菜单，新增tab
	function openTab(text, url) {
	    if ($mainTab.tabs('exists', text)) {
	    	$mainTab.tabs('select', text);
	    } else {
	    	$mainTab.tabs('add', {
	            title : text,
	            closable : true,
	            border:false,
	            content : '<iframe src="'+ ctx + url+'" scrolling="yes" frameborder="0" style="width:100%;height:100%;"></iframe>'
	        });
	    }
	}

});

</script>
