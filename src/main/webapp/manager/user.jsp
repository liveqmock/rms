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
            <td class="fm_lab">密码:</td><td><input name="password" type="password" class="easyui-validatebox" required="true"></td>
        </tr>
            </table>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="crud.save(); return false;">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="crud.closeDlg(); return false;">取消</a>
    </div>
    
    <div id="addRoleDlg" class="easyui-dialog" 
    	style="width:500px;height:450px;padding:10px 20px"
    	title="设置角色"
    	closed="true" modal="true">
    	<iframe id="roleFrame" scrolling="yes" frameborder="0" style="width:100%;height:100%;"></iframe>
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
    // password输入框需要用MD5加密
    ,encryptConfig:{encryptFun:function(val){
    	return faultylabs.MD5(val);
    },fields:['password']}
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
	$('#roleFrame').attr('src','userRole.jsp?username=' + username);
	$('#addRoleDlg').dialog('open');
}

function closeDlg(){
	$('#addRoleDlg').dialog('close');
}

function resetPassword(row){
	Action.jsonAsyncActByData(ctx + 'resetUserPassword.do',row,function(e){
		if(e.success){
			MsgUtil.alert('密码重置成功,新密码为:<strong style="color:red;">' + e.msg + '</strong>');
		}
	});
}
</script>
</body>
</html>