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
</style>
</head>
<body>
     <div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="crud.add()">添加</a>
    </div>
    <table id="dg"></table>
    
    <div id="dlg" class="easyui-dialog" style="width:320px;height:180px;padding:10px 20px"
            closed="true" modal="true" buttons="#dlg-buttons">
        <form id="fm" method="post">
            <table>
                <tr>
            <td class="fm_lab">角色名:</td><td><input name="roleName" type="text" class="easyui-validatebox" required="true"></td>
        </tr>
    
            </table>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="crud.save(); return false;">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="crud.closeDlg(); return false;">取消</a>
    </div>
    
    <div id="dlgDel" class="easyui-dialog" style="width:360px;height:280px;padding:10px 20px"
            closed="true" modal="true" title="删除角色" buttons="#dlgdlgDel-buttons">
    	<span style="color:red;">删除后,以下成员将失去该角色及对应的功能.确定删除吗?</span>
    	<div id="delUsernameGrid"></div>
    </div>
    <div id="dlgdlgDel-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="doDel(); return false;">确定</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#dlgDel').dialog('close'); return false;">取消</a>
    </div>

    
    
<jsp:include page="../easyui_lib.jsp"></jsp:include>
<script type="text/javascript">
var that = this;
var $dlgDel = $('#dlgDel');
var delRow;

var crud = Crud.create({
    pk:'roleId'
    ,listUrl:ctx + 'listRRole.do'
    ,addUrl:ctx + 'addRRole.do'
    ,updateUrl:ctx + 'updateRRole.do'
    ,delUrl:ctx + 'delRRole.do'
    ,dlgId:'dlg'
    ,formId:'fm'
    ,gridId:'dg'
});

var buttons = [
	{text:'修改',onclick:function(row){
		crud.update(row);
	}}
	,{text:'删除',onclick:function(row){
		del(row);
	}}
];

crud.buildGrid([
{field:'roleName',title:'角色名'}
,crud.createOperColumn(buttons)
]);

$('#delUsernameGrid').datagrid({
	columns:[[    
    	{field:'username',title:'用户名',width:100}  
	]]
	,height:150
	,fitColumns:true
	,striped:true
})


function del(row){
	if (row){
		delRow = row;
		var userRoles = listRoleUser(row);

		if(userRoles.length > 0){
			var title = '删除[<span style="color:red;">'+row.roleName+'</span>]角色';
			$('#delUsernameGrid').datagrid('loadData',userRoles);
			$dlgDel.dialog('setTitle',title).dialog('open');
		}else{
			MsgUtil.confirm('确定删除该角色吗?',function(){
				doDel(row);
			});
		}
	}
}

function doDel(){
	if(delRow){
		Action.post(crud.delUrl,delRow,function(result){
			Action.execResult(result,function(){
				$dlgDel.dialog('close');
				crud.runGridMethod('reload');	// reload the user data
			});
		});
	}
}


function listRoleUser(row){
	var ret = [];
	
	Action.postSync(ctx + 'listRoleRelationInfo.do'
			,{roleId:row.roleId},function(result){
		if(result.success){
			ret = result.userRoles;
		}
	});
	
	return ret;
}

</script>
</body>
</html>