<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作管理</title>
<style type="text/css">
.fm_lab{text-align: right;padding:10px;}
</style>
</head>
<body>
     <div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="crud.add()">添加操作类型</a>
    </div>
    <table id="dg"></table>
    
    <div id="dlg" class="easyui-dialog" style="width:320px;height:280px;padding:10px 20px"
            closed="true" modal="true" buttons="#dlg-buttons">
        <form id="fm" method="post">
            <table>
                    <tr>
            <td class="fm_lab">操作代码:</td><td><input name="operateCode" type="text" class="easyui-validatebox" required="true"></td>
        </tr>
                <tr>
            <td class="fm_lab">操作名称:</td><td><input name="operateName" type="text" class="easyui-validatebox" required="true"></td>
        </tr>
            </table>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="crud.save(); return false;">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="crud.closeDlg(); return false;">取消</a>
    </div>
    
<jsp:include page="../easyui_lib.jsp"></jsp:include>
<script type="text/javascript">
var that = this;
var crud = Crud.create({
    pk:'operateCode'
    ,listUrl:ctx + 'listRSysOperate.do'
    ,addUrl:ctx + 'addRSysOperate.do'
    ,updateUrl:ctx + 'updateRSysOperate.do'
    ,delUrl:ctx + 'delRSysOperate.do'
    ,dlgId:'dlg'
    ,formId:'fm'
    ,gridId:'dg'
});

crud.buildGrid([
 {field:'operateCode',title:'操作代码'}
,{field:'operateName',title:'操作名称'}
,crud.createEditColumn()   
]);

</script>
</body>
</html>