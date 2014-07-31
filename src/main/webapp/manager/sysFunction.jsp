<%@page import="org.durcframework.rms.entity.RSysOperate"%>
<%@page import="java.util.List"%>
<%@page import="org.durcframework.common.SpringContext"%>
<%@page import="org.durcframework.rms.service.RSysOperateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设置操作点</title>
<style type="text/css">
.fm_lab{text-align: right;padding:10px;}
.title{font-size: 12px;padding-bottom: 5px;}
.title_red{color:red;}
</style>
<%
RSysOperateService service = SpringContext.getBean(RSysOperateService.class);
List<RSysOperate> allSysOperates = service.listAllSysOperate();
request.setAttribute("allSysOperates", allSysOperates);
%>
</head>
<body>
	<div class="title">设置<strong class="title_red">${param.resName}</strong>的操作点</div>
     <div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">添加操作点</a>
    </div>
    <table id="dg"></table>
    
    <div id="dlg" class="easyui-dialog" style="width:550px;height:450px;padding:10px 20px"
            closed="true" modal="true" buttons="#dlg-buttons">
        <form id="fm" method="post">
            <table>
                <tr>
		            <td class="fm_lab">操作类型:</td>
		            <td>
		            	<select id="operateCode" name="operateCode">
		            		<c:forEach items="${allSysOperates}" var="opt">
		            			<option value="${opt.operateCode}">${opt.operateName}(${opt.operateCode})</option>
		            		</c:forEach>
		            	</select>
		            </td>
		        </tr>
                <tr>
                	<td class="fm_lab" valign="top">角色分配:</td>
                	<td style="width: 300px;">
	                	<table id="dgRole"></table>
                	</td>
        		</tr>
    
            </table>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="save(); return false;">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="crud.closeDlg(); return false;">取消</a>
    </div>
    
<jsp:include page="../easyui_lib.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}js/plugin/RoleSelect.js"></script>
<script type="text/javascript">
var that = this;
var $dgRole;
var crud = Crud.create({
    pk:'sfId'
    ,listUrl:ctx + 'listRSysFunction.do?srIdSch=${param.srId}'
    ,addUrl:ctx + 'addRSysFunction.do?srId=${param.srId}'
    ,updateUrl:ctx + 'setSysFunctionRole.do'
    ,delUrl:ctx + 'delRSysFunction.do'
    ,dlgId:'dlg'
    ,formId:'fm'
    ,gridId:'dg'
});

var buttons = [
	{text:'修改权限',onclick:updatePermission}
	,{text:'删除',onclick:delPermission}
];

crud.buildGrid([
  {field:'operateCode',title:'操作代码'}
, {field:'operateName',title:'操作名称'}
, {field:'roleNames',title:'角色分配',formatter:roleFormatter}
,crud.createOperColumn(buttons)
]);

function roleFormatter(val,row,index){
	var roles = row.roles;
	if(!roles || roles.length == 0){
		return '无分配角色';
	}
	
	var roleNameHtml = [];
	
	for(var i=0,len=roles.length; i<len; i++) {
		roleNameHtml.push(roles[i].roleName);
	}
	
	// 所有的角色名
	var roleNameStr = roleNameHtml.join(',');
	
	var resultStr = ['<div title="'+roleNameStr+'">'];
	
	if(roleNameHtml.length > 10){ // 超过10个角色就显示前10个
		for(var i=0; i<10; i++) {
			resultStr.push(roleNameHtml[i]) + ",";
		}
		resultStr.push('...');
	}else{
		resultStr.push(roleNameStr);
	}
	
	resultStr.push('</div>');
	
	return resultStr.join('');
}


function add(){
	if(!$dgRole){
		$dgRole = RoleSelect.create('dgRole');
	}
	$dgRole.datagrid('clearSelections');
	$('#operateCode').prop('disabled',false);
	crud.add('添加<strong class="title_red">${param.resName}</strong>操作点');
}

function save(){
	var rows = $dgRole.datagrid('getSelections');
	if(rows && rows.length > 0){
		crud.save();
	}else{
		MsgUtil.topMsg('请选择角色');
	}
}

function updatePermission(row){
	if (row){
		$('#operateCode').prop('disabled',true);
		crud.$dlg.dialog('open').dialog('setTitle','修改<strong class="title_red">${param.resName}</strong>操作点');
		crud.$form.form('clear').form('load',row);
		
		crud.submitUrl = crud.updateUrl + ['?',crud.pk,'=',row[crud.pk]].join('');
		
		// 如果表单中有主键控件,则不能被修改
		if(crud._hasPkInput()){
			crud.getPkInput().prop('disabled',true);
		}
		
		var roles = row.roles;
		if(!$dgRole){
			$dgRole = RoleSelect.create('dgRole',function($dgRole){
				doSelectRole(roles,$dgRole);
			});
		}else{
			doSelectRole(roles,$dgRole);
		}
		
	}
}

function doSelectRole(roles,grid){
	grid.datagrid('clearSelections');
	
	for(var i=0,len=roles.length; i<len; i++) {
		grid.datagrid('selectRecord',roles[i].roleId);
	}
}

function delPermission(row){
	crud.del(row);
}
</script>
</body>
</html>