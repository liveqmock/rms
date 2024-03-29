<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<style type="text/css">
.fm_lab{text-align: right;padding:10px;}
</style>
</head>
<body>
	
	<div class="easyui-panel search_panel" 
	style="padding:5px;background-color:#fafafa;margin-bottom: 10px;"
	data-options="iconCls:'icon-search'">
		<form id="schForm">
			<table>
				<tr>
					<td class="fm_lab">用户名:</td><td><input name="usernameSch" type="text" class="easyui-validatebox"></td>
					<td>
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="crud.search();">查询</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

     <div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="crud.add()">添加新用户</a>
    </div>
    <table id="dg"></table>
    
    <div id="dlg" class="easyui-dialog" style="width:420px;height:280px;padding:10px 20px"
            closed="true" modal="true" buttons="#dlg-buttons">
        <form id="fm" method="post">
            <table>
                <tr>
            <td class="fm_lab">用户名:</td><td><input name="username" type="text" class="easyui-validatebox" required="true"></td>
        </tr>
                <tr>
            <td class="fm_lab">密码:</td><td><input id="password" name="password" type="password" class="easyui-validatebox" required="true"></td>
        </tr>
            </table>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="crud.save(); return false;">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="crud.closeDlg(); return false;">取消</a>
    </div>
    
    <div id="addRoleDlg" class="easyui-dialog" 
    	style="width:500px;height:460px;padding:10px"
    	title="设置角色"
    	data-options="onClose:Globle.clearPanel()"
    	closed="true" modal="true">
    	<div id="roleFrame"></div>
    </div>
    
<jsp:include page="../easyui_lib.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}js/MD5.js"></script>
<script type="text/javascript">
var that = this;
var crud = Crud.create({
    pk:'username'
    ,listUrl:ctx + 'listRUser.do'
    ,addUrl:ctx + 'addRUser.do'
    ,updateUrl:ctx + 'updateRUser.do'
    ,delUrl:ctx + 'delRUser.do'
    ,dlgId:'dlg'
    ,formId:'fm'
    ,gridId:'dg'
    ,searchFormId:'schForm'
    ,onBeforeSave:function(crud){
    	var $input = $('#password');
    	var md5 = faultylabs.MD5($.trim($input.val()))
		$input.val(md5);
    }
});

var buttons = [
	{text:'重置密码',onclick:function(row){
		resetPassword(row);
	}}
	,{text:'设置角色',onclick:addRole}
];

crud.buildGrid([
 {field:'username',title:'用户名'}
, {field:'addTime',title:'添加时间'}
, {field:'lastLoginDate',title:'最后登陆时间'}
,crud.createOperColumn(buttons)
]);

function addRole(row){
	var username = row.username;
	$('#roleFrame').html('<iframe src="userRole.jsp?username='+username+'" scrolling="no" frameborder="0" style="width:100%;height:400px;"></iframe>');
	$('#addRoleDlg').dialog('open');
}

function closeDlg(){
	$('#addRoleDlg').dialog('close');
}

function resetPassword(row){
	
	MsgUtil.confirm("确定给"+row.username+"重置密码吗?",function(){
		Action.jsonAsyncActByData(ctx + 'resetUserPassword.do',row,function(e){
			if(e.success){
				MsgUtil.alert('密码重置成功,新密码为:<strong style="color:red;">' + e.msg + '</strong>');
			}
		});
	});
}
</script>
</body>
</html>