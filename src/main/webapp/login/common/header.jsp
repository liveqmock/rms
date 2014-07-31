<%@page import="org.durcframework.common.UserContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../taglib.jsp" %>
<script type="text/javascript">
function logout(){
	$.ajax({
		type: "POST",
	    url: '${ctx}logout.do',
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

</script>
<span style="float: right; padding-right: 10px;">
欢迎,<%=UserContext.getInstance().getUser().getUsername()%> | <a href="javascript:void(0)" onclick="logout(); return false;">安全退出</a>
</span>
<span style="padding-left: 5px; font-size: 16px;">
<!-- 		<img src="images/blocks.gif" width="20" height="20" align="absmiddle" /> -->
权限管理系统
</span>
