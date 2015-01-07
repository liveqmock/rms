<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统资源</title>
<style type="text/css">
.fm_lab{text-align: right;padding:10px;}
</style>
</head>
<body>
     <div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addRootMenu()">添加根节点</a>
    </div>
    <table id="dg"></table>
    
    <div id="dlg" class="easyui-dialog" style="width:480px;height:180px;padding:10px 20px"
            closed="true" modal="true" buttons="#dlg-buttons">
        <form id="fm" method="post">
        	<input id="parentId" name="parentId" type="hidden">
            <table>
                <tr>
            <td class="fm_lab">菜单名称:</td><td><input name="resName" type="text" class="easyui-validatebox" required="true"></td>
        </tr>
                <tr>
            <td class="fm_lab">url:</td><td><input name="url" type="text" class="easyui-validatebox" style="width: 300px;"></td>
        </tr>
    
            </table>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="crud.save(); return false;">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="crud.closeDlg(); return false;">取消</a>
    </div>
    
    <div id="setSysFun" class="easyui-dialog" 
    	style="width:600px;height:420px;"
    	title="设置操作点"
    	closed="true" modal="false" buttons="#setSysFun-btn">
    	<iframe id="sysFunFrame" scrolling="yes" frameborder="0" style="width:100%;height:100%;"></iframe>
    </div>
     <div id="setSysFun-btn">
        <a href="#" class="easyui-linkbutton" onclick="closeDlg(); return false;">关闭</a>
    </div>
    
<jsp:include page="../easyui_lib.jsp"></jsp:include>
<script type="text/javascript">
var that = this;
var $sysFunDlg = $('#setSysFun');
var $sysFunFrame = $('#sysFunFrame');
var crud = Crud.create({
    pk:'srId'
    ,listUrl:ctx + 'listRSysRes.do'
    ,addUrl:ctx + 'addRSysRes.do'
    ,updateUrl:ctx + 'updateRSysRes.do'
    ,delUrl:ctx + 'delRSysRes.do'
    ,dlgId:'dlg'
    ,formId:'fm'
    ,gridId:'dg'
});

var appendOptions = {
	idField:'srId'
	,treeField:'resName'
}
var buttons = [
	{text:'修改',onclick:function(row){
		crud.update(row);
	}}
	,{text:'删除',onclick:function(row){
		crud.del(row);
	},showFun:function(row){
		// 如果有子节点,则不显示删除按钮
		if(row.children && row.children.length > 0){
			return false;
		}
		return true;
	}}
	,{text:'添加子节点',onclick:function(row){
		$('#parentId').val(row.srId);
		crud.add();
	}}
	,{text:'设置操作点',onclick:function(row){
		setSysFunction(row);
	}}
]
crud.buildTreegrid([
	{field:'resName',title:'资源名称',formatter:function(value,row,index){
		if (!row.parentId){
			return '<strong>' + value + '</strong>';
		}else{
			return value;
		}
	}
}
	,{field:'url',title:'url'}
	,crud.createOperColumn(buttons)
],appendOptions);

function addRootMenu(){
	$('#parentId').val(0);
	crud.add();
}

function setSysFunction(row){
	var srId = row.srId;
	var resName = row.resName;
	$sysFunFrame.attr('src','sysFunction.jsp?srId=' + srId + '&resName=' + encodeURIComponent(resName));
	$sysFunDlg.dialog('open').dialog('maximize');
}

function closeDlg(){
	$sysFunDlg.dialog('close');
}
</script>
</body>
</html>