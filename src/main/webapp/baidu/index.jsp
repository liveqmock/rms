<%@page import="org.durcframework.rms.util.RightUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百度首页</title>
<script type="text/javascript">
function updateUrl(){
	document.getElementById('iframe').src="http://www.163.com/";
}
</script>
</head>
<body>
<!-- 检查能否查看百度首页 -->
<c:choose>
	<c:when test='<%=RightUtil.check(request.getParameter("srId"), "view")%>'>
		<iframe id="iframe" src="http://www.baidu.com" width="100%" height="400"></iframe>
	</c:when>
	<c:otherwise>
		您无权限查看
	</c:otherwise>
</c:choose>

<c:if test='<%=RightUtil.check(request.getParameter("srId"), "update")%>'>
	<button onclick="updateUrl()">修改地址</button>
</c:if>
</body>
</html>