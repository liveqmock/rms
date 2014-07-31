<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<style type="text/css">
.fm_lab{text-align: right;padding:10px;}
.title{font-size: 12px;padding-bottom: 5px;}
.title strong{color:red;}
</style>
</head>
<body>
	<div class="title">设置<strong>${param.username}</strong>的角色</div>
    <table id="dgRole"></table>
    
    <div id="dgRole-buttons" style="text-align:right;padding-top: 20px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="setUserRole(); return false;">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWin(); return false;">取消</a>
    </div>
    
<jsp:include page="../easyui_lib.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}js/plugin/RoleSelect.js"></script>
<script type="text/javascript">
var that = this;
var username = '${param.username}';
var $dgRole = RoleSelect.create('dgRole',loadUserRole);

function loadUserRole($dgRole){
	if(username){	
		Action.jsonAsyncActByData(
			ctx + 'listUserRRole.do'
			,{usernameSch:username}
			,function(e){
				
			if(!e.errorMsg){
				var rows = e.rows;
				for(var i=0,len=rows.length;i<len;i++){
					// 勾选已有的角色
					$dgRole.datagrid('selectRecord',rows[i].roleId);
				}
			}else{
				MsgUtil.topMsg('加载用户角色出错');
			}
		});
	}
}

function setUserRole(){
	var rows = $dgRole.datagrid('getSelections');
	var roleIds = [];
	if(rows && rows.length > 0){
		for(var i=0,len=rows.length;i<len;i++){
			roleIds.push(rows[i].roleId);
		}
		
		Action.jsonAsyncActByData(
				ctx + 'setUserRole.do'
				,{username:username,roleIds:roleIds}
				,function(e){
					
				if(e.success){
					MsgUtil.topMsg('设置成功');
				}else{
					MsgUtil.topMsg('设置失败');
				}
			});
		
	}else{
		MsgUtil.topMsg('请选择角色');
	}
}

function closeWin(){
	parent.closeDlg()
}

</script>
</body>
</html>