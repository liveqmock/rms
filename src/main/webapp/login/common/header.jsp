<%@page import="org.durcframework.common.UserContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../taglib.jsp" %>
<span style="float: right; padding-right: 10px;">
欢迎,<%=UserContext.getInstance().getUser().getUsername()%> 
| <a href="javascript:void(0)" onclick="updatePswd(); return false;">修改密码</a>
| <a href="javascript:void(0)" onclick="Globle.logout(); return false;">安全退出</a>
</span>
<span style="padding-left: 5px; font-size: 16px;">
<!-- 		<img src="images/blocks.gif" width="20" height="20" align="absmiddle" /> -->
权限管理系统
</span>
<div id="updatePswdDlg" class="easyui-dialog" 
  	style="width:500px;height:250px;padding:10px 20px"
  	title="修改密码" buttons="#updatePswdDlgBtn"
  	data-options="onClose:Globle.removeIframe('updatePswdFrame')"
  	closed="true" modal="true">
  	
  	<div id="updatePswdFrame"></div>
  	
	<div id="updatePswdDlgBtn">
	     <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#updatePswdDlg').dialog('close'); return false;">关闭</a>
	</div>
</div>
<script type="text/javascript">
function updatePswd(){
	$('#updatePswdFrame').html('<iframe src="' + ctx + 'help/updatePassword.jsp" scrolling="yes" frameborder="0" style="width:100%;height:100%;"></iframe>');
	$('#updatePswdDlg').dialog('open');
}

</script>